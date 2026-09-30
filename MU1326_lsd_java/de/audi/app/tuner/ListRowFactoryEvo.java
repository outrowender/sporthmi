/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.audi.app.tuner.amfm.stationlist.AmListRowEvo;
import de.audi.app.tuner.amfm.stationlist.FmListRowEvo;
import de.audi.app.tuner.dab.stationlist.DabListRowEvo;
import de.audi.app.tuner.favorites.AmFmFavRowEvo;
import de.audi.app.tuner.favorites.DABFavRowEvo;
import de.audi.app.tuner.favorites.EmptyFavRowEvo;
import de.audi.app.tuner.favorites.SDARSFavRowEvo;
import de.audi.app.tuner.favorites.UniFavRowEvo;
import de.audi.app.tuner.uni.stationlist.UniListRowEvo;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.dab.stationlist.RecordSets;
import de.audi.tuner.app.epg.dab.EPGListRow;
import de.audi.tuner.app.epg.dab.EPGListRowInfo;
import de.audi.tuner.app.epg.dab.EPGListRowServiceName;
import de.audi.tuner.app.epg.sdars.AbstractSdarsEpgListRow;
import de.audi.tuner.app.epg.sdars.EPGShortInfoExt;
import de.audi.tuner.app.epg.sdars.ProgramSdarsEpgListRow;
import de.audi.tuner.app.epg.sdars.StationSdarsEpgListRow;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sdars.SDARSListRow;
import de.audi.tuner.app.sdars.SDARSListRowEvo;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AlertRow;
import de.audi.tuner.app.sdars.seek.AlertRowEvo;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AbstractListRowFactory;
import org.dsi.ifc.sdars.EPGProgramInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekEntry;

public class ListRowFactoryEvo
extends AbstractListRowFactory {
    public AbstractAmFmRow getAmFmListRow(int n, AMFMStation aMFMStation, de.audi.tuner.app.amfm.stationlist.RecordSets recordSets, int n2) {
        switch (n) {
            case 1: {
                return new FmListRowEvo(aMFMStation, recordSets, n2);
            }
            case 4: 
            case 10: {
                return new AmListRowEvo(aMFMStation, recordSets, n2);
            }
        }
        throw new IllegalStateException("[ListRowFactoryEvo.makeRow] band " + n);
    }

    public int getNumOfCols(int n) {
        switch (n) {
            case 1: {
                return 23;
            }
            case 4: {
                return 19;
            }
            case 5: {
                return 17;
            }
            case 12: {
                return 23;
            }
        }
        throw new IllegalStateException("[ListRowFactoryEvo.getNumOfCols] band " + n);
    }

    public DabListRow getDabListRow(RecordSets recordSets, DabStation dabStation, boolean bl, int n) {
        return new DabListRowEvo(recordSets, dabStation, bl, n);
    }

    public UniListRow getUniListRow(UnifiedStationExt unifiedStationExt, boolean bl, int n) {
        return new UniListRowEvo(unifiedStationExt, bl, n);
    }

    public SDARSListRow getSdarsListRow(StationInfoExt stationInfoExt, boolean bl, boolean bl2) {
        return new SDARSListRowEvo(stationInfoExt, bl, bl2);
    }

    public AbstractMemoryRow getAmFmFavRow(AMFMStation aMFMStation, int n, int n2) {
        return new AmFmFavRowEvo(aMFMStation, n, n2);
    }

    public AbstractMemoryRow getDabFavRow(TunerObjectContainer tunerObjectContainer, int n) {
        return new DABFavRowEvo(tunerObjectContainer, n);
    }

    public AbstractMemoryRow getUniFavRow(UnifiedStationExt unifiedStationExt, int n) {
        return new UniFavRowEvo(unifiedStationExt, n);
    }

    public AbstractMemoryRow getSdarsFavRow(TunerObjectContainer tunerObjectContainer, int n, int n2) {
        return new SDARSFavRowEvo(tunerObjectContainer.getSDARSService(), n);
    }

    public AbstractMemoryRow getEmptyFavRow(int n) {
        return new EmptyFavRowEvo(n);
    }

    public AbstractMemoryRow getFavRow(TunerObjectContainer tunerObjectContainer, int n, int n2) {
        switch (tunerObjectContainer.getType()) {
            case 3: {
                return new AmFmFavRowEvo(tunerObjectContainer.getAMFMService(), n, n2);
            }
            case 6: {
                return new DABFavRowEvo(tunerObjectContainer, n2);
            }
            case 7: {
                return new UniFavRowEvo(tunerObjectContainer.getUniStation(), n2);
            }
            case 5: {
                return new SDARSFavRowEvo(tunerObjectContainer.getSDARSService(), n);
            }
        }
        throw new IllegalArgumentException();
    }

    public EPGListRow[] getEpgRows(de.audi.tuner.app.epg.dab.EPGShortInfoExt ePGShortInfoExt, long l) {
        EPGListRowServiceName ePGListRowServiceName = new EPGListRowServiceName(ePGShortInfoExt);
        EPGListRowInfo ePGListRowInfo = new EPGListRowInfo(ePGShortInfoExt, 1, l);
        EPGListRowInfo ePGListRowInfo2 = new EPGListRowInfo(ePGShortInfoExt, 2, l);
        return new EPGListRow[]{ePGListRowServiceName, ePGListRowInfo, ePGListRowInfo2};
    }

    public AbstractSdarsEpgListRow[] getSdarsGlobalEpgRows(EPGShortInfoExt ePGShortInfoExt, long l, int n) {
        StationInfoExt stationInfoExt = ePGShortInfoExt.station;
        int n2 = 1 + Math.min(n, ePGShortInfoExt.epgProgramInfo.length);
        AbstractSdarsEpgListRow[] abstractSdarsEpgListRowArray = new AbstractSdarsEpgListRow[n2];
        abstractSdarsEpgListRowArray[0] = new StationSdarsEpgListRow(stationInfoExt);
        for (int i2 = 1; i2 < n2; ++i2) {
            EPGProgramInfo ePGProgramInfo = ePGShortInfoExt.epgProgramInfo[i2 - 1];
            abstractSdarsEpgListRowArray[i2] = new ProgramSdarsEpgListRow(stationInfoExt, ePGProgramInfo, i2, l);
        }
        return abstractSdarsEpgListRowArray;
    }

    public AlertRow getSdarsAlertRow(StationInfoExt stationInfoExt, SeekEntry seekEntry, String string, String string2) {
        return new AlertRowEvo(stationInfoExt, seekEntry, string, string2);
    }

    public ArtistTitleRow getSdarsArtistTitleRow(RadioText radioText, StationInfoExt stationInfoExt, int n) {
        return new ArtistTitleRow(radioText, stationInfoExt, n);
    }
}

