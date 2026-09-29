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
    private static final int ARROWS_NONE;
    private static final int ARROWS_UP;
    private static final int ARROWS_DOWN;
    private static final int ARROWS_BOTH;
    private IBrowserHandler browserHandler;
    private final LogChannel logChannel;
    private final SettingsEnv env;
    private static final String URL_PREFIX;
    private static final String PATH_PREFIX;
    private static final String PATH_SUFFIX;
    private static final String DISABLE_SYSTEM_PROPERTY;

    public LicenseBrowserIntegration(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.logChannel = this.env.getFw().getLogChannel("App.Settings.LB");
        this.setScrollArrowVisible(0);
    }

    private void setScrollArrowVisible(int n) {
        this.env.getFw().getHMIService().getChoiceModel(-1027010560).setStatus(n);
    }

    @Override
    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
        int n;
        this.logChannel.log(1078071040, "LicenseBrowserHandler#setBrowserHandler: Called.");
        ChoiceModelApp choiceModelApp = this.env.getFw().getHMIService().getChoiceModel(-1043787776);
        if (iBrowserHandler != null) {
            VirtualButtonModelApp virtualButtonModelApp = this.env.getFw().getHmiServiceApp().getVirtualButtonModel(181014528);
            ChoiceModelApp choiceModelApp2 = this.env.getFw().getHmiServiceApp().getChoiceModel(-1060564992);
            ChoiceModelApp choiceModelApp3 = this.env.getFw().getHmiServiceApp().getChoiceModel(-1010233344);
            ChoiceModelApp choiceModelApp4 = this.env.getChoiceModel(-993456128);
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
        if (System.getProperty("DisableLicenseBrowser") != null && Boolean.getBoolean("DisableLicenseBrowser")) {
            this.logChannel.log(1078071040, "LicenseBrowserHandler#setBrowserHandler: Disabling license browser because of system property.");
            n = 0;
        }
        choiceModelApp.setValue(n);
    }

    @Override
    public void browserEntered() {
        this.logChannel.log(1078071040, "LicenseBrowserHandler#browserEntered: Called.");
        if (this.browserHandler == null) {
            this.logChannel.log(-1601830656, "LicenseBrowserHandler#browserEntered: browser handler is null.");
            return;
        }
        this.browserHandler.resumeBrowser();
        String string = this.getLocalURL();
        this.logChannel.log(1078071040, "LicenseBrowserHandler#browserEntered: Loading path %1", (Object)string);
        this.browserHandler.loadUrl(string, false);
    }

    private String getFilePath(String string) {
        Buffer buffer = new Buffer();
        buffer.append("/eso/browser/public/license");
        if (string != null && string.length() > 0) {
            buffer.append("-");
            buffer.append(string);
        }
        buffer.append(".html");
        return buffer.toString();
    }

    private String getLocalURL() {
        Language language = this.env.getFw().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI");
        String string = this.getFilePath(language.getHmiCode());
        if (new File(string).exists()) {
            this.logChannel.log(1078071040, "LicenseBrowserHandler#getPath: Using %1.", (Object)string);
            return new StringBuffer().append("file://").append(string).toString();
        }
        String string2 = this.getFilePath(null);
        this.logChannel.log(1078071040, "LicenseBrowserHandler#getPath: Using default %1.", (Object)string2);
        return new StringBuffer().append("file://").append(string2).toString();
    }

    public void browserLeft() {
        this.logChannel.log(1078071040, "LicenseBrowserHandler#browserLeft: Called.");
        if (this.browserHandler == null) {
            this.logChannel.log(-1601830656, "LicenseBrowserHandler#browserEntered: browser handler is null.");
            return;
        }
        this.browserHandler.suspendBrowser();
    }

    @Override
    public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateScrollbarY(int n, int n2, int n3, int n4) {
        int n5 = 0;
        n5 = n <= n2 ? 0 : (n3 + n2 >= n ? 1 : (n3 <= 0 ? 2 : 3));
        this.logChannel.log(-2137614336, new StringBuffer().append("LicenseBrowserHandler#updateScrollbarY: - pageContentHeight: %1, scrollPositionY: %2, visibleAreaHeight: %3, arrowFlag: ").append(n5).toString(), (long)n, (long)n3, (long)n2);
        this.setScrollArrowVisible(n5);
    }

    @Override
    public void updateBrowserStateBusy(boolean bl) {
    }

    @Override
    public boolean scrollDown(int n) {
        return false;
    }

    @Override
    public boolean scrollUp(int n) {
        return false;
    }

    @Override
    public void indicateBrowserStateNotFound() {
    }

    @Override
    public void indicateBrowserStateComplete() {
        this.logChannel.log(1078071040, "LicenseBrowserIntegration#indicateBrowserStateComplete: showing down arrow");
        this.setScrollArrowVisible(2);
    }

    @Override
    public void javascriptAlert(String string) {
    }

    @Override
    public boolean press() {
        return false;
    }

    @Override
    public boolean indicateEfiUrl(String string) {
        return false;
    }

    @Override
    public void belowLowerThreshold(int n) {
    }

    @Override
    public void exceedsUpperThreshold(int n) {
    }

    @Override
    public void updateActiveUrl(String string) {
    }

    @Override
    public byte updateEfiUrl(String string) {
        return 0;
    }

    @Override
    public void gotoHomeURL() {
    }

    @Override
    public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
    }

    @Override
    public boolean goForward() {
        return false;
    }

    @Override
    public boolean goBack() {
        return false;
    }

    @Override
    public void indicateBrowserStateTimeout() {
    }

    @Override
    public void indicateBoardbookAvailable(boolean bl) {
    }

    @Override
    public void updateBrowserState(int n) {
    }

    @Override
    public void virtualButtonBack() {
    }
}

