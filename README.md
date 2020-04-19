# Json Util
A simple, fast and light weight Json utility

# Technology stack

```bash
Java 8
Maven
Json
```

## Building And Running

Using maven for building the application

```bash
mvn clean install 
```
Jar is placed under target. You can add the it in your project.

## Utility Functionality

```python
Call JsonUtil.<methodName>

convertToJson(T object) : Pass your object, it will convert it to String
convertToJson(T object, boolean nonNull) : It will convert the object to String ignoring null fields
convertToObject(String jsonData, Class<T> clazz) : Maps the json string to the givenClass and returns the instance of it.
convertToJson(Map<String, Object> map) : Converts the passed map to Json string
convertToJson(List<T> list) : Converts the list to Json string
jsonToMap(String jsonString) : Maps the Json string to map
jsonToList(String jsonString, Class<T> clazz) : Takes array if Json as string and map it to the class passed and returns a List.
```
