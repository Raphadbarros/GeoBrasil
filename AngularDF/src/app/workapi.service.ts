import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http'
import { catchError, tap, map } from 'rxjs/operators';
import { Estados } from 'src/model/Estados.Entities';
import { Cidades } from 'src/Model/Cidades.Entities';


const httpOptions ={  headers: new HttpHeaders({'Contnt-Type' : 'application/json'})};


@Injectable({
  providedIn: 'root'
})
export class WorkapiService {
  
  private apiUrl = 'http://localhost:8080/api'
  constructor(private http: HttpClient) { }

getAllEstados(): Observable<Array<Estados>> {
    return this.http.get<Array<Estados>>(this.apiUrl+'/estados',httpOptions);

}

getEstadoId(id: string) {
  return this.http.get(this.apiUrl + id);
}

getAllCidades(): Observable<Array<Cidades>> {
  return this.http.get<Array<Cidades>>(this.apiUrl+'/cidades/',httpOptions);

}

getCidadeId(id: string) {
  return this.http.get(this.apiUrl + id);
}
   
onSubmit(cidades:Cidades) {
  return this.http.post<Cidades>(this.apiUrl+'/cidades', console.log(JSON.stringify(cidades),httpOptions))
}


addCidade (cidade): Observable<Cidades> {
  return this.http.post<Cidades>(this.apiUrl+'/cidade', cidade, httpOptions).pipe(
      tap((cidade: Cidades) => console.log(`adicionou o produto com w/ id=${cidade.nomeCidades}`))

  );
 }
}


