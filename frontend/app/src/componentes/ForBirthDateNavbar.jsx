import React from 'react'
import './css/ForIdComponentNavbar.css'

const ForBirthDateNavbar = ({navName,navEmail, navDocument}) => {
  return (
    <div>      
        <div className="containerNavB">
          <h3 className='name'>{navName} </h3>
          <h3 className='email'>{navEmail} </h3>
          <h3 className='document'>{navDocument} </h3>        
        </div>
    </div>
  )
}

export default ForBirthDateNavbar
