/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.StringUtilities$Accessor;
import de.esolutions.fw.util.commons.Buffer;

final class StringUtilities$2
implements StringUtilities$Accessor {
    private final /* synthetic */ int[] val$values;

    StringUtilities$2(int[] nArray) {
        this.val$values = nArray;
    }

    @Override
    public int getLength() {
        return this.val$values != null ? this.val$values.length : 0;
    }

    @Override
    public void appendArg(Buffer buffer, int n, int n2) {
        buffer.append(this.val$values != null ? (n >= 0 && n < this.val$values.length ? Integer.toString(this.val$values[n]) : "") : "");
    }
}

