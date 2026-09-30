/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.event.GestureEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ProximityEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.kbd.KeyMap;
import de.audi.kbd.hmi.AbstractKeyEventDistributor;
import de.audi.tghu.fwhmi.evo.IRootWindowEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IEventListenerEvo;

public final class KeyEventDistributorEvo
extends AbstractKeyEventDistributor {
    private final NullEventListenerEvo defaultEventListenerEvo = new NullEventListenerEvo();

    public KeyEventDistributorEvo(int n, IFrameworkAccess iFrameworkAccess) {
        super(n, iFrameworkAccess);
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.log.log(10000000, "KeyEventDistributor.keyPressed(%1)", (Object)keyEvent);
        int n = keyEvent.getKeyCode();
        if (this.isMIB2HighMMICombi() && n == 30) {
            this.log.log(10000000, "KeyEventDistributor.keyPressed only using menu key to possibly quit popups for G24 on main unit side");
            this.fw.getHMIService().getPopupManager(this.terminalID).processPopupQuit(n);
            return;
        }
        if ((n == 50 || n == 81 || n == 51) && this.sdsService != null) {
            this.sdsService.abortSDSSession(false, (byte)3);
        }
        boolean bl = false;
        if (n == 17 && this.sdsService != null) {
            this.log.log(10000000, "KeyEventDistributor.keyPressed: Notify SDS that DDS is being pressed!");
            bl = this.sdsService.startDDSPress();
        }
        this.sendMessagesOnKeyPress(n);
        if (KeyMap.isHardkey(n)) {
            if (n == 19) {
                IViewSizeManager iViewSizeManager = this.getViewSizeManager();
                if (iViewSizeManager == null) {
                    this.log.log(10000000, "KeyEventDistributor.keyPressed: View size button pressed but no manager available");
                } else {
                    this.log.log(10000000, "KeyEventDistributor.keyPressed: Telling view size manager that view size button was pressed");
                    iViewSizeManager.viewSizeKeyPressed();
                }
            }
            if (KeyMap.isAppChangeHardkey(n) || KeyMap.isStationHardkey(n) || n == 30 || n == 18 || n == 23 || n == 28 || n == 58 || n == 19 || n == 13 || n == 14) {
                this.log.log(10000000, "KeyEventDistributor.keyPressed: Sending %1 to drawer focus manager!", (Object)keyEvent);
                this.getDrawerFocusManager().processKeyEvent(keyEvent);
            }
            if (!keyEvent.isConsumed()) {
                this.informHardKeyListeners(keyEvent);
            }
        } else if (n == 15) {
            this.log.log(10000000, "KeyEventDistributor.keyPressed: Sending %1 to drawer focus manager!", (Object)keyEvent);
            this.getDrawerFocusManager().processKeyEvent(keyEvent);
            if (keyEvent.isConsumed()) {
                if (bl) {
                    this.log.log(10000000, "KeyEventDistributor.keyPressed: Notify SDS that DDS has been consumed!");
                    this.sdsService.endDDSPress();
                }
                return;
            }
            this.informHardKeyListeners(keyEvent);
        } else if (KeyMap.isCombiOnlyKey(n, this.isMIB2HighMMICombi())) {
            this.getCombiScreen().processKeyEvent(keyEvent);
        } else {
            this.getDrawerFocusManager().processKeyEvent(keyEvent);
            if (n == this.getSelectionDrawerKeyCode() && !keyEvent.isConsumed()) {
                this.informHardKeyListeners(keyEvent);
            }
        }
        if (KeyMap.isPopUpRemovalKey(n) && !keyEvent.ignorePopupRemoval()) {
            this.fw.getHMIService().getPopupManager(this.terminalID).processPopupQuit(n);
        }
        if (bl) {
            this.sdsService.endDDSPress();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        this.log.log(10000000, "KeyEventDistributor.keyReleased(%1)", (Object)keyEvent);
        int n = keyEvent.getKeyCode();
        if (KeyMap.isHardkey(n)) {
            this.informHardKeyListeners(keyEvent);
            if (KeyMap.isStationHardkey(n) || n == 30 || n == 58 || n == 13 || n == 14) {
                this.getDrawerFocusManager().processKeyEvent(keyEvent);
            }
        } else if (n == 15) {
            this.getDrawerFocusManager().processKeyEvent(keyEvent);
            if (keyEvent.isConsumed()) {
                return;
            }
            this.informHardKeyListeners(keyEvent);
        } else if (KeyMap.isCombiOnlyKey(n, this.isMIB2HighMMICombi())) {
            this.getCombiScreen().processKeyEvent(keyEvent);
        } else {
            this.getDrawerFocusManager().processKeyEvent(keyEvent);
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        this.log.log(10000000, "KeyEventDistributor.keyTurned(%1)", (Object)wheelButtonEvent);
        int n = wheelButtonEvent.getKeyCode();
        if (n == 16) {
            this.informHardKeyListeners(wheelButtonEvent);
        } else if (KeyMap.isCombiOnlyKey(n, this.isMIB2HighMMICombi())) {
            this.log.log(1000000, "KeyEventDistributor.keyTurned: Sending %1 to combi screen!", (Object)wheelButtonEvent);
            this.getCombiScreen().processKeyEvent(wheelButtonEvent);
        } else {
            if ((n == 17 || n == 20) && (this.fw.getHMIService().isPartialPopupVisibleInSlot(this.terminalID, 1) || this.fw.getHMIService().isPartialPopupVisibleInSlot(this.terminalID, 2))) {
                this.log.log(10000000, "KeyEventDistributor.keyTurned: Remove all partial pop-ups.! (terminal=%1)", (long)this.terminalID);
                this.fw.getHMIService().removeAllPartialPopupsForSlots(this.terminalID, IPartialPopupManager.SLOTS_ALL_POPINS);
                return;
            }
            if (this.sdsService != null && this.sdsService.isSDSActive()) {
                this.log.log(10000000, "KeyEventDistributor.keyTurned: SDS active, notify SDS that DDS is being turned!");
                this.sdsService.turnDDSWheel();
            }
            this.getDrawerFocusManager().processKeyEvent(wheelButtonEvent);
        }
    }

    public void keyMoved(JoystickEvent joystickEvent) {
        this.log.log(10000000, "KeyEventDistributor.keyMoved(%1)", (Object)joystickEvent);
        if (this.sdsService != null) {
            this.sdsService.movedDDSJoystick(joystickEvent);
        }
        if (joystickEvent.isConsumed()) {
            this.log.log(10000000, "KeyEventDistributor.keyMoved(%1) Event consumed by sdsService, no processing by drawer focus manager", (Object)joystickEvent);
        } else {
            this.getDrawerFocusManager().processKeyEvent(joystickEvent);
        }
        if (joystickEvent.isConsumed()) {
            return;
        }
        this.informHardKeyListeners(joystickEvent);
    }

    private int getSelectionDrawerKeyCode() {
        if (this.fw.getLanguageMgr().isLeftToRightOrientation()) {
            return 9;
        }
        return 11;
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadPositionMoved(%1)", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadPressed(%1)", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadReleased(%1)", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadCharactersRecognized(%1)", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void touchPadAbandoned(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadAbandoned(%1)", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void touchPadPalmRecognized(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadPalmRecognized(%1)", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void touchPadApproached(TouchEvent touchEvent) {
        this.log.log(10000000, "KeyEventDistributor.touchPadApproached: Sending %1 to drawer focus manager!", (Object)touchEvent);
        this.getDrawerFocusManager().processTouchPadEvent(touchEvent);
    }

    public void triggerGestureEvent(GestureEvent gestureEvent) {
        this.log.log(10000000, "KeyEventDistributor.triggerGestureEvent: Sending %1 to main screen!", (Object)gestureEvent);
        this.getDrawerFocusManager().processGestureEvent(gestureEvent);
    }

    public void triggerProximityEvent(ProximityEvent proximityEvent) {
        this.log.log(10000000, "KeyEventDistributor.triggerProximityEvent(%1)", (Object)proximityEvent);
    }

    private IEventListenerEvo getCombiScreen() {
        Screen screen;
        IRootWindow iRootWindow = this.fw.getHMIService().getRootWindow(1);
        if (iRootWindow != null && (screen = iRootWindow.getCurrentScreen()) != null) {
            return (IEventListenerEvo)((Object)screen);
        }
        return this.defaultEventListenerEvo;
    }

    private IEventListenerEvo getMainScreen() {
        Screen screen;
        IRootWindow iRootWindow = this.fw.getHMIService().getRootWindow(0);
        if (iRootWindow != null && (screen = iRootWindow.getCurrentScreen()) != null) {
            return (IEventListenerEvo)((Object)screen);
        }
        return this.defaultEventListenerEvo;
    }

    private IEventListenerEvo getDrawerFocusManager() {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = ((IRootWindowEvo)this.fw.getHMIService().getRootWindow(this.terminalID)).getDrawerFocusManager();
        if (null != iDrawerFocusManagerEvo) {
            return iDrawerFocusManagerEvo;
        }
        return this.defaultEventListenerEvo;
    }

    private IViewSizeManager getViewSizeManager() {
        return ((IRootWindowEvo)this.fw.getHMIService().getRootWindow(this.terminalID)).getViewSizeManager();
    }

    private boolean isMIB2HighMMICombi() {
        return this.fw.getKombiType() == 4;
    }

    private class NullEventListenerEvo
    implements IEventListenerEvo {
        private NullEventListenerEvo() {
        }

        public void processGestureEvent(GestureEvent gestureEvent) {
            KeyEventDistributorEvo.this.log.log(100000, "[NullEventListenerEvo].processGestureEvent(%1)", (Object)gestureEvent);
        }

        public void processKeyEvent(KeyEvent keyEvent) {
            KeyEventDistributorEvo.this.log.log(100000, "[NullEventListenerEvo].processKeyEvent(%1)", (Object)keyEvent);
        }

        public void processTouchPadEvent(TouchEvent touchEvent) {
            KeyEventDistributorEvo.this.log.log(100000, "[NullEventListenerEvo].processTouchPadEvent(%1)", (Object)touchEvent);
        }
    }
}

