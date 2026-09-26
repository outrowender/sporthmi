/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

public interface ISeeker {
    default public boolean seek(boolean bl, int n) {
    }

    default public int getMaxSeekSpeed() {
    }

    default public boolean isFixedSpeedSeeker() {
    }
}

