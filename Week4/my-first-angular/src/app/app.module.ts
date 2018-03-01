import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { MyFirstComponentComponent } from './components/my-first-component/my-first-component.component';
import { AuthorComponentComponent } from './components/author-component/author-component.component';
import { Input } from '@angular/core/src/metadata/directives';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MyFirstComponentComponent,
    AuthorComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
