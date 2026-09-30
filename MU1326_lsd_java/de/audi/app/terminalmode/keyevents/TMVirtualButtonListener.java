/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.keyevents.ITerminalModeDSIKeyEventsController;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.keyevents.KeyState;
import de.audi.app.terminalmode.keyevents.NullTerminalModeDSIKeyEventsController;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.log.LogChannel;

public class TMVirtualButtonListener
implements VirtualButtonListener,
ITerminalModeComponent {
    private static final String LOGCLASS = "TMVirtualButtonListener";
    protected final LogChannel logger;
    private final IHMIServiceApp hmiService;
    private final NullTerminalModeDSIKeyEventsController nullKeyEventListener;
    protected volatile ITerminalModeDSIKeyEventsController keyEventListener;
    private final int decrementMultiplier;
    private final int incrementMultiplier;
    protected final ITerminalModeConfiguration configuration;

    public TMVirtualButtonListener(ITerminalLogger iTerminalLogger, ITerminalModeConfiguration iTerminalModeConfiguration, IHMIServiceApp iHMIServiceApp) {
        this.logger = iTerminalLogger.hmi();
        this.configuration = iTerminalModeConfiguration;
        this.hmiService = iHMIServiceApp;
        this.nullKeyEventListener = new NullTerminalModeDSIKeyEventsController(iTerminalLogger.hmi());
        this.keyEventListener = this.nullKeyEventListener;
        this.decrementMultiplier = this.configuration.isKnobDirectionInverted() ? -1 : 1;
        this.incrementMultiplier = this.configuration.isKnobDirectionInverted() ? 1 : -1;
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        if (this.configuration.hasTwoVirtualButtonModels()) {
            this.hmiService.getVirtualButtonModel(3200038).setVirtualButtonListener(this);
        }
        this.hmiService.getVirtualButtonModel(3200037).setVirtualButtonListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        if (this.configuration.hasTwoVirtualButtonModels()) {
            this.hmiService.getVirtualButtonModel(3200038).setVirtualButtonListener(null);
        }
        this.hmiService.getVirtualButtonModel(3200037).setVirtualButtonListener(null);
    }

    public void decrement(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.decrement] %3 %2", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        this.keyEventListener.updateRotary(n2 * this.decrementMultiplier);
    }

    public void increment(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.increment] %3 %2", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        this.keyEventListener.updateRotary(n2 * this.incrementMultiplier);
    }

    public void keyPressed(int n, int n2, int n3) {
        Key key;
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.keyPressed] %3 %2", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        if (null != (key = this.getKey(n2))) {
            this.keyEventListener.updateKey(key, KeyState.PRESSED);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        Key key;
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.keyReleased] %3 %2", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        if (null != (key = this.getKey(n2))) {
            this.keyEventListener.updateKey(key, KeyState.RELEASED);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.keyTyped] %3 %2", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.keyLongTyped] %3 %2", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
    }

    public void stickN(int n, int n2) {
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickN]", (Object)LOGCLASS);
        }
        this.keyEventListener.updateKey(Key.JS_NORTH, KeyState.PRESSED);
    }

    public void stickNW(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickNW]", (Object)LOGCLASS);
        }
    }

    public void stickW(int n, int n2) {
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickW]", (Object)LOGCLASS);
        }
        this.keyEventListener.updateKey(Key.JS_WEST, KeyState.PRESSED);
    }

    public void stickSW(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickSW]", (Object)LOGCLASS);
        }
    }

    public void stickS(int n, int n2) {
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickS]", (Object)LOGCLASS);
        }
        this.keyEventListener.updateKey(Key.JS_SOUTH, KeyState.PRESSED);
    }

    public void stickSE(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickSE]", (Object)LOGCLASS);
        }
    }

    public void stickE(int n, int n2) {
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickE]", (Object)LOGCLASS);
        }
        this.keyEventListener.updateKey(Key.JS_EAST, KeyState.PRESSED);
    }

    public void stickNE(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickNE]", (Object)LOGCLASS);
        }
    }

    public void stickIdle(int n, int n2) {
        if (3200037 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.stickIdle]", (Object)LOGCLASS);
        }
        this.keyEventListener.updateKey(Key.JS_MIDDLE, KeyState.PRESSED);
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchPadPositionMoved]", (Object)LOGCLASS);
        }
    }

    public void touchPadReleased(int n, int n2, int n3) {
    }

    public void touchPadPressed(int n, int n2, int n3) {
    }

    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenMoved]", (Object)LOGCLASS);
        }
    }

    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenPressed]", (Object)LOGCLASS);
        }
    }

    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenLongPressed]", (Object)LOGCLASS);
        }
    }

    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenReleased]", (Object)LOGCLASS);
        }
    }

    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenDoubleClick]", (Object)LOGCLASS);
        }
    }

    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenPinch]", (Object)LOGCLASS);
        }
    }

    public void touchScreenRotate(int n, short s, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.touchScreenRotate]", (Object)LOGCLASS);
        }
    }

    private Key getKey(int n) {
        switch (n) {
            case 17: {
                return Key.DDS_SELECT;
            }
            case 15: {
                return Key.BACK;
            }
            case 9: {
                return Key.SOFTKEY_WEST;
            }
            case 11: {
                return Key.SOFTKEY_EAST;
            }
            case 10: {
                return Key.SOFTKEY_SOUTHWEST;
            }
            case 12: {
                return Key.SOFTKEY_SOUTHEAST;
            }
        }
        return null;
    }

    public void setDSIKeyEventController(ITerminalModeDSIKeyEventsController iTerminalModeDSIKeyEventsController) {
        this.keyEventListener = iTerminalModeDSIKeyEventsController;
    }
}

