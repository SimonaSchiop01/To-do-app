
import './App.css'
import { BrowserRouter as Router, Route, Routes } from 'react-router'
import Home from './pages/home'
import Register from './pages/register'
import { CustomAuthProvider } from './context/CustomAuthProvider'
import Login from './pages/login'
import Header from './components/Header'
function App() {

  return (
    <CustomAuthProvider>
      <Router>
        <Routes>
          <Route path='/login' element={<Login />} />
          <Route path='/' element={<Register />} />
          <Route path='/home' element={<Home />} />
        </Routes>
      </Router>
    </CustomAuthProvider>

  )

}

export default App
