/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;

public interface ISourceListener {
    default public void sourceAvailable(ISource iSource, boolean bl) {
    }
}

