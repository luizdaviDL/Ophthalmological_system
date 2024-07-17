import React from 'react'
import './css/ChatMensage.css'


const ChatMensage = ({user}) => {

    function cllickMensage(){
        const mensageBody = document.getElementById('bodyChat');
        mensageBody.style.display = 'block';
        console.log('olalla')
    }


  return (
    <div>
        <div onClick={cllickMensage} id='mensage' className="mensage">
            <div className="profile">
                <div className="image">
                    
                </div>
            </div>
            <div className="nameuser">
                <h4>{user}</h4>
            </div>
            <div className="iconStatus">
                <div className="timeMensage">
                    <p>09:00</p>
                </div>
                <div className="iconColor">
                    
                </div>                                                
            </div>
        </div>

    </div>

  )
}

export default ChatMensage
