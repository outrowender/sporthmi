/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.cas.CasIDs;

public class StationStatus {
    public final int casState;
    public final int muteState;

    public StationStatus(int n, int n2) {
        this.casState = n;
        this.muteState = n2;
    }

    public boolean isOK() {
        return this.muteState == 0 && CasIDs.isOK(this.casState);
    }
}

