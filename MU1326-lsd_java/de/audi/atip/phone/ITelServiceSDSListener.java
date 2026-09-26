/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.phone.ITelServiceListener;

public interface ITelServiceSDSListener
extends ITelServiceListener {
    default public void unlockSIMResponse(int n) {
    }

    default public void setMailboxResponse(int n) {
    }
}

