import React from 'react'
import './css/ForBirthDate.css'

const ForBirthDate = ({name, email, document}) => {
  return (
    <div>
        <div className="containerValuesB">
          <div className="name">
            <p>{name} </p>
          </div>

          <div className="email">
            <p>{email} </p>
          </div>

          <div className="document">
            <p>{document} </p>
          </div>
        </div>
    </div>
  )
}

export default ForBirthDate
