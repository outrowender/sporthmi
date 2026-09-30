/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

public interface ISpoilerMessageHandler {
    public static final int INVALID_POPUP_ID = -1;

    public void init();

    public void deinit();

    public void showMessage(int var1);

    public void updateMessage();
}

