import React from 'react'
import './css/ChatText.css'

const ChatText = ({text}) => {
  return (
    <div>
      <div className="text">
        <p>{text}</p>
      </div>
    </div>
  )
}

export default ChatText
