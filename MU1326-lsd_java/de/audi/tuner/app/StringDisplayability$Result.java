/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.StringDisplayability$1;

public class StringDisplayability$Result {
    public final int length;
    public final int numNotDisplayable;

    private StringDisplayability$Result(int n, int n2, int n3) {
        this.length = n;
        this.numNotDisplayable = n3;
    }

    /* synthetic */ StringDisplayability$Result(int n, int n2, int n3, StringDisplayability$1 stringDisplayability$1) {
        this(n, n2, n3);
    }
}

