import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import {createBrowserRouter, RouterProvider} from 'react-router-dom'
import BodyAppointmentsAdm from '../src/pages/admin/BodyAppointmentsAdm';
import TemplatApp from './pages/TemplatApp'
import App from './App'
import Register from './pages/admin/appointment/Register'

const router = createBrowserRouter([
  {
    path:"/",
    element: <TemplatApp typeUSer={'admin'}/>,
    children: [
      {
        path:"/",
        element: <BodyAppointmentsAdm />
      },
      {
        path:"/register",
        element: <Register />
      },
    ],
  },
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
