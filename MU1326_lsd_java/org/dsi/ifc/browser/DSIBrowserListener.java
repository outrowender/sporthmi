/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowserListener
extends DSIListener {
    public void updateBrowserState(int var1, int var2);

    public void updatePageTitle(String var1, int var2);

    public void updateActiveUrl(String var1, int var2);

    public void updateZoomFactor(int var1, int var2);

    public void updateVirtualKeyboardStatus(boolean var1, int var2);

    public void updateEncryption(boolean var1, int var2);

    public void updateHasFocus(boolean var1, int var2);

    public void updateButtonState(int var1, int var2, int var3);

    public void updateProgress(int var1, int var2);

    public void updateScrollbarX(int var1, int var2, int var3, int var4);

    public void updateScrollbarY(int var1, int var2, int var3, int var4);

    public void getPreferenceResult(int var1, int var2, String var3);

    public void resumeBrowserResult(int var1);

    public void indicateEfiUrl(String var1);

    public void indicateUnknownMimeType(String var1, String var2);

    public void indicateDownloadUrl(String var1);

    public void indicatePopup(String var1);

    public void indicateDownloadProgress(String var1, String var2, int var3);

    public void javascriptAlert(String var1);

    public void javascriptConfirm(String var1);

    public void javascriptPrompt(String var1, String var2);

    public void updateSelectionListContent(SelectionEntry[] var1, boolean var2, int var3);

    public void exportBrowserDataResult(int var1);

    public void importBrowserDataResult(int var1);

    public void getHistoryResult(TimePeriod var1, HistoryEntry[] var2, int var3);

    public void updateKeyboardDisplay(boolean var1, KeyboardInfo var2, int var3);
}

