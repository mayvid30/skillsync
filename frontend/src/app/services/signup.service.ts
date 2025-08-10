import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  private apiUrl='http://localhost:8080/api/auth';

  constructor(private http:HttpClient) { }

  signUp(userData:any):Observable<any>{
    return this.http.post(this.apiUrl+'/register',userData);
  }
}
