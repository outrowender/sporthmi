/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface ISourceChangeListener {
    default public boolean handleConcurrentIPodConnection(ISourceSlot iSourceSlot, ISourceSlot iSourceSlot2) {
    }
}

