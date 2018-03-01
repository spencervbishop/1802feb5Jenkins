import { Component } from '@angular/core';
import { OnInit, OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
    selector: 'app-my-first-component',
    templateUrl: './my-first-component.component.html',
    styleUrls: ['./my-first-component.component.css']
})
export class MyFirstComponentComponent implements OnInit, OnDestroy {

    /*
        Directives!
            1. Components! (They're directives, I promise)
            2. Structural!
            3. Attribute!
    */

    show: boolean = true;
    noshow: boolean = false;
    myNumber: number = 10;

    authors: Array<string> = ['Mark Twain', 'Brandon Sanderson',
     'William Shakespeare', 'Matthew Stover', 'J.K. Rowling',
     'Dr. Seuss', 'Phillip K. Dick', 'Arthur C. Clark',
     'Tom K. Clancy', 'Frank Herbert'];
    

    constructor() {}

    public consoleValue() {
        alert(this.myNumber);
    }

    ngOnInit() {

    }

    ngOnDestroy() {

    }
}