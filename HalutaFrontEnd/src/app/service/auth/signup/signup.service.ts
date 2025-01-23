import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  private baseUrl = 'http://localhost:8080/api';
  private endPoints = '/auth/public';
  constructor(private http: HttpClient) {}

  signup(data: any) {
    const username = 'admin'; // Tên người dùng đã sử dụng trong Postman
    const password = '123456'; // Mật khẩu đã sử dụng trong Postman
    const authHeader = 'Basic ' + btoa(`${username}:${password}`);
    return this.http.post(`${this.baseUrl + this.endPoints}/signup`, data, {
      headers: {
        Authorization: authHeader,
        'Content-Type': 'application/json',
      },
    });
  }
}
