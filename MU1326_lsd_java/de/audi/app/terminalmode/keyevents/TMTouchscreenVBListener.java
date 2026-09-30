/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.keyevents.TMVirtualButtonListener;
import de.audi.app.terminalmode.keyevents.TouchEvent;
import de.audi.atip.hmi.IHMIServiceApp;

public class TMTouchscreenVBListener
extends TMVirtualButtonListener {
    private static final String LOGCLASS = "TMTouchscreenVBListener";
    private volatile TouchEvent firstFinger;
    private volatile TouchEvent lastPinchEvent;

    public TMTouchscreenVBListener(ITerminalLogger iTerminalLogger, ITerminalModeConfiguration iTerminalModeConfiguration, IHMIServiceApp iHMIServiceApp) {
        super(iTerminalLogger, iTerminalModeConfiguration, iHMIServiceApp);
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchPadPositionMoved]", (Object)LOGCLASS);
        }
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n2, n3, n4, n5, false)};
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchPadPressed(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchPadPressed]", (Object)LOGCLASS);
        }
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(true, n, n2, false)};
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchPadReleased(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchPadReleased]", (Object)LOGCLASS);
        }
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(false, n, n2, false)};
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenMoved] %2 %3", (Object)LOGCLASS, (Object)Integer.toString(n4), (Object)Integer.toString(n5));
        }
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n2, n3, n4, n5, true)};
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenPressed] %2 %3", (Object)LOGCLASS, (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        }
        this.firstFinger = new TouchEvent(true, n2, n3, true);
        TouchEvent[] touchEventArray = new TouchEvent[]{this.firstFinger};
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenLongPressed]", (Object)LOGCLASS);
        }
    }

    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        TouchEvent[] touchEventArray;
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenReleased] %2 %3", (Object)LOGCLASS, (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        }
        if (null == this.lastPinchEvent) {
            touchEventArray = new TouchEvent[]{new TouchEvent(false, n2, n3, true)};
        } else {
            touchEventArray = this.lastPinchEvent.getCurrentX() == n2 && this.lastPinchEvent.getCurrentY() == n3 ? new TouchEvent[]{new TouchEvent(false, this.firstFinger.getCurrentX(), this.firstFinger.getCurrentY(), true), new TouchEvent(false, this.lastPinchEvent.getCurrentX(), this.lastPinchEvent.getCurrentY(), true)} : new TouchEvent[]{new TouchEvent(false, n2, n3, true), new TouchEvent(false, this.lastPinchEvent.getCurrentX(), this.lastPinchEvent.getCurrentY(), true)};
            this.lastPinchEvent = null;
            this.firstFinger = null;
        }
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenDoubleClick]", (Object)LOGCLASS);
        }
    }

    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenPinch] %2 %3 %4", (Object)LOGCLASS, (Object)Float.toString(f2), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        }
        if (null == this.firstFinger) {
            return;
        }
        TouchEvent touchEvent = null == this.lastPinchEvent ? new TouchEvent(true, n2, n3, true) : new TouchEvent(this.lastPinchEvent.getCurrentX(), this.lastPinchEvent.getCurrentY(), n2, n3, true);
        TouchEvent[] touchEventArray = new TouchEvent[]{this.firstFinger, touchEvent};
        this.lastPinchEvent = touchEvent;
        this.keyEventListener.updateTouchEvents(touchEventArray);
    }

    public void touchScreenRotate(int n, short s, int n2) {
        if (!this.configuration.hasTouchscreen()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenRotate] %2", (Object)LOGCLASS, (long)s);
        }
    }
}

