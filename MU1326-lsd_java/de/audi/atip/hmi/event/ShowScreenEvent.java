/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class ShowScreenEvent
extends ATIPEvent {
    private int screenId = 0;
    private boolean takeScreenshot = false;
    private int popinID = -1;
    private String pathToSaveScreenShot = null;
    private boolean saveAsZip = false;
    private int colorScheme = 0;
    private int terminalID;

    public ShowScreenEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, 19001);
    }

    public void setScreenId(int n) {
        this.screenId = n;
    }

    public int getScreenId() {
        return this.screenId;
    }

    public String toString() {
        return new StringBuffer().append("ShowScreenEvent: ScreenId = ").append(this.screenId).toString();
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
        this.saveAsZip = bl2;
        this.pathToSaveScreenShot = string;
    }

    public void setColorScheme(int n) {
        this.colorScheme = n;
    }

    public int getColorScheme() {
        return this.colorScheme;
    }

    public void setTerminalId(int n) {
        this.terminalID = n;
    }

    public int getTerminalId() {
        return this.terminalID;
    }
}

