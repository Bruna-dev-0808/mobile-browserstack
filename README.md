# Desafio de Automacao Mobile

Projeto criado do zero com as tecnologias sugeridas no desafio:

- JavaScript
- WebdriverIO
- Appium
- BrowserStack
- Chai
- Allure Report

## Como executar

Instale as dependencias:

```bash
npm install
```

Crie o arquivo `.env` com base no `.env.example`:

```text
BROWSERSTACK_USERNAME=seu_usuario
BROWSERSTACK_ACCESS_KEY=sua_access_key
BROWSERSTACK_APP_ID=bs://seu_app_id
PLATFORM=android
BROWSERSTACK_DEVICE=Google Pixel 8
BROWSERSTACK_OS_VERSION=14.0
```

As credenciais atuais ficam no BrowserStack em **Account > Settings > Access Key**.
Se aparecer `Invalid username or access-key`, atualize `BROWSERSTACK_USERNAME` e `BROWSERSTACK_ACCESS_KEY` no `.env`.

Execute os testes:

```bash
npm test
```

Gerar relatorio Allure:

```bash
npm run report
npm run report:open
```

## App usado

Automacao preparada para o WDIO Demo App exibido no desafio, com fluxos de:

- Login
- Cadastro
- Formulario
- Switch

## Observacoes

O projeto roda no BrowserStack. Nao precisa iniciar Appium local, emulator local ou gerar APK localmente.

Voce precisa subir o app no BrowserStack App Automate e usar o `bs://...` retornado em `BROWSERSTACK_APP_ID`.
