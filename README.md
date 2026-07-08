# Desafio de Automaçao Mobile

Projeto de automacao mobile em Java, Maven, Cucumber, JUnit 5 e Appium para o app WDIO Demo App em React Native/Expo.

## O que esta coberto

- Abertura do aplicativo WDIO Demo App.
- Login com sucesso.
- Cadastro com sucesso.
- Preenchimento de formulario.
- Validacao de switch.
- Evidencias com screenshot anexado ao relatorio Cucumber.
- Execucao local via Appium.
- Execucao opcional no BrowserStack via parametros.

## Pré-requisitos

- Java 21.
- Maven.
- Node.js compativel com o app em `native-demo-app`.
- Android Studio com um emulator Android configurado.
- Appium 2 instalado.
- Driver UiAutomator2 instalado:

```bash
appium driver install uiautomator2
```

## Como recuperar/gerar o APK

O APK nao esta versionado no Git. Para gerar novamente:

```powershell
.\scripts\build-android-apk.ps1
```

O APK debug esperado sera gerado em:

```text
native-demo-app/android/app/build/outputs/apk/debug/app-debug.apk
```

Se voce ja tiver um APK em outro local, informe o caminho na execucao com `-Dapp`.

## Como rodar localmente

1. Inicie o emulator Android.
2. Inicie o Appium:

```bash
appium
```

3. Rode os testes:

```bash
mvn test
```

Ou indicando um APK especifico:

```bash
mvn test -Dapp="C:/caminho/para/app-debug.apk"
```

## Execucao no BrowserStack

Envie o app para o BrowserStack e rode informando as credenciais por parametro ou variavel de ambiente:

```bash
mvn test -Dexecution=browserstack -Dplatform=android -Dbs.username=SEU_USUARIO -Dbs.accessKey=SUA_CHAVE -Dbs.app=bs://APP_ID
```

## Relatórios e evidências

Após a execução, os relatórios ficam em:

```text
target/cucumber-report.html
target/cucumber-report.json
```

Os screenshots sao anexados ao relatório Cucumber ao final de cada cenário.
