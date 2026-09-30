/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.remotehmi.media.IMediaValues;

public interface IViewNpsListenerInterface {
    public void updateTimeValues();

    public void updateMetadataValues();

    public void setRadioMode(boolean var1);

    public void updateCover(String var1);

    public void updateBufferState(int var1);

    public void setBufferState(String var1);

    public void updateActiveSource(MediaSlotInfo var1);

    public IMediaValues getMediaValues();
}

