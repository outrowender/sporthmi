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
    public static final int INVALID_STATION = -1;

    public void setTunerService(TunerService var1);

    public TunerService getTunerService();

    public void unsetTunerService();

    public void setTTSASR(ITTSASR var1);

    public SDSListEntry getGenreById(long var1);

    public long getSelectedStationID();

    public void setSelectedStationID(long var1);

    public SDSListEntry[] getFavoritesList();
}

