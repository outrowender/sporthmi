/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.ArrayHeaderConfigurator;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.vw.mib.bap.requests.GetArray;

public final class ArrayUtilsASG {
    public static void requestArrayElements(BAPFunctionArrayASG bAPFunctionArrayASG, int n, int n2, boolean bl, GetArray getArray) {
        ArrayHeaderConfigurator.forThis(getArray.getArrayHeader()).getElements(n, n2, bl);
        bAPFunctionArrayASG.getArrayREQ(getArray);
    }

    public static void requestNextArrayElements(BAPFunctionArrayASG bAPFunctionArrayASG, int n, int n2, int n3, boolean bl, GetArray getArray) {
        ArrayHeaderConfigurator.forThis(getArray.getArrayHeader()).getFollowingElements(n, n2, n3, bl);
        bAPFunctionArrayASG.getArrayREQ(getArray);
    }
}

