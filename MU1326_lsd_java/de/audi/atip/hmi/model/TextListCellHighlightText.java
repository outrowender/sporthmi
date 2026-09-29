/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

public class TextListCellHighlightText
extends TextListCell
implements ListCell {
    private int[] highlightArea = null;

    public TextListCellHighlightText(String string, int[] nArray) {
        super(string);
        this.highlightArea = nArray;
    }

    @Override
    public String toString() {
        String string = super.toString();
        Buffer buffer = new Buffer();
        buffer.append("text: ");
        buffer.append(string);
        buffer.append(", highlightArea: ");
        buffer.append(Util.arrayToString(this.highlightArea));
        return buffer.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !(object instanceof TextListCellHighlightText)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        int[] nArray = ((TextListCellHighlightText)object).highlightArea;
        if (this.highlightArea == nArray) {
            return true;
        }
        if (this.highlightArea == null || nArray == null) {
            return false;
        }
        return Arrays.equals(this.highlightArea, nArray);
    }

    @Override
    public int hashCode() {
        int n = this.highlightArea == null ? 0 : this.highlightArea.hashCode();
        return n * 31 + super.hashCode();
    }

    public int[] getHighlightArea() {
        return this.highlightArea;
    }
}

