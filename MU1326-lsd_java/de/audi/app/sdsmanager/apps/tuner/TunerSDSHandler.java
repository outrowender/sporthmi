/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.tuner;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService;

public interface TunerSDSHandler
extends ISDSApplication {
    public static final int INVALID_STATION;

    default public void setTunerService(TunerService tunerService) {
    }

    default public TunerService getTunerService() {
    }

    default public void unsetTunerService() {
    }

    default public void setTTSASR(ITTSASR iTTSASR) {
    }

    default public SDSListEntry getGenreById(long l) {
    }

    default public long getSelectedStationID() {
    }

    default public void setSelectedStationID(long l) {
    }

    default public SDSListEntry[] getFavoritesList() {
    }
}

