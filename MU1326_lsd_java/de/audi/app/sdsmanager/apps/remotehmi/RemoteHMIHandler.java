/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.atip.interapp.OnlineService;

public interface RemoteHMIHandler
extends ISDSApplication {
    default public void setOnlineService(OnlineService onlineService) {
    }

    default public void unsetOnlineService() {
    }

    default public void setSelectedHelpLine(int n) {
    }

    default public int getSelectedHelpLine() {
    }

    default public void setTTSASR(ITTSASR iTTSASR) {
    }

    default public boolean isGrammarReloadTriggered() {
    }

    default public void resetGrammarReloadTriggered() {
    }
}

