/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.sdars.GUIHandlerSDARS$1;
import de.audi.tuner.app.sdars.GUIHandlerSDARS$ChoiceListener;
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
    private final GUIHandlerSDARS$ChoiceListener choiceListener;

    GUIHandlerSDARS(SDARSTuner sDARSTuner, TunerBasics tunerBasics, TunerStorage tunerStorage, SDARSStationListHandler sDARSStationListHandler, SDARSEPGHandler sDARSEPGHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        tunerBasics.getStatus();
        this.sdarsTuner = sDARSTuner;
        this.epgHandler = sDARSEPGHandler;
        this.choiceListener = new GUIHandlerSDARS$ChoiceListener(this, null);
        this.setupHandler = new SDARSSetupHandler(this.logger, tunerStorage);
        this.setupHandler.init();
        this.stationListHandler = sDARSStationListHandler;
        this.initModels();
    }

    private void initModels() {
        this.models.getChoiceModel(981926144).setValue(0);
        this.models.getButtonModel(1032257792).setStatus(0);
        this.models.getChoiceModel(-410517248).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(1149763840).setChoiceListener(this.choiceListener);
        this.models.getChoiceModel(763953408).setChoiceListener(this.choiceListener);
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
        this.stationListHandler.register(iStoreStationHandler);
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return new GUIHandlerSDARS$1(this);
    }

    public SDARSStationListHandler getSdarsListHandler() {
        return this.stationListHandler;
    }

    @Override
    public IStationListHandler getStationListHandler() {
        return this.stationListHandler;
    }

    public void setPowerState(int n) {
    }

    public int getDisplayedStationNumber() {
        this.logger.sdarsRadioText.log(-2137614336, "getDisplayedStationNumber activeChannelIndex: %1", (long)this.getActiveChannelIndex());
        if (this.getActiveChannelIndex() >= 0 && this.getActiveChannelIndex() < this.channelNumbers.length) {
            int n = this.channelNumbers[this.activeChannelIndex];
            this.logger.sdarsRadioText.log(-2137614336, "getDisplayedStationNumber chNumber: %1", (long)n);
            return n;
        }
        this.logger.sdarsRadioText.log(-2137614336, "getDisplayedStationNumber index out of range");
        return -1;
    }

    private int getActiveChannelIndex() {
        return this.activeChannelIndex;
    }

    @Override
    public boolean tuneById(long l, int n) {
        return this.stationListHandler.tuneById(l, n);
    }

    @Override
    public TunerObjectContainer[] getStationList() {
        return this.stationListHandler.getStationList();
    }

    @Override
    public TunerObjectContainer[] getStationList(int n) {
        return this.stationListHandler.getStationList();
    }

    @Override
    public TunerObjectContainer getCurrentStation() {
        return this.sdarsTuner.getLabels().getActiveStation();
    }

    void initSetup() {
        int[] nArray = this.setupHandler.getCurrentSetup();
        if (nArray != null) {
            this.choiceListener.itemSelected(-410517248, nArray[2], 0, 0);
            this.models.getChoiceModel(1149763840).setValue(nArray[4]);
            this.models.getChoiceModel(763953408).setValue(nArray[3]);
        }
    }

    public SDARSSetupHandler getSetupHandler() {
        return this.setupHandler;
    }

    public void setChannelNumberNameMapping(StationInfoExt[] stationInfoExtArray) {
        this.chNumNameMap = new SimpleIntObjectMap(stationInfoExtArray.length);
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            if (stationInfoExtArray[i2].stationNumber == 0) {
                this.models.getLabelModel(965148928).setText(stationInfoExtArray[i2].fullLabel);
                this.models.getResourceLocatorModel(1753809152).setResourceLocator(stationInfoExtArray[i2].getStationArt());
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
        this.choiceListener.itemSelected(-410517248, 0, 0, 0);
        this.stationListHandler.resetToDefaultSettings();
    }

    static /* synthetic */ TunerModels access$100(GUIHandlerSDARS gUIHandlerSDARS) {
        return gUIHandlerSDARS.models;
    }

    static /* synthetic */ SDARSStationListHandler access$200(GUIHandlerSDARS gUIHandlerSDARS) {
        return gUIHandlerSDARS.stationListHandler;
    }

    static /* synthetic */ SDARSEPGHandler access$300(GUIHandlerSDARS gUIHandlerSDARS) {
        return gUIHandlerSDARS.epgHandler;
    }

    static /* synthetic */ SDARSSetupHandler access$400(GUIHandlerSDARS gUIHandlerSDARS) {
        return gUIHandlerSDARS.setupHandler;
    }
}

