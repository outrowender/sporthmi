/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.commands.AbstractSpeechCommand;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class CommandSpeechDSIInit
extends AbstractSpeechCommand {
    private static final String LOGCLASS = "CommandSpeechDSIInit";
    private static final int COMMAND_TIMEOUT_SPEECH_DSI_INIT = -1;
    private final SpeechRecognitionHandler srHandler;
    private final IFrameworkAccess framework;
    private final SDSAdapter sdsAdapter;
    private final SDSTimeoutHandler timeout;
    private final NaviSDSHandler naviHandler;

    public CommandSpeechDSIInit(LogChannel logChannel, SpeechRecognitionHandler speechRecognitionHandler, IFrameworkAccess iFrameworkAccess, SDSAdapter sDSAdapter, NaviSDSHandler naviSDSHandler, SDSTimeoutHandler sDSTimeoutHandler) {
        super(logChannel, "INIT_SPEECH_DSI");
        this.srHandler = speechRecognitionHandler;
        this.framework = iFrameworkAccess;
        this.sdsAdapter = sDSAdapter;
        this.naviHandler = naviSDSHandler;
        this.timeout = sDSTimeoutHandler;
    }

    private void processingFinished() {
        this.logger.log(10000000, "%1#processingFinished: called", (Object)LOGCLASS);
        this.commandList.commandFinished();
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)LOGCLASS);
        this.sdsAdapter.setSDSReady(false);
        this.timeout.startInitTimer();
        this.sdsAdapter.setInitializationStep((byte)0);
        if (!this.srHandler.init()) {
            this.logger.log(100000, "%1#execute: Initialization failed1", (Object)LOGCLASS);
            this.processingFinished();
            return;
        }
    }

    public void responseInit(int n) {
        this.logger.log(10000000, "%1#responseInit: replyCode=%2", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)1);
        String string = this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_SDS").getLanguageCode();
        this.logger.log(10000000, "%1#responseInit: localeString=%2!", (Object)LOGCLASS, (Object)string);
        if (!this.srHandler.setLanguage(string)) {
            this.logger.log(100000, "%1#responseInit: setLanguage failed!", (Object)LOGCLASS);
            this.sdsAdapter.updateSDSState((byte)2);
            this.sdsAdapter.sendSpeechSMEvent(2001, false, false);
            this.processingFinished();
            return;
        }
    }

    public void responseSetLanguage(int n) {
        this.logger.log(10000000, "%1#responseSetLanguage: replyCode=%2, requesting DSISpeechRec version!", (Object)LOGCLASS, (long)n);
        this.timeout.cancelInitTimer();
        this.srHandler.getVersion();
        boolean bl = SDSModelAccess.isSDSDisabledForLanguage();
        this.logger.log(10000000, "%1#responseSetLanguage: disabled=%2!", (Object)LOGCLASS, (Object)bl);
        if (SDSUtils.checkReplyCodeForError(n, this.logger) || bl) {
            this.logger.log(100000, "%1#responseSetLanguage: FAILED or language disabled!", (Object)LOGCLASS);
            this.sdsAdapter.updateSDSState((byte)2);
            this.framework.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_SDS", false);
            this.sdsAdapter.sendSpeechSMEvent(2001, false, false);
            this.processingFinished();
            return;
        }
        this.framework.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_SDS", true);
        this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 3: DSI language loading is finished.");
        this.sdsAdapter.setInitializationStep((byte)2);
        this.naviHandler.setSpeechDSIStatus(true);
        this.srHandler.setMaxSlotNBestListSize(20);
    }

    public void responseSetMaxSlotNBestListSize(int n) {
        this.logger.log(10000000, "%1#responseSetMaxSlotNBestListSize: replyCode=%2", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)3);
        this.srHandler.setMaxCommandNBestListSize(2);
    }

    public void responseSetMaxCommandNBestListSize(int n) {
        this.logger.log(10000000, "%1#responseSetMaxCommandNBestListSize: replyCode=%2", (Object)LOGCLASS, (long)n);
        this.sdsAdapter.setInitializationStep((byte)9);
        this.sdsAdapter.setSDSReady(true);
        this.processingFinished();
    }

    public void responseRequestSDSAvailability(int n, int n2) {
        this.logger.log(10000000, "%1#responseRequestSDSAvailability: sdsAvailability=%2, replyCode=%3 -> NOP", (Object)LOGCLASS, (long)n, (long)n2);
    }

    public void responseCheckDbPartition(int n) {
        this.logger.log(10000000, "%1#responseCheckDbPartition: replyCode=%2", (Object)LOGCLASS, (long)n);
        if (n == 0) {
            this.sdsAdapter.setInitializationStep((byte)9);
            this.sdsAdapter.setSDSReady(true);
        }
        this.processingFinished();
    }

    public long getTimeout() {
        return -1L;
    }

    public String toString() {
        return LOGCLASS + this.hashCode();
    }
}

