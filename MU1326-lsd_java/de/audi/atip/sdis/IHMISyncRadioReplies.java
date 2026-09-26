/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncRadioReplies$RadioNameIdPair;
import de.audi.atip.sdis.IHMISyncRadioReplies$RadioStationInfo;

public interface IHMISyncRadioReplies {
    default public void updateBandList(RadioNameIdPair[] radioNameIdPairArray) {
    }

    default public void updateActiveBand(int n) {
    }

    default public void updateRadioStationList(RadioStationInfo[] radioStationInfoArray) {
    }

    default public void updateActiveStation(int n) {
    }

    default public void updateActiveStationInfo(String[] stringArray) {
    }

    default public void updateSlideshowInfo(String string) {
    }
}

