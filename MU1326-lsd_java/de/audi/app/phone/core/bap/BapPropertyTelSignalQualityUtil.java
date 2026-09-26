/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

public final class BapPropertyTelSignalQualityUtil {
    public static int getCombiSignalQuality(int n) {
        return n == 255 ? 0 : n;
    }
}

