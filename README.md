# SportfiskeDagboken / Angler Log — teknisk showcase

[English version](docs/README_EN.md)

SportfiskeDagboken (Angler Log) är en fiskedagbok för att registrera och analysera fiskepass, fångster, observationer och miljöförhållanden.

> **Det här repot är ett sanerat portfolio-/showcase-utdrag ur ett större privat produktionsprojekt. Vissa delar inom produktion, säkerhet, betalning, infrastruktur och proprietär implementation är medvetet utelämnade.**

## Vad repot visar

- Lagerindelning i ett API byggt med Java 21 och Spring Boot: controller, validering, service, persistensgränssnitt och API-felhantering.
- Datamodellering för PostgreSQL och Flyway genom ett avsiktligt begränsat exempel för fiskepass.
- Struktur för en frontend med TypeScript och Vite, med API-gränssnitt, en mindre kö för offline-mutationer och fokuserade tester.
- En pragmatisk teststrategi med enhetstester för backend och frontend samt ett säkert CI-bygge.
- Produkttänk kring robust registrering av fiskepass utan att publicera intern produktionsimplementation.

Produktionsapplikationen ingår avsiktligt **inte** här. Det här är varken ett deployment-repo eller en fullständig kopia av produkten.

## Teknik

- Java 21, Spring Boot, Spring Validation, Spring Data JPA
- PostgreSQL och Flyway (representerat av en säker exempelmigrering)
- TypeScript, Vite, Vitest och API:er för lagring i webbläsaren
- Docker ingår i det större privata systemet; ingen Docker-konfiguration för produktion publiceras här

Produktionsapplikationens frontend använder TypeScript och Vite. Den här showcase-versionen speglar arkitekturen med ett kompakt och i stort sett ramverksoberoende exempel, utan att göra anspråk på att innehålla en React-implementation.

## Struktur

```text
backend/     Spring Boot-exempel med sessions-API och enhetstest
frontend/    TypeScript/Vite-gränssnitt, API-klient, offline-kö och enhetstest
docs/        Dokumentation om arkitektur, backend, frontend, offline-stöd och testning
.github/     Endast säker CI för bygge och test
```

## Mitt arbete

Den här showcase-versionen belyser fullstack-principer som används i projektet: modellering av en användarägd domän, utformning av validering och felkontrakt, tydliga gränser mellan webbläsare och API, stöd för återhämtning offline samt verifiering med fokuserade automatiserade tester. Den undviker medvetet påståenden om teamroller, kunddata eller den privata produktionsmiljön.

## Köra showcase-versionen

Modulerna är avsiktligt små och fristående:

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

Se [Arkitektur](docs/ARCHITECTURE.md) för en övergripande beskrivning av designen och avgränsningarna.

## Status

Det här är ett publikt portfolio-repo för teknisk granskning. Det innehåller inte produktionskällkoden för deployment och ska inte användas för produktionskonfiguration eller kunddata.
