/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.grammar.ITTSASRAppContext;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.command.CommandListManager;

public interface ITTSASR
extends TTSASR {
    public ITTSASRAppContext createAppGrammarContext();

    public void setCommandListManager(CommandListManager var1);

    public void setSlotGrammarContext(ITTSASRContext var1);

    public void reloadGrammarContext(ITTSASRContext var1);
}

