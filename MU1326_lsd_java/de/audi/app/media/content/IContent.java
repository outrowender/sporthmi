/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.ButtonListener;

public interface IContent {
    public static final int CONTENT_TYPES = 9;
    public static final int CT_UNDEFINED = -1;
    public static final int CT_CDDA = 0;
    public static final int CT_DATA = 1;
    public static final int CT_DVDV = 2;
    public static final int CT_TV_BROADCAST = 3;
    public static final int CT_AV_STREAM = 4;
    public static final int CT_AUX_AUDIO_STREAM = 5;
    public static final int CT_AUX_VIDEO_STREAM = 6;
    public static final int CT_FILEPLAYER = 7;
    public static final int CT_ONLINEPLAYER = 8;

    public void init();

    public void deinit();

    public int getContentType();

    public ButtonListener getHardKeyListener();

    public void resetSettings();

    public void activate(IActivationContext var1);

    public void deactivate();

    public IActivationContext getContext();

    public boolean isActive();

    public ISourceSlot getActiveSlot();

    public void vehicleMoving(boolean var1);

    public void notifyContentActivationFinished();

    public void diagResetBrowser();
}

