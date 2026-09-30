/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;

public class AmStationList
extends AbstractAmFmStationlist {
    private final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();

    public AmStationList(TunerBasics tunerBasics, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler) {
        super(tunerBasics, 100457, 100637, recordSets, abstractListRowFactory, aMFMTuner, 4, languageManager, iScanHandler, tunerStorage, iStoreHandler, 2);
    }

    public RadioInfo getDsiUpListener() {
        return this.dsiUpListener;
    }

    protected int getUpdateReason(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        int n = super.getUpdateReason(aMFMStation, aMFMStation2);
        if (n == 0 && aMFMStation.getHdInfo().getTaggingStatus() != aMFMStation2.getHdInfo().getTaggingStatus()) {
            n = 3;
        }
        return n;
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateStationListAM(AMFMStation[] aMFMStationArray) {
            Object object = AmStationList.this.mutex;
            synchronized (object) {
                AmStationList.this.lastList = aMFMStationArray;
                AmStationList.this.doListUpdate(false);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateSelectedStation(AMFMStation aMFMStation) {
            Object object = AmStationList.this.mutex;
            synchronized (object) {
                if (aMFMStation.waveband == 3 && AmStationList.this.models.getActiveTuner() == 4) {
                    AmStationList.this.highlight(aMFMStation);
                }
            }
        }
    }
}

