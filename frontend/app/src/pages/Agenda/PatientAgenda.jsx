import React from 'react'
import './css/PatientAgenda.css'

const PatientAgenda = ({id, name,birthDate,documentshort, documentLong}) => {
  return (
    <div>
        <div className="containerP">
            <div className="id">
                <p>{id}</p>
            </div>
            <div className="name">
                <p>{name}</p>
            </div>

            <div className="birthDate">
                <p>{birthDate}</p>
            </div>

            <div className="documentshort">
                <p>{documentshort}</p>
            </div>

            <div className="documentLong">
                <p>{documentLong}</p>
            </div>

            <div className="icons">
                <button className='edit'><img src="../src/icons/escrever.png" id='edit'/></button>
                <button className='delete'><img src="../src/icons/lixeira.png" id='delete'/></button>
            </div>
        </div>
    </div>
  )
}

export default PatientAgenda
