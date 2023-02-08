import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './Components/add-book/add-book.component';
import { AddStudentComponent } from './Components/add-student/add-student.component';
import { AdminComponent } from './Components/admin/admin.component';
import { GetBookComponent } from './Components/get-book/get-book.component';
import { GetStudentComponent } from './Components/get-student/get-student.component';
import { IssueBookComponent } from './Components/issue-book/issue-book.component';
import { LibraryComponent } from './Components/library/library.component';
import { ReturnBookComponent } from './Components/return-book/return-book.component';

const routes: Routes = [
  {
    path:"admin",
    component:AdminComponent,
    pathMatch:"full"
  },
  {
    path:"library",
    component:LibraryComponent,
    pathMatch:"full"
  },
  {
    path:"issueBook",
    component:IssueBookComponent,
    pathMatch:"full"
  },
  {
    path:"addBook",
    component:AddBookComponent,
    pathMatch:"full"
  },
  {
    path:"returnBook",
    component:ReturnBookComponent,
    pathMatch:"full"
  },
  {
    path:"getBook",
    component:GetBookComponent,
    pathMatch:"full"
  },
  {
    path:"addStudent",
    component:AddStudentComponent,
    pathMatch:"full"
  },
  {
    path:"getStudentDetails",
    component:GetStudentComponent,
    pathMatch:"full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
