/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IResource$OwnershipType;

public interface IResource {
    public static final int RESOURCE_UNKNOWN;
    public static final int RESOURCE_SCREEN;
    public static final int RESOURCE_MAIN_AUDIO;
    public static final int RESOURCE_AUDIO_MEDIA;
    public static final int RESOURCE_AUDIO_PHONE;
    public static final int RESOURCE_AUDIO_SPEECH;
    public static final int RESOURCE_AUDIO_GUIDANCE;
    public static final int RESOURCE_AUDIO_RINGTONE;
    public static final int RESOURCE_NOTIFICATION;
    public static final int RESOURCE_OWNER_UNKNOWN;
    public static final int RESOURCE_OWNER_MAINUNIT;
    public static final int RESOURCE_OWNER_DEVICE;

    default public int getResourceId() {
    }

    default public int getOwner() {
    }

    default public OwnershipType getOwnershipType() {
    }
}

