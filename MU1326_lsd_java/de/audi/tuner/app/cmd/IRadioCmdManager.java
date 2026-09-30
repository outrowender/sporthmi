/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.cmd.allband.AllBandCmdListener;
import de.audi.tuner.app.dab.DABDSIDownManager;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.SDARSTunerListener;
import de.audi.tuner.ifc.UnifiedTunerListener;

public interface IRadioCmdManager {
    public static final String KEY_TYPE = "CL_TYPE";
    public static final String CL_AMFM = "AM/FM";
    public static final String CL_DAB = "DAB";
    public static final String CL_UNI = "UNI";
    public static final String CL_SDARS = "SDARS";
    public static final String CL_DONT_ABORT = "DONT_ABORT";

    public boolean isBlocked();

    public void destroy();

    public RadioCommandList createCmdList(String var1);

    public AMFMTunerListener getActiveAMFMCommand();

    public DABTunerListener getActiveDABCmd();

    public SDARSTunerListener getActiveSDARSCmd();

    public UnifiedTunerListener getActiveUnifiedCommand();

    public HMIAudioServiceListener getActiveAudioCmd();

    public AllBandCmdListener getActiveAllBandCmd(ISimpleTuner var1);

    public void enqueue(CommandList var1);

    public boolean executesCmd(Class var1);

    public AbstractRadioCmd cmdInitAmFmDone();

    public AbstractRadioCmd cmdInitDabDone();

    public AbstractRadioCmd cmdInitSdarsDone();

    public AbstractRadioCmd cmdRestoreAudio(int var1);

    public AbstractRadioCmd cmdWaitAMAvilable();

    public AbstractRadioCmd cmdWaitAMAvilable(int var1);

    public AbstractRadioCmd cmdRequestConnection(int var1, int var2);

    public AbstractRadioCmd cmdFadeToConnection(int var1, int var2);

    public AbstractRadioCmd cmdDemute();

    public AbstractRadioCmd cmdAbortAMForcedStationListUpdate(IAmFmDsiDownManager var1);

    public AbstractRadioCmd cmdAbortDABForcedStationListUpdate(DABDSIDownManager var1);

    public AbstractRadioCmd cmdAbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(DABDSIDownManager var1);

    public AbstractRadioCmd cmdTuneAMFMStationBlock(AMFMStation var1, boolean var2, int var3);

    public AbstractRadioCmd cmdTuneAMFMStationDontBlock(AMFMStation var1, boolean var2, int var3);

    public AbstractRadioCmd cmdHighlightAMFMStation(AMFMStation var1, boolean var2, int var3);

    public AbstractRadioCmd cmdSwitchAMFMUsage(boolean var1);

    public AbstractRadioCmd cmdWaitAMFMTunerReady(boolean var1);

    public AbstractRadioCmd cmdSeekAbort();

    public AbstractRadioCmd cmdWaitDABTunerReady();

    public AbstractRadioCmd cmdWaitUniTunerReady();

    public AbstractRadioCmd cmdTuneUniStationBlock(UnifiedStationExt var1, int var2);

    public AbstractRadioCmd cmdTuneUniStationDontBlock(UnifiedStationExt var1, int var2);

    public AbstractRadioCmd cmdInitUniDone();

    public AbstractRadioCmd cmdSetNotificationUni(int[] var1);

    public AbstractRadioCmd cmdSwitchUniUsage(boolean var1);

    public AbstractRadioCmd cmdWaitSDARSTunerReady();

    public AbstractRadioCmd cmdSelectSDARSServiceBlock(StationInfoExt var1);

    public AbstractRadioCmd cmdSelectSDARSServiceDontBlock(StationInfoExt var1);

    public AbstractRadioCmd cmdSelectDABServiceBlock(int var1, DabStation var2, int var3);

    public AbstractRadioCmd cmdSelectDABServiceDontBlock(int var1, DabStation var2, int var3);

    public AbstractRadioCmd cmdSwitchDABUsage(boolean var1);

    public AbstractRadioCmd cmdSetNotificationDAB(int[] var1);

    public AbstractRadioCmd cmdSetNotificationAMFM(int[] var1);

    public AbstractRadioCmd cmdSetNotificationSDARS(int[] var1);

    public AbstractRadioCmd cmdHmiReadySDARS();

    public RadioCommandList clSwitchToAMFM(int var1, AMFMStation var2, boolean var3);

    public RadioCommandList clSwitchToAMFM(int var1, int var2);

    public RadioCommandList clSwitchToDAB(int var1, DabStation var2, int var3);

    public RadioCommandList clSwitchToDAB(int var1);

    public RadioCommandList clSwitchToUni(int var1);

    public RadioCommandList clSwitchToUni(UnifiedStationExt var1, int var2);

    public RadioCommandList clSwitchToSDARS(int var1);

    public RadioCommandList clSwitchToSDARS(StationInfoExt var1, int var2);

    public AbstractRadioCmd cmdInitSetup(ISimpleTuner var1);

    public AbstractRadioCmd cmdWaitDSIRegistered(ISimpleTuner var1);

    public boolean isControlledbyCmd(int var1);

    public CommandListManager getCommandListManager();
}

