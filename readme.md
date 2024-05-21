## Appium

Appium er et mobil automatiseringsverktøy med åpen kildekode som gir automatisering på plattformer
som Android, iOS, etc.
Enda viktigere er at dette verktøyet er "cross-platform" - som lar deg skrive tester mot flere
plattformer (iOS, Android, Windows), ved å bruke samme API. Dette muliggjør gjenbruk av kode mellom
iOS-, Android- og Windows-enheter.

## E2E test

Ved bruk av Appium, laget vi UI automasjon testene i Android

## Bygget med

1. Appium
2. Java (Junit 4)
3. Allure-report

## Hvordan kjøre vi testene

1. Alle testene ligger under scr/test/e2e/AppiumTest.java
2. Testene kan bli kjørt fra egen test. Høyre klikk på testene og klikk på run
3. Det er mulig å lage TestSuite i junit 4

## Reporting

Reporter lages under build/allure-results.Til å kjøre reporter, bruk i terminal under
\My Application\app>:

        allure serve build/allure-results

Allure reporting viser som ned og legger ved et bilde når testen feiler