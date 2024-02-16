import { Component, EventEmitter, Output } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})
export class ButtonsComponent {



  @Output() loginEvent = new EventEmitter();


  constructor(private axiosService: AxiosService) { }


}
