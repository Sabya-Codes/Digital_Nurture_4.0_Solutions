# PowerShell script to run Exercise 4: AAA Pattern and Test Fixtures
Write-Host "Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown" -ForegroundColor Green
Write-Host "=============================================================================" -ForegroundColor Green

# Create directories for compiled classes
New-Item -ItemType Directory -Path "target\classes" -Force | Out-Null
New-Item -ItemType Directory -Path "target\test-classes" -Force | Out-Null
New-Item -ItemType Directory -Path "lib" -Force | Out-Null

Write-Host "Downloading JUnit 4 dependencies..." -ForegroundColor Yellow

# Function to download file if it doesn't exist
function Download-IfNotExists {
    param($Url, $OutputPath, $Description)
    
    if (-not (Test-Path $OutputPath)) {
        Write-Host "Downloading $Description..." -ForegroundColor Cyan
        try {
            Invoke-WebRequest -Uri $Url -OutFile $OutputPath -UseBasicParsing
            Write-Host "Downloaded $Description" -ForegroundColor Green
        }
        catch {
            Write-Host "Failed to download $Description" -ForegroundColor Red
            Write-Host $_.Exception.Message -ForegroundColor Red
            return $false
        }
    } else {
        Write-Host "$Description already exists" -ForegroundColor Green
    }
    return $true
}

# Download JUnit 4 dependencies
$downloads = @(
    @{
        Url = "https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar"
        Path = "lib\junit-4.13.2.jar"
        Description = "JUnit 4.13.2"
    },
    @{
        Url = "https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
        Path = "lib\hamcrest-core-1.3.jar"
        Description = "Hamcrest Core"
    }
)

$allDownloaded = $true
foreach ($download in $downloads) {
    if (-not (Download-IfNotExists -Url $download.Url -OutputPath $download.Path -Description $download.Description)) {
        $allDownloaded = $false
    }
}

if (-not $allDownloaded) {
    Write-Host "Some dependencies failed to download. Please check your internet connection." -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host "Compiling BankAccount class..." -ForegroundColor Yellow
$compileMain = javac -d target\classes src\main\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile source code!" -ForegroundColor Red
    Write-Host $compileMain -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "BankAccount compiled successfully" -ForegroundColor Green

Write-Host "Compiling BankAccountTest class..." -ForegroundColor Yellow
$compileTest = javac -cp "target\classes;lib\*" -d target\test-classes src\test\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile test code!" -ForegroundColor Red
    Write-Host $compileTest -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "BankAccountTest compiled successfully" -ForegroundColor Green

Write-Host "Running Exercise 4 tests..." -ForegroundColor Yellow
Write-Host ("=" * 80) -ForegroundColor Cyan

# Run JUnit 4 tests
java -cp "target\classes;target\test-classes;lib\*" org.junit.runner.JUnitCore BankAccountTest

Write-Host ("=" * 80) -ForegroundColor Cyan
Write-Host "Exercise 4 Complete!" -ForegroundColor Green

Write-Host "What we accomplished in Exercise 4:" -ForegroundColor Yellow
Write-Host "1. Implemented the Arrange-Act-Assert (AAA) Pattern in all tests" -ForegroundColor White
Write-Host "2. Used @Before and @After annotations for setup and teardown methods" -ForegroundColor White
Write-Host "3. Used @BeforeClass and @AfterClass for class-level setup/teardown" -ForegroundColor White
Write-Host "4. Created comprehensive test fixtures (BankAccount objects)" -ForegroundColor White
Write-Host "5. Demonstrated proper test organization and isolation" -ForegroundColor White

Write-Host "AAA Pattern Benefits Demonstrated:" -ForegroundColor Yellow
Write-Host "- ARRANGE: Set up test data and conditions" -ForegroundColor White
Write-Host "- ACT: Execute the method or operation being tested" -ForegroundColor White
Write-Host "- ASSERT: Verify the expected outcomes" -ForegroundColor White
Write-Host "- Clear separation makes tests easy to read and maintain" -ForegroundColor White

Write-Host "Test Fixtures and Setup/Teardown Benefits:" -ForegroundColor Yellow
Write-Host "- @BeforeClass: One-time setup for the entire test class" -ForegroundColor White
Write-Host "- @Before: Setup before each individual test method" -ForegroundColor White
Write-Host "- @After: Cleanup after each individual test method" -ForegroundColor White
Write-Host "- @AfterClass: One-time cleanup for the entire test class" -ForegroundColor White
Write-Host "- Ensures test isolation and consistent starting conditions" -ForegroundColor White

Write-Host "Advanced Testing Concepts Covered:" -ForegroundColor Yellow
Write-Host "- Complex business logic testing (banking operations)" -ForegroundColor White
Write-Host "- State verification across multiple operations" -ForegroundColor White
Write-Host "- Exception testing with proper setup" -ForegroundColor White
Write-Host "- Boundary testing (zero balance scenarios)" -ForegroundColor White
Write-Host "- Multi-step operation testing" -ForegroundColor White
Write-Host "- Test fixture reuse and proper cleanup" -ForegroundColor White

Write-Host "All JUnit 4 Exercises Complete!" -ForegroundColor Green
Write-Host "You have successfully learned:" -ForegroundColor Yellow
Write-Host "- Exercise 1: Setting up JUnit 4 with Maven" -ForegroundColor White
Write-Host "- Exercise 2: Writing basic JUnit tests" -ForegroundColor White
Write-Host "- Exercise 3: Using various JUnit assertions" -ForegroundColor White
Write-Host "- Exercise 4: AAA pattern and test fixtures" -ForegroundColor White

Read-Host "Press Enter to finish"
