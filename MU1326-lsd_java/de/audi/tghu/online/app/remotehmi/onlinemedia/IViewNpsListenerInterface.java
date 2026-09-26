/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.remotehmi.media.IMediaValues;

public interface IViewNpsListenerInterface {
    default public void updateTimeValues() {
    }

    default public void updateMetadataValues() {
    }

    default public void setRadioMode(boolean bl) {
    }

    default public void updateCover(String string) {
    }

    default public void updateBufferState(int n) {
    }

    default public void setBufferState(String string) {
    }

    default public void updateActiveSource(MediaSlotInfo mediaSlotInfo) {
    }

    default public IMediaValues getMediaValues() {
    }
}

