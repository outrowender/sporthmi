/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;

public interface MatchspellerModelAsiaApp
extends MatchspellerModelApp {
    public void setValidNonAlphaNumTPCharacters(String var1);

    public void setInitialInputMode(int var1);

    public void setAllowNonAlphaNumInput(boolean var1);

    public void setSpellerListenerAsia(MatchspellerListenerAsia var1);
}

