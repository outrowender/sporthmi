/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.BrowserListener;
import de.audi.atip.hmi.modelaccess.BrowserModelApp;
import de.audi.atip.hmi.modelaccess.BrowserModelGUI;

public class BrowserModel
extends AbstractModel
implements BrowserModelApp,
BrowserModelGUI {
    public static final int SK_HOME = 1;
    public static final int SK_FORWARD = 2;
    public static final int SK_BACKWARD = 3;
    private volatile BrowserListener browserListener = DUMMY_LISTENER;

    public BrowserModel(int n) {
        super(n, 0);
    }

    public int getModelType() {
        return 18;
    }

    public void resetListener() {
        this.browserListener = DUMMY_LISTENER;
    }

    public void clear() {
    }

    public void setBrowserListener(BrowserListener browserListener) {
        this.browserListener = browserListener != null ? browserListener : DUMMY_LISTENER;
    }

    public void keyPressed(int n, int n2) {
        try {
            this.browserListener.keyPressed(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyReleased(int n, int n2) {
        try {
            this.browserListener.keyReleased(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyTyped(int n, int n2) {
        try {
            this.browserListener.keyTyped(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void decrement(int n, int n2) {
        try {
            this.browserListener.decrement(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void increment(int n, int n2) {
        try {
            this.browserListener.increment(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveNW(int n, int n2) {
        try {
            this.browserListener.moveNW(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveN(int n, int n2) {
        try {
            this.browserListener.moveN(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveNE(int n, int n2) {
        try {
            this.browserListener.moveNE(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveE(int n, int n2) {
        try {
            this.browserListener.moveE(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveSE(int n, int n2) {
        try {
            this.browserListener.moveSE(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveS(int n, int n2) {
        try {
            this.browserListener.moveS(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveSW(int n, int n2) {
        try {
            this.browserListener.moveSW(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveW(int n, int n2) {
        try {
            this.browserListener.moveW(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void moveMiddle(int n) {
        try {
            this.browserListener.moveMiddle(this.getID(), n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public boolean isEmpty() {
        return false;
    }
}

