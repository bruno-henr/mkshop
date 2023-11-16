import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRequestsHeaderComponent } from './user-requests-header.component';

describe('UserRequestsHeaderComponent', () => {
  let component: UserRequestsHeaderComponent;
  let fixture: ComponentFixture<UserRequestsHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserRequestsHeaderComponent]
    });
    fixture = TestBed.createComponent(UserRequestsHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
