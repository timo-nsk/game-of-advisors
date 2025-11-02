import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemaErstellenComponent } from './thema-erstellen.component';

describe('ThemaErstellenComponent', () => {
  let component: ThemaErstellenComponent;
  let fixture: ComponentFixture<ThemaErstellenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemaErstellenComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemaErstellenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
