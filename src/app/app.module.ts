import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './Components/navbar/navbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { AdminComponent } from './Components/admin/admin.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { LibraryComponent } from './Components/library/library.component';
import { FormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { AddBookComponent } from './Components/add-book/add-book.component';
import { IssueBookComponent } from './Components/issue-book/issue-book.component';
import { ReturnBookComponent } from './Components/return-book/return-book.component';
import { HttpClientModule } from '@angular/common/http';
import { GetBookComponent } from './Components/get-book/get-book.component';
import { AddStudentComponent } from './Components/add-student/add-student.component';
import { GetStudentComponent } from './Components/get-student/get-student.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AdminComponent,
    LibraryComponent,
    AddBookComponent,
    IssueBookComponent,
    ReturnBookComponent,
    GetBookComponent,
    AddStudentComponent,
    GetStudentComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
