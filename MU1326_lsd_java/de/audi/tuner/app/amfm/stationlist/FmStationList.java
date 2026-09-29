/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.FmStationList$DsiUpListener;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;

public class FmStationList
extends AbstractAmFmStationlist {
    private final AMFMDsiUpInfo dsiUpListener = new FmStationList$DsiUpListener(this, null);

    public FmStationList(TunerBasics tunerBasics, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler, int n) {
        super(tunerBasics, 1753743616, 478740736, recordSets, abstractListRowFactory, aMFMTuner, 1, languageManager, iScanHandler, tunerStorage, iStoreHandler, n);
    }

    @Override
    public RadioInfo getDsiUpListener() {
        return this.dsiUpListener;
    }
}

