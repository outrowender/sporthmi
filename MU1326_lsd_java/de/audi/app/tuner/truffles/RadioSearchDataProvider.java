/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.app.tuner.truffles.NullDSISearchDataProvider;
import de.audi.app.tuner.truffles.RadioSearchDataProvider$InvalidationTruffleCmd;
import de.audi.app.tuner.truffles.RadioSearchDataProvider$RadioUpdates;
import de.audi.app.tuner.truffles.RadioSearchDataProvider$SearchBreakListener;
import de.audi.app.tuner.truffles.SearchUtil;
import de.audi.app.tuner.truffles.TrufflesCommandHandler;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.app.AppTunerTextConstants;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.dsi.ifc.search.DSISearchDataProviderListener;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;

public class RadioSearchDataProvider
implements DSISearchDataProviderListener {
    public final IUpdateListener updateListener = new RadioSearchDataProvider$RadioUpdates(this, null);
    public final ISearchBreak searchListener = new RadioSearchDataProvider$SearchBreakListener(this, null);
    private final Logger logger;
    private final MemoryListHandler memory;
    private DSISearchDataProvider dsi;
    private final SimpleIntIntMap waitingInvalids = new SimpleIntIntMap(10);
    private boolean searchIsBlocked;
    private final IHMIServiceApp hmiService = Utilities.getHMIServiceApp();
    private final TrufflesCommandHandler cmdHandler;
    private final ISearchGUI searchGUI;

    public RadioSearchDataProvider(TunerBasics tunerBasics, MemoryListHandler memoryListHandler, TrufflesCommandHandler trufflesCommandHandler, ISearchGUI iSearchGUI) {
        this.logger = tunerBasics.getLogger();
        this.memory = memoryListHandler;
        this.dsi = new NullDSISearchDataProvider(this.logger.truffles);
        this.cmdHandler = trufflesCommandHandler;
        this.searchGUI = iSearchGUI;
    }

    public void setDeviceService(DSIBase dSIBase) {
        this.dsi = (DSISearchDataProvider)dSIBase;
        this.init();
    }

    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSISearchDataProvider);
    }

    private void init() {
        this.dsi.registerProviderSource(20017);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.asyncException] %1", (Object)string);
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.registerProviderSourceResult] success:%1 source:%2", (long)n, (long)n2);
    }

    @Override
    public void activateProviderSource(int n) {
        this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.activateProviderSource] %1", (long)n);
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.invalidateAllDataResult] success:%1 source:%2", (long)n, (long)n2);
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        try {
            this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.provideData] source:%1 offset:%2 count:%3", (long)n, (long)n2, (long)n3);
            int n4 = SearchUtil.getBandBySource(n);
            DataSet[] dataSetArray = new DataSet[]{};
            switch (n4) {
                case 1: 
                case 4: {
                    dataSetArray = this.makeAmFmList(n4);
                    break;
                }
                case 5: {
                    dataSetArray = this.makeDabList();
                    break;
                }
                case 11: {
                    dataSetArray = this.makeUniList();
                    break;
                }
                case 7: {
                    dataSetArray = this.makeSdarsList();
                    break;
                }
                case 12: {
                    dataSetArray = this.makeFavList();
                    break;
                }
            }
            int n5 = dataSetArray.length - n2;
            n5 = n5 > 0 ? Math.min(n5, n3) : 0;
            DataSet[] dataSetArray2 = new DataSet[n5];
            if (n5 > 0) {
                System.arraycopy((Object)dataSetArray, n2, (Object)dataSetArray2, 0, n5);
            }
            this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.provideData] source:%1 count:%2", (long)n, (long)dataSetArray2.length);
            this.dsi.storeDataSets(n, dataSetArray2, dataSetArray2.length);
        }
        catch (Exception exception) {
            this.logger.truffles.log(10000, "%1", (Throwable)exception);
        }
    }

    private DataSet[] makeFavList() {
        TunerObjectContainer[] tunerObjectContainerArray = this.memory.getList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            TunerObjectContainer tunerObjectContainer = tunerObjectContainerArray[i2];
            if (tunerObjectContainer == null || tunerObjectContainer.getType() == -1) continue;
            DataSet dataSet = null;
            switch (tunerObjectContainer.getType()) {
                case 3: {
                    dataSet = this.getAmFmDataSet(tunerObjectContainer.getAMFMService(), true);
                    break;
                }
                case 6: {
                    dataSet = this.getDabDataSet(tunerObjectContainer.getDABStation(), true);
                    break;
                }
                case 7: {
                    dataSet = this.getUniDataSet(tunerObjectContainer.getUniStation(), true);
                    break;
                }
                case 5: {
                    if (tunerObjectContainer.getSDARSService().getSubscription() != 2) break;
                    dataSet = this.getSdarsDataSet(tunerObjectContainer.getSDARSService(), true);
                    break;
                }
            }
            if (dataSet == null) continue;
            long l = dataSet.id & 0;
            dataSet.id = (long)tunerObjectContainer.getPresetPos() << 8 | l;
            arrayList.add(dataSet);
        }
        return (DataSet[])arrayList.toArray(new DataSet[arrayList.size()]);
    }

    private DataSet[] makeDabList() {
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getDabGUIHandler().getStationList(5);
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            DabStation dabStation = tunerObjectContainerArray[i2].getDABStation();
            if (dabStation.isEnsemble() || dabStation.ensemble.ensID == 0) continue;
            arrayList.add(this.getDabDataSet(dabStation, false));
        }
        return (DataSet[])arrayList.toArray(new DataSet[arrayList.size()]);
    }

    private DataSet getDabDataSet(DabStation dabStation, boolean bl) {
        long l = bl ? RadioObjectIds.toFavoriteID(dabStation.getUniqueId()) : dabStation.getUniqueId();
        return new DataSet(l, 4096, 0, new Searchable[]{new Searchable(22, dabStation.getFullName(), 0), new Searchable(23, dabStation.getShortName(), 0), new Searchable(24, this.hmiService.getText(AppTunerTextConstants.TEXT_CONST_TUNER_PTY[dabStation.getPTY()]), 0)});
    }

    private DataSet getAmFmDataSet(AMFMStation aMFMStation, boolean bl) {
        String string;
        long l;
        long l2 = l = bl ? RadioObjectIds.toFavoriteID(aMFMStation.getUniqueId()) : aMFMStation.getUniqueId();
        if (Utilities.isSinglePiMode()) {
            String string2 = Utilities.isEmpty(aMFMStation.name) ? aMFMStation.getFrequencyString() : aMFMStation.name;
            return new DataSet(l, 4096, 0, new Searchable[]{new Searchable(22, string2, 0), new Searchable(24, this.hmiService.getText(AppTunerTextConstants.TEXT_CONST_TUNER_PTY[aMFMStation.ptyCode]), 0)});
        }
        String string3 = string = aMFMStation.hd ? aMFMStation.getHDNameAndExt() : aMFMStation.name;
        if (Utilities.isEmpty(string)) {
            return new DataSet(l, 4096, 0, new Searchable[]{new Searchable(24, aMFMStation.getFrequencyString(), 0)});
        }
        return new DataSet(l, 4096, 0, new Searchable[]{new Searchable(24, aMFMStation.getFrequencyString(), 0), new Searchable(22, string, 0)});
    }

    private DataSet[] makeAmFmList(int n) {
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getAmFmGUIHandler().getStationList(n);
        DataSet[] dataSetArray = new DataSet[tunerObjectContainerArray.length];
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            AMFMStation aMFMStation = tunerObjectContainerArray[i2].getAMFMService();
            dataSetArray[i2] = this.getAmFmDataSet(aMFMStation, false);
        }
        return dataSetArray;
    }

    private DataSet[] makeUniList() {
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getUniGUIHandler().getStationList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            UnifiedStationExt unifiedStationExt = tunerObjectContainerArray[i2].getUniStation();
            arrayList.add(this.getUniDataSet(unifiedStationExt, false));
        }
        return (DataSet[])arrayList.toArray(new DataSet[arrayList.size()]);
    }

    private DataSet getUniDataSet(UnifiedStationExt unifiedStationExt, boolean bl) {
        long l = bl ? RadioObjectIds.toFavoriteID(unifiedStationExt.getUniqueId()) : unifiedStationExt.getUniqueId();
        return new DataSet(l, 4096, 0, new Searchable[]{new Searchable(22, unifiedStationExt.getLongName(), 0), new Searchable(23, unifiedStationExt.getName(true), 0), new Searchable(24, this.hmiService.getText(AppTunerTextConstants.TEXT_CONST_TUNER_PTY[unifiedStationExt.getPty()]), 0)});
    }

    private DataSet[] makeSdarsList() {
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getSdarsGUIHandler().getStationList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            StationInfoExt stationInfoExt = tunerObjectContainerArray[i2].getSDARSService();
            if (stationInfoExt.subscription != 2) continue;
            arrayList.add(this.getSdarsDataSet(stationInfoExt, false));
        }
        return (DataSet[])arrayList.toArray(new DataSet[arrayList.size()]);
    }

    private DataSet getSdarsDataSet(StationInfoExt stationInfoExt, boolean bl) {
        long l = bl ? RadioObjectIds.toFavoriteID(stationInfoExt.getUniqueId()) : stationInfoExt.getUniqueId();
        return new DataSet(l, 4096, 0, new Searchable[]{new Searchable(22, stationInfoExt.shortLabel, 0), new Searchable(23, stationInfoExt.getShortCategory(), 0), new Searchable(24, Utilities.getFormatedStationNumber(stationInfoExt.stationNumber), 0)});
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.storeDataSetsResult] success:%1 source:%2", (long)n, (long)n2);
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        this.logger.truffles.log(-2137614336, "[RadioSearchDataProvider.deleteDataSetResult] success:%1 source:%2 dataSetId%3", (long)n, (long)n2, l);
    }

    private void invalidateData(int n) {
        this.cmdHandler.add(new RadioSearchDataProvider$InvalidationTruffleCmd(this, n));
        this.searchGUI.runCommands();
    }

    static /* synthetic */ DSISearchDataProvider access$200(RadioSearchDataProvider radioSearchDataProvider) {
        return radioSearchDataProvider.dsi;
    }

    static /* synthetic */ Logger access$300(RadioSearchDataProvider radioSearchDataProvider) {
        return radioSearchDataProvider.logger;
    }

    static /* synthetic */ SimpleIntIntMap access$400(RadioSearchDataProvider radioSearchDataProvider) {
        return radioSearchDataProvider.waitingInvalids;
    }

    static /* synthetic */ boolean access$500(RadioSearchDataProvider radioSearchDataProvider) {
        return radioSearchDataProvider.searchIsBlocked;
    }

    static /* synthetic */ void access$600(RadioSearchDataProvider radioSearchDataProvider, int n) {
        radioSearchDataProvider.invalidateData(n);
    }

    static /* synthetic */ boolean access$502(RadioSearchDataProvider radioSearchDataProvider, boolean bl) {
        radioSearchDataProvider.searchIsBlocked = bl;
        return radioSearchDataProvider.searchIsBlocked;
    }
}

