/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import org.dsi.ifc.speechrec.DSISpeechRecListener;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public abstract class AbstractSpeechCommand
extends Command
implements DSISpeechRecListener {
    public AbstractSpeechCommand(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public void responseAbort(int n) {
    }

    public void responseDeleteLastSpellingBlock(int n, NBestList nBestList) {
    }

    public void responseDeleteProfile(int n) {
    }

    public void responseDeleteVoiceTag(int n) {
    }

    public void responseGetVersion(String string) {
    }

    public void responseInit(int n) {
    }

    public void responseInitVoiceTag(int n) {
    }

    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    public void responseLoadProfile(int n) {
    }

    public void responsePreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    public void responseRecordVoiceTag(int n) {
    }

    public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
    }

    public void responseRequestSDSAvailability(int n, int n2) {
    }

    public void responseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSetConfidenceRejectThreshold(int n) {
    }

    public void responseSetFirstLevelSize(int n) {
    }

    public void responseSetLanguage(int n) {
    }

    public void responseSetMaxCommandNBestListSize(int n) {
    }

    public void responseSetMaxSlotNBestListSize(int n) {
    }

    public void responseSetRecognitionTimeout(int n) {
    }

    public void responseSetSpellingMode(int n) {
    }

    public void responseSetUnambiguousResultRange(int n) {
    }

    public void responseSetUnambiguousResultThreshold(int n) {
    }

    public void responseSetUtteranceStartTimeout(int n) {
    }

    public void responseShutdown(int n) {
    }

    public void responseStartDialogue(int n) {
    }

    public void responseStartPostTraining(int n) {
    }

    public void responseStartRecognition(int n) {
    }

    public void responseStopDialogue(int n) {
    }

    public void responseStopPostTraining(int n) {
    }

    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    public void responseUnloadProfile(int n) {
    }

    public void responseUnpreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    public void responseWaitForResults(int n, NBestList nBestList) {
    }

    public void updateAborted(boolean bl, int n) {
    }

    public void updateAbsoluteConfidenceThreshold(int n, int n2) {
    }

    public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    public void updateAvailableProfiles(int[] nArray, int n) {
    }

    public void updateConfidenceRejectThreshold(int n, int n2) {
    }

    public void updateFailure(boolean bl, int n) {
    }

    public void updateFirstLevelSize(int n, int n2) {
    }

    public void updateGrammarStatus(int n, boolean bl, int n2) {
    }

    public void updateLanguage(String string, int n, int n2) {
    }

    public void updateMaxCommandNBestListSize(int n, int n2) {
    }

    public void updateMaxSlotNBestListSize(int n, int n2) {
    }

    public void updateRecognitionTimeout(int n, int n2) {
    }

    public void updateRecognizerState(int n, int n2) {
    }

    public void updateSDSAvailability(int n, int n2) {
    }

    public void updateTemporaryG2PLanguageChangeActive(boolean bl, int n) {
    }

    public void updateUnambiguousResultRange(int n, int n2) {
    }

    public void updateUnambiguousResultThreshold(int n, int n2) {
    }

    public void updateUtteranceStartTimeout(int n, int n2) {
    }

    public void execute() {
    }

    public void updateGrammarState(GrammarStateInfo grammarStateInfo, int n) {
    }

    public void responseSetDictionary(int n) {
    }

    public void responseEnableContinuousUpdate(int n) {
    }

    public void responseCheckDbPartition(int n) {
    }

    public void updateNBestList(NBestList nBestList, int n) {
    }

    public void responseSetASRParameterConfiguration(int n) {
    }

    public void updateASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3, int n) {
    }

    public void responseDeleteLastFlexVDEPart(int n, NBestList nBestList) {
    }

    public void responseClearFlexVDEHistory(int n) {
    }

    public void updateVDEMediumState(int n, int n2) {
    }

    public void updateAvailableSLMLanguages(String[] stringArray, int n) {
    }

    public void updateOnlineCapabilities(String[] stringArray, int n) {
    }
}

