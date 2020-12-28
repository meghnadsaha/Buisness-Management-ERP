import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeInventoryDetailsComponent } from './employee-inventory-details/employee-inventory-details.component';
import { EmployeeInventoryDetailsListComponent } from './_components/employee-inventory-details-list/employee-inventory-details-list.component';
import { EmployeeInventoryDetailsEditComponent } from './_components/employee-inventory-details-edit/employee-inventory-details-edit.component';


const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'inventory', component: EmployeeInventoryDetailsComponent },
  { path: 'list-of-inventory', component: EmployeeInventoryDetailsListComponent },
  { path: 'update-inventory/:id', component: EmployeeInventoryDetailsEditComponent },

  { path: '', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    EmployeeInventoryDetailsComponent,
    EmployeeInventoryDetailsListComponent,
    EmployeeInventoryDetailsEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
