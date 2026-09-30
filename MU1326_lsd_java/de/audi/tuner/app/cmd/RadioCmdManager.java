/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.cmd.SwitchToAMFMCmdList;
import de.audi.tuner.app.cmd.SwitchToDABCmdList;
import de.audi.tuner.app.cmd.SwitchToSdarsCmdList;
import de.audi.tuner.app.cmd.SwitchToUniCmdList;
import de.audi.tuner.app.cmd.allband.AbstractAllBandCmd;
import de.audi.tuner.app.cmd.allband.AllBandCmdListener;
import de.audi.tuner.app.cmd.allband.DSIRegisteredCmd;
import de.audi.tuner.app.cmd.allband.InitSetupCmd;
import de.audi.tuner.app.cmd.amfm.AbortAMForcedStationListUpdateCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.HighlightAMFMStationCmd;
import de.audi.tuner.app.cmd.amfm.InitAmFmDoneCmd;
import de.audi.tuner.app.cmd.amfm.SeekAbortCmd;
import de.audi.tuner.app.cmd.amfm.SetNotificationAMFM;
import de.audi.tuner.app.cmd.amfm.SwitchAMFMUsageCmd;
import de.audi.tuner.app.cmd.amfm.TuneAMFMStationCmd;
import de.audi.tuner.app.cmd.amfm.WaitAMFMTunerReadyCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;
import de.audi.tuner.app.cmd.audio.DemuteCmd;
import de.audi.tuner.app.cmd.audio.FadeToConnectionCmd;
import de.audi.tuner.app.cmd.audio.RequestConnectionCmd;
import de.audi.tuner.app.cmd.audio.RestoreAudioCmd;
import de.audi.tuner.app.cmd.audio.WaitAMAvailableCmd;
import de.audi.tuner.app.cmd.dab.AbortDABForcedStationListUpdateCmd;
import de.audi.tuner.app.cmd.dab.AbortDABForcedUpdateListAndSwitchLinkingDeviceUsage;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.cmd.dab.InitDabDoneCmd;
import de.audi.tuner.app.cmd.dab.SelectServiceCmd;
import de.audi.tuner.app.cmd.dab.SetNotificationDAB;
import de.audi.tuner.app.cmd.dab.SwitchDABUsageCmd;
import de.audi.tuner.app.cmd.dab.WaitDABTunerReadyCmd;
import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.audi.tuner.app.cmd.sdars.InitSdarsDoneCmd;
import de.audi.tuner.app.cmd.sdars.SelectSDARSServiceCmd;
import de.audi.tuner.app.cmd.sdars.SetHmiReadySDARS;
import de.audi.tuner.app.cmd.sdars.SetNotificationSDARS;
import de.audi.tuner.app.cmd.sdars.WaitSDARSTunerReadyCmd;
import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.cmd.uni.InitUniDoneCmd;
import de.audi.tuner.app.cmd.uni.SetNotificationUni;
import de.audi.tuner.app.cmd.uni.SwitchUniUsageCmd;
import de.audi.tuner.app.cmd.uni.TuneUniStationCmd;
import de.audi.tuner.app.cmd.uni.WaitUniTunerReadyCmd;
import de.audi.tuner.app.dab.DABDSIDownManager;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.IAMFMTuner;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.IRadioAudioService;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.SDARSTunerListener;
import de.audi.tuner.ifc.UnifiedTunerListener;
import java.util.Iterator;

public class RadioCmdManager
implements IRadioCmdManager {
    private final AbstractAMFMCmd.Builder amfmBuilder;
    private final AbstractAudioCmd.Builder audioBuilder;
    private final AbstractDABCmd.Builder dabBuilder;
    private final AbstractSDARSCmd.Builder sdarsBuilder;
    private final AbstractUnifiedCmd.Builder unifiedBuilder;
    private final LogChannel lc;
    private final TunerBasics basics;
    private final CommandListManager manager;
    private final DefaultAMFMCmd defaultAMFMCmd;
    private final DefaultDABCmd defaultDABCmd;
    private final DefaultSDARSCmd defaultSDARSCmd;
    private final DefaultUnifiedCmd defaultUnifiedCmd;
    private final DefaultAudioCmd defaultAudioCmd;
    private final DefaultAllBandCmd defaultAllBandCmd;
    private final Object mutex = new Object();

    public RadioCmdManager(Builder builder) {
        this.lc = builder.lc;
        this.basics = builder.basics;
        this.amfmBuilder = new AbstractAMFMCmd.Builder(this.basics.getFramework(), this.lc, builder.amfmTuner, builder.amfmDefaultListener);
        this.audioBuilder = new AbstractAudioCmd.Builder(this.basics.getFramework(), this.lc, builder.audioService, builder.audioDefaultListener);
        this.dabBuilder = new AbstractDABCmd.Builder(this.basics.getFramework(), this.lc, builder.dabTuner, builder.dabDefaultListener);
        this.sdarsBuilder = new AbstractSDARSCmd.Builder(this.basics.getFramework(), this.lc, builder.sdarsTuner, builder.sdarsDefaultListener);
        this.unifiedBuilder = new AbstractUnifiedCmd.Builder(this.basics.getFramework(), this.lc, builder.unifiedTuner, builder.unifiedDefaultListener);
        this.defaultAMFMCmd = new DefaultAMFMCmd(this.amfmBuilder);
        this.defaultDABCmd = new DefaultDABCmd(this.dabBuilder);
        this.defaultSDARSCmd = new DefaultSDARSCmd(this.sdarsBuilder);
        this.defaultUnifiedCmd = new DefaultUnifiedCmd(this.unifiedBuilder);
        this.defaultAudioCmd = new DefaultAudioCmd(this.audioBuilder);
        this.defaultAllBandCmd = new DefaultAllBandCmd(this.basics.getFramework(), this.lc);
        this.manager = new CommandListManager("Radio", this.basics.getFramework(), this.lc, null, null);
        this.manager.start();
    }

    public final void destroy() {
        this.manager.destroy();
    }

    public RadioCommandList createCmdList(String string) {
        return new RadioCommandList(this, string);
    }

    public boolean isBlocked() {
        CommandList commandList = this.manager.getActiveCommandList();
        if (!(commandList instanceof RadioCommandList)) {
            return false;
        }
        return ((RadioCommandList)commandList).getType() == "DONT_ABORT";
    }

    public AMFMTunerListener getActiveAMFMCommand() {
        AbstractRadioCmd abstractRadioCmd = this.getActiveCmd();
        if (abstractRadioCmd == null || !abstractRadioCmd.isAMFMCmd()) {
            return this.defaultAMFMCmd;
        }
        return (AMFMTunerListener)((Object)abstractRadioCmd);
    }

    public DABTunerListener getActiveDABCmd() {
        AbstractRadioCmd abstractRadioCmd = this.getActiveCmd();
        if (abstractRadioCmd == null || !abstractRadioCmd.isDABCmd()) {
            return this.defaultDABCmd;
        }
        return (DABTunerListener)((Object)abstractRadioCmd);
    }

    public SDARSTunerListener getActiveSDARSCmd() {
        AbstractRadioCmd abstractRadioCmd = this.getActiveCmd();
        if (abstractRadioCmd == null || !abstractRadioCmd.isSDARSCmd()) {
            return this.defaultSDARSCmd;
        }
        return (SDARSTunerListener)((Object)abstractRadioCmd);
    }

    public UnifiedTunerListener getActiveUnifiedCommand() {
        AbstractRadioCmd abstractRadioCmd = this.getActiveCmd();
        if (abstractRadioCmd == null || !abstractRadioCmd.isUnifiedCmd()) {
            return this.defaultUnifiedCmd;
        }
        return (UnifiedTunerListener)((Object)abstractRadioCmd);
    }

    public HMIAudioServiceListener getActiveAudioCmd() {
        AbstractRadioCmd abstractRadioCmd = this.getActiveCmd();
        if (abstractRadioCmd == null || !abstractRadioCmd.isAudioCmd()) {
            return this.defaultAudioCmd;
        }
        return (HMIAudioServiceListener)((Object)abstractRadioCmd);
    }

    public AllBandCmdListener getActiveAllBandCmd(ISimpleTuner iSimpleTuner) {
        AbstractRadioCmd abstractRadioCmd = this.getActiveCmd();
        if (abstractRadioCmd == null || !abstractRadioCmd.isAllBandCmd()) {
            return this.defaultAllBandCmd;
        }
        AbstractAllBandCmd abstractAllBandCmd = (AbstractAllBandCmd)abstractRadioCmd;
        if (!abstractAllBandCmd.supports(iSimpleTuner)) {
            return this.defaultAllBandCmd;
        }
        return abstractAllBandCmd;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enqueue(CommandList commandList) {
        if (commandList.size() == 0) {
            this.lc.log(100000, "[RadioCmdManager.enqueue] Empty CL %1", (Object)commandList);
            return;
        }
        this.debug2(commandList);
        Object object = this.mutex;
        synchronized (object) {
            String string = (String)commandList.get("CL_TYPE");
            this.abort(string);
            this.manager.execute(commandList);
        }
    }

    private void debug2(CommandList commandList) {
        if (this.lc.isDebug2()) {
            Object[] objectArray = commandList.getCommands().toArray();
            this.lc.log(100000000, "[RadioCmdManager.enqueue] type:%1 #%2", commandList.get("CL_TYPE"), (long)objectArray.length);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                this.lc.log(100000000, "[RadioCmdManager.enqueue] [%2] %1", objectArray[i2], (long)i2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean executesCmd(Class clazz) {
        Object object = this.mutex;
        synchronized (object) {
            return this.contains(this.manager.getActiveCommandList(), clazz);
        }
    }

    private boolean contains(CommandList commandList, Class clazz) {
        if (commandList == null) {
            return false;
        }
        Iterator iterator = commandList.getCommands().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getClass() != clazz) continue;
            return true;
        }
        return false;
    }

    private void abort(String string) {
        if (string == "DONT_ABORT") {
            return;
        }
        CommandList commandList = this.manager.getActiveCommandList();
        if (commandList == null) {
            return;
        }
        this.manager.abortExecution("DONT_ABORT", "DONT_ABORT", true);
    }

    public AbstractRadioCmd cmdInitAmFmDone() {
        return new InitAmFmDoneCmd(this.amfmBuilder);
    }

    public AbstractRadioCmd cmdInitDabDone() {
        return new InitDabDoneCmd(this.dabBuilder);
    }

    public AbstractRadioCmd cmdInitSdarsDone() {
        return new InitSdarsDoneCmd(this.sdarsBuilder);
    }

    public AbstractRadioCmd cmdRestoreAudio(int n) {
        return new RestoreAudioCmd(n, this.basics.getStatus(), this.audioBuilder);
    }

    public AbstractRadioCmd cmdWaitAMAvilable() {
        return new WaitAMAvailableCmd(this.audioBuilder);
    }

    public AbstractRadioCmd cmdWaitAMAvilable(int n) {
        return new WaitAMAvailableCmd(this.audioBuilder, n);
    }

    public AbstractRadioCmd cmdDemute() {
        return new DemuteCmd(this.audioBuilder);
    }

    public AbstractRadioCmd cmdRequestConnection(int n, int n2) {
        return new RequestConnectionCmd(Utilities.getConnectionByBand(n, n2), n2, this.audioBuilder);
    }

    public AbstractRadioCmd cmdFadeToConnection(int n, int n2) {
        return new FadeToConnectionCmd(Utilities.getConnectionByBand(n, n2), n2, this.audioBuilder);
    }

    public AbstractRadioCmd cmdAbortAMForcedStationListUpdate(IAmFmDsiDownManager iAmFmDsiDownManager) {
        return new AbortAMForcedStationListUpdateCmd(iAmFmDsiDownManager, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdAbortDABForcedStationListUpdate(DABDSIDownManager dABDSIDownManager) {
        return new AbortDABForcedStationListUpdateCmd(dABDSIDownManager, this.dabBuilder);
    }

    public AbstractRadioCmd cmdAbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(DABDSIDownManager dABDSIDownManager) {
        return new AbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(dABDSIDownManager, this.dabBuilder);
    }

    public AbstractRadioCmd cmdTuneAMFMStationBlock(AMFMStation aMFMStation, boolean bl, int n) {
        return new TuneAMFMStationCmd(aMFMStation, bl, true, n, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdTuneAMFMStationDontBlock(AMFMStation aMFMStation, boolean bl, int n) {
        return new TuneAMFMStationCmd(aMFMStation, bl, false, n, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdHighlightAMFMStation(AMFMStation aMFMStation, boolean bl, int n) {
        return new HighlightAMFMStationCmd(aMFMStation, bl, n, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdSelectDABServiceBlock(int n, DabStation dabStation, int n2) {
        return new SelectServiceCmd(n, dabStation, true, n2, this.dabBuilder);
    }

    public AbstractRadioCmd cmdSelectDABServiceDontBlock(int n, DabStation dabStation, int n2) {
        return new SelectServiceCmd(n, dabStation, false, n2, this.dabBuilder);
    }

    public AbstractRadioCmd cmdSwitchAMFMUsage(boolean bl) {
        return new SwitchAMFMUsageCmd(bl, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdWaitAMFMTunerReady(boolean bl) {
        boolean bl2 = Utilities.isStd();
        return new WaitAMFMTunerReadyCmd(bl2, bl, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdSeekAbort() {
        return new SeekAbortCmd(this.amfmBuilder);
    }

    public AbstractRadioCmd cmdWaitDABTunerReady() {
        boolean bl = Utilities.isStd();
        return new WaitDABTunerReadyCmd(bl, this.dabBuilder);
    }

    public AbstractRadioCmd cmdSwitchDABUsage(boolean bl) {
        return new SwitchDABUsageCmd(bl, this.dabBuilder);
    }

    public AbstractRadioCmd cmdWaitUniTunerReady() {
        return new WaitUniTunerReadyCmd(this.unifiedBuilder);
    }

    public AbstractRadioCmd cmdTuneUniStationBlock(UnifiedStationExt unifiedStationExt, int n) {
        return new TuneUniStationCmd(unifiedStationExt, true, n, this.unifiedBuilder);
    }

    public AbstractRadioCmd cmdTuneUniStationDontBlock(UnifiedStationExt unifiedStationExt, int n) {
        return new TuneUniStationCmd(unifiedStationExt, false, n, this.unifiedBuilder);
    }

    public AbstractRadioCmd cmdInitUniDone() {
        return new InitUniDoneCmd(this.unifiedBuilder);
    }

    public AbstractRadioCmd cmdSetNotificationUni(int[] nArray) {
        return new SetNotificationUni(nArray, this.unifiedBuilder);
    }

    public AbstractRadioCmd cmdSwitchUniUsage(boolean bl) {
        return new SwitchUniUsageCmd(bl, this.unifiedBuilder);
    }

    public AbstractRadioCmd cmdWaitSDARSTunerReady() {
        return new WaitSDARSTunerReadyCmd(this.sdarsBuilder);
    }

    public AbstractRadioCmd cmdSelectSDARSServiceBlock(StationInfoExt stationInfoExt) {
        return new SelectSDARSServiceCmd(stationInfoExt, true, this.sdarsBuilder);
    }

    public AbstractRadioCmd cmdSelectSDARSServiceDontBlock(StationInfoExt stationInfoExt) {
        return new SelectSDARSServiceCmd(stationInfoExt, false, this.sdarsBuilder);
    }

    public AbstractRadioCmd cmdSetNotificationDAB(int[] nArray) {
        return new SetNotificationDAB(nArray, this.dabBuilder);
    }

    public AbstractRadioCmd cmdSetNotificationAMFM(int[] nArray) {
        return new SetNotificationAMFM(nArray, this.amfmBuilder);
    }

    public AbstractRadioCmd cmdSetNotificationSDARS(int[] nArray) {
        return new SetNotificationSDARS(nArray, this.sdarsBuilder);
    }

    public AbstractRadioCmd cmdHmiReadySDARS() {
        return new SetHmiReadySDARS(this.sdarsBuilder);
    }

    public RadioCommandList clSwitchToAMFM(int n, AMFMStation aMFMStation, boolean bl) {
        return new SwitchToAMFMCmdList(n, aMFMStation, bl, this);
    }

    public RadioCommandList clSwitchToAMFM(int n, int n2) {
        return new SwitchToAMFMCmdList(n, n2, this);
    }

    public RadioCommandList clSwitchToDAB(int n, DabStation dabStation, int n2) {
        return new SwitchToDABCmdList(this, n, dabStation, n2);
    }

    public RadioCommandList clSwitchToDAB(int n) {
        return new SwitchToDABCmdList(n, this);
    }

    public RadioCommandList clSwitchToUni(int n) {
        return new SwitchToUniCmdList(this, n);
    }

    public RadioCommandList clSwitchToUni(UnifiedStationExt unifiedStationExt, int n) {
        return new SwitchToUniCmdList(this, unifiedStationExt, n);
    }

    public RadioCommandList clSwitchToSDARS(int n) {
        return new SwitchToSdarsCmdList(this, n);
    }

    public RadioCommandList clSwitchToSDARS(StationInfoExt stationInfoExt, int n) {
        return new SwitchToSdarsCmdList(this, stationInfoExt, n);
    }

    public AbstractRadioCmd cmdInitSetup(ISimpleTuner iSimpleTuner) {
        return new InitSetupCmd(this.basics.getFramework(), iSimpleTuner, this.lc);
    }

    public AbstractRadioCmd cmdWaitDSIRegistered(ISimpleTuner iSimpleTuner) {
        return new DSIRegisteredCmd(this.basics.getFramework(), iSimpleTuner, this.lc);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isControlledbyCmd(int n) {
        Object object = this.mutex;
        synchronized (object) {
            CommandList commandList = this.manager.getActiveCommandList();
            if (commandList == null) {
                return false;
            }
            int n2 = commandList.getPos();
            Iterator iterator = commandList.getCommands().iterator();
            for (int i2 = 0; i2 < n2 && iterator.hasNext(); ++i2) {
                iterator.next();
            }
            while (iterator.hasNext()) {
                AbstractRadioCmd abstractRadioCmd = (AbstractRadioCmd)iterator.next();
                if (!abstractRadioCmd.isAudioCmd()) continue;
                AbstractAudioCmd abstractAudioCmd = (AbstractAudioCmd)abstractRadioCmd;
                if (abstractAudioCmd.connection != n) continue;
                return true;
            }
            return false;
        }
    }

    public CommandListManager getCommandListManager() {
        return this.manager;
    }

    private AbstractRadioCmd getActiveCmd() {
        CommandList commandList = this.manager.getActiveCommandList();
        if (commandList == null) {
            return null;
        }
        return (AbstractRadioCmd)commandList.getActiveCommand();
    }

    public static class Builder {
        private final LogChannel lc;
        private final TunerBasics basics;
        private IAMFMTuner amfmTuner;
        private AMFMTunerListener amfmDefaultListener;
        private IDABTuner dabTuner;
        private DABTunerListener dabDefaultListener;
        private ISDARSTuner sdarsTuner;
        private SDARSTunerListener sdarsDefaultListener;
        private IUnifiedTuner unifiedTuner;
        private UnifiedTunerListener unifiedDefaultListener;
        private IRadioAudioService audioService;
        private HMIAudioServiceListener audioDefaultListener;

        public Builder(TunerBasics tunerBasics) {
            this.basics = tunerBasics;
            this.lc = tunerBasics.getLogger().jobs;
        }

        public void setAMFMTuner(IAMFMTuner iAMFMTuner) {
            this.amfmTuner = iAMFMTuner;
        }

        public void setAMFMDefaultListener(AMFMTunerListener aMFMTunerListener) {
            this.amfmDefaultListener = aMFMTunerListener;
        }

        public void setDABTuner(IDABTuner iDABTuner) {
            this.dabTuner = iDABTuner;
        }

        public void setDABDefaultListener(DABTunerListener dABTunerListener) {
            this.dabDefaultListener = dABTunerListener;
        }

        public void setSDARSTuner(ISDARSTuner iSDARSTuner) {
            this.sdarsTuner = iSDARSTuner;
        }

        public void setSDARSDefaultListener(SDARSTunerListener sDARSTunerListener) {
            this.sdarsDefaultListener = sDARSTunerListener;
        }

        public void setUnifiedTuner(IUnifiedTuner iUnifiedTuner) {
            this.unifiedTuner = iUnifiedTuner;
        }

        public void setUnifiedDefaultListener(UnifiedTunerListener unifiedTunerListener) {
            this.unifiedDefaultListener = unifiedTunerListener;
        }

        public void setAudioService(IRadioAudioService iRadioAudioService) {
            this.audioService = iRadioAudioService;
        }

        public void setAudioDefaultListener(HMIAudioServiceListener hMIAudioServiceListener) {
            this.audioDefaultListener = hMIAudioServiceListener;
        }
    }

    private static class DefaultDABCmd
    extends AbstractDABCmd {
        DefaultDABCmd(AbstractDABCmd.Builder builder) {
            super(builder);
        }

        public void execute() {
            throw new IllegalStateException("Calling #execute() for default DAB command no allowed!");
        }
    }

    private static class DefaultAMFMCmd
    extends AbstractAMFMCmd {
        DefaultAMFMCmd(AbstractAMFMCmd.Builder builder) {
            super(builder);
        }

        public void execute() {
            throw new IllegalStateException("Calling #execute() for AM/FM command no allowed!");
        }
    }

    private static class DefaultAudioCmd
    extends AbstractAudioCmd {
        DefaultAudioCmd(AbstractAudioCmd.Builder builder) {
            super(builder);
        }

        public void execute() {
            throw new IllegalStateException("Calling #execute() for default audio command no allowed!");
        }
    }

    private static class DefaultSDARSCmd
    extends AbstractSDARSCmd {
        DefaultSDARSCmd(AbstractSDARSCmd.Builder builder) {
            super(builder);
        }

        public void execute() {
            throw new IllegalStateException("Calling #execute() for default DAB command no allowed!");
        }
    }

    static class DefaultAllBandCmd
    extends AbstractAllBandCmd {
        DefaultAllBandCmd(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
            super(iFrameworkAccess, null, logChannel);
        }

        public void execute() {
            throw new IllegalStateException("Calling #execute() for all band command no allowed!");
        }
    }

    private static class DefaultUnifiedCmd
    extends AbstractUnifiedCmd {
        DefaultUnifiedCmd(AbstractUnifiedCmd.Builder builder) {
            super(builder);
        }

        public void execute() {
            throw new IllegalStateException("Calling #execute() for default DAB command no allowed!");
        }
    }
}

