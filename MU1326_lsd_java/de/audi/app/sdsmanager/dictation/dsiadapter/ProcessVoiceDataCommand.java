/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.ProcessVoiceDataCommand$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.online.DictationValueSentence;

final class ProcessVoiceDataCommand
extends AbstractDsiOnlineDictationCommand {
    private static final String AUDIO_DATA_PATH = ProcessVoiceDataCommand.getAudioDataPath();

    private ProcessVoiceDataCommand(DictationComponentManager dictationComponentManager) {
        super(dictationComponentManager);
    }

    static void schedule(DictationComponentManager dictationComponentManager, Monitor monitor) {
        ProcessVoiceDataCommand processVoiceDataCommand = new ProcessVoiceDataCommand(dictationComponentManager);
        processVoiceDataCommand.schedule(monitor);
    }

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[ProcessVoiceDataCommand#execute]");
            this.dsiOnlineDictationAccess.rawVoiceDataAvailable(AUDIO_DATA_PATH, 0);
        }
        catch (Exception exception) {
            this.logException("[ProcessVoiceDataCommand#execute]", exception);
            this.signalResult(1, null);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void dictationResult(int n) {
        this.logger.log(-2137614336, "[ProcessVoiceDataCommand#dictationResult] returnCode = %1", (long)n);
        if (n == 11) {
            this.logger.log(-2137614336, "[ProcessVoiceDataCommand#dictationResult] Result OK_DICTATION_COMPLETE, waiting for dictation content.");
        } else {
            this.logger.log(-2137614336, "[ProcessVoiceDataCommand#dictationResult] Result NOK, finishing command.");
            this.signalResult(AbstractDsiOnlineDictationCommand.mapDsiErrorCode(n), null);
        }
    }

    @Override
    public void dictationValueList(DictationValueSentence dictationValueSentence) {
        this.logger.log(-2137614336, "[ProcessVoiceDataCommand#dictationValueList]");
        if (dictationValueSentence != null) {
            this.signalResult(0, dictationValueSentence);
        } else {
            this.logNullParameter("[ProcessVoiceDataCommand#dictationValueList]");
            this.signalResult(1, null);
        }
    }

    private static String getAudioDataPath() {
        return System.getProperty("dictation.audioDataPath", "/tmp/speech-online.pcm");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n, DictationValueSentence dictationValueSentence) {
        try {
            this.logger.log(-2137614336, "[ProcessVoiceDataCommand#signalResult] result = %1", (long)n);
            this.dictationComponentManager.getDsiDictationAdapter().handleProcessVoiceDataResult(n, dictationValueSentence);
        }
        catch (Exception exception) {
            this.logException("[ProcessVoiceDataCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    protected Command getErrorCommand() {
        return new ProcessVoiceDataCommand$1(this, this.dictationComponentManager);
    }

    static /* synthetic */ LogChannel access$001(ProcessVoiceDataCommand processVoiceDataCommand) {
        return processVoiceDataCommand.logger;
    }

    static /* synthetic */ void access$100(ProcessVoiceDataCommand processVoiceDataCommand, int n, DictationValueSentence dictationValueSentence) {
        processVoiceDataCommand.signalResult(n, dictationValueSentence);
    }
}

