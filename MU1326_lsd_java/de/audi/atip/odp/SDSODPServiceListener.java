/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.NBestListResult;

public interface SDSODPServiceListener {
    public void dialogSessionAborted();

    public void responseEndDialogSession();

    public void responseStartDialogSession();

    public void dialogSessionPaused();

    public void languageChanged(String var1);

    public void eventSent(int var1);

    public void screenChanged(int var1);

    public void lineSelected(int var1);

    public void responseLoadGrammar(byte var1);

    public void responseUnloadGrammar(byte var1);

    public void responseStartRecognition(byte var1, NBestListResult[] var2);

    public void responsePlayPrompt(byte var1);
}

