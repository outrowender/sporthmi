/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener$1;
import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener$2;
import de.audi.app.ecall.core.audio.cmd.EcallAudioDSISoundCmdListener$EcallAudioDSISoundClient;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;

public class EcallAudioDSISoundCmdListener
extends AbstractEcallComponent
implements ICommandResponseSupplier,
DSISoundListener {
    private DSIActivator dsiSoundActivator;
    private final IEcallAudioCmdListener defaultListener;
    private final CommandListManager cmdListManager;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    public EcallAudioDSISoundCmdListener(IEcallApplication iEcallApplication, IEcallAudioCmdListener iEcallAudioCmdListener, CommandListManager commandListManager) {
        super(iEcallApplication, "App.Ecall.Audio");
        this.defaultListener = iEcallAudioCmdListener;
        this.cmdListManager = commandListManager;
        this.getApplication().addDiagnosisComponent(new EcallAudioDSISoundCmdListener$1(this));
    }

    @Override
    public void init() {
        EcallAudioDSISoundCmdListener$EcallAudioDSISoundClient ecallAudioDSISoundCmdListener$EcallAudioDSISoundClient = new EcallAudioDSISoundCmdListener$EcallAudioDSISoundClient(this, null);
        this.dsiSoundActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = EcallAudioDSISoundCmdListener.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = EcallAudioDSISoundCmdListener.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), new Integer(0), this, ecallAudioDSISoundCmdListener$EcallAudioDSISoundClient);
        this.dsiSoundActivator.start(this.getApplication().getBundleContext());
    }

    @Override
    public void deinit() {
        if (this.dsiSoundActivator != null) {
            this.dsiSoundActivator.stop(this.getApplication().getBundleContext());
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
    }

    @Override
    public void updateBalance(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateBalanceRange(int n, int n2, int n3) {
    }

    @Override
    public void updateBass(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateBassRange(int n, int n2, int n3) {
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
    }

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateFader(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateFaderRange(int n, int n2, int n3) {
    }

    @Override
    public void importFileResponse(int n, boolean bl) {
    }

    @Override
    public void updateInputGainOffset(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
        this.log.log(1078071040, "[EcallAudioDSISoundCmdListener#updateMutePinState] mutePinState=%1", bl);
        CommandResponse.execute(this, new EcallAudioDSISoundCmdListener$2(this, bl, n));
    }

    public void updateSoundSet(int n, int n2, long l, int n3) {
    }

    public void updateSoundSetList(long l, int n) {
    }

    @Override
    public void updateSubwoofer(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateSubwooferRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSurrLevelRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSurroundLevel(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateTreble(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateTrebleRange(int n, int n2, int n3) {
    }

    public void updateVolLevelRange(int n, int n2, int n3) {
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
        this.log.log(1078071040, "EcallAudioDSISoundCmdListener.updateVolume()");
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
    }

    @Override
    public void updateMiddle(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateMiddleRange(int n, int n2, int n3) {
    }

    @Override
    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
    }

    @Override
    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
    }

    @Override
    public void updateOnVolumeLimit(int n, int n2) {
    }

    @Override
    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
    }

    @Override
    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
    }

    @Override
    public void updateVolumeFocus(int n, int n2, int n3) {
    }

    @Override
    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2, int n3) {
    }

    @Override
    public void updateThreeDMode(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateThreeDModeRange(int n, int n2, int n3) {
    }

    @Override
    public void updatePresetPosition(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updatePresetPositionList(int n, int n2) {
    }

    @Override
    public void updatePresetEQList(int n, int n2) {
    }

    @Override
    public void updatePresetEQ(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
    }

    @Override
    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
    }

    @Override
    public void updateSoundShapeActive(boolean bl, int n) {
    }

    @Override
    public void updateSoundShape(short s, short s2, short s3, int n) {
    }

    @Override
    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    @Override
    public void updateICCAvailable(boolean bl, int n, int n2) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }

    @Override
    public String getHandlerName() {
        return "EcallAudioDSISoundCmdListener";
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IEcallAudioCmdListener access$100(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        return ecallAudioDSISoundCmdListener.defaultListener;
    }

    static /* synthetic */ LogChannel access$200(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        return ecallAudioDSISoundCmdListener.log;
    }

    static /* synthetic */ LogChannel access$300(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        return ecallAudioDSISoundCmdListener.log;
    }

    static /* synthetic */ LogChannel access$400(EcallAudioDSISoundCmdListener ecallAudioDSISoundCmdListener) {
        return ecallAudioDSISoundCmdListener.log;
    }
}

