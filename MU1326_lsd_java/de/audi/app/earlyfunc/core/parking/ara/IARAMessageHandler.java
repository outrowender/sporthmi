/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ara;

public interface IARAMessageHandler {
    public static final int INVALID_POPUP_ID = -1;

    public void init();

    public void deinit();

    public void showMessage(int var1);

    public void updateMessage();
}

