/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAsiaInputReply {
    public static final String IPL_COMM_UUID = "fbfa7ec2-cf7e-5410-bf3b-2435ecaa2283";
    public static final String IPL_COMM_INTERFACE_KEY = "5629fd5e-f29a-577a-b6bd-f10203c96186";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public void initialized(int var1) throws MethodException;

    public void getVersionInfo(String var1, String var2) throws MethodException;

    public void builtCandidates(int var1) throws MethodException;

    public void getSpelling(String var1) throws MethodException;

    public void getCandidates(String[] var1) throws MethodException;

    public void selectedCandidate(int var1, int var2) throws MethodException;

    public void indicateErrorStatus(int var1) throws MethodException;

    public void indicateDataInvalidated(int var1) throws MethodException;

    public void getIntParameter(int var1, int var2) throws MethodException;

    public void getBooleanParameter(int var1, boolean var2) throws MethodException;

    public void setIntParameterResult(int var1, int var2, int var3) throws MethodException;

    public void setBooleanParameterResult(int var1, boolean var2, int var3) throws MethodException;

    public void setStringParameterResult(int var1, String var2, int var3) throws MethodException;

    public void getStringParameter(int var1, String var2) throws MethodException;

    public void setAdditionalWordDatabasesResult(int var1) throws MethodException;

    public void setUserDatabaseStateResult(int var1, int var2, int var3) throws MethodException;

    public void resetToFactorySettingsResult(int var1) throws MethodException;

    public void getSegmentation(String var1) throws MethodException;

    public void responseSegmentationForTruffles(String var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

