import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { timer } from 'rxjs/observable/timer';

@Component({
  selector: 'app-ticking-observable',
  templateUrl: './ticking-observable.component.html',
  styleUrls: ['./ticking-observable.component.css']
})
export class TickingObservableComponent implements OnInit {

  numbers: number[] = [];
  numbersObservable: Observable<any>;

  constructor() { }

  ngOnInit() {
    this.numbersObservable = timer(1000, 2000);
    this.watch();
  }

  watch() {
    this.numbersObservable.subscribe((d) => {
      this.numbers.push(d);
      console.log(d);
    });
  }

}
