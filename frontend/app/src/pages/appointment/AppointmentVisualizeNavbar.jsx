import React from 'react'
import './css/AppointmentVisualizeNavbar.css'

const AppointmentVisualizeNavbar = ({id, name, document, document2, department, especiality }) => {
  return (
    <div>
      <div className="containerApn">
          <h3 className='id'>{id}</h3>
          <h3 className='name'> {name}</h3>
          <h3 className='document'>{document} </h3>    
          <h3 className='document2'> {document2}</h3>    
          <h3 className='department'>{department}</h3>   
          <h3 className='especiality'>{especiality}</h3>           
        </div>
    </div>
  )
}

export default AppointmentVisualizeNavbar
