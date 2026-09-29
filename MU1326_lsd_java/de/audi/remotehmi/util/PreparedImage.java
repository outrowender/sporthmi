/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import java.io.File;

public final class PreparedImage {
    private final String localLocation;
    private final String remoteUrl;
    private final boolean lazy;
    private final String checksum;
    private final int cacheBehavior;
    private final boolean notification;
    private static final PreparedImage EMPTY = new PreparedImage("", null, false, null, 0, false);

    public PreparedImage(String string, String string2, boolean bl, String string3, int n, boolean bl2) {
        this.localLocation = string;
        this.remoteUrl = string2;
        this.lazy = bl;
        this.checksum = string3;
        this.cacheBehavior = n;
        this.notification = bl2;
    }

    public String getLocalLocation() {
        return this.localLocation;
    }

    public String getRemoteUrl() {
        return this.remoteUrl;
    }

    public boolean isLazy() {
        return this.lazy;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public int getCacheBehavior() {
        return this.cacheBehavior;
    }

    public boolean isNotification() {
        return this.notification;
    }

    public static final PreparedImage fromLocalLocation(String string) {
        return new PreparedImage(string == null ? "" : string, null, false, null, 0, false);
    }

    public static final PreparedImage fromFile(File file) {
        return PreparedImage.fromLocalLocation(file.getAbsolutePath());
    }

    public static final PreparedImage getEmptyInstance() {
        return EMPTY;
    }
}

