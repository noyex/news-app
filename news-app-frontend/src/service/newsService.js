import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/news';

const getNews = async (query = 'technology', sortBy = 'publishedAt', page = 1, targetLanguage = 'pl') => {
    try {
        console.log('Fetching news with params:', { query, sortBy, page, targetLanguage });
        
        const response = await axios.get(BASE_URL, {
            params: {
                q: query,
                sortBy: sortBy,
                page: page,
                targetLanguage: targetLanguage
            },
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

        return response.data;
    } catch (error) {
        console.error('Error fetching news:', error);
        throw error;
    }
};

export default getNews;