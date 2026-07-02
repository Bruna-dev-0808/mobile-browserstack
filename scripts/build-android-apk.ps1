$ErrorActionPreference = "Stop"

$appDir = Join-Path $PSScriptRoot "..\native-demo-app"
$androidDir = Join-Path $appDir "android"
$wrapperProperties = Join-Path $androidDir "gradle\wrapper\gradle-wrapper.properties"
$localProperties = Join-Path $androidDir "local.properties"
$apkPath = Join-Path $androidDir "app\build\outputs\apk\debug\app-debug.apk"

function Resolve-AndroidSdkPath {
    if ($env:ANDROID_HOME -and (Test-Path $env:ANDROID_HOME)) {
        return $env:ANDROID_HOME
    }

    if ($env:ANDROID_SDK_ROOT -and (Test-Path $env:ANDROID_SDK_ROOT)) {
        return $env:ANDROID_SDK_ROOT
    }

    $defaultSdkPath = Join-Path $env:LOCALAPPDATA "Android\Sdk"
    if (Test-Path $defaultSdkPath) {
        return $defaultSdkPath
    }

    throw "Android SDK nao encontrado. Instale pelo Android Studio ou configure ANDROID_HOME."
}

function Set-AndroidLocalProperties {
    $sdkPath = Resolve-AndroidSdkPath
    $escapedSdkPath = $sdkPath.Replace("\", "\\")
    Set-Content -LiteralPath $localProperties -Value "sdk.dir=$escapedSdkPath" -Encoding UTF8
}

Push-Location $appDir
try {
    if (-not (Test-Path "node_modules")) {
        npm install
    }

    npx expo prebuild --clean --platform android
    Set-AndroidLocalProperties

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
