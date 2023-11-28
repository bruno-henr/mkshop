import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerAddressComponent } from './manager-address.component';

describe('ManagerAddressComponent', () => {
  let component: ManagerAddressComponent;
  let fixture: ComponentFixture<ManagerAddressComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManagerAddressComponent]
    });
    fixture = TestBed.createComponent(ManagerAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
