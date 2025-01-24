import React, { useEffect, useState } from 'react';
import getWeatherByCity from '../service/weatherService';
import WeatherIcon from '../component/WeatherIcon';
import WeatherDetails from '../component/WeatherDetails';
import '../component/style/WeatherDisplay.css';

const WeatherDisplay = ({ city }) => {
    const [weatherData, setWeatherData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchWeather = async () => {
            try {
                const data = await getWeatherByCity(city);
                setWeatherData(data);
                setLoading(false);
            } catch (err) {
                setError(err);
                setLoading(false);
            }
        };

        fetchWeather();
    }, [city]);

    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    return (
        <div className="weather-display">
            <h1>{weatherData.name}</h1>
            <WeatherIcon weather={weatherData.weather[0].main} />
            <WeatherDetails weatherData={weatherData} />
        </div>
    );
};

export default WeatherDisplay;