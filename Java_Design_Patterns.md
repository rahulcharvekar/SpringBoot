
# Design Patterns in Java

This file explains 4 commonly used design patterns in Java with:
- Code examples
- Real-world analogies
- Diagram references

---

## 1. Singleton Pattern

**Purpose:** Ensure a class has only one instance and provide a global point of access.

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

**Analogy:** Controlling access to a printer – only one instance is needed to manage usage.

**Diagram Reference:** See top-left of the image (Singleton Pattern).

---

## 2. Factory Pattern

**Purpose:** Define an interface for creating an object, but let subclasses decide which class to instantiate.

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}
```

**Analogy:** Ordering a product from a factory – you don’t need to know how it's made.

**Diagram Reference:** See top-right of the image (Factory Pattern).

---

## 3. Observer Pattern

**Purpose:** When one object changes state, all its dependents are notified automatically.

```java
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void attach(Observer o) {
        observers.add(o);
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public int getState() {
        return state;
    }
}

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {
        System.out.println("Hex: " + Integer.toHexString(subject.getState()));
    }
}
```

**Analogy:** Subscribing to stock price changes – observers get notified when prices update.

**Diagram Reference:** See bottom-left of the image (Observer Pattern).

---

## 4. Strategy Pattern

**Purpose:** Define a family of algorithms and make them interchangeable.

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        strategy.pay(amount);
    }
}
```

**Analogy:** Choosing a route for a journey – strategy defines which route to use.

**Diagram Reference:** See bottom-right of the image (Strategy Pattern).
