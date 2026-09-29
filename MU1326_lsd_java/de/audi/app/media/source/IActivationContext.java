/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface IActivationContext {
    public static final String PLAYER_SELECTION_ON_STARTUP_BROWSER_INSTANCE;
    public static final String PLAYER_SELECTION_ON_STARTUP_TRACK_ID;
    public static final String RESTORE_LAST_STATE;
    public static final String PHYSICAL_PLAYER_ID;
    public static final String PLAYER_SELECTION_CALLBACK_HANDLER;
    public static final String RESTORE_BROWSER_PATH_POSSIBLE;
    public static final String DEMUTE;
    public static final String IS_STARTUP;
    public static final String VIDEO_FORMAT_HANDLER;
    public static final String CLOSE_DRAWER;
    public static final String REQUEST_AUDIO_IN_ADVANCE;

    default public ISourceSlot getSlot() {
    }

    default public Object getParameter(String string) {
    }
}

