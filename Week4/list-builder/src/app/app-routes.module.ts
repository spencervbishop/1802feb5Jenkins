import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListDirComponent } from './list-dir/list-dir.component';
import { MyListComponent } from './my-list/my-list.component';
import { TickingObservableComponent } from './ticking-observable/ticking-observable.component';

const routes: Routes = [
  {path: "lists", component: ListDirComponent},
  {path: "list/:id", component: MyListComponent},
  {path: "tick", component: TickingObservableComponent},
  {path: "", redirectTo: "/lists", pathMatch: "full"}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutesModule { }
