import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BasicAuth } from '../../../constant/basic_auth';
import { Url, endPoints, authenticate } from '../../../constant/api';

@Injectable({
  providedIn: 'root',
})
export class SigninService {
  constructor(private http: HttpClient) {}
  login(data: any) {
    // Tên người dùng đã sử dụng trong Postman
    // Mật khẩu đã sử dụng trong Postman
    const authHeader =
      'Basic ' + btoa(`${BasicAuth.username}:${BasicAuth.password}`);
    return this.http.post(`${Url + authenticate.signIn}`, data, {
      headers: {
        Authorization: authHeader,
        'Content-Type': 'application/json',
      },
    });
  }
}
