import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { MyListComponent } from './my-list/my-list.component';
import { ListItemComponent } from './list-item/list-item.component';
import { AppRoutesModule } from './app-routes.module';
import { ListsService } from './services/lists.service';
import { ListDirComponent } from './list-dir/list-dir.component';
import { NewItemComponent } from './new-item/new-item.component';
import { TickingObservableComponent } from './ticking-observable/ticking-observable.component';


@NgModule({
  declarations: [
    AppComponent,
    MyListComponent,
    ListItemComponent,
    ListDirComponent,
    NewItemComponent,
    TickingObservableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutesModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ListsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
