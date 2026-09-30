/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.diagnosis;

public interface IDiagnosisCommandProvider {
    public String[] getDiagKeys();

    public void executeDiagCommand(String var1, String[] var2);
}

