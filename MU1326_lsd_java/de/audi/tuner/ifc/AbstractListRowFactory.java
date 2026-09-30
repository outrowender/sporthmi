/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.epg.dab.EPGListRow;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import de.audi.tuner.app.epg.sdars.AbstractSdarsEpgListRow;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sdars.SDARSListRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AlertRow;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UnifiedStationExt;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekEntry;

public abstract class AbstractListRowFactory {
    private static long uniqueFavoriteId = 1000L;

    public static long getNextUniqueId() {
        return ++uniqueFavoriteId;
    }

    public abstract AbstractAmFmRow getAmFmListRow(int var1, AMFMStation var2, RecordSets var3, int var4);

    public abstract int getNumOfCols(int var1);

    public abstract DabListRow getDabListRow(de.audi.tuner.app.dab.stationlist.RecordSets var1, DabStation var2, boolean var3, int var4);

    public abstract UniListRow getUniListRow(UnifiedStationExt var1, boolean var2, int var3);

    public abstract SDARSListRow getSdarsListRow(StationInfoExt var1, boolean var2, boolean var3);

    public abstract AbstractMemoryRow getAmFmFavRow(AMFMStation var1, int var2, int var3);

    public abstract AbstractMemoryRow getDabFavRow(TunerObjectContainer var1, int var2);

    public abstract AbstractMemoryRow getUniFavRow(UnifiedStationExt var1, int var2);

    public abstract AbstractMemoryRow getSdarsFavRow(TunerObjectContainer var1, int var2, int var3);

    public abstract AbstractMemoryRow getEmptyFavRow(int var1);

    public abstract AbstractMemoryRow getFavRow(TunerObjectContainer var1, int var2, int var3);

    public abstract EPGListRow[] getEpgRows(EPGShortInfoExt var1, long var2);

    public AbstractSdarsEpgListRow[] getSdarsStationEpgRows(de.audi.tuner.app.epg.sdars.EPGShortInfoExt ePGShortInfoExt, long l) {
        return this.getSdarsGlobalEpgRows(ePGShortInfoExt, l, ePGShortInfoExt.epgProgramInfo.length);
    }

    public abstract AbstractSdarsEpgListRow[] getSdarsGlobalEpgRows(de.audi.tuner.app.epg.sdars.EPGShortInfoExt var1, long var2, int var4);

    public abstract AlertRow getSdarsAlertRow(StationInfoExt var1, SeekEntry var2, String var3, String var4);

    public abstract ArtistTitleRow getSdarsArtistTitleRow(RadioText var1, StationInfoExt var2, int var3);
}

