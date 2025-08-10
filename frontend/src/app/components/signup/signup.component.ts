import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { SignupService } from '../../services/signup.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './signup.component.html'
})
export class SignupComponent {
  signupForm: FormGroup;
  roles = ['MENTOR', 'LEARNER', 'BOTH']; 
  experienceLevels = ['BEGINNER', 'INTERMEDIATE', 'ADVANCED'];

  constructor(private fb: FormBuilder, private authService: SignupService) {
    this.signupForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      firstName: [''],
      lastName: [''],
      bio: [''],
      profilePictureUrl: [''],
      role: ['LEARNER', Validators.required],
      timezone: [''],
      experienceLevel: ['BEGINNER'],
      isAvailable: [false],
      active: [true]
    });
  }

  onSubmit() {
    if (this.signupForm.valid) {
      this.authService.signUp(this.signupForm.value).subscribe({
        next: (res) => console.log('User registered successfully', res),
        error: (err) => console.error('Error during signup', err)
      });
    }
  }
}
