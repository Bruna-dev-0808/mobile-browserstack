const {Given, When, Then} = require('@wdio/cucumber-framework');
const {expect} = require('chai');

const homePage = require('../pageobjects/home.page');
const loginPage = require('../pageobjects/login.page');
const formsPage = require('../pageobjects/forms.page');
const menuPage = require('../pageobjects/menu.page');

Given('que estou na Home do aplicativo', async () => {
  await browser.acceptAlert().catch(() => {});
  await homePage.openHome();
});

When('acesso a tela de Login', async () => {
  await homePage.openLogin();
  await loginPage.validateOpened();
});

When('faco login com usuario {string} e senha {string}', async (email, password) => {
  await loginPage.login(email, password);
});

When('tento fazer login sem informar email e senha', async () => {
  await loginPage.submitLoginWithoutCredentials();
});

When('faco cadastro com usuario {string}, senha {string} e confirmacao {string}', async (email, password, confirmation) => {
  await loginPage.signUp(email, password, confirmation);
});

When('tento fazer cadastro com usuario {string}, senha {string} e confirmacao {string}', async (email, password, confirmation) => {
  await loginPage.submitSignUpWithDifferentPasswords(email, password, confirmation);
});

Then('devo ver a mensagem {string}', async (expectedMessage) => {
  const message = await loginPage.getAlertMessage();
  expect(message).to.contain(expectedMessage);
});

Then('devo ver a mensagem de validacao {string}', async (expectedMessage) => {
  const message = await loginPage.getValidationMessage(expectedMessage);
  expect(message).to.contain(expectedMessage);
});

When('acesso a tela de Forms', async () => {
  await homePage.openForms();
  await formsPage.validateOpened();
});

Then('devo estar na tela de Login', async () => {
  expect(await loginPage.isOpened()).to.equal(true);
});

Then('devo estar na tela de Forms', async () => {
  expect(await formsPage.isOpened()).to.equal(true);
});

When('preencho o campo de texto com {string}', async (text) => {
  await formsPage.fillText(text);
});

When('aciono o switch', async () => {
  await formsPage.toggleSwitch();
});

When('seleciono no dropdown a opcao {string}', async (optionText) => {
  await formsPage.selectDropdownOption(optionText);
});

When('clico no botao {string}', async (buttonText) => {
  await formsPage.selectButton(buttonText);
});

Then('devo ver o texto digitado {string}', async (expectedText) => {
  const typedText = await formsPage.getTypedText();
  expect(typedText).to.equal(expectedText);
});

Then('devo ver o switch no estado ativo', async () => {
  const switchText = await formsPage.getSwitchText();
  expect(switchText).to.equal('Click to turn the switch OFF');
});

Then('devo ver a opcao {string} selecionada no dropdown', async (expectedText) => {
  const selectedText = await formsPage.getDropdownText(expectedText);
  expect(selectedText).to.equal(expectedText);
});

When('favorito a funcionalidade {string}', async (itemName) => {
  await menuPage.toggleFavorite(itemName);
});

When('desfavorito a funcionalidade {string}', async (itemName) => {
  await menuPage.toggleFavorite(itemName);
});

When('abro a funcionalidade {string}', async (itemName) => {
  await menuPage.openItem(itemName);
});

Then('devo visualizar a funcionalidade {string}', async (itemName) => {
  await menuPage.validateScreen(itemName);
});
