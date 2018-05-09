import { Component, OnInit } from '@angular/core';
import { HttpModule } from '@angular/http';
import { Moneyexchange } from '../../model/moneyexchange';
import { ExchangeService } from '../../service/exchangeService';
import { Injectable }from '@angular/core';
import { HttpClient, HttpHeaders }from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { catchError, tap } from 'rxjs/operators';
import {of} from "rxjs/observable/of";


@Component({
  selector: 'app-moneyexchangecomponent',
  templateUrl: './moneyexchangecomponent.component.html',
  styleUrls: ['./moneyexchangecomponent.component.css']
})
export class MoneyexchangecomponentComponent implements OnInit {
  moneyexchange: Moneyexchange;
  exchangeService:ExchangeService;
  buttonlabel='Calculate';
  constructor(private http: HttpClient) { 
  }

  ngOnInit() {
    this.moneyexchange=new Moneyexchange();
    this.exchangeService=new ExchangeService(this.http);
    this.moneyexchange.fromCurrency='USD';
    this.moneyexchange.toCurrency='EUR';
  }
  
  calculate(){
   this.exchangeService.exhangeCurrency(this.moneyexchange);
  }

}
