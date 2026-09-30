/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;

public interface ISourceActivationExtension {
    public boolean slotsChanged(ISource[] var1, ISourceSlot var2);
}

