/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.LogAppender;
import de.esolutions.fw.util.commons.Buffer;

final class LogAppender$Factory$2
implements LogAppender {
    private final /* synthetic */ Object val$o;
    private final /* synthetic */ int val$estimatedLength;

    LogAppender$Factory$2(Object object, int n) {
        this.val$o = object;
        this.val$estimatedLength = n;
    }

    @Override
    public int getEstimatedLength() {
        return this.val$o == null ? 0 : this.val$estimatedLength;
    }

    @Override
    public void appendTo(Buffer buffer) {
        if (this.val$o != null) {
            buffer.append(this.val$o);
        }
    }
}

