/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;

public interface ISourceActivationExtension {
    default public boolean slotsChanged(ISource[] iSourceArray, ISourceSlot iSourceSlot) {
    }
}

