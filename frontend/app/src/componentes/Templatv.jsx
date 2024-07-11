import React from 'react'
import './css/Templat.css'

const templat = () => {
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

              <div className="logout">
                <img src="../src/icons/logout.png" alt="" />
              </div>
            </div>
        </div>

        <div className="interfaceMain">
          <div className="sideBar">

          </div>

          <div className="body">

          </div>
        </div>




      </div>
    </div>
  )
}

export default templat
