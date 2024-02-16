import { Component, EventEmitter, Output } from '@angular/core';
import { AxiosService } from '../axios.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isNavbarCollapsed: boolean = false;

  @Output() loginEvent = new EventEmitter();

  @Output() logoutEvent = new EventEmitter();

  constructor(private axiosService: AxiosService) { }

  onClick() {

    this.axiosService.componentToShow = 'login';

  }

}
