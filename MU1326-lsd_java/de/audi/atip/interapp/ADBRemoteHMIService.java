/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBRemoteHMIAddress;

public interface ADBRemoteHMIService {
    default public int[] getListModelIDs() {
    }

    default public ADBRemoteHMIAddress getAddress(EvoListRow evoListRow) {
    }
}

