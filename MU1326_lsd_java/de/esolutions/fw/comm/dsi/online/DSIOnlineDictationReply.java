/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.DictationValueSentence;

public interface DSIOnlineDictationReply {
    public static final String IPL_COMM_UUID = "8713cd7d-139f-5bf7-8bce-1c82c0b4c605";
    public static final String IPL_COMM_INTERFACE_KEY = "4c75da4a-03db-5a77-9740-90765e5413a6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void dictationResult(int var1) throws MethodException;

    public void finishDictationResponse(int var1) throws MethodException;

    public void dictationValueList(DictationValueSentence var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

