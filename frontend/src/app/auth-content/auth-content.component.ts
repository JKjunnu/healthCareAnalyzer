import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-auth-content',
  templateUrl: './auth-content.component.html',
  styleUrls: ['./auth-content.component.css']
})
export class AuthContentComponent {
  data: string[] = [];

  // Variable to store shortLink from api response
  // shortLink: string = "";
  // loading: boolean = false; // Flag variable
  // file: File ; // Variable to store file
  // file = new File(["foo"], "foo.txt", {
  //   type: "text/plain",
  // });

  file: any = null;

  constructor(private axiosService: AxiosService) { }

  // ngOnInit(): void {
  //   this.axiosService.request(
  //     "GET",
  //     "/messages",
  //     {}
  //   ).then(
  //     (response) => {
  //         this.data = response.data;
  //     }).catch(
  //     (error) => {
  //         if (error.response.status === 401) {
  //             this.axiosService.setAuthToken(null);
  //         } else {
  //             this.data = error.response.code;
  //         }

  //     }
  // );
  // }


  onChange(event: any) {
    if (event.target.value == null) {
      this.file = null;
    }
    else if (event.target.files[0].type == 'text/csv') {
      this.file = event.target.files[0];
    } else {
      this.file = null;
    }

  }

  onUpload(): void {

    // this.loading = !this.loading;
    // console.log(this.file);

    if (this.file == null) {
      alert('Please select a valid file')
      return
    }

    const formData = new FormData();

    // Store form name as "file" with file data

    formData.append("file", this.file, this.file.name);




    this.axiosService.requestFile(
      "POST",
      "/analytics/upload",
      formData
    ).then(
      response => {
        if (response.data == 'Saved Successfully') {


        }

      }).catch(
        (error) => {
          if (error.response.status === 401) {
            this.axiosService.setAuthToken(null);
          } else {
            this.data = error.response.code;
          }

        }
      );

    this.axiosService.request(
      "GET",
      "/analytics/patients",
      {

      }
    ).then(
      response => {
        this.axiosService.allPatientData = response.data;

        alert('Saved Successfully');

      }).catch(
        error => {

        });
  }

}







// OnClick of button Upload
// onUpload() {
//     this.loading = !this.loading;
//     console.log(this.file);
//     this.axiosService.upload(this.file).subscribe(
//         (event: any) => {
//             if (typeof (event) === 'object') {

//                 // Short link via api response
//                 this.shortLink = event.link;

//                 this.loading = false; // Flag variable
//             }
//         }
//     );
// }




