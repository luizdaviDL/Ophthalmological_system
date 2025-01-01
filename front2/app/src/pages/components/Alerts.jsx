import React from 'react'

const Alerts = ({typeAlert, text}) => {
    const renderAlert =()=>{
        switch (typeAlert) {
            case 'processing':
                return <div  class="alert alert-primary" role="alert">{text}</div>
            case 'success':
                return <div class="alert alert-success" role="alert">{text}</div>
            case 'danger':
                return <div class="alert alert-danger" role="alert">{text}</div>
            default:
                break;
          }
    }

    return (
        <div>
        {renderAlert()}      
        </div>
    )
}

export default Alerts
