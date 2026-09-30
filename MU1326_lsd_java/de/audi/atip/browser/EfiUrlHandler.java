/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.browser;

public interface EfiUrlHandler {
    public static final byte UPDATE_EFI_URL_ERROR = -1;
    public static final byte UPDATE_EFI_URL_SUCCESS_CHANGE_MODULE = 1;
    public static final byte UPDATE_EFI_URL_SUCCESS_DONT_CHANGE_MODULE = 2;
    public static final byte UPDATE_EFI_URL_DO_NOTHING = 3;

    public void updateActiveUrl(String var1);

    public byte updateEfiUrl(String var1);

    public void gotoHomeURL();

    public void showSpeller(String var1, String var2, String var3, boolean var4, short var5);

    public boolean goForward();

    public boolean goBack();
}

