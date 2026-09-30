/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.TerminalMapper;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.audio.AudioEnv;
import de.audi.audio.CombiServiceHandler;
import de.audi.audio.store.ConnectionStore;
import de.audi.audio.store.VolumelockMap;
import de.audi.audio.volume.VolumeMap;
import java.util.Arrays;

public class VolumePopup {
    public static final int TEXT_ENTERTAINMENT = 0;
    public static final int TEXT_RINGTONE = 1;
    public static final int TEXT_PHONE_CALL = 2;
    public static final int TEXT_TP_MEMO = 3;
    public static final int TEXT_NAVIGATION = 4;
    public static final int TEXT_TMC = 5;
    public static final int TEXT_SDS = 6;
    public static final int TEXT_TA = 7;
    public static final int TEXT_READOUT_CONTACT = 8;
    public static final int TEXT_READOUT_MESSAGE = 9;
    public static final int TEXT_ECALL_CONNECTED_GATEWAY = 13;
    static final int VALUE_ENABLE_CONTENT = 0;
    static final int VALUE_DISABLE_CONTENT = 1;
    private static final int HIDE_POPUP = 0;
    private static final int SHOW_POPUP = 1;
    private final LogChannel lc;
    private final Object mutex = new Object();
    private final ChoiceModelApp controlChoice;
    private final ChoiceModelApp greyoutChoice;
    private final ChoiceModelApp textChoice;
    private final RangeModelApp volumeRange;
    private final int[] activeConns;
    private final int[] activeEntConns;
    private final CombiServiceHandler combi;
    private volatile boolean visible;

    VolumePopup(AudioEnv audioEnv, CombiServiceHandler combiServiceHandler, int n) {
        this.combi = combiServiceHandler;
        this.lc = audioEnv.lcVol;
        this.controlChoice = audioEnv.getChoiceModel(n, 428);
        this.greyoutChoice = audioEnv.getChoiceModel(n, 430);
        this.textChoice = audioEnv.getChoiceModel(n, 429);
        this.volumeRange = audioEnv.getRangeModel(n, 427);
        this.activeConns = new int[8];
        Arrays.fill(this.activeConns, 0);
        this.activeEntConns = new int[8];
        Arrays.fill(this.activeEntConns, 0);
        this.controlChoice.forceUpdate(true);
        this.greyoutChoice.setValue(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void audioStateChanged(int n) {
        int n2 = TerminalMapper.toHmiTerminal(n);
        Object object = this.mutex;
        synchronized (object) {
            int n3;
            int n4 = this.updateActiveConnection(n, n2);
            int n5 = this.updateActiveEntertainmentConnection(n, n2);
            boolean bl = this.isVolumelockActive(n, n4, n5);
            this.lc.log(10000000, "[VolumePopup.audioStateChanged] AAC:%1 AEC:%2 VL:%3", (long)n4, (long)n5, bl);
            if (n4 == 8) {
                this.lc.log(10000000, "[VolumePopup.audioStateChanged] UserMute active -> set volume of AEC:%1 to 0", (long)n5);
                VolumeMap.INSTANCE.setVolume(n5, n, 0);
            }
            if (!bl) {
                this.greyoutChoice.setValue(0);
                this.combi.setVolumeLockActive(false);
                this.lc.log(10000000, "[VolumePopup.audioStateChanged] volumelock not active -> set VALUE_ENABLE_CONTENT");
            }
            if ((n3 = this.getTextID(n4)) != this.textChoice.getValue()) {
                this.hide();
                this.lc.log(10000000, "[VolumePopup.audioStateChanged] textID: %1", (long)n3);
                this.textChoice.setValue(n3);
            }
            this.combi.setVolumePopupText(n3);
            this.setVolume(n4, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void volumeChanged(int n, int n2) {
        this.lc.log(10000000, "[VolumePopup.volumeChanged] AC:%1 AT:%2", (long)n, (long)n2);
        int n3 = TerminalMapper.toHmiTerminal(n2);
        Object object = this.mutex;
        synchronized (object) {
            if (n == this.activeConns[n3]) {
                this.setVolume(n, n2);
            } else if (this.activeConns[n3] == 4) {
                this.setVolume(n, n2);
            }
        }
    }

    final void show() {
        this.lc.log(10000000, "[VolumePopup.show]");
        this.controlChoice.setValue(1);
        this.combi.showVolumePopup(true);
        this.visible = true;
    }

    final void hide() {
        this.lc.log(10000000, "[VolumePopup.hide]");
        this.controlChoice.setValue(0);
        this.combi.showVolumePopup(false);
        this.visible = false;
    }

    public final boolean isVisible() {
        return this.visible;
    }

    private boolean isVolumelockActive(int n, int n2, int n3) {
        boolean bl = ConnectionStore.INSTANCE.isActive(308, 2);
        if (!(n2 != 8 && n2 != n3 || bl)) {
            return VolumelockMap.INSTANCE.isActive(n3, n);
        }
        if (n2 == 106) {
            return true;
        }
        if (AudioConnection.contains(AudioConnection.TA_PTY31, n2)) {
            return VolumelockMap.INSTANCE.isActive(n2, n);
        }
        if (n2 == 159) {
            this.lc.log(10000000, "[VolumePopup.isVolumelockActive] allow volume lock for GAL_SPEECH_INPUT");
            return VolumelockMap.INSTANCE.isActive(n3, n);
        }
        this.lc.log(1000000, "[VolumePopup.isVolumelockActive] set VALUE_ENABLE_CONTENT A2LS active: %1", bl);
        return false;
    }

    public void updateVolumeLock(int n) {
        int n2;
        int n3 = TerminalMapper.toHmiTerminal(n);
        int n4 = this.updateActiveConnection(n, n3);
        if (this.isVolumelockActive(n, n4, n2 = this.updateActiveEntertainmentConnection(n, n3))) {
            this.greyoutChoice.setValue(1);
            this.combi.setVolumeLockActive(true);
            this.lc.log(1000000, "[VolumePopup.updateVolumeLock] set VALUE_DISABLE_CONTENT");
        } else {
            this.greyoutChoice.setValue(0);
            this.combi.setVolumeLockActive(false);
            this.lc.log(1000000, "[VolumePopup.updateVolumeLock] set VALUE_ENABLE_CONTENT");
        }
    }

    private int updateActiveConnection(int n, int n2) {
        int n3 = ConnectionStore.INSTANCE.getActiveConnection(n);
        if (n3 == 0 || n3 == 6 || AudioConnection.contains(AudioConnection.TOUCHPAD_CONNECTIONS, n3) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_BACKGROUND, n3)) {
            this.lc.log(10000000, "[VolumePopup.updateActiveConnection] AAC:%1 AT:%2 IGNORED", (long)n3, (long)n);
        } else {
            this.activeConns[n2] = n3;
        }
        return this.activeConns[n2];
    }

    private int updateActiveEntertainmentConnection(int n, int n2) {
        this.activeEntConns[n2] = ConnectionStore.INSTANCE.getActiveEntertainmentConnection(n);
        return this.activeEntConns[n2];
    }

    private int getTextID(int n) {
        if (AudioConnection.contains(AudioConnection.NAVI, n) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_NAVI_LOWERING, n)) {
            return 4;
        }
        if (AudioConnection.contains(AudioConnection.TA_PTY31, n)) {
            return 7;
        }
        if (AudioConnection.contains(AudioConnection.SDS, n) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_SPEECH, n)) {
            return 6;
        }
        if (this.isRingtoneConnection(n)) {
            return 1;
        }
        if (AudioConnection.contains(AudioConnection.PHONE_CALL, n) || AudioConnection.contains(AudioConnection.TERMINAL_MODE_PHONE, n)) {
            return 2;
        }
        if (AudioConnection.contains(AudioConnection.TMC_CONNS, n)) {
            return 5;
        }
        if (AudioConnection.contains(AudioConnection.READOUT_CONTACT_CONNS, n)) {
            return 8;
        }
        if (AudioConnection.contains(AudioConnection.READOUT_MESSAGE_CONNS, n)) {
            return 9;
        }
        if (AudioConnection.contains(AudioConnection.CONNECTED_GATEWAY_CONNS, n)) {
            return 13;
        }
        return 0;
    }

    private void setVolume(int n, int n2) {
        int n3 = VolumeMap.INSTANCE.getVolume(n2, n);
        if (n3 == -1) {
            this.lc.log(10000000, "[VolumePopup.setVolume] No volume found for AAC:%1.", (long)n);
            return;
        }
        if (n3 != this.volumeRange.getValue() && n3 >= this.volumeRange.getMinimum() && n3 <= this.volumeRange.getMaximum()) {
            this.lc.log(10000000, "[VolumePopup.setVolume] AAC:%1 vol:%2", (long)n, (long)n3);
            this.volumeRange.setValue(n3);
            this.combi.setVolume(n3);
        }
    }

    private boolean isRingtoneConnection(int n) {
        if (AudioConnection.contains(AudioConnection.PHONE_RINGING, n)) {
            return true;
        }
        switch (n) {
            case 87: 
            case 88: 
            case 91: {
                return true;
            }
        }
        return false;
    }
}

