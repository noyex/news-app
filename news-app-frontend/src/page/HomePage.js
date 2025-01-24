import React, { useState } from 'react';
import getWeatherByCity from '../service/weatherService';
import logo from '../logo.svg';
import '../style/HomePage.css';

const HomePage = () => {
    const [city, setCity] = useState('');
    const [weather, setWeather] = useState(null);
    const [error, setError] = useState(null);

    const fetchWeather = async () => {
        try {
            const data = await getWeatherByCity(city);
            setWeather(data);
            setError(null);
        } catch (err) {
            setError(`Error fetching weather data: ${err.message}`);
            setWeather(null);
        }
    };

    const handleKeyPress = (event) => {
        if (event.key === 'Enter') {
            fetchWeather();
        }
    };

    return (
        <div>
            <h1>Weather Forecast</h1>
            <img src={logo} alt="Logo" style={{ width: '100px', height: '100px' }} />
            <input 
                type="text" 
                value={city} 
                onChange={(e) => setCity(e.target.value)} 
                onKeyPress={handleKeyPress}
                placeholder="Enter city name" 
            />
            <button onClick={fetchWeather}>Get Weather</button>
            {error && <p>{error}</p>}
            {weather && (
                <div>
                    <h2>Weather in {weather.name}</h2>
                    <p>Temperature: {weather.main.temp}°C</p>
                    <p>Feels Like: {weather.main.feels_like}°C</p>
                    <p>Min Temperature: {weather.main.temp_min}°C</p>
                    <p>Max Temperature: {weather.main.temp_max}°C</p>
                    <p>Pressure: {weather.main.pressure} hPa</p>
                    <p>Humidity: {weather.main.humidity}%</p>
                    <p>Wind Speed: {weather.wind.speed} m/s</p>
                    <p>Cloudiness: {weather.clouds.all}%</p>
                </div>
            )}
        </div>
    );
};

export default HomePage;