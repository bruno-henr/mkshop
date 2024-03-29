import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserInfoHeaderComponent } from './user-info-header.component';

describe('UserInfoHeaderComponent', () => {
  let component: UserInfoHeaderComponent;
  let fixture: ComponentFixture<UserInfoHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserInfoHeaderComponent]
    });
    fixture = TestBed.createComponent(UserInfoHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
