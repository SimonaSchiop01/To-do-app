import React from 'react'
import { Task } from '../models'
import { Chip } from '@mui/material'
import DateRangeIcon from '@mui/icons-material/DateRange';
type Props = {
  task: Task,
  status: string
}

const TaskComponent: React.FC<Props> = ({ task, status }) => {
  return (
    <div style={{ background: 'white', width: '20em', display: 'flex', height: '40em', flexDirection: 'column', marginTop: '0.5em', borderRadius: '20px' }}>
      <Chip color="info" label={status} />
      <div style={{ width: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>{task.type}</div>
      <div style={{ width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
        <h4>{task.title}</h4>
        <h6>{task.description}</h6>
      </div>
      <div style={{ width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
       <DateRangeIcon/>
        {task.dueDate}
      </div>
    </div>
  )
}

export default TaskComponent
