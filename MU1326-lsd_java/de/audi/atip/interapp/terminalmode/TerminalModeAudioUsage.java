/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

public class TerminalModeAudioUsage {
    public static final int AUDIOTYPE_RINGTONE;
    public static final int AUDIOTYPE_PHONECALL;
    private final int type;
    private final boolean inUse;

    public TerminalModeAudioUsage(int n, boolean bl) {
        this.type = n;
        this.inUse = bl;
    }

    public int getType() {
        return this.type;
    }

    public boolean isInUse() {
        return this.inUse;
    }

    public String toString() {
        return new StringBuffer().append("TerminalModeAudioUsage [type=").append(this.type).append(", inUse=").append(this.inUse).append("]").toString();
    }
}

