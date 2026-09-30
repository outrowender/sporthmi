/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public interface DSISpeechRecReply {
    public static final String IPL_COMM_UUID = "79eee404-4c40-56c5-8364-199e1f7288f9";
    public static final String IPL_COMM_INTERFACE_KEY = "16e45b2a-c0be-56b6-af24-bf8bb01263ef";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.25";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.25";

    public void responseAbort(int var1) throws MethodException;

    public void responseDeleteProfile(int var1) throws MethodException;

    public void responseDeleteVoiceTag(int var1) throws MethodException;

    public void responseEnableContinuousUpdate(int var1) throws MethodException;

    public void responseGetVersion(String var1) throws MethodException;

    public void responseInit(int var1) throws MethodException;

    public void responseInitVoiceTag(int var1) throws MethodException;

    public void responseLoadGrammar(int var1, GrammarInfo[] var2) throws MethodException;

    public void responseLoadProfile(int var1) throws MethodException;

    public void responsePreloadGrammar(int var1, GrammarInfo[] var2) throws MethodException;

    public void responseRecordVoiceTag(int var1) throws MethodException;

    public void responseSetLanguage(int var1) throws MethodException;

    public void responseShutdown(int var1) throws MethodException;

    public void responseStartRecognition(int var1) throws MethodException;

    public void responseUnloadGrammar(int var1, GrammarInfo[] var2) throws MethodException;

    public void responseUnloadProfile(int var1) throws MethodException;

    public void responseUnpreloadGrammar(int var1, GrammarInfo[] var2) throws MethodException;

    public void responseWaitForResults(int var1, NBestList var2) throws MethodException;

    public void updateAborted(boolean var1, int var2) throws MethodException;

    public void updateAvailableLanguages(String[] var1, int var2) throws MethodException;

    public void updateAvailableProfiles(int[] var1, int var2) throws MethodException;

    public void updateFailure(boolean var1, int var2) throws MethodException;

    public void updateLanguage(String var1, int var2, int var3) throws MethodException;

    public void updateRecognizerState(int var1, int var2) throws MethodException;

    public void updateAbsoluteConfidenceThreshold(int var1, int var2) throws MethodException;

    public void responseSetMaxCommandNBestListSize(int var1) throws MethodException;

    public void updateMaxCommandNBestListSize(int var1, int var2) throws MethodException;

    public void responseSetMaxSlotNBestListSize(int var1) throws MethodException;

    public void updateMaxSlotNBestListSize(int var1, int var2) throws MethodException;

    public void responseSetConfidenceRejectThreshold(int var1) throws MethodException;

    public void updateConfidenceRejectThreshold(int var1, int var2) throws MethodException;

    public void responseSetUtteranceStartTimeout(int var1) throws MethodException;

    public void updateUtteranceStartTimeout(int var1, int var2) throws MethodException;

    public void responseSetRecognitionTimeout(int var1) throws MethodException;

    public void updateRecognitionTimeout(int var1, int var2) throws MethodException;

    public void responseSetUnambiguousResultThreshold(int var1) throws MethodException;

    public void updateUnambiguousResultThreshold(int var1, int var2) throws MethodException;

    public void responseSetUnambiguousResultRange(int var1) throws MethodException;

    public void updateUnambiguousResultRange(int var1, int var2) throws MethodException;

    public void responseSetFirstLevelSize(int var1) throws MethodException;

    public void updateFirstLevelSize(int var1, int var2) throws MethodException;

    public void responseStartPostTraining(int var1) throws MethodException;

    public void responseStopPostTraining(int var1) throws MethodException;

    public void responseRequestSDSAvailability(int var1, int var2) throws MethodException;

    public void updateSDSAvailability(int var1, int var2) throws MethodException;

    public void responseSetSpellingMode(int var1) throws MethodException;

    public void responseDeleteLastSpellingBlock(int var1, NBestList var2) throws MethodException;

    public void responseStartDialogue(int var1) throws MethodException;

    public void responseStopDialogue(int var1) throws MethodException;

    public void updateGrammarStatus(int var1, boolean var2, int var3) throws MethodException;

    public void updateGrammarState(GrammarStateInfo var1, int var2) throws MethodException;

    public void updateTemporaryG2PLanguageChangeActive(boolean var1, int var2) throws MethodException;

    public void responseCheckDbPartition(int var1) throws MethodException;

    public void responseRequestGraphemicGroupAsNBestList(int var1, NBestList var2) throws MethodException;

    public void responseRequestVDECapabilities(int var1, VDECapabilities var2) throws MethodException;

    public void responseRestoreFactorySettings(int var1) throws MethodException;

    public void responseSetDictionary(int var1) throws MethodException;

    public void updateNBestList(NBestList var1, int var2) throws MethodException;

    public void responseSetASRParameterConfiguration(int var1) throws MethodException;

    public void updateASRParameterConfiguration(int[] var1, int[] var2, int[] var3, int var4) throws MethodException;

    public void responseDeleteLastFlexVDEPart(int var1, NBestList var2) throws MethodException;

    public void responseClearFlexVDEHistory(int var1) throws MethodException;

    public void updateVDEMediumState(int var1, int var2) throws MethodException;

    public void updateAvailableSLMLanguages(String[] var1, int var2) throws MethodException;

    public void updateOnlineCapabilities(String[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

