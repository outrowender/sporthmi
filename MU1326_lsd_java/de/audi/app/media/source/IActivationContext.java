/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface IActivationContext {
    public static final String PLAYER_SELECTION_ON_STARTUP_BROWSER_INSTANCE = "SETPLAYSELECTION_BROWSERID";
    public static final String PLAYER_SELECTION_ON_STARTUP_TRACK_ID = "SETPLAYSELECTION_TRACKID";
    public static final String RESTORE_LAST_STATE = "RESTORE_STATE";
    public static final String PHYSICAL_PLAYER_ID = "PHYSICAL_PLAYER_ID";
    public static final String PLAYER_SELECTION_CALLBACK_HANDLER = "PLAYER_SELECTION_CALLBACK_HANDLER";
    public static final String RESTORE_BROWSER_PATH_POSSIBLE = "RESTORE_BROWSER_PATH_POSSIBLE";
    public static final String DEMUTE = "DEMUTE";
    public static final String IS_STARTUP = "IS_STARTUP";
    public static final String VIDEO_FORMAT_HANDLER = "VIDEO_FORMAT_HANDLER";
    public static final String CLOSE_DRAWER = "CLOSE_DRAWER";
    public static final String REQUEST_AUDIO_IN_ADVANCE = "REQUEST_AUDIO_IN_ADVANCE";

    public ISourceSlot getSlot();

    public Object getParameter(String var1);
}

