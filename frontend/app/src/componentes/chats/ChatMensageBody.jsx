import React from 'react'
import ChatText from './ChatText'
import './css/ChatMensageBody.css'


const ChatMensageBody = () => {

  function closeChat(){
    const chatBody = document.getElementById('bodyChat');
    chatBody.style.display = 'none';
  
  }

  return (
    

    <div>
       <div id='bodyChat' className="bodyChat">
            <div className="profille">
                <div className="image">
                  <div className="imageUSer"></div>  
                </div>  

                <div className="nameUSer">
                    <h4>Luiz Dantos</h4>
                </div>  

                <div onClick={closeChat} className="closeIcon">                  
                  <button type="button" class="close" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>      
                      
            </div>
            
            <div className="mensageBody">
                <div className="textMensage">
                  <ChatText text={'Ola meu nome e luiz'}/>  
                  <ChatText text={'Ola meu nome e luiz bjavbd avbdjva djaviudab dvia uabdi dbujd adbda ad da a d ad ad ad ad a d ad ad ad ad  ad ad ad ad'}/>  
                  <ChatText text={'Ola meu nome e luiz'}/>  
                  <ChatText text={'Ola meu nome e luiz'}/>  
                  <ChatText text={'Ola meu nome e luiz'}/>  
                  <ChatText text={'Ola meu nome e luiz'}/>  
                  <ChatText text={'Ola meu nome e luiz'}/>  

                   
                   </div>
                <div className="sendText">

                    <input type="text" placeholder='send mensage'/>     

                    <div className='iconSend'>
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                        <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z"/>
                      </svg>
                    </div>

                                              
                </div>
            </div>
            
        </div>
    </div>
  )
}

export default ChatMensageBody
