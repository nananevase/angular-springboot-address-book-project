import { Injectable } from '@angular/core';
import { Contacts } from '../models/common';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) { }

  getContacts() {
    return this.sendGetRequest('/api/addressBook/getContacts');
  }

  addContacts(contact: Contacts){
    return this.sendPostRequest('/api/addressBook/createContact', contact);
  }

  updateContacts(contact: Contacts){
    return this.sendPutRequest('/api/addressBook/updateContact/'+contact.id, contact);
  }

  deleteContact(contact: Contacts) {
    return this.sendDeleteRequest('/api/addressBook/deleteContact/'+contact.id);
  }

  private sendGetRequest(path: string): Observable<any> {
    const url = this.getFullUrl(path);
    const headers = new HttpHeaders({ 'Content-Type': 'text/plain', 'Accept': 'application/json' });
    const httpOptions = { headers };
    return this.http.get(url, httpOptions);
  }

  private sendPostRequest(path: string, data: Object): Observable<any> {
    const url = this.getFullUrl(path);
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
    const httpOptions = { headers };
    return this.http.post(url, JSON.stringify(data), httpOptions);
  }

  private sendPutRequest(path: string, data: Object): Observable<any> {
    const url = this.getFullUrl(path);
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
    const httpOptions = { headers };
    return this.http.put(url, JSON.stringify(data), httpOptions);
  }

  private sendDeleteRequest(path: string): Observable<any> {
    const url = this.getFullUrl(path);
    const headers = new HttpHeaders({ 'Content-Type': 'text/plain', 'Accept': 'application/json' });
    const httpOptions = { headers };
    return this.http.delete(url, httpOptions);
  }

  private getFullUrl(path: string) {
    return `${environment.apiUrl}${path}`;
  }

}
