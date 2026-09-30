/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface ISourceChangeListener {
    public boolean handleConcurrentIPodConnection(ISourceSlot var1, ISourceSlot var2);
}

