import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-author-component',
  templateUrl: './author-component.component.html',
  styleUrls: ['./author-component.component.scss']
})
export class AuthorComponentComponent implements OnInit {

  @Input() name: string;

  constructor() { }

  ngOnInit() {
  }

}
