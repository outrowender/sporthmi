/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class ScreenShotEvent
extends ATIPEvent {
    private String fileName = null;
    private String screenShotPath = "";
    private boolean saveWithCompression = false;
    private boolean saveToClipboard = false;
    private static final int EVENT_ID;

    public ScreenShotEvent(ATIPEventListener aTIPEventListener, String string) {
        super(aTIPEventListener, 19001);
        this.setScreenShotPath(string);
    }

    public ScreenShotEvent(ATIPEventListener aTIPEventListener, boolean bl) {
        super(aTIPEventListener, 19001);
        this.saveToClipboard = bl;
    }

    public final void setScreenShotPath(String string) {
        this.screenShotPath = string;
    }

    public String getScreenShotPath() {
        return this.screenShotPath;
    }

    public final void setFileName(String string) {
        this.fileName = string;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setSaveWithCompression(boolean bl) {
        this.saveWithCompression = bl;
    }

    public boolean saveWithCompression() {
        return this.saveWithCompression;
    }

    public boolean saveToClipboard() {
        return this.saveToClipboard;
    }
}

