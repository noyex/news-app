import React, { useState, useEffect, useRef } from 'react';

const CustomSelect = ({ options, value, onChange, placeholder }) => {
    const [isOpen, setIsOpen] = useState(false);
    const selectRef = useRef(null);

    // Dodaj funkcję, która znajduje label dla wybranej wartości
    const getSelectedLabel = () => {
        const selectedOption = options.find(option => option.value === value);
        return selectedOption ? selectedOption.label : placeholder;
    };

    useEffect(() => {
        const handleClickOutside = (event) => {
            if (selectRef.current && !selectRef.current.contains(event.target)) {
                setIsOpen(false);
            }
        };

        document.addEventListener('mousedown', handleClickOutside);
        return () => document.removeEventListener('mousedown', handleClickOutside);
    }, []);

    return (
        <div className="custom-select-container" ref={selectRef}>
            <div 
                className="custom-select"
                onClick={() => setIsOpen(!isOpen)}
            >
                <div className={`select-header ${isOpen ? 'open' : ''}`}>
                    <span>{getSelectedLabel()}</span> {/* Zmienione z value na getSelectedLabel() */}
                    <svg 
                        width="12" 
                        height="8" 
                        viewBox="0 0 12 8" 
                        fill="none" 
                        xmlns="http://www.w3.org/2000/svg"
                    >
                        <path 
                            d="M1 1L6 6L11 1" 
                            stroke="white" 
                            strokeWidth="2" 
                            strokeLinecap="round"
                        />
                    </svg>
                </div>
            </div>
            <div className={`options-container ${isOpen ? 'open' : ''}`}>
                {options.map((option) => (
                    <div
                        key={option.value}
                        className={`option ${value === option.value ? 'selected' : ''}`}
                        onClick={() => {
                            onChange(option.value);
                            setIsOpen(false);
                        }}
                    >
                        {option.label}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default CustomSelect;