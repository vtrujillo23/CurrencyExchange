
import { Moneyexchange } from '../model/moneyexchange';
import { Error } from '../model/error';
import { MoneyExchangeResponse } from '../model/moneyExchangeResponse';
import { MoneyExchangeReq } from '../model/moneyExchangeReq';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ExchangeService {
  restUrl='http://localhost:8082/exchange';
  moneyExchangeResponse:MoneyExchangeResponse;
  moneyExchangeReq:MoneyExchangeReq;
  
  constructor(private http: HttpClient){
    
  }
  
  exhangeCurrency(moneyexchange:Moneyexchange){
    moneyexchange.toAmmount='652000';
  }
}