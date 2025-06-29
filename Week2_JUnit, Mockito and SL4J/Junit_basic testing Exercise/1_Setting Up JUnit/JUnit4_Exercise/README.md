# Exercise 1: Setting Up JUnit 4

This exercise demonstrates how to set up JUnit 4 in a Java project following the exact steps outlined in the exercise requirements.

## Exercise Requirements Completed ✅

### Step 1: Create a new Java project
- ✅ Created Maven project structure with standard directories
- ✅ Set up `src/main/java` and `src/test/java` directories

### Step 2: Add JUnit dependency to pom.xml
- ✅ Added the exact JUnit 4.13.2 dependency as specified:
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

### Step 3: Create a new test class
- ✅ Created `MathUtilsTest.java` with comprehensive JUnit 4 examples

## Project Structure

```
JUnit4_Exercise/
├── pom.xml                           # Maven configuration with JUnit 4
├── run-junit4-tests.ps1             # Script to run tests without Maven
├── README.md                         # This file
├── src/
│   ├── main/java/
│   │   └── MathUtils.java           # Class under test
│   └── test/java/
│       └── MathUtilsTest.java       # JUnit 4 test class
├── target/                          # Compiled classes (created when running)
└── lib/                             # Downloaded JUnit JARs (created when running)
```

## JUnit 4 Features Demonstrated

### 1. Basic Annotations
- `@Test` - Marks methods as test methods
- `@Before` - Setup method run before each test
- `@After` - Cleanup method run after each test
- `@BeforeClass` - Setup method run once before all tests
- `@AfterClass` - Cleanup method run once after all tests

### 2. Assertions
- `assertEquals(expected, actual)` - Assert two values are equal
- `assertTrue(condition)` - Assert condition is true
- `assertFalse(condition)` - Assert condition is false

### 3. Exception Testing
- `@Test(expected = ExceptionClass.class)` - Test that method throws expected exception

### 4. Test Organization
- Multiple test methods in one class
- Descriptive test method names
- Setup and teardown methods

## How to Run

### Option 1: Using PowerShell Script (Recommended)
```powershell
powershell -ExecutionPolicy Bypass -File run-junit4-tests.ps1
```

### Option 2: Using Maven (if installed)
```bash
mvn clean test
```

### Option 3: Manual Compilation and Execution
```bash
# Compile source code
javac -d target/classes src/main/java/*.java

# Compile test code (requires JUnit JAR in classpath)
javac -cp "target/classes;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" -d target/test-classes src/test/java/*.java

# Run tests
java -cp "target/classes;target/test-classes;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MathUtilsTest
```

## Expected Output

When you run the tests, you should see output similar to:
```
Setting up before all tests in the class
Setting up before each test
Cleaning up after each test
Setting up before each test
Cleaning up after each test
...
Cleaning up after all tests in the class

JUnit version 4.13.2
.........
Time: 0.xxx

OK (9 tests)
```

## Key Differences: JUnit 4 vs JUnit 5

| Feature | JUnit 4 | JUnit 5 |
|---------|---------|---------|
| Test Annotation | `@Test` | `@Test` |
| Setup/Teardown | `@Before/@After` | `@BeforeEach/@AfterEach` |
| Class Setup | `@BeforeClass/@AfterClass` | `@BeforeAll/@AfterAll` |
| Exception Testing | `@Test(expected=...)` | `assertThrows(...)` |
| Assertions | `Assert.assertEquals()` | `Assertions.assertEquals()` |
| Display Names | Not available | `@DisplayName` |
| Parameterized Tests | Separate runner required | Built-in `@ParameterizedTest` |

## What's Next?

1. **Experiment**: Try modifying the MathUtils class or tests
2. **Add More Tests**: Create additional test methods for edge cases
3. **Explore Assertions**: Try other JUnit 4 assertions like `assertNull`, `assertNotNull`, `assertSame`
4. **Exception Handling**: Practice testing different types of exceptions
5. **Move to Exercise 2**: Continue with writing basic JUnit tests

## Exercise Summary

This exercise successfully demonstrates:
- ✅ Setting up a Java project with proper Maven structure
- ✅ Adding JUnit 4 dependency exactly as specified
- ✅ Creating a comprehensive test class with multiple JUnit 4 features
- ✅ Running tests and verifying they pass

The setup is complete and ready for further JUnit learning!
