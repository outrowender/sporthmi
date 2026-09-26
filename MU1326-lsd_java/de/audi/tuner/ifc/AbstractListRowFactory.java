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
    private static long uniqueFavoriteId = 0;

    public static long getNextUniqueId() {
        return ++uniqueFavoriteId;
    }

    public abstract AbstractAmFmRow getAmFmListRow(int n, AMFMStation aMFMStation, RecordSets recordSets, int n2) {
    }

    public abstract int getNumOfCols(int n) {
    }

    public abstract DabListRow getDabListRow(de.audi.tuner.app.dab.stationlist.RecordSets recordSets, DabStation dabStation, boolean bl, int n) {
    }

    public abstract UniListRow getUniListRow(UnifiedStationExt unifiedStationExt, boolean bl, int n) {
    }

    public abstract SDARSListRow getSdarsListRow(StationInfoExt stationInfoExt, boolean bl, boolean bl2) {
    }

    public abstract AbstractMemoryRow getAmFmFavRow(AMFMStation aMFMStation, int n, int n2) {
    }

    public abstract AbstractMemoryRow getDabFavRow(TunerObjectContainer tunerObjectContainer, int n) {
    }

    public abstract AbstractMemoryRow getUniFavRow(UnifiedStationExt unifiedStationExt, int n) {
    }

    public abstract AbstractMemoryRow getSdarsFavRow(TunerObjectContainer tunerObjectContainer, int n, int n2) {
    }

    public abstract AbstractMemoryRow getEmptyFavRow(int n) {
    }

    public abstract AbstractMemoryRow getFavRow(TunerObjectContainer tunerObjectContainer, int n, int n2) {
    }

    public abstract EPGListRow[] getEpgRows(EPGShortInfoExt ePGShortInfoExt, long l) {
    }

    public AbstractSdarsEpgListRow[] getSdarsStationEpgRows(de.audi.tuner.app.epg.sdars.EPGShortInfoExt ePGShortInfoExt, long l) {
        return this.getSdarsGlobalEpgRows(ePGShortInfoExt, l, ePGShortInfoExt.epgProgramInfo.length);
    }

    public abstract AbstractSdarsEpgListRow[] getSdarsGlobalEpgRows(de.audi.tuner.app.epg.sdars.EPGShortInfoExt ePGShortInfoExt, long l, int n) {
    }

    public abstract AlertRow getSdarsAlertRow(StationInfoExt stationInfoExt, SeekEntry seekEntry, String string, String string2) {
    }

    public abstract ArtistTitleRow getSdarsArtistTitleRow(RadioText radioText, StationInfoExt stationInfoExt, int n) {
    }
}

