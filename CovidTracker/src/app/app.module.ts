import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './CovidTracker/home-page/home-page.component';
import { StateDetailsViewComponent } from './CovidTracker/state-details-view/state-details-view.component';
import { StateViewComponent } from './CovidTracker/home-page/state-view/state-view.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { ChartsModule, ThemeService } from 'ng2-charts';
import { StateNamePipe } from './CovidTracker/pipe/state-name.pipe';
import { AngularFontAwesomeModule } from 'angular-font-awesome/dist';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    StateViewComponent,
    StateDetailsViewComponent,
    StateNamePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    AngularFontAwesomeModule
  ],
  providers: [DatePipe, ThemeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
