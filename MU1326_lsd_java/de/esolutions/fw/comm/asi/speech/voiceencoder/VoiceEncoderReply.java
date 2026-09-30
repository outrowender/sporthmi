/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder;

import de.esolutions.fw.comm.core.method.MethodException;

public interface VoiceEncoderReply {
    public static final String IPL_COMM_UUID = "6cfdcd5d-a243-4e89-ac17-88fd405b152c";
    public static final String IPL_COMM_INTERFACE_KEY = "20498df5-80e6-5c41-b816-715e2be26dfe";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void voiceDataAvailable(int var1, long var2) throws MethodException;
}

