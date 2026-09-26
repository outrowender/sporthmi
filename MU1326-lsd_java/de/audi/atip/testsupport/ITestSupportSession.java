/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

public interface ITestSupportSession {
    public static final int STATUS_UNREGISTERED;
    public static final int STATUS_REGISTERED;
    public static final int STATUS_VISIBLE;
    public static final int STATUS_OSO_VISIBLE;

    default public void activateMenuEntry(boolean bl) {
    }

    default public void flashText(String string, long l) {
    }

    default public void flashScreen() {
    }

    default public void updateData(String[] stringArray) {
    }

    default public int getStatus() {
    }
}

