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
    public static final String KEY_TYPE;
    public static final String CL_AMFM;
    public static final String CL_DAB;
    public static final String CL_UNI;
    public static final String CL_SDARS;
    public static final String CL_DONT_ABORT;

    default public boolean isBlocked() {
    }

    default public void destroy() {
    }

    default public RadioCommandList createCmdList(String string) {
    }

    default public AMFMTunerListener getActiveAMFMCommand() {
    }

    default public DABTunerListener getActiveDABCmd() {
    }

    default public SDARSTunerListener getActiveSDARSCmd() {
    }

    default public UnifiedTunerListener getActiveUnifiedCommand() {
    }

    default public HMIAudioServiceListener getActiveAudioCmd() {
    }

    default public AllBandCmdListener getActiveAllBandCmd(ISimpleTuner iSimpleTuner) {
    }

    default public void enqueue(CommandList commandList) {
    }

    default public boolean executesCmd(Class clazz) {
    }

    default public AbstractRadioCmd cmdInitAmFmDone() {
    }

    default public AbstractRadioCmd cmdInitDabDone() {
    }

    default public AbstractRadioCmd cmdInitSdarsDone() {
    }

    default public AbstractRadioCmd cmdRestoreAudio(int n) {
    }

    default public AbstractRadioCmd cmdWaitAMAvilable() {
    }

    default public AbstractRadioCmd cmdWaitAMAvilable(int n) {
    }

    default public AbstractRadioCmd cmdRequestConnection(int n, int n2) {
    }

    default public AbstractRadioCmd cmdFadeToConnection(int n, int n2) {
    }

    default public AbstractRadioCmd cmdDemute() {
    }

    default public AbstractRadioCmd cmdAbortAMForcedStationListUpdate(IAmFmDsiDownManager iAmFmDsiDownManager) {
    }

    default public AbstractRadioCmd cmdAbortDABForcedStationListUpdate(DABDSIDownManager dABDSIDownManager) {
    }

    default public AbstractRadioCmd cmdAbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(DABDSIDownManager dABDSIDownManager) {
    }

    default public AbstractRadioCmd cmdTuneAMFMStationBlock(AMFMStation aMFMStation, boolean bl, int n) {
    }

    default public AbstractRadioCmd cmdTuneAMFMStationDontBlock(AMFMStation aMFMStation, boolean bl, int n) {
    }

    default public AbstractRadioCmd cmdHighlightAMFMStation(AMFMStation aMFMStation, boolean bl, int n) {
    }

    default public AbstractRadioCmd cmdSwitchAMFMUsage(boolean bl) {
    }

    default public AbstractRadioCmd cmdWaitAMFMTunerReady(boolean bl) {
    }

    default public AbstractRadioCmd cmdSeekAbort() {
    }

    default public AbstractRadioCmd cmdWaitDABTunerReady() {
    }

    default public AbstractRadioCmd cmdWaitUniTunerReady() {
    }

    default public AbstractRadioCmd cmdTuneUniStationBlock(UnifiedStationExt unifiedStationExt, int n) {
    }

    default public AbstractRadioCmd cmdTuneUniStationDontBlock(UnifiedStationExt unifiedStationExt, int n) {
    }

    default public AbstractRadioCmd cmdInitUniDone() {
    }

    default public AbstractRadioCmd cmdSetNotificationUni(int[] nArray) {
    }

    default public AbstractRadioCmd cmdSwitchUniUsage(boolean bl) {
    }

    default public AbstractRadioCmd cmdWaitSDARSTunerReady() {
    }

    default public AbstractRadioCmd cmdSelectSDARSServiceBlock(StationInfoExt stationInfoExt) {
    }

    default public AbstractRadioCmd cmdSelectSDARSServiceDontBlock(StationInfoExt stationInfoExt) {
    }

    default public AbstractRadioCmd cmdSelectDABServiceBlock(int n, DabStation dabStation, int n2) {
    }

    default public AbstractRadioCmd cmdSelectDABServiceDontBlock(int n, DabStation dabStation, int n2) {
    }

    default public AbstractRadioCmd cmdSwitchDABUsage(boolean bl) {
    }

    default public AbstractRadioCmd cmdSetNotificationDAB(int[] nArray) {
    }

    default public AbstractRadioCmd cmdSetNotificationAMFM(int[] nArray) {
    }

    default public AbstractRadioCmd cmdSetNotificationSDARS(int[] nArray) {
    }

    default public AbstractRadioCmd cmdHmiReadySDARS() {
    }

    default public RadioCommandList clSwitchToAMFM(int n, AMFMStation aMFMStation, boolean bl) {
    }

    default public RadioCommandList clSwitchToAMFM(int n, int n2) {
    }

    default public RadioCommandList clSwitchToDAB(int n, DabStation dabStation, int n2) {
    }

    default public RadioCommandList clSwitchToDAB(int n) {
    }

    default public RadioCommandList clSwitchToUni(int n) {
    }

    default public RadioCommandList clSwitchToUni(UnifiedStationExt unifiedStationExt, int n) {
    }

    default public RadioCommandList clSwitchToSDARS(int n) {
    }

    default public RadioCommandList clSwitchToSDARS(StationInfoExt stationInfoExt, int n) {
    }

    default public AbstractRadioCmd cmdInitSetup(ISimpleTuner iSimpleTuner) {
    }

    default public AbstractRadioCmd cmdWaitDSIRegistered(ISimpleTuner iSimpleTuner) {
    }

    default public boolean isControlledbyCmd(int n) {
    }

    default public CommandListManager getCommandListManager() {
    }
}

