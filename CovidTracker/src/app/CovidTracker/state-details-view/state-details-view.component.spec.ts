import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StateDetailsViewComponent } from './state-details-view.component';

describe('StateDetailsViewComponent', () => {
  let component: StateDetailsViewComponent;
  let fixture: ComponentFixture<StateDetailsViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StateDetailsViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StateDetailsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
