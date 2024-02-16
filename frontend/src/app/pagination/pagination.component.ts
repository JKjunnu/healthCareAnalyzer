import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent {

  @Input() totalItems: any;
  @Input() currentPage: any;
  @Input() itemsPerPage: any;

  totalPages = 0;



}
