/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelEcallService {
    public void hangupServiceCall();

    public void hangupLowPrioritySOSCall();

    public void dialLowPrioritySOSCall(String var1);
}

