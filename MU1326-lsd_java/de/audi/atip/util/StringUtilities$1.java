/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.StringUtilities$Accessor;
import de.esolutions.fw.util.commons.Buffer;

final class StringUtilities$1
implements StringUtilities$Accessor {
    private final /* synthetic */ String[] val$values;

    StringUtilities$1(String[] stringArray) {
        this.val$values = stringArray;
    }

    @Override
    public int getLength() {
        return this.val$values != null ? this.val$values.length : 0;
    }

    @Override
    public void appendArg(Buffer buffer, int n, int n2) {
        buffer.append(this.val$values != null ? (n >= 0 && n < this.val$values.length ? this.val$values[n] : "") : "");
    }
}

