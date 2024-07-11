import React from 'react'
import './css/PatientNavbar.css'

const PatientNavbar = ({id,name,birthDate,document1,document2}) => {
  return (
    <div>
      <div className="containerPn">
          <h3 className='id'>{id}</h3>
          <h3 className='name'> {name}</h3>
          <h3 className='birthDate'>{birthDate} </h3>    
          <h3 className='document1'> {document1}</h3>    
          <h3 className='document2'>{document2} </h3>             
        </div>
    </div>
  )
}

export default PatientNavbar
