import { Component } from '@angular/core';
import { BookServiceService } from 'src/app/services/book-service.service';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-issue-book',
  templateUrl: './issue-book.component.html',
  styleUrls: ['./issue-book.component.css']
})
export class IssueBookComponent {
  studentId:any 
  bookId:any
  studentfetched:any
  

constructor(private student: StudentServiceService,private book:BookServiceService) {}

issueBook(){
  console.log("button clicked");
  console.log(this.studentId,this.bookId);
  this.student.issueBookData(this.bookId,this.studentId).subscribe(
    response=>{
      this.studentfetched=response;
      console.log(this.studentfetched);
      alert("issued");
    },
    error=>{
      console.log(error.error.message.message);
      alert(error.error.message.message);
    }
  )
}

}
