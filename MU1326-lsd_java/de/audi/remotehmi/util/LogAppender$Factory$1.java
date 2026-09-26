/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.LogAppender;
import de.esolutions.fw.util.commons.Buffer;

final class LogAppender$Factory$1
implements LogAppender {
    private final /* synthetic */ String val$s;

    LogAppender$Factory$1(String string) {
        this.val$s = string;
    }

    @Override
    public int getEstimatedLength() {
        return this.val$s == null ? 0 : this.val$s.length();
    }

    @Override
    public void appendTo(Buffer buffer) {
        if (this.val$s != null) {
            buffer.append(this.val$s);
        }
    }
}

