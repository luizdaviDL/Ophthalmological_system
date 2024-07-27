import React from 'react'
import './css/OnlyCamp.css'
import { useState } from 'react'

const OnlyCamp = ({value, habiliteEdit}) => {

  const [valueNew, setvalueNew] = useState(value); 
  return (
    <div>
      <div className="containerOc">
        {habiliteEdit==true?
          <div className="newValue">
            <input type="text" 
            defaultValue={valueNew}   
            onChange={(e)=> setvalueNew(e.target.value)}           
            />
          </div>   
        :<p className='valueC' >{value} </p>   }
               
        </div>
    </div>
  )
}

export default OnlyCamp
