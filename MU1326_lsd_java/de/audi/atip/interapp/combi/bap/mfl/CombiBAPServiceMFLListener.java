/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.mfl;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceMFLListener
extends CombiBAPServiceListener {
    public static final int JOKER_KEY_FUNCTION_SCREENSAVER_ON_OFF_AVAILABLE = 1;
    public static final int JOKER_KEY_FUNCTION_TRAFFIC_SIGNS_ON_OFF_AVAILABLE = 2;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_PHONEBOOK_AVAILABLE = 4;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_AVAILABLE = 8;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION_AVAILABLE = 16;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_DIGITAL_SPEED_AVAILABLE = 32;

    public void setAvailableJokerKeyClusterFunctions(int var1);

    public void confirmCurrentJokerKeyFunctions(int var1, int var2, int var3, int var4, int var5);
}

