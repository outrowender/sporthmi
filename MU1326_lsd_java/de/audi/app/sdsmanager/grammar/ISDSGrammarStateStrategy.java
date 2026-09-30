/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

public interface ISDSGrammarStateStrategy {
    public byte getGrammarStatus();

    public byte getGrammarStatusForMedia();

    public boolean isGrammarStatusCompiling();
}

