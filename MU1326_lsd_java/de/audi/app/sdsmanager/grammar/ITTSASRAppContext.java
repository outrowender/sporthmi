/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.atip.statemachine.sds.ITTSASRContext;

public interface ITTSASRAppContext
extends ITTSASRContext {
    public void addToGrammar(int var1, String var2);

    public String getSRGSString(int var1);
}

