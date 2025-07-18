
# Java and Spring Core Concepts

This document provides in-depth coverage of key Java and Spring topics including:
- Design Patterns
- Serialization
- Inversion of Control (IoC) & Dependency Injection (DI)
- Constructor vs Setter Injection
- Spring Bean Scopes (including Custom Scopes)
- Spring Bean Lifecycle
- Spring Framework Features

---

## 🎯 Design Patterns in Java

### 1. Singleton Pattern

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

📌 **Analogy**: Single printer shared across office.

---

### 2. Factory Pattern

```java
interface Shape { void draw(); }
class Circle implements Shape { public void draw() { System.out.println("Circle"); } }
class Square implements Shape { public void draw() { System.out.println("Square"); } }

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}
```

📌 **Analogy**: Factory produces different products based on input.

---

### 3. Template Method Pattern

```java
abstract class Beverage {
    public final void prepare() {
        boilWater();
        addIngredients();
        pourInCup();
    }
    void boilWater() { System.out.println("Boiling water"); }
    abstract void addIngredients();
    void pourInCup() { System.out.println("Pouring"); }
}

class Tea extends Beverage {
    void addIngredients() { System.out.println("Adding tea leaves"); }
}
```

📌 **Analogy**: Fixed recipe steps, one step customized (tea vs coffee).

---

## 📦 Serialization in Java

- Converts Java object to byte stream.
- Must implement `Serializable`.

### Example:

```java
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
}
```

### Preventing Serialization

```java
private void writeObject(ObjectOutputStream oos) throws IOException {
    throw new NotSerializableException("Not allowed");
}
```

---

## 🔁 IoC and Dependency Injection

- **IoC**: Framework manages object creation.
- **DI**: Injects dependencies into your classes.

### Constructor DI:

```java
@Service
public class UserService {
    private final UserRepo repo;
    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }
}
```

### Setter DI:

```java
@Autowired
public void setRepo(UserRepo repo) {
    this.repo = repo;
}
```

---

## ⚖️ Constructor vs Setter Injection

| Feature             | Constructor           | Setter               |
|---------------------|------------------------|-----------------------|
| Mandatory?          | ✅ Yes                | ❌ Optional          |
| Immutability        | ✅ Yes                | ❌ No                |
| Readability         | ✅ For small sets     | ✅ For optional ones |

---

## 🌱 Spring Bean Scopes

| Scope       | Description                         |
|-------------|-------------------------------------|
| singleton   | One per Spring container (default)  |
| prototype   | New per injection                   |
| request     | New per HTTP request                |
| session     | New per session                     |
| application | One per ServletContext              |
| websocket   | One per WebSocket session           |

### Custom Scope (ThreadLocal):

```java
public class ThreadLocalScope implements Scope {
    // implement Scope methods
}
```

Register:

```java
beanFactory.registerScope("thread", new ThreadLocalScope());
```

---

## 🌿 Spring Bean Lifecycle

1. Instantiation
2. Dependency Injection
3. Aware Interfaces (BeanNameAware, etc.)
4. `@PostConstruct` or `afterPropertiesSet()`
5. Ready to use
6. `@PreDestroy` or `destroy()`

### Example:

```java
@PostConstruct
public void init() { }

@PreDestroy
public void cleanup() { }
```

---

## 🚀 Key Spring Framework Features

- **IoC Container**
- **Dependency Injection**
- **AOP (Aspect-Oriented Programming)**
- **Spring MVC**
- **Spring Boot (auto-config)**
- **Spring Security**
- **Spring Data (JPA, MongoDB)**
- **Spring Cloud**
- **Testing with @MockBean, @WebMvcTest**

---

_End of Document_
