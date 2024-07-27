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
import moment from 'moment';

import { useState, useEffect } from 'react'

const AgendaTemplat = () => {
    function getStatusAgendaPatient(status){
        onChangeAgendaPatient(status)
    };

    const [showModal, setModal] = useState(false);

    {/*Date camp */}
    const [inputday, setinputday] = useState('');
    const [inputmounth, setinputmounth] = useState('');
    const [inputyear, setinputyear] = useState('');
    const [getUpdate, setgetUpdate] = useState([]);

    function handleClick(e){
        setModal(true)
        setgetUpdate(e)
    }

    const closeClick=()=>{
        setModal(false)
    }

    function ModifyHour(value){
        const [hour, minut, second] = value.split(':')
        return hour+':' +minut
    }

    function ModifyDate(dateR) {
        {/**does not convert date to local time zone , keep the date*/}
        const dataFormatada = moment.utc(dateR).format('DD/MM/YYYY');
        return dataFormatada
      }
  
    const getDate=(value)=>{
        const month = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];

        value = value.split("-");
        const day = value[2];
        const mounthV = value[1];
        const mounthN = mounthV-1;
        const year = value[0];

        const mounthResult = month[mounthN];

        setinputday(day);
        setinputmounth(mounthResult);
        setinputyear(year);

    }


    {/**get api data */}
    const [getData, setgetData] = useState([]);
    

    useEffect(()=>{
        const getDataApi = async() =>{
            const dataApi = await fetch(`http://localhost:8081/diary/Alldiary`);
            const result = dataApi.json();
            result.then(value => {
                
                setgetData(value)
                
                console.log(getData)
            })            
        }
        getDataApi()
    },[]);
     {/**[] is used to sstart useEffect with a value after go to bin(lixeira) */}

    {/**Get data when updateAgenda */}
    const NavbarNames = ['id','Paciente','CPF','Status','Doutor(a)','RG','Consulta','Data','Hora']
    const DatasPatient = [getUpdate.id, getUpdate.patient?.fullname, getUpdate.patient?.cpf, getUpdate.status==true ?'Ativo': 'Cancelado', getUpdate.doctor?.fullname, getUpdate.patient?.rg, getUpdate.appointment?.name, getUpdate.date ? ModifyDate(getUpdate.date) : '' , getUpdate.time ? ModifyHour(getUpdate.time): '']

  return (
    
        <Templatv>
            
            `{/**
             * {showModal && <AgendaUpdate styleModal={'block'} = True and Expression(<AgendaUpdate styleModal={'block'} ) = True (that show the Component)
             * {showModal && <AgendaUpdate styleModal={'block'} = False and Expression(<AgendaUpdate styleModal={'block'} ) = False (dont show the Component)
             */}`
             
            {showModal && <AgendaUpdate styleModal={'block'} closeModal={closeClick} values={DatasPatient} navBarName={NavbarNames}/> } 

            <div className="sideBar">               
                <NavsidBarC value={'Agenda'} img={"../src/icons/calendario.png"} />                                               
                <NavsidBarC value={'Patient'} img={"../src/icons/patient1.png"} />  
                <NavsidBarC value={'Estatistica'} img={"../src/icons/estatisticas.png"} />  
            </div>

            <div className="body">
                <BodyAgenda>

                    

                    <div className="mainCamp">

                        <div className="datasAC">

                            <div className="dateCamp">
                                <div className="dateV">
                                    <h1>{inputday} de {inputmounth} {inputyear}</h1>
                                    <p></p>
                                </div>
                                <div className="calendaryIcon">
                                    <input className='date' type="date" onChange={(e)=> getDate(e.target.value)}/>
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

                                {
                                    Array.isArray(getData) && getData.map(value=>{                                        
                                        const dataValue = ModifyDate(value.date);
                                        return(
                                            <Agenda ponit={'.'} time={dataValue} name={value.patient.fullname} document={value.patient.rg} name2={value.doctor.fullname} callModal={()=>handleClick(value)} /> 
                                        )
                                    })
                                }
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
