/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.remotehmi.RemoteHMIHandler;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.commands.CommandRecognition;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListJobQueue;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.util.commons.job.Job;
import java.util.Iterator;
import java.util.List;

public class SystemStartRecognitionCommand
extends AbstractSystemCallCommand {
    private static final int BEEP_TYPE_LONG;
    private static final int BEEP_TYPE_SHORT;
    private static final int BEEP_TYPE_NONE;
    private final SpeechRecognitionHandler srHandler;
    private final CommandListManager cmdListManager;
    private final NBestStorageAccess nBestStorage;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private final ISystemVBIHandler systemVBIHandler;
    private final SDSAppFactory factory;
    private final int beepValue;
    private final int recogModeValue;
    private MessageDictationHandler messageDictSDSHandler;
    private RemoteHMIHandler remoteHMIHandler;

    public SystemStartRecognitionCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, SpeechRecognitionHandler speechRecognitionHandler, CommandListManager commandListManager, NBestStorageAccess nBestStorageAccess, SDSTimeoutHandler sDSTimeoutHandler, ISystemVBIHandler iSystemVBIHandler, SDSAppFactory sDSAppFactory) {
        super(logChannel, string, sDSHandlerService);
        this.srHandler = speechRecognitionHandler;
        this.cmdListManager = commandListManager;
        this.nBestStorage = nBestStorageAccess;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.systemVBIHandler = iSystemVBIHandler;
        this.factory = sDSAppFactory;
        this.recogModeValue = SDSUtils.retrieveInteger(iSystemCallParameterArray, 1);
        this.messageDictSDSHandler = sDSAppFactory.getSDSHandlerMessageDictation();
        this.remoteHMIHandler = sDSAppFactory.getSDSHandlerRemoteHMI();
        this.beepValue = this.getBeepValue(SDSUtils.retrieveInteger(iSystemCallParameterArray, 0));
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: beepValue=%2, recogModeValue=%3", (Object)this.getName(), (long)this.beepValue, (long)this.recogModeValue);
        if (!this.sdsHandlerService.isCommandScreen() || SDSModelAccess.getDialogJumpingModel() != 0) {
            SDSUtils.updateSDSNumbers(true);
        }
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(new CommandRecognition(this.factory, this.srHandler, this.beepValue, this.recogModeValue, this.nBestStorage, this.sdsHandlerService, this.sdsTimeoutHandler, this.messageDictSDSHandler));
        commandList.execute("RECOGNITION");
    }

    private int getBeepValue(int n) {
        this.logger.log(-2137614336, "%1#getBeepValue: beepType=%2", (Object)this.getName(), (long)n);
        switch (n) {
            case 0: {
                this.logger.log(-2137614336, "%1#getBeepValue: Long beep requested!", (Object)this.getName());
                return 3;
            }
            case 1: {
                if (SDSModelAccess.isHelpPTTBargeIn()) {
                    SDSModelAccess.resetHelpPTTBargeIn();
                    return 2;
                }
                if (this.remoteHMIHandler.isGrammarReloadTriggered()) {
                    this.remoteHMIHandler.resetGrammarReloadTriggered();
                    return 1;
                }
                int n2 = this.systemVBIHandler.isVBIActiveDuringActivePrompt() ? 1 : 2;
                this.logger.log(-2137614336, "%1#getBeepValue: Short beep requested -> actual value: %2!", (Object)this.getName(), (long)n2);
                return n2;
            }
            case 2: {
                this.logger.log(-2137614336, "%1#getBeepValue: No beep requested!", (Object)this.getName());
                return 1;
            }
        }
        this.logger.log(-1601830656, "%1#getBeepValue: Unhandled beepType %2, returning %3!", (Object)this.getName(), (long)n, 1L);
        return 1;
    }

    public boolean stopCurrentRecognition() {
        this.logger.log(-2137614336, "%1#stopCurrentRecognition: called", (Object)this.getName());
        boolean bl = false;
        Command command = this.removeGrammarJobsBeforeRecognition();
        if (command == null) {
            this.logger.log(-2137614336, "%1#stopCurrentRecognition: No active recognition command, calling recognitionAborted()!", (Object)this.getName());
            this.recognitionAborted();
        } else {
            this.logger.log(-2137614336, "%1#stopCurrentRecognition: activeCommand=%2, stopping recognition!", (Object)this.getName(), (Object)command.getName());
            bl = ((CommandRecognition)command).stopRecognition();
            if (!bl) {
                this.logger.log(-2137614336, "%1#stopCurrentRecognition(): Recognition already finished, calling recognitionAborted!", (Object)this.getName());
                this.recognitionAborted();
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Command removeGrammarJobsBeforeRecognition() {
        if (this.cmdListManager == null) {
            return null;
        }
        CommandListJobQueue commandListJobQueue = this.cmdListManager.getQueue();
        synchronized (commandListJobQueue) {
            CommandList commandList = this.cmdListManager.getActiveCommandList();
            if (commandList == null) {
                this.logger.log(-2137614336, "%1#removeGrammarJobsBeforeRecognition: No active command list.", (Object)this.getName());
                return null;
            }
            Command command = commandList.getActiveCommand();
            if (command == null) {
                this.logger.log(-2137614336, "%1#removeGrammarJobsBeforeRecognition: No active command.", (Object)this.getName());
                return null;
            }
            if (command instanceof CommandRecognition) {
                return command;
            }
            this.logger.log(-2137614336, "%1#removeGrammarJobsBeforeRecognition: No active recognition.", (Object)this.getName());
            List list = this.cmdListManager.getQueue().getCommandLists();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Command command2;
                CommandList commandList2 = (CommandList)((Job)iterator.next()).getPayload();
                Iterator iterator2 = commandList2.getCommands().iterator();
                if (!iterator2.hasNext() || !((command2 = (Command)iterator2.next()) instanceof CommandRecognition)) continue;
                this.logger.log(1078071040, "%1#removeGrammarJobsBeforeRecognition: Remove %2!", (Object)this.getName(), (Object)commandList2.getName());
                iterator.remove();
            }
            return null;
        }
    }

    public void recognitionAborted() {
        this.logger.log(-2137614336, "%1#recognitionAborted: called", (Object)this.getName());
        this.sendResult(3000);
    }

    @Override
    public byte getActionOnNewSystemCall(ISystemCall iSystemCall) {
        int n = iSystemCall.getId();
        if (n == 1000 || n == 1043) {
            return 1;
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isCurrentRecognitionStopping() {
        if (this.cmdListManager == null) {
            return false;
        }
        CommandListJobQueue commandListJobQueue = this.cmdListManager.getQueue();
        synchronized (commandListJobQueue) {
            CommandList commandList = this.cmdListManager.getActiveCommandList();
            if (commandList == null) {
                this.logger.log(-2137614336, "%1#isCurrentRecognitionStopping: No active command list.", (Object)this.getName());
                return false;
            }
            Command command = commandList.getActiveCommand();
            if (command == null) {
                this.logger.log(-2137614336, "%1#isCurrentRecognitionStopping: No active command.", (Object)this.getName());
                return false;
            }
            if (command instanceof CommandRecognition) {
                return ((CommandRecognition)command).isAborting();
            }
        }
        return false;
    }
}

