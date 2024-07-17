import React from 'react'
import './css/EstatisticCamp.css'
import { useState } from 'react'

const EstatisticCamp = ({titlle, titllerNumber, numberTitller, status, titllerSTatus, totalStatus}) => {
  const [getStat, setStat] = useState({
    status: useState,
    totalStatus: totalStatus,
  })

  function getStatusColor(status) {
    switch (status) {
      case 'falta':
        return 'rgb(172, 0, 29)'; // cor que você quer para o status "ativo"
      case 'remarcar':
        return 'rgb(186, 197, 27)'; // cor que você quer para o status "inativo"
      case 'presenca':
        return 'rgb(0, 95, 82)';
      default:
        return '#CCCCCC'; // cor padrão
    }
  }
  return (
    <div>
      <div className="statistic">
        <div className="textS">
            <p>{titlle} </p>
            <div className="barr"></div>
        </div>

        <div className="total">
            <p>{titllerNumber} </p><p>{numberTitller} </p>
        </div>

        <div className="dataTotal">
          <div className="iconColor" style={{ backgroundColor: getStatusColor(getStat.status) }}></div>  
          <div className="textStatus">{titllerSTatus} </div>
          <p className='Number'>{getStat.totalStatus} </p>

        </div>              
      </div>
    </div>
  )
}

export default EstatisticCamp
