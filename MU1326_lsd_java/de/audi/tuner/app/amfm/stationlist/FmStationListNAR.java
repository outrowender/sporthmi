/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$ListListener;
import de.audi.tuner.app.amfm.stationlist.FmStationListNAR$DsiUpListener;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AbstractListRowFactory;
import de.audi.tuner.ifc.IScanHandler;

public class FmStationListNAR
extends AbstractAmFmStationlistNar {
    private final AMFMDsiUpInfo dsiUpListener = new FmStationListNAR$DsiUpListener(this, null);

    public FmStationListNAR(TunerBasics tunerBasics, RecordSets recordSets, AbstractListRowFactory abstractListRowFactory, AMFMTuner aMFMTuner, LanguageManager languageManager, IScanHandler iScanHandler, TunerStorage tunerStorage, IStoreHandler iStoreHandler, MemoryListHandler memoryListHandler, int n) {
        super(tunerBasics, 1753743616, 478740736, recordSets, abstractListRowFactory, aMFMTuner, 1, languageManager, iScanHandler, tunerStorage, iStoreHandler, memoryListHandler, n);
        this.listModel.setListener(new AbstractAmFmStationlistNar$ListListener(this, tunerBasics.getModels(), 478740736));
    }

    @Override
    public RadioInfo getDsiUpListener() {
        return this.dsiUpListener;
    }
}

