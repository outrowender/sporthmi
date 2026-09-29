/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;

public interface IMultipleSourceSlotListener {
    default public void slotsChanged(ISource[] iSourceArray) {
    }
}

