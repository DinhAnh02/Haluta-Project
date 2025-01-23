import { SignupService } from './../../service/auth/signup/signup.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  standalone: false,
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss',
})
export class SignupComponent {
  signUpForm: FormGroup;
  constructor(private router: Router, private signup: SignupService) {
    this.signUpForm = new FormGroup({
      customer_name: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
        Validators.pattern('^[a-zA-Z0-9]+$'),
      ]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
        Validators.pattern('^[a-zA-Z0-9]+$'),
      ]),
      again_password: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
        Validators.pattern('^[a-zA-Z0-9]+$'),
      ]),
      phone: new FormControl('', [
        Validators.required,
        Validators.minLength(9),
        Validators.pattern('^\\d{9,}$'),
      ]),
      full_name: new FormControl('', [
        Validators.required,
        Validators.minLength(15),
        Validators.pattern('^[A-Za-zÀ-ỹ\\s]{1,255}$'),
      ]),
    });
  }
  //Event Action
  onSubmit() {
    if (this.signUpForm.invalid) {
      console.log('Form Invalid', this.signUpForm.errors);
      Object.keys(this.signUpForm.controls).forEach((key) => {
        const controlErrors = this.signUpForm.get(key)?.errors;
        if (controlErrors) {
          console.log(`Lỗi trong trường ${key}:`, controlErrors);
        }
      });
      return;
    } else {
      console.log('Form data', this.signUpForm.value);
      this.signup.signup(this.signUpForm.value).subscribe({
        next: () => {
          this.router.navigate(['/signin']);
          alert('Sign up success');
        },
        error: (error) => {
          console.error('Sign up failed', error);
          if (error.status === 401) {
            alert('Unauthorized: Please check your authorized');
          } else {
            alert('Sign Up Fail !');
          }
        },
      });
    }
  }
  //Validate function
  getFullNameError() {
    if (this.signUpForm.get('full_name')?.hasError('required')) {
      return 'Full name is required.';
    } else if (this.signUpForm.get('full_name')?.hasError('minlength')) {
      return 'Full name must be at least 15 characters.';
    } else if (this.signUpForm.get('full_name')?.hasError('pattern')) {
      return 'Full name must contain only uppercase, lowercase letters, and whitespace.';
    }
    return '';
  }

  getCustomerNameError() {
    if (this.signUpForm.get('customer_name')?.hasError('required')) {
      return 'Customer name is required';
    } else if (this.signUpForm.get('customer_name')?.hasError('minlength')) {
      return '"Customer must be 8 characters long"';
    } else if (this.signUpForm.get('customer_name')?.hasError('pattern')) {
      return 'Username must contain upppercase, lowercase letters and numbers, special symbol';
    }
    return '';
  }
}
