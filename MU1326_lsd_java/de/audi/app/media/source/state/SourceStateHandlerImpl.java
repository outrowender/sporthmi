/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.state.ISourceStateHandler;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.RegisteredSource;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.app.media.util.CopyOnWriteMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SourceStateHandlerImpl
implements ISourceStateUpdater,
ISourceStateHandler,
ISourceResolver {
    private static final String LOGCLASS = "SourceStateHandlerImpl";
    private static final int AMOUNT_OF_SOURCES_LIKELY_TO_BE_CHANGED = 2;
    private final LogChannel logger;
    private final DispatcherBase dispatcher;
    private final Map registeredSourcesMap;
    private final CopyOnWriteArrayList multipleSourceSlotListeners;

    public SourceStateHandlerImpl(LogChannel logChannel, DispatcherBase dispatcherBase) {
        if (logChannel == null || dispatcherBase == null) {
            throw new IllegalArgumentException("Parameter cannot ne null");
        }
        this.logger = logChannel;
        this.dispatcher = dispatcherBase;
        this.registeredSourcesMap = new CopyOnWriteMap(14);
        this.multipleSourceSlotListeners = new CopyOnWriteArrayList(0);
    }

    public synchronized void registerSource(ISource iSource) {
        this.logger.log(1000000, "[%1.registerSource] '%2'.", (Object)LOGCLASS, (Object)iSource);
        this.registeredSourcesMap.put(new Integer(iSource.getType()), new RegisteredSource(iSource, this.logger));
    }

    public void addSourceSlotListener(IMultipleSourceSlotListener iMultipleSourceSlotListener) {
        this.logger.log(1000000, "[%1.addSourceSlotListener] '%2'.", (Object)LOGCLASS, (Object)iMultipleSourceSlotListener);
        this.multipleSourceSlotListeners.addIfAbsent(iMultipleSourceSlotListener);
    }

    public synchronized void addSourceSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener, boolean bl) {
        this.logger.log(1000000, "[%1.addSourceSlotListener] [%2] '%3' %4", (Object)LOGCLASS, (Object)iSource, (Object)iSourceSlotListener, (Object)(bl ? "NOTIFY" : ""));
        if (iSource == null || iSourceSlotListener == null) {
            throw new IllegalArgumentException();
        }
        RegisteredSource registeredSource = (RegisteredSource)this.registeredSourcesMap.get(new Integer(iSource.getType()));
        registeredSource.addSourceSlotListener(iSourceSlotListener);
        if (bl) {
            this.dispatcher.execute(new JobNotifyOnAdd(registeredSource));
        }
    }

    public synchronized void removeSlotListener(ISource iSource, ISourceSlotListener iSourceSlotListener) {
        this.logger.log(1000000, "[%1.removeSlotListener] [%2] '%3'", (Object)LOGCLASS, (Object)iSource, (Object)iSourceSlotListener);
        RegisteredSource registeredSource = (RegisteredSource)this.registeredSourcesMap.get(new Integer(iSource.getType()));
        registeredSource.removeSlotListener(iSourceSlotListener);
    }

    public ISourceStateUpdater getSourceStateUpdater() {
        return this;
    }

    public synchronized void updateSourceState(SourceStateUpdate sourceStateUpdate) {
        this.logger.log(1000000, "[%1.updateSourceState] '%2'", (Object)LOGCLASS, (Object)sourceStateUpdate);
        ArrayList arrayList = new ArrayList(3);
        Iterator iterator = this.registeredSourcesMap.values().iterator();
        while (iterator.hasNext()) {
            boolean bl;
            RegisteredSource registeredSource = (RegisteredSource)iterator.next();
            if (!registeredSource.getSource().getUpdateTypes().contains(Integers.valueOf(sourceStateUpdate.getType())) || !(bl = registeredSource.getSource().processSourceStateUpdate(sourceStateUpdate))) continue;
            arrayList.add(registeredSource);
        }
        if (arrayList.isEmpty()) {
            this.logger.log(1000000, "[%1.updateSourceState] Nothing changed", (Object)LOGCLASS);
            return;
        }
        this.logSourceState(arrayList);
        this.notifySlotListeners(arrayList);
        this.notifyMultipleSourceSlotListeners(arrayList);
    }

    public synchronized void updateSourceSlots(Map map) {
        this.logger.log(1000000, "[%1.updateSourceSlots]", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(2);
        Iterator iterator = this.registeredSourcesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer n = (Integer)entry.getKey();
            RegisteredSource registeredSource = (RegisteredSource)entry.getValue();
            List list = (List)map.get(n);
            if (list == null || !registeredSource.getSource().processSourceStateUpdate(new SourceStateUpdate(1, list))) continue;
            arrayList.add(registeredSource);
        }
        if (arrayList.isEmpty()) {
            this.logger.log(1000000, "[%1.updateSourceSlots] Source state not changed.", (Object)LOGCLASS);
            return;
        }
        this.logSourceState(arrayList);
        this.notifySlotListeners(arrayList);
        this.notifyMultipleSourceSlotListeners(arrayList);
    }

    public synchronized void updateSourceAvailability(int n, Map map) {
        this.logger.log(1000000, "[%1.updateSourceAvailability]", (Object)LOGCLASS);
        Iterator iterator = this.registeredSourcesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer n2 = (Integer)entry.getKey();
            RegisteredSource registeredSource = (RegisteredSource)entry.getValue();
            Boolean bl = (Boolean)map.get(n2);
            if (bl == null) continue;
            registeredSource.getSource().processSourceStateUpdate(new SourceStateUpdate(n, bl));
        }
    }

    public synchronized void updateNumberOfSlots(Map map) {
        this.logger.log(1000000, "[%1.updateNumberOfSlots]", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(map.size());
        Iterator iterator = this.registeredSourcesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer n = (Integer)entry.getKey();
            RegisteredSource registeredSource = (RegisteredSource)entry.getValue();
            Integer n2 = (Integer)map.get(n);
            if (n2 == null) continue;
            arrayList.add(registeredSource);
            registeredSource.getSource().processSourceStateUpdate(new SourceStateUpdate(15, n2));
        }
        if (arrayList.isEmpty()) {
            this.logger.log(1000000, "[%1.updateSourceSlots] Source state not changed.", (Object)LOGCLASS);
            return;
        }
        this.notifySlotListeners(arrayList);
        this.notifyMultipleSourceSlotListeners(arrayList);
    }

    public synchronized MediaSourceSlot getSourceSlot(long l, long l2) {
        Iterator iterator = this.registeredSourcesMap.values().iterator();
        while (iterator.hasNext()) {
            ISource iSource = ((RegisteredSource)iterator.next()).getSource();
            Iterator iterator2 = iSource.getSlots().iterator();
            while (iterator2.hasNext()) {
                MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iterator2.next();
                if (mediaSourceSlot.getDeviceID() != l || mediaSourceSlot.getMediaID() != l2) continue;
                return mediaSourceSlot;
            }
        }
        return null;
    }

    public synchronized MediaSourceSlot getSourceSlot(long l, String string) {
        Iterator iterator = this.registeredSourcesMap.values().iterator();
        while (iterator.hasNext()) {
            ISource iSource = ((RegisteredSource)iterator.next()).getSource();
            Iterator iterator2 = iSource.getSlots().iterator();
            while (iterator2.hasNext()) {
                MediaSourceSlot mediaSourceSlot = (MediaSourceSlot)iterator2.next();
                if ((long)mediaSourceSlot.getSource().getType() != l || !Util.equals(mediaSourceSlot.getUniqueMediaId(), string)) continue;
                return mediaSourceSlot;
            }
        }
        return null;
    }

    private void notifySlotListeners(Collection collection) {
        this.logger.log(10000000, "[%1.notifySlotListeners]", (Object)LOGCLASS);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            RegisteredSource registeredSource = (RegisteredSource)iterator.next();
            try {
                registeredSource.notifySlotChanged();
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifySlotListeners] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyMultipleSourceSlotListeners(Collection collection) {
        Object object;
        this.logger.log(10000000, "[%1.notifyMultipleSourceSlotListeners]", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(14);
        ISource[] iSourceArray = collection.iterator();
        while (iSourceArray.hasNext()) {
            object = (RegisteredSource)iSourceArray.next();
            arrayList.add(((RegisteredSource)object).getSource());
        }
        iSourceArray = (ISource[])arrayList.toArray(new ISource[arrayList.size()]);
        object = this.multipleSourceSlotListeners.iterator();
        while (object.hasNext()) {
            IMultipleSourceSlotListener iMultipleSourceSlotListener = (IMultipleSourceSlotListener)object.next();
            try {
                iMultipleSourceSlotListener.slotsChanged(iSourceArray);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyMultipleSourceSlotListeners] %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void logSourceState(Collection collection) {
        if (!this.logger.isInfo()) {
            return;
        }
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ISource iSource = ((RegisteredSource)iterator.next()).getSource();
            if (!iSource.getSlots().isEmpty()) {
                Iterator iterator2 = iSource.getSlots().iterator();
                while (iterator2.hasNext()) {
                    this.logger.log(1000000, "[%1.logSourceState] %2", (Object)LOGCLASS, iterator2.next());
                }
                continue;
            }
            this.logger.log(1000000, "[%1.logSourceState] [%2] <EMPTY>", (Object)LOGCLASS, (Object)iSource);
        }
    }

    private class JobNotifyOnAdd
    implements Runnable {
        private final RegisteredSource registeredSource;

        public JobNotifyOnAdd(RegisteredSource registeredSource) {
            this.registeredSource = registeredSource;
        }

        public void run() {
            if (this.registeredSource.getSource().getSlots().isEmpty()) {
                SourceStateHandlerImpl.this.logger.log(1000000, "[%1.onAddSourceSlotListener] [%2] No slots available.", (Object)SourceStateHandlerImpl.LOGCLASS, (Object)this.registeredSource.getSource());
                return;
            }
            SourceStateHandlerImpl.this.logger.log(1000000, "[%1.onAddSourceSlotListener] [%2]", (Object)SourceStateHandlerImpl.LOGCLASS, (Object)this.registeredSource.getSource());
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.registeredSource);
            SourceStateHandlerImpl.this.notifySlotListeners(arrayList);
        }

        public String toString() {
            return new Buffer().append("SourceStateHandlerImpl.addSourceSlotListener('").append(this.registeredSource.getSource()).append("')").toString();
        }
    }
}

