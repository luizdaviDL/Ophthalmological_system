import React from 'react'
import Templatv from '../../componentes/Templatv'
import NavsidBarC from '../Agenda/NavsidBarC' 
import BodyAgenda from './BodyAgenda'
import ForIdComponentNavbar from '../../componentes/ForIdComponentNavbar'

const AgendaTemplat = () => {
  return (
    
        <Templatv>
            <div className="sideBar">
                <NavsidBarC value={'Agenda'} img={"../src/icons/calendario.png"} />                               
                <NavsidBarC value={'Patient'} img={"../src/icons/calendario.png"} />  
                <NavsidBarC value={'Patient'} img={"../src/icons/patient.png"} />  
                <NavsidBarC value={'Estatistica'} img={"../src/icons/estatisticas.png"} />  
            </div>

            <div className="body">
                <BodyAgenda>
                    <div className="bodyAgenda">
                        <ForIdComponentNavbar navid={'id'} navName={'Patient'} navDocument={'Document'} />
                    </div>

                    <div className="datasAgenda">
                        <p>oi</p>
                    </div>
                </BodyAgenda>  
            </div>

        </Templatv>
    
  )
}

export default AgendaTemplat
