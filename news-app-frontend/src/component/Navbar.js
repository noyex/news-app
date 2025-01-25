import React, { useState, useEffect } from 'react';
import './style/Navbar.css';

const Navbar = () => {
    const [currentTime, setCurrentTime] = useState(new Date());
    const [isScrolled, setIsScrolled] = useState(false);

    useEffect(() => {
        const timer = setInterval(() => {
            setCurrentTime(new Date());
        }, 1000);

        return () => clearInterval(timer);
    }, []);

    useEffect(() => {
        const handleScroll = () => {
            if (window.scrollY > 20) {
                setIsScrolled(true);
            } else {
                setIsScrolled(false);
            }
        };

        window.addEventListener('scroll', handleScroll);
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);

    const formatTime = (date) => {
        return date.toLocaleTimeString('pl-PL', {
            hour: '2-digit',
            minute: '2-digit'
        });
    };

    return (
        <div className={`navbar-wrapper ${isScrolled ? 'scrolled' : ''}`}>
            <nav className="navbar dynamic-island">
                <div className="dynamic-content">
                    <div className="time">
                        {formatTime(currentTime)}
                    </div>
                    <div className="nav-items">
                        <a href="/" className="nav-link">Pogoda</a>
                        <a href="/news" className="nav-link">Wiadomości</a>
                    </div>
                </div>
            </nav>
        </div>
    );
};

export default Navbar;