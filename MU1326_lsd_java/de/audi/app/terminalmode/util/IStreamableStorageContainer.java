/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.Streamable;
import java.util.List;

public interface IStreamableStorageContainer {
    public List readListFromStorage(Streamable.Creator var1);

    public void writeListToStorage(List var1);
}

