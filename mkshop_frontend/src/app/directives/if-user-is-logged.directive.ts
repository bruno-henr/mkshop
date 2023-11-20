import {
  Directive,
  ElementRef,
  OnDestroy,
  OnInit,
  Renderer2,
} from '@angular/core';
import { UserService } from '../services/user/user-service.service';
import { Subscription } from 'rxjs';

@Directive({
  selector: '[ifUserIsLogged]',
})
export class IfUserIsLoggedDirective implements OnInit, OnDestroy {
  constructor(
    private userService: UserService,
    private renderer: Renderer2,
    private hostElement: ElementRef
  ) {}

  subscription: Subscription | undefined;
  displayHost: string | undefined;

  ngOnInit(): void {
    this.displayHost = this.hostElement.nativeElement.style.display;
    
    this.subscription = this.userService.getUserIfLogged().subscribe((data) => {
      this.renderer.setStyle(
        this.hostElement.nativeElement,
        'display',
        data ? this.displayHost : 'none'
      );
    });
  }

  ngOnDestroy(): void {
    this.subscription?.unsubscribe();
  }
}
