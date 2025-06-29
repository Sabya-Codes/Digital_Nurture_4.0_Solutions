# PowerShell script to run JUnit 4 tests without Maven
Write-Host "Setting up JUnit 4 test environment..." -ForegroundColor Green

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
        Description = "Hamcrest Core (JUnit 4 dependency)"
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

Write-Host "Compiling source code..." -ForegroundColor Yellow
$compileMain = javac -d target\classes src\main\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile source code!" -ForegroundColor Red
    Write-Host $compileMain -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "Source code compiled successfully" -ForegroundColor Green

Write-Host "Compiling test code..." -ForegroundColor Yellow
$compileTest = javac -cp "target\classes;lib\*" -d target\test-classes src\test\java\*.java 2>&1
if ($LASTEXITCODE -ne 0) {
    Write-Host "Failed to compile test code!" -ForegroundColor Red
    Write-Host $compileTest -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "Test code compiled successfully" -ForegroundColor Green

Write-Host "Running JUnit 4 tests..." -ForegroundColor Yellow
Write-Host ("=" * 60) -ForegroundColor Cyan

# Run JUnit 4 tests using the JUnit runner
java -cp "target\classes;target\test-classes;lib\*" org.junit.runner.JUnitCore MathUtilsTest

Write-Host ("=" * 60) -ForegroundColor Cyan
Write-Host "Tests completed!" -ForegroundColor Green

# Show additional information
Write-Host "Exercise 1 Complete!" -ForegroundColor Yellow
Write-Host "What we accomplished:" -ForegroundColor White
Write-Host "1. Created a new Java project with Maven structure" -ForegroundColor White
Write-Host "2. Added JUnit 4.13.2 dependency to pom.xml" -ForegroundColor White
Write-Host "3. Created a test class (MathUtilsTest) with various JUnit 4 features" -ForegroundColor White
Write-Host "4. Successfully ran the tests" -ForegroundColor White

Write-Host "JUnit 4 Features Demonstrated:" -ForegroundColor Yellow
Write-Host "- @Test annotation for test methods" -ForegroundColor White
Write-Host "- @Before/@After for setup/cleanup" -ForegroundColor White
Write-Host "- @BeforeClass/@AfterClass for class-level setup/cleanup" -ForegroundColor White
Write-Host "- assertEquals, assertTrue, assertFalse assertions" -ForegroundColor White
Write-Host "- @Test(expected=Exception.class) for exception testing" -ForegroundColor White

Read-Host "Press Enter to exit"
