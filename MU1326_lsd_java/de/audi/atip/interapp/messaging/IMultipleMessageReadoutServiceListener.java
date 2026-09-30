/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging;

public interface IMultipleMessageReadoutServiceListener {
    public void responseBeginDialog(int var1);

    public void responseNextMessage(int var1, String var2);

    public void responseEndDialog(int var1);
}

