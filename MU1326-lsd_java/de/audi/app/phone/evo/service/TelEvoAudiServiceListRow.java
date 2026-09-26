/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.service;

import de.audi.atip.hmi.model.list.EvoListRow;

public class TelEvoAudiServiceListRow
extends EvoListRow {
    static final int MAX_COLUMNS;
    private final int serviceType;

    public TelEvoAudiServiceListRow(long l, int n) {
        super(l, 1);
        this.serviceType = n;
        this.setInteger(0, n);
    }

    @Override
    public EvoListRow copy() {
        return new TelEvoAudiServiceListRow(this.getUniqueID(), this.serviceType);
    }

    public int getServiceType() {
        return this.serviceType;
    }
}

