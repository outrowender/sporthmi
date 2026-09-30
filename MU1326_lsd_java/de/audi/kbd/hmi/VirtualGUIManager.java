/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.keyhandling.IVirtualGUIManager;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.kbd.KeyMap;
import de.audi.kbd.hmi.FocusManager;
import de.audi.kbd.hmi.VirtualButtonHandler;

public class VirtualGUIManager
implements IVirtualGUIManager,
TimerListener,
PowerEventListener {
    private static final int PTT_TIMER_PRIORITY = 5;
    private static final long PTT_DURATION_DEFAULT = 3000L;
    private final IFrameworkAccess framework;
    private final FocusManager focusManager;
    private final LogChannel logGUIManager;
    private final DefaultVirtualButtonHandler defaultVirtualButtonHandler;
    private final Timer pttTimer;
    private int[] powerState = new int[8];
    private final VirtualButtonHandler[] virtualButtonHandler = new VirtualButtonHandler[55];
    private boolean forwardJoker1Released = true;
    private boolean sdsStatusChoiceLongPress = false;
    private boolean isPTTLong = false;
    private boolean surpressSDSUnavailablePopup = false;

    public VirtualGUIManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.focusManager = new FocusManager(this.framework);
        this.logGUIManager = this.framework.getLogChannel("Fw.Kbd.VirtualGUIManager");
        this.defaultVirtualButtonHandler = new DefaultVirtualButtonHandler();
        this.pttTimer = new Timer("pttTimer", 5, null, this, this.getPttDuration(), true);
        for (int i2 = 0; i2 < 55; ++i2) {
            this.virtualButtonHandler[i2] = new VirtualButtonHandler(this.framework, i2);
        }
    }

    public void fireTimer(Timer timer) {
        if (this.pttTimer.equals(timer)) {
            this.logGUIManager.log(1000000, "VirtualGUIManager.fireTimer: Reset SDS status!");
            ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(335);
            choiceModelApp.setValue(0);
        }
    }

    public void cancelTimer(Timer timer) {
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logGUIManager.log(1000000, "VirtualGUIManager.notifyPowerListenerOnEnterState(%1, %2)", (long)n, (long)n2);
        this.focusManager.setPowerState(n, n2);
        this.setPowerState(n, n2);
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public IFocusManager getFocusManager() {
        return this.focusManager;
    }

    public void connectService(HMIApplication hMIApplication) {
        this.logGUIManager.log(10000000, "VirtualGUIManager.connectService(%1)", (Object)hMIApplication);
        if (hMIApplication == null) {
            return;
        }
        for (int i2 = 0; i2 < this.virtualButtonHandler.length; ++i2) {
            if (this.virtualButtonHandler[i2] == null) continue;
            int n = this.virtualButtonHandler[i2].getVirtualButtonID();
            ButtonModelGUI buttonModelGUI = (ButtonModelGUI)((Object)hMIApplication.getVirtualButton(this.virtualButtonHandler[i2].getVirtualButtonID()));
            if (buttonModelGUI == null) continue;
            this.logGUIManager.log(1000000, "VirtualGUIManager.connectService: viewID=%1, modelID=%2", (long)n, (long)buttonModelGUI.getID());
            this.virtualButtonHandler[i2].addModel(buttonModelGUI);
            buttonModelGUI.addReference();
        }
    }

    public void disconnectService(HMIApplication hMIApplication) {
        this.logGUIManager.log(10000000, "VirtualGUIManager.disconnectService(%1)", (Object)hMIApplication);
        if (hMIApplication == null) {
            return;
        }
        for (int i2 = 0; i2 < this.virtualButtonHandler.length; ++i2) {
            if (this.virtualButtonHandler[i2] == null) continue;
            int n = this.virtualButtonHandler[i2].getVirtualButtonID();
            ButtonModelGUI buttonModelGUI = (ButtonModelGUI)((Object)hMIApplication.getVirtualButton(this.virtualButtonHandler[i2].getVirtualButtonID()));
            if (buttonModelGUI == null) continue;
            this.logGUIManager.log(1000000, "VirtualGUIManager.disconnectService: viewID=%1, modelID=%2", (long)n, (long)buttonModelGUI.getID());
            this.virtualButtonHandler[i2].removeModel(buttonModelGUI);
            buttonModelGUI.removeReference();
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.logGUIManager.log(10000000, "VirtualGUIManager.keyPressed(%1)", (Object)keyEvent);
        int n = keyEvent.getKeyCode();
        if (!(this.framework.isBentley() || n != 9 && n != 11)) {
            int n2;
            boolean bl = this.framework.getLanguageMgr().isLeftToRightOrientation();
            int n3 = n2 = bl ? 9 : 11;
            if (n == n2) {
                this.framework.getSysApp().getVariantAppSystem().fireHKSelection(keyEvent.getTerminalID());
                return;
            }
        }
        switch (n) {
            case 1: 
            case 2: 
            case 30: {
                if (this.focusManager.focusAppChanged(keyEvent)) {
                    this.getVirtualButtonHandler(n).keyPressed(keyEvent);
                }
                this.focusManager.postSetFocusedScreenEvent();
                break;
            }
            case 15: {
                this.framework.getSysApp().getVariantAppSystem().fireHKReturn(keyEvent.getTerminalID());
                break;
            }
            case 18: 
            case 23: 
            case 28: {
                this.setSDSStatusChoice(false, n);
                this.handlePorschePopups(false, n);
                this.getVirtualButtonHandler(n).keyPressed(keyEvent);
                break;
            }
            case 21: {
                this.getVirtualButtonHandler(16).keyPressed(keyEvent);
                break;
            }
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: 
            case 79: 
            case 80: {
                if (!this.getTouchPadMode()) break;
                this.getVirtualButtonHandler(n).keyPressed(keyEvent);
                break;
            }
            case 50: {
                this.forwardJoker1Released = true;
                this.getVirtualButtonHandler(n).keyPressed(keyEvent);
                break;
            }
            case 81: {
                this.forwardJoker1Released = false;
                this.getVirtualButtonHandler(n).keyPressed(keyEvent);
                break;
            }
            default: {
                this.getVirtualButtonHandler(n).keyPressed(keyEvent);
            }
        }
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        this.logGUIManager.log(10000000, "VirtualGUIManager.keyMoved(%1)", (Object)joystickEvent);
        int n = joystickEvent.getKeyCode();
        if (n == 22) {
            int n2;
            boolean bl = this.framework.getLanguageMgr().isLeftToRightOrientation();
            int n3 = joystickEvent.getDirection();
            int n4 = n2 = bl ? 8 : 4;
            if (n3 == n2) {
                this.framework.getSysApp().getVariantAppSystem().fireHKSelection(joystickEvent.getTerminalID());
                return;
            }
            this.logGUIManager.log(10000000, "VirtualGUIManager.keyMoved(%1) nothing is done for direction", (long)n3);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        this.logGUIManager.log(10000000, "VirtualGUIManager.keyReleased(%1)", (Object)keyEvent);
        int n = keyEvent.getKeyCode();
        switch (n) {
            case 21: {
                this.getVirtualButtonHandler(16).keyReleased(keyEvent);
                break;
            }
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: 
            case 79: 
            case 80: {
                if (!this.getTouchPadMode()) break;
                this.getVirtualButtonHandler(n).keyReleased(keyEvent);
                break;
            }
            case 50: {
                if (this.forwardJoker1Released) {
                    this.getVirtualButtonHandler(n).keyReleased(keyEvent);
                }
                this.forwardJoker1Released = true;
                break;
            }
            case 18: {
                this.setSDSStatusChoice(true, n);
                this.handlePorschePopups(true, n);
                this.getVirtualButtonHandler(n).keyReleased(keyEvent);
                break;
            }
            default: {
                this.getVirtualButtonHandler(n).keyReleased(keyEvent);
            }
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        this.logGUIManager.log(10000000, "VirtualGUIManager.keyTurned(%1)", (Object)wheelButtonEvent);
        int n = wheelButtonEvent.getKeyCode();
        switch (wheelButtonEvent.getKeyCode()) {
            default: 
        }
        this.getVirtualButtonHandler(n).keyTurned(wheelButtonEvent);
    }

    private synchronized int getPowerState(int n) {
        return this.powerState[n];
    }

    private synchronized void setPowerState(int n, int n2) {
        this.powerState[n2] = n;
    }

    private boolean getTouchPadMode() {
        boolean bl;
        ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(413);
        boolean bl2 = bl = choiceModelApp.getValue() == 0;
        if (this.framework.isFrontMU() && this.getPowerState(0) == 1) {
            bl = true;
        }
        return bl;
    }

    private void setSDSStatusChoice(boolean bl, int n) {
        ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(335);
        ChoiceModelApp choiceModelApp2 = this.framework.getHMIService().getChoiceModel(371);
        if ((bl || n != 18 && n != 28) && !bl && n == 23) {
            this.sdsStatusChoiceLongPress = true;
        }
        if (bl && this.isTerminalModeCoded() && this.sdsStatusChoiceLongPress) {
            this.sdsStatusChoiceLongPress = false;
        } else if (bl) {
            if (this.framework.getSysConst(460) == 0) {
                this.logGUIManager.log(1000000, "VirtualGUIManager.setSDSStatusChoice: Set SDS status to NOT_PRESENT!");
                choiceModelApp.setValue(5);
                this.pttTimer.restart();
            } else if (choiceModelApp2.getValue() == 0) {
                this.logGUIManager.log(1000000, "VirtualGUIManager.setSDSStatusChoice: Set SDS status to NOT_INITIALIZED!");
                choiceModelApp.setValue(1);
                this.pttTimer.restart();
            }
        }
    }

    private boolean isTerminalModeCoded() {
        return this.framework.getSysConst(4237) == 1 || this.framework.getSysConst(4238) == 1 || this.framework.getSysConst(5571) == 1;
    }

    private void handlePorschePopups(boolean bl, int n) {
        if (!this.framework.isPorscheHigh()) {
            return;
        }
        if (bl || n != 18 && n != 28) {
            if (!bl && n == 23) {
                this.isPTTLong = true;
                if (this.isTerminalModeCoded()) {
                    this.surpressSDSUnavailablePopup = true;
                } else {
                    this.logGUIManager.log(1000000, "VirtualGUIManager.handlePorschePopups: No terminalmode provider coded, showing error popup.");
                    this.surpressSDSUnavailablePopup = false;
                    ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(335);
                    choiceModelApp.setValue(13);
                    this.pttTimer.restart();
                    this.framework.getSysApp().getVariantAppSystem().showSdsStatusPopup(0);
                }
            } else if (bl && n == 18) {
                if (!this.isPTTLong) {
                    if (this.framework.getSysConst(460) == 0 && !this.surpressSDSUnavailablePopup) {
                        this.framework.getSysApp().getVariantAppSystem().showSdsStatusPopup(0);
                    } else if (this.framework.getHMIService().getChoiceModel(371).getValue() == 0) {
                        this.framework.getSysApp().getVariantAppSystem().showSdsStatusPopup(0);
                    } else {
                        this.logGUIManager.log(1000000, "VirtualGUIManager.handlePorschePopups: Normal workflow or smartphone voice abort, not showing 'SDS not shored' popup.");
                    }
                    this.surpressSDSUnavailablePopup = false;
                } else if (this.isPTTLong && this.isTerminalModeCoded() && this.framework.getSysConst(460) == 0) {
                    ChoiceModelApp choiceModelApp = this.framework.getHMIService().getChoiceModel(335);
                    choiceModelApp.setValue(14);
                    this.framework.getSysApp().getVariantAppSystem().showSdsStatusPopup(0);
                }
                this.isPTTLong = false;
            }
        }
    }

    private KeyListener getVirtualButtonHandler(int n) {
        int n2 = KeyMap.getVirtualButtonId(n);
        if (n2 >= 0 && n2 < 55) {
            return this.virtualButtonHandler[n2];
        }
        return this.defaultVirtualButtonHandler;
    }

    private long getPttDuration() {
        return 3000L;
    }

    private class DefaultVirtualButtonHandler
    implements KeyListener {
        private DefaultVirtualButtonHandler() {
        }

        public void keyPressed(KeyEvent keyEvent) {
            VirtualGUIManager.this.logGUIManager.log(1000000, "DefaultVirtualButtonHandler.keyPressed: No virtual button! (evenz=%1)", (Object)keyEvent);
        }

        public void keyReleased(KeyEvent keyEvent) {
            VirtualGUIManager.this.logGUIManager.log(1000000, "DefaultVirtualButtonHandler.keyReleased: No virtual button! (evenz=%1)", (Object)keyEvent);
        }

        public void keyTurned(WheelButtonEvent wheelButtonEvent) {
            VirtualGUIManager.this.logGUIManager.log(1000000, "DefaultVirtualButtonHandler.keyTurned: No virtual button! (evenz=%1)", (Object)wheelButtonEvent);
        }

        public void keyMoved(JoystickEvent joystickEvent) {
            VirtualGUIManager.this.logGUIManager.log(1000000, "DefaultVirtualButtonHandler.keyMoved: No virtual button! (evenz=%1)", (Object)joystickEvent);
        }
    }
}

