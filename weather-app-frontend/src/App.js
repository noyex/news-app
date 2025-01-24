import React from 'react';
import WeatherDisplay from './component/WeatherDisplay';
import './style/App.css';

function App() {
    return (
        <div className="App">
            <WeatherDisplay city="Radom" />
        </div>
    );
}

export default App;