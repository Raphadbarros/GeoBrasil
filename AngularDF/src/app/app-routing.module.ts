import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EstadosComponent } from './estados/estados.component';
import { CidadesComponent } from './cidades/cidades.component';

const routes: Routes = [{
  path: 'estados',
  component: EstadosComponent,
  data: { title: 'Estados' }
},
{
  path: 'cidades',
  component: CidadesComponent,
  data: { title: 'Cidades' }
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
