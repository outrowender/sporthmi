/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.metrics.ByteSize;

public final class ByteSizeProvider {
    static ByteSize getByteSize(long l) {
        if (l == 0L) {
            return new ByteSize(l, 43);
        }
        return new ByteSize(l, 1, false);
    }
}

