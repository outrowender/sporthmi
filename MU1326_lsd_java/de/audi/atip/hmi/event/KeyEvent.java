/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;

public class KeyEvent
extends ATIPEvent {
    public static final int KEYEVENT_FIRST;
    public static final int KEY_PRESSED;
    public static final int KEY_RELEASED;
    public static final int KEY_TURNED;
    public static final int KEY_MOVED;
    public static final int KEY_LONG_PRESSED;
    public static final int KEY_INVALID;
    public static final int KEY_TUN;
    public static final int KEY_MED;
    public static final int KEY_MAIL;
    public static final int KEY_TEL;
    public static final int KEY_NAV;
    public static final int KEY_TRAFFIC;
    public static final int KEY_CAR;
    public static final int KEY_SK_NW;
    public static final int KEY_SK_SW;
    public static final int KEY_SK_NE;
    public static final int KEY_SK_SE;
    public static final int KEY_PREV;
    public static final int KEY_NEXT;
    public static final int KEY_BACK;
    public static final int INC_VOL_ENTER;
    public static final int INC_MENU_ENTER;
    public static final int KEY_PTT;
    public static final int KEY_MODE;
    public static final int INC_ROLLER_LEFT;
    public static final int INC_ROLLER_RIGHT;
    public static final int KEY_JOYSTICK;
    public static final int KEY_PTT_LONGPRESSED;
    public static final int KEY_COMBO_REM;
    public static final int KEY_COMBO_GEM;
    public static final int KEY_COMBO_HMI_EM;
    public static final int KEY_PTT_DOUBLEPRESSED;
    public static final int KEY_PTT_OFF;
    public static final int KEY_MENU;
    public static final int KEY_LEFT;
    public static final int KEY_RIGHT;
    public static final int KEY_MUTE;
    public static final int KEY_DRIVE_SELECT;
    public static final int KEY_TONE;
    public static final int KEY_RC_AC;
    public static final int KEY_RC_SK_NW;
    public static final int KEY_RC_SK_SW;
    public static final int KEY_RC_SK_NE;
    public static final int KEY_RC_SK_SE;
    public static final int KEY_RC_BACK;
    public static final int RC_INC_MENU_ENTER;
    public static final int KEY_STATION_1;
    public static final int KEY_STATION_2;
    public static final int KEY_STATION_3;
    public static final int KEY_STATION_4;
    public static final int KEY_STATION_5;
    public static final int KEY_STATION_6;
    public static final int KEY_INFO;
    public static final int KEY_JOKER1;
    public static final int KEY_JOKER2;
    public static final int KEY_INIT;
    public static final int KEY_ECALL_1;
    public static final int KEY_ECALL_2;
    public static final int KEY_AC;
    public static final int KEY_UP;
    public static final int KEY_DOWN;
    public static final int KEY_HOOK;
    public static final int KEY_HANGUP;
    public static final int KEY_BREAK_DOWN;
    public static final int KEY_3TMR;
    public static final int KEY_3TMC;
    public static final int KEY_3TML;
    public static final int KEY_TP_ENCODER_X;
    public static final int KEY_TP_ENCODER_Y;
    public static final int KEY_DISPLAY;
    public static final int KEY_LONGPRESS_ON_OFF;
    public static final int KEY_JOYSTICK_NW;
    public static final int KEY_JOYSTICK_N;
    public static final int KEY_JOYSTICK_NE;
    public static final int KEY_JOYSTICK_E;
    public static final int KEY_JOYSTICK_SE;
    public static final int KEY_JOYSTICK_S;
    public static final int KEY_JOYSTICK_SW;
    public static final int KEY_JOYSTICK_W;
    public static final int KEY_JOYSTICK_IDLE;
    public static final int KEY_SK_WEST;
    public static final int KEY_SK_EAST;
    public static final int KEY_STATION_7;
    public static final int KEY_STATION_8;
    public static final int KEY_JOKER1_LONGPRESS;
    public static final int KEY_MAP;
    public static final int KEY_SOURCE;
    public static final int KEY_OPTION;
    public static final int KEY_HOR;
    public static final int KEY_TP_CENTER;
    public static final int KEY_TRAFFIC_PROGRAM;
    public static final int KEY_TAB_PREV;
    public static final int KEY_TAB_NEXT;
    public static final int KEY_FOCUS;
    public static final int KEY_SEAT;
    public static final int KEY_HYBRID;
    public static final int KEY_OFFROAD;
    public static final int KEY_INFO_MY_SCREEN;
    public static final int KEY_ASSIST;
    public static final int KEY_VOLUME_DOWN;
    public static final int KEY_VOLUME_UP;
    public static final int SDS_ABORT;
    public static final int SDS_ABORT_SILENT;
    public static final int SDS_CONTINUE;
    public static final int SDS_CONTINUE_SILENT;
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

    @Override
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

