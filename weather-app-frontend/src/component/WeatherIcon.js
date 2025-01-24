import React from 'react';
import '../component/style/WeatherIcon.css';

const WeatherIcon = ({ weather }) => {
    const getIconClass = (weather) => {
        switch (weather) {
            case 'Clear':
                return 'clear';
            case 'Clouds':
                return 'clouds';
            case 'Rain':
                return 'rain';
            case 'Snow':
                return 'snow';
            default:
                return 'default';
        }
    };

    return <div className={`weather-icon ${getIconClass(weather)}`}></div>;
};

export default WeatherIcon;