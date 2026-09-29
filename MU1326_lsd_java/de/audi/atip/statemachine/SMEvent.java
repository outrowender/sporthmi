/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.SMEventAddressBook;
import de.audi.atip.statemachine.SMEventBluetooth;
import de.audi.atip.statemachine.SMEventCar;
import de.audi.atip.statemachine.SMEventConnectivity;
import de.audi.atip.statemachine.SMEventEarlyApps;
import de.audi.atip.statemachine.SMEventEcall;
import de.audi.atip.statemachine.SMEventEngineering;
import de.audi.atip.statemachine.SMEventInfo;
import de.audi.atip.statemachine.SMEventInfoAsia;
import de.audi.atip.statemachine.SMEventMedia;
import de.audi.atip.statemachine.SMEventMessaging;
import de.audi.atip.statemachine.SMEventNavAsia;
import de.audi.atip.statemachine.SMEventNavi;
import de.audi.atip.statemachine.SMEventOnline;
import de.audi.atip.statemachine.SMEventPhone;
import de.audi.atip.statemachine.SMEventPictureNav;
import de.audi.atip.statemachine.SMEventSWDL;
import de.audi.atip.statemachine.SMEventSettings;
import de.audi.atip.statemachine.SMEventSpeech;
import de.audi.atip.statemachine.SMEventSystem;
import de.audi.atip.statemachine.SMEventTV;
import de.audi.atip.statemachine.SMEventTerminalMode;
import de.audi.atip.statemachine.SMEventTestSupport;
import de.audi.atip.statemachine.SMEventTone;
import de.audi.atip.statemachine.SMEventTpegKR;
import de.audi.atip.statemachine.SMEventTrafficInfoJP;
import de.audi.atip.statemachine.SMEventTuner;
import de.audi.atip.statemachine.SMEventWirelessCharging;

public interface SMEvent
extends SMEventAddressBook,
SMEventBluetooth,
SMEventCar,
SMEventEarlyApps,
SMEventInfo,
SMEventInfoAsia,
SMEventMedia,
SMEventMessaging,
SMEventNavAsia,
SMEventNavi,
SMEventOnline,
SMEventPhone,
SMEventSettings,
SMEventTestSupport,
SMEventSWDL,
SMEventSystem,
SMEventTone,
SMEventTuner,
SMEventSpeech,
SMEventPictureNav,
SMEventEngineering,
SMEventConnectivity,
SMEventTV,
SMEventEcall,
SMEventTerminalMode,
SMEventWirelessCharging,
SMEventTpegKR,
SMEventTrafficInfoJP {
    public static final int SK_NW;
    public static final int SK_NE;
    public static final int SK_SW;
    public static final int SK_SE;
    public static final int MFL_MENU;
    public static final int TUNER;
    public static final int MEDIA;
    public static final int HK_NAV;
    public static final int HK_MENU;
    public static final int SYS_INIT_COMPLETE;
    public static final int SDS_INFO_TPMEMO_LIST;
    public static final int _SWDL_ENTER_EVENT;
    public static final int _SWDL_EXIT_EVENT;
    public static final int _CUST_DOWNLOAD_DIRECT_JUMP;
}

