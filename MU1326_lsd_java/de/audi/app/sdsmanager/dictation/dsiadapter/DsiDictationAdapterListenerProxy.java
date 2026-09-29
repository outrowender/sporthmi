/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$1;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$10;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$11;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$12;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$13;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$14;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$2;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$3;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$4;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$5;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$6;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$7;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$8;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy$9;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
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

    void addListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$1(this, iDsiDictationAdapterListener));
    }

    void removeListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$2(this, iDsiDictationAdapterListener));
    }

    private synchronized IDsiDictationAdapterListener[] getCurrentListeners() {
        Object[] objectArray = new IDsiDictationAdapterListener[this.listeners.size()];
        objectArray = (IDsiDictationAdapterListener[])this.listeners.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void responseSetLanguage(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$3(this, n));
    }

    @Override
    public void responseSetFallbackLanguage(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$4(this, n));
    }

    @Override
    public void responseSetUserId(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$5(this, n));
    }

    @Override
    public void responseActivateDictation(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$6(this, n));
    }

    @Override
    public void responseStartDictation(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$7(this, n));
    }

    @Override
    public void responseProcessVoiceData(int n, LinkedList linkedList) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$8(this, n, linkedList));
    }

    @Override
    public void responseStopDictation(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$9(this, n));
    }

    @Override
    public void updateLanguage(String string, String string2) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$10(this, string, string2));
    }

    @Override
    public void updateUserId(String string) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$11(this, string));
    }

    @Override
    public void updateActivationState(int n) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$12(this, n));
    }

    @Override
    public void updateServiceProviderInfo(ServiceProviderInfo serviceProviderInfo) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$13(this, serviceProviderInfo));
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
        this.dispatcher.execute(new DsiDictationAdapterListenerProxy$14(this, bl));
    }

    static /* synthetic */ LogChannel access$000(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.log;
    }

    static /* synthetic */ Collection access$100(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.listeners;
    }

    static /* synthetic */ String access$200(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.language;
    }

    static /* synthetic */ String access$300(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.fallbackLanguage;
    }

    static /* synthetic */ String access$400(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.userId;
    }

    static /* synthetic */ int access$500(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.activationState;
    }

    static /* synthetic */ ServiceProviderInfo access$600(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.serviceProviderInfo;
    }

    static /* synthetic */ boolean access$700(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.dsiAvailable;
    }

    static /* synthetic */ IDsiDictationAdapterListener[] access$800(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy) {
        return dsiDictationAdapterListenerProxy.getCurrentListeners();
    }

    static /* synthetic */ String access$202(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, String string) {
        dsiDictationAdapterListenerProxy.language = string;
        return dsiDictationAdapterListenerProxy.language;
    }

    static /* synthetic */ String access$302(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, String string) {
        dsiDictationAdapterListenerProxy.fallbackLanguage = string;
        return dsiDictationAdapterListenerProxy.fallbackLanguage;
    }

    static /* synthetic */ String access$402(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, String string) {
        dsiDictationAdapterListenerProxy.userId = string;
        return dsiDictationAdapterListenerProxy.userId;
    }

    static /* synthetic */ int access$502(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, int n) {
        dsiDictationAdapterListenerProxy.activationState = n;
        return dsiDictationAdapterListenerProxy.activationState;
    }

    static /* synthetic */ ServiceProviderInfo access$602(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, ServiceProviderInfo serviceProviderInfo) {
        dsiDictationAdapterListenerProxy.serviceProviderInfo = serviceProviderInfo;
        return dsiDictationAdapterListenerProxy.serviceProviderInfo;
    }

    static /* synthetic */ boolean access$702(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, boolean bl) {
        dsiDictationAdapterListenerProxy.dsiAvailable = bl;
        return dsiDictationAdapterListenerProxy.dsiAvailable;
    }
}

