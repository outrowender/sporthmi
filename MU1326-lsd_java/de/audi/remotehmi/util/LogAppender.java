/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.esolutions.fw.util.commons.Buffer;

public interface LogAppender {
    default public void appendTo(Buffer buffer) {
    }

    default public int getEstimatedLength() {
    }
}

