import { Button } from '@mui/material'
import axios from 'axios'
import { useState } from 'react'

const Register = () => {

    const [email,setEmail] = useState<string>()
    const [password,setPassword]= useState<string>()
    const [username,setUsername]=useState<string>()

    const handleRegister = async (e)=>{
        e.preventDefault()
        const response =await axios.get("http://localhost:8080/users/create/")
        console.log("response",response)
    }   

    return (
       <div style={{width:'100vw',height:'100vh',display:'flex',alignItems:'center',justifyContent:'center'}}>
         <form style={{display:'flex',flexDirection:'column'}} onSubmit={handleRegister}>
            <label>
                Email
            </label>
            <input onChange={e=>setEmail(e.target.value)} type="text" placeholder='Enter Email' />
            <label>
                Username
            </label>
            <input onChange={e=>setUsername(e.target.value)} type="text" placeholder='Enter Username' />
            <label >
                Password
            </label>
            <input onChange={e=>setPassword(e.target.value)} type="password" placeholder='Enter password' />
            <div style={{width:'100%',height:'3e,'}}>
                <Button type='submit'>Register</Button>
            </div>
        </form>
       </div>
    )
}

export default Register
