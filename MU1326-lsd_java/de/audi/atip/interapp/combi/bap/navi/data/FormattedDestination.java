/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

public final class FormattedDestination {
    private final String firstLine;
    private final String secondLine;

    public FormattedDestination(String string, String string2) {
        this.firstLine = string;
        this.secondLine = string2;
    }

    public String getFirstLine() {
        return this.firstLine;
    }

    public String getSecondLine() {
        return this.secondLine;
    }
}

