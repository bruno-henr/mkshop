import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowMainBransComponent } from './show-main-brans.component';

describe('ShowMainBransComponent', () => {
  let component: ShowMainBransComponent;
  let fixture: ComponentFixture<ShowMainBransComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowMainBransComponent]
    });
    fixture = TestBed.createComponent(ShowMainBransComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
