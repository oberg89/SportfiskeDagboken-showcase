# SportfiskeDagboken / Angler Log — Technical Showcase

SportfiskeDagboken (Angler Log) is a fishing diary application for recording and analyzing fishing sessions, catches, observations, and environmental conditions.

> **This repository is a sanitized portfolio/showcase extract of a larger private production project. Some production, security, billing, infrastructure and proprietary implementation details are intentionally omitted.**

## What this repository demonstrates

- Java 21 and Spring Boot API layering: controller, validation, service, persistence boundary, and API error handling.
- PostgreSQL/Flyway-oriented data modelling through a deliberately small fishing-session example.
- TypeScript/Vite frontend organization with an API boundary, a small offline mutation queue, and focused tests.
- A pragmatic testing approach: backend unit tests, frontend unit tests, and a safe CI build.
- Product thinking around resilient session capture without publishing production internals.

The production application is intentionally **not** included here. This is neither a deployment repository nor a complete product clone.

## Technology

- Java 21, Spring Boot, Spring Validation, Spring Data JPA
- PostgreSQL and Flyway (represented by a safe sample migration)
- TypeScript, Vite, Vitest, browser storage APIs
- Docker is part of the broader private system; no production Docker configuration is published here

The production frontend uses TypeScript and Vite. This showcase mirrors that architecture with a compact, framework-light sample rather than claiming a React implementation.

## Structure

```text
backend/     Spring Boot session API showcase and unit test
frontend/    TypeScript/Vite UI, API client, offline queue, and unit test
docs/        Architecture, backend, frontend, offline, and testing notes
.github/     Safe build-and-test CI only
```

## My work

This showcase highlights full-stack engineering practices used in the project: modelling a user-owned domain, designing validation and error contracts, keeping browser/API boundaries explicit, designing for offline recovery, and verifying behavior with focused automated tests. It deliberately avoids claims about team roles, customer data, or the private production deployment.

## Running the showcase

The modules are intentionally small and independent:

```bash
cd backend
mvn test
```

```bash
cd frontend
npm install
npm test
npm run build
```

See [Architecture](docs/ARCHITECTURE.md) for the high-level design and the scope boundaries.

## Status

This is a public portfolio repository for technical review. It is not the production deployment source and does not accept production configuration or customer data.
