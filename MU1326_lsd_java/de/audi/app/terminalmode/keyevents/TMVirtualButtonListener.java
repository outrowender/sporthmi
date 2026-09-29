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
    private static final String LOGCLASS;
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

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"TMVirtualButtonListener");
        if (this.configuration.hasTwoVirtualButtonModels()) {
            this.hmiService.getVirtualButtonModel(651440128).setVirtualButtonListener(this);
        }
        this.hmiService.getVirtualButtonModel(634662912).setVirtualButtonListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"TMVirtualButtonListener");
        if (this.configuration.hasTwoVirtualButtonModels()) {
            this.hmiService.getVirtualButtonModel(651440128).setVirtualButtonListener(null);
        }
        this.hmiService.getVirtualButtonModel(634662912).setVirtualButtonListener(null);
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.decrement] %3 %2", (Object)"TMVirtualButtonListener", (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        this.keyEventListener.updateRotary(n2 * this.decrementMultiplier);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.increment] %3 %2", (Object)"TMVirtualButtonListener", (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        this.keyEventListener.updateRotary(n2 * this.incrementMultiplier);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        Key key;
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.keyPressed] %3 %2", (Object)"TMVirtualButtonListener", (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        if (null != (key = this.getKey(n2))) {
            this.keyEventListener.updateKey(key, KeyState.PRESSED);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        Key key;
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.keyReleased] %3 %2", (Object)"TMVirtualButtonListener", (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
        if (null != (key = this.getKey(n2))) {
            this.keyEventListener.updateKey(key, KeyState.RELEASED);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.keyTyped] %3 %2", (Object)"TMVirtualButtonListener", (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.keyLongTyped] %3 %2", (Object)"TMVirtualButtonListener", (Object)String.valueOf(n2), (Object)String.valueOf(n));
        }
    }

    @Override
    public void stickN(int n, int n2) {
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickN]", (Object)"TMVirtualButtonListener");
        }
        this.keyEventListener.updateKey(Key.JS_NORTH, KeyState.PRESSED);
    }

    @Override
    public void stickNW(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickNW]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void stickW(int n, int n2) {
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickW]", (Object)"TMVirtualButtonListener");
        }
        this.keyEventListener.updateKey(Key.JS_WEST, KeyState.PRESSED);
    }

    @Override
    public void stickSW(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickSW]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void stickS(int n, int n2) {
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickS]", (Object)"TMVirtualButtonListener");
        }
        this.keyEventListener.updateKey(Key.JS_SOUTH, KeyState.PRESSED);
    }

    @Override
    public void stickSE(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickSE]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void stickE(int n, int n2) {
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickE]", (Object)"TMVirtualButtonListener");
        }
        this.keyEventListener.updateKey(Key.JS_EAST, KeyState.PRESSED);
    }

    @Override
    public void stickNE(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickNE]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void stickIdle(int n, int n2) {
        if (634662912 == n && this.configuration.hasTwoVirtualButtonModels()) {
            return;
        }
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.stickIdle]", (Object)"TMVirtualButtonListener");
        }
        this.keyEventListener.updateKey(Key.JS_MIDDLE, KeyState.PRESSED);
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchPadPositionMoved]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchPadReleased(int n, int n2, int n3) {
    }

    @Override
    public void touchPadPressed(int n, int n2, int n3) {
    }

    @Override
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5, int n6) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenMoved]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchScreenPressed(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenPressed]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchScreenLongPressed(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenLongPressed]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchScreenReleased(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenReleased]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenDoubleClick]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3, int n4) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenPinch]", (Object)"TMVirtualButtonListener");
        }
    }

    @Override
    public void touchScreenRotate(int n, short s, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.touchScreenRotate]", (Object)"TMVirtualButtonListener");
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

