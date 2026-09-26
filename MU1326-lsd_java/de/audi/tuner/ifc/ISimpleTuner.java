/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.itunes.ITaggingManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.HdStationInfo;

public interface ISimpleTuner {
    public static final int TUNER_TYPE_AMFM;
    public static final int TUNER_TYPE_DAB;
    public static final String STRING_EMPTY;
    public static final String STRING_EMPTY_SPACE;
    public static final String STRING_KHZ;
    public static final String STRING_KHZ_LS;
    public static final String STRING_MHZ;
    public static final String STRING_MHZ_LS;
    public static final String STRING_DSI_EXCEPTION;
    public static final String STRING_STATION;
    public static final String STRING_NO_SIGNAL;
    public static final ResourceLocator EMPTY_DSI_RL;
    public static final HMIResourceLocator EMPTY_RL;
    public static final RadioHMIResourceLocator EMPTY_RADIO_RL;
    public static final HdStationInfoExt EMPTY_HDSTATIONINFO;

    default public void setNotification(int[] nArray) {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public int init() {
    }

    default public void initSetup() {
    }

    default public void setInitDone() {
    }

    default public void deinit() {
    }

    default public void executeInitialCommands() {
    }

    default public boolean isDsiFound() {
    }

    default public ITunerGUIHandler getGUIHandler() {
    }

    default public void setDeviceService(DSIBase dSIBase) {
    }

    default public void seekStation(int n, int n2) {
    }

    default public void resetToDefaultSettings() {
    }

    default public boolean isDeviceInUse() {
    }

    default public void setComponentUsage(boolean bl) {
    }

    default public void setComponentUnused() {
    }

    default public boolean forceStationListUpdate(boolean bl) {
    }

    default public void register(DSIListener dSIListener) {
    }

    default public void register(ITaggingManager iTaggingManager) {
    }

    default public void register(IGracenoteRequest iGracenoteRequest) {
    }

    default public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
    }

    default public IRadioCmdManager getCmdManager() {
    }

    default public void audioManagementJustBecameAvailable() {
    }

    default public void registerDsiUpDownListener(RadioInfo radioInfo) {
    }

    default public CmdDefaultListener getDSIUpManager() {
    }

    default public TunerObjectContainer[] startScan() {
    }

    default public void stopScan() {
    }

    default public void performLanguageChange() {
    }

    default public void reRequestCoverArt() {
    }

    default public IRadioDatabaseListener getDatabaseListener() {
    }

    static {
        EMPTY_DSI_RL = new ResourceLocator("");
        EMPTY_RL = new HMIResourceLocator("");
        EMPTY_RADIO_RL = new RadioHMIResourceLocator(EMPTY_RL, 3);
        EMPTY_HDSTATIONINFO = new HdStationInfoExt(new HdStationInfo());
    }
}

