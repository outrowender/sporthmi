/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.esolutions.fw.util.commons.Buffer;

public class AudioState {
    private final int state;
    private final int connection;

    public AudioState(int n, int n2) {
        this.connection = n;
        this.state = n2;
    }

    public int getState() {
        return this.state;
    }

    public int getConnection() {
        return this.connection;
    }

    public boolean isAudible() {
        return this.state == 4 || this.state == 2;
    }

    public boolean equals(Object object) {
        try {
            return ((AudioState)object).connection == this.connection && ((AudioState)object).state == this.state;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return this.connection;
    }

    private static String getStateStr(int n) {
        switch (n) {
            case 6: {
                return "ERROR";
            }
            case 4: {
                return "FADEDIN";
            }
            case 3: {
                return "PAUSED";
            }
            case 2: {
                return "STARTED";
            }
            case 5: {
                return "STOPPED";
            }
            case 0: {
                return "UNDEFINED";
            }
        }
        return "UNKNOWN (" + n + ")";
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("'").append(this.connection).append("','").append(AudioState.getStateStr(this.state)).append("'");
        return buffer.toString();
    }
}

