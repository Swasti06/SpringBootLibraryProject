import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private baseurl: string = "http://localhost:9098";

  constructor(private http: HttpClient) { }
  sendData(data: any) {
    return this.http.post(`${this.baseurl}/student/addStudent`, data)
  }
  getData(studentId:any) {
    return this.http.get(`${this.baseurl}/student/getStudentDetails/${studentId}`)
  }
  issueBookData(bookId:any,studentId:any){
    return this.http.get(`${this.baseurl}/student/issueBook?bookId=${bookId}&studentId=${studentId}`)
  }
  returnBookData(bookId:any,studentId:any){
    return this.http.get(`${this.baseurl}/student/returnBook?bookId=${bookId}&studentId=${studentId}`)
  }
}
