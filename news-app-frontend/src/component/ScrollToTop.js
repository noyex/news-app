// import React, { useState, useEffect } from 'react';

// const ScrollToTop = () => {
//     const [isVisible, setIsVisible] = useState(false);

//     useEffect(() => {
//         const toggleVisibility = () => {
//             if (window.pageYOffset > 300) {
//                 setIsVisible(true);
//             } else {
//                 setIsVisible(false);
//             }
//         };

//         window.addEventListener('scroll', toggleVisibility);
//         return () => window.removeEventListener('scroll', toggleVisibility);
//     }, []);

//     const scrollToTop = () => {
//         window.scrollTo({
//             top: 0,
//             behavior: 'smooth'
//         });
//     };

//     return (
//         <>
//             {isVisible && (
//                 <div 
//                     onClick={scrollToTop}
//                     style={{
//                         position: 'fixed',
//                         bottom: '20px',
//                         right: '20px',
//                         cursor: 'pointer',
//                         backgroundColor: '#000000',
//                         borderRadius: '50%',
//                         width: '40px',
//                         height: '40px',
//                         display: 'flex',
//                         justifyContent: 'center',
//                         alignItems: 'center',
//                         color: 'white',
//                         fontSize: '20px',
//                         boxShadow: '0 2px 10px rgba(0,0,0,0.2)',
//                         transition: 'all 0.3s ease',
//                         zIndex: 1000,
//                     }}
//                     onMouseEnter={(e) => e.target.style.transform = 'scale(1.1)'}
//                     onMouseLeave={(e) => e.target.style.transform = 'scale(1)'}
//                 >
//                     ↑
//                 </div>
//             )}
//         </>
//     );
// };

// export default ScrollToTop;