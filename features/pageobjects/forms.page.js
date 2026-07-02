const BasePage = require('./base.page');

class FormsPage extends BasePage {
  async validateOpened() {
    const screen = await $('~Forms-screen');
    await screen.waitForDisplayed();
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
