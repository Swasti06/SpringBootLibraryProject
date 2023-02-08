import { Component } from '@angular/core';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {
  //in data give the names of the fields as in db
  data={
    studentId:"",
    name:"",
    email:"",
    phone:""
  
  }
  constructor(private student:StudentServiceService){}
  submitTheForm(){
    console.log("buton Clicked");
    console.log(this.data);
    /* call the object */
    this.student.sendData(this.data).subscribe(
      response=>{
        console.log(response);
        alert("Data Submitted");
      },
      error=>{
        console.log(error);
        alert("Data not Submitted");
      }
      )
  }

}
