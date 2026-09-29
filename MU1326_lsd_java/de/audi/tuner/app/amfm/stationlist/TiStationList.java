/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.amfm.stationlist.TiStationList$DsiUpListener;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;

public class TiStationList
extends AbstractAmFmStationlist {
    private final AMFMDsiUpInfo dsiUpListener = new TiStationList$DsiUpListener(this, null);

    public TiStationList(TunerBasics tunerBasics, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler) {
        super(tunerBasics, 1820852480, 948502784, recordSets, abstractListRowFactory, aMFMTuner, 10, languageManager, iScanHandler, tunerStorage, iStoreHandler, 2);
        this.lastList = Utilities.getTIStations();
    }

    @Override
    public RadioInfo getDsiUpListener() {
        return this.dsiUpListener;
    }
}

