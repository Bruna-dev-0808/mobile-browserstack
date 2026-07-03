const BasePage = require('./base.page');

const menuItems = {
  Home: {
    text: 'Home',
    itemSelector: '~side-menu-item-home',
    screenSelector: '~Home-screen'
  },
  Webview: {
    text: 'Webview',
    itemSelector: '~side-menu-item-webview',
    screenSelector: '~Webview-screen'
  },
  Login: {
    text: 'Login',
    itemSelector: '~side-menu-item-login',
    screenSelector: '~Login-screen'
  },
  Forms: {
    text: 'Forms',
    itemSelector: '~side-menu-item-forms',
    screenSelector: '~Forms-screen'
  },
  Swipe: {
    text: 'Swipe',
    itemSelector: '~side-menu-item-swipe',
    screenSelector: '~Swipe-screen'
  },
  Drag: {
    text: 'Drag',
    itemSelector: '~side-menu-item-drag',
    screenSelector: '~Drag-screen'
  },
  Permissions: {
    text: 'Permissions',
    itemSelector: '~side-menu-item-permissions',
    screenSelector: '~Permissions-screen'
  },
  Data: {
    text: 'Data',
    itemSelector: '~side-menu-item-data',
    screenSelector: '~Data-screen'
  }
};

class MenuPage extends BasePage {
  async open() {
    const menu = await $('~Menu');
    if (await menu.isDisplayed()) {
      await menu.click();
    }
  }

  async getVisibleItem(itemName) {
    const item = menuItems[itemName];
    const element = await $(item.itemSelector);

    try {
      await element.waitForDisplayed({timeout: 3000});
      return element;
    } catch (_error) {
      await $(`android=new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView("${item.text}")`);
      await element.waitForDisplayed();
      return element;
    }
  }

  async openItem(itemName) {
    await this.open();
    const item = await this.getVisibleItem(itemName);
    await item.click();
  }

  async validateScreen(itemName) {
    const item = menuItems[itemName];
    const screen = await $(item.screenSelector);
    await screen.waitForDisplayed();
  }

  async toggleFavorite(itemName) {
    await this.open();
    const item = await this.getVisibleItem(itemName);

    const rect = await item.getRect();
    await browser.action('pointer')
      .move({x: Math.round(rect.x + rect.width - 24), y: Math.round(rect.y + rect.height / 2)})
      .down()
      .up()
      .perform();
  }
}

module.exports = new MenuPage();
