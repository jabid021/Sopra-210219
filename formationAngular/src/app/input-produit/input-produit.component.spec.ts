import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputProduitComponent } from './input-produit.component';

describe('InputProduitComponent', () => {
  let component: InputProduitComponent;
  let fixture: ComponentFixture<InputProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InputProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
