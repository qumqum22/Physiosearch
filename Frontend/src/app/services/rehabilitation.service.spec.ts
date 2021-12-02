import { TestBed } from '@angular/core/testing';

import { RehabilitationService } from './rehabilitation.service';

describe('RehabilitationService', () => {
  let service: RehabilitationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RehabilitationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
