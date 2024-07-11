import React from 'react'
import './css/OnlyNavbar.css'

const OnlyNavbar = ({value}) => {
  return (
    <div>
      <div className="text">
        <h3>{value}</h3>
      </div>
    </div>
  )
}

export default OnlyNavbar
