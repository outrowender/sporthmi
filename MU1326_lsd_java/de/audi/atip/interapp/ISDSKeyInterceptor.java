/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface ISDSKeyInterceptor {
    public void pttPressed();

    public void pttReleasedAfterShortPress();

    public void pttLongDetected();

    public void pttReleasedAfterLongPress();
}

