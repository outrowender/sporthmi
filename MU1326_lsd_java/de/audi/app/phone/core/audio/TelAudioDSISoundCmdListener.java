/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioCmdDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class TelAudioDSISoundCmdListener
extends AbstractPhoneComponent
implements ICommandResponseSupplier,
DSISoundListener {
    private DSIActivator dsiSoundActivator;
    private final ITelAudioCmdListener defaultListener;
    private final CommandListManager cmdListManager;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    public TelAudioDSISoundCmdListener(ITelApplication iTelApplication, TelAudioCmdDefaultListener telAudioCmdDefaultListener, CommandListManager commandListManager) {
        super(iTelApplication, "App.Phone.Audio");
        this.defaultListener = telAudioCmdDefaultListener;
        this.cmdListManager = commandListManager;
    }

    public void init() {
        TelAudioDSISoundClient telAudioDSISoundClient = new TelAudioDSISoundClient();
        this.dsiSoundActivator = new DSIActivator(this.getApplication().getFrameworkAccess(), (class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = TelAudioDSISoundCmdListener.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound).getName(), (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = TelAudioDSISoundCmdListener.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName(), new Integer(0), this, telAudioDSISoundClient);
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

    public void updateMutePinState(boolean bl, int n) {
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

    public void responseWidebandSpeech(final int n, final boolean bl) {
        this.log.log(10000000, "[TelAudioDSISoundCmdListener#responseWidebandSpeech] onoff=%1", bl);
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ITelAudioCmdListener iTelAudioCmdListener = TelAudioDSISoundCmdListener.this.defaultListener;
                try {
                    iTelAudioCmdListener = (ITelAudioCmdListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    TelAudioDSISoundCmdListener.this.log.log(10000, "[TelAudioDSISoundCmdListener#responseWidebandSpeech] %1", (Throwable)classCastException);
                }
                iTelAudioCmdListener.responseWidebandSpeech(n, bl);
            }
        });
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
        return "TelAudioDSISoundCmdListener";
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelAudioDSISoundClient
    implements IDSIClient {
        private TelAudioDSISoundClient() {
        }

        public void setDSI(DSIBase dSIBase) {
            if (dSIBase instanceof DSISound) {
                TelAudioDSISoundCmdListener.this.log.log(1000000, "[TelAudioHandler.TelAudioDSISoundClient#setDSI] DSISound available");
            } else {
                TelAudioDSISoundCmdListener.this.log.log(1000000, "[TelAudioHandler.TelAudioDSISoundClient#setDSI] DSISound not available");
            }
        }

        public int[] getAutoNotifications() {
            return new int[0];
        }
    }
}

