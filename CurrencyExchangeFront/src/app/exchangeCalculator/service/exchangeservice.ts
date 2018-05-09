import { Injectable }from '@angular/core';
import { HttpClient, HttpHeaders }from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { catchError, tap } from 'rxjs/operators';
import {of} from "rxjs/observable/of";

import { Moneyexchange } from '../model/moneyexchange';
import { Error } from '../model/error';
import { MoneyExchangeResponse } from '../model/moneyExchangeResponse';
import { MoneyExchangeReq } from '../model/moneyExchangeReq';

@Injectable()
export class ExchangeService {
  private restUrl='http://localhost:8082/exchange'
  
  constructor(private http: HttpClient){
    
  }
  
  public exhangeCurrency(moneyexchange:Moneyexchange):MoneyExchangeResponse{
    moneyExchangeResponse:MoneyExchangeResponse =new MoneyExchangeResponse();
    return moneyExchangeResponse;
  }
}