/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.widgets;

import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.BrowserModel;
import de.audi.atip.hmi.modelaccess.BrowserModelGUI;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.ITouchScreenEventListener;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButtonTouchHandler;

public class VirtualButton
extends AbstractWidgetController
implements ITouchScreenEventListener {
    public static final int PROCESS_EVENT_INC_MENU_ENTER = 1;
    public static final int PROCESS_EVENT_KEY_BACK = 2;
    public static final int PROCESS_EVENT_TURN = 4;
    public static final int PROCESS_EVENT_JOYSTICK = 8;
    public static final int PROCESS_EVENT_TOUCH_PAD = 16;
    public static final int PROCESS_EVENT_TOUCH_PAD_MOVED = 32;
    public static final int PROCESS_EVENT_TOUCH_PAD_RELEASED = 64;
    public static final int PROCESS_EVENT_SK_NW = 64;
    public static final int PROCESS_EVENT_SK_NE = 128;
    public static final int PROCESS_EVENT_SK_SE = 256;
    public static final int PROCESS_EVENT_SK_SW = 512;
    public static final int PROCESS_EVENT_KEY_MENU = 1024;
    private int eventConfiguration = 0;
    private boolean invertJoystickEvents = false;
    private boolean[] blockedJoystickDirections = new boolean[]{true, true, true, true, true, true, true, true, true};
    private boolean rotationalDirectionClockWise = true;
    private boolean consumeEvents = true;
    private int sdsItemSelectedAction = 0;
    private VirtualButtonTouchHandler touchEventHandler = new VirtualButtonTouchHandler(this);
    private boolean isTouchScreenSupported = false;
    private int sdsCommand = -1;
    private boolean handleKeyTurnAsKeyPress = false;
    private boolean enableFastIncrement = false;
    private boolean mflRollerUpIncrementsModel = true;
    private static final int ACCUMULATION_TIME = 100;
    private int eventAccumulation = 0;
    private long lastEventTime = 0L;
    private boolean fireEventKeyTurnedForward = true;
    private boolean fireEventKeyTurnedBackward = true;
    private int currentTouchPositionX;
    private int currentTouchPositionY;
    private int currentFingerDistance;
    private int currentTouchPadX;
    private int currentTouchPadY;

    public VirtualButton() {
    }

    protected void initializeWidget() {
        if (this.doProcessTouchEvents() && this.terminal != null && this.terminal.getTouchInputManager() != null) {
            this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, 25);
        }
    }

    private boolean doProcessTouchEvents() {
        return this.doProcessEventSource(16) || this.doProcessEventSource(32) || this.doProcessEventSource(64);
    }

    public void setJoystickDirectionBlocked(boolean[] blArray) {
        if (blArray.length == 9) {
            this.blockedJoystickDirections = blArray;
        } else {
            logChannelEvent.log(10000, "VirtualButton#setJoystickDirectionBlocked : received incorrect BlockedJoystickDirections array length (= %1) , array should have length = 9 .", (long)blArray.length);
        }
    }

    private boolean isJoystickDirectionBlocked(int n) {
        if (n < this.blockedJoystickDirections.length) {
            return this.blockedJoystickDirections[n];
        }
        return false;
    }

    public VirtualButton(int n, int n2, int n3, int n4) {
        this();
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
        this.touchEventHandler = new VirtualButtonTouchHandler(this);
    }

    public void keyPressed(KeyEvent keyEvent) {
        logChannelEvent.log(10000000, "VirtualButton#keyPressed event = %1", (Object)keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        int n = keyEvent.getKeyCode();
        int n2 = this.terminal.getTerminalID();
        this.callSdsServiceOnKeyPress(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        if (this.model instanceof ButtonModelGUI) {
            if (this.doProcessEvent(n)) {
                logChannel.log(10000000, "VirtualButton#keyPressed ButtonModelGUI connected passing pressed event to model");
                ButtonModelGUI buttonModelGUI = (ButtonModelGUI)this.model;
                buttonModelGUI.keyPressed(n, n2);
                buttonModelGUI.keyTyped(n, n2);
                this.maybeConsumeEvent(keyEvent);
            } else {
                logChannel.log(10000000, "VirtualButton#keyPressed ButtonModelGUI connected according to configuration pressed event is ignored by this widget");
            }
        } else if (this.model instanceof BrowserModelGUI) {
            if (this.doProcessEvent(n)) {
                ((BrowserModelGUI)this.model).keyTyped(n, n2);
                this.maybeConsumeEvent(keyEvent);
            } else {
                logChannel.log(10000000, "VirtualButton#keyPressed VirtualButtonModelGUI connected according to configuration pressed event is ignored by this widget");
            }
        } else if (this.event != 0) {
            if (this.doProcessEvent(n)) {
                this.fireSMEvent(this.terminal.getTerminalID(), this.event);
                this.maybeConsumeEvent(keyEvent);
            } else {
                logChannel.log(10000000, "VirtualButton#keyPressed no model connected but event configured, according to configuration pressed event is ignored by this widget");
            }
        } else {
            logChannel.log(10000000, "VirtualButton#keyPressed ignore event because no SM event configured and no supported model: %1", this.model);
        }
    }

    private void callSdsServiceOnKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 17) {
            return;
        }
        int n = this.getSdsItemSelectedAction();
        if (n == 1) {
            keyEvent.setSdsAction(n);
        } else if (n == 2) {
            if (AbstractWidget.sdsService != null) {
                keyEvent.consume();
                keyEvent.setSdsAction(n);
                logChannel.log(10000000, "VirtualButton#callSdsServiceOnKeyPress: item selected with modelID %1, sdsCommand %2", (long)this.modelID, (long)this.sdsCommand);
                AbstractWidget.sdsService.keyTyped(this.modelID, this.sdsCommand);
            } else {
                logChannel.log(10000, "VirtualButton#callSdsServiceOnKeyPress: sdsService is not present, cannot call itemSelected");
            }
        } else if (n == 3) {
            keyEvent.setSdsAction(n);
        }
    }

    private void maybeConsumeEvent(KeyEvent keyEvent) {
        if (this.consumeEvents) {
            keyEvent.consume(false);
        }
    }

    private void maybeConsumeEvent(JoystickEvent joystickEvent) {
        if (this.consumeEvents) {
            joystickEvent.consume(false);
        }
    }

    private boolean doProcessEvent(int n) {
        return this.hasState(36) && (VirtualButton.isWheelButtonKey(n) && this.doProcessEventSource(1) || n == 15 && this.doProcessEventSource(2) || n == 12 && this.doProcessEventSource(256) || n == 10 && this.doProcessEventSource(512) || n == 11 && this.doProcessEventSource(128) || n == 9 && this.doProcessEventSource(64) || n == 30 && this.doProcessEventSource(1024));
    }

    public void keyReleased(KeyEvent keyEvent) {
        logChannelEvent.log(10000000, "VirtualButton#keyReleased event = %1", (Object)keyEvent);
        if (keyEvent.isConsumed() || this.model == null) {
            return;
        }
        keyEvent.setSdsAction(3);
        int n = keyEvent.getKeyCode();
        int n2 = this.terminal.getTerminalID();
        if (this.model instanceof ButtonModelGUI) {
            if (this.doProcessEvent(n)) {
                ((ButtonModelGUI)this.model).keyReleased(n, n2);
                this.maybeConsumeEvent(keyEvent);
            } else {
                logChannel.log(10000000, "VirtualButton#keyReleased according to configuration released event is ignored by this widget. modelType: %1", (long)((HMIModelGUI)this.model).getModelType());
            }
        } else if (this.model instanceof BrowserModelGUI) {
            if (this.doProcessEvent(n)) {
                ((BrowserModelGUI)this.model).keyReleased(n, n2);
                this.maybeConsumeEvent(keyEvent);
            } else {
                logChannel.log(10000000, "VirtualButton#keyPressed VirtualButtonModelGUI connected according to configuration pressed event is ignored by this widget");
            }
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (wheelButtonEvent.getClickCount() == 0) {
            return;
        }
        logChannelEvent.log(10000000, "VirtualButton#keyTurned event = %1", (Object)wheelButtonEvent);
        if (wheelButtonEvent.isConsumed()) {
            return;
        }
        if (this.doProcessEventSource(4) && this.hasState(36)) {
            if (this.handleKeyTurnAsKeyPress) {
                KeyEvent keyEvent = new KeyEvent(wheelButtonEvent.getReceiver(), wheelButtonEvent.getID(), 17, wheelButtonEvent.getTerminalID());
                this.keyPressed(keyEvent);
                return;
            }
            if (this.model instanceof RangeModelGUI) {
                int n = wheelButtonEvent.getDirection();
                if (wheelButtonEvent.getKeyCode() == 20) {
                    if (this.mflRollerUpIncrementsModel) {
                        n = n == 1 ? 0 : 1;
                    } else {
                        int n2 = n = n == 1 ? 1 : 0;
                    }
                }
                if (n == 1) {
                    logChannelEvent.log(10000000, "VirtualButton#keyTurned Rangemodel Leftturn", (Object)wheelButtonEvent);
                    if (this.rotationalDirectionClockWise) {
                        ((RangeModelGUI)this.model).decrement(this.calculateRangeModelIncrementationStep(wheelButtonEvent, (RangeModelGUI)this.model), this.terminal.getTerminalID());
                    } else {
                        ((RangeModelGUI)this.model).increment(this.calculateRangeModelIncrementationStep(wheelButtonEvent, (RangeModelGUI)this.model), this.terminal.getTerminalID());
                    }
                } else {
                    logChannelEvent.log(10000000, "VirtualButton#keyTurned Rangemodel Rightturn", (Object)wheelButtonEvent);
                    if (this.rotationalDirectionClockWise) {
                        ((RangeModelGUI)this.model).increment(this.calculateRangeModelIncrementationStep(wheelButtonEvent, (RangeModelGUI)this.model), this.terminal.getTerminalID());
                    } else {
                        ((RangeModelGUI)this.model).decrement(this.calculateRangeModelIncrementationStep(wheelButtonEvent, (RangeModelGUI)this.model), this.terminal.getTerminalID());
                    }
                }
                this.maybeConsumeEvent(wheelButtonEvent);
            } else if (this.model instanceof BrowserModelGUI) {
                if (wheelButtonEvent.getDirection() == 1) {
                    ((BrowserModelGUI)this.model).decrement(wheelButtonEvent.getClickCount(), this.terminal.getTerminalID());
                } else {
                    ((BrowserModelGUI)this.model).increment(wheelButtonEvent.getClickCount(), this.terminal.getTerminalID());
                }
                this.maybeConsumeEvent(wheelButtonEvent);
            } else if (this.event != 0) {
                if (this.fireEventKeyTurnedBackward && this.isTurnBackwardDirection(wheelButtonEvent) || this.fireEventKeyTurnedForward && this.isTurnForwardDirection(wheelButtonEvent)) {
                    this.fireSMEvent(this.terminal.getTerminalID(), this.event);
                    this.maybeConsumeEvent(wheelButtonEvent);
                }
            } else {
                logChannel.log(1000000, "VirtualButton#keyTurned unsupported model connected. model: %1 cannot process turn events", this.model);
            }
        } else {
            logChannel.log(10000000, "VirtualButton#keyTurned according to configuration turn event is ignored by this widget");
        }
    }

    private int calculateRangeModelIncrementationStep(WheelButtonEvent wheelButtonEvent, RangeModelGUI rangeModelGUI) {
        int n = wheelButtonEvent.getClickCount();
        if (!this.enableFastIncrement) {
            return n;
        }
        long l = this.getCurrentTime();
        if (l <= this.lastEventTime + 100L) {
            this.eventAccumulation += n;
            this.lastEventTime = l;
        } else {
            this.eventAccumulation = n;
            this.lastEventTime = l;
        }
        int n2 = rangeModelGUI.getMaximum();
        int n3 = rangeModelGUI.getMinimum();
        int n4 = rangeModelGUI.getStep();
        int n5 = n2 - n3;
        return 1 + (int)((float)(n4 * (this.eventAccumulation - 1)) * ((float)n5 / 200.0f));
    }

    private long getCurrentTime() {
        return AbstractWidget.framework.getMonotonicTime();
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        logChannelEvent.log(10000000, "VirtualButton#keyMoved event = %1", (Object)joystickEvent);
        if (joystickEvent.isConsumed() || !this.doProcessEventSource(8)) {
            logChannel.log(10000000, "VirtualButton#keyMoved event is not processed because event is consumed: %1 or widget is not configured to process joystick events", joystickEvent.isConsumed());
            return;
        }
        if (this.isJoystickDirectionBlocked(joystickEvent.getDirection())) {
            logChannel.log(10000000, "VirtualButton#keyMoved event is not processed - ignored Joystick direction ( %1 )", (long)joystickEvent.getDirection());
            return;
        }
        if (this.model instanceof VirtualButtonModelGUI) {
            VirtualButtonModelGUI virtualButtonModelGUI = (VirtualButtonModelGUI)this.model;
            if (this.invertJoystickEvents) {
                logChannel.log(10000000, "VirtualButton#processJoystickEvent joystick events are inverted, modelID: %1 terminalID: %2", (long)this.modelID, (long)this.terminal.getTerminalID());
                switch (joystickEvent.getDirection()) {
                    case 2: {
                        virtualButtonModelGUI.joyS(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 3: {
                        virtualButtonModelGUI.joySW(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 4: {
                        virtualButtonModelGUI.joyW(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 5: {
                        virtualButtonModelGUI.joyNW(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 6: {
                        virtualButtonModelGUI.joyN(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 7: {
                        virtualButtonModelGUI.joyNE(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 8: {
                        virtualButtonModelGUI.joyE(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 1: {
                        virtualButtonModelGUI.joySE(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 0: {
                        virtualButtonModelGUI.joyIdle(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    default: {
                        logChannel.log(10000, "VirtualButton#processJoystickEvent unknown Joystick direction: %1 event is not processed and consumed", (long)joystickEvent.getDirection());
                        break;
                    }
                }
            } else {
                logChannel.log(10000000, "VirtualButton#processJoystickEvent joystick events are not inverted, modelID: %1 terminalID: %2", (long)this.modelID, (long)this.terminal.getTerminalID());
                switch (joystickEvent.getDirection()) {
                    case 2: {
                        virtualButtonModelGUI.joyN(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 3: {
                        virtualButtonModelGUI.joyNE(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 4: {
                        virtualButtonModelGUI.joyE(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 5: {
                        virtualButtonModelGUI.joySE(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 6: {
                        virtualButtonModelGUI.joyS(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 7: {
                        virtualButtonModelGUI.joySW(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 8: {
                        virtualButtonModelGUI.joyW(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 1: {
                        virtualButtonModelGUI.joyNW(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    case 0: {
                        virtualButtonModelGUI.joyIdle(this.terminal.getTerminalID());
                        this.maybeConsumeEvent(joystickEvent);
                        break;
                    }
                    default: {
                        logChannel.log(10000000, "VirtualButton#keyMoved unknown Joystick direction: %1 event is not processed and consumed", (long)joystickEvent.getDirection());
                    }
                }
            }
        } else if (this.model instanceof BrowserModel) {
            BrowserModel browserModel = (BrowserModel)this.model;
            switch (joystickEvent.getDirection()) {
                case 2: {
                    browserModel.moveN(1, this.terminal.getTerminalID());
                    break;
                }
                case 3: {
                    browserModel.moveNE(1, this.terminal.getTerminalID());
                    break;
                }
                case 4: {
                    browserModel.moveE(1, this.terminal.getTerminalID());
                    break;
                }
                case 5: {
                    browserModel.moveSE(1, this.terminal.getTerminalID());
                    break;
                }
                case 6: {
                    browserModel.moveS(1, this.terminal.getTerminalID());
                    break;
                }
                case 7: {
                    browserModel.moveSW(1, this.terminal.getTerminalID());
                    break;
                }
                case 8: {
                    browserModel.moveW(1, this.terminal.getTerminalID());
                    break;
                }
                case 1: {
                    browserModel.moveNW(1, this.terminal.getTerminalID());
                    break;
                }
                case 0: {
                    browserModel.moveMiddle(this.terminal.getTerminalID());
                    break;
                }
            }
            this.maybeConsumeEvent(joystickEvent);
        } else if (this.event != 0) {
            this.fireSMEvent(this.terminal.getTerminalID(), this.event);
            this.maybeConsumeEvent(joystickEvent);
        } else {
            logChannel.log(10000000, "VirtualButton#keyMoved ignore event because no SM event configured and no supported model: %1", this.model);
        }
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchPadPositionMoved(this.currentTouchPadX, this.currentTouchPadY, touchEvent.getX(), touchEvent.getY(), this.terminal.getTerminalID());
        } else if (this.doProcessEventSource(32)) {
            this.touchEventHandler.touchPadPositionMoved(touchEvent, this.model);
        }
        this.currentTouchPadX = touchEvent.getX();
        this.currentTouchPadY = touchEvent.getY();
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        logChannelEvent.log(10000000, "VirtualButton#touchPadPressed event = %1", (Object)touchEvent);
        logChannel.log(10000000, "VirtualButton#touchPadPressed() event = %1", (Object)touchEvent);
        super.touchPadPressed(touchEvent);
        if (touchEvent.isConsumed() || this.model == null) {
            return;
        }
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchPadPressed(touchEvent.getX(), touchEvent.getY(), this.terminal.getTerminalID());
        } else if (this.doProcessEventSource(16) && this.hasState(36)) {
            if (touchEvent.getID() == 10906 || touchEvent.getID() == 10907) {
                if (this.model instanceof ButtonModelGUI) {
                    ButtonModelGUI buttonModelGUI = (ButtonModelGUI)this.model;
                    buttonModelGUI.keyPressed(touchEvent.getID(), this.terminal.getTerminalID());
                    buttonModelGUI.keyTyped(touchEvent.getID(), this.terminal.getTerminalID());
                    if (this.consumeEvents) {
                        touchEvent.consume(false);
                    }
                } else if (this.event != 0) {
                    this.fireSMEvent(this.terminal.getTerminalID(), this.event);
                    if (this.consumeEvents) {
                        touchEvent.consume(false);
                    }
                } else {
                    logChannel.log(10000000, "VirtualButton#keyMoved ignore event because no SM event configured and no supported model: %1", this.model);
                }
            }
        } else {
            logChannel.log(10000000, "VirtualButton#touchPadPressed VirtualButtonModelGUI connected according to configuration touchScreenPressed event is ignored by this widget, (STATE_ENABLED|STATE_ACTIVE) : %1", this.hasState(36));
        }
        this.currentTouchPadX = touchEvent.getX();
        this.currentTouchPadY = touchEvent.getY();
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchPadReleased(touchEvent.getX(), touchEvent.getY(), this.terminal.getTerminalID());
        } else if (this.doProcessEventSource(32)) {
            this.touchEventHandler.touchPadReleased(touchEvent);
        }
        this.currentTouchPadX = 0;
        this.currentTouchPadY = 0;
    }

    public void setEventConfiguration(int n) {
        this.eventConfiguration = n;
    }

    private boolean doProcessEventSource(int n) {
        return (n & this.eventConfiguration) != 0;
    }

    public void setRotationalDirectionClockwise(boolean bl) {
        this.rotationalDirectionClockWise = bl;
    }

    public void setInvertJoystickEvents(boolean bl) {
        this.invertJoystickEvents = bl;
    }

    public void setConsumeEvents(boolean bl) {
        this.consumeEvents = bl;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public int getSdsItemSelectedAction() {
        return this.sdsItemSelectedAction;
    }

    public void setSdsItemSelectedAction(int n) {
        this.sdsItemSelectedAction = n;
    }

    public int getSdsCommand() {
        return this.sdsCommand;
    }

    public void setSdsCommand(int n) {
        this.sdsCommand = n;
    }

    public void setHandleKeyTurnedAsKeyPressed(boolean bl) {
        this.handleKeyTurnAsKeyPress = bl;
    }

    public boolean isEnableFastIncrement() {
        return this.enableFastIncrement;
    }

    public void setEnableFastIncrement(boolean bl) {
        this.enableFastIncrement = bl;
    }

    public boolean isMflRollerUpIncrementsModel() {
        return this.mflRollerUpIncrementsModel;
    }

    public void setMflRollerUpIncrementsModel(boolean bl) {
        this.mflRollerUpIncrementsModel = bl;
    }

    public void setFireEventKeyTurnedBackward(boolean bl) {
        this.fireEventKeyTurnedBackward = bl;
    }

    public void setFireEventKeyTurnedForward(boolean bl) {
        this.fireEventKeyTurnedForward = bl;
    }

    public void touchScreenReleased(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenReleased(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchScreenReleased(gestureEvent.getX(), gestureEvent.getY(), this.terminal.getTerminalID());
        }
    }

    public void touchScreenFlicked(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenFlicked(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
    }

    public void touchScreenPressed(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenPressed(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchScreenPressed(gestureEvent.getX(), gestureEvent.getY(), this.terminal.getTerminalID());
        }
    }

    public void touchScreenZoom(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenZoom(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            float f2 = -gestureEvent.getYDelta();
            logChannel.log(10000000, "VirtualButton#touchScreenZoom new finger distance is %1, YDelta is: %2", (long)gestureEvent.getFingerDistance(), (long)gestureEvent.getYDelta());
            float f3 = this.currentFingerDistance > gestureEvent.getFingerDistance() ? f2 / (float)this.currentFingerDistance * 100.0f : f2 / (float)gestureEvent.getFingerDistance() * 100.0f;
            this.currentTouchPositionX = gestureEvent.getX();
            this.currentTouchPositionY = gestureEvent.getY();
            this.currentFingerDistance = gestureEvent.getFingerDistance();
            logChannel.log(10000000, "VirtualButton#touchScreenZoom() - Broadcasting delta of %1 to default VirtualButtonModel.", (double)f3);
            ((VirtualButtonModelGUI)this.model).touchScreenPinch(f3, gestureEvent.getX(), gestureEvent.getY(), this.terminal.getTerminalID());
        }
    }

    public void touchScreenMoved(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenMoved(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchScreenMoved(this.currentTouchPositionX, this.currentTouchPositionY, n, n2, this.terminal.getTerminalID());
            this.currentTouchPositionX = n;
            this.currentTouchPositionY = n2;
        }
    }

    public void touchScreenRotate(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenRotate(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
    }

    public void touchScreenPress2(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenPress2(%1, %2, %3) - called", (Object)gestureEvent, (long)n, (long)n2);
        if (this.isTouchScreenSupported() && this.model instanceof VirtualButtonModelGUI) {
            ((VirtualButtonModelGUI)this.model).touchScreenPressed(gestureEvent.getX(), gestureEvent.getY(), this.terminal.getTerminalID());
        }
    }

    public void touchScreenTap(GestureEvent gestureEvent, int n, int n2) {
        logChannel.log(10000000, "VirtualButton#touchScreenTap(%1, %2, %3) - called", (Object)gestureEvent, (long)this.x, (long)this.y);
    }

    public void setTouchScreenSupported(boolean bl) {
        this.isTouchScreenSupported = bl;
    }

    public boolean isTouchScreenSupported() {
        return this.isTouchScreenSupported;
    }
}

