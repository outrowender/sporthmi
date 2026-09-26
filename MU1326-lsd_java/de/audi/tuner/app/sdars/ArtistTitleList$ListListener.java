/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.sdars.ArtistTitleList$1;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sdars.StationInfoExt;

class ArtistTitleList$ListListener
extends DefaultBaseListModelListener {
    private ArtistTitleList$ListListener() {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        ArtistTitleRow artistTitleRow = (ArtistTitleRow)evoListRow;
        StationInfoExt stationInfoExt = artistTitleRow.getStation();
        TunerProxyManager.getInstance().getSDARSTuner().selectStation(stationInfoExt, 0);
    }

    /* synthetic */ ArtistTitleList$ListListener(ArtistTitleList$1 artistTitleList$1) {
        this();
    }
}

