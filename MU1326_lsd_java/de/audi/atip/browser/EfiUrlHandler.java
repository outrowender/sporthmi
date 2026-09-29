/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.browser;

public interface EfiUrlHandler {
    public static final byte UPDATE_EFI_URL_ERROR;
    public static final byte UPDATE_EFI_URL_SUCCESS_CHANGE_MODULE;
    public static final byte UPDATE_EFI_URL_SUCCESS_DONT_CHANGE_MODULE;
    public static final byte UPDATE_EFI_URL_DO_NOTHING;

    default public void updateActiveUrl(String string) {
    }

    default public byte updateEfiUrl(String string) {
    }

    default public void gotoHomeURL() {
    }

    default public void showSpeller(String string, String string2, String string3, boolean bl, short s) {
    }

    default public boolean goForward() {
    }

    default public boolean goBack() {
    }
}

