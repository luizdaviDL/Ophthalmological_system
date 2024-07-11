import React from 'react'
import './css/ForIdComponent.css'


const ForIdCompoente = ({id, name, document}) => {
  return (
    <div>
      
        <div className="containerValues">
          <div className="id">
            <p>{id} </p>
          </div>

          <div className="name">
            <p>{name} </p>
          </div>

          <div className="document">
            <p>{document} </p>
          </div>
        </div>
    </div>
  )
}

export default ForIdCompoente
