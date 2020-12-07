import { Component, OnInit } from '@angular/core';
import { Cidades } from 'src/Model/Cidades.Entities';
import { WorkapiService } from 'src/app/workapi.service';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http'
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';

@Component({
  selector: 'app-cidades',
  templateUrl: './cidades.component.html',
  styleUrls: ['./cidades.component.css']
  
})
export class CidadesComponent implements OnInit {
 
  CidadeForm = this.formBuilder.group({
    'id':[null],
    'nomeCidades' : [null],
    
  });

  cidade= {} as Cidades;
  cidades: Cidades[];

    constructor(private WorkapiService: WorkapiService,private formBuilder: FormBuilder) { }

    ngOnInit() {

     
    this.getCidades();
  }

  getCidades() {
      this.WorkapiService.getAllCidades().subscribe((cidades: Cidades[]) => {
        this.cidades = cidades;
      });
    }

    addCidade(form: NgForm) {
      this.WorkapiService.addCidade(form)
        .subscribe(res => {
            const id = res['_id'];
          }, (err) => {
            console.log(err);
          });
    }
  

}
