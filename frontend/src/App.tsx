
import './App.css'
import { BrowserRouter as Router ,  Route, Routes } from 'react-router'
import Home from './pages/home'
import Register from './pages/register'
function App() {

  return (
    <Router>
      <Routes>
        <Route  path='/' element={<Register/>}/>
        <Route path='/home'   element={<Home/>}/>
      </Routes>
    </Router>
  )

}

export default App
