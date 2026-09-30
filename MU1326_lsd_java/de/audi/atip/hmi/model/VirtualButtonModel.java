/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.VirtualButtonListener;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelGUI;

public class VirtualButtonModel
extends RangeModel
implements VirtualButtonModelGUI,
VirtualButtonModelApp {
    public VirtualButtonModel(int n) {
        super(n, 0);
    }

    public VirtualButtonModel(int n, int n2) {
        super(n, n2);
    }

    public int getModelType() {
        return 17;
    }

    public void joyN(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickN(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joyNW(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickNW(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joyW(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickW(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joySW(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickSW(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joyS(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickS(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joySE(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickSE(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joyE(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickE(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joyNE(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickNE(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void joyIdle(int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).stickIdle(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenMoved(this.id, n, n2, n3, n4, n5);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenFlicked(int n, int n2, int n3, int n4, int n5) {
        this.touchScreenMoved(n, n2, n3, n4, n5);
    }

    public void touchScreenPressed(int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenPressed(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenLongPressed(int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenLongPressed(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenReleased(int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenReleased(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchPadPositionMoved(this.id, n, n2, n3, n4, n5);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenDoubleClick(int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenDoubleClick(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenPinch(float f2, int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenPinch(this.id, f2, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchScreenRotate(short s, int n) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchScreenRotate(this.id, s, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void setVirtualButtonListener(VirtualButtonListener virtualButtonListener) {
        this.setButtonListener(virtualButtonListener);
    }

    public void touchPadReleased(int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchPadReleased(n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void touchPadPressed(int n, int n2, int n3) {
        try {
            ((VirtualButtonListener)this.buttonListener).touchPadPressed(n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

