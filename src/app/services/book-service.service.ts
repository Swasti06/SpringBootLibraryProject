import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  private baseurl: string = "http://localhost:9091";

  constructor(private http: HttpClient) { }
  sendData(data: any) {
    return this.http.post(`${this.baseurl}/book/addBook`, data)
  }
  getData(bookId:any) {
    return this.http.get(`${this.baseurl}/book/getBookDetails/${bookId}`)
  }
}
