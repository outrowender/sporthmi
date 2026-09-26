/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class TouchEvent
extends ATIPEvent {
    public static final int TOUCH_EVENT_FIRST;
    public static final int TOUCH_PAD_PRESSED;
    public static final int TOUCH_PAD_RELEASED;
    public static final int TOUCH_PAD_TAPPED;
    public static final int TOUCH_PAD_DOUBLETAPPED;
    public static final int TOUCH_PAD_CHARS_RECOGNIZED;
    public static final int TOUCH_PAD_APPROACHED;
    public static final int TOUCH_PAD_ABANDONED;
    public static final int TOUCH_PAD_MOVED_ABS;
    public static final int TOUCH_PAD_MOVED_REL;
    public static final int TOUCH_PAD_SCROLL;
    public static final int TOUCH_PAD_PALM;
    public static final int TOUCH_SCREEN_LAST;
    private long when;
    private int touchCode;
    private int x;
    private int y;
    private int fingerCount;
    private String recognizedCharacters;
    private int[] recognizerConfidence;
    private boolean palmRecognized = false;
    private boolean repaintNeeded = false;
    private int angle;
    private int distance;
    private int deltaTime;
    private int sdsAction = 0;

    public TouchEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3, int n4) {
        super(aTIPEventListener, n);
        this.touchCode = n2;
        this.x = n3;
        this.y = n4;
    }

    public TouchEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5) {
        super(aTIPEventListener, n);
        this.when = l;
        this.touchCode = n2;
        this.x = n3;
        this.y = n4;
        this.fingerCount = n5;
    }

    public TouchEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, String string, int[] nArray) {
        super(aTIPEventListener, n);
        this.when = l;
        this.touchCode = n2;
        this.x = n3;
        this.y = n4;
        this.recognizedCharacters = string;
        this.recognizerConfidence = nArray;
    }

    public TouchEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        super(aTIPEventListener, n);
        this.when = l;
        this.touchCode = n2;
        this.x = n3;
        this.y = n4;
        this.fingerCount = n5;
        this.distance = n6;
        this.angle = n7;
        this.deltaTime = n8;
    }

    public TouchEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5, boolean bl, int n6, int n7, int n8) {
        this(aTIPEventListener, n, l, n2, n3, n4, n5, n6, n7, n8);
        this.palmRecognized = bl;
    }

    public int getCode() {
        return this.touchCode;
    }

    public long getWhen() {
        return this.when;
    }

    public String getRecognizedCharacters() {
        return this.recognizedCharacters;
    }

    public int[] getCharacterConfidence() {
        return this.recognizerConfidence;
    }

    public String toString() {
        if (this.recognizedCharacters == null) {
            Buffer buffer = new Buffer().append("TouchScreenEvent: type=").append(this.type2Text()).append(", touchCode=").append(this.touchCode2Text()).append(", finger=").append(this.fingerCount).append(", deltaTime=").append(this.deltaTime).append(", x=").append(this.x).append(", y=").append(this.y);
            return buffer.toString();
        }
        return new StringBuffer().append("TouchScreenEvent: type = ").append(this.type2Text()).append(", recognizedCharacters = ").append(this.recognizedCharacters).append(", recognizerConfidence = ").append(Util.arrayToString(this.recognizerConfidence)).toString();
    }

    private String touchCode2Text() {
        switch (this.touchCode) {
            case 0: {
                return "INVALID";
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
            case 85: {
                return "KEY_HOR";
            }
            case 86: {
                return "KEY_TP_CENTER";
            }
        }
        return String.valueOf(this.touchCode);
    }

    private String type2Text() {
        switch (this.getID()) {
            case 10904: {
                return "TOUCH_PAD_PRESSED";
            }
            case 10905: {
                return "TOUCH_PAD_RELEASED";
            }
            case 10906: {
                return "TOUCH_PAD_TAPPED";
            }
            case 10907: {
                return "TOUCH_PAD_DOUBLETAPPED";
            }
            case 10909: {
                return "TOUCH_PAD_APPROACHED";
            }
            case 10910: {
                return "TOUCH_PAD_ABANDONED";
            }
            case 10908: {
                return "TOUCH_PAD_CHARS_RECOGNIZED";
            }
            case 10911: {
                return "TOUCH_PAD_MOVED_ABS";
            }
            case 10912: {
                return "TOUCH_PAD_MOVED_REL";
            }
            case 10913: {
                return "TOUCH_PAD_SCROLL";
            }
            case 10914: {
                return "TOUCH_PAD_PALM";
            }
        }
        return String.valueOf(this.getID());
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getFingerCount() {
        return this.fingerCount;
    }

    public boolean isPalm() {
        return this.palmRecognized;
    }

    public boolean isRepaintNeeded() {
        return this.repaintNeeded;
    }

    public int getAngle() {
        return this.angle;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getDeltaTime() {
        return this.deltaTime;
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
}

