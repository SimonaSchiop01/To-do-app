import axios from "axios"
import { Task, TaskColumn } from "../models"

type Response = {
    tasks:TaskColumn[]
}

export const fetchTasks = async ()=>{
    const response = await axios.get<Response>("data.json")
    console.log("response",response.data.tasks)
    return response.data.tasks
}