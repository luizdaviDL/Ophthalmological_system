
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import '@popperjs/core';
import ShearchMenuAdm from './admin/shearchMenuAdm';
import { Outlet } from 'react-router-dom'
import Register from './admin/appointment/Register';
import { useState } from 'react';
import { Link } from 'react-router-dom';

function TemplatApp({typeUSer}) {
            
    let menuOptional;
    
    switch(typeUSer){
        case 'admin':           
            menuOptional = <ShearchMenuAdm/>;
    };


    

    return (
        <div className="container-fluid" style={{ boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)" }}>
            <nav className="navbar bg-body-tertiary">
                <div className="d-flex justify-content-between w-100" style={{ background: "#558C98" }}>
                    <div className="container">
                        <Link to={"/"} className="navbar-brand">
                            <img src="../src/icons/logom.png" alt="Bootstrap" width="45" height="40" />
                        </Link>
                    </div>

                    <div className="dropdown-center" style={{ marginRight: "1rem" }}>
                        <button className="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Opção
                        </button>
                        <ul className="dropdown-menu">
                            <li><a className="dropdown-item" href="#">Action</a></li>
                            <li><a className="dropdown-item" href="#">Action two</a></li>
                            <li><a className="dropdown-item" href="#">Action three</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            {/* Usando d-flex para o layout principal */}
            <div className="d-flex" style={{ height: "calc(100vh - 56px)" }}> {/* Ajuste a altura conforme necessário */}
                <div id="offcanvs" className="bg-white" style={{ width: "13rem", height: "100%", overflowY: "auto" }}>
                    <div className="header text-center">
                        <p>Busca de menu</p>
                    </div>
                    {menuOptional}
                </div>

                {/* Usando flex-grow-1 para que este div ocupe o espaço restante */}
                <div id="bysideBody" className="bg-light flex-grow-1" style={{ overflowY: "auto" }}>
                    <Outlet />
                </div>
            </div>
        </div>
    );
}

export default TemplatApp;