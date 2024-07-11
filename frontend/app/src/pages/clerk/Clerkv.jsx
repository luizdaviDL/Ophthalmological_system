import React from 'react'
import './css/Clerkv.css'

const Clerkv = ({id, name, document, department }) => {
  return (
    <div>
       <div className="containerCL">
        <div className="id">
                <h3>{id}</h3>
            </div>

            <div className="name">
                <h3>{name}</h3>
            </div>

            <div className="document">
                <h3>{document}</h3>
            </div>

            <div className="department">
                <h3>{department}</h3>
            </div>

            <div className="icons">
                <button className='edit'><img src="../src/icons/escrever.png" id='edit'/></button>
                <button className='delete'><img src="../src/icons/lixeira.png" id='delete'/></button>
            </div>
       </div>
    </div>
  )
}

export default Clerkv
