/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public interface DSIAsiaInputC {
    public void initialize(int var1) throws MethodException;

    public void addSymbol(char var1) throws MethodException;

    public void addSymbols(String var1) throws MethodException;

    public void removeSymbol() throws MethodException;

    public void removeAllSymbols() throws MethodException;

    public void clear() throws MethodException;

    public void buildCandidates() throws MethodException;

    public void getSpelling() throws MethodException;

    public void getCandidates(int var1) throws MethodException;

    public void selectCandidate(int var1) throws MethodException;

    public void setBooleanParameter(int var1, boolean var2) throws MethodException;

    public void setIntParameter(int var1, int var2) throws MethodException;

    public void getBooleanParameter(int var1) throws MethodException;

    public void getIntParameter(int var1) throws MethodException;

    public void getVersionInfo() throws MethodException;

    public void setStringParameter(int var1, String var2) throws MethodException;

    public void getStringParameter(int var1) throws MethodException;

    public void setPredictionContext(String var1) throws MethodException;

    public void clearPredictionContext() throws MethodException;

    public void addUserDefinedEntry(UserDefinedEntry var1) throws MethodException;

    public void setAdditionalWordDatabases(WordDatabase[] var1) throws MethodException;

    public void setUserDatabaseState(int var1, int var2) throws MethodException;

    public void resetToFactorySettings() throws MethodException;

    public void getSegmentation(String var1) throws MethodException;

    public void requestSegmentationForTruffles(String var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

