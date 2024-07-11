import React from 'react'
import './css/AppointmentVisualize.css'

const AppointmentVisualize = ({id, name, document, document2, department, especiality }) => {
  return (
    <div>
       <div className="containerv">
        <div className="id">
                <h3>{id}</h3>
            </div>

            <div className="name">
                <h3>{name}</h3>
            </div>

            <div className="document">
                <h3>{document}</h3>
            </div>

            <div className="document2">
                <h3>{document2}</h3>
            </div>

            <div className="department">
                <h3>{department}</h3>
            </div>

            <div className="especialityv">
                <h3>{especiality}</h3>
            </div>
            <div className="icons">
                <button className='edit'><img src="../src/icons/escrever.png" id='edit'/></button>
                <button className='delete'><img src="../src/icons/lixeira.png" id='delete'/></button>
            </div>
       </div>
    </div>
  )
}

export default AppointmentVisualize
