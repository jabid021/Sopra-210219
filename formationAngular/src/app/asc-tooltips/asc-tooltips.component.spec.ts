import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscTooltipsComponent } from './asc-tooltips.component';

describe('AscTooltipsComponent', () => {
  let component: AscTooltipsComponent;
  let fixture: ComponentFixture<AscTooltipsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AscTooltipsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AscTooltipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
