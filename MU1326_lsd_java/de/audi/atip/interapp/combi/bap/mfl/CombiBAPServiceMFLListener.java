/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.mfl;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceMFLListener
extends CombiBAPServiceListener {
    public static final int JOKER_KEY_FUNCTION_SCREENSAVER_ON_OFF_AVAILABLE;
    public static final int JOKER_KEY_FUNCTION_TRAFFIC_SIGNS_ON_OFF_AVAILABLE;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_PHONEBOOK_AVAILABLE;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_LAST_DESTINATIONS_AVAILABLE;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_TRAFFIC_SIGN_INFORMATION_AVAILABLE;
    public static final int JOKER_KEY_FUNCTION_CONTEXT_SWITCH_TO_DIGITAL_SPEED_AVAILABLE;

    default public void setAvailableJokerKeyClusterFunctions(int n) {
    }

    default public void confirmCurrentJokerKeyFunctions(int n, int n2, int n3, int n4, int n5) {
    }
}

