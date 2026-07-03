const BasePage = require('./base.page');

class LoginPage extends BasePage {
  get loginScreen() {
    return $('~Login-screen');
  }

  async validateOpened() {
    await this.loginScreen.waitForDisplayed();
  }

  async isOpened() {
    return this.loginScreen.isDisplayed();
  }

  async login(email, password) {
    await this.waitAndClick('~button-login-container');
    await this.waitAndSetValue('~input-email', email);
    await this.waitAndSetValue('~input-password', password);
    await this.waitAndClick('~button-LOGIN');
  }

  async signUp(email, password, confirmation) {
    await this.waitAndClick('~button-sign-up-container');
    await this.waitAndSetValue('~input-email', email);
    await this.waitAndSetValue('~input-password', password);
    await this.waitAndSetValue('~input-repeat-password', confirmation);
    await this.waitAndClick('~button-SIGN UP');
  }

  async submitLoginWithoutCredentials() {
    await this.waitAndClick('~button-login-container');
    await this.waitAndClick('~button-LOGIN');
  }

  async submitSignUpWithDifferentPasswords(email, password, confirmation) {
    await this.waitAndClick('~button-sign-up-container');
    await this.waitAndSetValue('~input-email', email);
    await this.waitAndSetValue('~input-password', password);
    await this.waitAndSetValue('~input-repeat-password', confirmation);
    await this.waitAndClick('~button-SIGN UP');
  }

  async getValidationMessage(message) {
    const element = await $(`android=new UiSelector().textContains("${message}")`);
    await element.waitForDisplayed();
    return element.getText();
  }

  async getAlertMessage() {
    const platformName = String(browser.capabilities.platformName || '').toLowerCase();

    if (platformName.includes('android')) {
      const androidMessage = await $('id:android:id/message');
      await androidMessage.waitForDisplayed();
      return androidMessage.getText();
    }

    const iosAlert = await $('-ios predicate string:label CONTAINS "logged in" OR label CONTAINS "signed up"');
    await iosAlert.waitForDisplayed();
    return iosAlert.getText();
  }
}

module.exports = new LoginPage();
