export const getTemperatureColor = (temp) => {
    // Zakres temperatur od -20°C do 40°C
    if (temp <= -20) return '#000080'; // Granatowy
    if (temp >= 40) return '#FF0000';  // Czerwony

    if (temp < 0) {
        // Od granatowego (-20°C) do jasnoniebieskiego (0°C)
        const intensity = (temp + 20) / 20;
        return `rgb(${Math.round(intensity * 135)}, ${Math.round(intensity * 206)}, 235)`;
    } else if (temp <= 20) {
        // Od jasnoniebieskiego (0°C) do żółtego (20°C)
        const intensity = temp / 20;
        return `rgb(${Math.round(135 + intensity * 120)}, ${Math.round(206 + intensity * 49)}, ${Math.round(235 - intensity * 235)})`;
    } else {
        // Od żółtego (20°C) do czerwonego (40°C)
        const intensity = (temp - 20) / 20;
        return `rgb(255, ${Math.round(255 - intensity * 255)}, 0)`;
    }
};

export const getWindColor = (speed) => {
    // Skala Beauforta: 0-3 (słaby), 4-7 (umiarkowany), 8+ (silny)
    if (speed <= 3) return '#4CAF50';      // Zielony
    if (speed <= 7) return '#FFC107';      // Żółty
    return '#F44336';                      // Czerwony
};

export const getPressureColor = (pressure) => {
    // Normalne ciśnienie: 1013.25 hPa
    // Zakres: 960-1060 hPa
    if (pressure < 1000) return '#F44336'; // Czerwony - niskie
    if (pressure > 1025) return '#F44336'; // Czerwony - wysokie
    if (pressure >= 1010 && pressure <= 1015) return '#4CAF50'; // Zielony - optymalne
    return '#FFC107';                      // Żółty - graniczne
};

export const getHumidityColor = (humidity) => {
    // Optymalny zakres: 30-60%
    if (humidity < 30) return '#F44336';   // Czerwony - za sucho
    if (humidity > 60) return '#F44336';   // Czerwony - za wilgotno
    if (humidity >= 40 && humidity <= 50) return '#4CAF50'; // Zielony - optymalne
    return '#FFC107';                      // Żółty - graniczne
};