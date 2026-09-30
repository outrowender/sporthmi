/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class Resource
extends Enum<Resource> {
    public static final int COUNT = 7;
    public static final Resource SCREEN = new Resource(0, "SCREEN");
    public static final Resource AUDIO_MEDIA = new Resource(1, "AUDIO_MEDIA");
    public static final Resource AUDIO_PHONE = new Resource(2, "AUDIO_PHONE");
    public static final Resource AUDIO_SPEECH = new Resource(3, "AUDIO_SPEECH");
    public static final Resource AUDIO_RINGTONE = new Resource(4, "AUDIO_RINGTONE");
    public static final Resource NOTIFICATION = new Resource(5, "NOTIFICATION");
    public static final Resource AUDIO_GUIDANCE = new Resource(6, "AUDIO_GUIDANCE");
    private static final Resource[] internalList = new Resource[]{SCREEN, AUDIO_MEDIA, AUDIO_PHONE, AUDIO_SPEECH, AUDIO_RINGTONE, NOTIFICATION, AUDIO_GUIDANCE};

    private Resource(int n, String string) {
        super(n, string);
    }

    public static Resource[] values() {
        return (Resource[])internalList.clone();
    }
}

