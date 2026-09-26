/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

public class StringHighlighter$HighlightingResult {
    public String matchText;
    public int beginIndex;
    public int endIndex;

    public StringHighlighter$HighlightingResult(String string, int n, int n2) {
        this.matchText = string;
        this.beginIndex = n;
        this.endIndex = n2;
    }

    public int[] getHighlightArea() {
        return new int[]{this.beginIndex, this.endIndex};
    }
}

