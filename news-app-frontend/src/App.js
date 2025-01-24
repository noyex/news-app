import React, { useState } from 'react';
import WeatherDisplay from './component/WeatherDisplay';
import Navbar from './component/Navbar';
import './style/App.css';

function App() {
    const [city, setCity] = useState('Warszawa'); // domyślne miasto
    const [searchedCity, setSearchedCity] = useState('Warszawa');

    const handleSubmit = (e) => {
        e.preventDefault();
        setSearchedCity(city);
    };

    return (
        <div className="app-container">
            <Navbar />
            <div className="main-content">
                <div className="news-section">
                    {/* Tutaj będą wiadomości */}
                    <div className="news-placeholder">
                        Miejsce na przyszłe wiadomości
                    </div>
                </div>
                <div className="sidebar">
                    <div className="weather-section">
                        <div className="search-container">
                            <form onSubmit={handleSubmit}>
                                <input
                                    type="text"
                                    value={city}
                                    onChange={(e) => setCity(e.target.value)}
                                    placeholder="Wpisz nazwę miasta"
                                    className="city-input"
                                />
                                <button type="submit" className="search-button">
                                    Szukaj
                                </button>
                            </form>
                        </div>
                        {searchedCity && <WeatherDisplay city={searchedCity} />}
                    </div>
                    <div className="stock-section">
                        {/* Tutaj będzie giełda */}
                        <div className="stock-placeholder">
                            Miejsce na widget giełdowy
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;