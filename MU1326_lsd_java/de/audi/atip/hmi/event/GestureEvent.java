/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;

public class GestureEvent
extends ATIPEvent {
    public static final int OFFSET_EVENT_ID = 10901;
    public static final int GESTURE_EVENT_INVALID = 10901;
    public static final int GESTURE_EVENT_PRESS = 10902;
    public static final int GESTURE_EVENT_RELEASE = 10903;
    public static final int GESTURE_EVENT_MOVE = 10904;
    public static final int GESTURE_EVENT_FLICK = 10905;
    public static final int GESTURE_EVENT_TAP = 10906;
    public static final int GESTURE_EVENT_ZOOM = 10907;
    public static final int GESTURE_EVENT_ROTATE = 10908;
    public static final int GESTURE_EVENT_PRESS2 = 10909;
    public static final int GESTURE_EVENT_CHARS_RECOGNIZED = 10910;
    public static final int GESTURE_EVENT_FLICK2 = 10911;
    public static final int GESTURE_EVENT_DRAG2 = 10912;
    public static final int GESTURE_EVENT_LONG_PRESS = 10913;
    public static final int GESTURE_EVENT_UPDATE_TOUCH_AREA = 10914;
    public static final double[] PGEN2_COORDINATE_SACLING = new double[]{1.40625, 1.0};
    private long timestamp;
    private int code;
    private int x;
    private static double scaleFactorX = 1.0;
    private int y;
    private static double scaleFactorY = 1.0;
    private static boolean doScaling = false;
    private int param1;
    private int param2;
    private String[] recognizedCharacters;
    private int[] recognizerConfidence;
    private boolean beep;
    private boolean managed;
    private int gestureState;

    public GestureEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4) {
        super(aTIPEventListener, n);
        this.timestamp = l;
        this.code = n2;
        this.setCoordinates(n3, n4);
    }

    public GestureEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, int n5, int n6) {
        super(aTIPEventListener, n);
        this.timestamp = l;
        this.code = n2;
        this.param1 = n5;
        this.param2 = n6;
        this.setCoordinates(n3, n4);
    }

    public GestureEvent(ATIPEventListener aTIPEventListener, int n, long l, int n2, int n3, int n4, String[] stringArray, int[] nArray) {
        this(aTIPEventListener, n, l, n2, n3, n4);
        this.recognizedCharacters = stringArray;
        this.recognizerConfidence = nArray;
    }

    private void setCoordinates(int n, int n2) {
        if (doScaling) {
            this.x = (int)((double)n * scaleFactorX);
            this.y = (int)((double)n2 * scaleFactorY);
        } else {
            this.x = n;
            this.y = n2;
        }
    }

    public static void setScaleFactorX(double d2) {
        scaleFactorX = d2;
        doScaling = true;
    }

    public static void setScaleFactorY(double d2) {
        scaleFactorY = d2;
        doScaling = true;
    }

    public boolean isPressEvent() {
        return super.getID() == 10902;
    }

    public boolean isReleaseEvent() {
        return super.getID() == 10903;
    }

    public boolean isFlick2Event() {
        return super.getID() == 10911;
    }

    public boolean isDrag2Event() {
        return super.getID() == 10912;
    }

    public boolean isMoveEvent() {
        return super.getID() == 10904;
    }

    public boolean isFlickEvent() {
        return super.getID() == 10905;
    }

    public boolean isTapEvent() {
        return super.getID() == 10906;
    }

    public boolean isZoomEvent() {
        return super.getID() == 10907;
    }

    public boolean isRotateEvent() {
        return super.getID() == 10908;
    }

    public boolean isPress2Event() {
        return super.getID() == 10909;
    }

    public boolean isCharRecognizedEvent() {
        return super.getID() == 10910;
    }

    public boolean isLongPressEvent() {
        return super.getID() == 10913;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getCode() {
        return this.code;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String[] getRecognizedCharacters() {
        return this.recognizedCharacters;
    }

    public int[] getCharacterConfidence() {
        return this.recognizerConfidence;
    }

    public void setBeep(boolean bl) {
        this.beep = bl;
    }

    public boolean isBeep() {
        return this.beep;
    }

    public boolean isManaged() {
        return this.managed;
    }

    public void setManaged() {
        this.managed = true;
    }

    public int getGestureState() {
        return this.gestureState;
    }

    public void setGestureState(int n) {
        this.gestureState = n;
    }

    public int getClickCount() {
        return this.param1;
    }

    public int getFingerDistance() {
        return this.param1;
    }

    public short getRotationAngle() {
        return (short)this.param1;
    }

    public byte getXDelta() {
        return (byte)this.param1;
    }

    public byte getYDelta() {
        return (byte)this.param2;
    }

    public int getWidth() {
        return this.param1;
    }

    public int getHeight() {
        return this.param2;
    }

    public static String typeIdToText(int n) {
        switch (n) {
            case 10902: {
                return "GESTURE_EVENT_PRESS";
            }
            case 10909: {
                return "GESTURE_EVENT_PRESS2";
            }
            case 10903: {
                return "GESTURE_EVENT_RELEASE";
            }
            case 10904: {
                return "GESTURE_EVENT_MOVE";
            }
            case 10905: {
                return "GESTURE_EVENT_FLICK";
            }
            case 10910: {
                return "GESTURE_EVENT_CHARS_RECOGNIZED";
            }
            case 10908: {
                return "GESTURE_EVENT_ROTATE";
            }
            case 10906: {
                return "GESTURE_EVENT_TAP";
            }
            case 10907: {
                return "GESTURE_EVENT_ZOOM";
            }
            case 10911: {
                return "GESTURE_EVENT_FLICK2";
            }
            case 10912: {
                return "GESTURE_EVENT_DRAG2";
            }
            case 10913: {
                return "GESTURE_EVENT_LONG_PRESS";
            }
            case 10914: {
                return "GESTURE_EVENT_UPDATE_TOUCH_AREA";
            }
        }
        return "Invalid type id: " + n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("GestureEvent:[receiver: ").append(this.getReceiver()).append(", id: ").append(this.getID()).append(", timestamp: ").append(this.timestamp).append(", code: ").append(this.code).append(", type: ").append(GestureEvent.typeIdToText(this.getID())).append(", managed: ").append(this.managed).append(", coordinates: (").append(this.x).append(",").append(this.y).append(")").append(", param1: ").append(this.param1).append(", param2: ").append(this.param2).append(", rotationAngle: ").append(this.getRotationAngle()).append(", getXDelta(): ").append(this.getXDelta()).append(", getYDelta(): ").append(this.getYDelta()).append("]");
        return buffer.toString();
    }
}

