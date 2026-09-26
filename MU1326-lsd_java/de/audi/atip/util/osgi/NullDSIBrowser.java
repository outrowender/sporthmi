/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIBase;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.TimePeriod;

public class NullDSIBrowser
extends NullDSIBase
implements DSIBrowser {
    public NullDSIBrowser(LogChannel logChannel) {
        super(logChannel, "DSIBrowser");
    }

    @Override
    public void cancelLoading() {
        this.log();
    }

    @Override
    public void followLink(boolean bl) {
        this.log();
    }

    @Override
    public void getPreference(int n) {
        this.log();
    }

    @Override
    public void goBack() {
        this.log();
    }

    @Override
    public void goForward() {
        this.log();
    }

    @Override
    public void gotoHomeUrl() {
        this.log();
    }

    @Override
    public void loadUrl(String string) {
        this.log();
    }

    @Override
    public void nextFocus(int n) {
        this.log();
    }

    @Override
    public void previousFocus(int n) {
        this.log();
    }

    @Override
    public void scroll(int n, int n2) {
        this.log();
    }

    @Override
    public void reloadUrl() {
        this.log();
    }

    @Override
    public void setPreference(int n, int n2, String string) {
        this.log();
    }

    @Override
    public void stopBrowser() {
        this.log();
    }

    @Override
    public void zoom(int n, boolean bl) {
        this.log();
    }

    @Override
    public void suspendBrowser() {
        this.log();
    }

    @Override
    public void resumeBrowser() {
        this.log();
    }

    @Override
    public void setLanguage(String string) {
        this.log();
    }

    @Override
    public void deleteCookies() {
        this.log();
    }

    @Override
    public void deleteHistory() {
        this.log();
    }

    @Override
    public void deletePasswords() {
        this.log();
    }

    @Override
    public void deleteCache() {
        this.log();
    }

    @Override
    public void downloadFile(String string, String string2) {
        this.log();
    }

    @Override
    public void enterImageSelectionMode() {
        this.log();
    }

    @Override
    public void clickOnPosition(int n, int n2, boolean bl) {
        this.log();
    }

    @Override
    public void javaScriptAlertAck() {
        this.log();
    }

    @Override
    public void javaScriptConfirmAck(boolean bl) {
        this.log();
    }

    @Override
    public void javaScriptPromptAck(String string, boolean bl) {
        this.log();
    }

    @Override
    public void bringToFront() {
        this.log();
    }

    @Override
    public void keyboardInput(String string) {
        this.log();
    }

    @Override
    public void setSelection(int n, boolean bl) {
        this.log();
    }

    @Override
    public void resetToFactoryDefaults() {
        this.log();
    }

    @Override
    public void exportBrowserData(String string) {
        this.log();
    }

    @Override
    public void importBrowserData(String string) {
        this.log();
    }

    @Override
    public void getHistory(TimePeriod timePeriod) {
        this.log();
    }

    @Override
    public void executeJavaScript(String string) {
        this.log();
    }

    @Override
    public void touchScroll(int n, int n2) {
        this.log();
    }
}

