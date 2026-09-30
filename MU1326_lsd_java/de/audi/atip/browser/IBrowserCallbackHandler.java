/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.browser;

public interface IBrowserCallbackHandler {
    public void updateScrollbarX(int var1, int var2, int var3, int var4);

    public void updateScrollbarY(int var1, int var2, int var3, int var4);

    public void updateBrowserStateBusy(boolean var1);

    public void updateBrowserState(int var1);

    public boolean scrollDown(int var1);

    public boolean scrollUp(int var1);

    public void indicateBrowserStateNotFound();

    public void indicateBrowserStateComplete();

    public void indicateBrowserStateTimeout();

    public void javascriptAlert(String var1);

    public boolean press();

    public boolean indicateEfiUrl(String var1);

    public void belowLowerThreshold(int var1);

    public void exceedsUpperThreshold(int var1);

    public void indicateBoardbookAvailable(boolean var1);

    public void virtualButtonBack();
}

