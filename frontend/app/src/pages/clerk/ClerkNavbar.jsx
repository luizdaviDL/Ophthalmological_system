import React from 'react'
import './css/ClerkNavbar.css'
const ClerkNavbar = ({id, name, document, department}) => {
  return (
    <div>
      <div className="containerCln">
          <h3 className='id'>{id}</h3>
          <h3 className='name'> {name}</h3>
          <h3 className='document'>{document} </h3>              
          <h3 className='department'>{department}</h3>             
        </div>
    </div>
  )
}

export default ClerkNavbar
