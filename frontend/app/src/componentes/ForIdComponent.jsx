import React from 'react'
import './css/ForIdComponent.css'
import { useState } from 'react'

const ForIdCompoente = ({id, name, document, habiliteEdit}) => {
  const [nameNew, setnameNew] = useState(name); 
  const [documentNew, setdocumentNew] = useState(document); 

  return (
    <div>
      
        <div className="containerValues">
          <div className="id">
            <p>{id} </p>
          </div>

          <div className="name">
            {habiliteEdit==true?
              <div className="newName">
                  <input type="text" 
                  defaultValue={nameNew}   
                  onChange={(e)=> setnameNew(e.target.value)}           
                  />
              </div>
            : <p>{name} </p>}            
          </div>

          <div className="document">
            {habiliteEdit?
                <div className="newDocument">
                    <input type="text" 
                    defaultValue={documentNew}   
                    onChange={(e)=> setdocumentNew(e.target.value)}             
                    />
                </div>
            : <p>{document} </p>}
            
          </div>
        </div>
    </div>
  )
}

export default ForIdCompoente
