/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.radio;

public interface IHistoryVetoService {
    public static final int VETO_FROM_RADIO = 0;
    public static final int VETO_FROM_TV = 1;
    public static final int MAX_VETOS = 2;
    public static final IHistoryVetoService NULL_INSTANCE = new IHistoryVetoService(){

        public void updateVeto(int n, boolean bl) {
        }
    };

    public void updateVeto(int var1, boolean var2);
}

