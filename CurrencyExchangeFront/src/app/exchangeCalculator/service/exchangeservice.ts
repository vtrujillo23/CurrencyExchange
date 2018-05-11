
import { Moneyexchange } from '../model/moneyexchange';
import { Error } from '../model/error';
import { MoneyExchangeResponse } from '../model/moneyExchangeResponse';
import { MoneyExchangeReq } from '../model/moneyExchangeReq';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
 const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Origin': '*',
  })
  };



@Injectable()
export class ExchangeService {
 
  restUrl='http://localhost:8082/exchange';
  moneyExchangeResponse:MoneyExchangeResponse;
  
  constructor(private http: HttpClient){
    
  }
  
  exhangeCurrency(moneyexchange:Moneyexchange){
    httpOptions.headers.append('Access-Control-Allow-Origin','*');
    this.http.post<MoneyExchangeResponse>(this.restUrl,{
    fromAmmount: moneyexchange.fromAmmount,
    fromCurrency: moneyexchange.fromCurrency,
    toCurrency: moneyexchange.toCurrency
   },httpOptions).subscribe((data:MoneyExchangeResponse)=>{          
                                                          moneyexchange.toAmmount=data.toAmmount;
                                                          });  
  }
}