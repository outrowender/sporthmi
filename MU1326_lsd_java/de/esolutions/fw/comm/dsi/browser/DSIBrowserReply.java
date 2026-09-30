/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowserReply {
    public static final String IPL_COMM_UUID = "b9025762-f046-5aaa-bcde-0e6654d49868";
    public static final String IPL_COMM_INTERFACE_KEY = "a9cab10b-fbea-5364-a0dc-125101f3dcef";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.18";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.18";

    public void updateBrowserState(int var1, int var2) throws MethodException;

    public void updatePageTitle(String var1, int var2) throws MethodException;

    public void updateActiveUrl(String var1, int var2) throws MethodException;

    public void updateZoomFactor(int var1, int var2) throws MethodException;

    public void updateVirtualKeyboardStatus(boolean var1, int var2) throws MethodException;

    public void updateEncryption(boolean var1, int var2) throws MethodException;

    public void updateHasFocus(boolean var1, int var2) throws MethodException;

    public void updateButtonState(int var1, int var2, int var3) throws MethodException;

    public void updateProgress(int var1, int var2) throws MethodException;

    public void updateScrollbarX(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateScrollbarY(int var1, int var2, int var3, int var4) throws MethodException;

    public void getPreferenceResult(int var1, int var2, String var3) throws MethodException;

    public void resumeBrowserResult(int var1) throws MethodException;

    public void indicateEfiUrl(String var1) throws MethodException;

    public void indicateUnknownMimeType(String var1, String var2) throws MethodException;

    public void indicateDownloadUrl(String var1) throws MethodException;

    public void indicatePopup(String var1) throws MethodException;

    public void indicateDownloadProgress(String var1, String var2, int var3) throws MethodException;

    public void javascriptAlert(String var1) throws MethodException;

    public void javascriptConfirm(String var1) throws MethodException;

    public void javascriptPrompt(String var1, String var2) throws MethodException;

    public void updateSelectionListContent(SelectionEntry[] var1, boolean var2, int var3) throws MethodException;

    public void exportBrowserDataResult(int var1) throws MethodException;

    public void importBrowserDataResult(int var1) throws MethodException;

    public void getHistoryResult(TimePeriod var1, HistoryEntry[] var2, int var3) throws MethodException;

    public void updateKeyboardDisplay(boolean var1, KeyboardInfo var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

