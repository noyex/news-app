import React, { useState, useEffect } from 'react';
import '../component/style/Navbar.css';

const Navbar = () => {
    const [time, setTime] = useState(new Date());

    useEffect(() => {
        const timer = setInterval(() => {
            setTime(new Date());
        }, 1000);

        return () => clearInterval(timer);
    }, []);

    const formatTime = (date) => {
        return date.toLocaleTimeString('pl-PL', { 
            hour: '2-digit', 
            minute: '2-digit' 
        });
    };

    return (
        <div className="navbar-wrapper">
            <nav className="navbar dynamic-island">
                <div className="dynamic-content">
                    <div className="time">
                        {formatTime(time)}
                    </div>
                    <div className="nav-items">
                        <a href="/" className="nav-link active">
                            Strona główna
                        </a>
                    </div>
                </div>
            </nav>
        </div>
    );
};

export default Navbar;