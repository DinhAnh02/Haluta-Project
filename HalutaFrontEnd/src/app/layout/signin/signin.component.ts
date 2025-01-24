import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SigninService } from '../../service/auth/signin/signin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  standalone: false,
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss',
})
export class SigninComponent {
  loginForm: FormGroup;
  constructor(private router: Router, private login: SigninService) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }
  //Event Action
  onSubmit() {
    if (this.loginForm.invalid) {
      console.log('Form Invalid', this.loginForm.errors);
      Object.keys(this.loginForm.controls).forEach((key) => {
        const controlErrors = this.loginForm.get(key)?.errors;
        if (controlErrors) {
          console.log(`Lỗi trong trường ${key}:`, controlErrors);
        }
      });
      return;
    } else {
      console.log('Form data', this.loginForm.value);
      this.login.login(this.loginForm.value).subscribe({
        next: () => {
          this.router.navigate(['/signup']);
          alert('Login success');
        },
        error: (error) => {
          console.error('Login failed', error);
          if (error.status === 401) {
            alert('Unauthorized: Please check your authorized');
          } else {
            alert('Login Fail !');
          }
        },
      });
    }
  }
  //Validate function
  getUserNameError() {
    if (this.loginForm.get('username')?.hasError('required')) {
      return 'Email or phone is required.';
    }
    return '';
  }

  getPasswordError() {
    if (this.loginForm.get('password')?.hasError('required')) {
      return 'Password is required';
    }
    return '';
  }
}
