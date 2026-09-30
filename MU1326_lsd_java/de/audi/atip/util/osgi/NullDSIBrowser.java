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

    public void cancelLoading() {
        this.log();
    }

    public void followLink(boolean bl) {
        this.log();
    }

    public void getPreference(int n) {
        this.log();
    }

    public void goBack() {
        this.log();
    }

    public void goForward() {
        this.log();
    }

    public void gotoHomeUrl() {
        this.log();
    }

    public void loadUrl(String string) {
        this.log();
    }

    public void nextFocus(int n) {
        this.log();
    }

    public void previousFocus(int n) {
        this.log();
    }

    public void scroll(int n, int n2) {
        this.log();
    }

    public void reloadUrl() {
        this.log();
    }

    public void setPreference(int n, int n2, String string) {
        this.log();
    }

    public void stopBrowser() {
        this.log();
    }

    public void zoom(int n, boolean bl) {
        this.log();
    }

    public void suspendBrowser() {
        this.log();
    }

    public void resumeBrowser() {
        this.log();
    }

    public void setLanguage(String string) {
        this.log();
    }

    public void deleteCookies() {
        this.log();
    }

    public void deleteHistory() {
        this.log();
    }

    public void deletePasswords() {
        this.log();
    }

    public void deleteCache() {
        this.log();
    }

    public void downloadFile(String string, String string2) {
        this.log();
    }

    public void enterImageSelectionMode() {
        this.log();
    }

    public void clickOnPosition(int n, int n2, boolean bl) {
        this.log();
    }

    public void javaScriptAlertAck() {
        this.log();
    }

    public void javaScriptConfirmAck(boolean bl) {
        this.log();
    }

    public void javaScriptPromptAck(String string, boolean bl) {
        this.log();
    }

    public void bringToFront() {
        this.log();
    }

    public void keyboardInput(String string) {
        this.log();
    }

    public void setSelection(int n, boolean bl) {
        this.log();
    }

    public void resetToFactoryDefaults() {
        this.log();
    }

    public void exportBrowserData(String string) {
        this.log();
    }

    public void importBrowserData(String string) {
        this.log();
    }

    public void getHistory(TimePeriod timePeriod) {
        this.log();
    }

    public void executeJavaScript(String string) {
        this.log();
    }

    public void touchScroll(int n, int n2) {
        this.log();
    }
}

