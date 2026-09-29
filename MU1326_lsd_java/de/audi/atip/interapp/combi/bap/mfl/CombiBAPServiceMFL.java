/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.mfl;

import de.audi.atip.interapp.combi.bap.CombiBAPService;

public interface CombiBAPServiceMFL
extends CombiBAPService {
    public static final int JOKER_KEY_1;
    public static final int JOKER_KEY_2;
    public static final int JOKER_KEY_3;
    public static final int JOKER_KEY_4;
    public static final int JOKER_KEY_5;

    default public void updateInstalledKeys(int n) {
    }

    default public void updateCurrentJokerKeyFunction(int n, int n2) {
    }

    default public void updateAvailableJokerKeyClusterFunctions(int n) {
    }
}

