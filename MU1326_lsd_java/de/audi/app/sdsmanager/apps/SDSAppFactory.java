/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.ISDSDispatcher;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandler;
import de.audi.app.sdsmanager.apps.adb.AddressBookSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandler;
import de.audi.app.sdsmanager.apps.dictate.MessageDictationHandlerImpl;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandler;
import de.audi.app.sdsmanager.apps.media.MediaSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.messaging.MessagingSDSHandler;
import de.audi.app.sdsmanager.apps.messaging.MessagingSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandler;
import de.audi.app.sdsmanager.apps.phone.PhoneSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.remotehmi.RemoteHMIHandler;
import de.audi.app.sdsmanager.apps.remotehmi.RemoteHMIHandlerImpl;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.terminalmode.ITerminalModeSDSHandler;
import de.audi.app.sdsmanager.apps.terminalmode.TerminalModeSDSHandler;
import de.audi.app.sdsmanager.apps.tuner.TunerSDSHandler;
import de.audi.app.sdsmanager.apps.tuner.TunerSDSHandlerImpl;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.dictation.DictationService;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.OneshotHandlerFactory;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;

public class SDSAppFactory {
    private final LogChannel lc = Logger.getMainLog();
    private SystemSDSHandler systemSDSHandler;
    private AddressBookSDSHandler adbSDSHandler;
    private MediaSDSHandler mediaSDSHandler;
    private NaviSDSHandler naviSDSHandler;
    private PhoneSDSHandler phoneSDSHandler;
    private TunerSDSHandler tunerSDSHandler;
    private RemoteHMIHandler remoteHMIHandler;
    private MessageDictationHandler msgDictationHandler;
    private MessagingSDSHandler messagingSDSHandler;
    private ISystemVBIHandler systemVBIHandler;
    private ITerminalModeSDSHandler terminalModeSDSHandler;
    private OneshotHandlerFactory oneshotHandlerFactory;

    public SDSAppFactory(IFrameworkAccess iFrameworkAccess, SpeechRecognitionHandler speechRecognitionHandler, SpeechTTSHandler speechTTSHandler, AppSDSManager appSDSManager, SDSHMIListener sDSHMIListener, SDSAudioHandler sDSAudioHandler, ISDSDispatcher iSDSDispatcher, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, SDSHandlerService sDSHandlerService, SDSTimeoutHandler sDSTimeoutHandler, ISDSPopupHelper iSDSPopupHelper, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, DictationService dictationService) {
        this.systemSDSHandler = new SystemSDSHandlerImpl(this, iFrameworkAccess, sDSHandlerService, speechRecognitionHandler, speechTTSHandler, appSDSManager, sDSHMIListener, sDSAudioHandler, nBestStorageAccess, sDSTimeoutHandler, iSDSPopupHelper);
        this.oneshotHandlerFactory = new OneshotHandlerFactory(iFrameworkAccess);
        this.createHandlers(iFrameworkAccess, nBestStorageAccess, iDynamicLists, sDSHandlerService, speechRecognitionHandler, iSDSPopupHelper, mobileSpeechRecognitionHandler, dictationService);
        this.registerHandlers(iSDSDispatcher);
        this.lc.log(-2137614336, "SDSAppFactory initialized.");
    }

    private void createHandlers(IFrameworkAccess iFrameworkAccess, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, SDSHandlerService sDSHandlerService, SpeechRecognitionHandler speechRecognitionHandler, ISDSPopupHelper iSDSPopupHelper, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, DictationService dictationService) {
        this.lc.log(-2137614336, "SDSAppFactory#createHandlers: called");
        HMIService hMIService = iFrameworkAccess.getHMIService();
        ILanguageManager iLanguageManager = iFrameworkAccess.getLanguageMgr();
        this.adbSDSHandler = new AddressBookSDSHandlerImpl(hMIService, sDSHandlerService, this, nBestStorageAccess, iSDSPopupHelper);
        this.mediaSDSHandler = this.createMediaHandler(hMIService, sDSHandlerService, iDynamicLists, nBestStorageAccess, this.systemSDSHandler, new Long[0], iSDSPopupHelper, this.oneshotHandlerFactory);
        this.naviSDSHandler = new NaviSDSHandlerImpl(hMIService, sDSHandlerService, this, nBestStorageAccess, iDynamicLists, speechRecognitionHandler, iLanguageManager, iSDSPopupHelper, this.oneshotHandlerFactory);
        if (iFrameworkAccess.isAsia()) {
            this.naviSDSHandler.setLDCHandling((byte)1);
        }
        this.phoneSDSHandler = new PhoneSDSHandlerImpl(hMIService, sDSHandlerService, iDynamicLists, nBestStorageAccess, this, iLanguageManager, iSDSPopupHelper, mobileSpeechRecognitionHandler);
        this.tunerSDSHandler = this.createTunerHandler(sDSHandlerService, nBestStorageAccess, iDynamicLists, hMIService, this, iSDSPopupHelper);
        this.remoteHMIHandler = new RemoteHMIHandlerImpl(sDSHandlerService, nBestStorageAccess, iDynamicLists, speechRecognitionHandler);
        this.msgDictationHandler = new MessageDictationHandlerImpl(sDSHandlerService, this, nBestStorageAccess, iSDSPopupHelper, dictationService, hMIService, iDynamicLists);
        this.messagingSDSHandler = new MessagingSDSHandlerImpl(hMIService, sDSHandlerService, iSDSPopupHelper);
        this.terminalModeSDSHandler = new TerminalModeSDSHandler();
    }

    protected TunerSDSHandler createTunerHandler(SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, HMIService hMIService, SDSAppFactory sDSAppFactory, ISDSPopupHelper iSDSPopupHelper) {
        return new TunerSDSHandlerImpl(sDSHandlerService, nBestStorageAccess, iDynamicLists, hMIService, sDSAppFactory, iSDSPopupHelper);
    }

    protected MediaSDSHandler createMediaHandler(HMIService hMIService, SDSHandlerService sDSHandlerService, IDynamicLists iDynamicLists, NBestStorageAccess nBestStorageAccess, SystemSDSHandler systemSDSHandler, Long[] longArray, ISDSPopupHelper iSDSPopupHelper, OneshotHandlerFactory oneshotHandlerFactory) {
        return new MediaSDSHandlerImpl(hMIService, sDSHandlerService, iDynamicLists, nBestStorageAccess, systemSDSHandler, longArray, iSDSPopupHelper, oneshotHandlerFactory);
    }

    public void setTTSASR(ITTSASR iTTSASR) {
        this.tunerSDSHandler.setTTSASR(iTTSASR);
        this.naviSDSHandler.setTTSASR(iTTSASR);
        this.remoteHMIHandler.setTTSASR(iTTSASR);
    }

    private void registerHandlers(ISDSDispatcher iSDSDispatcher) {
        this.lc.log(-2137614336, "SDSAppFactory#registerHandlers: called");
        iSDSDispatcher.registerApplication(this.systemSDSHandler, (byte)14);
        iSDSDispatcher.registerApplication(this.adbSDSHandler, (byte)7);
        iSDSDispatcher.registerApplication(this.mediaSDSHandler, (byte)2);
        iSDSDispatcher.registerApplication(this.naviSDSHandler, (byte)4);
        iSDSDispatcher.registerApplication(this.phoneSDSHandler, (byte)3);
        iSDSDispatcher.registerApplication(this.tunerSDSHandler, (byte)1);
        iSDSDispatcher.registerApplication(this.remoteHMIHandler, (byte)23);
        iSDSDispatcher.registerApplication(this.msgDictationHandler, (byte)24);
        iSDSDispatcher.registerApplication(this.messagingSDSHandler, (byte)35);
    }

    public SystemSDSHandler getSDSHandlerSystem() {
        return this.systemSDSHandler;
    }

    public AddressBookSDSHandler getSDSHandlerADB() {
        return this.adbSDSHandler;
    }

    public MediaSDSHandler getSDSHandlerMedia() {
        return this.mediaSDSHandler;
    }

    public NaviSDSHandler getSDSHandlerNavi() {
        return this.naviSDSHandler;
    }

    public PhoneSDSHandler getSDSHandlerPhone() {
        return this.phoneSDSHandler;
    }

    public TunerSDSHandler getSDSHandlerTuner() {
        return this.tunerSDSHandler;
    }

    public RemoteHMIHandler getSDSHandlerRemoteHMI() {
        return this.remoteHMIHandler;
    }

    public MessageDictationHandler getSDSHandlerMessageDictation() {
        return this.msgDictationHandler;
    }

    public MessagingSDSHandler getSDSHandlerMessaging() {
        return this.messagingSDSHandler;
    }

    public ITerminalModeSDSHandler getTerminalModeSDSHandler() {
        return this.terminalModeSDSHandler;
    }

    public void setCommandListManager(CommandListManager commandListManager) {
        this.systemSDSHandler.setCommandListManager(commandListManager);
    }

    public void setSystemVBIHandler(ISystemVBIHandler iSystemVBIHandler) {
        this.systemVBIHandler = iSystemVBIHandler;
    }

    public ISystemVBIHandler getSystemVBIHandler() {
        return this.systemVBIHandler;
    }
}

