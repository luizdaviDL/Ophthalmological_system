import React from 'react'
import './css/Agenda.css'

const Agenda = ({ponit, time, name, document, name2}) => {
  return (
    <div>
        <div className="containerA">
            <div className="status">
                <p>{ponit}</p>
            </div>
            <div className="time">
                <p>{time}</p>
            </div>

            <div className="patient">
                <p>{name}</p>
            </div>

            <div className="document">
                <p>{document}</p>
            </div>

            <div className="doctor">
                <p>{name2}</p>
            </div>

            <div className="icons">
                <button className='edit'><img src="../src/icons/escrever.png" id='edit'/></button>
                <button className='delete'><img src="../src/icons/lixeira.png" id='delete'/></button>
            </div>
        </div>
    </div>
  )
}

export default Agenda
