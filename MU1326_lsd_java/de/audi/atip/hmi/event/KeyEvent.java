/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;

public class KeyEvent
extends ATIPEvent {
    public static final int KEYEVENT_FIRST = 10401;
    public static final int KEY_PRESSED = 10401;
    public static final int KEY_RELEASED = 10402;
    public static final int KEY_TURNED = 10403;
    public static final int KEY_MOVED = 10404;
    public static final int KEY_LONG_PRESSED = 10405;
    public static final int KEY_INVALID = 0;
    public static final int KEY_TUN = 1;
    public static final int KEY_MED = 2;
    public static final int KEY_MAIL = 3;
    public static final int KEY_TEL = 4;
    public static final int KEY_NAV = 5;
    public static final int KEY_TRAFFIC = 6;
    public static final int KEY_CAR = 7;
    public static final int KEY_SK_NW = 9;
    public static final int KEY_SK_SW = 10;
    public static final int KEY_SK_NE = 11;
    public static final int KEY_SK_SE = 12;
    public static final int KEY_PREV = 13;
    public static final int KEY_NEXT = 14;
    public static final int KEY_BACK = 15;
    public static final int INC_VOL_ENTER = 16;
    public static final int INC_MENU_ENTER = 17;
    public static final int KEY_PTT = 18;
    public static final int KEY_MODE = 19;
    public static final int INC_ROLLER_LEFT = 20;
    public static final int INC_ROLLER_RIGHT = 21;
    public static final int KEY_JOYSTICK = 22;
    public static final int KEY_PTT_LONGPRESSED = 23;
    public static final int KEY_COMBO_REM = 24;
    public static final int KEY_COMBO_GEM = 25;
    public static final int KEY_COMBO_HMI_EM = 26;
    public static final int KEY_PTT_DOUBLEPRESSED = 28;
    public static final int KEY_PTT_OFF = 29;
    public static final int KEY_MENU = 30;
    public static final int KEY_LEFT = 31;
    public static final int KEY_RIGHT = 32;
    public static final int KEY_MUTE = 33;
    public static final int KEY_DRIVE_SELECT = 34;
    public static final int KEY_TONE = 35;
    public static final int KEY_RC_AC = 36;
    public static final int KEY_RC_SK_NW = 37;
    public static final int KEY_RC_SK_SW = 38;
    public static final int KEY_RC_SK_NE = 39;
    public static final int KEY_RC_SK_SE = 40;
    public static final int KEY_RC_BACK = 41;
    public static final int RC_INC_MENU_ENTER = 42;
    public static final int KEY_STATION_1 = 43;
    public static final int KEY_STATION_2 = 44;
    public static final int KEY_STATION_3 = 45;
    public static final int KEY_STATION_4 = 46;
    public static final int KEY_STATION_5 = 47;
    public static final int KEY_STATION_6 = 48;
    public static final int KEY_INFO = 49;
    public static final int KEY_JOKER1 = 50;
    public static final int KEY_JOKER2 = 51;
    public static final int KEY_INIT = 52;
    public static final int KEY_ECALL_1 = 53;
    public static final int KEY_ECALL_2 = 54;
    public static final int KEY_AC = 55;
    public static final int KEY_UP = 56;
    public static final int KEY_DOWN = 57;
    public static final int KEY_HOOK = 58;
    public static final int KEY_HANGUP = 59;
    public static final int KEY_BREAK_DOWN = 60;
    public static final int KEY_3TMR = 61;
    public static final int KEY_3TMC = 62;
    public static final int KEY_3TML = 63;
    public static final int KEY_TP_ENCODER_X = 64;
    public static final int KEY_TP_ENCODER_Y = 65;
    public static final int KEY_DISPLAY = 66;
    public static final int KEY_LONGPRESS_ON_OFF = 67;
    public static final int KEY_JOYSTICK_NW = 68;
    public static final int KEY_JOYSTICK_N = 69;
    public static final int KEY_JOYSTICK_NE = 70;
    public static final int KEY_JOYSTICK_E = 71;
    public static final int KEY_JOYSTICK_SE = 72;
    public static final int KEY_JOYSTICK_S = 73;
    public static final int KEY_JOYSTICK_SW = 74;
    public static final int KEY_JOYSTICK_W = 75;
    public static final int KEY_JOYSTICK_IDLE = 76;
    public static final int KEY_SK_WEST = 77;
    public static final int KEY_SK_EAST = 78;
    public static final int KEY_STATION_7 = 79;
    public static final int KEY_STATION_8 = 80;
    public static final int KEY_JOKER1_LONGPRESS = 81;
    public static final int KEY_MAP = 82;
    public static final int KEY_SOURCE = 83;
    public static final int KEY_OPTION = 84;
    public static final int KEY_HOR = 85;
    public static final int KEY_TP_CENTER = 86;
    public static final int KEY_TRAFFIC_PROGRAM = 87;
    public static final int KEY_TAB_PREV = 88;
    public static final int KEY_TAB_NEXT = 89;
    public static final int KEY_FOCUS = 90;
    public static final int KEY_SEAT = 91;
    public static final int KEY_HYBRID = 92;
    public static final int KEY_OFFROAD = 93;
    public static final int KEY_INFO_MY_SCREEN = 94;
    public static final int KEY_ASSIST = 95;
    public static final int KEY_VOLUME_DOWN = 96;
    public static final int KEY_VOLUME_UP = 97;
    public static final int SDS_ABORT = 0;
    public static final int SDS_ABORT_SILENT = 1;
    public static final int SDS_CONTINUE = 2;
    public static final int SDS_CONTINUE_SILENT = 3;
    private int keyCode;
    private long when;
    private boolean repaintNeeded = false;
    private int sdsAction = 0;
    private int terminalID;
    private boolean ignorePopupRemoval;

    public KeyEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3) {
        super(aTIPEventListener, n);
        this.keyCode = n2;
        this.terminalID = n3;
    }

    public KeyEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3) {
        super(aTIPEventListener, n);
        this.keyCode = n2;
        this.when = l;
        this.terminalID = n3;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public long getWhen() {
        return this.when;
    }

    String type2Text() {
        switch (this.getID()) {
            case 10401: {
                return "KEY_PRESSED";
            }
            case 10402: {
                return "KEY_RELEASED";
            }
            case 10403: {
                return "KEY_TYPED";
            }
            case 10404: {
                return "KEY_MOVED";
            }
        }
        return "<UNKNOWN>";
    }

    String keycode2Text() {
        switch (this.keyCode) {
            case 1: {
                return "KEY_TUN";
            }
            case 2: {
                return "KEY_MED";
            }
            case 3: {
                return "KEY_MAIL";
            }
            case 4: {
                return "KEY_TEL";
            }
            case 5: {
                return "KEY_NAV";
            }
            case 6: {
                return "KEY_TRAFFIC";
            }
            case 7: {
                return "KEY_CAR";
            }
            case 9: {
                return "KEY_SK_NW";
            }
            case 10: {
                return "KEY_SK_SW";
            }
            case 11: {
                return "KEY_SK_NE";
            }
            case 12: {
                return "KEY_SK_SE";
            }
            case 13: {
                return "KEY_PREV";
            }
            case 14: {
                return "KEY_NEXT";
            }
            case 15: {
                return "KEY_BACK";
            }
            case 16: {
                return "INC_VOL_ENTER";
            }
            case 17: {
                return "INC_MENU_ENTER";
            }
            case 18: {
                return "KEY_PTT";
            }
            case 19: {
                return "KEY_MODE";
            }
            case 20: {
                return "INC_ROLLER_LEFT";
            }
            case 21: {
                return "INC_ROLLER_RIGHT";
            }
            case 22: {
                return "JOYSTICK";
            }
            case 23: {
                return "PTT_LONGPRESSED";
            }
            case 28: {
                return "PTT_DOUBLEPRESSED";
            }
            case 29: {
                return "KEY_PTT_OFF";
            }
            case 24: {
                return "KEY_COMBO_REM";
            }
            case 25: {
                return "KEY_COMBO_GEM";
            }
            case 26: {
                return "KEY_COMBO_HMI_EM";
            }
            case 30: {
                return "KEY_MENU";
            }
            case 31: {
                return "KEY_LEFT";
            }
            case 32: {
                return "KEY_RIGHT";
            }
            case 33: {
                return "KEY_MUTE";
            }
            case 34: {
                return "KEY_DRIVE_SELECT";
            }
            case 35: {
                return "KEY_TONE";
            }
            case 36: {
                return "KEY_RC_AC";
            }
            case 37: {
                return "KEY_RC_SK_NW";
            }
            case 38: {
                return "KEY_RC_SK_SW";
            }
            case 39: {
                return "KEY_RC_SK_NE";
            }
            case 40: {
                return "KEY_RC_SK_SE";
            }
            case 41: {
                return "KEY_RC_BACK";
            }
            case 42: {
                return "RC_INC_MENU_ENTER";
            }
            case 43: {
                return "KEY_STATION_1";
            }
            case 44: {
                return "KEY_STATION_2";
            }
            case 45: {
                return "KEY_STATION_3";
            }
            case 46: {
                return "KEY_STATION_4";
            }
            case 47: {
                return "KEY_STATION_5";
            }
            case 48: {
                return "KEY_STATION_6";
            }
            case 79: {
                return "KEY_STATION_7";
            }
            case 80: {
                return "KEY_STATION_8";
            }
            case 49: {
                return "KEY_INFO";
            }
            case 50: {
                return "KEY_JOKER1";
            }
            case 51: {
                return "KEY_JOKER2";
            }
            case 52: {
                return "KEY_INIT";
            }
            case 53: {
                return "KEY_ECALL_1";
            }
            case 54: {
                return "KEY_ECALL_2";
            }
            case 55: {
                return "KEY_AC";
            }
            case 56: {
                return "KEY_UP";
            }
            case 57: {
                return "KEY_DOWN";
            }
            case 58: {
                return "KEY_HOOK";
            }
            case 59: {
                return "KEY_HANGUP";
            }
            case 60: {
                return "KEY_BREAK_DOWN";
            }
            case 61: {
                return "KEY_3TMR";
            }
            case 62: {
                return "KEY_3TMC";
            }
            case 63: {
                return "KEY_3TML";
            }
            case 64: {
                return "KEY_TP_ENCODER_X";
            }
            case 65: {
                return "KEY_TP_ENCODER_Y";
            }
            case 66: {
                return "KEY_DISPLAY";
            }
            case 67: {
                return "KEY_LONGPRESS_ON_OFF";
            }
            case 77: {
                return "KEY_SK_WEST";
            }
            case 78: {
                return "KEY_SK_EAST";
            }
            case 81: {
                return "KEY_JOKER1_LONGPRESS";
            }
            case 82: {
                return "KEY_MAP";
            }
            case 83: {
                return "KEY_SOURCE";
            }
            case 84: {
                return "KEY_OPTION";
            }
            case 86: {
                return "KEY_TP_CENTER";
            }
            case 87: {
                return "KEY_TRAFFIC_PROGRAM";
            }
            case 88: {
                return "KEY_TAB_PREV";
            }
            case 89: {
                return "KEY_TAB_NEXT";
            }
            case 90: {
                return "KEY_FOCUS";
            }
        }
        return "<UNKNOWN>";
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public void setTerminalID(int n) {
        this.terminalID = n;
    }

    public String toString() {
        return new Buffer().append("KeyEvent:[").append(this.getPosted()).append("] type =").append(this.type2Text()).append('(').append(this.getID()).append("), keyCode =").append(this.keycode2Text()).append('(').append(this.keyCode).append("), terminalID =").append(this.terminalID).toString();
    }

    public static boolean isHardKey(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 30: 
            case 35: 
            case 58: 
            case 59: 
            case 82: 
            case 83: 
            case 84: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppChangeHardkey(int n) {
        return n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 35 || n == 34 || n == 35 || n == 36 || n == 55 || n == 30 || n == 82 || n == 84 || n == 83;
    }

    public boolean isRepaintNeeded() {
        return this.repaintNeeded;
    }

    public void consume() {
        super.consume();
        this.repaintNeeded = true;
    }

    public void consume(boolean bl) {
        super.consume();
        if (!this.repaintNeeded) {
            this.repaintNeeded = bl;
        }
    }

    public int getSdsAction() {
        return this.sdsAction;
    }

    public void setSdsAction(int n) {
        this.sdsAction = n;
    }

    public void setIgnorePopupRemoval(boolean bl) {
        this.ignorePopupRemoval = bl;
    }

    public boolean ignorePopupRemoval() {
        return this.ignorePopupRemoval;
    }
}

