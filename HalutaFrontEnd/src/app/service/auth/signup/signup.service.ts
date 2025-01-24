import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { authenticate, endPoints, Url } from '../../../constant/api';
import { BasicAuth } from '../../../constant/basic_auth';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http: HttpClient) {}

  signup(data: any) {
    // Tên người dùng đã sử dụng trong Postman
    // Mật khẩu đã sử dụng trong Postman
    const authHeader =
      'Basic ' + btoa(`${BasicAuth.username}:${BasicAuth.password}`);
    return this.http.post(`${Url + authenticate.signUp}`, data, {
      headers: {
        Authorization: authHeader,
        'Content-Type': 'application/json',
      },
    });
  }
}
