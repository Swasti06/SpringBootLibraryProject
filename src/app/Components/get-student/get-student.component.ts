import { Component } from '@angular/core';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css']
})
export class GetStudentComponent {
  studentId:any 
  studentfetched:any

constructor(private student: StudentServiceService) { }

getdata(){
  console.log("button clicked");
  console.log(this.studentId);
  this.student.getData(this.studentId).subscribe(
    response=>{
      this.studentfetched=response;
      console.log(this.studentfetched);
    },
    error=>{
      console.log(error.error.message.message);
      alert(error.error.message.message);
    }
  )
}

}
