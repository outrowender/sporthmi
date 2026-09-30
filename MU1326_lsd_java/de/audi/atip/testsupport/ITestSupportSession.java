/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

public interface ITestSupportSession {
    public static final int STATUS_UNREGISTERED = 0;
    public static final int STATUS_REGISTERED = 1;
    public static final int STATUS_VISIBLE = 2;
    public static final int STATUS_OSO_VISIBLE = 3;

    public void activateMenuEntry(boolean var1);

    public void flashText(String var1, long var2);

    public void flashScreen();

    public void updateData(String[] var1);

    public int getStatus();
}

