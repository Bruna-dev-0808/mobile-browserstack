const BasePage = require('./base.page');

class LoginPage extends BasePage {
  async validateOpened() {
    const screen = await $('~Login-screen');
    await screen.waitForDisplayed();
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

  async getAlertMessage() {
    const androidMessage = await $('id:android:id/message');
    if (await androidMessage.isExisting()) {
      await androidMessage.waitForDisplayed();
      return androidMessage.getText();
    }

    const iosAlert = await $('-ios predicate string:label CONTAINS "logged in" OR label CONTAINS "signed up"');
    await iosAlert.waitForDisplayed();
    return iosAlert.getText();
  }
}

module.exports = new LoginPage();
