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

    const handleClick = ()=>{
        setModal(true)
    }

    const closeClick=()=>{
        setModal(false)
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

  return (
    
        <Templatv>
            
            `{/**
             * {showModal && <AgendaUpdate styleModal={'block'} = True and Expression(<AgendaUpdate styleModal={'block'} ) = True (that show the Component)
             * {showModal && <AgendaUpdate styleModal={'block'} = False and Expression(<AgendaUpdate styleModal={'block'} ) = False (dont show the Component)
             *     
             */}`
            {showModal && <AgendaUpdate styleModal={'block'} closeModal={closeClick}/> } 

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
                                        const dateR = new Date(value.date);
                                        const dataFormat = dateR.toLocaleString('pt-BR',{
                                            year: 'numeric',
                                            month: '2-digit',
                                            day: '2-digit',
                                            hour: '2-digit',
                                            minute: '2-digit',
                                            hour12: false
                                        });
                                        const dateV = dataFormat.split(',');
                                        const dataValue = dateV[0];
                                        return(
                                            <Agenda ponit={'.'} time={dataValue} name={value.patient.fullname} document={value.patient.rg} name2={value.doctor.fullname} callModal={handleClick} /> 
                                        )
                                    })
                                }

                                {/** 
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} callModal={handleClick} />    
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />
                                <Agenda ponit={'.'} time={'09:80'} name={'Luiz Carlos SIlva'} document={'765.735.973-66'} name2={'Luan Silva Brito'} />
                                */}
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
