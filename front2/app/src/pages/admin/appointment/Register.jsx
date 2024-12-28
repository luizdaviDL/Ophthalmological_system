import React, { useState, useRef } from 'react';

const Register = () => {
    const [inputs, setInputs] = useState([]); // Estado para armazenar os inputs
    const lastInputRef = useRef(null); // Ref para o último input adicionado

    // Função para adicionar novos campos de input
    const addInput = () => {
        const newInput = { value: '', id: inputs.length, isDisabled: false };
        setInputs([...inputs, newInput]); // Adiciona um novo campo de input ao estado

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

    return (
        <div>
            <div style={{ background: "rgb(255, 255, 255)", width: "50rem", marginLeft: "6rem", marginTop: "5rem", display: "flex", gap: "6rem", justifyContent: "center", paddingTop: "2rem", boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)" }}>
                <div>
                    <div className="mb-3">
                        <label htmlFor="exampleFormControlInput1" className="form-label">Nome</label>
                        <input style={{ width: "15rem" }} type="email" className="form-control" id="exampleFormControlInput1" placeholder="clinico geral" />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="exampleFormControlTextarea1" className="form-label">Observação</label>
                        <textarea style={{ width: "15rem" }} className="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                    </div>  
                </div>

                <div>
                    <div className="mb-3">
                        <label htmlFor="exampleFormControlInput1" className="form-label">Duração Consultas</label>
                        <input style={{ width: "15rem" }} type="time" className="form-control" id="exampleFormControlInput1" placeholder="clinico geral" />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="exampleFormControlInput1" className="form-label">Serviços Oferecidos</label>
                        <div style={{ background: "rgb(117, 228, 150)", width: "2.50rem", borderRadius: "1rem", display: "flex", justifyContent: "center", alignItems: "center" }}>
                            <button onClick={addInput} id='more' style={{ border: "none" }} type="button" className="btn">
                                <img src="../src/icons/add.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                            </button>
                        </div>
                    
                        <div id='services' style={{ height: "6.40rem", overflowY: "auto", overflowX: "hidden", width: "20rem", display: "block" }}>
                            {inputs.map((input, index) => (
                                <div style={{ display: "flex", marginTop: ".70rem" }} key={input.id}>
                                    <div>
                                        <input
                                            id="inputAdd"
                                            style={{ width: "15rem" }}
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
                                        <button style={{ border: "none" }} type="button" className="btn">
                                            <img src="../src/icons/escrever.png" style={{ objectFit: "cover", width: "1.50rem", height: "1.50rem" }} />
                                        </button>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Register;
