/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.IInquiry;

public interface IEvoInquiry
extends IInquiry {
    public void abortInquiry(int var1);

    public void prepareServiceSpecificInquiry(int var1, boolean var2);
}

