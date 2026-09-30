/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;

public class TiStationList
extends AbstractAmFmStationlist {
    private final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();

    public TiStationList(TunerBasics tunerBasics, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler) {
        super(tunerBasics, 100460, 100664, recordSets, abstractListRowFactory, aMFMTuner, 10, languageManager, iScanHandler, tunerStorage, iStoreHandler, 2);
        this.lastList = Utilities.getTIStations();
    }

    public RadioInfo getDsiUpListener() {
        return this.dsiUpListener;
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateSelectedStation(AMFMStation aMFMStation) {
            Object object = TiStationList.this.mutex;
            synchronized (object) {
                if (aMFMStation.waveband == 3 && TiStationList.this.models.getActiveTuner() == 10) {
                    TiStationList.this.highlight(aMFMStation);
                }
            }
        }
    }
}

