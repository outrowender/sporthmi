/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class RemoveScreenEvent
extends ATIPEvent {
    private int screenId = 0;
    private boolean takeScreenshot = false;
    private String pathToSaveScreenShot = null;
    private int popinID = -1;
    private boolean saveAsZip = false;

    public RemoveScreenEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, 19001);
    }

    public void setScreenId(int n) {
        this.screenId = n;
    }

    public int getScreenId() {
        return this.screenId;
    }

    public String toString() {
        return "RemoveScreenEvent: ScreenId = " + this.screenId;
    }

    public boolean isPopin() {
        return this.popinID > -1;
    }

    public int getPopinID() {
        return this.popinID;
    }

    public void setPopinID(int n) {
        this.popinID = n;
    }

    public boolean takeScreenshot() {
        return this.takeScreenshot;
    }

    public String getScreenShotPath() {
        return this.pathToSaveScreenShot;
    }

    public boolean saveAsZip() {
        return this.saveAsZip;
    }

    public void setTakeScreenshot(boolean bl, String string, boolean bl2) {
        this.takeScreenshot = bl;
        this.pathToSaveScreenShot = string;
        this.saveAsZip = bl2;
    }
}

