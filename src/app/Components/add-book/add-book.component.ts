import { Component } from '@angular/core';
import { BookServiceService } from 'src/app/services/book-service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent {
  data={
    bookId:"",
    bookName:"",
    authorName:"",
    // issueDate:"",
    availability:""

  }
  constructor(private book:BookServiceService){}
  addBookForm(){
    console.log("buton Clicked");
    console.log(this.data);
    /* call the object */
    this.book.sendData(this.data).subscribe(
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
