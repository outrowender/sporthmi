/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.audio.ATIPAudioService;
import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.interapp.def.NullATIPAudioService;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.tone.app.IGreyOutAndPopupHandler;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.dsi.AudioServiceHandler;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.intra.AbstractAppListener;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.HeartbeatVolumeRange;
import de.audi.tone.app.volume.IDrawerStateListener;
import de.audi.tone.app.volume.InfoAnnouncementVolumeRange;
import de.audi.tone.app.volume.NaviVolumeRange;
import de.audi.tone.app.volume.NullVolumeRange;
import de.audi.tone.app.volume.PhoneMicGainVolumeRange;
import de.audi.tone.app.volume.PhoneRingtoneVolumeRange;
import de.audi.tone.app.volume.RingtoneSelectionVolumeRange;
import de.audi.tone.app.volume.SDSVolumeRange;
import de.audi.tone.app.volume.SMSBeepVolumeRange;
import de.audi.tone.app.volume.TAVolumeRange;
import de.audi.tone.app.volume.ToneServiceImpl;
import de.audi.tone.app.volume.TouchpadVolumeRange;
import de.audi.tone.app.volume.WirelessChargingVolumeRange;
import de.audi.tone.app.volume.greyout.VolumeRangeManagerGreyOutHandler;
import de.audi.tone.app.volume.lowered.AbstractLoweredEnt;
import de.audi.tone.app.volume.lowered.LoweredEntAps;
import de.audi.tone.app.volume.lowered.LoweredEntNav;
import de.audi.tone.app.volume.lowered.NullLoweredEnt;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class VolumeRangeManager
extends AbstractAppListener
implements IDrawerStateListener,
IViewSizeListener {
    static final int MENU_INVALID = -1;
    public static final int MENU_NAVI_EU = 0;
    public static final int MENU_TA = 1;
    public static final int MENU_SDS = 2;
    public static final int MENU_PHONE_RINGTONE = 3;
    public static final int MENU_LOWERED_ENT_NAVI = 4;
    public static final int MENU_LOWERED_ENT_APS = 5;
    public static final int MENU_TOUCHPAD = 6;
    public static final int MENU_SMS_BEEP = 7;
    public static final int MENU_HEARTBEAT = 8;
    public static final int MENU_PHONE_RINGTONE_SEL = 9;
    public static final int MENU_PHONE_MIC_GAIN = 10;
    public static final int MENU_WC = 11;
    public static final int MENU_INFO_ANNOUNCEMENT = 12;
    protected static final int MENU_COUNT = 13;
    protected static final int LOWERED_MENU_COUNT = 2;
    protected static final int LOWERED_MENU_APS = 0;
    protected static final int LOWERED_MENU_NAV = 1;
    private static final int TONE_LEFT_DRAWER_SETTINGS = 0;
    private static final int TONE_LEFT_DRAWER_PHONE = 1;
    private static final int TONE_LEFT_DRAWER_NAVI = 2;
    private static final int TONE_LEFT_DRAWER_ANNOUNCEMENT = 3;
    private static final int TONE_LEFT_DRAWER_SPEECH = 4;
    private static final int TONE_LEFT_DRAWER_PARKING = 5;
    private static final int TONE_LEFT_DRAWER_MMI_TOUCH = 6;
    private static final int TONE_LEFT_DRAWER_AUDI_DEPARTURE_SOUND = 7;
    private static final int TONE_LEFT_DRAWER_WC = 8;
    private static final int STANDBY_MUTE_ACTIVE = 1;
    private static final int STANDBY_MUTE_INACTIVE = 0;
    public static final int LOW_APS_DDB_OPENED = 0;
    public static final int LOW_APS_DDB_CLOSED = 1;
    public final ActionProxyListener actionProxyListener = new ActionProxyListenerExt();
    protected AbstractVolumeRange[] menus;
    protected AbstractLoweredEnt[] loweredEntMenus;
    private final AbstractVolumeRange dummyMenu;
    public final ToneService toneService;
    final ToneEnv env;
    final IDSISoundHandler dsiSound;
    final AudioServiceHandler audioService;
    private final AbstractLoweredEnt loweredEntAps;
    private final AbstractLoweredEnt loweredEntNav;
    private final IGreyOutAndPopupHandler greyOutHandler;
    protected final boolean activateOnOffButtons;
    private volatile AbstractVolumeRange activeVolumeMenu;
    private ATIPAudioService atipAudio;

    public VolumeRangeManager(ToneEnv toneEnv, IDSISoundHandler iDSISoundHandler, AudioServiceHandler audioServiceHandler) {
        this.env = toneEnv;
        this.dsiSound = iDSISoundHandler;
        this.audioService = audioServiceHandler;
        this.atipAudio = new NullATIPAudioService(toneEnv.lcMain);
        this.toneService = new ToneServiceImpl(this);
        this.activeVolumeMenu = this.dummyMenu = new NullVolumeRange(this);
        this.loweredEntAps = new LoweredEntAps(this, iDSISoundHandler);
        this.loweredEntNav = new LoweredEntNav(this, iDSISoundHandler);
        this.loweredEntMenus = new AbstractLoweredEnt[2];
        NullLoweredEnt nullLoweredEnt = new NullLoweredEnt(this, iDSISoundHandler);
        this.loweredEntMenus[0] = nullLoweredEnt;
        this.loweredEntMenus[1] = nullLoweredEnt;
        this.menus = new AbstractVolumeRange[13];
        this.menus[3] = this.dummyMenu;
        this.menus[9] = this.dummyMenu;
        this.menus[10] = this.dummyMenu;
        this.menus[1] = this.dummyMenu;
        this.menus[2] = this.dummyMenu;
        this.menus[0] = this.dummyMenu;
        this.menus[4] = this.dummyMenu;
        this.menus[5] = this.dummyMenu;
        this.menus[6] = this.dummyMenu;
        this.menus[7] = this.dummyMenu;
        this.menus[8] = this.dummyMenu;
        this.menus[11] = this.dummyMenu;
        this.menus[12] = this.dummyMenu;
        this.activateOnOffButtons = toneEnv.getSysConst(4604) == 1;
        ChoiceModelApp choiceModelApp = toneEnv.getChoiceModel(4073);
        this.greyOutHandler = new VolumeRangeManagerGreyOutHandler(choiceModelApp, new int[0], toneEnv.lcHMI, "VolumeRangeManager");
    }

    public void createVolumeMenus() {
        this.loweredEntMenus[0] = this.loweredEntAps;
        this.loweredEntMenus[1] = this.loweredEntNav;
        this.menus[3] = new PhoneRingtoneVolumeRange(this);
        this.menus[1] = new TAVolumeRange(this);
        this.menus[2] = new SDSVolumeRange(this);
        this.menus[0] = new NaviVolumeRange(this);
        this.menus[4] = this.loweredEntNav;
        this.menus[5] = this.loweredEntAps;
        this.menus[6] = new TouchpadVolumeRange(this);
        this.menus[7] = new SMSBeepVolumeRange(this);
        this.menus[8] = new HeartbeatVolumeRange(this);
        this.menus[9] = new RingtoneSelectionVolumeRange(this);
        this.menus[10] = new PhoneMicGainVolumeRange(this);
        if (this.env.getSysConst(4162) == 1) {
            this.menus[11] = new WirelessChargingVolumeRange(this);
        }
        this.menus[12] = new InfoAnnouncementVolumeRange(this);
    }

    public void register(ATIPAudioService aTIPAudioService) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.register] ATIPAudioService:%1", (Object)aTIPAudioService);
        this.atipAudio = aTIPAudioService;
    }

    public void updateAMAvailable(boolean bl) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.updateAMAvailable] %1", bl);
        if (bl) {
            this.init();
        }
    }

    public void init() {
        this.env.lcMain.log(1000000, "[VolumeRangeManager.init]");
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            this.menus[i2].init();
        }
    }

    public ToneEnv getEnv() {
        return this.env;
    }

    public void updateConnectionStatus(int n, int n2, int n3) {
        if (this.env.isFrontUnit() && n3 != 0) {
            return;
        }
        this.env.lcMain.log(10000000, "[VolumeRangeManager.updateConnectionStatus] status:%1 AC:%2 HT:%3", (long)n2, (long)n, (long)n3);
        block0 : switch (n2) {
            case 2: {
                if (n == 94) {
                    this.setAudible(n, true);
                } else if (n == this.menus[3].getForegroundConnection()) {
                    this.setAudible(n, true);
                }
                if (n != 3) break;
                this.env.getChoiceModel(1000106).setValue(1);
                this.env.lcMain.log(10000000, "[VolumeRangeManager.updateConnectionStatus] MUTE_STANDBY active jump out");
                break;
            }
            case 0: {
                if (n == this.menus[3].getForegroundConnection()) break;
                this.setAudible(n, true);
                break;
            }
            case 4: 
            case 5: {
                if (n == 3) {
                    this.env.getChoiceModel(1000106).setValue(0);
                    this.env.lcMain.log(10000000, "[VolumeRangeManager.updateConnectionStatus] MUTE_STANDBY not active, show all menus");
                }
                this.setAudible(n, false);
                switch (n) {
                    case 31: 
                    case 32: 
                    case 33: 
                    case 34: {
                        this.menus[1].init();
                        break block0;
                    }
                }
                break;
            }
        }
    }

    public void menuVolumeRange(int n, int n2, int n3) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.menuVolumeRange] AC:%1 min:%2 max:%3", (long)n, (long)n2, (long)n3);
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            AbstractVolumeRange abstractVolumeRange = this.menus[i2];
            if (abstractVolumeRange.getLimitsConnection() != n) continue;
            abstractVolumeRange.updateLimits(n2, n3);
        }
    }

    public void menuVolEntRange(int n, int n2, int n3) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.menuVolEntRange] type:%1 min:%2 max:%3", (long)n, (long)n2, (long)n3);
        for (int i2 = 0; i2 < this.loweredEntMenus.length; ++i2) {
            if (n != this.loweredEntMenus[i2].getLoweringType()) continue;
            this.loweredEntMenus[i2].updateLimits(n2, n3);
        }
    }

    public void updateLoweringEntertainment(int n, int n2) {
        for (int i2 = 0; i2 < this.loweredEntMenus.length; ++i2) {
            this.loweredEntMenus[i2].updateLoweringEntertainment(n, n2);
        }
    }

    public void updateVolume(int n, int n2, int n3) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.updateVolume] AC:%1 volume:%2 HT:%3", (long)n2, (long)n3, (long)n);
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            if (!this.menus[i2].isVolumeConnection(n2)) continue;
            this.menus[i2].updateValue(n3);
        }
    }

    public void entered(int n, int n2) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.entered] called ");
        if (this.activeVolumeMenu == this.menus[n]) {
            this.env.lcMain.log(10000000, "[VolumeRangeManager.entered] menu: %1 already active -> return", (long)n);
            return;
        }
        this.activeVolumeMenu = this.menus[n];
        this.activeVolumeMenu.entered();
        this.atipAudio.volumeMenuEntered(this.activeVolumeMenu.getMin(), this.activeVolumeMenu.getMax(), this.activeVolumeMenu.enableOnOffDDSMapping());
    }

    public void left(int n, int n2) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.left] called");
        if (this.activeVolumeMenu != this.menus[n]) {
            this.env.lcMain.log(10000000, "[VolumeRangeManager.left] menu: %1 not active -> return", (long)n);
            return;
        }
        this.menus[n].left();
        this.activeVolumeMenu = this.dummyMenu;
        this.atipAudio.volumeMenuLeft();
    }

    public void menuDrawerFocused(int n) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.menuDrawerOpen] menuID:%1 ", (long)n);
        this.atipAudio.volumeMenuEntered(this.activeVolumeMenu.getMin(), this.activeVolumeMenu.getMax(), this.activeVolumeMenu.enableOnOffDDSMapping());
    }

    public void menuDrawerUnfocused(int n) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.menuDrawerClosed] menuID:%1 ", (long)n);
        this.atipAudio.volumeMenuLeft();
    }

    public void viewSizeChanged(int n) {
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            this.menus[i2].viewSizeChanged(n);
        }
    }

    public void registerService(int n, Object object) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.registerService] menu:%2 service:%1", object, (long)n);
        this.menus[n].registerService(object);
    }

    public void deregisterService(int n, Object object) {
        this.env.lcMain.log(10000000, "[VolumeRangeManager.deregisterService] menu:%2 service:%1", object, (long)n);
        this.menus[n].deregisterService(object);
    }

    public ISamplePlayer getSamplePlayer(int n) {
        return this.menus[n].getSamplePlayer();
    }

    AbstractVolumeRange getMenuByID(int n) {
        try {
            return this.menus[n];
        }
        catch (Exception exception) {
            return this.dummyMenu;
        }
    }

    public AbstractVolumeRange[] getMenus() {
        return this.menus;
    }

    public AbstractVolumeRange getActiveMenu() {
        return this.activeVolumeMenu;
    }

    public void updateActiveEntertainmentConnection(int n, int n2) {
        this.greyOutHandler.updateActiveEntertainmentConnection(n, n2);
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            this.menus[i2].updateActiveEntertainmentConnection(n, n2);
        }
    }

    public void updateActiveConnection(int n, int n2) {
        this.greyOutHandler.updateActiveConnection(n, n2);
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            this.menus[i2].updateActiveConnection(n, n2);
        }
    }

    private void setAudible(int n, boolean bl) {
        for (int i2 = 0; i2 < this.menus.length; ++i2) {
            AbstractVolumeRange abstractVolumeRange = this.menus[i2];
            if (abstractVolumeRange.getForegroundConnection() != n) continue;
            abstractVolumeRange.audible(bl);
        }
    }

    private class ActionProxyListenerExt
    extends ActionProxyListener {
        ActionProxyListenerExt() {
            super(0);
        }

        public void volumeLoweredEntertainmentAPSEntered() {
            VolumeRangeManager.this.entered(5, this.terminalID);
        }

        public void volumeLoweredEntertainmentAPSLeft() {
            VolumeRangeManager.this.left(5, this.terminalID);
        }

        public void volumeHeartbeatEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(7);
            VolumeRangeManager.this.entered(8, this.terminalID);
        }

        public void volumeHeartbeatLeft() {
            VolumeRangeManager.this.left(8, this.terminalID);
        }

        public void volumeNavEntered() {
            VolumeRangeManager.this.entered(0, this.terminalID);
        }

        public void volumeNavExited() {
            VolumeRangeManager.this.left(0, this.terminalID);
        }

        public void volumeSDSEntered() {
            VolumeRangeManager.this.entered(2, this.terminalID);
        }

        public void volumeSDSExited() {
            VolumeRangeManager.this.left(2, this.terminalID);
        }

        public void volumeTelEntered() {
            VolumeRangeManager.this.entered(3, this.terminalID);
        }

        public void volumeTelExited() {
            VolumeRangeManager.this.left(3, this.terminalID);
        }

        public void volumeTelMsgEntered() {
            VolumeRangeManager.this.entered(7, this.terminalID);
        }

        public void volumeTelMsgLeft() {
            VolumeRangeManager.this.left(7, this.terminalID);
        }

        public void volumeTPEntered() {
            VolumeRangeManager.this.entered(1, this.terminalID);
        }

        public void volumeTPExited() {
            VolumeRangeManager.this.left(1, this.terminalID);
        }

        public void volumeTouchpadEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(6);
            VolumeRangeManager.this.entered(6, this.terminalID);
        }

        public void volumeTouchpadLeft() {
            VolumeRangeManager.this.left(6, this.terminalID);
        }

        public void toneSettingsEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(0);
        }

        public void tonePhoneEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(1);
        }

        public void toneNaviEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(2);
        }

        public void toneAnnouncementEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(3);
        }

        public void toneSpeechEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(4);
        }

        public void toneParkingEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(5);
        }

        public void volumeTouchInitEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(6);
        }

        public void volumeRingtoneSelectionEntered() {
            VolumeRangeManager.this.entered(9, this.terminalID);
        }

        public void volumeRingtoneSelectionLeft() {
            VolumeRangeManager.this.left(9, this.terminalID);
        }

        public void volumeTelMicEntered() {
            VolumeRangeManager.this.entered(10, this.terminalID);
        }

        public void volumeTelMicLeft() {
            VolumeRangeManager.this.left(10, this.terminalID);
        }

        public void volumeWCEntered() {
            VolumeRangeManager.this.entered(11, this.terminalID);
        }

        public void volumeWCLeft() {
            VolumeRangeManager.this.left(11, this.terminalID);
        }

        public void volumeInfoAnnouncementEntered() {
            VolumeRangeManager.this.entered(12, this.terminalID);
        }

        public void volumeInfoAnnouncementLeft() {
            VolumeRangeManager.this.left(12, this.terminalID);
        }

        public void WCMenuEntered() {
            VolumeRangeManager.this.env.getChoiceModel(1000057).setValue(8);
        }
    }
}

