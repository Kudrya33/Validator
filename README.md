### Hexlet tests and linter status:
[![Actions Status](https://github.com/Kudrya33/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Kudrya33/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/baba3095f76894acf6f4/maintainability)](https://codeclimate.com/github/Kudrya33/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/baba3095f76894acf6f4/test_coverage)](https://codeclimate.com/github/Kudrya33/java-project-78/test_coverage)
[![Java CI](https://github.com/Kudrya33/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/Kudrya33/java-project-78/actions/workflows/main.yml)

Библиотеки для проверки корректности (валидации) данных.

Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. В первую очередь речь идет про данные форм заполняемых пользователями.
Валидатор функционирует следующим образом: сначала создается объект валидатора, затем мы создаем и настраиваем схему проверки данных. После этого мы проводим проверку данных, используя ранее созданную схему.

Чтобы воспользоваться валидатором, необходимо создать объект данной программы.
var v = new Validator();

После этого необходимо создать и настроить схему валидации данных, которая будет содержать правила проверки. Разные типы данных проверяются при помощи своих схем:
var schema = v.string();

Схема StringSchema содержит такой набор методов:

required() — делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение, которое не позволяет использовать null или пустую строку в качестве значения
minLength() — добавляет в схему ограничение минимальной длины для строки. Строка должна быть равна или длиннее указанного числа
contains() — добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку.

Ограничения и minLength и contains могут быть настроены при помощи передачи параметра в метод.
Проверки накапливаются в схеме, а не заменяют друг друга.
var schema = v.string().required().minLength(5).contains("hex");

После того как схема валидации была настроена, можно приступить к проверке данных. Для этого нужно вызвать метод isValid() на сконфигурированной схеме и передать ему данные, которые нужно провалидировать. Результатом работы будет логическое значение true, если данные соответствуют всем заданным в схеме правилам, или false, если не соответствуют.

Пример.
var schema = v.string().required().minLength(5).contains("hex");
schema.isValid(""); // true
schema.isValid(null); // true
schema.required();
schema.isValid(null); // false
schema.isValid(""); // false
schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true

Вызов метода number() определяет схему NumberSchema. Эта схема используется для валидации чисел.

Схема содержит такой набор методов:

required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
positive() — добавляет ограничение на знак числа. Число должно быть положительным
range() — добавляет допустимый диапазон, в который должно попадать значение числа включая границы.

Пример.
var schema = v.number();
schema.isValid(5); // true
Пока не вызван метод required(), null считается валидным
schema.isValid(null); // true
schema.positive().isValid(null); // true
schema.required();
schema.isValid(null); // false
schema.isValid(10); // true
Потому что ранее мы вызвали метод positive()
schema.isValid(-10); // false
Ноль — не положительное число
schema.isValid(0); // false

Валидация объектов типа Map

Реализуйте возможность проверять объекты Map валидатором.

Вызов метода map() определяет схему MapSchema. Эта схема используется для валидации объектов типа Map.

Схема содержит следующие методы:

required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения. Требуется тип данных Map
sizeof() — добавляет ограничение на размер мапы. Количество пар ключ-значений в объекте Map должно быть равно заданному.

Пример.
var v = new Validator();
var schema = v.map();
schema.isValid(null); // true
schema.required();
schema.isValid(null); // false
schema.isValid(new HashMap<>()); // true
var data = new HashMap<String, String>();
data.put("key1", "value1");
schema.isValid(data); // true

Метод shape() используется для определения свойств объекта Map и создания схемы для валидации их значений. Каждому свойству объекта Map привязывается свой набор ограничений (своя схема), что позволяет более точно контролировать данные.

Пример.
var v = new Validator();

var schema = v.map();

shape позволяет описывать валидацию для значений каждого ключа объекта Map
Создаем набор схем для проверки каждого ключа проверяемого объекта
Для значения каждого ключа - своя схема
Map<String, BaseSchema<String>> schemas = new HashMap<>();

Определяем схемы валидации для значений свойств "firstName" и "lastName"
Имя должно быть строкой, обязательно для заполнения
schemas.put("firstName", v.string().required());
Фамилия обязательна для заполнения и должна содержать не менее 2 символов
schemas.put("lastName", v.string().required().minLength(2));

Настраиваем схему `MapSchema`
Передаем созданный набор схем в метод shape()
schema.shape(schemas);

Проверяем объекты
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
schema.isValid(human3); // false

