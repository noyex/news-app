import React from 'react';
import '../component/style/WeatherDetails.css';
import { 
    getTemperatureColor, 
    getWindColor, 
    getPressureColor, 
    getHumidityColor 
} from '../utils/WeatherColors.js';

const WeatherDetails = ({ weatherData }) => {
    const details = [
        {
            label: "Temperatura",
            value: `${weatherData.main.temp}°C`,
            icon: "🌡️",
            color: getTemperatureColor(weatherData.main.temp)
        },
        {
            label: "Odczuwalna",
            value: `${weatherData.main.feels_like}°C`,
            icon: "🤔",
            color: getTemperatureColor(weatherData.main.feels_like)
        },
        {
            label: "Minimalna",
            value: `${weatherData.main.temp_min}°C`,
            icon: "⬇️",
            color: getTemperatureColor(weatherData.main.temp_min)
        },
        {
            label: "Maksymalna",
            value: `${weatherData.main.temp_max}°C`,
            icon: "⬆️",
            color: getTemperatureColor(weatherData.main.temp_max)
        },
        {
            label: "Ciśnienie",
            value: `${weatherData.main.pressure} hPa`,
            icon: "⭕",
            color: getPressureColor(weatherData.main.pressure)
        },
        {
            label: "Wilgotność",
            value: `${weatherData.main.humidity}%`,
            icon: "💧",
            color: getHumidityColor(weatherData.main.humidity)
        },
        {
            label: "Wiatr",
            value: `${weatherData.wind.speed} m/s`,
            icon: "💨",
            color: getWindColor(weatherData.wind.speed)
        },
        {
            label: "Zachmurzenie",
            value: `${weatherData.clouds.all}%`,
            icon: "☁️",
            color: getHumidityColor(weatherData.clouds.all)
        }
    ];

    return (
        <div className="weather-details-grid">
            {details.map((detail, index) => (
                <div 
                    key={index} 
                    className="weather-detail-item"
                    style={{
                        background: `linear-gradient(135deg, white, ${detail.color}20)`,
                        borderLeft: `4px solid ${detail.color}`
                    }}
                >
                    <div className="detail-icon">{detail.icon}</div>
                    <div className="detail-label">{detail.label}</div>
                    <div 
                        className="detail-value"
                        style={{ color: detail.color }}
                    >
                        {detail.value}
                    </div>
                </div>
            ))}
        </div>
    );
};

export default WeatherDetails;