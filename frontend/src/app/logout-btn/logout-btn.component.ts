import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-logout-btn',
  templateUrl: './logout-btn.component.html',
  styleUrls: ['./logout-btn.component.css']
})
export class LogoutBtnComponent {

  @Output() logoutEvent = new EventEmitter();

}
