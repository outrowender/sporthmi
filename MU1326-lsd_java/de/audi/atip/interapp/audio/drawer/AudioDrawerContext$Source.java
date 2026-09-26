/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$1;

public final class AudioDrawerContext$Source {
    private final String source;
    private final int column;

    private AudioDrawerContext$Source(String string, int n) {
        this.source = string;
        this.column = n;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return this.source;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.column;
        n = 31 * n + (this.source == null ? 0 : this.source.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AudioDrawerContext$Source)) {
            return false;
        }
        AudioDrawerContext$Source audioDrawerContext$Source = (AudioDrawerContext$Source)object;
        if (this.column != audioDrawerContext$Source.column) {
            return false;
        }
        return !(this.source == null ? audioDrawerContext$Source.source != null : !this.source.equals(audioDrawerContext$Source.source));
    }

    /* synthetic */ AudioDrawerContext$Source(String string, int n, AudioDrawerContext$1 audioDrawerContext$1) {
        this(string, n);
    }
}

