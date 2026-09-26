/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$1;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$10;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$11;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$12;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$13;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$2;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$3;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$4;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$5;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$6;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$7;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$8;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$9;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$DsiAccessClient;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$DsiOnlineDictationListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ITranscriptPreprocessor;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.dsiadapter.TranscriptPreprocessor;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Set;
import java.util.TreeSet;
import org.dsi.ifc.online.DictationValueSentence;

public final class DsiDictationAdapter
extends AbstractDictationComponent
implements IDsiDictationAdapter {
    private static final int RQ_SET_LANGUAGE;
    private static final int RQ_SET_FALLBACK_LANGUAGE;
    private static final int RQ_SET_USER_ID;
    private static final int RQ_ACTIVATE_DICTATION;
    private static final int RQ_START_DICTATION;
    private static final int RQ_PROCESS_VOICE_DATA;
    private static final int RQ_STOP_DICTATION;
    private final ITranscriptPreprocessor transcriptPreprocessor;
    private final Set currentRequests = new TreeSet();
    private volatile DispatcherBase dispatcher;
    private volatile DsiDictationAdapterListenerProxy listenerProxy;
    private volatile Monitor cmdMonitor;
    private volatile int cachedStartDictationResult = 0;
    private volatile String language = "";
    private volatile String fallbackLanguage = "";
    private volatile String userId = "";
    private volatile int activationState = 0;
    private volatile ServiceProviderInfo serviceProviderInfo = new ServiceProviderInfo();
    private volatile boolean dsiAvailable = false;

    public DsiDictationAdapter(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
        this.transcriptPreprocessor = new TranscriptPreprocessor(this.log);
    }

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.dispatcher = dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher();
        this.cmdMonitor = new Monitor(dictationComponentManager.getDispatcherManager().getCommandListManager().getLogChannel());
        dictationComponentManager.getDsiOnlineDictationPrimaryListener().addSubscriber(new DsiDictationAdapter$DsiOnlineDictationListener(this, null));
        this.initListenerProxy();
        dictationComponentManager.getDsiOnlineDictationAccess().addDsiAccessClient(new DsiDictationAdapter$DsiAccessClient(this, null));
    }

    private void initListenerProxy() {
        DispatcherBase dispatcherBase = this.dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher();
        this.listenerProxy = new DsiDictationAdapterListenerProxy(dispatcherBase, this.log);
        this.listenerProxy.updateLanguage(this.language, this.fallbackLanguage);
        this.listenerProxy.updateUserId(this.userId);
        this.listenerProxy.updateActivationState(this.activationState);
        this.listenerProxy.updateServiceProviderInfo(this.serviceProviderInfo);
        this.listenerProxy.updateDsiAvailability(this.dsiAvailable);
    }

    private synchronized void markRequestInProgress(int n) {
        this.currentRequests.add(Util.createInteger(n));
    }

    private synchronized void markRequestCompleted(int n) {
        this.currentRequests.remove(Util.createInteger(n));
    }

    private synchronized boolean isRequestInProgress(int n) {
        return this.currentRequests.contains(Util.createInteger(n));
    }

    private void setLanguage(String string, String string2) {
        this.language = string;
        this.fallbackLanguage = string2;
        this.listenerProxy.updateLanguage(string, string2);
    }

    private void setUserId(String string) {
        this.userId = string;
        this.listenerProxy.updateUserId(string);
    }

    private void setActivationState(int n) {
        this.activationState = n;
        this.listenerProxy.updateActivationState(n);
    }

    private void setServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
        this.listenerProxy.updateServiceProviderInfo(serviceProviderInfo);
    }

    private void setDsiAvailable(boolean bl) {
        this.dsiAvailable = bl;
        this.listenerProxy.updateDsiAvailability(bl);
    }

    private void logIllegalRequest(String string, int n, Set set) {
        this.log.log(-1601830656, "%1 Illegal request: activationState = %2, currentRequests = %3", (Object)string, (Object)String.valueOf(n), (Object)DictationUtil.collectionToString(set));
    }

    @Override
    public void addListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.log.log(1078071040, "[DsiDictationAdapter#addListener] listener = %1", (Object)iDsiDictationAdapterListener);
        this.listenerProxy.addListener(iDsiDictationAdapterListener);
    }

    @Override
    public void removeListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.log.log(1078071040, "[DsiDictationAdapter#removeListener] listener = %1", (Object)iDsiDictationAdapterListener);
        this.listenerProxy.removeListener(iDsiDictationAdapterListener);
    }

    @Override
    public void requestSetLanguage(String string) {
        this.dispatcher.execute(new DsiDictationAdapter$1(this, string));
    }

    @Override
    public void requestSetFallbackLanguage(String string) {
        this.dispatcher.execute(new DsiDictationAdapter$2(this, string));
    }

    @Override
    public void requestSetUserId(String string) {
        this.dispatcher.execute(new DsiDictationAdapter$3(this, string));
    }

    @Override
    public void requestActivateDictation() {
        this.dispatcher.execute(new DsiDictationAdapter$4(this));
    }

    @Override
    public void requestStartDictation(String string) {
        this.dispatcher.execute(new DsiDictationAdapter$5(this, string));
    }

    @Override
    public void requestProcessVoiceData() {
        this.dispatcher.execute(new DsiDictationAdapter$6(this));
    }

    @Override
    public void requestStopDictation() {
        this.dispatcher.execute(new DsiDictationAdapter$7(this));
    }

    void handleSetLanguageResult(int n, String string, boolean bl) {
        this.dispatcher.execute(new DsiDictationAdapter$8(this, n, string, bl));
    }

    void handleActivateDictationResult(int n) {
        this.dispatcher.execute(new DsiDictationAdapter$9(this, n));
    }

    void handleProcessVoiceDataResult(int n, DictationValueSentence dictationValueSentence) {
        this.dispatcher.execute(new DsiDictationAdapter$10(this, n, dictationValueSentence));
    }

    void handleStartDictationResult(int n) {
        this.dispatcher.execute(new DsiDictationAdapter$11(this, n));
    }

    void handleStopDictationResult(int n) {
        this.dispatcher.execute(new DsiDictationAdapter$12(this, n));
    }

    private void handleDictationResult(int n) {
        this.dispatcher.execute(new DsiDictationAdapter$13(this, n));
    }

    static /* synthetic */ LogChannel access$201(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ boolean access$300(DsiDictationAdapter dsiDictationAdapter, int n) {
        return dsiDictationAdapter.isRequestInProgress(n);
    }

    static /* synthetic */ int access$400(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.activationState;
    }

    static /* synthetic */ Set access$500(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.currentRequests;
    }

    static /* synthetic */ void access$600(DsiDictationAdapter dsiDictationAdapter, String string, int n, Set set) {
        dsiDictationAdapter.logIllegalRequest(string, n, set);
    }

    static /* synthetic */ DsiDictationAdapterListenerProxy access$700(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.listenerProxy;
    }

    static /* synthetic */ void access$800(DsiDictationAdapter dsiDictationAdapter, int n) {
        dsiDictationAdapter.markRequestInProgress(n);
    }

    static /* synthetic */ DictationComponentManager access$901(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dictationComponentManager;
    }

    static /* synthetic */ Monitor access$1000(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.cmdMonitor;
    }

    static /* synthetic */ LogChannel access$1101(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ DictationComponentManager access$1201(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dictationComponentManager;
    }

    static /* synthetic */ LogChannel access$1301(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ void access$1400(DsiDictationAdapter dsiDictationAdapter, String string) {
        dsiDictationAdapter.setUserId(string);
    }

    static /* synthetic */ void access$1500(DsiDictationAdapter dsiDictationAdapter, int n) {
        dsiDictationAdapter.markRequestCompleted(n);
    }

    static /* synthetic */ LogChannel access$1601(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ DictationComponentManager access$1701(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dictationComponentManager;
    }

    static /* synthetic */ LogChannel access$1801(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ int access$1902(DsiDictationAdapter dsiDictationAdapter, int n) {
        dsiDictationAdapter.cachedStartDictationResult = n;
        return dsiDictationAdapter.cachedStartDictationResult;
    }

    static /* synthetic */ DictationComponentManager access$2001(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dictationComponentManager;
    }

    static /* synthetic */ String access$2100(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.userId;
    }

    static /* synthetic */ LogChannel access$2201(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ int access$1900(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.cachedStartDictationResult;
    }

    static /* synthetic */ LogChannel access$2301(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ void access$2400(DsiDictationAdapter dsiDictationAdapter, int n) {
        dsiDictationAdapter.setActivationState(n);
    }

    static /* synthetic */ DictationComponentManager access$2501(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dictationComponentManager;
    }

    static /* synthetic */ LogChannel access$2601(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$2701(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ DictationComponentManager access$2801(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dictationComponentManager;
    }

    static /* synthetic */ LogChannel access$2901(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ String access$3000(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.language;
    }

    static /* synthetic */ String access$3100(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.fallbackLanguage;
    }

    static /* synthetic */ void access$3200(DsiDictationAdapter dsiDictationAdapter, String string, String string2) {
        dsiDictationAdapter.setLanguage(string, string2);
    }

    static /* synthetic */ LogChannel access$3301(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$3401(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$3501(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ void access$3600(DsiDictationAdapter dsiDictationAdapter, ServiceProviderInfo serviceProviderInfo) {
        dsiDictationAdapter.setServiceProviderInfo(serviceProviderInfo);
    }

    static /* synthetic */ ITranscriptPreprocessor access$3700(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.transcriptPreprocessor;
    }

    static /* synthetic */ LogChannel access$3801(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$3901(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$4001(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$4101(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$4201(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$4301(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$4401(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ LogChannel access$4501(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ void access$4600(DsiDictationAdapter dsiDictationAdapter, int n) {
        dsiDictationAdapter.handleDictationResult(n);
    }

    static /* synthetic */ LogChannel access$4801(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.log;
    }

    static /* synthetic */ void access$4900(DsiDictationAdapter dsiDictationAdapter, boolean bl) {
        dsiDictationAdapter.setDsiAvailable(bl);
    }

    static /* synthetic */ DispatcherBase access$5000(DsiDictationAdapter dsiDictationAdapter) {
        return dsiDictationAdapter.dispatcher;
    }
}

