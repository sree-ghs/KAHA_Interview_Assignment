import { HomePageService } from './home-page.service';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public fetchedData: any;
  public stateNameList: string[];
  public stateTodayDataList: any[] = [];
  public items = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  public sortClickedTimes = 0;
  constructor(
    private homePageService: HomePageService,
    private datePipe: DatePipe,
    private route: Router) { }

  ngOnInit() {
    this.homePageService.fetchData().subscribe(data => {
      this.fetchedData = data;
      this.stateNameList = Object.keys(this.fetchedData);
      const todayDate = new Date();
      const yesterdayDate = new Date().setDate(todayDate.getDate() - 1);
      const todayDateString = this.datePipe.transform(todayDate, 'yyyy-MM-dd');
      const yesterdayDateString = this.datePipe.transform(yesterdayDate, 'yyyy-MM-dd');

      this.stateNameList.forEach(state => {
          let latestData;
          if (this.fetchedData[state].dates[todayDateString] !== undefined) {
            latestData = this.fetchedData[state].dates[todayDateString];
          } else {
            latestData = this.fetchedData[state].dates[yesterdayDateString];
          }
          const obj = {
            name : state,
            latestInfo : latestData,
            allInfo: this.fetchedData[state]
          };
          if (obj.name !== 'TT' && obj.name !== 'UN') {
          this.stateTodayDataList.push(obj);
          }
      });
      console.log(this.stateTodayDataList);
      this.stateTodayDataList.sort((a, b) => (a.name > b.name) ? 1 : -1);
      console.log(this.stateTodayDataList);
    });
  }


  openStateGraph(data: any) {
    console.log('open state ');
    console.log(data);
    this.homePageService.currentStateDetails = data;
    this.route.navigateByUrl('state-graph');
  }


  sortArray() {
    console.log('sortArray-', this.sortClickedTimes);
    if (this.sortClickedTimes === 2) {
      this.sortClickedTimes = 0;
    } else {
      this.sortClickedTimes ++;
    }

    if (this.sortClickedTimes === 0) {
      this.stateTodayDataList.sort((a, b) => (a.name > b.name) ? 1 : -1);
    } else if (this.sortClickedTimes === 1) {
      this.stateTodayDataList.sort((a, b) => (a.latestInfo.total.confirmed > b.latestInfo.total.confirmed) ? 1 : -1);
    } else {
      this.stateTodayDataList.sort((a, b) => (a.latestInfo.total.confirmed < b.latestInfo.total.confirmed) ? 1 : -1);
    }
  }
}
