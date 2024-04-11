import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssetCreationComponent } from './asset-creation.component';

describe('AssetCreationComponent', () => {
  let component: AssetCreationComponent;
  let fixture: ComponentFixture<AssetCreationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssetCreationComponent]
    });
    fixture = TestBed.createComponent(AssetCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
