# Testing strategy

The private product uses layered testing. This public extract includes safe representative examples:

- backend unit test for session creation and persistence;
- frontend unit test for mutation ordering and acknowledgement;
- CI that tests Java and typechecks, tests, and builds TypeScript.

Production acceptance, security verification, payment testing, device matrices, and operational deployment checks are intentionally not published.
