/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.LogAppender;
import de.esolutions.fw.util.commons.Buffer;

final class LogAppender$Factory$3
implements LogAppender {
    private final /* synthetic */ String val$label;
    private final /* synthetic */ int val$i;

    LogAppender$Factory$3(String string, int n) {
        this.val$label = string;
        this.val$i = n;
    }

    @Override
    public int getEstimatedLength() {
        return 16 + (this.val$label == null ? 0 : this.val$label.length());
    }

    @Override
    public void appendTo(Buffer buffer) {
        if (this.val$label != null && this.val$label.length() > 0) {
            buffer.append(this.val$label);
            buffer.append("=");
        }
        buffer.append(this.val$i);
    }
}

