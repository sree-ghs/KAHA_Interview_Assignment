import { HomePageService } from './../home-page/home-page.service';
import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-state-details-view',
  templateUrl: './state-details-view.component.html',
  styleUrls: ['./state-details-view.component.css']
})
export class StateDetailsViewComponent implements OnInit {

  public stateName  = '';
  public viewChart = false;

  public lineChartData: ChartDataSets[];
  public lineChartLabels: Label[] ;
  public lineChartOptions: (ChartOptions & { annotation: any }) = {
    responsive: true,
    annotation: true
  };
  public lineChartLegend = true;
  public lineChartType = 'line';
  constructor(public homePageService: HomePageService) {

   }

  ngOnInit() {
    console.log('ngOnInit');
    this.showByTotal();
  }

  showByTotal() {
    const data = this.homePageService.currentStateDetails;
    this.stateName = data.name;
    const dateList = Object.keys(data.allInfo.dates);
    let totalCaseNo;
    const totalCaseNoList = [];
    dateList.forEach(element => {
        if (data.allInfo.dates[element].total.confirmed !== null && data.allInfo.dates[element].total.confirmed !== undefined) {
          totalCaseNo = data.allInfo.dates[element].total.confirmed;
        } else {
          totalCaseNo = 0;
        }
        totalCaseNoList.push(totalCaseNo);
      });
    this.lineChartLabels = dateList;
    this.lineChartData  = [
        { data: totalCaseNoList, label: 'Date vs Total Count',
       },
      ];
    console.log(dateList);
    console.log(totalCaseNoList);
    this.viewChart = true;
  }

  showByRecovered() {
    const data = this.homePageService.currentStateDetails;
    const dateList = Object.keys(data.allInfo.dates);
    let totalCaseNo;
    const totalCaseNoList = [];
    dateList.forEach(element => {
        if (data.allInfo.dates[element].total.recovered !== null && data.allInfo.dates[element].total.recovered !== undefined) {
          totalCaseNo = data.allInfo.dates[element].total.recovered;
        } else {
          totalCaseNo = 0;
        }
        totalCaseNoList.push(totalCaseNo);
      });
    this.lineChartLabels = dateList;
    this.lineChartData  = [
        { data: totalCaseNoList, label: 'Date vs Recovered Count',
       },
      ];
    this.viewChart = true;
  }

  showByDeceased() {
    const data = this.homePageService.currentStateDetails;
    const dateList = Object.keys(data.allInfo.dates);
    let totalCaseNo;
    const totalCaseNoList = [];
    dateList.forEach(element => {
        if (data.allInfo.dates[element].total.deceased !== null && data.allInfo.dates[element].total.deceased !== undefined) {
          totalCaseNo = data.allInfo.dates[element].total.deceased;
        } else {
          totalCaseNo = 0;
        }
        totalCaseNoList.push(totalCaseNo);
      });
    this.lineChartLabels = dateList;
    this.lineChartData  = [
        { data: totalCaseNoList, label: 'Date vs Deceased Count',
       },
      ];
    this.viewChart = true;
  }

}
