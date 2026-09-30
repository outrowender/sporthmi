/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.sds;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerServiceListener;
import de.audi.tuner.app.Const;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.radio.EnsembleInfo;

public class TunerServiceHandler
extends DefaultUpdateListener
implements IUpdateListener {
    private final Map listeners = new HashMap();
    private IMemoryList memory = new IMemoryList(){

        public boolean isEmpty() {
            return true;
        }

        public PresetIds getPresetIds(TunerObjectContainer tunerObjectContainer) {
            return new PresetIds(0, 0);
        }

        public TunerObjectContainer[] getList(int[] nArray) {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer[] getList(int n) {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer[] getList() {
            return new TunerObjectContainer[0];
        }

        public boolean tuneByCombiID(int n, int n2) {
            return false;
        }
    };
    private final Logger logger;
    private int[] bands = new int[0];

    public TunerServiceHandler(TunerBasics tunerBasics) {
        this.logger = tunerBasics.getLogger();
    }

    public void addListener(TunerServiceListener tunerServiceListener) {
        this.logger.main.log(10000000, "[TunerServiceHandler.addListener] %1 %2", (Object)tunerServiceListener.getName(), (Object)tunerServiceListener);
        this.listeners.put(tunerServiceListener.getName(), tunerServiceListener);
        this.sendBandList(this.bands);
        this.updatedStationList(1);
        this.updatedStationList(4);
        this.updatedStationList(7);
        this.updatedStationList(5);
        this.updatedStationList(11);
        this.updatedMemoryList();
    }

    public void setFavortieListHandler(IMemoryList iMemoryList) {
        this.memory = iMemoryList;
        if (this.listeners.size() > 0) {
            this.updatedMemoryList();
        }
    }

    public void removeListener(TunerServiceListener tunerServiceListener) {
        this.logger.main.log(10000000, "[TunerServiceHandler.removeListener] %1 %2", (Object)tunerServiceListener.getName(), (Object)tunerServiceListener);
        this.listeners.remove(tunerServiceListener.getName());
    }

    private void updateStationListAMFM(int n) {
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getAmFmGUIHandler().getStationList(n);
        if (tunerObjectContainerArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            if (tunerObjectContainerArray[i2].getType() != 3) continue;
            String string = "";
            AMFMStation aMFMStation = tunerObjectContainerArray[i2].getAMFMService();
            if (!Utilities.isNARBuild()) {
                string = aMFMStation.getName();
            }
            if (Utilities.isEmpty(string)) {
                string = aMFMStation.getFrequencyString();
            }
            long l = aMFMStation.getUniqueId();
            arrayList.add(new SDSListEntry(string, l));
        }
        this.updateStationList((SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]), n);
        this.logger.sds.log(10000000, "[TunerServiceHAndler.updateStationListAMFM()] %1 stations band %2", (long)arrayList.size(), (long)n);
    }

    private void updateStationListDAB() {
        TunerObjectContainer[] tunerObjectContainerArray = Utilities.isPGen1OrBentley() ? TunerProxyManager.getInstance().getDabGUIHandler().getStationListHierarchical() : TunerProxyManager.getInstance().getDabGUIHandler().getStationList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        ArrayList arrayList2 = new ArrayList(10);
        block5: for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            String string = "";
            TunerObjectContainer tunerObjectContainer = tunerObjectContainerArray[i2];
            DabStation dabStation = tunerObjectContainer.getDABStation();
            switch (dabStation.getType()) {
                case 2: {
                    string = dabStation.service.fullName;
                    long l = dabStation.getUniqueId();
                    arrayList.add(new SDSListEntry(string, l));
                    continue block5;
                }
                case 3: {
                    string = dabStation.component.fullName;
                    long l = dabStation.getUniqueId();
                    arrayList.add(new SDSListEntry(string, l));
                    continue block5;
                }
                case 1: {
                    EnsembleInfo ensembleInfo = dabStation.ensemble;
                    if (i2 + 1 >= tunerObjectContainerArray.length) continue block5;
                    DabStation dabStation2 = tunerObjectContainerArray[i2 + 1].getDABStation();
                    string = ensembleInfo.fullName;
                    long l = dabStation2.getUniqueId();
                    arrayList2.add(new SDSListEntry(string, l));
                    continue block5;
                }
            }
        }
        this.updateStationList((SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]), 5);
        this.updateEnsembleList((SDSListEntry[])arrayList2.toArray(new SDSListEntry[arrayList2.size()]));
        this.logger.sds.log(10000000, "[TunerServiceHAndler.updateStationListDAB()] %1 stations", (long)arrayList.size());
    }

    private void updateStationListUni() {
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getUniGUIHandler().getStationList();
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[tunerObjectContainerArray.length];
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            UnifiedStationExt unifiedStationExt = tunerObjectContainerArray[i2].getUniStation();
            String string = unifiedStationExt.getName(true);
            long l = unifiedStationExt.getUniqueId();
            sDSListEntryArray[i2] = new SDSListEntry(string, l);
        }
        this.updateStationList(sDSListEntryArray, 11);
        this.logger.sds.log(10000000, "[TunerServiceHAndler.updateStationListUni()] %1 stations", (long)sDSListEntryArray.length);
    }

    private SimpleIntObjectMap updateStationListSDARS() {
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(64);
        TunerObjectContainer[] tunerObjectContainerArray = TunerProxyManager.getInstance().getSdarsGUIHandler().getStationList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        ArrayList arrayList2 = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            StationInfoExt stationInfoExt;
            if (tunerObjectContainerArray[i2].getType() != 5 || (stationInfoExt = tunerObjectContainerArray[i2].getSDARSService()) == null || stationInfoExt.subscription != 2) continue;
            String string = stationInfoExt.fullLabel;
            String string2 = String.valueOf(stationInfoExt.stationNumber);
            long l = RadioObjectIds.getSDARSObjectId(stationInfoExt.sID);
            arrayList.add(new SDSListEntry(string, l));
            arrayList2.add(new SDSListEntry(string2, l));
            simpleIntObjectMap.add(stationInfoExt.categoryNumber, stationInfoExt.getShortCategory());
        }
        this.updateStationList((SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]), 7);
        this.updateSdarsChannelNumberList((SDSListEntry[])arrayList2.toArray(new SDSListEntry[arrayList2.size()]));
        this.logger.sds.log(10000000, "[TunerServiceHAndler.updateStationListSDARS()] %1 stations", (long)arrayList.size());
        return simpleIntObjectMap;
    }

    private void updateGenreListSDARS(SimpleIntObjectMap simpleIntObjectMap) {
        SDSListEntry[] sDSListEntryArray = new SDSListEntry[simpleIntObjectMap.size()];
        int[] nArray = simpleIntObjectMap.getKeys();
        Object[] objectArray = simpleIntObjectMap.getValues();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            sDSListEntryArray[i2] = new SDSListEntry((String)objectArray[i2], nArray[i2]);
        }
        this.updateGenreList(sDSListEntryArray);
        this.logger.sds.log(10000000, "[TunerServiceHAndler.updateGenreListSDARS()] %1 stations", (long)sDSListEntryArray.length);
    }

    public void updatedMemoryList() {
        TunerObjectContainer[] tunerObjectContainerArray = this.memory.getList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            String string = "";
            long l = 0L;
            boolean bl = true;
            switch (tunerObjectContainerArray[i2].getType()) {
                case 3: {
                    AMFMStation aMFMStation = tunerObjectContainerArray[i2].getAMFMService();
                    string = aMFMStation.isRds() && !Utilities.isNARBuild() ? aMFMStation.getName() : aMFMStation.getFrequencyString();
                    l = RadioObjectIds.toFavoriteID(aMFMStation.getUniqueId());
                    break;
                }
                case 6: {
                    string = tunerObjectContainerArray[i2].getDABStation().service.getFullName();
                    l = RadioObjectIds.toFavoriteID(tunerObjectContainerArray[i2].getObjectID());
                    break;
                }
                case 7: {
                    string = tunerObjectContainerArray[i2].getUniStation().getLongName();
                    l = RadioObjectIds.toFavoriteID(tunerObjectContainerArray[i2].getObjectID());
                    break;
                }
                case 5: {
                    StationInfoExt stationInfoExt = tunerObjectContainerArray[i2].getSDARSService();
                    string = stationInfoExt.getFullLabel();
                    l = RadioObjectIds.toFavoriteID(RadioObjectIds.getSDARSObjectId(stationInfoExt.sID));
                    break;
                }
                default: {
                    bl = false;
                }
            }
            if (!bl) continue;
            arrayList.add(new SDSListEntry(string, l));
        }
        this.updateStationList((SDSListEntry[])arrayList.toArray(new SDSListEntry[arrayList.size()]), 12);
    }

    public void updatedBandList(int[] nArray) {
        if (!this.memory.isEmpty()) {
            boolean bl = false;
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                if (nArray[i2] != 12) continue;
                bl = true;
                break;
            }
            if (!bl) {
                int[] nArray2 = new int[nArray.length + 1];
                System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray.length);
                nArray2[nArray.length] = 12;
                nArray = nArray2;
            }
        }
        this.bands = nArray;
        this.sendBandList(this.bands);
    }

    public void updatedStationList(int n) {
        switch (n) {
            case 1: 
            case 4: {
                this.updateStationListAMFM(n);
                break;
            }
            case 5: {
                this.updateStationListDAB();
                break;
            }
            case 11: {
                this.updateStationListUni();
                break;
            }
            case 7: {
                SimpleIntObjectMap simpleIntObjectMap = this.updateStationListSDARS();
                this.updateGenreListSDARS(simpleIntObjectMap);
                break;
            }
        }
    }

    private void sendBandList(int[] nArray) {
        this.logger.main.log(1000000, "[TunerServiceHandler.updateBandList]");
        this.logger.dd.log(10000000, "List: %1", (Object)nArray);
        int[] nArray2 = new int[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray2[i2] = Const.radioBand2SdsBand(nArray[i2]);
        }
        Iterator iterator = this.listeners.keySet().iterator();
        while (iterator.hasNext()) {
            TunerServiceListener tunerServiceListener = (TunerServiceListener)this.listeners.get(iterator.next());
            try {
                tunerServiceListener.updateBandList(nArray2);
            }
            catch (Exception exception) {
                this.logger.main.log(10000, "[TunerServiceHandler.updateBandList] Calling %1 failed!", (Object)tunerServiceListener, (Throwable)exception);
            }
        }
    }

    private void updateEnsembleList(SDSListEntry[] sDSListEntryArray) {
        this.logger.main.log(1000000, "[TunerServiceHandler.updateEnsembleList] #%1", (long)sDSListEntryArray.length);
        this.dumpList(sDSListEntryArray);
        Iterator iterator = this.listeners.keySet().iterator();
        while (iterator.hasNext()) {
            TunerServiceListener tunerServiceListener = (TunerServiceListener)this.listeners.get(iterator.next());
            try {
                tunerServiceListener.updateEnsembleList(sDSListEntryArray);
            }
            catch (Exception exception) {
                this.logger.main.log(10000, "[TunerServiceHandler.updateEnsembleList] Calling %1 failed!", (Object)tunerServiceListener, (Throwable)exception);
            }
        }
    }

    private void updateStationList(SDSListEntry[] sDSListEntryArray, int n) {
        this.logger.main.log(1000000, "[TunerServiceHandler.updateStationList]");
        this.dumpList(sDSListEntryArray);
        Iterator iterator = this.listeners.keySet().iterator();
        while (iterator.hasNext()) {
            TunerServiceListener tunerServiceListener = (TunerServiceListener)this.listeners.get(iterator.next());
            try {
                tunerServiceListener.updateStationList(sDSListEntryArray, Const.radioBand2SdsBand(n));
            }
            catch (Exception exception) {
                this.logger.main.log(10000, "[TunerServiceHandler.updateStationList] Calling %1 failed!", (Object)tunerServiceListener, (Throwable)exception);
            }
        }
    }

    private void updateSdarsChannelNumberList(SDSListEntry[] sDSListEntryArray) {
        this.logger.main.log(1000000, "[TunerServiceHandler.updateSdarsChannelNumberList]");
        this.dumpList(sDSListEntryArray);
        Iterator iterator = this.listeners.keySet().iterator();
        while (iterator.hasNext()) {
            TunerServiceListener tunerServiceListener = (TunerServiceListener)this.listeners.get(iterator.next());
            try {
                tunerServiceListener.updateChannelNumberList(sDSListEntryArray);
            }
            catch (Exception exception) {
                this.logger.main.log(10000, "[TunerServiceHandler.updateSdarsChannelNumberList] Calling %1 failed!", (Object)tunerServiceListener, (Throwable)exception);
            }
        }
    }

    private void updateGenreList(SDSListEntry[] sDSListEntryArray) {
        this.logger.main.log(1000000, "[TunerServiceHandler.updateGenreList]");
        this.dumpList(sDSListEntryArray);
        Iterator iterator = this.listeners.keySet().iterator();
        while (iterator.hasNext()) {
            TunerServiceListener tunerServiceListener = (TunerServiceListener)this.listeners.get(iterator.next());
            try {
                tunerServiceListener.updateGenreList(sDSListEntryArray);
            }
            catch (Exception exception) {
                this.logger.main.log(10000, "[TunerServiceHandler.updateGenreList] Calling %1 failed!", (Object)tunerServiceListener, (Throwable)exception);
            }
        }
    }

    private void dumpList(SDSListEntry[] sDSListEntryArray) {
        if (this.logger.dd.getCurrentLogThreshold() >= 10000000) {
            for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
                this.logger.dd.log(10000000, "[%2] %1", (Object)sDSListEntryArray[i2], (long)i2);
            }
        }
    }
}

