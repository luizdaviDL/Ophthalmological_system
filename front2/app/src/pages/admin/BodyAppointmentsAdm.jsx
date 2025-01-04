import React, { useEffect, useState } from 'react'


const getDatas = async () => {
    const url = 'http://localhost:8081/appointment/appointments';
    const method = 'GET';
    try {
        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
        });       
        const result = await response.json();
        console.log(result);

        return { status: response.status, result};
    } catch (error) {
        console.error(error);
        return { status: 'Error', result: error.message };
    }
};


const BodyAppointmentsAdm = () => {
    const [appointments, setAppointments] = useState([]);
    useEffect(()=>{
        const fetchData = async()=>{
            const result = await getDatas();
            setAppointments(result.result);
        };
        fetchData ();
    }, []);
  return (
    <div style={{width: "55rem", marginTop:"3rem"}}>
    
        <table class="table" style={{width: "55rem", boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)"}}>
            <thead>
                <tr>
                <th scope="col">Id</th>
                <th scope="col">Consulta</th>
                <th scope="col">Duração</th>
                <th scope="col">Responsabilidades</th>
                <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                {appointments.length > 0 ? (
                            appointments.map((appointment) => (
                                <tr key={appointment.id}>
                                    <th scope="row">{appointment.id}</th>
                                    <td>{appointment.name}</td>
                                    <td>{appointment.timeDuration}</td>
                                    <td>{appointment.observation}</td>
                                    <td>
                                        <div style={{ display: 'flex', gap: '1rem', justifyContent: 'center' }}>
                                            <div style={{ width: '2rem' }}>
                                                <button
                                                    type="button"
                                                    className="btn"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#staticBackdrop"
                                                >
                                                    <img
                                                        src="../src/icons/escrever.png"
                                                        style={{ objectFit: 'cover', width: '1.50rem', height: '1.50rem' }}
                                                    />
                                                </button>
                                            </div>

                                            <div style={{ width: '2rem' }}>
                                                <button
                                                    type="button"
                                                    className="btn"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#deleteMensage"
                                                >
                                                    <img
                                                        src="../src/icons/lixeira.png"
                                                        style={{ objectFit: 'cover', width: '1.50rem', height: '1.50rem' }}
                                                    />
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="5" style={{ textAlign: 'center' }}>
                                    Não ha cadastros
                                </td>
                            </tr>
                        )}                    
            </tbody>
        </table>

        {/**modal*/}
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
            <div class="modal-dialog">
                <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Understood</button>
                </div>
                </div>
            </div>
        </div>

        {/**modal delete */}
        <div class="modal fade" id="deleteMensage" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
            <div class="modal-dialog">
                <div class="modal-content">
                
                <div class="modal-body">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel"> Do you want to delete this Appointment?</h1>                   
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary">Confirm</button>
                </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default BodyAppointmentsAdm
