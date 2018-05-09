import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoneyexchangecomponentComponent } from './moneyexchangecomponent.component';

describe('MoneyexchangecomponentComponent', () => {
  let component: MoneyexchangecomponentComponent;
  let fixture: ComponentFixture<MoneyexchangecomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoneyexchangecomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoneyexchangecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
