import React from 'react'
import ForIdComponent from '../../componentes/ForIdComponent'
import ForIdComponentNavbar from '../../componentes/ForIdComponentNavbar'
import OnlyNavbar from './OnlyNavbar'
import ManyCamps from './ManyCamps'
import Buttons from '../../componentes/Buttons'

import './css/AgendaUpdate.css'

const AgendaUpdate = () => {
  return (
    <div>
        <div className="containerAUP">
            <div className="iconClose">            
                <img src="../src/icons/close.png" alt="" />
            </div>
            <div className="bosyContainerAUP">
                <ForIdComponentNavbar navid={'id'} navName={'Paciente'} navDocument={'CPF'}/>
                <ForIdComponent id={1} name={'Luiz Carlos SIlva Brito'} document={'098.584.221-99'}/>

                <ForIdComponentNavbar navid={'Status'} navName={'Doutor(a)'} navDocument={'RG'}/>
                <ForIdComponent id={'Ativo'} name={'Mariana Silva'} document={'8843254'}/>

                <OnlyNavbar value={'Consulta'}/>
                <ManyCamps appointment={['Dermatologista']}/>
            </div>
            <div className="butonsAction">
                <Buttons/>
            </div>
            
        </div>
    </div>
  )
}

export default AgendaUpdate
