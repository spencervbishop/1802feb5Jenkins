import { Person } from './Person'

export class Startup {
    public static main(): void {
        const p = new Person("August", 35);
        console.log('Hello, World!');
    }
}