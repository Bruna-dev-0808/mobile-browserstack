const BasePage = require('./base.page');

class FormsPage extends BasePage {
  get formsScreen() {
    return $('~Forms-screen');
  }

  async validateOpened() {
    await this.formsScreen.waitForDisplayed();
  }

  async isOpened() {
    return this.formsScreen.isDisplayed();
  }

  async fillText(value) {
    await this.waitAndSetValue('~text-input', value);
  }

  async toggleSwitch() {
    await this.waitAndClick('~switch');
  }

  async getTypedText() {
    return this.waitAndGetText('~input-text-result');
  }

  async getSwitchText() {
    return this.waitAndGetText('~switch-text');
  }
}

module.exports = new FormsPage();
