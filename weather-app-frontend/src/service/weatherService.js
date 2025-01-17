import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/weather';

const getWeatherByCity = async (city) => {
    try {
        const response = await axios.get(`${BASE_URL}/${city}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching weather data:', error);
        throw error;
    }
};

export default getWeatherByCity;