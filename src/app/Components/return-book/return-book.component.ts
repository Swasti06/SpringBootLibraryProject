import { Component } from '@angular/core';
import { StudentServiceService } from 'src/app/services/student-service.service';
import { BookServiceService } from 'src/app/services/book-service.service';

@Component({
  selector: 'app-return-book',
  templateUrl: './return-book.component.html',
  styleUrls: ['./return-book.component.css']
})
export class ReturnBookComponent {
  studentId:any 
  bookId:any
  studentfetched:any
  

constructor(private student: StudentServiceService,private book:BookServiceService) {}

returnBookForm(){
  console.log("button clicked");
  console.log(this.studentId,this.bookId);
  this.student.returnBookData(this.bookId,this.studentId).subscribe(
    response=>{
      this.studentfetched=response;
      console.log(this.studentfetched);
      alert("returned")
    },
    error=>{
      console.log(error.error.message.message);
      alert(error.error.message.message);
    }
  )
}


}
