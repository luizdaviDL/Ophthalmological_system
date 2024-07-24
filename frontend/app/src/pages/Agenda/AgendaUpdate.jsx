import React from 'react'
import ForIdComponent from '../../componentes/ForIdComponent'
import ForIdComponentNavbar from '../../componentes/ForIdComponentNavbar'
import OnlyNavbar from './OnlyNavbar'
import ManyCamps from './ManyCamps'
import Buttons from '../../componentes/Buttons'
import OnlyCamp from '../../componentes/OnlyCamp'

import './css/AgendaUpdate.css'
import { useState } from 'react'

const AgendaUpdate = ({styleModal, closeModal}) => {
    


  return (
    <div>
        <div className="AgendaUpdateSHow" style={{display:styleModal}}>
            <div className="component">
                    <div className="containerAUP">
                        <div className="iconClose" onClick={closeModal}>            
                            <img src="../src/icons/close.png" alt="" />
                        </div>
                        <div className="bosyContainerAUP">
                            <ForIdComponentNavbar navid={'id'} navName={'Paciente'} navDocument={'CPF'}/>
                            <ForIdComponent id={1} name={'Luiz Carlos SIlva Brito'} document={'098.584.221-99'}/>

                            <ForIdComponentNavbar navid={'Status'} navName={'Doutor(a)'} navDocument={'RG'}/>
                            <ForIdComponent id={'Ativo'} name={'Mariana Silva'} document={'8843254'}/>

                            <div className="onlyCamps">
                                <div className="appointmentsV">
                                    <OnlyNavbar value={'Consulta'}/>
                                    <ManyCamps appointment={['Dermatologista']}/>
                                </div>
                                
                                <div className="dataV">
                                    <OnlyNavbar value={'Data'}/>
                                    <OnlyCamp value={'01/02/2022'}/>
                                </div>

                                <div className="timeV">
                                    <OnlyNavbar value={'Hora'}/>
                                    <OnlyCamp value={'09:00'}/>
                                </div>
                            </div>
                        </div>
                        <div className="butonsAction">
                            <Buttons/>
                        </div>
            
                    </div>
            </div>
        </div>

  
    </div>
  )
}

export default AgendaUpdate
