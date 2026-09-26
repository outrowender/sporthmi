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

    @Override
    public void responseAbort(int n) {
    }

    @Override
    public void responseDeleteLastSpellingBlock(int n, NBestList nBestList) {
    }

    @Override
    public void responseDeleteProfile(int n) {
    }

    @Override
    public void responseDeleteVoiceTag(int n) {
    }

    @Override
    public void responseGetVersion(String string) {
    }

    @Override
    public void responseInit(int n) {
    }

    @Override
    public void responseInitVoiceTag(int n) {
    }

    @Override
    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void responseLoadProfile(int n) {
    }

    @Override
    public void responsePreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void responseRecordVoiceTag(int n) {
    }

    @Override
    public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
    }

    @Override
    public void responseRequestSDSAvailability(int n, int n2) {
    }

    @Override
    public void responseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSetConfidenceRejectThreshold(int n) {
    }

    @Override
    public void responseSetFirstLevelSize(int n) {
    }

    @Override
    public void responseSetLanguage(int n) {
    }

    @Override
    public void responseSetMaxCommandNBestListSize(int n) {
    }

    @Override
    public void responseSetMaxSlotNBestListSize(int n) {
    }

    @Override
    public void responseSetRecognitionTimeout(int n) {
    }

    @Override
    public void responseSetSpellingMode(int n) {
    }

    @Override
    public void responseSetUnambiguousResultRange(int n) {
    }

    @Override
    public void responseSetUnambiguousResultThreshold(int n) {
    }

    @Override
    public void responseSetUtteranceStartTimeout(int n) {
    }

    @Override
    public void responseShutdown(int n) {
    }

    @Override
    public void responseStartDialogue(int n) {
    }

    @Override
    public void responseStartPostTraining(int n) {
    }

    @Override
    public void responseStartRecognition(int n) {
    }

    @Override
    public void responseStopDialogue(int n) {
    }

    @Override
    public void responseStopPostTraining(int n) {
    }

    @Override
    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void responseUnloadProfile(int n) {
    }

    @Override
    public void responseUnpreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
    }

    @Override
    public void updateAborted(boolean bl, int n) {
    }

    @Override
    public void updateAbsoluteConfidenceThreshold(int n, int n2) {
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    @Override
    public void updateAvailableProfiles(int[] nArray, int n) {
    }

    @Override
    public void updateConfidenceRejectThreshold(int n, int n2) {
    }

    @Override
    public void updateFailure(boolean bl, int n) {
    }

    @Override
    public void updateFirstLevelSize(int n, int n2) {
    }

    @Override
    public void updateGrammarStatus(int n, boolean bl, int n2) {
    }

    @Override
    public void updateLanguage(String string, int n, int n2) {
    }

    @Override
    public void updateMaxCommandNBestListSize(int n, int n2) {
    }

    @Override
    public void updateMaxSlotNBestListSize(int n, int n2) {
    }

    @Override
    public void updateRecognitionTimeout(int n, int n2) {
    }

    @Override
    public void updateRecognizerState(int n, int n2) {
    }

    @Override
    public void updateSDSAvailability(int n, int n2) {
    }

    @Override
    public void updateTemporaryG2PLanguageChangeActive(boolean bl, int n) {
    }

    @Override
    public void updateUnambiguousResultRange(int n, int n2) {
    }

    @Override
    public void updateUnambiguousResultThreshold(int n, int n2) {
    }

    @Override
    public void updateUtteranceStartTimeout(int n, int n2) {
    }

    @Override
    public void execute() {
    }

    @Override
    public void updateGrammarState(GrammarStateInfo grammarStateInfo, int n) {
    }

    @Override
    public void responseSetDictionary(int n) {
    }

    @Override
    public void responseEnableContinuousUpdate(int n) {
    }

    @Override
    public void responseCheckDbPartition(int n) {
    }

    @Override
    public void updateNBestList(NBestList nBestList, int n) {
    }

    @Override
    public void responseSetASRParameterConfiguration(int n) {
    }

    @Override
    public void updateASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3, int n) {
    }

    @Override
    public void responseDeleteLastFlexVDEPart(int n, NBestList nBestList) {
    }

    @Override
    public void responseClearFlexVDEHistory(int n) {
    }

    @Override
    public void updateVDEMediumState(int n, int n2) {
    }

    @Override
    public void updateAvailableSLMLanguages(String[] stringArray, int n) {
    }

    @Override
    public void updateOnlineCapabilities(String[] stringArray, int n) {
    }
}

