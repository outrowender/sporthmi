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
    public static final int SK_HOME;
    public static final int SK_FORWARD;
    public static final int SK_BACKWARD;
    private volatile BrowserListener browserListener = DUMMY_LISTENER;

    public BrowserModel(int n) {
        super(n, 0);
    }

    @Override
    public int getModelType() {
        return 18;
    }

    @Override
    public void resetListener() {
        this.browserListener = DUMMY_LISTENER;
    }

    public void clear() {
    }

    @Override
    public void setBrowserListener(BrowserListener browserListener) {
        this.browserListener = browserListener != null ? browserListener : DUMMY_LISTENER;
    }

    @Override
    public void keyPressed(int n, int n2) {
        try {
            this.browserListener.keyPressed(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void keyReleased(int n, int n2) {
        try {
            this.browserListener.keyReleased(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void keyTyped(int n, int n2) {
        try {
            this.browserListener.keyTyped(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void decrement(int n, int n2) {
        try {
            this.browserListener.decrement(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void increment(int n, int n2) {
        try {
            this.browserListener.increment(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveNW(int n, int n2) {
        try {
            this.browserListener.moveNW(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveN(int n, int n2) {
        try {
            this.browserListener.moveN(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveNE(int n, int n2) {
        try {
            this.browserListener.moveNE(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveE(int n, int n2) {
        try {
            this.browserListener.moveE(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveSE(int n, int n2) {
        try {
            this.browserListener.moveSE(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveS(int n, int n2) {
        try {
            this.browserListener.moveS(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveSW(int n, int n2) {
        try {
            this.browserListener.moveSW(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveW(int n, int n2) {
        try {
            this.browserListener.moveW(this.getID(), n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void moveMiddle(int n) {
        try {
            this.browserListener.moveMiddle(this.getID(), n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

