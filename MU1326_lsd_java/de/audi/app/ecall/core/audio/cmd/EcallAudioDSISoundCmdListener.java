/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.mib.swdiagnosis.ecall.IEcallDiagnosisComponent;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIBase;
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
        this.getApplication().addDiagnosisComponent(new IEcallDiagnosisComponent(){

            public void cmdUpdateMutePinState(boolean bl) {
                EcallAudioDSISoundCmdListener.this.updateMutePinState(bl, 1);
            }
        });
    }

    public void init() {
        EcallAudioDSISoundClient ecallAudioDSISoundClient = new EcallAudioDSISoundClient();
        this.dsiSoundActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = EcallAudioDSISoundCmdListener.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = EcallAudioDSISoundCmdListener.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), new Integer(0), this, ecallAudioDSISoundClient);
        this.dsiSoundActivator.start(this.getApplication().getBundleContext());
    }

    public void deinit() {
        if (this.dsiSoundActivator != null) {
            this.dsiSoundActivator.stop(this.getApplication().getBundleContext());
        }
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
    }

    public void menuVolEntRange(int n, int n2, int n3) {
    }

    public void menuVolumeRange(int n, int n2, int n3, int n4) {
    }

    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
    }

    public void updateBalance(int n, int n2, short s, int n3) {
    }

    public void updateBalanceRange(int n, int n2, int n3) {
    }

    public void updateBass(int n, int n2, short s, int n3) {
    }

    public void updateBassRange(int n, int n2, int n3) {
    }

    public void createExportFileResult(int n, boolean bl) {
    }

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
    }

    public void updateFader(int n, int n2, short s, int n3) {
    }

    public void updateFaderRange(int n, int n2, int n3) {
    }

    public void importFileResponse(int n, boolean bl) {
    }

    public void updateInputGainOffset(int n, int n2, short s, int n3) {
    }

    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
    }

    public void updateMutePinState(final boolean bl, final int n) {
        this.log.log(1000000, "[EcallAudioDSISoundCmdListener#updateMutePinState] mutePinState=%1", bl);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                IEcallAudioCmdListener iEcallAudioCmdListener = EcallAudioDSISoundCmdListener.this.defaultListener;
                try {
                    iEcallAudioCmdListener = (IEcallAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    EcallAudioDSISoundCmdListener.this.log.log(10000, "[EcallAudioDSISoundCmdListener#updateMutePinState] %1", (Throwable)classCastException);
                }
                iEcallAudioCmdListener.updateMutePinState(bl, n);
            }
        });
    }

    public void updateSoundSet(int n, int n2, long l, int n3) {
    }

    public void updateSoundSetList(long l, int n) {
    }

    public void updateSubwoofer(int n, int n2, short s, int n3) {
    }

    public void updateSubwooferRange(int n, int n2, int n3) {
    }

    public void updateSurrLevelRange(int n, int n2, int n3) {
    }

    public void updateSurroundLevel(int n, int n2, short s, int n3) {
    }

    public void updateTreble(int n, int n2, short s, int n3) {
    }

    public void updateTrebleRange(int n, int n2, int n3) {
    }

    public void updateVolLevelRange(int n, int n2, int n3) {
    }

    public void updateVolume(int n, int n2, short s, int n3) {
        this.log.log(1000000, "EcallAudioDSISoundCmdListener.updateVolume()");
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
    }

    public void updateVolumeRange(int n, int n2, int n3) {
    }

    public void updateMiddle(int n, int n2, short s, int n3) {
    }

    public void updateMiddleRange(int n, int n2, int n3) {
    }

    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
    }

    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
    }

    public void updateOnVolumeLimit(int n, int n2) {
    }

    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
    }

    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
    }

    public void updateMuteTheftProtection(boolean bl, int n) {
    }

    public void updateMicGainLevel(int n, int n2) {
    }

    public void updateVolumeFocus(int n, int n2, int n3) {
    }

    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
    }

    public void updateNoiseCompensationRange(int n, int n2, int n3) {
    }

    public void updateThreeDMode(int n, int n2, int n3, int n4) {
    }

    public void updateThreeDModeRange(int n, int n2, int n3) {
    }

    public void updatePresetPosition(int n, int n2, int n3, int n4) {
    }

    public void updatePresetPositionList(int n, int n2) {
    }

    public void updatePresetEQList(int n, int n2) {
    }

    public void updatePresetEQ(int n, int n2, int n3, int n4) {
    }

    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
    }

    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
    }

    public void responseWidebandSpeech(int n, boolean bl) {
    }

    public void updateSoundShapeActive(boolean bl, int n) {
    }

    public void updateSoundShape(short s, short s2, short s3, int n) {
    }

    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    public void updateICCAvailable(boolean bl, int n, int n2) {
    }

    public void updateProfileState(int n, int n2, int n3) {
    }

    public void profileChanged(int n, int n2) {
    }

    public void profileCopied(int n, int n2, int n3) {
    }

    public void profileReset(int n, int n2) {
    }

    public void profileResetAll(int n) {
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }

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

    private class EcallAudioDSISoundClient
    implements IDSIClient {
        private EcallAudioDSISoundClient() {
        }

        public void setDSI(DSIBase dSIBase) {
            if (dSIBase instanceof DSISound) {
                EcallAudioDSISoundCmdListener.this.log.log(1000000, "[EcallAudioDSISoundCmdListener.EcallAudioDSISoundClient#setDSI] DSISound available");
            } else {
                EcallAudioDSISoundCmdListener.this.log.log(1000000, "[EcallAudioDSISoundCmdListener.EcallAudioDSISoundClient#setDSI] DSISound not available");
            }
        }

        public int[] getAutoNotifications() {
            return new int[]{14, 24};
        }
    }
}

