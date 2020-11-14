import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-state-view',
  templateUrl: './state-view.component.html',
  styleUrls: ['./state-view.component.css']
})
export class StateViewComponent implements OnInit {

  @Input() stateDate: any;

  public newCases: number;


  constructor() { }

  ngOnInit() {

    if (this.stateDate && this.stateDate.latestInfo && this.stateDate.latestInfo.delta) {
      if (this.stateDate.latestInfo.delta.confirmed) {
        this.newCases = this.stateDate.latestInfo.delta.confirmed;
      } else {
        this.newCases = 0;
      }
    } else {
      this.newCases = 0;
    }

  }

}
