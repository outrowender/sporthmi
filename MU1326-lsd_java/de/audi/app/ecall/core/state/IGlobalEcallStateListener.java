/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.state;

import de.audi.app.ecall.core.state.IEcallStateStruct;

public interface IGlobalEcallStateListener {
    default public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
    }
}

