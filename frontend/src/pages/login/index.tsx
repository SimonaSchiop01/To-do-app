import { Button } from '@mui/material'
import React, { useContext, useEffect, useState } from 'react'
import { CustomAuth } from '../../context/CustomAuthProvider'
import { useNavigate } from 'react-router'

const Login= () => {

    const { login, IsUserLoggedIn } = useContext(CustomAuth)
    const navigate = useNavigate()

    useEffect(()=>{
       if(IsUserLoggedIn()==true)
       {
            navigate("/home")
       }
    },[])

    const [email, setEmail] = useState<string>()
    const [password, setPassword] = useState<string>()
    const handleLogin = async (e:React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()
        const response = await login({email,password})
        if(response)
        {
            navigate("/home")
        }
    }

    return (
        <div style={{ width: '100vw', height: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
            <form style={{display:'flex',alignItems:'center',justifyContent:'center',flexDirection:'column'}} onSubmit={handleLogin}>
                <label>
                    Email
                </label>
                <input onChange={(e) => setEmail(e.target.value)} type='email' placeholder='Enter email' />
                <label>
                    Password
                </label>
                <input onChange={(e) => setPassword(e.target.value)} type='password' placeholder='Enter password' />
                <Button type='submit'>Login</Button>
            </form>
        </div>
    )
}

export default Login
