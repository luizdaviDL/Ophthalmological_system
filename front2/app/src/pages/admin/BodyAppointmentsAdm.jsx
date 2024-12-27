import React from 'react'

const BodyAppointmentsAdm = () => {
  return (
    <div style={{width: "50rem", marginLeft:"9rem", marginTop:"3rem"}}>
    
        <table class="table" style={{width: "50rem"}}>
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Appointment</th>
                <th scope="col">Clerck</th>
                <th scope="col">Profissionais</th>
                <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>terapia</td>
                    <td>Rodrigo simas Pinto</td>
                    <td>20</td>
                    <td>
                        <div style={{display: "flex", gap:"1rem", justifyContent: "center"}}>
                            <div style={{ width: "2rem"}}>
                                <button type="button" class="btn " data-bs-toggle="modal" data-bs-target="#staticBackdrop" ><img src="../src/icons/escrever.png" style={{objectFit: "cover", width: "1.50rem", height: "1.50rem"}}/></button>
                            </div>

                            <div style={{ width: "2rem"}}>
                                <button type="button" class="btn " data-bs-toggle="modal" data-bs-target="#deleteMensage"><img src="../src/icons/lixeira.png" style={{objectFit: "cover", width: "1.50rem", height: "1.50rem"}}/></button>
                            </div>
                        </div>
                    </td>
                </tr>
                
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
