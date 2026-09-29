/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.radio;

import de.audi.atip.interapp.radio.IHistoryVetoService$1;

public interface IHistoryVetoService {
    public static final int VETO_FROM_RADIO;
    public static final int VETO_FROM_TV;
    public static final int MAX_VETOS;
    public static final IHistoryVetoService NULL_INSTANCE;

    default public void updateVeto(int n, boolean bl) {
    }

    static {
        NULL_INSTANCE = new IHistoryVetoService$1();
    }
}

