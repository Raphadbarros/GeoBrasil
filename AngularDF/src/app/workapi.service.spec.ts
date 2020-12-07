import { TestBed } from '@angular/core/testing';

import { WorkapiService } from './workapi.service';

describe('WorkapiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorkapiService = TestBed.get(WorkapiService);
    expect(service).toBeTruthy();
  });
});
