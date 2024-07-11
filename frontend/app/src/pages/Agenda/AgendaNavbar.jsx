import React from 'react'
import './css/AgendaNavbar.css'
const AgendaNavbar = ({status, time, name, document, name2}) => {
  return (
    <div>
        <div className="containerAg">
          <h3 className='status'>{status}</h3>
          <h3 className='time'> {time}</h3>
          <h3 className='patient'>{name} </h3>    
          <h3 className='document'> {document}</h3>    
          <h3 className='doctor'>{name2} </h3>             
        </div>
    </div>
  )
}

export default AgendaNavbar
