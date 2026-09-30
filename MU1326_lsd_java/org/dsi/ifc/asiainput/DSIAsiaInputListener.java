/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiainput;

import org.dsi.ifc.base.DSIListener;

public interface DSIAsiaInputListener
extends DSIListener {
    public void initialized(int var1);

    public void getVersionInfo(String var1, String var2);

    public void builtCandidates(int var1);

    public void getSpelling(String var1);

    public void getCandidates(String[] var1);

    public void selectedCandidate(int var1, int var2);

    public void indicateErrorStatus(int var1);

    public void indicateDataInvalidated(int var1);

    public void getIntParameter(int var1, int var2);

    public void getBooleanParameter(int var1, boolean var2);

    public void setIntParameterResult(int var1, int var2, int var3);

    public void setBooleanParameterResult(int var1, boolean var2, int var3);

    public void setStringParameterResult(int var1, String var2, int var3);

    public void getStringParameter(int var1, String var2);

    public void setAdditionalWordDatabasesResult(int var1);

    public void setUserDatabaseStateResult(int var1, int var2, int var3);

    public void resetToFactorySettingsResult(int var1);

    public void getSegmentation(String var1);

    public void responseSegmentationForTruffles(String var1);
}

