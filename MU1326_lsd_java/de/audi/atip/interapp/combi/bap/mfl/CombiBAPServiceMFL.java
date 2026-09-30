/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.mfl;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceMFL
extends CombiBAPService {
    public static final int JOKER_KEY_1 = 1;
    public static final int JOKER_KEY_2 = 2;
    public static final int JOKER_KEY_3 = 4;
    public static final int JOKER_KEY_4 = 8;
    public static final int JOKER_KEY_5 = 16;

    public void updateInstalledKeys(int var1);

    public void updateCurrentJokerKeyFunction(int var1, int var2);

    public void updateAvailableJokerKeyClusterFunctions(int var1);
}

