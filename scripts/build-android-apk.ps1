$ErrorActionPreference = "Stop"

$appDir = Join-Path $PSScriptRoot "..\native-demo-app"
$androidDir = Join-Path $appDir "android"
$wrapperProperties = Join-Path $androidDir "gradle\wrapper\gradle-wrapper.properties"
$apkPath = Join-Path $androidDir "app\build\outputs\apk\debug\app-debug.apk"

Push-Location $appDir
try {
    if (-not (Test-Path "node_modules")) {
        npm install
    }

    npx expo prebuild --clean --platform android

    if (Test-Path $wrapperProperties) {
        $content = Get-Content -LiteralPath $wrapperProperties -Raw
        $content = $content -replace "distributionUrl=.*gradle-[^-]+-bin\.zip", "distributionUrl=https\://services.gradle.org/distributions/gradle-8.14.3-bin.zip"
        Set-Content -LiteralPath $wrapperProperties -Value $content -Encoding UTF8
    }

    Push-Location $androidDir
    try {
        .\gradlew.bat assembleDebug
    } finally {
        Pop-Location
    }

    if (-not (Test-Path $apkPath)) {
        throw "APK nao encontrado em $apkPath"
    }

    Write-Host "APK gerado em: $apkPath"
} finally {
    Pop-Location
}
