/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SDSODPADBService$ADBEntry;

public interface SDSODPADBServiceListener {
    default public void responseGetEntry(byte by, SDSODPADBService.ADBEntry aDBEntry) {
    }

    default public void responseOpenEntryDetails(byte by) {
    }
}

