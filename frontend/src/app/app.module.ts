import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon'
import { MatListModule } from '@angular/material/list'
import { MatSidenavModule } from '@angular/material/sidenav'
import { NgxPaginationModule } from 'ngx-pagination';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AuthContentComponent } from './auth-content/auth-content.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { HomeContentComponent } from './home-content/home-content.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { HttpClientModule } from '@angular/common/http';
import { DashBoardContentComponent } from './dash-board-content/dash-board-content.component';
import { LogoutBtnComponent } from './logout-btn/logout-btn.component';
import { NavbarComponent } from './navbar/navbar.component';

import { NgxChartsModule } from '@swimlane/ngx-charts';
import { PatientTableComponent } from './patient-table/patient-table.component';
import { PaginationComponent } from './pagination/pagination.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthContentComponent,
    WelcomeContentComponent,
    LoginFormComponent,
    HomeContentComponent,
    ButtonsComponent,
    DashBoardContentComponent,
    LogoutBtnComponent,
    NavbarComponent,
    PatientTableComponent,
    PaginationComponent,


  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatSidenavModule,
    NgxChartsModule,
    CommonModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
