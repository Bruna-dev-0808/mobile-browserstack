# Automacao Mobile - WDIO Demo App

Projeto de automacao mobile para validacao dos principais fluxos do WDIO Demo App em nuvem, utilizando BrowserStack App Automate.

## Tecnologias

- JavaScript
- WebdriverIO
- Appium
- BrowserStack App Automate
- Cucumber/Gherkin
- Chai
- Allure Report

## Estrutura

```text
features/
  cadastro.feature
  formulario.feature
  login.feature
  mensagens_erro.feature
  navegacao.feature
  pageobjects/
  step-definitions/
```

O projeto segue o padrao Page Object, separando os elementos e acoes de cada tela da escrita dos cenarios. Os cenarios ficam em Gherkin, facilitando leitura e manutencao.

## Configuracao

Instale as dependencias:

```bash
npm install
```

Crie um arquivo `.env` na raiz do projeto usando o `.env.example` como referencia:

```text
BROWSERSTACK_USERNAME=seu_usuario
BROWSERSTACK_ACCESS_KEY=sua_access_key
BROWSERSTACK_APP_ID=bs://seu_app_id
PLATFORM=android
BROWSERSTACK_DEVICE=Google Pixel 8
BROWSERSTACK_OS_VERSION=14.0
```

As credenciais ficam disponiveis no BrowserStack em **Account > Settings > Access Key**.

## Execucao

Para executar a suite:

```bash
npm test
```

Para executar por plataforma:

```bash
npm run test:android
npm run test:ios
```

## Relatorio

Gerar e abrir o relatorio Allure:

```bash
npm run report
npm run report:open
```

## Cobertura automatizada

Cenarios automatizados:

- Login com sucesso
- Cadastro com sucesso
- Login sem credenciais
- Login com senha incorreta
- Cadastro com senhas divergentes
- Preenchimento de formulario
- Navegacao da Home para Login
- Navegacao da Home para Forms

Tambem existem cenarios marcados como `@manual` para fluxos que nao possuem tela estavel no app demonstrativo, como produtos, carrinho e checkout. Esses cenarios documentam cobertura planejada, mas nao entram na execucao automatica.

## Observacoes

A execucao e feita no BrowserStack. Nao e necessario iniciar Appium localmente, abrir emulador local ou gerar APK durante a execucao.