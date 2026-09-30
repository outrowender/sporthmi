/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.state.ISourceStateUpdater;

public interface ISourceStateHandler {
    public void registerSource(ISource var1);

    public void addSourceSlotListener(IMultipleSourceSlotListener var1);

    public void addSourceSlotListener(ISource var1, ISourceSlotListener var2, boolean var3);

    public void removeSlotListener(ISource var1, ISourceSlotListener var2);

    public ISourceStateUpdater getSourceStateUpdater();
}

