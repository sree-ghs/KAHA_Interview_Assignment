import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { serviceUrl } from '../data-model/data.constant';

@Injectable({
  providedIn: 'root'
})
export class HomePageService {

  public passDataToDetailsViewEmmiter = new EventEmitter();
  public dateList: string[] = [];
  public totalCaseNoList: number[] = [];
  public stateName = '';

  public currentStateDetails;

  constructor(private http: HttpClient) { }

  public fetchData() {
    return this.http.get(serviceUrl.dataFetchUrl);
  }
}
