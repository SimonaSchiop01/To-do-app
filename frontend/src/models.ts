export type Assignee = {
    name: string,
    avatar:string 
}


export type Task = {
    id: string,
    title: string,
    description: string,
    dueDate: string,
    assignee: Assignee,
    type:string
}

export type TaskColumn = {
    title: string,
    status: string,
    icon: string,
    iconColor: string,
    tasks: Task[]
}