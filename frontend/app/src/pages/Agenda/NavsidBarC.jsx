import React from 'react'
import './css/NavsidBarC.css'

const NavsidBarC = ({value, img}) => {
  return (
    <div>
      <div className="containerNs">
        <div className="bodyN">
            <img src={img} alt="" />
        <h3>{value} </h3>
        </div>
      </div>
    </div>
  )
}

export default NavsidBarC
