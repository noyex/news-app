import React from 'react';
import '../component/style/WeatherDetails.css';

const WeatherDetails = ({ weatherData }) => {
    return (
        <div className="weather-details">
            <p>Temperatura: {weatherData.main.temp}°C</p>
            <p>Odczuwalna: {weatherData.main.feels_like}°C</p>
            <p>Minimalna: {weatherData.main.temp_min}°C</p>
            <p>Maksymalna: {weatherData.main.temp_max}°C</p>
            <p>Ciśnienie: {weatherData.main.pressure} hPa</p>
            <p>Wilgotność: {weatherData.main.humidity}%</p>
            <p>Wiatr: {weatherData.wind.speed} m/s</p>
            <p>Zachmurzenie: {weatherData.clouds.all}%</p>
            <p>Widoczność: {weatherData.visibility} m</p>
        </div>
    );
};

export default WeatherDetails;