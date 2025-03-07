import { Button } from '@mui/material'
import axios from 'axios'
import { useContext, useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router'
import { CustomAuth } from '../../context/CustomAuthProvider'

const Register = () => {

    const [email, setEmail] = useState<string>()
    const [password, setPassword] = useState<string>()
    const [username, setUsername] = useState<string>()
    const navigate = useNavigate()
    const { login, IsUserLoggedIn } = useContext(CustomAuth)

    useEffect(() => {
        if(IsUserLoggedIn())
        {
            navigate("/home")
        }
    }, [])

    const handleRegister = async (e) => {
        e.preventDefault()
        const response = await axios.post("http://localhost:8080/users/create", { email, password, username })
        console.log("response", response)
    }

    return (
        <div style={{ width: '100vw', height: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
            <form style={{ display: 'flex', flexDirection: 'column' }} onSubmit={handleRegister}>
                <label>
                    Email
                </label>
                <input onChange={e => setEmail(e.target.value)} type="text" placeholder='Enter Email' />
                <label>
                    Username
                </label>
                <input onChange={e => setUsername(e.target.value)} type="text" placeholder='Enter Username' />
                <label >
                    Password
                </label>
                <input onChange={e => setPassword(e.target.value)} type="password" placeholder='Enter password' />
                <div style={{ width: '100%', height: '3e,' }}>
                    <Button type='submit'>Register</Button>
                    <Button onClick={() => navigate("/login")}>Login</Button>
                </div>
            </form>
        </div>
    )
}

export default Register
