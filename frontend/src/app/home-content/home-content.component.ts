import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { LoginFormComponent } from '../login-form/login-form.component';

@Component({
  selector: 'app-home-content',
  templateUrl: './home-content.component.html',
  styleUrls: ['./home-content.component.css']
})
export class HomeContentComponent {

  componentToShow: string = "login";
  isActive: boolean = false;
  isLogin: boolean = false;


  constructor(private axiosService: AxiosService) { }

  showComponent(componentToShow: string): void {
    this.componentToShow = componentToShow;
  }

  changeIsLogin(componentToShow: string): void {
    this.componentToShow = componentToShow;
    this.isLogin = false;
  }

  onLogin(input: any): void {


    this.axiosService.request(
      "POST",
      "/login/auth",
      {
        email: input.email,
        password: input.password
      }
    ).then(
      response => {
        this.axiosService.setAuthToken(response.data.token);
        this.isLogin = true;
        this.axiosService.setUserDetails(response.data.firstName, response.data.lastName, response.data.roles);
        this.componentToShow = "dashboard";
      }).catch(
        error => {
          this.axiosService.setAuthToken(null);
          this.componentToShow = "login";
        });

    this.axiosService.request(
      "GET",
      "/analytics/patients",
      {

      }
    ).then(
      response => {
        this.axiosService.allPatientData = response.data;

      }).catch(
        error => {

        });

  }

  onRegister(input: any): void {


    this.axiosService.request(
      "POST",
      "/register",
      {
        firstName: input.firstName,
        lastName: input.lastName,
        email: input.email,
        password: input.password

      }
    ).then(
      response => {
        // this.axiosService.setAuthToken(response.data);
        // this.isActive = response.data.enabled;
        this.componentToShow = "login";
        alert('Registered Successfully');
      }).catch(
        error => {
          this.axiosService.setAuthToken(null);
          this.componentToShow = "login";
        }
      );

  }



}
