/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.IFocusManager;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.SetFocusedScreenEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;

public final class FocusManager
implements ATIPEventListener,
IFocusManager {
    private static final int APP_INVALID = -1;
    private static final int APP_MENU = 0;
    private static final int STATUSBAR_FOCUS_LEFT = 0;
    private static final int STATUSBAR_FOCUS_RIGHT = 1;
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private HMITerminal terminalLeft;
    private HMITerminal terminalRight;
    private int focusedTerminal = -2;
    private int[] lastFocusedApp = new int[8];
    private final boolean isRSE;
    private volatile boolean setFocusedScreen;
    private int[] currentIntrinsicPowerState = new int[8];

    public FocusManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Kbd.FocusManager");
        this.isRSE = !iFrameworkAccess.isFrontMU();
        for (int i2 = 0; i2 < this.lastFocusedApp.length; ++i2) {
            this.lastFocusedApp[i2] = -1;
        }
    }

    public int getFocusedTerminal() {
        return this.focusedTerminal;
    }

    public PowerEventListener getPowerEventListener() {
        return null;
    }

    public void setActiveApplication(int n, int n2) {
        this.log.log(10000000, "PocusManger.setActiveApplication( %1, %2)", (long)n, (long)n2);
        if (this.getLastFocusedApp(n) == -1) {
            this.setLastFocusedApp(n, this.getValidApp(n2));
            this.switchLightingToFocusedTerminal();
        } else {
            this.setLastFocusedApp(n, this.getValidApp(n2));
        }
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        this.log.log(1000000, "FocusManager.processEvent(%1)", (Object)aTIPEvent);
        if (aTIPEvent instanceof SetFocusedScreenEvent) {
            this.switchLightingToFocusedTerminal();
            this.checkSKIlluminationChange();
        }
    }

    public void setPowerState(int n, int n2) {
        this.log.log(1000000, "FocusManager.notifyPowerListenerOnEnterState(%1, %2)", (long)n, (long)n2);
        if (!this.isRSE) {
            return;
        }
        if (this.switchFocus(n, n2)) {
            this.log.log(10000000, "FocusManager.notifyPowerListenerOnEnterState: Set focus to terminal %1!", (long)this.getOppositeTerminalID(n2));
            this.assignFocus(this.getOppositeTerminalID(n2));
        } else if (this.obtainFocus(n, n2)) {
            this.log.log(10000000, "FocusManager.notifyPowerListenerOnEnterState: Set focus to terminal %1!", (long)n2);
            this.assignFocus(n2);
        }
        this.setCurrentIntrinsicPowerState(n, n2);
    }

    public boolean focusAppChanged(KeyEvent keyEvent) {
        this.log.log(1000000, "FocusManager.focusAppChanged(%1)", (Object)keyEvent);
        if (!this.isRSE) {
            return true;
        }
        int n = keyEvent.getKeyCode();
        int n2 = keyEvent.getTerminalID();
        if (n != 1 && n != 2 && n != 30) {
            this.log.log(10000000, "FocusManager.focusAppChanged: The key event is not supported! (event=%1)", (Object)keyEvent);
            return true;
        }
        if (this.getFocusedTerminal() == this.getOppositeTerminalID(n2) || this.getFocusedTerminal() == -2) {
            this.log.log(10000000, "FocusManager.focusAppChanged: Set focus to terminal %1!", (long)n2);
            this.setFocusedScreen = true;
            this.setFocusedTerminal(n2);
            this.broadcatsFocus();
            this.checkSKIlluminationChange();
            if (this.getLastFocusedApp(n2) == (n == 30 ? 0 : n)) {
                this.log.log(10000000, "FocusManager.focusAppChanged: The focus has changed but the application of the new focused terminal has not chhanged.");
                return false;
            }
        }
        this.setLastFocusedApp(n2, this.getValidApp(n));
        return true;
    }

    public void postSetFocusedScreenEvent() {
        this.log.log(1000000, "FocusManager.postSetFocusedScreenEvent()");
        if (!this.isRSE) {
            return;
        }
        if (this.setFocusedScreen) {
            this.framework.getHMIService().getEventDispatcher().postEvent(new SetFocusedScreenEvent(this, 0, this.getFocusedTerminal()));
            this.setFocusedScreen = false;
        }
    }

    private void assignFocus(int n) {
        if (this.getFocusedTerminal() == this.getOppositeTerminalID(n) || this.getFocusedTerminal() == -2) {
            this.setFocusedTerminal(n);
            this.broadcatsFocus();
            this.switchLightingToFocusedTerminal();
        }
        this.checkSKIlluminationChange();
    }

    private void checkSKIlluminationChange() {
        if (this.isRSE) {
            if (this.terminalLeft == null) {
                this.terminalLeft = this.framework.getHMITerminalRegistry().getTerminal(3);
            }
            if (this.terminalRight == null) {
                this.terminalRight = this.framework.getHMITerminalRegistry().getTerminal(4);
            }
            HMITerminal hMITerminal = null;
            HMITerminal hMITerminal2 = null;
            if (this.getFocusedTerminal() == 3) {
                hMITerminal = this.terminalLeft;
                hMITerminal2 = this.terminalRight;
            } else {
                hMITerminal = this.terminalRight;
                hMITerminal2 = this.terminalLeft;
            }
            if (hMITerminal != null) {
                hMITerminal.setFocus(true);
            }
            if (hMITerminal2 != null) {
                hMITerminal2.setFocus(false);
            }
        }
    }

    private void switchLightingToFocusedTerminal() {
        if (this.getFocusedTerminal() != -2 && this.getLastFocusedApp(this.getFocusedTerminal()) != -1) {
            this.log.log(1000000, "FocusManager.switchLightingToFocusedTerminal: Change key board illumination!");
        }
    }

    private void broadcatsFocus() {
        this.log.log(1000000, "FocusManager.broadcatsFocus()");
        this.framework.getHMIService().getChoiceModel(384).setValue(this.getFocusIconValue(this.getFocusedTerminal()));
    }

    private void setFocusedTerminal(int n) {
        this.focusedTerminal = n;
    }

    private boolean obtainFocus(int n, int n2) {
        return n == 0 && this.getCurrentIntrinsicPowerState(n2) == 2;
    }

    private boolean switchFocus(int n, int n2) {
        return n == 2 && this.getCurrentIntrinsicPowerState(n2) == 1 && n2 == this.getFocusedTerminal();
    }

    private int getCurrentIntrinsicPowerState(int n) {
        return this.currentIntrinsicPowerState[n];
    }

    private void setCurrentIntrinsicPowerState(int n, int n2) {
        this.currentIntrinsicPowerState[n2] = n;
    }

    private int getLastFocusedApp(int n) {
        return this.lastFocusedApp[n];
    }

    private void setLastFocusedApp(int n, int n2) {
        this.lastFocusedApp[n] = n2;
    }

    private int getValidApp(int n) {
        int n2 = -1;
        switch (n) {
            case 0: 
            case 5: 
            case 6: 
            case 30: {
                n2 = 0;
                break;
            }
            default: {
                n2 = n;
            }
        }
        return n2;
    }

    private int getOppositeTerminalID(int n) {
        switch (n) {
            case 3: {
                return 4;
            }
            case 4: {
                return 3;
            }
        }
        return -2;
    }

    private int getFocusIconValue(int n) {
        switch (n) {
            case 3: {
                return 0;
            }
            case 4: {
                return 1;
            }
        }
        return 0;
    }
}

