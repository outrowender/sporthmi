/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import de.audi.app.terminalmode.util.Streamable$Creator;
import java.util.List;

public interface IStreamableStorageContainer {
    default public List readListFromStorage(Streamable$Creator streamable$Creator) {
    }

    default public void writeListToStorage(List list) {
    }
}

