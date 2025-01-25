import React, { useEffect, useState } from 'react';
import getNews from '../service/newsService';
import './style/NewsFeed.css';

const NewsFeed = () => {
    const [news, setNews] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [selectedTopic, setSelectedTopic] = useState('technology');
    const [selectedSort, setSelectedSort] = useState('publishedAt');
    const [currentPage, setCurrentPage] = useState(1);
    const [totalPages] = useState(3);

    const topics = [
        { value: 'technology', label: 'Technologia' },
        { value: 'business', label: 'Biznes' },
        { value: 'science', label: 'Nauka' },
        { value: 'health', label: 'Zdrowie' },
        { value: 'sports', label: 'Sport' },
        { value: 'entertainment', label: 'Rozrywka' }
    ];

    const sortOptions = [
        { value: 'publishedAt', label: 'Najnowsze' },
        { value: 'relevancy', label: 'Trafność' },
        { value: 'popularity', label: 'Popularność' }
    ];

    useEffect(() => {
        fetchNews();
    }, [selectedTopic, selectedSort, currentPage]);

    const fetchNews = async () => {
        setLoading(true);
        setError(null);
        
        try {
            const data = await getNews(selectedTopic, selectedSort, currentPage);
            
            if (!data || !data.articles) {
                throw new Error('Nieprawidłowy format danych');
            }
            
            setNews(data.articles);
        } catch (err) {
            console.error('Error in fetchNews:', err);
            setError(err.message || 'Wystąpił błąd podczas pobierania wiadomości');
            setNews([]);
        } finally {
            setLoading(false);
        }
    };

    const handleTopicChange = (e) => {
        setSelectedTopic(e.target.value);
        setCurrentPage(1);
    };

    const handleSortChange = (e) => {
        setSelectedSort(e.target.value);
        setCurrentPage(1); 
    };

    const handlePageChange = (newPage) => {
        setCurrentPage(newPage);
        window.scrollTo({ top: 0, behavior: 'smooth' });
    };

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return date.toLocaleString('pl-PL', {
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: '2-digit',
            minute: '2-digit'
        });
    };

    return (
        <div className="news-feed">
            <div className="news-controls">
                <div className="filters">
                    <div className="filter-group">
                        <label htmlFor="topic">Kategoria:</label>
                        <select 
                            id="topic" 
                            value={selectedTopic}
                            onChange={handleTopicChange}
                            className="filter-select"
                        >
                            {topics.map(topic => (
                                <option key={topic.value} value={topic.value}>
                                    {topic.label}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="filter-group">
                        <label htmlFor="sort">Sortowanie:</label>
                        <select 
                            id="sort" 
                            value={selectedSort}
                            onChange={handleSortChange}
                            className="filter-select"
                        >
                            {sortOptions.map(option => (
                                <option key={option.value} value={option.value}>
                                    {option.label}
                                </option>
                            ))}
                        </select>
                    </div>
                    <button 
                        className="refresh-button"
                        onClick={fetchNews}
                        disabled={loading}
                    >
                        {loading ? 'Odświeżanie...' : 'Odśwież'}
                    </button>
                </div>
            </div>

            {loading && (
                <div className="news-loading">
                    <div className="loading-spinner-container">
                        <div className="loading-spinner"></div>
                        <div className="loading-spinner-inner"></div>
                        <div className="loading-spinner-core"></div>
                    </div>
                    <div className="loading-text">
                        Ładowanie wiadomości
                        <span className="loading-dots">
                            <span>.</span>
                            <span>.</span>
                            <span>.</span>
                        </span>
                    </div>
                </div>
            )}

            {error && (
                <div className="news-error">
                    <p>Wystąpił błąd: {error}</p>
                    <button 
                        className="retry-button"
                        onClick={fetchNews}
                    >
                        Spróbuj ponownie
                    </button>
                </div>
            )}

            {!loading && !error && news.length === 0 && (
                <div className="news-empty">
                    <p>Brak wiadomości do wyświetlenia</p>
                </div>
            )}

            {!loading && !error && news.length > 0 && (
                <>
                    <div className="news-grid">
                        {news.map((article, index) => (
                            <article key={index} className="news-card">
                                {article.urlToImage && (
                                    <div className="news-image-container">
                                        <img 
                                            src={article.urlToImage} 
                                            alt={article.title}
                                            className="news-image"
                                            onError={(e) => {
                                                e.target.onerror = null;
                                                e.target.src = '/placeholder-news.jpg';
                                            }}
                                        />
                                    </div>
                                )}
                                <div className="news-content">
                                    <h3 className="news-title">{article.title}</h3>
                                    <p className="news-description">{article.description}</p>
                                    <div className="news-footer">
                                        <span className="news-source">{article.source.name}</span>
                                        <span className="news-date">
                                            {formatDate(article.publishedAt)}
                                        </span>
                                    </div>
                                    <a 
                                        href={article.url} 
                                        target="_blank" 
                                        rel="noopener noreferrer" 
                                        className="read-more"
                                    >
                                        Czytaj więcej
                                    </a>
                                </div>
                            </article>
                        ))}
                    </div>

                    <div className="pagination">
                        <button 
                            className="pagination-button"
                            onClick={() => handlePageChange(currentPage - 1)}
                            disabled={currentPage === 1}
                        >
                            &lt; Poprzednia
                        </button>
                        
                        <div className="pagination-numbers">
                            {[...Array(totalPages)].map((_, index) => (
                                <button
                                    key={index + 1}
                                    className={`pagination-number ${currentPage === index + 1 ? 'active' : ''}`}
                                    onClick={() => handlePageChange(index + 1)}
                                >
                                    {index + 1}
                                </button>
                            ))}
                        </div>

                        <button 
                            className="pagination-button"
                            onClick={() => handlePageChange(currentPage + 1)}
                            disabled={currentPage === totalPages}
                        >
                            Następna &gt;
                        </button>
                    </div>
                </>
            )}
        </div>
    );
};

export default NewsFeed;