/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

public final class Resource
extends Enum {
    public static final int COUNT;
    public static final Resource SCREEN;
    public static final Resource AUDIO_MEDIA;
    public static final Resource AUDIO_PHONE;
    public static final Resource AUDIO_SPEECH;
    public static final Resource AUDIO_RINGTONE;
    public static final Resource NOTIFICATION;
    public static final Resource AUDIO_GUIDANCE;
    private static final Resource[] internalList;

    private Resource(int n, String string) {
        super(n, string);
    }

    public static Resource[] values() {
        return (Resource[])internalList.clone();
    }

    static {
        SCREEN = new Resource(0, "SCREEN");
        AUDIO_MEDIA = new Resource(1, "AUDIO_MEDIA");
        AUDIO_PHONE = new Resource(2, "AUDIO_PHONE");
        AUDIO_SPEECH = new Resource(3, "AUDIO_SPEECH");
        AUDIO_RINGTONE = new Resource(4, "AUDIO_RINGTONE");
        NOTIFICATION = new Resource(5, "NOTIFICATION");
        AUDIO_GUIDANCE = new Resource(6, "AUDIO_GUIDANCE");
        internalList = new Resource[]{SCREEN, AUDIO_MEDIA, AUDIO_PHONE, AUDIO_SPEECH, AUDIO_RINGTONE, NOTIFICATION, AUDIO_GUIDANCE};
    }
}

