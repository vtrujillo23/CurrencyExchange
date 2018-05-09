import { Error } from './error';
export class MoneyExchangeResponse {
   fromAmmount:string;
   fromCurrency:string;
   toCurrency:string;
   toAmmount:string;
   errors:Error[];
}