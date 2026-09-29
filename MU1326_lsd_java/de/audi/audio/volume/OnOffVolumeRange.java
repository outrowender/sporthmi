/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.hmi.HMITerminalHelper;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.audio.TIJPVolumeServiceListener;
import de.audi.atip.interapp.audio.VolumeOnOffPressListener;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.interapp.def.NullSDSService;
import de.audi.atip.interapp.def.NullTIJPVolumeService;
import de.audi.atip.interapp.def.NullTelMuteMicService;
import de.audi.atip.interapp.def.NullTelServiceAudio;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.atip.interapp.phone.ITelMuteMicService;
import de.audi.atip.interapp.phone.ITelServiceAudio;
import de.audi.atip.interapp.terminalmode.ITerminalModeAudioService;
import de.audi.atip.util.osgi.NullDSIAudioManagement;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.audio.AudioEnv;
import de.audi.audio.AudioTools;
import de.audi.audio.CombiServiceHandler;
import de.audi.audio.InterAppHandler;
import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.audio.store.ConnectionStore;
import de.audi.audio.store.VolumelockMap;
import de.audi.audio.volume.OnOffVolumeRange$RangeListenerImpl;
import de.audi.audio.volume.OnOffVolumeRange$SoundListener;
import de.audi.audio.volume.VolumePopup;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Enumeration;
import java.util.Vector;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSISound;

public final class OnOffVolumeRange
extends DefaultAudioListener
implements ChoiceListener {
    public final ISoundListener soundListener = new OnOffVolumeRange$SoundListener(this, null);
    private final VolumePopup volumePopup;
    private final String label;
    private final int defaultHmiTerminal;
    private final int defaultAudioTerminal;
    private final RangeModelApp rangeModel;
    private final ChoiceModelApp choiceModel;
    private final InterAppHandler interAppHandler;
    private volatile DSIAudioManagement dsiAudio;
    private volatile DSISound dsiSound;
    private volatile TunerService tunerService;
    private volatile NaviService naviService;
    private volatile SDSService sdsService;
    private volatile ITelServiceAudio phoneAudioService;
    private volatile ITerminalModeAudioService terminalModeAudioService;
    private volatile TIJPVolumeServiceListener etcService;
    private volatile ITelMuteMicService muteMicService;
    private Vector volumeOnOffPressListeners;
    private volatile int defaultMin;
    private volatile int defaultMax;
    private int menuMin;
    private int menuMax;
    private volatile boolean volumeMenuCurrentlyActive;
    private volatile boolean standbyPopupActive;
    private static final int STATUS_LINE_MUTE_OFF;
    private static final int STATUS_LINE_MUTE_ON;
    public static final int ON_OFF_JUMP_ON;
    public static final int ON_OFF_JUMP_OFF;
    private volatile AudioEnv env;

    private OnOffVolumeRange(AudioEnv audioEnv, InterAppHandler interAppHandler, CombiServiceHandler combiServiceHandler, int n) {
        this.env = audioEnv;
        this.interAppHandler = interAppHandler;
        this.standbyPopupActive = false;
        this.volumePopup = new VolumePopup(audioEnv, combiServiceHandler, n);
        this.defaultHmiTerminal = n;
        this.defaultAudioTerminal = TerminalMapper.toAudioTerminal(n);
        this.rangeModel = audioEnv.getRangeModel(n, 427);
        this.label = new Buffer(50).append('[').append(HMITerminalHelper.toString(n)).append("] [OnOffVolumeRange").toString();
        audioEnv.lcMain.log(14808325, "%1.new]", (Object)this.label);
        this.rangeModel.setRangeListener(new OnOffVolumeRange$RangeListenerImpl(this));
        this.rangeModel.setLimits(-100, 100, 1);
        this.choiceModel = audioEnv.getChoiceModel(n, 379);
        this.choiceModel.setChoiceListener(this);
        if (n == 0) {
            RangeModelApp rangeModelApp = audioEnv.getRangeModel(1, 427);
            rangeModelApp.setRangeListener(new OnOffVolumeRange$RangeListenerImpl(this));
            rangeModelApp.setLimits(-100, 100, 1);
        }
        this.dsiAudio = new NullDSIAudioManagement(audioEnv.lcDSI);
        this.dsiSound = new NullDSISound(audioEnv.lcDSI);
        this.tunerService = new NullTunerService(audioEnv.lcMain);
        this.naviService = new NullNaviService(audioEnv.lcMain);
        this.sdsService = new NullSDSService(audioEnv.lcMain);
        this.phoneAudioService = new NullTelServiceAudio(audioEnv.lcMain);
        this.etcService = new NullTIJPVolumeService(audioEnv.lcMain);
        this.muteMicService = new NullTelMuteMicService(audioEnv.lcMain, "ITelMuteMicService");
        this.volumeOnOffPressListeners = new Vector();
    }

    public void setService(Object object) {
        this.env.lcMain.log(1078071040, "%1.setService] %2", (Object)this.label, object);
        if (object instanceof DSIAudioManagement) {
            this.dsiAudio = (DSIAudioManagement)object;
        } else if (object instanceof DSISound) {
            this.dsiSound = (DSISound)object;
        } else if (object instanceof NaviService) {
            this.naviService = (NaviService)object;
        } else if (object instanceof SDSService) {
            this.sdsService = (SDSService)object;
        } else if (object instanceof TunerService) {
            this.tunerService = (TunerService)object;
        } else if (object instanceof ITelServiceAudio) {
            this.phoneAudioService = (ITelServiceAudio)object;
        } else if (object instanceof ITerminalModeAudioService) {
            this.terminalModeAudioService = (ITerminalModeAudioService)object;
        } else if (object instanceof TIJPVolumeServiceListener) {
            this.etcService = (TIJPVolumeServiceListener)object;
        } else if (object instanceof ITelMuteMicService) {
            this.muteMicService = (ITelMuteMicService)object;
        } else if (object instanceof VolumeOnOffPressListener) {
            this.volumeOnOffPressListeners.add(object);
        } else {
            this.env.lcMain.log(10000, "%1.register] Unknown service %2", (Object)this.label, object);
        }
    }

    public void unregisterService(Object object) {
        if (object instanceof VolumeOnOffPressListener && this.volumeOnOffPressListeners.contains(object)) {
            this.volumeOnOffPressListeners.remove(object);
        }
    }

    public void volumeMenuActive(boolean bl) {
        this.volumeMenuCurrentlyActive = bl;
        this.menuMin = this.rangeModel.getMinimum();
        this.menuMax = this.rangeModel.getMaximum();
        if (bl) {
            this.volumePopup.hide();
        }
    }

    public void standbyPopupActive(boolean bl) {
        this.standbyPopupActive = bl;
    }

    @Override
    public void updateConnStatus(int n, int n2, int n3) {
        this.env.lcMain.log(1078071040, "[OnOffVolumeRange.updateConnStatus] connection: %1, status: %2, terminal: %3", (long)n, (long)n2, (long)n3);
        if (n3 != this.defaultHmiTerminal) {
            return;
        }
        if (this.isEcallActive()) {
            this.env.lcVol.log(-2137614336, "%1.updateConnStatus] eCallActive", (Object)this.label);
            this.updateLimits(18, this.defaultMax);
        } else if (this.isTLAMConnectionActive(n)) {
            this.env.lcMain.log(1078071040, "[%1.updateConnStatus] set TLAM range min:1, max:11", (Object)this.label);
            this.updateLimits(1, 11);
        } else if (this.isMenuConnectionActive()) {
            this.env.lcMain.log(1078071040, "[%1.updateConnStatus] set Range to menuMin and menuMax", (Object)this.label);
            this.updateLimits(this.menuMin, this.menuMax);
        } else {
            this.updateLimits(this.defaultMin, this.defaultMax);
        }
    }

    public void audioStateChanged(int n) {
        this.volumePopup.audioStateChanged(n);
    }

    private void setVolume(int n, int n2, int n3) {
        if (this.env.lcVol.isDebug()) {
            String string = AudioTools.toString(n, n2, n3);
            this.env.lcVol.log(-2137614336, "%1.updateVolume] %2", (Object)this.label, (Object)string);
        }
        if (n3 == 0) {
            int n4 = ConnectionStore.INSTANCE.getActiveEntertainmentConnection(n2);
            boolean bl = n == n4;
            boolean bl2 = ConnectionStore.INSTANCE.isActive(n, n2);
            if (bl && bl2) {
                this.env.lcVol.log(-2137614336, "%1.updateVolume] --> request MUTE_ENT", (Object)this.label);
                this.mute();
            }
        }
        this.volumePopup.volumeChanged(n, n2);
    }

    public void updateLimits(int n, int n2) {
        this.env.lcVol.log(-2137614336, "%1.updateLimits] min:%2 max:%3", (Object)this.label, (long)n, (long)n2);
        if (this.rangeModel.getMinimum() != n || this.rangeModel.getMaximum() != n2) {
            this.rangeModel.setLimits(n, n2, 1);
        }
    }

    public int getMin() {
        return this.rangeModel.getMinimum();
    }

    public int getMax() {
        return this.rangeModel.getMaximum();
    }

    public int getDefaultMin() {
        return this.defaultMin;
    }

    public int getDefaultMax() {
        return this.defaultMax;
    }

    private void decreaseVolume(int n, int n2) {
        if (this.volumeMenuCurrentlyActive && !this.volumePopup.isVisible()) {
            this.env.lcVol.log(-2137614336, "%1.decrement] Volume menu active -> map to DDS", (Object)this.label);
            this.interAppHandler.getListener().decVolume(n2);
        } else {
            int n3 = TerminalMapper.toAudioTerminal(this.defaultHmiTerminal);
            this.volumePopup.updateVolumeLock(n3);
            this.env.lcVol.log(-2137614336, "%1.decrement] [DSISound.decreaseVolume] AC:%2 steps:%3", (Object)this.label, (long)n, (long)n2);
            this.dsiSound.decreaseVolume(n, n3, (short)n2);
        }
    }

    private void increaseVolume(int n, int n2) {
        int n3 = TerminalMapper.toAudioTerminal(this.defaultHmiTerminal);
        this.volumePopup.updateVolumeLock(n3);
        int n4 = ConnectionStore.INSTANCE.getActiveConnection(n3);
        if (this.volumeMenuCurrentlyActive && !this.volumePopup.isVisible()) {
            this.env.lcVol.log(-2137614336, "%1.increment] Volume menu active -> map to DDS", (Object)this.label);
            this.interAppHandler.getListener().incVolume(n2);
        } else if (this.isMuteAndVolumelockActive() || n4 == 106) {
            int n5 = ConnectionStore.INSTANCE.getActiveEntertainmentConnection(n3);
            this.env.lcVol.log(1078071040, "%1.increment] AC:%2 AEC:%3 ignore volume increase - muted or locked!", (Object)this.label, (long)n4, (long)n5);
            this.volumePopup.show();
        } else {
            this.env.lcVol.log(-2137614336, "%1.increment] [DSISound.increaseVolume] AC:%2 steps:%3", (Object)this.label, (long)n, (long)n2);
            this.dsiSound.increaseVolume(n, n3, (short)n2);
        }
    }

    private void releaseConnection(int n) {
        this.env.lcDSI.log(-2137614336, "%1.releaseConnection] AC:%2 AT:%3", (Object)this.label, (long)n, (long)this.defaultAudioTerminal);
        this.dsiAudio.releaseConnection(n, this.defaultAudioTerminal);
    }

    private void toggleOnOffButton() {
        if (this.isNotStopped(AudioConnection.PHONE_RINGING)) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Mute incoming call ringing ", (Object)this.label);
            this.phoneAudioService.muteIncomingCallRingtone();
            this.terminalModeAudioService.muteIncomingCarPlayRingtone();
            return;
        }
        if (this.isNotStopped(AudioConnection.NAVI)) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Abort active navi announcement", (Object)this.label);
            this.naviService.abortActiveAnnouncement();
            return;
        }
        if (this.isNotStopped(AudioConnection.TA_PTY31)) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Abort active TA", (Object)this.label);
            this.tunerService.abortActiveTA();
            return;
        }
        if (this.isNotStopped(AudioConnection.SDS)) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Abort active SDS dialogue", (Object)this.label);
            this.sdsService.abortSDSSession(true, (byte)2);
            return;
        }
        if (this.isNotStopped(AudioConnection.ETC)) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Abort active ETC", (Object)this.label);
            this.etcService.abortReadOut();
            return;
        }
        if (this.isNotStopped(AudioConnection.PHONE_CALL)) {
            if (this.env.framework.getSysConst(4572) == 1) {
                if (this.isNotStopped(new int[]{102})) {
                    this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Unmute microphone", (Object)this.label);
                    this.muteMicService.toggleMuteMicrophone(false);
                } else {
                    this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Mute microphone", (Object)this.label);
                    this.muteMicService.toggleMuteMicrophone(true);
                }
            }
            return;
        }
        int n = this.getReadoutType();
        if (n != -1) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Abort active TTS read-out. Type:%2", (Object)this.label, (long)n);
            Enumeration enumeration = this.volumeOnOffPressListeners.elements();
            while (enumeration.hasMoreElements()) {
                ((VolumeOnOffPressListener)enumeration.nextElement()).volumeOnOffPressed(n);
            }
            return;
        }
        if (this.isInUse(3)) {
            this.env.lcVol.log(-2137614336, "%1.toggleOnOffButton] Ignore as LC_MUTE_MMISTANDBY active", (Object)this.label);
            return;
        }
        if (this.standbyPopupActive) {
            this.env.lcVol.log(-2137614336, "%1.toggleOnOffButton] standbyPopup is active do not mute/demute", (Object)this.label);
            this.standbyPopupActive = false;
            return;
        }
        boolean bl = this.isInUse(8);
        if (this.env.framework.isPorsche()) {
            this.volumePopup.show();
        }
        if (bl) {
            this.demute();
        } else {
            this.mute();
        }
    }

    private int getReadoutType() {
        if (this.isInUse(126)) {
            return 0;
        }
        if (this.isInUse(127)) {
            return 1;
        }
        if (this.isInUse(125)) {
            return 2;
        }
        if (this.isInUse(114) || this.isInUse(115)) {
            return 3;
        }
        return -1;
    }

    private void mute() {
        if (this.isMuteActive()) {
            this.env.lcVol.log(1078071040, "%1.mute] IGNORE as standby or SWDL mute active!", (Object)this.label);
        } else {
            this.env.lcDSI.log(-2137614336, "%1.mute] requestConnection: AC:%2 AT:%3", (Object)this.label, (long)0, (long)this.defaultAudioTerminal);
            this.dsiAudio.requestConnection(8, this.defaultAudioTerminal, 0);
            ConnectionStore.INSTANCE.setStatus(8, 3, this.defaultAudioTerminal);
        }
    }

    private void demute() {
        int n = ConnectionStore.INSTANCE.getActiveEntertainmentConnection(this.defaultAudioTerminal);
        if (this.isMuteAndVolumelockActive()) {
            this.env.lcVol.log(1078071040, "%1.toggleOnOffButton] Don't demute while active volumelock for AEC:%2", (Object)this.label, (long)n);
        } else {
            this.env.lcVol.log(-2137614336, "%1.toggleOnOffButton] DEMUTE", (Object)this.label);
            this.releaseConnection(8);
            ConnectionStore.INSTANCE.setStatus(8, 6, this.defaultAudioTerminal);
        }
    }

    private boolean isMuteAndVolumelockActive() {
        if (ConnectionStore.INSTANCE.getActiveConnection(this.defaultAudioTerminal) != 8) {
            return false;
        }
        int n = ConnectionStore.INSTANCE.getActiveEntertainmentConnection(this.defaultAudioTerminal);
        return VolumelockMap.INSTANCE.isActive(n, this.defaultAudioTerminal);
    }

    private boolean isNotStopped(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!this.isInUse(nArray[i2])) continue;
            return true;
        }
        return false;
    }

    private boolean isEcallActive() {
        return ConnectionStore.INSTANCE.getStatus(227, this.defaultAudioTerminal) <= 3 || ConnectionStore.INSTANCE.getStatus(228, this.defaultAudioTerminal) <= 3 || ConnectionStore.INSTANCE.getStatus(225, this.defaultAudioTerminal) <= 3;
    }

    private boolean isTLAMConnectionActive(int n) {
        return this.env.framework.isPorsche() && AudioConnection.contains(AudioConnection.NAVI, n) && ConnectionStore.INSTANCE.getStatus(n, this.defaultAudioTerminal) <= 3;
    }

    private boolean isInUse(int n) {
        int n2 = ConnectionStore.INSTANCE.getStatus(n, this.defaultAudioTerminal);
        return n2 != 6 && n2 != 5;
    }

    private boolean isMuteActive() {
        return this.isInUse(8) || this.isInUse(3) || this.isInUse(7);
    }

    private boolean isMenuConnectionActive() {
        for (int i2 = 0; i2 < AudioConnection.VOLUME_MENU_CONNECTIONS.length; ++i2) {
            if (ConnectionStore.INSTANCE.getStatus(AudioConnection.VOLUME_MENU_CONNECTIONS[i2], this.defaultAudioTerminal) > 3) continue;
            this.env.lcVol.log(14808325, "[OnOffVolumeRange.isMenuConnectionRequested] true");
            return true;
        }
        return false;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 379) {
            this.env.lcVol.log(-2137614336, "%1.itemSelected] value:%2", (Object)this.label, (long)n2);
            switch (n2) {
                case 0: {
                    this.demute();
                    break;
                }
                case 1: {
                    this.mute();
                    break;
                }
                default: {
                    this.env.lcVol.log(-2137614336, "%1.itemSelected] value:%2 unrecognized - Ignored", (Object)this.label, (long)n2);
                }
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    static /* synthetic */ void access$100(OnOffVolumeRange onOffVolumeRange, int n, int n2, int n3) {
        onOffVolumeRange.setVolume(n, n2, n3);
    }

    static /* synthetic */ String access$200(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.label;
    }

    static /* synthetic */ AudioEnv access$300(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.env;
    }

    static /* synthetic */ int access$402(OnOffVolumeRange onOffVolumeRange, int n) {
        onOffVolumeRange.defaultMin = n;
        return onOffVolumeRange.defaultMin;
    }

    static /* synthetic */ int access$502(OnOffVolumeRange onOffVolumeRange, int n) {
        onOffVolumeRange.defaultMax = n;
        return onOffVolumeRange.defaultMax;
    }

    static /* synthetic */ VolumePopup access$600(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.volumePopup;
    }

    static /* synthetic */ boolean access$700(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.volumeMenuCurrentlyActive;
    }

    static /* synthetic */ boolean access$800(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.isMenuConnectionActive();
    }

    static /* synthetic */ int access$900(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.defaultAudioTerminal;
    }

    static /* synthetic */ void access$1000(OnOffVolumeRange onOffVolumeRange) {
        onOffVolumeRange.toggleOnOffButton();
    }

    static /* synthetic */ RangeModelApp access$1100(OnOffVolumeRange onOffVolumeRange) {
        return onOffVolumeRange.rangeModel;
    }

    static /* synthetic */ void access$1200(OnOffVolumeRange onOffVolumeRange, int n, int n2) {
        onOffVolumeRange.decreaseVolume(n, n2);
    }

    static /* synthetic */ boolean access$1300(OnOffVolumeRange onOffVolumeRange, int[] nArray) {
        return onOffVolumeRange.isNotStopped(nArray);
    }

    static /* synthetic */ void access$1400(OnOffVolumeRange onOffVolumeRange, int n, int n2) {
        onOffVolumeRange.increaseVolume(n, n2);
    }

    static /* synthetic */ boolean access$1500(OnOffVolumeRange onOffVolumeRange, int n) {
        return onOffVolumeRange.isInUse(n);
    }
}

