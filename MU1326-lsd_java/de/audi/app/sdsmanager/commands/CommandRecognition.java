/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.system.commands.SystemStartRecognitionCommand;
import de.audi.app.sdsmanager.commands.AbstractSpeechCommand;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.testsupport.SDSStatisticsHandler;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;

public class CommandRecognition
extends AbstractSpeechCommand {
    private final SpeechRecognitionHandler speechRecHandler;
    private final NBestStorageAccess nBestStorage;
    private final SDSAppFactory sdsAppFactory;
    private final SDSHandlerService sdsHandlerService;
    private final SDSTimeoutHandler sdsTimeoutHandler;
    private MessageDictationHandler messageDictSDSHandler;
    private final int beepType;
    private final int recogMode;
    private final Object mutex = new Object();
    private final Object abortMutex = new Object();
    private boolean recognitionStopped = false;
    private boolean recognitionStarted = false;
    private boolean abortCompleted = false;
    private boolean abortTriggered = false;

    public CommandRecognition(SDSAppFactory sDSAppFactory, SpeechRecognitionHandler speechRecognitionHandler, int n, int n2, NBestStorageAccess nBestStorageAccess, SDSHandlerService sDSHandlerService, SDSTimeoutHandler sDSTimeoutHandler, MessageDictationHandler messageDictationHandler) {
        super(Logger.getCommandLog(), "RECOGNITION");
        this.sdsAppFactory = sDSAppFactory;
        this.speechRecHandler = speechRecognitionHandler;
        this.beepType = n;
        this.recogMode = n2;
        this.nBestStorage = nBestStorageAccess;
        this.sdsHandlerService = sDSHandlerService;
        this.sdsTimeoutHandler = sDSTimeoutHandler;
        this.messageDictSDSHandler = messageDictationHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute]", (Object)this.getName());
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            if (this.recognitionStopped) {
                this.logger.log(-2137614336, "[%1#execute] Recognition stopped. Ignore.", (Object)this.getName());
                bl = true;
            } else if (!this.speechRecHandler.startRecognition(this.beepType, this.recogMode)) {
                this.logger.log(-2137614336, "[%1#execute] Recognition failed.", (Object)this.getName());
                bl = true;
            } else {
                this.recognitionStarted = true;
            }
        }
        if (bl) {
            this.logger.log(-2137614336, "[%1#execute] Finished, calling processingFinished!", (Object)this.getName());
            this.processingFinished();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean stopRecognition() {
        this.logger.log(-2137614336, "[%1#stopRecognition]", (Object)this.getName());
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            this.recognitionStopped = true;
            if (!this.recognitionStarted) {
                this.logger.log(-2137614336, "[%1#stopRecognition] Recognition not started!", (Object)this.getName());
                bl = true;
            } else if (this.isAbortCompleted()) {
                this.logger.log(-2137614336, "[%1#stopRecognition] Abort already completed!", (Object)this.getName());
                bl = true;
            } else if (this.isAbortTriggered()) {
                this.logger.log(-2137614336, "[%1#stopRecognition] Abort already triggered => NOP!", (Object)this.getName());
            } else if (!this.speechRecHandler.abortRecognition()) {
                this.logger.log(-2137614336, "[%1#stopRecognition] Abort not triggered and thus finished!", (Object)this.getName());
                bl = true;
            } else {
                this.logger.log(-2137614336, "[%1#stopRecognition] Abort triggered!", (Object)this.getName());
                this.setAbortTriggered(true);
            }
        }
        if (bl) {
            this.logger.log(-2137614336, "[%1#stopRecognition] Abort finished!", (Object)this.getName());
            this.abortingFinished();
        }
        return !bl;
    }

    @Override
    public long getTimeout() {
        return -1L;
    }

    private void abortingFinished() {
        this.logger.log(-2137614336, "[%1#abortingFinished] called", (Object)this.getName());
        this.processingFinished();
        this.sdsAppFactory.getSDSHandlerSystem().abortedCurrentRecognition();
    }

    private void processingFinished() {
        this.logger.log(-2137614336, "[%1#processingFinished] called", (Object)this.getName());
        try {
            ((SystemStartRecognitionCommand)SDSUtils.getActiveSystemCall()).processingFinished();
        }
        catch (ClassCastException classCastException) {
            this.logger.log(10000, "[%1#processingFinished] Active command is no SystemStartRecognitionCommand!", (Object)this.getName());
        }
        catch (NullPointerException nullPointerException) {
            this.logger.log(-1601830656, "[%1#processingFinished] NullpointerException. No command active!", (Object)this.getName());
        }
        this.getCommandList().commandFinished();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void responseStartRecognition(int n) {
        this.logger.log(-2137614336, "[%1#responseStartRecognition] replyCode=%2", (Object)this.getName(), (long)n);
        boolean bl = false;
        boolean bl2 = false;
        Object object = this.abortMutex;
        synchronized (object) {
            bl = this.isAbortTriggered();
            bl2 = this.isAbortCompleted();
            if (bl) {
                this.setAbortCompleted(true);
            }
            this.logger.log(-2137614336, "[%1#responseStartRecognition] triggered=%2, completed=%3!", (Object)this.getName(), (Object)bl, (Object)bl2);
        }
        if (bl2) {
            this.logger.log(-2137614336, "[%1#responseStartRecognition] Abort completed, NOT calling waitForResults!", (Object)this.getName());
            this.abortingFinished();
            return;
        }
        if (bl) {
            this.logger.log(-2137614336, "[%1#responseStartRecognition] Abort triggered, NOT calling waitForResults, waiting for responseAbort!", (Object)this.getName());
            return;
        }
        if (SDSUtils.checkReplyCodeForError(n, this.logger)) {
            this.logger.log(-1601830656, "[%1#responseStartRecognition] Error from DSI, sending ERROR!", (Object)this.getName());
            this.sdsHandlerService.sendSpeechSMEvent(3001, false, false);
            this.processingFinished();
            return;
        }
        this.logger.log(-2137614336, "[%1#responseStartRecognition] Calling waitForResults!", (Object)this.getName());
        if (!this.speechRecHandler.waitForResults()) {
            this.logger.log(-1601830656, "[%1#responseStartRecognition] waitForResults failed, sending ERROR!", (Object)this.getName());
            this.sdsHandlerService.sendSpeechSMEvent(3001, false, false);
            this.processingFinished();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        boolean bl = false;
        boolean bl2 = false;
        Object object = this.abortMutex;
        synchronized (object) {
            bl = this.isAbortTriggered();
            bl2 = this.isAbortCompleted();
            this.setAbortCompleted(true);
        }
        if (bl2) {
            this.logger.log(-2137614336, "[%1#responseWaitForResults] Abort completed!", (Object)this.getName());
            this.abortingFinished();
            return;
        }
        if (bl) {
            this.logger.log(-2137614336, "[%1#responseWaitForResults] Abort triggered, but not completed, awaiting responseAbort!", (Object)this.getName());
            return;
        }
        int n2 = this.mapReplyCodeToSMEvent(n);
        SDSStatisticsHandler.addSpeechRecognitionData(nBestList);
        if (n2 != 3000) {
            this.handleInvalidEvents(n2);
        } else if (CommandRecognition.isEmpty(nBestList)) {
            this.handleEmptyResults();
        } else {
            this.handleValidResults(nBestList);
        }
        this.processingFinished();
    }

    private void handleEmptyResults() {
        this.logger.log(-2137614336, "[%1#handleEmptyResults] called", (Object)this.getName());
        if (!SDSUtils.isOnlineRecogActive(this.logger) && !SDSModelAccess.isMsgDictateActive()) {
            this.logger.log(-1601830656, "[%1#handleEmptyResults] Online recognition NOT active, sending ERROR!", (Object)this.getName());
            this.sdsHandlerService.sendSpeechSMEvent(3001, false, false);
        }
    }

    private void handleInvalidEvents(int n) {
        this.logger.log(-2137614336, "[%1#handleInvalidEvents] smEvent=%2", (Object)this.getName(), (long)n);
        this.sdsHandlerService.sendSpeechSMEvent(n, false, false);
    }

    private void handleValidResults(NBestList nBestList) {
        if (this.handleEmptyEntry(nBestList.getEntries()[0])) {
            this.logger.log(-1601830656, "[%1#handleValidResults] firstEntry with empty recognized string!", (Object)this.getName());
            return;
        }
        if (!this.nBestStorage.storeNBestList(nBestList)) {
            this.logger.log(-2137614336, "[%1#handleValidResults] no entries stored.", (Object)this.getName());
            this.sdsHandlerService.sendSpeechSMEvent(2001, false, false);
            return;
        }
        NBestListEntry nBestListEntry = this.nBestStorage.getTopEntry();
        int n = nBestListEntry.getGrammarId();
        int n2 = SDSManagerBaseActivator.getMapping().getEventIdForRule(n);
        int n3 = SDSManagerBaseActivator.getMapping().getEventID(1001);
        n2 = n2 == -1 ? n3 : n2;
        this.sdsTimeoutHandler.restartEventTimer(n2);
        if (n2 == n3) {
            SDSModelAccess.setSDSAborterType(0);
        }
        if (this.messageDictSDSHandler.isDictationRunning() && !SDSManagerBaseActivator.getMapping().isOnlineRecogFinishedSMEvent(n2)) {
            this.sdsHandlerService.setOnlineRecogResultsInvalid(true);
        } else {
            this.sdsHandlerService.setOnlineRecogResultsInvalid(false);
        }
        this.logger.log(-2137614336, "[%1#handleValidResults] Firing SM-event with ID %2 for ruleID %3!", (Object)this.getName(), (long)n2, (long)n);
        this.sdsHandlerService.sendSpeechSMEvent(n2, true, false);
    }

    @Override
    public void responseAbort(int n) {
        this.logger.log(-2137614336, "[%1#responseAbort] replyCode=%2", (Object)this.getName(), (long)n);
        if (!this.isAbortTriggered()) {
            this.logger.log(-1601830656, "[%1#responseAbort] Abort not triggered => NOP!", (Object)this.getName());
            return;
        }
        if (!this.isAbortCompleted()) {
            this.logger.log(-2137614336, "[%1#responseAbort] Abort not completed, awaiting responseStartRecognition or responseWaitForResults!", (Object)this.getName());
            this.setAbortCompleted(true);
            return;
        }
        this.logger.log(-2137614336, "[%1#responseAbort] Abort completed!", (Object)this.getName());
        this.abortingFinished();
    }

    private int mapReplyCodeToSMEvent(int n) {
        if (SDSUtils.checkReplyCodeForError(n, this.logger)) {
            this.logger.log(-1601830656, "[%1#mapReplyCodeToSMEvent] Error from DSI, returning ERROR!", (Object)this.getName());
            return 3001;
        }
        if (SDSUtils.checkReplyCodeForNonSatisfyingRecognition(n, this.logger)) {
            this.logger.log(-1601830656, "[%1#mapReplyCodeToSMEvent] Unsatisfying recognition from DSI, returning RECOG_FAILURE!", (Object)this.getName());
            return 2001;
        }
        if (SDSUtils.checkReplyCodeForTimeout(n, this.logger)) {
            this.logger.log(-1601830656, "[%1#mapReplyCodeToSMEvent] Timeout from DSI, returning TIMEOUT!", (Object)this.getName());
            return 2002;
        }
        if (n == 105) {
            this.logger.log(-1601830656, "[%1#mapReplyCodeToSMEvent] Signal-to-noise-ratio too low, returning SIGNAL_TO_NOISE_RATIO_TOO_LOW!", (Object)this.getName());
            return 2003;
        }
        return 3000;
    }

    private static boolean isEmpty(NBestList nBestList) {
        return nBestList == null || nBestList.getEntries() == null || nBestList.getEntries().length == 0;
    }

    private boolean handleEmptyEntry(NBestListEntry nBestListEntry) {
        if (nBestListEntry == null) {
            this.logger.log(-1601830656, "[%1#handleEmptyEntry] No entry given!", (Object)this.getName());
            this.sdsHandlerService.sendSpeechSMEvent(3001, false, false);
            return true;
        }
        String string = nBestListEntry.getRecognizedString();
        if (!SDSUtils.isEmpty(string)) {
            return false;
        }
        if (SDSModelAccess.getPosttrainingActiveValue() == 1) {
            this.logger.log(-2137614336, "[%1#handleEmptyEntry] Empty recognized string found, but posttraining active, sending OK!", (Object)this.getName());
            this.sdsHandlerService.sendSpeechSMEvent(3000, false, false);
            return true;
        }
        this.logger.log(-1601830656, "[%1#handleEmptyEntry] Ignoring empty recognized string!", (Object)this.getName());
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isAbortCompleted() {
        Object object = this.abortMutex;
        synchronized (object) {
            return this.abortCompleted;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAbortCompleted(boolean bl) {
        Object object = this.abortMutex;
        synchronized (object) {
            this.abortCompleted = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isAbortTriggered() {
        Object object = this.abortMutex;
        synchronized (object) {
            return this.abortTriggered;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAbortTriggered(boolean bl) {
        Object object = this.abortMutex;
        synchronized (object) {
            this.abortTriggered = bl;
        }
    }

    @Override
    public String toString() {
        return new StringBuffer().append("CommandRecognition@").append(this.hashCode()).toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAborting() {
        Object object = this.abortMutex;
        synchronized (object) {
            return this.abortTriggered && !this.abortCompleted;
        }
    }
}

