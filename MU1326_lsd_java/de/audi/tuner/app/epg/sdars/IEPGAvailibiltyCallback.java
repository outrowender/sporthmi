/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.sdars.StationInfoExt;

public interface IEPGAvailibiltyCallback {
    public static final IEPGAvailibiltyCallback DUMMY = new IEPGAvailibiltyCallback(){

        public void epgAvailibiltyChanged(StationInfoExt stationInfoExt, boolean bl) {
        }
    };

    public void epgAvailibiltyChanged(StationInfoExt var1, boolean var2);
}

