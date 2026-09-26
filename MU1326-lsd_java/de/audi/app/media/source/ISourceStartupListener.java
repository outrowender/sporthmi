/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface ISourceStartupListener {
    default public void sourceStartupFinished(ISourceSlot iSourceSlot) {
    }
}

