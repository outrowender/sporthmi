/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.atip.statemachine.sds.ITTSASRContext;

public interface ITTSASRAppContext
extends ITTSASRContext {
    default public void addToGrammar(int n, String string) {
    }

    default public String getSRGSString(int n) {
    }
}

