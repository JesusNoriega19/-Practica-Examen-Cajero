import { TestBed } from '@angular/core/testing';

import { CajeroService } from './cajero.service';

describe('CajeroServiceService', () => {
  let service: CajeroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CajeroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
