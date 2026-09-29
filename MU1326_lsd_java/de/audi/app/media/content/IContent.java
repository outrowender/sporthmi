/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.ButtonListener;

public interface IContent {
    public static final int CONTENT_TYPES;
    public static final int CT_UNDEFINED;
    public static final int CT_CDDA;
    public static final int CT_DATA;
    public static final int CT_DVDV;
    public static final int CT_TV_BROADCAST;
    public static final int CT_AV_STREAM;
    public static final int CT_AUX_AUDIO_STREAM;
    public static final int CT_AUX_VIDEO_STREAM;
    public static final int CT_FILEPLAYER;
    public static final int CT_ONLINEPLAYER;

    default public void init() {
    }

    default public void deinit() {
    }

    default public int getContentType() {
    }

    default public ButtonListener getHardKeyListener() {
    }

    default public void resetSettings() {
    }

    default public void activate(IActivationContext iActivationContext) {
    }

    default public void deactivate() {
    }

    default public IActivationContext getContext() {
    }

    default public boolean isActive() {
    }

    default public ISourceSlot getActiveSlot() {
    }

    default public void vehicleMoving(boolean bl) {
    }

    default public void notifyContentActivationFinished() {
    }

    default public void diagResetBrowser() {
    }
}

