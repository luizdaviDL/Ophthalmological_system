import React from 'react'
import ForIdComponent from '../../componentes/ForIdComponent'
import ForIdComponentNavbar from '../../componentes/ForIdComponentNavbar'
import OnlyNavbar from './OnlyNavbar'
import ManyCamps from './ManyCamps'
import Buttons from '../../componentes/Buttons'
import OnlyCamp from '../../componentes/OnlyCamp'

import './css/AgendaUpdate.css'
import { useState } from 'react'

const AgendaUpdate = ({styleModal, closeModal, values, navBarName}) => {
    
    const [habiliteEdit, setabiliteEdit] = useState(values);
 

    function handleHability(){
        setabiliteEdit(true)
    }

  return (
    <div>
        <div className="AgendaUpdateSHow" style={{display:styleModal}}>
            <div className="component">
                    <div className="containerAUP">
                        <div className="iconClose" onClick={closeModal}>            
                            <img src="../src/icons/close.png" alt="" />
                        </div>
                        <div className="bosyContainerAUP">
                            <ForIdComponentNavbar navid={navBarName[0]} navName={navBarName[1]} navDocument={navBarName[2]}/>
                            <ForIdComponent id={values[0]} name={habiliteEdit[1]} document={habiliteEdit[2]}  habiliteEdit={habiliteEdit} />

                            <ForIdComponentNavbar navid={navBarName[3]} navName={navBarName[4]} navDocument={navBarName[5]}/>
                            <ForIdComponent id={values[3]} name={habiliteEdit[4]} document={habiliteEdit[5]}  habiliteEdit={habiliteEdit} />

                            <div className="onlyCamps">
                                <div className="appointmentsV">
                                    <OnlyNavbar value={navBarName[6]}/>
                                    <ManyCamps appointment={[habiliteEdit[6]]}  habiliteEdit={habiliteEdit} />
                                </div>
                                
                                <div className="dataV">
                                    <OnlyNavbar value={navBarName[7]}/>
                                    <OnlyCamp value={habiliteEdit[7]} habiliteEdit={habiliteEdit}/>
                                </div>

                                <div className="timeV">
                                    <OnlyNavbar value={navBarName[8]}/>
                                    <OnlyCamp value={habiliteEdit[8]} habiliteEdit={habiliteEdit}/>
                                </div>
                            </div>
                        </div>
                        <div className="butonsAction">
                            <Buttons handleChange={handleHability} />
                        </div>
            
                    </div>
            </div>
        </div>

  
    </div>
  )
}

export default AgendaUpdate
