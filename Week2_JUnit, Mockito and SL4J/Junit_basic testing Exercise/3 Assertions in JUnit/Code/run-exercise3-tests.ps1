# PowerShell script to run Exercise 3: Assertions in JUnit
Write-Host "Exercise 3: Assertions in JUnit" -ForegroundColor Green
Write-Host "===============================" -ForegroundColor Green

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

Write-Host "Compiling DataValidator class..." -ForegroundColor Yellow
$compileMain = javac -d target\classes src\main\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile source code!" -ForegroundColor Red
    Write-Host $compileMain -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "DataValidator compiled successfully" -ForegroundColor Green

Write-Host "Compiling AssertionsTest class..." -ForegroundColor Yellow
$compileTest = javac -cp "target\classes;lib\*" -d target\test-classes src\test\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile test code!" -ForegroundColor Red
    Write-Host $compileTest -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "AssertionsTest compiled successfully" -ForegroundColor Green

Write-Host "Running Exercise 3 tests..." -ForegroundColor Yellow
Write-Host ("=" * 60) -ForegroundColor Cyan

# Run JUnit 4 tests
java -cp "target\classes;target\test-classes;lib\*" org.junit.runner.JUnitCore AssertionsTest

Write-Host ("=" * 60) -ForegroundColor Cyan
Write-Host "Exercise 3 Complete!" -ForegroundColor Green

Write-Host "What we accomplished in Exercise 3:" -ForegroundColor Yellow
Write-Host "1. Implemented the exact solution code from the exercise" -ForegroundColor White
Write-Host "2. Created comprehensive examples of ALL JUnit 4 assertions:" -ForegroundColor White

Write-Host "JUnit 4 Assertions Demonstrated:" -ForegroundColor Yellow
Write-Host "- assertEquals()     - Test equality of values" -ForegroundColor White
Write-Host "- assertTrue()       - Test boolean true conditions" -ForegroundColor White
Write-Host "- assertFalse()      - Test boolean false conditions" -ForegroundColor White
Write-Host "- assertNull()       - Test for null values" -ForegroundColor White
Write-Host "- assertNotNull()    - Test for non-null values" -ForegroundColor White
Write-Host "- assertSame()       - Test object reference equality" -ForegroundColor White
Write-Host "- assertNotSame()    - Test different object references" -ForegroundColor White
Write-Host "- assertArrayEquals()- Test array content equality" -ForegroundColor White
Write-Host "- assertEquals(delta)- Test floating point equality with tolerance" -ForegroundColor White
Write-Host "- fail()             - Explicitly fail a test" -ForegroundColor White

Write-Host "Advanced Testing Concepts:" -ForegroundColor Yellow
Write-Host "- Exception testing with @Test(expected=...)" -ForegroundColor White
Write-Host "- Custom assertion messages for better debugging" -ForegroundColor White
Write-Host "- Multiple assertions in single test methods" -ForegroundColor White
Write-Host "- String and collection-specific assertions" -ForegroundColor White
Write-Host "- Floating point comparison with delta values" -ForegroundColor White
Write-Host "- Proper exception handling in tests" -ForegroundColor White

Read-Host "Press Enter to continue to Exercise 4"
