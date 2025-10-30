# Restaurant Bill

A simple Vaadin Flow (v24) web app that helps calculate a restaurant bill: tip amount, bill + tip total, and amount per person when splitting the check. Built with Java 17 and Maven, packaged as a WAR, and runnable locally via Jetty or deployable to Heroku.

Last updated: 2025-10-31

## Features
- Enter bill subtotal, tip percentage, and number of people to split between
- Calculates:
  - Tip amount
  - Bill + tip total
  - Amount per person
- Clean Vaadin UI, no JavaScript required
- Unit tests for the calculation service

## Tech stack
- Java 17
- Vaadin 24 (Flow)
- Maven (WAR packaging)
- Jetty Maven Plugin for local dev server
- JUnit 5 for tests
- Optional: Heroku deployment using `webapp-runner` and a `Procfile`

## Getting started
### Prerequisites
- JDK 17 installed and on PATH
- Maven 3.9+ installed and on PATH

### Clone
```bash
git clone https://github.com/your-org-or-user/RestaurantBill.git
cd RestaurantBill
```

### Run locally (dev)
This project uses the Jetty Maven Plugin. The first run may take longer as Vaadin prepares the frontend.

```bash
mvn -DskipTests jetty:run
```
Then open:
- http://localhost:8080

To stop the server, press Ctrl+C in the terminal.

### Build
- Development build (no production optimizations):
```bash
mvn -DskipTests clean package
```
Produces `target/restaurantbill-0.1.war`.

- Production build (minified frontend, no dev tools):
```bash
mvn -Pproduction -DskipTests clean package
```

### Run tests
```bash
mvn test
```

## How it works
Core logic lives in `BillCalculationService`, which computes three values from inputs on the `Bill` model:
- Tip amount = `billTotal * tipPercent / 100`
- Total with tip = `billTotal + tipAmount`
- Amount per person = `totalWithTip / numberOfPeople`

Key files:
- `src/main/java/com/reedmanit/restaurantbill/service/BillCalculationService.java` – calculation logic (rounds to 2 decimals)
- `src/main/java/com/reedmanit/restaurantbill/model/Bill.java` – holds bill fields (Vaadin `NumberField`s)
- `src/main/java/com/reedmanit/restaurantbill/view/BillForm.java` – the UI form
- `src/main/java/com/reedmanit/restaurantbill/MainView.java` and `AppShell.java` – Vaadin view and shell
- `src/test/java/com/reedmanit/restaurantbill/service/BillCalculationServiceTest.java` – unit tests

## Project structure
```
RestaurantBill/
├─ pom.xml
├─ Procfile
├─ system.properties
├─ src/
│  ├─ main/
│  │  ├─ java/com/reedmanit/restaurantbill/
│  │  │  ├─ model/
│  │  │  ├─ service/
│  │  │  └─ view/
│  │  ├─ resources/
│  │  └─ webapp/
│  └─ test/
└─ README.md
```

## Heroku deployment (optional)
This repo includes a `Procfile`, `system.properties`, and Maven setup to fetch `webapp-runner`. Two common options:

1) Deploy with Git (Heroku Java buildpack)
- Install Heroku CLI and log in
```bash
heroku create
heroku stack:set heroku-22
git push heroku main
```
Heroku will build and run the app using the `Procfile`.

2) Deploy with Maven plugin
The POM includes `com.heroku.sdk:heroku-maven-plugin`.
```bash
mvn heroku:deploy
```

## Troubleshooting
- If the first `jetty:run` is slow, it’s likely Vaadin preparing the frontend. Subsequent runs are faster.
- If the browser shows a 404, verify Jetty is running and you’re opening `http://localhost:8080/`.
- On Windows PowerShell, you can run the same Maven commands shown above.

## License
This project is licensed. See the `LICENSE` file for details.

## Contributing
- Fork the repo, create a feature branch, and open a PR.
- Please add or update tests for logic changes.

## Acknowledgments
- Vaadin team and community for the excellent web components and Flow framework.

