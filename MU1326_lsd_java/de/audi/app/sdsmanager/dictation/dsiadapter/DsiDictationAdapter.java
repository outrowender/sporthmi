/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationEmptyListener;
import de.audi.app.sdsmanager.dictation.dsi.IDsiAccessClient;
import de.audi.app.sdsmanager.dictation.dsiadapter.ActivateDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ITranscriptPreprocessor;
import de.audi.app.sdsmanager.dictation.dsiadapter.ProcessVoiceDataCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.dsiadapter.SetLanguageCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.StartDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.StopDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.TranscriptPreprocessor;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.util.Util;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import org.dsi.ifc.online.DictationValueSentence;

public final class DsiDictationAdapter
extends AbstractDictationComponent
implements IDsiDictationAdapter {
    private static final int RQ_SET_LANGUAGE = 0;
    private static final int RQ_SET_FALLBACK_LANGUAGE = 1;
    private static final int RQ_SET_USER_ID = 2;
    private static final int RQ_ACTIVATE_DICTATION = 3;
    private static final int RQ_START_DICTATION = 4;
    private static final int RQ_PROCESS_VOICE_DATA = 5;
    private static final int RQ_STOP_DICTATION = 6;
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

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.dispatcher = dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher();
        this.cmdMonitor = new Monitor(dictationComponentManager.getDispatcherManager().getCommandListManager().getLogChannel());
        dictationComponentManager.getDsiOnlineDictationPrimaryListener().addSubscriber(new DsiOnlineDictationListener());
        this.initListenerProxy();
        dictationComponentManager.getDsiOnlineDictationAccess().addDsiAccessClient(new DsiAccessClient());
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
        this.log.log(100000, "%1 Illegal request: activationState = %2, currentRequests = %3", (Object)string, (Object)String.valueOf(n), (Object)DictationUtil.collectionToString(set));
    }

    public void addListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.log.log(1000000, "[DsiDictationAdapter#addListener] listener = %1", (Object)iDsiDictationAdapterListener);
        this.listenerProxy.addListener(iDsiDictationAdapterListener);
    }

    public void removeListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.log.log(1000000, "[DsiDictationAdapter#removeListener] listener = %1", (Object)iDsiDictationAdapterListener);
        this.listenerProxy.removeListener(iDsiDictationAdapterListener);
    }

    public void requestSetLanguage(final String string) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestSetLanguage] language = %1", (Object)string);
                if (DsiDictationAdapter.this.isRequestInProgress(0)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestSetLanguage]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseSetLanguage(3);
                } else {
                    DsiDictationAdapter.this.markRequestInProgress(0);
                    SetLanguageCommand.schedule(DsiDictationAdapter.this.dictationComponentManager, DsiDictationAdapter.this.cmdMonitor, string, false);
                }
            }
        });
    }

    public void requestSetFallbackLanguage(final String string) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestSetFallbackLanguage] fallbackLanguage = %1", (Object)string);
                if (DsiDictationAdapter.this.isRequestInProgress(1)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestSetFallbackLanguage]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseSetFallbackLanguage(3);
                } else {
                    DsiDictationAdapter.this.markRequestInProgress(1);
                    SetLanguageCommand.schedule(DsiDictationAdapter.this.dictationComponentManager, DsiDictationAdapter.this.cmdMonitor, string, true);
                }
            }
        });
    }

    public void requestSetUserId(final String string) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestSetUserId] userId = %1", (Object)string);
                if (DsiDictationAdapter.this.isRequestInProgress(2)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestSetUserId]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseSetUserId(3);
                } else {
                    DsiDictationAdapter.this.markRequestInProgress(2);
                    DsiDictationAdapter.this.setUserId(string);
                    DsiDictationAdapter.this.listenerProxy.responseSetUserId(0);
                    DsiDictationAdapter.this.markRequestCompleted(2);
                }
            }
        });
    }

    public void requestActivateDictation() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestActivateDictation]");
                if (DsiDictationAdapter.this.activationState != 0 || DsiDictationAdapter.this.isRequestInProgress(3) || DsiDictationAdapter.this.isRequestInProgress(4) || DsiDictationAdapter.this.isRequestInProgress(5) || DsiDictationAdapter.this.isRequestInProgress(6)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestActivateDictation]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseActivateDictation(3);
                } else {
                    DsiDictationAdapter.this.markRequestInProgress(3);
                    ActivateDictationCommand.schedule(DsiDictationAdapter.this.dictationComponentManager, DsiDictationAdapter.this.cmdMonitor);
                }
            }
        });
    }

    public void requestStartDictation(final String string) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestStartDictation] customGrammar = %1", (Object)string);
                if (DsiDictationAdapter.this.activationState != 1 || DsiDictationAdapter.this.isRequestInProgress(3) || DsiDictationAdapter.this.isRequestInProgress(4) || DsiDictationAdapter.this.isRequestInProgress(5) || DsiDictationAdapter.this.isRequestInProgress(6)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestStartDictation]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseStartDictation(3);
                } else {
                    DsiDictationAdapter.this.cachedStartDictationResult = 0;
                    DsiDictationAdapter.this.markRequestInProgress(4);
                    StartDictationCommand.schedule(DsiDictationAdapter.this.dictationComponentManager, DsiDictationAdapter.this.cmdMonitor, string, DsiDictationAdapter.this.userId);
                }
            }
        });
    }

    public void requestProcessVoiceData() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestProcessVoiceData]");
                if (DsiDictationAdapter.this.activationState != 2 || DsiDictationAdapter.this.isRequestInProgress(3) || DsiDictationAdapter.this.isRequestInProgress(4) || DsiDictationAdapter.this.isRequestInProgress(5) || DsiDictationAdapter.this.isRequestInProgress(6)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestProcessVoiceData]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseProcessVoiceData(3, null);
                } else if (DsiDictationAdapter.this.cachedStartDictationResult != 0) {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#requestProcessVoiceData] The DSI reported an error prior to this call. Responding with cached error code.");
                    DsiDictationAdapter.this.setActivationState(1);
                    DsiDictationAdapter.this.listenerProxy.responseProcessVoiceData(DsiDictationAdapter.this.cachedStartDictationResult, null);
                } else {
                    DsiDictationAdapter.this.markRequestInProgress(5);
                    DsiDictationAdapter.this.setActivationState(3);
                    ProcessVoiceDataCommand.schedule(DsiDictationAdapter.this.dictationComponentManager, DsiDictationAdapter.this.cmdMonitor);
                }
            }
        });
    }

    public void requestStopDictation() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                boolean bl;
                DsiDictationAdapter.this.log.log(1000000, "[DsiDictationAdapter#requestStopDictation]");
                boolean bl2 = !DsiDictationAdapter.this.isRequestInProgress(3) && !DsiDictationAdapter.this.isRequestInProgress(4) && !DsiDictationAdapter.this.isRequestInProgress(5) && !DsiDictationAdapter.this.isRequestInProgress(6);
                boolean bl3 = bl2 && DsiDictationAdapter.this.activationState == 1;
                boolean bl4 = DsiDictationAdapter.this.isRequestInProgress(4) && DsiDictationAdapter.this.activationState == 1;
                boolean bl5 = bl2 && DsiDictationAdapter.this.activationState == 2;
                boolean bl6 = bl = DsiDictationAdapter.this.isRequestInProgress(5) && DsiDictationAdapter.this.activationState == 3;
                if (!(bl3 || bl4 || bl5 || bl)) {
                    DsiDictationAdapter.this.logIllegalRequest("[DsiDictationAdapter#requestStopDictation]", DsiDictationAdapter.this.activationState, DsiDictationAdapter.this.currentRequests);
                    DsiDictationAdapter.this.listenerProxy.responseStopDictation(3);
                } else if (bl3) {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#requestStopDictation] No dictation in progress, signalling OK to the client.");
                    DsiDictationAdapter.this.listenerProxy.responseStopDictation(0);
                } else {
                    DsiDictationAdapter.this.markRequestInProgress(6);
                    DsiDictationAdapter.this.cmdMonitor.stopMonitoredLists("[DsiDictationAdapter#requestStopDictation] has been called.");
                    StopDictationCommand.schedule(DsiDictationAdapter.this.dictationComponentManager, DsiDictationAdapter.this.cmdMonitor);
                }
            }
        });
    }

    void handleSetLanguageResult(final int n, final String string, final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleSetLanguageResult] result = %1, languageCode = %2, isFallbackLanguage = %3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(bl));
                if (n == 0) {
                    String string3 = DsiDictationAdapter.this.language;
                    String string2 = DsiDictationAdapter.this.fallbackLanguage;
                    if (!bl) {
                        string3 = string;
                    } else {
                        string2 = string;
                    }
                    DsiDictationAdapter.this.setLanguage(string3, string2);
                }
                if (!bl) {
                    DsiDictationAdapter.this.listenerProxy.responseSetLanguage(n);
                } else {
                    DsiDictationAdapter.this.listenerProxy.responseSetFallbackLanguage(n);
                }
                DsiDictationAdapter.this.markRequestCompleted(bl ? 1 : 0);
            }
        });
    }

    void handleActivateDictationResult(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleActivateDictationResult] result = %1", (long)n);
                if (DsiDictationAdapter.this.isRequestInProgress(3)) {
                    if (n == 0) {
                        DsiDictationAdapter.this.setActivationState(1);
                    } else {
                        DsiDictationAdapter.this.setActivationState(0);
                    }
                    DsiDictationAdapter.this.listenerProxy.responseActivateDictation(n);
                    DsiDictationAdapter.this.markRequestCompleted(3);
                } else {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleActivateDictationResult] Discarding obsolete result.");
                }
            }
        });
    }

    void handleProcessVoiceDataResult(final int n, final DictationValueSentence dictationValueSentence) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleProcessVoiceDataResult] result = %1", (long)n);
                if (DsiDictationAdapter.this.isRequestInProgress(5)) {
                    int n2 = n;
                    LinkedList linkedList = new LinkedList();
                    if (n == 0) {
                        DsiDictationAdapter.this.setServiceProviderInfo(new ServiceProviderInfo(dictationValueSentence));
                        try {
                            linkedList = DsiDictationAdapter.this.transcriptPreprocessor.preprocessTranscript(dictationValueSentence);
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DsiDictationAdapter.this.log, exception, "[DsiDictationAdapter#handleProcessVoiceDataResult]");
                            n2 = 1;
                        }
                    }
                    DsiDictationAdapter.this.setActivationState(1);
                    DsiDictationAdapter.this.listenerProxy.responseProcessVoiceData(n2, linkedList);
                    DsiDictationAdapter.this.markRequestCompleted(5);
                } else {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleProcessVoiceDataResult] Discarding obsolete result.");
                }
            }
        });
    }

    void handleStartDictationResult(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleStartDictationResult] result = %1", (long)n);
                if (DsiDictationAdapter.this.isRequestInProgress(4)) {
                    if (n == 0) {
                        DsiDictationAdapter.this.setActivationState(2);
                    } else {
                        DsiDictationAdapter.this.setActivationState(0);
                    }
                    DsiDictationAdapter.this.listenerProxy.responseStartDictation(n);
                    DsiDictationAdapter.this.markRequestCompleted(4);
                } else {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleStartDictationResult] Discarding obsolete result.");
                }
            }
        });
    }

    void handleStopDictationResult(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleStopDictationResult] result = %1", (long)n);
                if (DsiDictationAdapter.this.isRequestInProgress(6)) {
                    if (n == 0) {
                        DsiDictationAdapter.this.setActivationState(1);
                    } else {
                        DsiDictationAdapter.this.setActivationState(0);
                    }
                    DsiDictationAdapter.this.listenerProxy.responseStopDictation(n);
                    DsiDictationAdapter.this.markRequestCompleted(6);
                } else {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleStopDictationResult] Discarding obsolete result.");
                }
            }
        });
    }

    private void handleDictationResult(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#handleDictationResult] result = %1", (long)n);
                if (DsiDictationAdapter.this.activationState == 2) {
                    DsiDictationAdapter.this.cachedStartDictationResult = n;
                } else {
                    DsiDictationAdapter.this.log.log(100000, "[DsiDictationAdapter#handleDictationResult] Invalid state, ignoring call.");
                }
            }
        });
    }

    private class DsiAccessClient
    implements IDsiAccessClient {
        private DsiAccessClient() {
        }

        public void updateDsiAvailability(final boolean bl) {
            DsiDictationAdapter.this.dispatcher.execute(new Runnable(){

                public void run() {
                    DsiDictationAdapter.this.log.log(10000000, "[DsiDictationAdapter#updateDsiAvailability] dsiAvailable = %1", bl);
                    DsiDictationAdapter.this.setDsiAvailable(bl);
                }
            });
        }
    }

    private class DsiOnlineDictationListener
    extends DsiOnlineDictationEmptyListener {
        private DsiOnlineDictationListener() {
        }

        public void dictationResult(int n) {
            int n2 = AbstractDsiOnlineDictationCommand.mapDsiErrorCode(n);
            DsiDictationAdapter.this.handleDictationResult(n2);
        }
    }
}

