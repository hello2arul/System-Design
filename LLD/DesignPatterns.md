## 1. Creational
- Creational patterns are related to the creation of new objects.


### 1.1 Singleton
- A singleton is an object that can only be instantiated once.
Examples:
```
public class LazySingleton {
    // The single instance is initially null
    private static LazySingleton instance;

    // Private constructor prevents instantiation from other classes
    private LazySingleton() {}

    // Public method to provide access to the instance
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

public class EagerSingleton {
    // The single instance is created eagerly
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // Private constructor prevents instantiation from other classes
    private EagerSingleton() {}

    // Public method to provide access to the instance
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    // Private constructor prevents instantiation from other classes
    private DoubleCheckedLockingSingleton() {}

    // Public method to provide access to the instance
    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}


public class BillPughSingleton {
    // Static inner class responsible for holding the Singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Private constructor prevents instantiation from other classes
    private BillPughSingleton() {}

    // Public method to provide access to the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}


public enum EnumSingleton {
    INSTANCE;

    // Define any additional methods if needed
    public void doSomething() {
        // Example method
    }
}
```

### 1.2 Prototype
- Prototype allows objects to be clones of other objects
#### Key Concepts of Prototype Pattern:

1. Prototype Interface: Defines the method for cloning itself.
2. Concrete Prototype: Implements the prototype interface and provides the actual cloning implementation.
3. Client: Uses the prototype to create new objects by cloning.

```
public interface Prototype {
    Prototype clone();
}


public class ConcretePrototype implements Prototype {
    private String field1;
    private int field2;

    // Constructor
    public ConcretePrototype(String field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    // Getter and Setter methods
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    // Implement clone method
    @Override
    public ConcretePrototype clone() {
        try {
            // Perform a shallow copy
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "ConcretePrototype [field1=" + field1 + ", field2=" + field2 + "]";
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        // Create an instance of ConcretePrototype
        ConcretePrototype original = new ConcretePrototype("Original", 42);

        // Clone the original object
        ConcretePrototype clone1 = original.clone();
        clone1.setField1("Clone1");

        // Clone again to demonstrate that we get a new instance
        ConcretePrototype clone2 = original.clone();
        clone2.setField2(84);

        // Print out the objects to show they are distinct
        System.out.println("Original: " + original);
        System.out.println("Clone1: " + clone1);
        System.out.println("Clone2: " + clone2);
    }
}

```

#### Notes:

1. Shallow Copy vs. Deep Copy: The provided clone method performs a shallow copy. For more complex objects that contain references to other objects, you may need a deep copy, which involves copying the referenced objects as well.
2. Cloneable Interface: Java's Cloneable interface can be used to mark a class as cloneable. The Object.clone() method is protected and must be overridden to be accessible, as shown in the example.
3. Exception Handling: Cloning can throw CloneNotSupportedException, but it’s often caught and handled within the class to provide a more suitable exception or runtime exception.

### 1.3 Builder

```
public class Computer {
    private String motherboard;
    private String processor;
    private int ram;
    private int storage;

    // Private constructor to enforce object creation via Builder
    private Computer(Builder builder) {
        this.motherboard = builder.motherboard;
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    @Override
    public String toString() {
        return "Computer [motherboard=" + motherboard + ", processor=" + processor 
                + ", ram=" + ram + "GB, storage=" + storage + "GB]";
    }

    // Static inner Builder class
    public static class Builder {
        private String motherboard;
        private String processor;
        private int ram;
        private int storage;

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

```

### 1.4 Factory
- create objects without specifying the exact class of the object that will be created.

```
public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}


public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

```

## 2. Structural
- Structural patterns are primarily used to handle relationships between objects.


### 2.1 Facade
- A facade is a class that provides a simplified API for larger body of code. It is often to used to hide low-level details of a subsystem.

```
public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SurroundSoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SurroundSoundSystem soundSystem, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        projector.on();
        projector.setInput("DVD");
        soundSystem.on();
        soundSystem.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down...");
        dvdPlayer.stop();
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        lights.on();
    }
}


public class FacadeDemo {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SurroundSoundSystem soundSystem = new SurroundSoundSystem();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}

```

### 2.2 Proxy
- The Proxy Design Pattern is a structural pattern that provides an object representing another object. A proxy serves as an intermediary to control access to the real object.

```
public interface Subject {
    void request();
}

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request");
    }
}

public class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // Additional behavior can be added here
        System.out.println("Proxy: Logging request");
        realSubject.request();
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}

```

## 3. Behavioral 
- Behavioral patterns are used to identify communication between objects.


### 3.1 Iterator
The iterator pattern is used to traverse a collection of elements. Most programming languages provide abstrations for iteration like the for loop.

```
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        // Create a List and add elements to it
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Obtain an Iterator from the List
        Iterator<String> iterator = list.iterator();

        // Iterate through the List using the Iterator
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}

```


### 3.2 Observer
- The observer pattern is used to notify a set of interested parties when a state change occurs. The rxjs library is a popular implementation of this pattern.

```
software.ts
import { Subject } from 'rxjs';

const news = new Subject();

const tv1 = news.subscribe(v => console.log(v + 'via Den TV'));
const tv2 = news.subscribe(v => console.log(v + 'via Batcave TV'));
const tv3 = news.subscribe(v => console.log(v + 'via Airport TV'));

news.next('Breaking news: ');
news.next('The war is over ');

tv1.unsubscribe();
```
### 3.3 Mediator
- The mediator is provids a middle layer between objects that communicate with each other. This pattern implemented frequently in JavaScript libaries via plugin systems (like Webpack) and middleware (like Express).

```
software.ts
import express from 'express';
const app = express();

// Middleware logic
function mediator(req, res, next) {
  console.log('Request Type:', req.method)
  next()
}

app.use(mediator);

// Mediator runs before each route handler
app.get('/', (req, res) => {
  res.send('Hello World');
});

app.get('/about', (req, res) => {
  res.send('About');
});
```

### 3.4 State
- The state pattern is used to encapsulate the state of an object so that it can be changed and accessed independently of the object. 

```
software.ts
interface State {
  think(): string;
}

class HappyState implements State {
  think() {
    return 'I am happy 🙂';
  }
}

class SadState implements State {
  think() {
    return 'I am sad 🙁';
  }
}


class Human {
  state: State;

  constructor() {
    this.state = new HappyState();
  }

  changeState(state) {
    this.state = state;
  }

  think() {
    return this.state.think();
  }
  
}

const human = new Human();
console.log(human.think());
human.changeState(new SadState());
console.log(human.think());
```

### References:
- https://fireship.io/lessons/typescript-design-patterns/