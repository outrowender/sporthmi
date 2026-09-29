/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.source.IMultipleSourceSlotListener;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceListListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SourceListProvider
implements IMultipleSourceSlotListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final Object sourceListListenerMutx = new Object();
    private volatile HashMap completeSourceListMap = new HashMap(14);
    private volatile List sourceListListener = new ArrayList(0);

    public SourceListProvider(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"SourceListProvider");
        this.sourceListListener.clear();
        this.completeSourceListMap.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addSourceListListener(ISourceListListener iSourceListListener) {
        this.logger.log(1078071040, "[%1.addSourceListListener] '%2'", (Object)"SourceListProvider", (Object)iSourceListListener);
        Object object = this.sourceListListenerMutx;
        synchronized (object) {
            if (this.sourceListListener.contains(iSourceListListener)) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.sourceListListener.size() + 1);
            arrayList.addAll(this.sourceListListener);
            arrayList.add(iSourceListListener);
            this.sourceListListener = arrayList;
        }
        if (this.completeSourceListMap.isEmpty()) {
            return;
        }
        iSourceListListener.sourceListChanged(this.completeSourceListMap);
    }

    private void notifySourceListListener() {
        this.logger.log(-2137614336, "[%1.notifySourceListListener]", (Object)"SourceListProvider");
        Iterator iterator = this.sourceListListener.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISourceListListener)iterator.next()).sourceListChanged(this.completeSourceListMap);
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.notifySourceListListener] %2", (Object)"SourceListProvider", (Throwable)exception);
            }
        }
    }

    @Override
    public void slotsChanged(ISource[] iSourceArray) {
        this.logger.log(-2137614336, "[%1.slotsChanged]", (Object)"SourceListProvider");
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            ISource iSource = iSourceArray[i2];
            if (MediaUtils.isInternalSource(iSource.getType())) continue;
            LinkedList linkedList = (LinkedList)this.completeSourceListMap.get(Integers.valueOf(iSource.getType()));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.completeSourceListMap.put(Integers.valueOf(iSource.getType()), linkedList);
            }
            linkedList.clear();
            linkedList.addAll(iSource.getSlots());
        }
        this.notifySourceListListener();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("SourceListProvider").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

