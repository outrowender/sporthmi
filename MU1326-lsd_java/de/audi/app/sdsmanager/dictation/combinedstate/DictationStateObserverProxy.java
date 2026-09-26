/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy$1;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy$2;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy$3;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy$4;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy$5;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy$6;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Collection;
import java.util.LinkedList;

final class DictationStateObserverProxy
implements IDictationStateObserver {
    private final DispatcherBase dispatcher;
    private final LogChannel log;
    private final Collection observers = new LinkedList();
    private volatile long dictationMaxDuration = 0L;
    private volatile int dictationState = 0;

    public DictationStateObserverProxy(DispatcherBase dispatcherBase, LogChannel logChannel) {
        this.dispatcher = dispatcherBase;
        this.log = logChannel;
    }

    void addObserver(IDictationStateObserver iDictationStateObserver) {
        this.dispatcher.execute(new DictationStateObserverProxy$1(this, iDictationStateObserver));
    }

    void removeObserver(IDictationStateObserver iDictationStateObserver) {
        this.dispatcher.execute(new DictationStateObserverProxy$2(this, iDictationStateObserver));
    }

    private synchronized IDictationStateObserver[] getCurrentObservers() {
        Object[] objectArray = new IDictationStateObserver[this.observers.size()];
        objectArray = (IDictationStateObserver[])this.observers.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void updateDictationState(int n) {
        this.dispatcher.execute(new DictationStateObserverProxy$3(this, n));
    }

    @Override
    public void updateDictationMaxDuration(long l) {
        this.dispatcher.execute(new DictationStateObserverProxy$4(this, l));
    }

    @Override
    public void indicateRecordingStarted() {
        this.dispatcher.execute(new DictationStateObserverProxy$5(this));
    }

    @Override
    public void indicateRecordingStopped() {
        this.dispatcher.execute(new DictationStateObserverProxy$6(this));
    }

    static /* synthetic */ LogChannel access$000(DictationStateObserverProxy dictationStateObserverProxy) {
        return dictationStateObserverProxy.log;
    }

    static /* synthetic */ Collection access$100(DictationStateObserverProxy dictationStateObserverProxy) {
        return dictationStateObserverProxy.observers;
    }

    static /* synthetic */ long access$200(DictationStateObserverProxy dictationStateObserverProxy) {
        return dictationStateObserverProxy.dictationMaxDuration;
    }

    static /* synthetic */ int access$300(DictationStateObserverProxy dictationStateObserverProxy) {
        return dictationStateObserverProxy.dictationState;
    }

    static /* synthetic */ int access$302(DictationStateObserverProxy dictationStateObserverProxy, int n) {
        dictationStateObserverProxy.dictationState = n;
        return dictationStateObserverProxy.dictationState;
    }

    static /* synthetic */ IDictationStateObserver[] access$400(DictationStateObserverProxy dictationStateObserverProxy) {
        return dictationStateObserverProxy.getCurrentObservers();
    }

    static /* synthetic */ long access$202(DictationStateObserverProxy dictationStateObserverProxy, long l) {
        dictationStateObserverProxy.dictationMaxDuration = l;
        return dictationStateObserverProxy.dictationMaxDuration;
    }
}

