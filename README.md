# Основы автотестирования на Java — JUnit 5 и TestNG
Java unit testing with JUnit 5, TestNG and Gradle.

[![JUnit and TestNG](https://github.com/rootofevi1/java-unit-testing-basics/actions/workflows/tests.yml/badge.svg)](https://github.com/rootofevi1/java-unit-testing-basics/actions/workflows/tests.yml)

Проект, выполненный при обучении автотестированию. На небольших Java-методах показаны подбор тестовых данных, параметризация, проверка исключений, управление порядком выполнения и объединение тестов в сьюты. Похожие сценарии реализованы на JUnit 5 и TestNG, чтобы сравнить подходы двух фреймворков.

## Что проверяется

| Объект | Сценарии |
|---|---|
| `MethodExamples` | Факториал, простые и совершенные числа, подсчёт цифры в числе; обычные значения, ноль, отрицательные числа и недопустимая цифра |
| `PalindromeChecker` | Палиндромы и обычные строки, разный регистр, пробелы, цифры, спецсимволы, пустая строка и `null` |
| `PersonValidator` | Строка вида `Maxim 18 years`: корректные данные, граница возраста 17/18, короткое имя, ошибки формата, пробелы, пустой ввод и `null` |
| `TestsExampleJunit` / `TestsExampleTestNG` | Порядок тестов и методы жизненного цикла; в JUnit дополнительно — перехват ошибки проверки и пользовательское исключение с исходной причиной |

В проекте восемь тестовых классов: четыре для JUnit и четыре для TestNG. Отдельно предусмотрены два JUnit-сьюта и два XML-сьюта TestNG.

## Что демонстрирует проект

- Позитивные, негативные и граничные проверки.
- JUnit: `@ParameterizedTest`, `@ValueSource`, `@MethodSource`, `@NullAndEmptySource`.
- TestNG: `@DataProvider` и передача ожидаемого результата вместе с входными данными.
- Группировка утверждений через `assertAll` и `SoftAssert`.
- Проверка исключений через `assertThrows` / `expectThrows`.
- `@BeforeAll` / `@AfterAll`, `@BeforeClass` / `@AfterClass`, `@Order` и `priority`.
- Запуск классов, сьютов и двух фреймворков через Gradle.

## Стек

Java 21 · Gradle 9.3.0 · JUnit Jupiter 5.10.3 · JUnit Platform 1.10.3 · TestNG 7.10.2

## Структура

| Каталог / файл | Назначение |
|---|---|
| [src/main/java/utils](src/main/java/utils) | Проверяемые математические методы и проверка палиндрома |
| [src/main/java/validators](src/main/java/validators) | Валидация строки с данными человека |
| [src/main/java/exceptions](src/main/java/exceptions) | Пользовательское исключение |
| [src/test/java/junitTests](src/test/java/junitTests) | Тесты JUnit 5 |
| [src/test/java/testNGTests](src/test/java/testNGTests) | Тесты TestNG |
| [src/test/java/suites](src/test/java/suites) | JUnit Platform suites |
| [src/test/resources/testng-suites](src/test/resources/testng-suites) | XML-конфигурации TestNG |
| [build.gradle](build.gradle) | Зависимости и задачи запуска |

## Запуск

Установите JDK 21 и настройте `JAVA_HOME`. Gradle загружается через Wrapper; для первого запуска нужен интернет. Тесты выполняются локально, без браузера, сервера или API-ключей.

```bash
git clone https://github.com/rootofevi1/java-unit-testing-basics.git
cd java-unit-testing-basics
./gradlew clean check
```

Windows PowerShell:

```powershell
.\gradlew.bat clean check
```

`check` запускает все тесты JUnit и TestNG. Команда `test` запускает только JUnit; `testNG` — только TestNG.

| Команда (Linux / macOS) | Что запускает |
|---|---|
| `./gradlew test` | Все четыре класса JUnit |
| `./gradlew testNG` | Все четыре класса TestNG |
| `./gradlew test --tests 'junitTests.PalindromeCheckerTest'` | Один класс JUnit |
| `./gradlew testNG --tests 'testNGTests.PersonValidatorTestNG'` | Один класс TestNG |
| `./gradlew junitSuites` | Оба JUnit-сьюта |
| `./gradlew junitSuites --tests 'suites.TestsExampleSuite'` | Один JUnit-сьют |
| `./gradlew testNGMethods` | Математические проверки через XML TestNG |
| `./gradlew testNGExample` | Пример порядка выполнения через XML TestNG |

В Windows замените `./gradlew` на `.\gradlew.bat`. Для повторного выполнения без изменения кода добавьте `--rerun-tasks`.

## Отчёты и CI

- JUnit HTML: `build/reports/tests/test/index.html`.
- TestNG HTML: `build/reports/tests/testNG/index.html`.
- Отдельные сьюты: `build/reports/tests/<имя задачи>/index.html`.
- XML-результаты: `build/test-results/<имя задачи>/`.

GitHub Actions запускает `check junitSuites testNGMethods testNGExample` на Java 21 и сохраняет отчёты как артефакт `test-reports`. Сьюты повторно выполняют выбранные проверки; их результаты не следует прибавлять к числу уникальных сценариев.

## Особенности проверок

- Палиндром сравнивается без пробелов и с приведением к нижнему регистру. Знаки пунктуации сохраняются; пустая строка считается палиндромом, `null` — нет.
- Валидатор проверяет три части строки, имя длиннее трёх символов, целочисленный возраст от 18 и точное слово `years`. Верхняя возрастная граница и алфавит имени не проверяются.
- Примеры порядка выполнения служат для знакомства с фреймворками. Они не моделируют пользовательский бизнес-процесс.
- Тест пользовательского исключения намеренно печатает перехваченную ошибку в лог. Успешность определяется результатом теста.
- Набор учебный и не обеспечивает полного покрытия всех числовых диапазонов и Unicode-строк. Процент покрытия не измерялся.

Опубликованы код решения и необходимая конфигурация. Тексты школьных заданий, материалы курса, учебные промпты и история исходного репозитория не включены.

Александр · Junior QA/AQA Engineer · [Email](mailto:a@samoylov-qa.ru) · [Telegram](https://t.me/samoylov_av)
