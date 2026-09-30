/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
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

    void addObserver(final IDictationStateObserver iDictationStateObserver) {
        this.dispatcher.execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                DictationStateObserverProxy.this.log.log(10000000, "[DictationStateObserverProxy#addObserver] observer = %1", (Object)iDictationStateObserver);
                DictationStateObserverProxy dictationStateObserverProxy = DictationStateObserverProxy.this;
                synchronized (dictationStateObserverProxy) {
                    DictationStateObserverProxy.this.observers.add(iDictationStateObserver);
                }
                try {
                    iDictationStateObserver.updateDictationMaxDuration(DictationStateObserverProxy.this.dictationMaxDuration);
                    iDictationStateObserver.updateDictationState(DictationStateObserverProxy.this.dictationState);
                }
                catch (Exception exception) {
                    DictationUtil.logException(DictationStateObserverProxy.this.log, exception, "[DictationStateObserverProxy#addObserver]");
                }
            }
        });
    }

    void removeObserver(final IDictationStateObserver iDictationStateObserver) {
        this.dispatcher.execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                DictationStateObserverProxy.this.log.log(10000000, "[DictationStateObserverProxy#removeObserver] observer = %1", (Object)iDictationStateObserver);
                DictationStateObserverProxy dictationStateObserverProxy = DictationStateObserverProxy.this;
                synchronized (dictationStateObserverProxy) {
                    DictationStateObserverProxy.this.observers.remove(iDictationStateObserver);
                }
            }
        });
    }

    private synchronized IDictationStateObserver[] getCurrentObservers() {
        Object[] objectArray = new IDictationStateObserver[this.observers.size()];
        objectArray = (IDictationStateObserver[])this.observers.toArray(objectArray);
        return objectArray;
    }

    public void updateDictationState(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DictationStateObserverProxy.this.log.log(1000000, "[DictationStateObserverProxy#updateDictationState] dictationState = %1", (long)n);
                if (DictationStateObserverProxy.this.dictationState != n) {
                    DictationStateObserverProxy.this.dictationState = n;
                    IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.this.getCurrentObservers();
                    for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
                        try {
                            iDictationStateObserverArray[i2].updateDictationState(n);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DictationStateObserverProxy.this.log, exception, "[DictationStateObserverProxy#updateDictationState]");
                        }
                    }
                }
            }
        });
    }

    public void updateDictationMaxDuration(final long l) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DictationStateObserverProxy.this.log.log(10000000, "[DictationStateObserverProxy#updateDictationMaxDuration] dictationMaxDuration = %1", l);
                if (DictationStateObserverProxy.this.dictationMaxDuration != l) {
                    DictationStateObserverProxy.this.dictationMaxDuration = l;
                    IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.this.getCurrentObservers();
                    for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
                        try {
                            iDictationStateObserverArray[i2].updateDictationMaxDuration(l);
                            continue;
                        }
                        catch (Exception exception) {
                            DictationUtil.logException(DictationStateObserverProxy.this.log, exception, "[DictationStateObserverProxy#updateDictationMaxDuration]");
                        }
                    }
                }
            }
        });
    }

    public void indicateRecordingStarted() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DictationStateObserverProxy.this.log.log(1000000, "[DictationStateObserverProxy#indicateRecordingStarted]");
                IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.this.getCurrentObservers();
                for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
                    try {
                        iDictationStateObserverArray[i2].indicateRecordingStarted();
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DictationStateObserverProxy.this.log, exception, "[DictationStateObserverProxy#indicateRecordingStarted]");
                    }
                }
            }
        });
    }

    public void indicateRecordingStopped() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DictationStateObserverProxy.this.log.log(1000000, "[DictationStateObserverProxy#indicateRecordingStopped]");
                IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.this.getCurrentObservers();
                for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
                    try {
                        iDictationStateObserverArray[i2].indicateRecordingStopped();
                        continue;
                    }
                    catch (Exception exception) {
                        DictationUtil.logException(DictationStateObserverProxy.this.log, exception, "[DictationStateObserverProxy#indicateRecordingStopped]");
                    }
                }
            }
        });
    }
}

