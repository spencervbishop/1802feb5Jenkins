import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { KnightsComponent } from './knights/knights.component';
import { Highlighter } from './knights/knights.component';

@NgModule({
  declarations: [
    AppComponent,
    KnightsComponent, 
    Highlighter
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
