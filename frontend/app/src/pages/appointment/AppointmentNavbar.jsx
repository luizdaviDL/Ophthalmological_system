import React from 'react'
import './css/AppointmentNavbar.css'


const AppointmentNavbar = ({id,name, name2}) => {
  return (
    <div>
      <div className="containerApo">
        <div className="idCamp">
            <h3>{id}</h3>
        </div>
        <div className="nameCamp">
            <h3>{name}</h3>
        </div>
        <div className="nameCamp2">
            <h3>{name2}</h3>
        </div>
      </div>
    </div>
  )
}

export default AppointmentNavbar
