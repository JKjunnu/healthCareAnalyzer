import { Component, ChangeDetectionStrategy } from '@angular/core';
import { AxiosService } from '../axios.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { OnInit } from '@angular/core';


@Component({
  selector: 'app-dash-board-content',
  templateUrl: './dash-board-content.component.html',
  styleUrls: ['./dash-board-content.component.css'],
  changeDetection: ChangeDetectionStrategy.Default
})
export class DashBoardContentComponent {
  active: string = "";

  constructor(private axiosService: AxiosService) { }

  page = 1;
  count = 0;
  tableSize = 10;
  tableSizes = [5, 10, 15, 20];

  onTableDataChange(event: any) {
    this.page = event;

  }

  onTableSizeChange(event: any): void {
    this.tableSize = event.target.value;
    this.page = 1;
  }




  firstName: string = this.axiosService.firstName;
  lastName: string = this.axiosService.lastName;
  roles: string = this.axiosService.roles;

  column: any = null;
  chartType: any = 'vb';
  data: any = null;


  // options
  showXAxis = false;
  showYAxis = false;
  gradient = false;
  showLegend = false;
  showXAxisLabel = false;
  xAxisLabel: any = 'Patients';
  showYAxisLabel = false;
  yAxisLabel: any = 'Patients';

  colorScheme: Color = {
    name: 'myScheme',
    selectable: true,
    group: ScaleType.Ordinal,
    domain: [
      "#3498db", // Blue
      "#2ecc71", // Green
      "#e74c3c", // Red
      "#f39c12", // Orange
      "#9b59b6", // Purple
      "#16a085", // Turquoise
      "#e67e22", // Tangerine
      "#2c3e50", // Charcoal
      "#1abc9c", // Teal
      "#c0392b",  // Maroon
      "#27ae60", // Nephritis
      "#d35400", // Pumpkin
      "#8e44ad", // Wisteria
      "#2980b9", // Belize Hole
      "#f1c40f", // Sunflower
      "#7f8c8d", // Silver
      "#d35400", // Pumpkin
      "#27ae60", // Nephritis
      "#e74c3c", // Alizarin
      "#3498db"  // Peter River
    ]
    ,
  };

  showLabels: boolean = true;
  isDoughnut: boolean = false;
  legendPosition: string = 'below';

  tableHeadList: string[] = ['Id', 'First Name', 'Last Name', 'Email', 'Age', 'Sex', 'Chest Pain Type', 'Resting Blood Pressure', 'Serum Cholesterol', 'Fasting Blood Sugar', 'Resting Electrocardiographic Results', 'Maximum Heart Rate Achieved', 'Exercise-Induced Angina', 'Oldpeak(ST Depression)', 'Slope of Peak Exercise ST Segment', 'Number of Major Vessels Colored by Fluoroscopy', 'Thalassemia', 'Target'];

  allPatientData: any = null;

  onSelect(event: any) {
    console.log(event);
  }

  onPatientInfoTab(): void {
    this.active = "patient";

    this.allPatientData = this.axiosService.allPatientData;


  }

  onAnalyticsTab(): void {
    this.active = "analytics";
  }

  onUploadTab(): void {
    this.active = "upload";
  }

  onAcademicCellChairTab(): void {
    this.active = "academic";
  }

  onRegisterAdmin(): void {
    this.active = "registerAdmin";
  }

  onChangeXVariable(column: string) {
    this.column = column;
  }

  setColumn: any = null;

  onChangeGraphType(chartType: string) {
    this.chartType = chartType;

    if (chartType == 'hb') {
      if (this.yAxisLabel == 'Patients') {
        this.yAxisLabel = this.setColumn
        this.xAxisLabel = 'Patients'
      }
    }
    if (chartType == 'vb') {
      if (this.xAxisLabel == 'Patients') {
        this.yAxisLabel = 'Patients'
        this.xAxisLabel = this.setColumn
      }
    }


  }



  onSubmitAnalytics(): void {


    this.axiosService.request(
      "POST",
      "/analytics",
      {
        columnName: this.column
      }
    ).then(
      response => {
        this.data = response.data.array;
        this.setColumn = this.column;
        if (this.chartType == 'vb') {
          this.xAxisLabel = this.setColumn
        }
        else if (this.chartType == 'hb') {
          this.yAxisLabel = this.setColumn
        }

        this.showXAxis = true;
        this.showYAxis = true;
        this.gradient = false;
        this.showLegend = true;
        this.showXAxisLabel = true;
        this.showYAxisLabel = true;


      }).catch(
        error => {

        });

  }

  onSubmitPatient(): void {


    this.axiosService.request(
      "GET",
      "/analytics",
      {
        columnName: this.column
      }
    ).then(
      response => {


      }).catch(
        error => {

        });

  }

  adminFirstName: any = null;
  adminLastName: any = null;
  adminEmail: any = null;
  adminPassword: any = null;

  onSubmitRegisterAdmin() {

    this.axiosService.request(
      "POST",
      "/register/admin",
      {
        firstName: this.adminFirstName,
        lastName: this.adminLastName,
        email: this.adminEmail,
        password: this.adminPassword
      }
    ).then(
      response => {

        if (response.data == "Admin added successfully") {
          alert("Admin Registered Successfully");
        }




      }).catch(
        error => {

        });
  }




}
