import React from 'react'
import './css/Appointment.css'

const Appointment = ({id,name, name2}) => {
  return (
    <div>
      <div className="containerA">
        <div className="id">
            <h3>{id}</h3>
        </div>

        <div className="name">
            <h3>{name}</h3>
        </div>

        <div className="name2">
            <h3>{name2}</h3>
        </div>

        <div className="Apicons">
                <button className='visualize'><img src="../src/icons/olho-aberto.png" id='visualize'/></button>
                <button className='delete'><img src="../src/icons/lixeira.png" id='delete'/></button>
        </div>

      </div>
 
    </div>
  )
}

export default Appointment
