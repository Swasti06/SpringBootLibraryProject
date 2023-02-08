import { Component } from '@angular/core';
import { BookServiceService } from 'src/app/services/book-service.service';

@Component({
  selector: 'app-get-book',
  templateUrl: './get-book.component.html',
  styleUrls: ['./get-book.component.css']
})
export class GetBookComponent {
  bookId:any 
  bookfetched:any

constructor(private book: BookServiceService) { }

getdata(){
  console.log("button clicked");
  console.log(this.bookId);
  this.book.getData(this.bookId).subscribe(
    response=>{
      this.bookfetched=response;
      console.log(this.bookfetched);
    },
    error=>{
      console.log(error.error.message.message);
      alert(error.error.message.message);
    }
  )
}

}
