import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
onLogout() {
throw new Error('Method not implemented.');
}
  title = 'MesProduits';
  
  constructor(public authService: AuthService) { }
}
