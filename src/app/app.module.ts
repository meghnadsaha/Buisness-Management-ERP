import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';

import { ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { Routes, RouterModule } from '@angular/router';
import {MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';

import { AppComponent } from './app.component';
import { EmployeeInventoryDetailsCreateComponent } from './_components/employee-inventory-details-create/employee-inventory-details-create.component';
import { EmployeeInventoryDetailsListComponent } from './_components/employee-inventory-details-list/employee-inventory-details-list.component';
import { EmployeeInventoryDetailsEditComponent } from './_components/employee-inventory-details-edit/employee-inventory-details-edit.component';
import { UploadFilesComponent } from './_components/upload-files/upload-files.component';
import { SignUpComponent } from './_components/sign-up/sign-up.component';
import { TableComponent } from './_components/table/table.component';


import {DemoMaterialModule} from './_components/table/material-module';
import 'zone.js/dist/zone';

const routes: Routes = [
  { path: 'register', component: SignUpComponent },
  { path: 'create-inventory', component: EmployeeInventoryDetailsCreateComponent },
  { path: 'list-of-inventory', component: EmployeeInventoryDetailsListComponent },
  { path: 'update-inventory/:id', component: EmployeeInventoryDetailsEditComponent },
  { path: 'upload-doc', component: UploadFilesComponent },

  { path: '', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
	SignUpComponent,
    EmployeeInventoryDetailsCreateComponent,
    EmployeeInventoryDetailsListComponent,
    EmployeeInventoryDetailsEditComponent,
    UploadFilesComponent,
    TableComponent,
	
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)],
	
	
	BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    DemoMaterialModule,
    MatNativeDateModule,
    ReactiveFormsModule
  ],
  entryComponents: [TableComponent],
  providers: [
    { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'fill' } },
  ],
  bootstrap: [AppComponent]
  
})
export class AppModule { }
