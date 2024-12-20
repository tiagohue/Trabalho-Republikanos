import React from "react";

function Navbar(){
    return (
        <nav style ={{ background : '#333', padding: '10px', color: '#fff'}}>
            <h1>Republikanos</h1>
            <ul style={{ listStyle: 'none', display: 'flex', gap: "15px"}}>
            <li><a href="/" style={{ color: '#fff', textDecoration: 'none' }}>Home</a></li>
                <li><a href="/sobre" style={{ color: '#fff', textDecoration: 'none' }}>Sobre</a></li>
            </ul>
        </nav>
    );
}