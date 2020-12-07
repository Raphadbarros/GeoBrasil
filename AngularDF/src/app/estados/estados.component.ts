import { Component, OnInit } from '@angular/core';
import { Estados } from 'src/Model/Estados.Entities';
import { WorkapiService } from 'src/app/workapi.service';
import {Observable} from 'rxjs';
import {debounceTime, distinctUntilChanged, map} from 'rxjs/operators';


@Component({
  selector: 'app-estados',
  templateUrl: './estados.component.html',
  styleUrls: ['./estados.component.css']
})
export class EstadosComponent implements OnInit {
  estados: Array<Estados>; 
  constructor(private WorkapiService: WorkapiService ) { }


  idEstado: number; // Declaração da variável (Precisa ter o Mesmo nome da ngModel.).
  //id: number
  onAddCidade(){ // Função que foi chamada
    this.idEstado = +this.idEstado;
    console.log("estou no cidade compo... " + this.idEstado); // Imprimiu o valor no Console log.
    console.log(this.idEstado) // outra forma de imprimir.
  }
 
  ngOnInit() {
  
    this.WorkapiService.getAllEstados().subscribe(data => {
      this.estados = data;
      console.log(this.estados);
      
      return this.estados = data;
  
    })
  }

}



