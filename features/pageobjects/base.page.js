class BasePage {
  async waitAndClick(selector) {
    const element = await $(selector);
    await element.waitForDisplayed();
    await element.click();
  }

  async waitAndSetValue(selector, value) {
    const element = await $(selector);
    await element.waitForDisplayed();
    await element.setValue(value);
  }

  async waitAndGetText(selector) {
    const element = await $(selector);
    await element.waitForDisplayed();
    return element.getText();
  }
}

module.exports = BasePage;
