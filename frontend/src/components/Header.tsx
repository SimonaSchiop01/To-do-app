import { Button } from '@mui/material'
import React, { useContext } from 'react'
import { CustomAuth } from '../context/CustomAuthProvider'
import { useNavigate } from 'react-router'

const Header = () => {

    const {logoutUser} = useContext(CustomAuth)

    const navigate = useNavigate()

  return (
    <div style={{width:'100vw',height:'5em'}}>
        <Button type="button" onClick={(e)=>{e.preventDefault();logoutUser();navigate("/login")}}>logout</Button>
    </div>
  )
}

export default Header
