/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

public interface ISeeker {
    public boolean seek(boolean var1, int var2);

    public int getMaxSeekSpeed();

    public boolean isFixedSpeedSeeker();
}

