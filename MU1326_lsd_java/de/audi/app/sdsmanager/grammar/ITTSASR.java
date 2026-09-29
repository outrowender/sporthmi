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
    default public ITTSASRAppContext createAppGrammarContext() {
    }

    default public void setCommandListManager(CommandListManager commandListManager) {
    }

    default public void setSlotGrammarContext(ITTSASRContext iTTSASRContext) {
    }

    default public void reloadGrammarContext(ITTSASRContext iTTSASRContext) {
    }
}

