/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Collection;
import java.util.LinkedList;

final class DsiDictationAdapterListenerProxy
implements IDsiDictationAdapterListener {
    private final DispatcherBase dispatcher;
    private final LogChannel log;
    private final Collection listeners = new LinkedList();
    private volatile String language = "";
    private volatile String fallbackLanguage = "";
    private volatile String userId = "";
    private volatile int activationState = 0;
    private volatile ServiceProviderInfo serviceProviderInfo = new ServiceProviderInfo();
    private volatile boolean dsiAvailable = false;

    public DsiDictationAdapterListenerProxy(DispatcherBase dispatcherBase, LogChannel logChannel) {
        this.dispatcher = dispatcherBase;
        this.log = logChannel;
    }

    void addListener(final IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.dispatcher.execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(10000000, "[DsiDictationAdapterListenerProxy#addListener] listener = %1", (Object)iDsiDictationAdapterListener);
                DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy = DsiDictationAdapterListenerProxy.this;
                synchronized (dsiDictationAdapterListenerProxy) {
                    DsiDictationAdapterListenerProxy.this.listeners.add(iDsiDictationAdapterListener);
                }
                try {
                    iDsiDictationAdapterListener.updateLanguage(DsiDictationAdapterListenerProxy.this.language, DsiDictationAdapterListenerProxy.this.fallbackLanguage);
                    iDsiDictationAdapterListener.updateUserId(DsiDictationAdapterListenerProxy.this.userId);
                    iDsiDictationAdapterListener.updateActivationState(DsiDictationAdapterListenerProxy.this.activationState);
                    iDsiDictationAdapterListener.updateServiceProviderInfo(DsiDictationAdapterListenerProxy.this.serviceProviderInfo);
                    iDsiDictationAdapterListener.updateDsiAvailability(DsiDictationAdapterListenerProxy.this.dsiAvailable);
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#addListener]");
                }
            }
        });
    }

    void removeListener(final IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.dispatcher.execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(10000000, "[DsiDictationAdapterListenerProxy#removeListener] listener = %1", (Object)iDsiDictationAdapterListener);
                DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy = DsiDictationAdapterListenerProxy.this;
                synchronized (dsiDictationAdapterListenerProxy) {
                    DsiDictationAdapterListenerProxy.this.listeners.remove(iDsiDictationAdapterListener);
                }
            }
        });
    }

    private synchronized IDsiDictationAdapterListener[] getCurrentListeners() {
        Object[] objectArray = new IDsiDictationAdapterListener[this.listeners.size()];
        objectArray = (IDsiDictationAdapterListener[])this.listeners.toArray(objectArray);
        return objectArray;
    }

    public void responseSetLanguage(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseSetLanguage] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseSetLanguage(n);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseSetLanguage]");
                    }
                }
            }
        });
    }

    public void responseSetFallbackLanguage(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseSetFallbackLanguage] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseSetFallbackLanguage(n);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseSeresponseSetFallbackLanguagetLanguage]");
                    }
                }
            }
        });
    }

    public void responseSetUserId(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseSetUserId] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseSetUserId(n);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseSetUserId]");
                    }
                }
            }
        });
    }

    public void responseActivateDictation(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseActivateDictation] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseActivateDictation(n);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseActivateDictation]");
                    }
                }
            }
        });
    }

    public void responseStartDictation(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseStartDictation] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseStartDictation(n);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseStartDictation]");
                    }
                }
            }
        });
    }

    public void responseProcessVoiceData(final int n, final LinkedList linkedList) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseProcessVoiceData] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseProcessVoiceData(n, linkedList);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseProcessVoiceData]");
                    }
                }
            }
        });
    }

    public void responseStopDictation(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#responseStopDictation] result = %1", (long)n);
                IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                    try {
                        iDsiDictationAdapterListenerArray[i2].responseStopDictation(n);
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#responseStopDictation]");
                    }
                }
            }
        });
    }

    public void updateLanguage(final String string, final String string2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#updateLanguage] language = %1, fallbackLanguage = %2", (Object)string, (Object)string2);
                if (!DsiDictationAdapterListenerProxy.this.language.equals(string) || !DsiDictationAdapterListenerProxy.this.fallbackLanguage.equals(string2)) {
                    DsiDictationAdapterListenerProxy.this.language = string;
                    DsiDictationAdapterListenerProxy.this.fallbackLanguage = string2;
                    IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                    for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                        try {
                            iDsiDictationAdapterListenerArray[i2].updateLanguage(string, string2);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#updateLanguage]");
                        }
                    }
                }
            }
        });
    }

    public void updateUserId(final String string) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#updateUserId] userId = %1", (Object)string);
                if (!DsiDictationAdapterListenerProxy.this.userId.equals(string)) {
                    DsiDictationAdapterListenerProxy.this.userId = string;
                    IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                    for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                        try {
                            iDsiDictationAdapterListenerArray[i2].updateUserId(string);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#updateUserId]");
                        }
                    }
                }
            }
        });
    }

    public void updateActivationState(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#updateActivationState] activationState = %1", (long)n);
                if (DsiDictationAdapterListenerProxy.this.activationState != n) {
                    DsiDictationAdapterListenerProxy.this.activationState = n;
                    IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                    for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                        try {
                            iDsiDictationAdapterListenerArray[i2].updateActivationState(n);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#updateActivationState]");
                        }
                    }
                }
            }
        });
    }

    public void updateServiceProviderInfo(final ServiceProviderInfo serviceProviderInfo) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#updateServiceProviderInfo] serviceProviderInfo = %1", (Object)serviceProviderInfo);
                if (!DsiDictationAdapterListenerProxy.this.serviceProviderInfo.equals(serviceProviderInfo)) {
                    DsiDictationAdapterListenerProxy.this.serviceProviderInfo = serviceProviderInfo;
                    IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                    for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                        try {
                            iDsiDictationAdapterListenerArray[i2].updateServiceProviderInfo(serviceProviderInfo);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#updateServiceProviderInfo]");
                        }
                    }
                }
            }
        });
    }

    public void updateDsiAvailability(final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DsiDictationAdapterListenerProxy.this.log.log(1000000, "[DsiDictationAdapterListenerProxy#updateDsiAvailability] dsiAvaiable = %1", bl);
                if (DsiDictationAdapterListenerProxy.this.dsiAvailable != bl) {
                    DsiDictationAdapterListenerProxy.this.dsiAvailable = bl;
                    IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.this.getCurrentListeners();
                    for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                        try {
                            iDsiDictationAdapterListenerArray[i2].updateDsiAvailability(bl);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DsiDictationAdapterListenerProxy.this.log, exception, "[DsiDictationAdapterListenerProxy#updateDsiAvailability]");
                        }
                    }
                }
            }
        });
    }
}

