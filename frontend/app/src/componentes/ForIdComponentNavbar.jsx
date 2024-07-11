import React from 'react'
import './css/ForIdComponentNavbar.css'

const ForIdComponentNavbar = ({navid,navName, navDocument}) => {
  return (
    <div>
        <div className="containerNav">
          <h3 className='id'>{navid} </h3>
          <h3 className='patient'>{navName} </h3>
          <h3 className='document'>{navDocument} </h3>        
        </div>
    </div>
  )
}

export default ForIdComponentNavbar
