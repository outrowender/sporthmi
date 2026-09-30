/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;

public class FmStationListNAR
extends AbstractAmFmStationlistNar {
    private final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();

    public FmStationListNAR(TunerBasics tunerBasics, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler, MemoryListHandler memoryListHandler, int n) {
        super(tunerBasics, 100456, 100636, recordSets, abstractListRowFactory, aMFMTuner, 1, languageManager, iScanHandler, tunerStorage, iStoreHandler, memoryListHandler, n);
        this.listModel.setListener(new AbstractAmFmStationlistNar.ListListener(this, tunerBasics.getModels(), 100636));
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
        public void updateStationListFM(AMFMStation[] aMFMStationArray) {
            Object object = FmStationListNAR.this.mutex;
            synchronized (object) {
                FmStationListNAR.this.lastList = aMFMStationArray;
                FmStationListNAR.this.doListUpdate(false);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateSelectedStation(AMFMStation aMFMStation) {
            Object object = FmStationListNAR.this.mutex;
            synchronized (object) {
                if (aMFMStation.waveband == 1) {
                    FmStationListNAR.this.highlight(aMFMStation);
                }
            }
        }
    }
}

