/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public interface DSISpeechRecListener
extends DSIListener {
    public void responseAbort(int var1);

    public void responseDeleteProfile(int var1);

    public void responseDeleteVoiceTag(int var1);

    public void responseEnableContinuousUpdate(int var1);

    public void responseGetVersion(String var1);

    public void responseInit(int var1);

    public void responseInitVoiceTag(int var1);

    public void responseLoadGrammar(int var1, GrammarInfo[] var2);

    public void responseLoadProfile(int var1);

    public void responsePreloadGrammar(int var1, GrammarInfo[] var2);

    public void responseRecordVoiceTag(int var1);

    public void responseSetLanguage(int var1);

    public void responseShutdown(int var1);

    public void responseStartRecognition(int var1);

    public void responseUnloadGrammar(int var1, GrammarInfo[] var2);

    public void responseUnloadProfile(int var1);

    public void responseUnpreloadGrammar(int var1, GrammarInfo[] var2);

    public void responseWaitForResults(int var1, NBestList var2);

    public void updateAborted(boolean var1, int var2);

    public void updateAvailableLanguages(String[] var1, int var2);

    public void updateAvailableProfiles(int[] var1, int var2);

    public void updateFailure(boolean var1, int var2);

    public void updateLanguage(String var1, int var2, int var3);

    public void updateRecognizerState(int var1, int var2);

    public void updateAbsoluteConfidenceThreshold(int var1, int var2);

    public void responseSetMaxCommandNBestListSize(int var1);

    public void updateMaxCommandNBestListSize(int var1, int var2);

    public void responseSetMaxSlotNBestListSize(int var1);

    public void updateMaxSlotNBestListSize(int var1, int var2);

    public void responseSetConfidenceRejectThreshold(int var1);

    public void updateConfidenceRejectThreshold(int var1, int var2);

    public void responseSetUtteranceStartTimeout(int var1);

    public void updateUtteranceStartTimeout(int var1, int var2);

    public void responseSetRecognitionTimeout(int var1);

    public void updateRecognitionTimeout(int var1, int var2);

    public void responseSetUnambiguousResultThreshold(int var1);

    public void updateUnambiguousResultThreshold(int var1, int var2);

    public void responseSetUnambiguousResultRange(int var1);

    public void updateUnambiguousResultRange(int var1, int var2);

    public void responseSetFirstLevelSize(int var1);

    public void updateFirstLevelSize(int var1, int var2);

    public void responseStartPostTraining(int var1);

    public void responseStopPostTraining(int var1);

    public void responseRequestSDSAvailability(int var1, int var2);

    public void updateSDSAvailability(int var1, int var2);

    public void responseSetSpellingMode(int var1);

    public void responseDeleteLastSpellingBlock(int var1, NBestList var2);

    public void responseStartDialogue(int var1);

    public void responseStopDialogue(int var1);

    public void updateGrammarStatus(int var1, boolean var2, int var3);

    public void updateGrammarState(GrammarStateInfo var1, int var2);

    public void updateTemporaryG2PLanguageChangeActive(boolean var1, int var2);

    public void responseCheckDbPartition(int var1);

    public void responseRequestGraphemicGroupAsNBestList(int var1, NBestList var2);

    public void responseRequestVDECapabilities(int var1, VDECapabilities var2);

    public void responseRestoreFactorySettings(int var1);

    public void responseSetDictionary(int var1);

    public void updateNBestList(NBestList var1, int var2);

    public void responseSetASRParameterConfiguration(int var1);

    public void updateASRParameterConfiguration(int[] var1, int[] var2, int[] var3, int var4);

    public void responseDeleteLastFlexVDEPart(int var1, NBestList var2);

    public void responseClearFlexVDEHistory(int var1);

    public void updateVDEMediumState(int var1, int var2);

    public void updateAvailableSLMLanguages(String[] var1, int var2);

    public void updateOnlineCapabilities(String[] var1, int var2);
}

