/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;

public interface MatchspellerModelAsiaApp
extends MatchspellerModelApp {
    @Override
    default public void setValidNonAlphaNumTPCharacters(String string) {
    }

    @Override
    default public void setInitialInputMode(int n) {
    }

    @Override
    default public void setAllowNonAlphaNumInput(boolean bl) {
    }

    @Override
    default public void setSpellerListenerAsia(MatchspellerListenerAsia matchspellerListenerAsia) {
    }
}

