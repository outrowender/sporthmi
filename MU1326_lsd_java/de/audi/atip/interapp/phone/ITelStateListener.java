/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.phone.ITelState;

public interface ITelStateListener {
    default public void updateTelState(int n, ITelState iTelState) {
    }
}

