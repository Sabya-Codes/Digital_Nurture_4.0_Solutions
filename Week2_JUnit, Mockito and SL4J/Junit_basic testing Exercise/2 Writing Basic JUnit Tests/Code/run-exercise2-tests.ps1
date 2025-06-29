# PowerShell script to run Exercise 2: Writing Basic JUnit Tests
Write-Host "Exercise 2: Writing Basic JUnit Tests" -ForegroundColor Green
Write-Host "=====================================" -ForegroundColor Green

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

Write-Host "Compiling StringProcessor class..." -ForegroundColor Yellow
$compileMain = javac -d target\classes src\main\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile source code!" -ForegroundColor Red
    Write-Host $compileMain -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "StringProcessor compiled successfully" -ForegroundColor Green

Write-Host "Compiling test classes..." -ForegroundColor Yellow
$compileTest = javac -cp "target\classes;lib\*" -d target\test-classes src\test\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile test code!" -ForegroundColor Red
    Write-Host $compileTest -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "Test classes compiled successfully" -ForegroundColor Green

Write-Host "Running Exercise 2 tests..." -ForegroundColor Yellow
Write-Host ("=" * 60) -ForegroundColor Cyan

# Run JUnit 4 tests
java -cp "target\classes;target\test-classes;lib\*" org.junit.runner.JUnitCore StringProcessorTest

Write-Host ("=" * 60) -ForegroundColor Cyan
Write-Host "Exercise 2 Complete!" -ForegroundColor Green

Write-Host "What we accomplished in Exercise 2:" -ForegroundColor Yellow
Write-Host "1. Created a StringProcessor class with 8 different methods" -ForegroundColor White
Write-Host "2. Wrote 24 comprehensive JUnit tests covering:" -ForegroundColor White
Write-Host "   - Normal cases and edge cases" -ForegroundColor White
Write-Host "   - Null input handling" -ForegroundColor White
Write-Host "   - Empty string handling" -ForegroundColor White
Write-Host "   - Exception testing" -ForegroundColor White
Write-Host "   - Boolean assertions (assertTrue, assertFalse)" -ForegroundColor White
Write-Host "   - Equality assertions (assertEquals)" -ForegroundColor White
Write-Host "   - Null assertions (assertNull)" -ForegroundColor White
Write-Host "3. Used @Before and @After for test setup and cleanup" -ForegroundColor White

Write-Host "Key Testing Concepts Demonstrated:" -ForegroundColor Yellow
Write-Host "- Testing different input scenarios" -ForegroundColor White
Write-Host "- Boundary testing (empty strings, null values)" -ForegroundColor White
Write-Host "- Exception testing with @Test(expected=...)" -ForegroundColor White
Write-Host "- Proper test naming conventions" -ForegroundColor White
Write-Host "- Test isolation with setup/teardown methods" -ForegroundColor White

Read-Host "Press Enter to continue to Exercise 3"
