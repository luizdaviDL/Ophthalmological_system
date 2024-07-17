import React from 'react'
import Templatv from '../../componentes/Templatv'
import NavsidBarC from '../Agenda/NavsidBarC' 
import BodyAgenda from './BodyAgenda'
import AgendaNavbar from './AgendaNavbar'
import ShearchIcon from '../../componentes/ShearchIcon'
import Agenda from './Agenda'
import './css/AgendaTemplat.css'
import ChatMensage from '../../componentes/chats/ChatMensage'
import ChatMensageBody from '../../componentes/chats/ChatMensageBody'
import EstatisticCamp from '../../componentes/EstatisticCamp'
import AgendaUpdate from './AgendaUpdate'

const AgendaTemplat = () => {
    function getStatusAgendaPatient(status){
        onChangeAgendaPatient(status)
    };

    


  return (
    
        <Templatv>
            <div className="AgendaUpdateSHow">
                <div className="component">
                        <AgendaUpdate/>
                </div>
            </div>

            <div className="sideBar">
                <NavsidBarC value={'Agenda'} img={"../src/icons/calendario.png"} />                               
                <NavsidBarC value={'Patient'} img={"../src/icons/calendario.png"} />  
                <NavsidBarC value={'Patient'} img={"../src/icons/patient.png"} />  
                <NavsidBarC value={'Estatistica'} img={"../src/icons/estatisticas.png"} />  
            </div>

            <div className="body">
                <BodyAgenda>

                    

                    <div className="mainCamp">

                        <div className="datasAC">

                            <div className="dateCamp">
                                <div className="dateV">
                                    <h1>23 de Janeiro 2022</h1>
                                    <p></p>
                                </div>
                                <div className="calendaryIcon">
                                    <input className='date' type="date"/>
                                    <img className='image' src="../src/icons/calendaryShearch.png" alt="" />
                                </div>
                            </div>

                            <div className="search">
                                <ShearchIcon/>                               
                            </div>

                            <div className="bodyAgenda">
                                <AgendaNavbar status={''} time={"Horario"} name={"Paciente"} document={"CPF"} name2={"Doutor(a)"}   />                               
                                
                            </div>

                            <div className="datasAgenda">
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />    
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />

                            </div>

                        </div>

                        <div className="statisticCamp">
                            <div className="chatCamp">
                                <div className="shearchUser">
                                    <input type="text" placeholder='Shearch for user'/>
                                </div>

                                <div className="mensageCamp">
                                    <ChatMensage user={'Luiz Santos'}/>   
                                    <ChatMensage user={'Luiz Santos'}/>       
                                    <ChatMensage user={'Luiz Santos'}/>       

                                    <ChatMensage user={'Luiz Santos'}/>       

                                    <ChatMensage user={'Luiz Santos'}/>       
                                                                        
                                </div>
                                <ChatMensageBody/>      
                            </div>        

                            <div className="statistcDay">
                                <EstatisticCamp titlle={'Estatistica do dia'} titllerNumber={'Agendamentos'} numberTitller={10} onChangeAgendaPatient={getStatusAgendaPatient} />   
                                

                            </div>                    
                        </div>
                    
                    </div>
                </BodyAgenda>  
            </div>

        </Templatv>
    
  )
}

export default AgendaTemplat  
