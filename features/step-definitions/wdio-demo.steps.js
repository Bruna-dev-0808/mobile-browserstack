const {Given, When, Then} = require('@wdio/cucumber-framework');
const {expect} = require('chai');

const homePage = require('../pageobjects/home.page');
const loginPage = require('../pageobjects/login.page');
const formsPage = require('../pageobjects/forms.page');

Given('que estou na Home do aplicativo', async () => {
  await homePage.validateOpened();
});

When('acesso a tela de Login', async () => {
  await homePage.openLogin();
  await loginPage.validateOpened();
});

When('faco login com usuario {string} e senha {string}', async (email, password) => {
  await loginPage.login(email, password);
});

When('faco cadastro com usuario {string}, senha {string} e confirmacao {string}', async (email, password, confirmation) => {
  await loginPage.signUp(email, password, confirmation);
});

Then('devo ver a mensagem {string}', async (expectedMessage) => {
  const message = await loginPage.getAlertMessage();
  expect(message).to.contain(expectedMessage);
});

When('acesso a tela de Forms', async () => {
  await homePage.openForms();
  await formsPage.validateOpened();
});

When('preencho o campo de texto com {string}', async (text) => {
  await formsPage.fillText(text);
});

When('aciono o switch', async () => {
  await formsPage.toggleSwitch();
});

Then('devo ver o texto digitado {string}', async (expectedText) => {
  const typedText = await formsPage.getTypedText();
  expect(typedText).to.equal(expectedText);
});

Then('devo ver o switch no estado ativo', async () => {
  const switchText = await formsPage.getSwitchText();
  expect(switchText).to.equal('Click to turn the switch OFF');
});
