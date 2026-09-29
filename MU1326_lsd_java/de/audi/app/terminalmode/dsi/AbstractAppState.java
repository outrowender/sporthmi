/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IAppState;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractAppState
implements IAppState {
    private final int appStateId;
    private final int owner;
    private final int speechMode;

    public AbstractAppState(int n, int n2, int n3) {
        this.appStateId = n;
        this.owner = n2;
        this.speechMode = n3;
    }

    @Override
    public int getAppStateId() {
        return this.appStateId;
    }

    @Override
    public int getOwner() {
        return this.owner;
    }

    @Override
    public int getSpeechMode() {
        return this.speechMode;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("AppState [appStateId=");
        buffer.append(this.getApplicationString(this.appStateId));
        buffer.append(", owner=");
        buffer.append(this.getOwnerString(this.owner));
        buffer.append(", speechMode=");
        buffer.append(this.getSpeechModeString(this.speechMode));
        buffer.append("]");
        return buffer.toString();
    }

    private String getSpeechModeString(int n) {
        switch (n) {
            case 2: {
                return "RECOGNIZING";
            }
            case 1: {
                return "SPEEKING";
            }
        }
        return "UNKNOWN";
    }

    private String getOwnerString(int n) {
        switch (n) {
            case 2: {
                return "DEVICE";
            }
            case 1: {
                return "MAINUNIT";
            }
        }
        return "UNKNOWN";
    }

    private String getApplicationString(int n) {
        switch (n) {
            case 2: {
                return "NAVI";
            }
            case 1: {
                return "PHONE";
            }
            case 3: {
                return "SPEECH";
            }
        }
        return "UNKNOWN";
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.appStateId;
        n = 31 * n + this.owner;
        n = 31 * n + this.speechMode;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AbstractAppState abstractAppState = (AbstractAppState)object;
        if (this.appStateId != abstractAppState.appStateId) {
            return false;
        }
        if (this.owner != abstractAppState.owner) {
            return false;
        }
        return this.speechMode == abstractAppState.speechMode;
    }
}

