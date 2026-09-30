/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.AddressInputUtil;

public final class AddressInputUtilEvo {
    private AddressInputUtilEvo() {
    }

    public static boolean isInPOIRelatedContext(NavigationEnv navigationEnv) {
        boolean bl = navigationEnv.getChoiceModel(401824).getValue() == 1 || AddressInputUtil.getNewSearchAreaContextChoiceValue(navigationEnv) == 1 || AddressInputUtil.getNewSearchAreaContextChoiceValue(navigationEnv) == 2;
        return bl;
    }

    public static boolean isOnlineOrNormalPOIContext(NavigationEnv navigationEnv) {
        boolean bl = navigationEnv.getChoiceModel(401824).getValue() == 1 || AddressInputUtil.getNewSearchAreaContextChoiceValue(navigationEnv) == 1;
        return bl;
    }

    public static boolean isNormalPOIContext(NavigationEnv navigationEnv) {
        boolean bl = navigationEnv.getChoiceModel(401824).getValue() == 1;
        return bl;
    }

    public static boolean isOnlinePOIContext(NavigationEnv navigationEnv) {
        boolean bl = AddressInputUtil.getNewSearchAreaContextChoiceValue(navigationEnv) == 1;
        return bl;
    }

    public static boolean isRemoteHMIPOIContext(NavigationEnv navigationEnv) {
        boolean bl = AddressInputUtil.getNewSearchAreaContextChoiceValue(navigationEnv) == 2;
        return bl;
    }
}

