import React from 'react'
import './css/Templat.css'


const Templatv = ({children}) => {
  return (
    <div>
      <div className="container">

        <div className="navbar">
            <div className="logo">
              <img src="../src/icons/logom.png" alt="" />
            </div>

            <div className="icon">
              <div className="user">
                <img src="../src/icons/key.png" alt="" />
              </div>

              
            </div>
        </div>

        <div className="interfaceMain">
            {children}
        </div>

      </div>
    </div>
  )
}

export default Templatv
