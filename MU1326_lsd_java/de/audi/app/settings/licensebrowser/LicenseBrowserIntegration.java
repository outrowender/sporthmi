/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.licensebrowser;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.licensebrowser.ILicenseBrowser;
import de.audi.atip.browser.EfiUrlHandler;
import de.audi.atip.browser.IBrowserCallbackHandler;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.io.File;

public final class LicenseBrowserIntegration
implements IBrowserCallbackHandler,
EfiUrlHandler,
ILicenseBrowser {
    private static final int ARROWS_NONE = 0;
    private static final int ARROWS_UP = 1;
    private static final int ARROWS_DOWN = 2;
    private static final int ARROWS_BOTH = 3;
    private IBrowserHandler browserHandler;
    private final LogChannel logChannel;
    private final SettingsEnv env;
    private static final String URL_PREFIX = "file://";
    private static final String PATH_PREFIX = "/eso/browser/public/license";
    private static final String PATH_SUFFIX = ".html";
    private static final String DISABLE_SYSTEM_PROPERTY = "DisableLicenseBrowser";

    public LicenseBrowserIntegration(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.logChannel = this.env.getFw().getLogChannel("App.Settings.LB");
        this.setScrollArrowVisible(0);
    }

    private void setScrollArrowVisible(int n) {
        this.env.getFw().getHMIService().getChoiceModel(1100226).setStatus(n);
    }

    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        int n;
        this.logChannel.log(1000000, "LicenseBrowserHandler#setBrowserHandler: Called.");
        ChoiceModelApp choiceModelApp = this.env.getFw().getHMIService().getChoiceModel(1100225);
        if (iBrowserHandler != null) {
            VirtualButtonModelApp virtualButtonModelApp = this.env.getFw().getHmiServiceApp().getVirtualButtonModel(1100298);
            ChoiceModelApp choiceModelApp2 = this.env.getFw().getHmiServiceApp().getChoiceModel(1100224);
            ChoiceModelApp choiceModelApp3 = this.env.getFw().getHmiServiceApp().getChoiceModel(1100227);
            ChoiceModelApp choiceModelApp4 = this.env.getChoiceModel(1100228);
            choiceModelApp4.setValue(1);
            iBrowserHandler.initialize(virtualButtonModelApp, choiceModelApp2, choiceModelApp, choiceModelApp4, null, 7);
            iBrowserHandler.setBrowserSyncModel(choiceModelApp3);
            iBrowserHandler.setRangeModels(null);
            iBrowserHandler.setZoomLabel(null);
            iBrowserHandler.setLabels(null);
            iBrowserHandler.setModels(null, null, null, null, null, null, null, null, null, null);
            iBrowserHandler.setEfiUrlHandler(this);
            iBrowserHandler.setBrowserCallbackHandler(this);
        } else {
            this.browserHandler.setBrowserCallbackHandler(null);
        }
        this.browserHandler = iBrowserHandler;
        int n2 = n = iBrowserHandler != null ? 1 : 0;
        if (System.getProperty(DISABLE_SYSTEM_PROPERTY) != null && Boolean.getBoolean(DISABLE_SYSTEM_PROPERTY)) {
            this.logChannel.log(1000000, "LicenseBrowserHandler#setBrowserHandler: Disabling license browser because of system property.");
            n = 0;
        }
        choiceModelApp.setValue(n);
    }

    public void browserEntered() {
        this.logChannel.log(1000000, "LicenseBrowserHandler#browserEntered: Called.");
        if (this.browserHandler == null) {
            this.logChannel.log(100000, "LicenseBrowserHandler#browserEntered: browser handler is null.");
            return;
        }
        this.browserHandler.resumeBrowser();
        String string = this.getLocalURL();
        this.logChannel.log(1000000, "LicenseBrowserHandler#browserEntered: Loading path %1", (Object)string);
        this.browserHandler.loadUrl(string, false);
    }

    private String getFilePath(String string) {
        Buffer buffer = new Buffer();
        buffer.append(PATH_PREFIX);
        if (string != null && string.length() > 0) {
            buffer.append("-");
            buffer.append(string);
        }
        buffer.append(PATH_SUFFIX);
        return buffer.toString();
    }

    private String getLocalURL() {
        Language language = this.env.getFw().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI");
        String string = this.getFilePath(language.getHmiCode());
        if (new File(string).exists()) {
            this.logChannel.log(1000000, "LicenseBrowserHandler#getPath: Using %1.", (Object)string);
            return URL_PREFIX + string;
        }
        String string2 = this.getFilePath(null);
        this.logChannel.log(1000000, "LicenseBrowserHandler#getPath: Using default %1.", (Object)string2);
        return URL_PREFIX + string2;
    }

    public void browserLeft() {
        this.logChannel.log(1000000, "LicenseBrowserHandler#browserLeft: Called.");
        if (this.browserHandler == null) {
            this.logChannel.log(100000, "LicenseBrowserHandler#browserEntered: browser handler is null.");
            return;
        }
        this.browserHandler.suspendBrowser();
    }

    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    public void updateScrollbarY(int n, int n2, int n3, int n4) {
        int n5 = 0;
        n5 = n <= n2 ? 0 : (n3 + n2 >= n ? 1 : (n3 <= 0 ? 2 : 3));
        this.logChannel.log(10000000, "LicenseBrowserHandler#updateScrollbarY: - pageContentHeight: %1, scrollPositionY: %2, visibleAreaHeight: %3, arrowFlag: " + n5, (long)n, (long)n3, (long)n2);
        this.setScrollArrowVisible(n5);
    }

    public void updateBrowserStateBusy(boolean bl) {
    }

    public boolean scrollDown(int n) {
        return false;
    }

    public boolean scrollUp(int n) {
        return false;
    }

    public void indicateBrowserStateNotFound() {
    }

    public void indicateBrowserStateComplete() {
        this.logChannel.log(1000000, "LicenseBrowserIntegration#indicateBrowserStateComplete: showing down arrow");
        this.setScrollArrowVisible(2);
    }

    public void javascriptAlert(String string) {
    }

    public boolean press() {
        return false;
    }

    public boolean indicateEfiUrl(String string) {
        return false;
    }

    public void belowLowerThreshold(int n) {
    }

    public void exceedsUpperThreshold(int n) {
    }

    public void updateActiveUrl(String string) {
    }

    public byte updateEfiUrl(String string) {
        return 0;
    }

    public void gotoHomeURL() {
    }

    public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
    }

    public boolean goForward() {
        return false;
    }

    public boolean goBack() {
        return false;
    }

    public void indicateBrowserStateTimeout() {
    }

    public void indicateBoardbookAvailable(boolean bl) {
    }

    public void updateBrowserState(int n) {
    }

    public void virtualButtonBack() {
    }
}

