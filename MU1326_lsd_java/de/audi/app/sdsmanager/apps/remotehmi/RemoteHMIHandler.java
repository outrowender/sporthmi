/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.atip.interapp.OnlineService;

public interface RemoteHMIHandler
extends ISDSApplication {
    public void setOnlineService(OnlineService var1);

    public void unsetOnlineService();

    public void setSelectedHelpLine(int var1);

    public int getSelectedHelpLine();

    public void setTTSASR(ITTSASR var1);

    public boolean isGrammarReloadTriggered();

    public void resetGrammarReloadTriggered();
}

