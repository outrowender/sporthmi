/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.waveplayer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIWavePlayerReply {
    public static final String IPL_COMM_UUID = "769ce35c-50ad-5d34-9ac5-cfccf1aedd73";
    public static final String IPL_COMM_INTERFACE_KEY = "353ec8df-dc25-5139-a159-43eaf2ee00e4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.7";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.7";

    public void updatePlayTone(int var1, int var2) throws MethodException;

    public void updateAudioRequest(int var1, int var2) throws MethodException;

    public void setPlayTone(int var1) throws MethodException;

    public void audioTriggerResponse(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

