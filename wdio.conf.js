require('dotenv').config();

const platform = (process.env.PLATFORM || 'android').toLowerCase();
const isAndroid = platform === 'android';

const requiredEnv = ['BROWSERSTACK_USERNAME', 'BROWSERSTACK_ACCESS_KEY', 'BROWSERSTACK_APP_ID'];
for (const key of requiredEnv) {
  if (!process.env[key]) {
    throw new Error(`Variavel obrigatoria nao configurada: ${key}`);
  }
}

exports.config = {
  runner: 'local',
  user: process.env.BROWSERSTACK_USERNAME,
  key: process.env.BROWSERSTACK_ACCESS_KEY,
  hostname: 'hub.browserstack.com',

  specs: ['./features/**/*.feature'],
  maxInstances: 1,

  capabilities: [
    {
      platformName: isAndroid ? 'Android' : 'iOS',
      'appium:app': process.env.BROWSERSTACK_APP_ID,
      'appium:deviceName': process.env.BROWSERSTACK_DEVICE || (isAndroid ? 'Google Pixel 8' : 'iPhone 15'),
      'appium:platformVersion': process.env.BROWSERSTACK_OS_VERSION || (isAndroid ? '14.0' : '17'),
      'appium:automationName': isAndroid ? 'UiAutomator2' : 'XCUITest',
      'appium:autoGrantPermissions': true,
      'bstack:options': {
        projectName: 'Desafio Automacao Mobile',
        buildName: 'WDIO Demo App - BrowserStack',
        sessionName: 'Fluxos principais',
        debug: true,
        networkLogs: true
      }
    }
  ],

  logLevel: 'info',
  bail: 0,
  waitforTimeout: 15000,
  connectionRetryTimeout: 120000,
  connectionRetryCount: 2,

  framework: 'cucumber',
  cucumberOpts: {
    require: ['./features/step-definitions/**/*.js'],
    timeout: 90000
  },

  reporters: [
    'spec',
    ['allure', {
      outputDir: 'allure-results',
      disableWebdriverStepsReporting: false,
      disableWebdriverScreenshotsReporting: false
    }]
  ],

  services: [
    ['browserstack', {
      browserstackLocal: false
    }]
  ],

  afterStep: async function (_step, _scenario, result) {
    if (!result.passed) {
      await browser.takeScreenshot();
    }
  }
};
