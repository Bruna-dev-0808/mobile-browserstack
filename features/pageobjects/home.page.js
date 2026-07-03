const BasePage = require('./base.page');

class HomePage extends BasePage {
  get homeScreen() {
    return $('~Home-screen');
  }

  async validateOpened() {
    await this.homeScreen.waitForDisplayed();
  }

  async openHome() {
    if (await this.homeScreen.isDisplayed().catch(() => false)) {
      return;
    }

    const homeTab = await $('~Home');
    if (await homeTab.isDisplayed().catch(() => false)) {
      await homeTab.click();
      await this.validateOpened();
      return;
    }

    await this.openMenu();
    await this.waitAndClick('~side-menu-item-home');
    await this.validateOpened();
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