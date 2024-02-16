import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent } from '@angular/common/http';
import { Observable, last } from 'rxjs';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  private server = 'http://localhost:8080';

  allPatientData: any = null;
  isLogin: boolean = false;

  firstName: string = "";
  lastName: string = "";
  roles: string = "";
  componentToShow: string = "login";

  constructor(private http: HttpClient) {
    axios.defaults.baseURL = 'http://localhost:8080'
    axios.defaults.headers.post["Content-Type"] = 'application/json'
  }

  getAuthToken(): string | null {
    return window.localStorage.getItem("auth_token");
  }

  setAuthToken(token: string | null): void {
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
  }

  request(method: string, url: string, data: any): Promise<any> {
    let headers: any = {};

    if (this.getAuthToken() !== null) {
      headers = { "Authorization": "Bearer " + this.getAuthToken() };
    }

    return axios({
      method: method,
      url: url,
      data: data,
      headers: headers
    });
  }

  requestFile(method: string, url: string, data: any): Promise<any> {
    let headers: any = {};

    if (this.getAuthToken() !== null) {
      headers = { "Authorization": "Bearer " + this.getAuthToken(), "Content-Type": "multipart/form-data" };
    }

    return axios({
      method: method,
      url: url,
      data: data,
      headers: headers
    });
  }

  setUserDetails(firstName: string, lastName: string, roles: string): any {
    this.firstName = firstName;
    this.lastName = lastName;
    this.roles = roles;
  }




}
