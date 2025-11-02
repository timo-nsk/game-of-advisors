import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemaDetailsComponent } from './thema-details.component';

describe('ThemaDetailsComponent', () => {
  let component: ThemaDetailsComponent;
  let fixture: ComponentFixture<ThemaDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemaDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
