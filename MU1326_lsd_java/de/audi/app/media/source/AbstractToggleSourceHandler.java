/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISourceListListener;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractToggleSourceHandler
extends AbstractMediaTerminalComponent
implements ISourceListListener {
    private static final String LOGCLASS = "AbstractToggleSourceHandler";
    private final int[] sourceOrder;
    protected final Object listUpdateMutex = new Object();
    private List sources;
    public static final List EMPTY_RESULT = Collections.unmodifiableList(new ArrayList());
    private static final int INITIAL_CAPACITY = 10;

    public AbstractToggleSourceHandler(IMediaTerminal iMediaTerminal, int[] nArray) {
        super(iMediaTerminal);
        this.sourceOrder = nArray;
        this.sources = new ArrayList(10);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getTerminal().getSourceController().addSourceListListener(this);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    protected ISourceSlot getNextEntry(ISourceSlot iSourceSlot) {
        List list = this.getNextNEntries(iSourceSlot, 1);
        if (!list.isEmpty()) {
            return (ISourceSlot)list.get(0);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getNextNEntries(ISourceSlot iSourceSlot, int n) {
        this.logger.main().log(1000000, "[%1.getNextNSlots] Starting from %3. Get the next %2 slots.", (Object)LOGCLASS, (Object)iSourceSlot, (long)n);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            Iterator iterator = this.findEntry(iSourceSlot);
            if (null == iterator) {
                this.logger.main().log(1000000, "[%1.getNextNSlots] Entry not found. Returning empty list.", (Object)LOGCLASS);
                return EMPTY_RESULT;
            }
            this.logger.main().log(10000000, "[%1.getNextNSlots] Found item! ", (Object)LOGCLASS);
            int n2 = this.sources.size() - 1;
            int n3 = n < n2 ? n : n2;
            this.logger.main().log(10000000, "[%1.getNextNSlots] Get the next %2 items", (Object)LOGCLASS, (long)n3);
            return this.getFollowingEntries(iterator, n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ISourceSlot getFirstEntry() {
        this.logger.main().log(1000000, "[%1.getFirstSlot]", (Object)LOGCLASS);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            if (!this.sources.isEmpty()) {
                ISourceSlot iSourceSlot = (ISourceSlot)this.sources.get(0);
                this.logger.main().log(10000000, "[%1.getFirstSlot] Returning %2.", (Object)LOGCLASS, (Object)iSourceSlot);
                return iSourceSlot;
            }
        }
        this.logger.main().log(1000000, "[%1.getFirstSlot] No sources.", (Object)LOGCLASS);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ISourceSlot getActiveEntry() {
        this.logger.main().log(1000000, "[%1.getActiveSlot] Enter.", (Object)LOGCLASS);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
            if (this.isSlotPlayable(iSourceSlot) && this.sources.contains(iSourceSlot)) {
                return iSourceSlot;
            }
            return null;
        }
    }

    protected List getAllEntries() {
        return this.sources;
    }

    protected void activate(final ISourceSlot iSourceSlot) {
        if (null == iSourceSlot) {
            this.logger.main().log(10000000, "[%1.activate] Entry is null", (Object)LOGCLASS, (Object)iSourceSlot);
            return;
        }
        this.logger.main().log(1000000, "[%1.activate] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("AbstractToggleSource.activate"){

            public void run() {
                AbstractToggleSourceHandler.this.logger.main().log(1000000, "[%1.activate] '%2'", (Object)AbstractToggleSourceHandler.LOGCLASS, (Object)iSourceSlot);
                AbstractToggleSourceHandler.this.getTerminal().getSourceController().activateSource(new ActivationContext(iSourceSlot));
            }
        });
    }

    public abstract boolean isSlotPlayable(ISourceSlot var1);

    public abstract boolean applyToggleFilter(ISourceSlot var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sourceListChanged(Map map) {
        this.logger.hmi().log(1000000, "[%1.sourceListChanged]", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(10);
        for (int i2 = 0; i2 < this.sourceOrder.length; ++i2) {
            int n = this.sourceOrder[i2];
            List list = (List)map.get(Integers.valueOf(n));
            if (null == list || list.isEmpty()) continue;
            this.logger.hmi().log(100000000, "[%1.sourceListChanged] Slots available for type %2", (Object)LOGCLASS, (long)n);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
                this.logger.hmi().log(100000000, "[%1.sourceListChanged] New SourceSlot: %2", (Object)LOGCLASS, (Object)iSourceSlot);
                if (!this.applyToggleFilter(iSourceSlot)) {
                    this.logger.hmi().log(100000000, "[%1.sourceListChanged] not visible", (Object)LOGCLASS);
                    continue;
                }
                arrayList.add(iSourceSlot);
            }
        }
        this.logger.hmi().log(1000000, "[%1.sourceListChanged] Updating SourceList", (Object)LOGCLASS);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.sources = new ArrayList(arrayList.size());
            this.sources.addAll(arrayList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Iterator findEntry(ISourceSlot iSourceSlot) {
        this.logger.main().log(1000000, "[%1.findSlot]", (Object)LOGCLASS);
        if (null == iSourceSlot) {
            return null;
        }
        Object object = this.listUpdateMutex;
        synchronized (object) {
            Iterator iterator = this.sources.iterator();
            while (iterator.hasNext()) {
                ISourceSlot iSourceSlot2 = (ISourceSlot)iterator.next();
                this.logger.main().log(10000000, "[%1.findSlot] Trying to match: %2", (Object)LOGCLASS, (Object)iSourceSlot2);
                if (!((Object)iSourceSlot).equals(iSourceSlot2)) continue;
                this.logger.main().log(1000000, "[%1.findSlot] Found match: %2!", (Object)LOGCLASS, (Object)iSourceSlot2);
                return iterator;
            }
        }
        this.logger.main().log(1000000, "[%1.findSlot] No entry found!", (Object)LOGCLASS);
        return null;
    }

    private List getFollowingEntries(Iterator iterator, int n) {
        this.logger.main().log(1000000, "[%1.getFollowingItems] ", (Object)LOGCLASS);
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            Object object;
            if (iterator.hasNext()) {
                object = iterator.next();
                this.logger.main().log(10000000, "[%1.getFollowingItems] Adding %2 ", (Object)LOGCLASS, object);
                arrayList.add(object);
                continue;
            }
            this.logger.main().log(10000000, "[%1.getFollowingItems] Reached end. Starting over.", (Object)LOGCLASS);
            iterator = this.sources.iterator();
            object = iterator.next();
            this.logger.main().log(10000000, "[%1.getFollowingItems] Adding %2 after loop", (Object)LOGCLASS, object);
            arrayList.add(object);
        }
        this.logger.main().log(10000000, "[%1.getFollowingItems] Returning with filled list.", (Object)LOGCLASS);
        return arrayList;
    }

    public boolean hasSources() {
        return !this.sources.isEmpty();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

