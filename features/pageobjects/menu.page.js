const BasePage = require('./base.page');

const menuItems = {
  Home: {
    itemSelector: '~side-menu-item-home',
    screenSelector: '~Home-screen'
  },
  Webview: {
    itemSelector: '~side-menu-item-webview',
    screenSelector: '~Webview-screen'
  },
  Login: {
    itemSelector: '~side-menu-item-login',
    screenSelector: '~Login-screen'
  },
  Forms: {
    itemSelector: '~side-menu-item-forms',
    screenSelector: '~Forms-screen'
  },
  Swipe: {
    itemSelector: '~side-menu-item-swipe',
    screenSelector: '~Swipe-screen'
  },
  Drag: {
    itemSelector: '~side-menu-item-drag',
    screenSelector: '~Drag-screen'
  },
  Permissions: {
    itemSelector: '~side-menu-item-permissions',
    screenSelector: '~Permissions-screen'
  },
  Data: {
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

  async openItem(itemName) {
    const item = menuItems[itemName];
    await this.open();
    await this.waitAndClick(item.itemSelector);
  }

  async validateScreen(itemName) {
    const item = menuItems[itemName];
    const screen = await $(item.screenSelector);
    await screen.waitForDisplayed();
  }

  async toggleFavorite(itemName) {
    await this.open();
    const item = await $(menuItems[itemName].itemSelector);
    await item.waitForDisplayed();

    const rect = await item.getRect();
    await browser.action('pointer')
      .move({x: Math.round(rect.x + rect.width - 24), y: Math.round(rect.y + rect.height / 2)})
      .down()
      .up()
      .perform();
  }
}

module.exports = new MenuPage();
