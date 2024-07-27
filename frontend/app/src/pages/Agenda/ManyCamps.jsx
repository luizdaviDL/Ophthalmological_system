import React from 'react'
import './css/ManyCamps.css'
import { useState } from 'react'

const ManyCamps = ({appointment, habiliteEdit}) => {

  const [appointmentNew, setappointmentNew] = useState(appointment); 
  return (
    <div>
        <div className="containerC">
            {appointment.map((appointment, index) =>(
                habiliteEdit==true?(
                    <div className="newAppointment">
                        <input type="text" 
                        defaultValue={appointmentNew}   
                        onChange={(e)=> setappointmentNew(e.target.value)}           
                        />
                    </div>                  
                ):(
                  <p className='appointmentC' key={index}>{appointment} </p>
                )
                
            )) }
        </div>
    </div>
  )
}

export default ManyCamps
