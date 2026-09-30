/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowserC {
    public void cancelLoading() throws MethodException;

    public void followLink(boolean var1) throws MethodException;

    public void getPreference(int var1) throws MethodException;

    public void goBack() throws MethodException;

    public void goForward() throws MethodException;

    public void gotoHomeUrl() throws MethodException;

    public void loadUrl(String var1) throws MethodException;

    public void nextFocus(int var1) throws MethodException;

    public void previousFocus(int var1) throws MethodException;

    public void scroll(int var1, int var2) throws MethodException;

    public void reloadUrl() throws MethodException;

    public void setPreference(int var1, int var2, String var3) throws MethodException;

    public void stopBrowser() throws MethodException;

    public void zoom(int var1, boolean var2) throws MethodException;

    public void suspendBrowser() throws MethodException;

    public void resumeBrowser() throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void deleteCookies() throws MethodException;

    public void deleteHistory() throws MethodException;

    public void deletePasswords() throws MethodException;

    public void deleteCache() throws MethodException;

    public void downloadFile(String var1, String var2) throws MethodException;

    public void enterImageSelectionMode() throws MethodException;

    public void clickOnPosition(int var1, int var2, boolean var3) throws MethodException;

    public void javaScriptAlertAck() throws MethodException;

    public void javaScriptConfirmAck(boolean var1) throws MethodException;

    public void javaScriptPromptAck(String var1, boolean var2) throws MethodException;

    public void bringToFront() throws MethodException;

    public void keyboardInput(String var1) throws MethodException;

    public void setSelection(int var1, boolean var2) throws MethodException;

    public void resetToFactoryDefaults() throws MethodException;

    public void exportBrowserData(String var1) throws MethodException;

    public void importBrowserData(String var1) throws MethodException;

    public void getHistory(TimePeriod var1) throws MethodException;

    public void executeJavaScript(String var1) throws MethodException;

    public void touchScroll(int var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

