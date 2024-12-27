import { Link } from "react-router-dom"

const ShearchMenuAdm = () => {
   
    return (
        <div>
            <div className="optionals">
                <div style={{height: ".09rem", width: "10rem", background:"rgb(194, 194, 194)"}}></div>
                <div class="dropdown">
                    <a class="btn  dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Consulta
                    </a>
                    <ul class="dropdown-menu">
                        <Link style={{textDecoration: "none"}} to={"/register"}><li><a class="dropdown-item" href="#" >Cadastrar</a></li>     </Link>                                       
                    </ul>
                </div>
                <div style={{height: ".09rem", width: "10rem", background:"rgb(194, 194, 194)"}}></div>
                <div class="dropdown">
                    <a class="btn  dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Funcionários
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Cadastrar</a></li>
                        <li><a class="dropdown-item" href="#">Dados completos</a></li>
                        <li><a class="dropdown-item" href="#">Documentos</a></li>
                    </ul>
                </div>

                <div style={{height: ".09rem", width: "10rem", background:"rgb(194, 194, 194)"}}></div>
                <div class="dropdown">
                    <a class="btn  dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Departamento
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Cadastrar</a></li>
                        <li><a class="dropdown-item" href="#">Dados completos</a></li>
                        <li><a class="dropdown-item" href="#">Documentos</a></li>
                    </ul>
                </div>
            </div>
        
        </div>
    )
}

export default ShearchMenuAdm
