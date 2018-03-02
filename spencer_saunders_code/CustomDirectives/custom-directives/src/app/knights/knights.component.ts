import { Component, OnInit, HostListener, ElementRef, Directive } from '@angular/core';

@Component({
  selector: 'app-knights',
  templateUrl: './knights.component.html',
  styleUrls: ['./knights.component.css']
})
export class KnightsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

@Directive({
  selector: "[myHighlight]"
})
export class Highlighter {
  @HostListener('mouseenter') onMouseEnter() {
    this.highlight('yellow');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight(null);
  }
  constructor(private el: ElementRef){}
  
  private highlight(color: string){
    this.el.nativeElement.style.backgroundColor = color;
  }
}
