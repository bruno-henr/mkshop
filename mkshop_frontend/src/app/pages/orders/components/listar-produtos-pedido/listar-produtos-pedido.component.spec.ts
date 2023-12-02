import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarProdutosPedidoComponent } from './listar-produtos-pedido.component';

describe('ListarProdutosPedidoComponent', () => {
  let component: ListarProdutosPedidoComponent;
  let fixture: ComponentFixture<ListarProdutosPedidoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarProdutosPedidoComponent]
    });
    fixture = TestBed.createComponent(ListarProdutosPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
