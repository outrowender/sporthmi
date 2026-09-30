/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public interface DSISpeechRecC {
    public void abort() throws MethodException;

    public void deleteProfile(int var1) throws MethodException;

    public void deleteVoiceTag(int var1) throws MethodException;

    public void enableContinuousUpdate(boolean var1) throws MethodException;

    public void getVersion() throws MethodException;

    public void init() throws MethodException;

    public void initVoiceTag(int var1) throws MethodException;

    public void loadGrammar(Grammar[] var1) throws MethodException;

    public void loadProfile(int var1) throws MethodException;

    public void preloadGrammar(Grammar[] var1) throws MethodException;

    public void recordVoiceTag() throws MethodException;

    public void setLanguage(String var1, int var2) throws MethodException;

    public void shutdown() throws MethodException;

    public void startRecognition(int var1, int var2, int var3) throws MethodException;

    public void unloadGrammar(GrammarInfo[] var1) throws MethodException;

    public void unloadProfile(int var1) throws MethodException;

    public void unpreloadGrammar(GrammarInfo[] var1) throws MethodException;

    public void waitForResults() throws MethodException;

    public void setMaxCommandNBestListSize(int var1) throws MethodException;

    public void setMaxSlotNBestListSize(int var1) throws MethodException;

    public void setRecognitionTimeout(int var1) throws MethodException;

    public void setUnambiguousResultThreshold(int var1) throws MethodException;

    public void setUnambiguousResultRange(int var1) throws MethodException;

    public void setFirstLevelSize(int var1) throws MethodException;

    public void startPostTraining(int var1) throws MethodException;

    public void stopPostTraining() throws MethodException;

    public void requestSDSAvailability() throws MethodException;

    public void setSpellingMode(int var1) throws MethodException;

    public void deleteLastSpellingBlock() throws MethodException;

    public void startDialogue() throws MethodException;

    public void stopDialogue() throws MethodException;

    public void requestCheckDbPartition() throws MethodException;

    public void requestGraphemicGroupAsNBestList(int var1) throws MethodException;

    public void requestVDECapabilities(String var1) throws MethodException;

    public void requestRestoreFactorySettings() throws MethodException;

    public void setDictionary(int var1, String var2, String var3, DictionaryEntry[] var4) throws MethodException;

    public void setASRParameterConfiguration(int[] var1, int[] var2, int[] var3) throws MethodException;

    public void deleteLastFlexVDEPart() throws MethodException;

    public void clearFlexVDEHistory() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

