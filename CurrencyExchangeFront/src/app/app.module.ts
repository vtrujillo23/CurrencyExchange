import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { Injectable }from '@angular/core';
import { HttpClient, HttpHeaders }from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { catchError, tap } from 'rxjs/operators';
import {of} from "rxjs/observable/of";
import { MoneyexchangecomponentComponent } from './exchangeCalculator/components/moneyexchangecomponent/moneyexchangecomponent.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MoneyexchangecomponentComponent
  ],
  imports: [
     BrowserModule,
     FormsModule,
     HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
