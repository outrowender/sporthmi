/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SDSODPADBService;

public interface SDSODPADBServiceListener {
    public void responseGetEntry(byte var1, SDSODPADBService.ADBEntry var2);

    public void responseOpenEntryDetails(byte var1);
}

