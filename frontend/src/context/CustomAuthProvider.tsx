import axios from "axios";
import { createContext, useEffect, useState } from "react";
import { jwtDecode } from "jwt-decode";

//@ts-ignore
export const CustomAuth = createContext()

type LoginRequest = {
    email:string,
    password:string
}

type LoginResponse = {
    accessToken: string,
    refreshToken: string,
    message: string,
    errorCode: number
}

type DecodedToken = {
    email:string
}
export const CustomAuthProvider:React.FC<{children:React.ReactNode}> = ({children})=>{

    const IsUserLoggedIn = ()=>{
        const accessToken = localStorage.getItem("accessToken")
        if(accessToken)
        {
            return true;
        }
        else{
            return false;
        }
    }

    const logoutUser = ()=>{
        localStorage.removeItem("accessToken")
        localStorage.removeItem("refreshToken")
        localStorage.removeItem("user")
    }

    const login = async (data:LoginRequest) => {
        const response = await axios.post<LoginResponse>("http://localhost:8080/authentification-controller/GeneratePairsOfTokens",data)
        const {accessToken,refreshToken} = response.data
        const decode:DecodedToken = jwtDecode(accessToken)

        const user = {
            email:decode.email
        }
        localStorage.setItem("accessToken",accessToken)
        localStorage.setItem("refreshToken",refreshToken)
        localStorage.setItem("user",JSON.stringify(user))
        return true
    }



    useEffect(()=>{

        const interval = setInterval(() => {
            console.log("interval apelat")
        }, (14400));

        return ()=>{
            clearInterval(interval)
        }
    },[])

    const value = {
        login,
        IsUserLoggedIn,
        logoutUser
    }
    return <CustomAuth.Provider value={value}>{children}</CustomAuth.Provider>

    
}