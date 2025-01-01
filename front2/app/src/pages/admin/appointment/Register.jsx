import React, { useState, useRef } from 'react';
import Alerts from '../../components/Alerts';

const Register = () => {   
    const [inputStat, setInputStat] = useState(false);    
    const [mensageStatus, setMensageStatus] = useState(null);
    const [name, setNome] = useState('');
    const [observation, setObservation] = useState('');
    const [timeDuration, settimeDuration] = useState('');
    const [inputs, setInputs] = useState([]); // Estado para armazenar os inputs
    const lastInputRef = useRef(null); // Ref para o último input adicionado
    const [inputCounter, setInputCounter] = useState(0);

    const handleName = (e)=>{
        setNome(e.target.value);
    };
    const handletimeDuration = (e)=>{
        settimeDuration(e.target.value);
    };
    const handleObservation = (e)=>{
        setObservation(e.target.value);
    };

    const handleEditName = ()=>{
        setInputStat(false);
    }

    // Função para adicionar novos campos de input
    const addInput = () => {
        const newInput = { value: '', id: inputs.length, isDisabled: false };
        setInputs([...inputs, newInput]); // Adiciona um novo campo de input ao estado
        setInputCounter(inputCounter+1);

        // Coloca o foco no último campo de input adicionado
        setTimeout(() => {
            if (lastInputRef.current) {
                lastInputRef.current.focus();
            }
        }, 0);
    };

    // Função para atualizar o valor de um input específico
    const handleInputChange = (index, value) => {
        const newInputs = [...inputs];
        newInputs[index].value = value;
        setInputs(newInputs);
    };

    // Função para desabilitar o input quando a tecla Enter for pressionada
    const handleKeyPress = (index, event) => {
        if (event.key === 'Enter') {
            const newInputs = [...inputs];
            newInputs[index].isDisabled = true; // Desabilita o input
            setInputs(newInputs);
        }
    };

    const enableEditing = (index) => {
        const newInputs = [...inputs];
        newInputs[index].isDisabled = false; // Habilita o input para edição
        setInputs(newInputs);
    };


    const handleMensageStatus =(typeAlert, text)=>{
        setMensageStatus(<Alerts typeAlert={typeAlert} text={text}/>);
        setTimeout(() => {
            setMensageStatus(null);  // Remove a mensagem de status
        }, 3000); 
    }
        

    const saveData = async () => {
        const data = {
            name,
            observation,
            timeDuration,
            services: inputs.map(input => input.value).filter(value => value) // Filtra valores vazios
        };
    
        // Exibe a mensagem antes de fazer a requisição
        handleMensageStatus("processing", "Enviando os dados");
    
        // Aguarda a próxima renderização para garantir que a mensagem apareça
        setTimeout(async () => {
            try {
                const response = await fetch('http://localhost:8081/appointment', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(data),
                });
                const result = await response.json();
                switch (response.status) {
                    case 200:
                    case 201:
                        handleMensageStatus("success", "Dados Salvos com sucesso");
                        setInputStat(true);
                        break;
                    case 400:
                        handleMensageStatus("danger",  result.message);
                        break;
                    case 401:
                        handleMensageStatus("danger",  result.message);
                        break;
                    case 404:
                        handleMensageStatus("danger",  result.message);
                        break;
                    case 500:
                        handleMensageStatus("danger",  result.message);
                        break;
                    default:
                        handleMensageStatus("danger", "Erro desconhecido");
                        break;
                }
                                          
            } catch (error) {
                console.error('Erro:', error);
            }
        }, 0); // Usa um timeout com 0 ms para garantir que a renderização ocorra primeiro
    };
    

    {/**<Alerts alert={"processing"} text={"Enviando os dados"}/> */}

    return (
        <div>
            <div style={{display: "flex"}}>
                <div style={{ background: "rgb(255, 255, 255)"}}>
                    <div style={{background: "rgb(255, 255, 255)", width: "50rem", marginTop: "1rem", display: "flex", gap: "4rem", justifyContent: "center", paddingTop: "2rem", boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)" }}>
                        <div>
                            <div style={{display: "flex"}}>
                                <div className="mb-3">
                                    <label htmlFor="exampleFormControlInput1" className="form-label">Nome</label>
                                    <input disabled={inputStat} onChange={handleName} style={{ width: "15rem" }} type="email" className="form-control" id="exampleFormControlInput1" placeholder="clinico geral" />
                                </div>
                                <button onClick={handleEditName}  style={{ border: "none" }} type="button" className="btn">
                                    <img src="../src/icons/escrever.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                                </button>
                            </div>
                            
                            <div  style={{display: "flex"}}>
                                <div className="mb-3">
                                    <label htmlFor="exampleFormControlTextarea1" className="form-label">Observação</label>
                                    <textarea disabled={inputStat} onChange={handleObservation} style={{ width: "15rem" }} className="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>  
                                <button onClick={handleEditName}  style={{ border: "none" }} type="button" className="btn">
                                    <img src="../src/icons/escrever.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                                </button>
                            </div>

                            <div >
                                <button onClick={saveData}  style={{ border: "none" }} type="button" className="btn">
                                    <img src="../src/icons/marca.png" style={{ objectFit: "cover", width: "2rem", height: "2rem" }} />
                                </button>
                                <button  style={{ border: "none" }} type="button" className="btn">
                                    <img src="../src/icons/excluir.png" style={{ objectFit: "cover", width: "1.90rem", height: "1.90rem" }} />
                                </button>
                            </div>
                        </div>

                        <div>
                            <div  style={{display: "flex"}}>
                                <div className="mb-3">
                                    <label htmlFor="exampleFormControlInput1" className="form-label">Duração Consultas em Minutos</label>
                                    <input disabled={inputStat} onChange={handletimeDuration} style={{ width: "15rem" }} type="time" className="form-control" id="exampleFormControlInput1" placeholder="clinico geral" />
                                </div>
                                <button onClick={handleEditName}  style={{ border: "none" }} type="button" className="btn">
                                    <img src="../src/icons/escrever.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                                </button>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="exampleFormControlInput1" className="form-label">Serviços Oferecidos</label>
                                <div style={{ background: "rgb(117, 228, 150)", width: "2.50rem", borderRadius: "1rem", display: "flex", justifyContent: "center", alignItems: "center" }}>
                                    <button onClick={addInput} id='more' style={{ border: "none" }} type="button" className="btn">
                                        <img src="../src/icons/add.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                                    </button>
                                </div>
                            
                                <div id='services' style={{ height: "6.40rem", overflowY: "auto", overflowX: "hidden", width: "24rem", display: "block" }}>
                                    {inputs.map((input, index) => (
                                        <div style={{ display: "flex", marginTop: ".70rem" }} key={input.id}>
                                            <div>
                                                <input
                                                    id="inputAdd"
                                                    style={{ width: "20rem" }}
                                                    type="text"
                                                    className="form-control"
                                                    value={input.value}
                                                    onChange={(e) => handleInputChange(index, e.target.value)}
                                                    onKeyPress={(e) => handleKeyPress(index, e)} // Chama a função para desabilitar no Enter
                                                    disabled={input.isDisabled} // Verifica se o input deve ser desabilitado
                                                    ref={index === inputs.length - 1 ? lastInputRef : null} // Atribui o foco ao último input
                                                />
                                            </div>
                                            <div>
                                                <button onClick={() => enableEditing(index)} style={{ border: "none" }} type="button" className="btn">
                                                    <img src="../src/icons/escrever.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                                                </button>
                                            </div>
                                        </div>
                                    ))}
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div style={{marginTop:"2rem", paddingBottom: "2rem"}}>
                        <div style={{display: "flex", justifyContent: "center", boxShadow: "0 4px 0px rgba(150, 147, 147, 0.2)" }}>
                            <blockquote className="blockquote" style={{ margin: 0 }}>
                                <p className="mb-0" style={{ margin: 0}}>Funcionários</p>
                            </blockquote>
                        </div>

                        <div id='clercksList' style={{ display: "flex", justifyContent:"center", height: "15rem", marginTop:"1rem", overflowY: "auto"}}>                       
                            <div>
                                <table class="table" style={{width: "48rem", boxShadow: "0 -4px 8px rgba(0, 0, 0, 0.2)"}}>
                                    <thead>
                                        <tr>
                                            <th  style={{background: "rgb(137, 200, 211)", position: "sticky", top: 0, backgroundColor: "#fff", zIndex: 1 }} scope="col">Id</th>
                                            <th  style={{background: "rgb(137, 200, 211)", position: "sticky", top: 0, backgroundColor: "#fff", zIndex: 1 }} scope="col">Nome</th>
                                            <th  style={{background: "rgb(137, 200, 211)", position: "sticky", top: 0, backgroundColor: "#fff", zIndex: 1 }} scope="col">Departamento</th>
                                            <th  style={{background: "rgb(137, 200, 211)", position: "sticky", top: 0, backgroundColor: "#fff", zIndex: 1 }} scope="col">Cpf</th>                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim ferreira da silva</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim ferreira da silva</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim ferreira da silva</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim ferreira da silva</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim ferreira da silva</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>

                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>

                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>

                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>

                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>

                                        <tr>
                                            <th scope="row">1</th>
                                            <td>Biantra Amorim</td>
                                            <td>Pediatria</td>
                                            <td>098.045.004-22</td>                               
                                        </tr>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                                
                </div>

                <div id='alertDiv' style={{width: "13rem", height:"10rem", marginTop:"32rem", display: "flex", justifyContent:"flex-end", position:"absolute", left: "83%"}} >
                                                    
                    {mensageStatus}
                </div>

            </div>


        </div>
    );
};

export default Register;
