
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import '@popperjs/core';
import ShearchMenuAdm from './admin/shearchMenuAdm';
import BodyAppointmentsAdm from './admin/BodyAppointmentsAdm';

function TemplatApp({typeUSer}) {
    let childrenBody;
    
    switch(typeUSer){
        case 'admin':
            childrenBody = <BodyAppointmentsAdm/>;
    };

    return (
        <div className="container" style={{height: "49rem"}}>
            <nav className="navbar bg-body-tertiary" >                
                <div style={{display:"flex", background:" #558C98"}} className="d-flex justify-content-between w-100">
                    <div className="container" >
                        <a className="navbar-brand" href="#">
                            <img src="../src/icons/logom.png" alt="Bootstrap" width="45" height="40rem" />
                        </a>
                    </div>
                    
                    <div className="dropdown-center" style={{marginRight:"1rem"}}>
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

            <div style={{display: "flex"}}>
                <div id="offcanvs" style={{width: "13rem", background:"rgb(255, 255, 255)", height: "46rem"}}>
                    <div className="header" style={{ width:"10rem"}}>
                        <p style={{textAlign: "center"}}>Busca de menu</p>
                    </div>              
                    <ShearchMenuAdm/>                
                </div>

                <div id="bysideBody" style={{background:"rgb(247, 247, 247)", width:"150vh"}}>                    
                    {childrenBody}                                    
                </div>
                
            </div>
            
            
        </div>
    );
}

export default TemplatApp;