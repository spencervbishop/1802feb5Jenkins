import { TaskItem } from "./TaskItem";

export class TodoList {
    id: number;
    title: string;
    items: TaskItem[];

    constructor(id: number, title: string, items: TaskItem[]) {
        this.id = id;
        if(title && title.length) {
            this.title = title;
        }

        if(items && items.length) {
            this.items = [...items];
        }
    }
}