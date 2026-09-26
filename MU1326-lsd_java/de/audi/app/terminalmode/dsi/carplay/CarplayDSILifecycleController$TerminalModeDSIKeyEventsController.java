/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$1;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$TerminalModeDSIKeyEventsController$1;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.dsi.ifc.carplay.TouchEvent;

class CarplayDSILifecycleController$TerminalModeDSIKeyEventsController
implements ITerminalModeDSIKeyEventsController {
    private static final String LOGCLASS;
    private final /* synthetic */ CarplayDSILifecycleController this$0;

    private CarplayDSILifecycleController$TerminalModeDSIKeyEventsController(CarplayDSILifecycleController carplayDSILifecycleController) {
        this.this$0 = carplayDSILifecycleController;
    }

    @Override
    public void updateKey(Key key, KeyState keyState) {
        if (TerminalModeUtils.isJoystickMiddleposition((Key)key)) {
            if (null == CarplayDSILifecycleController.access$2900(this.this$0)) {
                return;
            }
            CarplayDSILifecycleController.access$3000(this.this$0).log(1078071040, "[%1.updateKey] joystick middle position, release button %2", (Object)"TerminalModeDSIKeyEventsController", (Object)CarplayDSILifecycleController.access$2900(this.this$0));
            CarplayDSILifecycleController.access$300(this.this$0).postButtonEvent(this.getKeyId(CarplayDSILifecycleController.access$2900(this.this$0)), 1);
            CarplayDSILifecycleController.access$2902(this.this$0, null);
            return;
        }
        int n = this.getKeyId(key);
        if (0 == n) {
            CarplayDSILifecycleController.access$3100(this.this$0).log(1078071040, "[%1.updateKey] unknown key id", (Object)"TerminalModeDSIKeyEventsController");
            return;
        }
        int n2 = this.getKeyState(keyState);
        CarplayDSILifecycleController.access$3200(this.this$0).log(1078071040, "[%1.updateKey] %2 %3", (Object)"TerminalModeDSIKeyEventsController", (Object)String.valueOf(n), (long)n2);
        if (TerminalModeUtils.isJoystick((Key)key)) {
            CarplayDSILifecycleController.access$2902(this.this$0, key);
        }
        CarplayDSILifecycleController.access$300(this.this$0).postButtonEvent(n, n2);
    }

    public void updateTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        Object[] objectArray;
        CarplayDSILifecycleController.access$3300(this.this$0).log(1078071040, "[%1.updateTouchEvent] c=%2 x=%3 y=%4", (Object)"TerminalModeDSIKeyEventsController", (Object)String.valueOf(n2), (Object)String.valueOf(n4), (Object)String.valueOf(n5));
        TouchEvent[] touchEventArray = new TouchEvent[n2];
        if (n2 >= 1) {
            touchEventArray[0] = new TouchEvent(n4, n5);
        }
        if (n2 >= 2) {
            objectArray = this.calcSecondCorr(n4, n5, n6, n7);
            touchEventArray[1] = new TouchEvent(objectArray[0], objectArray[1]);
        }
        if (null != CarplayDSILifecycleController.access$3400(this.this$0) && CarplayDSILifecycleController.access$3400(this.this$0).length > touchEventArray.length) {
            objectArray = new TouchEvent[CarplayDSILifecycleController.access$3400(this.this$0).length];
            for (int i2 = 0; i2 < CarplayDSILifecycleController.access$3400(this.this$0).length; ++i2) {
                objectArray[i2] = i2 < touchEventArray.length - 1 ? (int)touchEventArray[i2] : (int)CarplayDSILifecycleController.access$3400(this.this$0)[i2];
            }
        } else {
            objectArray = touchEventArray;
        }
        if (CarplayDSILifecycleController.access$3500(this.this$0).isDebug()) {
            if (n2 == 1) {
                CarplayDSILifecycleController.access$3600(this.this$0).log(1078071040, "[%1.updateTouchEvent] %2/%3", (Object)"TerminalModeDSIKeyEventsController", (long)objectArray[0].getX(), (long)objectArray[0].getY());
            } else if (n2 >= 2) {
                Buffer buffer = new Buffer(50);
                buffer.append(objectArray[0].getX());
                buffer.append('/');
                buffer.append(objectArray[0].getY());
                buffer.append(' ');
                buffer.append(objectArray[1].getX());
                buffer.append('/');
                buffer.append(objectArray[1].getY());
                CarplayDSILifecycleController.access$3700(this.this$0).log(1078071040, "[%1.updateTouchEvent] %2", (Object)"TerminalModeDSIKeyEventsController", (Object)buffer.toString());
            }
        }
        if (0 != n2) {
            CarplayDSILifecycleController.access$3402(this.this$0, (TouchEvent[])objectArray);
        } else {
            CarplayDSILifecycleController.access$3402(this.this$0, null);
        }
        CarplayDSILifecycleController.access$300(this.this$0).postTouchEvent(this.getDSITouchInputId(n), n2, (TouchEvent[])objectArray);
    }

    @Override
    public void updateTouchEvents(de.audi.app.terminalmode.keyevents.TouchEvent[] touchEventArray) {
        CarplayDSILifecycleController.access$3800(this.this$0).log(1078071040, "[%1.updateTouchEvent] c=%2 %3", (Object)"TerminalModeDSIKeyEventsController", (Object)Integer.toString(touchEventArray.length), (Object)touchEventArray[0]);
        int n = 0;
        ArrayList arrayList = new ArrayList(touchEventArray.length);
        for (int i2 = 0; i2 < touchEventArray.length; ++i2) {
            if (touchEventArray[i2].isTouchScreen()) {
                arrayList.add(new TouchEvent(touchEventArray[i2].getCurrentX() - CarplayDSILifecycleController.access$600(this.this$0).getScreenOffsetX(), touchEventArray[i2].getCurrentY() - CarplayDSILifecycleController.access$600(this.this$0).getScreenOffsetY()));
            } else {
                arrayList.add(new TouchEvent(touchEventArray[i2].getCurrentX(), touchEventArray[i2].getCurrentY()));
            }
            if (touchEventArray[i2].getTouchState() == 1) continue;
            ++n;
        }
        Collections.sort(arrayList, new CarplayDSILifecycleController$TerminalModeDSIKeyEventsController$1(this));
        if (CarplayDSILifecycleController.access$3900(this.this$0).isDebug()) {
            Buffer buffer = new Buffer(50);
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                TouchEvent touchEvent = (TouchEvent)iterator.next();
                buffer.append(touchEvent.getX());
                buffer.append('/');
                buffer.append(touchEvent.getY());
                buffer.append(' ');
            }
            buffer.append('/');
            buffer.append(n);
            CarplayDSILifecycleController.access$4000(this.this$0).log(1078071040, "[%1.updateTouchEvent] %2", (Object)"TerminalModeDSIKeyEventsController", (Object)buffer.toString());
        }
        CarplayDSILifecycleController.access$300(this.this$0).postTouchEvent(touchEventArray[0].isTouchScreen() ? 1 : 0, n, (TouchEvent[])arrayList.toArray(new TouchEvent[arrayList.size()]));
    }

    @Override
    public void updateRotary(int n) {
        CarplayDSILifecycleController.access$4100(this.this$0).log(1078071040, "[%1.updateRotary] %2", (Object)"TerminalModeDSIKeyEventsController", (long)n);
        CarplayDSILifecycleController.access$300(this.this$0).postRotaryEvent(n);
    }

    private int getKeyState(KeyState keyState) {
        if (keyState.is(KeyState.PRESSED)) {
            return 0;
        }
        if (keyState.is(KeyState.RELEASED)) {
            return 1;
        }
        CarplayDSILifecycleController.access$4200(this.this$0).log(1078071040, "[%1.getKeyState] Unsupported key state %2", (Object)"TerminalModeDSIKeyEventsController", (Object)keyState);
        return -1;
    }

    private int getKeyId(Key key) {
        if (Key.BACK.is(key)) {
            return 3;
        }
        if (Key.DDS_SELECT.is(key)) {
            return 1;
        }
        if (key.isOneOf(Key.JS_NORTH, Key.SOFTKEY_SOUTHWEST)) {
            return 7;
        }
        if (key.isOneOf(Key.JS_EAST, Key.SOFTKEY_NORTHEAST)) {
            return 6;
        }
        if (key.isOneOf(Key.JS_SOUTH, Key.SOFTKEY_SOUTHEAST)) {
            return 8;
        }
        if (key.isOneOf(Key.JS_WEST, Key.SOFTKEY_NORTHWEST)) {
            return 5;
        }
        if (key.is(Key.SOFTKEY_EAST)) {
            return 17;
        }
        if (key.is(Key.SOFTKEY_WEST)) {
            return 16;
        }
        CarplayDSILifecycleController.access$4300(this.this$0).log(1078071040, "[%1.getKeyId] Unsupport %2", (Object)"TerminalModeDSIKeyEventsController", (Object)key);
        return 0;
    }

    private int getDSITouchInputId(int n) {
        switch (n) {
            case 2: {
                return 1;
            }
        }
        return 0;
    }

    private int[] calcSecondCorr(int n, int n2, int n3, int n4) {
        if (n4 > 100) {
            n4 -= 100;
        }
        int n5 = (int)((double)n + Math.acos(n4 / 100) * (double)n4);
        int n6 = (int)((double)n2 + Math.asin(n4 / 100) * (double)n4);
        return new int[]{n5, n6};
    }

    @Override
    public void updateCharacterEvent(String[] stringArray, int[] nArray) {
        CarplayDSILifecycleController.access$4400(this.this$0).log(1078071040, "[%1.updateCharacterEvent]", (Object)"TerminalModeDSIKeyEventsController");
        CarplayDSILifecycleController.access$300(this.this$0).postCharacterEvent(stringArray.length, stringArray);
    }

    /* synthetic */ CarplayDSILifecycleController$TerminalModeDSIKeyEventsController(CarplayDSILifecycleController carplayDSILifecycleController, CarplayDSILifecycleController$1 carplayDSILifecycleController$1) {
        this(carplayDSILifecycleController);
    }
}

