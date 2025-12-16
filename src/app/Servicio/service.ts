import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service {
  // URL del Backend
  private url ='http://localhost:9007/UsuariosWS';

  constructor(private http: HttpClient){};

  // 1. Listar
  listar(): Observable<any>{
    return this.http.get(`${this.url}/listar`); // <--- OJO: Comillas invertidas ``
  }

  // 2. Guardar
  guardar(usuario: any): Observable<any> {
    return this.http.post(`${this.url}/guardar`, usuario);
  }

  // 3. Editar
  editar(usuario: any): Observable<any> {
    return this.http.put(`${this.url}/editar`, usuario);
  }

  // 4. Eliminar
  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.url}/eliminar/${id}`);
  }

  // 5. Buscar (Opcional)
  buscar(id: number): Observable<any> {
    return this.http.get(`${this.url}/buscar/${id}`);
  }
}