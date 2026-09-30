/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.sdars.SDARSSetupHandler;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.sdars.CategoryInfo;

public class GUIHandlerSDARS
extends DefaultButtonListener
implements ITunerGUIHandler {
    private int[] channelNumbers;
    private int activeChannelIndex;
    private SimpleIntObjectMap chNumNameMap = new SimpleIntObjectMap();
    private final Logger logger;
    private final TunerModels models;
    private final SDARSTuner sdarsTuner;
    private final SDARSSetupHandler setupHandler;
    private final SDARSStationListHandler stationListHandler;
    private final SDARSEPGHandler epgHandler;
    private final ChoiceListener choiceListener;

    GUIHandlerSDARS(SDARSTuner sDARSTuner, TunerBasics tunerBasics, TunerStorage tunerStorage, SDARSStationListHandler sDARSStationListHandler, SDARSEPGHandler sDARSEPGHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        tunerBasics.getStatus();
        this.sdarsTuner = sDARSTuner;
        this.epgHandler = sDARSEPGHandler;
        this.choiceListener = new ChoiceListener();
        this.setupHandler = new SDARSSetupHandler(this.logger, tunerStorage);
        this.setupHandler.init();
        this.stationListHandler = sDARSStationListHandler;
        this.initModels();
    }

    private void initModels() {
        this.models.getChoiceModel(100154).setValue(0);
        this.models.getButtonModel(100157).setStatus(0);
        this.models.getChoiceModel(100583).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100420).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(100653).setChoiceListener(this.choiceListener);
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        this.stationListHandler.register(iStoreStationHandler);
    }

    public IPowerEvent getPoPowerStateListener() {
        return new IPowerEvent(){

            public void notifyPowerEvent(int n, int n2) {
            }
        };
    }

    public SDARSStationListHandler getSdarsListHandler() {
        return this.stationListHandler;
    }

    public IStationListHandler getStationListHandler() {
        return this.stationListHandler;
    }

    public void setPowerState(int n) {
    }

    public int getDisplayedStationNumber() {
        this.logger.sdarsRadioText.log(10000000, "getDisplayedStationNumber activeChannelIndex: %1", (long)this.getActiveChannelIndex());
        if (this.getActiveChannelIndex() >= 0 && this.getActiveChannelIndex() < this.channelNumbers.length) {
            int n = this.channelNumbers[this.activeChannelIndex];
            this.logger.sdarsRadioText.log(10000000, "getDisplayedStationNumber chNumber: %1", (long)n);
            return n;
        }
        this.logger.sdarsRadioText.log(10000000, "getDisplayedStationNumber index out of range");
        return -1;
    }

    private int getActiveChannelIndex() {
        return this.activeChannelIndex;
    }

    public boolean tuneById(long l, int n) {
        return this.stationListHandler.tuneById(l, n);
    }

    public TunerObjectContainer[] getStationList() {
        return this.stationListHandler.getStationList();
    }

    public TunerObjectContainer[] getStationList(int n) {
        return this.stationListHandler.getStationList();
    }

    public TunerObjectContainer getCurrentStation() {
        return this.sdarsTuner.getLabels().getActiveStation();
    }

    void initSetup() {
        int[] nArray = this.setupHandler.getCurrentSetup();
        if (nArray != null) {
            this.choiceListener.itemSelected(100583, nArray[2], 0, 0);
            this.models.getChoiceModel(100420).setValue(nArray[4]);
            this.models.getChoiceModel(100653).setValue(nArray[3]);
        }
    }

    public SDARSSetupHandler getSetupHandler() {
        return this.setupHandler;
    }

    public void setChannelNumberNameMapping(StationInfoExt[] stationInfoExtArray) {
        this.chNumNameMap = new SimpleIntObjectMap(stationInfoExtArray.length);
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            if (stationInfoExtArray[i2].stationNumber == 0) {
                this.models.getLabelModel(100153).setText(stationInfoExtArray[i2].fullLabel);
                this.models.getResourceLocatorModel(100712).setResourceLocator(stationInfoExtArray[i2].getStationArt());
                continue;
            }
            this.chNumNameMap.add(stationInfoExtArray[i2].stationNumber, stationInfoExtArray[i2]);
        }
        this.channelNumbers = this.chNumNameMap.getKeys();
    }

    StationInfoExt getStationByChannelNumber(int n) {
        return (StationInfoExt)this.chNumNameMap.get(n);
    }

    public CategoryInfo[] getSdarsCategoryList() {
        return this.stationListHandler.getSdarsCategoryList();
    }

    void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.stationListHandler.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    public void resetToDefaultSettings() {
        this.choiceListener.itemSelected(100583, 0, 0, 0);
        this.stationListHandler.resetToDefaultSettings();
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            switch (n) {
                case 100583: {
                    GUIHandlerSDARS.this.models.getChoiceModel(n).setValue(n2);
                    GUIHandlerSDARS.this.stationListHandler.setSortAlgo(n2);
                    GUIHandlerSDARS.this.epgHandler.setSortAlgo(n2);
                    GUIHandlerSDARS.this.setupHandler.valueUpdated(n2, 2);
                    break;
                }
                case 100420: {
                    GUIHandlerSDARS.this.models.getChoiceModel(n4, n).setValue(n2);
                    GUIHandlerSDARS.this.setupHandler.valueUpdated(n2, 4);
                    break;
                }
                case 100653: {
                    GUIHandlerSDARS.this.models.getChoiceModel(n4, n).setValue(n2);
                    GUIHandlerSDARS.this.setupHandler.valueUpdated(n2, 3);
                    break;
                }
            }
        }
    }
}

