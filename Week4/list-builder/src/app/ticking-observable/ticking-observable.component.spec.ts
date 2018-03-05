import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TickingObservableComponent } from './ticking-observable.component';

describe('TickingObservableComponent', () => {
  let component: TickingObservableComponent;
  let fixture: ComponentFixture<TickingObservableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TickingObservableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TickingObservableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
