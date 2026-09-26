/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.def.NullHMIAudioServiceListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager$NullRadioCmd;
import de.audi.tuner.app.cmd.RadioCmdManager$DefaultAllBandCmd;
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
import de.audi.tuner.util.NullAMFMTunerListener;
import de.audi.tuner.util.NullDABTunerListener;
import de.audi.tuner.util.NullSDARSTunerListener;
import de.audi.tuner.util.NullUnifiedTunerListener;

public class NullRadioCmdManager
extends NullService
implements IRadioCmdManager {
    private final IFrameworkAccess framework;
    private final AbstractRadioCmd nullCmd;

    public NullRadioCmdManager(TunerBasics tunerBasics) {
        super(tunerBasics.getLogger().jobs, "IRadioCmdManager");
        this.framework = tunerBasics.getFramework();
        this.nullCmd = new NullRadioCmdManager$NullRadioCmd(this, this.framework, this.lc);
    }

    @Override
    public boolean isBlocked() {
        this.log();
        return false;
    }

    @Override
    public void destroy() {
        this.log();
    }

    @Override
    public void enqueue(CommandList commandList) {
        this.log();
    }

    @Override
    public boolean executesCmd(Class clazz) {
        this.log();
        return false;
    }

    @Override
    public RadioCommandList createCmdList(String string) {
        this.log();
        return this.getNullCommandList();
    }

    @Override
    public AMFMTunerListener getActiveAMFMCommand() {
        return new NullAMFMTunerListener(this.lc);
    }

    @Override
    public DABTunerListener getActiveDABCmd() {
        return new NullDABTunerListener(this.lc);
    }

    @Override
    public SDARSTunerListener getActiveSDARSCmd() {
        return new NullSDARSTunerListener(this.lc);
    }

    @Override
    public UnifiedTunerListener getActiveUnifiedCommand() {
        return new NullUnifiedTunerListener(this.lc);
    }

    @Override
    public HMIAudioServiceListener getActiveAudioCmd() {
        return new NullHMIAudioServiceListener(this.lc);
    }

    @Override
    public AllBandCmdListener getActiveAllBandCmd(ISimpleTuner iSimpleTuner) {
        return new RadioCmdManager$DefaultAllBandCmd(this.framework, this.lc);
    }

    @Override
    public AbstractRadioCmd cmdInitAmFmDone() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdInitDabDone() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdInitSdarsDone() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdRestoreAudio(int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdDemute() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdRequestConnection(int n, int n2) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdFadeToConnection(int n, int n2) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdAbortDABForcedStationListUpdate(DABDSIDownManager dABDSIDownManager) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdAbortAMForcedStationListUpdate(IAmFmDsiDownManager iAmFmDsiDownManager) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdTuneAMFMStationBlock(AMFMStation aMFMStation, boolean bl, int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdTuneAMFMStationDontBlock(AMFMStation aMFMStation, boolean bl, int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdHighlightAMFMStation(AMFMStation aMFMStation, boolean bl, int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSelectDABServiceBlock(int n, DabStation dabStation, int n2) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSelectDABServiceDontBlock(int n, DabStation dabStation, int n2) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSwitchAMFMUsage(boolean bl) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitAMFMTunerReady(boolean bl) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitDABTunerReady() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSwitchDABUsage(boolean bl) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdAbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(DABDSIDownManager dABDSIDownManager) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitUniTunerReady() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdTuneUniStationBlock(UnifiedStationExt unifiedStationExt, int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdTuneUniStationDontBlock(UnifiedStationExt unifiedStationExt, int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdInitUniDone() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSwitchUniUsage(boolean bl) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSetNotificationUni(int[] nArray) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitSDARSTunerReady() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSelectSDARSServiceBlock(StationInfoExt stationInfoExt) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSelectSDARSServiceDontBlock(StationInfoExt stationInfoExt) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitAMAvilable() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitAMAvilable(int n) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSeekAbort() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdInitSetup(ISimpleTuner iSimpleTuner) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdWaitDSIRegistered(ISimpleTuner iSimpleTuner) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSetNotificationDAB(int[] nArray) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSetNotificationAMFM(int[] nArray) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdSetNotificationSDARS(int[] nArray) {
        this.log();
        return this.nullCmd;
    }

    @Override
    public AbstractRadioCmd cmdHmiReadySDARS() {
        this.log();
        return this.nullCmd;
    }

    @Override
    public RadioCommandList clSwitchToAMFM(int n, AMFMStation aMFMStation, boolean bl) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToAMFM(int n, int n2) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToDAB(int n, DabStation dabStation, int n2) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToUni(int n) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToUni(UnifiedStationExt unifiedStationExt, int n) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToDAB(int n) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToSDARS(int n) {
        return this.getNullCommandList();
    }

    @Override
    public RadioCommandList clSwitchToSDARS(StationInfoExt stationInfoExt, int n) {
        return this.getNullCommandList();
    }

    @Override
    public boolean isControlledbyCmd(int n) {
        return false;
    }

    @Override
    public CommandListManager getCommandListManager() {
        return new CommandListManager("NullCommandListManager", this.framework, this.lc, null, null);
    }

    private RadioCommandList getNullCommandList() {
        return new RadioCommandList(this, "NULL_TYPE");
    }

    static /* synthetic */ void access$000(NullRadioCmdManager nullRadioCmdManager) {
        nullRadioCmdManager.log();
    }
}

