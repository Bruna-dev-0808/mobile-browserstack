const BasePage = require('./base.page');

class HomePage extends BasePage {
  get homeScreen() {
    return $('~Home-screen');
  }

  async validateOpened() {
    await this.homeScreen.waitForDisplayed();
  }

  async openMenu() {
    await this.waitAndClick('~Menu');
  }

  async openLogin() {
    await this.openMenu();
    await this.waitAndClick('~side-menu-item-login');
  }

  async openForms() {
    await this.openMenu();
    await this.waitAndClick('~side-menu-item-forms');
  }
}

module.exports = new HomePage();
