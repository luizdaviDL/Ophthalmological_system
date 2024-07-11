import React from 'react'
import './css/ManyCamps.css'

const ManyCamps = ({appointment}) => {
  return (
    <div>
        <div className="containerC">
            {appointment.map((appointment, index) =>(
                <p className='appointmentC' key={index}>{appointment} </p>
            )) }
        </div>
    </div>
  )
}

export default ManyCamps
