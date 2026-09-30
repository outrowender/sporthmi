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
    public static final int TUNER_TYPE_AMFM = 1;
    public static final int TUNER_TYPE_DAB = 2;
    public static final String STRING_EMPTY = "";
    public static final String STRING_EMPTY_SPACE = " ";
    public static final String STRING_KHZ = "kHz";
    public static final String STRING_KHZ_LS = " kHz";
    public static final String STRING_MHZ = "MHz";
    public static final String STRING_MHZ_LS = " MHz";
    public static final String STRING_DSI_EXCEPTION = "DSIException occured!";
    public static final String STRING_STATION = "Station";
    public static final String STRING_NO_SIGNAL = "NoSignal";
    public static final ResourceLocator EMPTY_DSI_RL = new ResourceLocator("");
    public static final HMIResourceLocator EMPTY_RL = new HMIResourceLocator("");
    public static final RadioHMIResourceLocator EMPTY_RADIO_RL = new RadioHMIResourceLocator(EMPTY_RL, 3);
    public static final HdStationInfoExt EMPTY_HDSTATIONINFO = new HdStationInfoExt(new HdStationInfo());

    public void setNotification(int[] var1);

    public void clearNotification(int[] var1);

    public int init();

    public void initSetup();

    public void setInitDone();

    public void deinit();

    public void executeInitialCommands();

    public boolean isDsiFound();

    public ITunerGUIHandler getGUIHandler();

    public void setDeviceService(DSIBase var1);

    public void seekStation(int var1, int var2);

    public void resetToDefaultSettings();

    public boolean isDeviceInUse();

    public void setComponentUsage(boolean var1);

    public void setComponentUnused();

    public boolean forceStationListUpdate(boolean var1);

    public void register(DSIListener var1);

    public void register(ITaggingManager var1);

    public void register(IGracenoteRequest var1);

    public void setCmdManager(IRadioCmdManager var1);

    public IRadioCmdManager getCmdManager();

    public void audioManagementJustBecameAvailable();

    public void registerDsiUpDownListener(RadioInfo var1);

    public CmdDefaultListener getDSIUpManager();

    public TunerObjectContainer[] startScan();

    public void stopScan();

    public void performLanguageChange();

    public void reRequestCoverArt();

    public IRadioDatabaseListener getDatabaseListener();
}

