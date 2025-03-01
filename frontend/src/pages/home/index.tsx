import { useEffect, useState } from 'react'
import { TaskColumn } from '../../models'
import { Alert } from '@mui/material'
import HourglassEmptyIcon from '@mui/icons-material/HourglassEmpty';
import { fetchTasks } from '../../actions/fetchTasks';
import TaskComponent from '../../components/Task';

const Home = () => {

    const [tasks, setTasks] = useState<TaskColumn[]>([])

    const handleFetch = async () => {
        const response = await fetchTasks()
        setTasks(response)
    }

    useEffect(() => {
        handleFetch()
    }, [])

    if (!tasks.length) {
        return (
            <Alert icon={<HourglassEmptyIcon fontSize="inherit" />} severity="success">
                We couldn't find any tasks...
            </Alert>
        )
    }

    return (
        <div style={{display:'flex',background:'#f5f5f5',width:'100vw',overflowY:'scroll'}}>
            {
                tasks.map(column => {
                    return (
                        <div style={{width:'30em',display:'flex',flexDirection:'column',alignItems:'center',justifyContent:'center',height:'100em',overflowY:"scroll"}}>
                            <h4>{column.status}</h4>
                            {column.tasks.map(task =>
                                <TaskComponent task={task} status={column.status} />
                            )}
                        </div>
                    )
                }
                )
            }
        </div>
    )
}

export default Home
