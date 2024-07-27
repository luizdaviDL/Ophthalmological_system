import React from 'react'
import './css/Buttons.css'

const Buttons = ({handleChange}) => {
  return (
    <div>
      <div className="containerButons">        
        <div title='salvar'>
            <img className='save' src="../src/icons/marca.png" alt="" />
        </div>
        
        <div title='deletar'>
          <img className='delete' src="../src/icons/editarColoricon.png" onClick={handleChange}/>
        </div>

        <div title='remarcar'>
          <img className='reschedule' src="../src/icons/reagendar.png" alt="" />
        </div>
        
      </div>
    </div>
  )
}

export default Buttons
