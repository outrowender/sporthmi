/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.IInquiry;

public interface IEvoInquiry
extends IInquiry {
    default public void abortInquiry(int n) {
    }

    default public void prepareServiceSpecificInquiry(int n, boolean bl) {
    }
}

