/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state;

import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;

public class RegisteredSource
implements Comparable {
    private final ISource source;
    private final CopyOnWriteArrayList registeredSourceSlotListeners;
    private final LogChannel logger;
    private static final String LOGCLASS = "RegisteredSource";

    public RegisteredSource(ISource iSource, LogChannel logChannel) {
        this.source = iSource;
        this.registeredSourceSlotListeners = new CopyOnWriteArrayList();
        this.logger = logChannel;
    }

    public ISource getSource() {
        return this.source;
    }

    public void addSourceSlotListener(ISourceSlotListener iSourceSlotListener) {
        if (iSourceSlotListener == null) {
            throw new IllegalArgumentException();
        }
        this.registeredSourceSlotListeners.addIfAbsent(iSourceSlotListener);
    }

    public void removeSlotListener(ISourceSlotListener iSourceSlotListener) {
        this.registeredSourceSlotListeners.remove(iSourceSlotListener);
    }

    public final void notifySlotChanged() {
        Iterator iterator = this.registeredSourceSlotListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISourceSlotListener)iterator.next()).slotsChanged(this.getSource());
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifySlotChanged] Exception occured: %2", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public int compareTo(Object object) {
        return this.source.getType() - ((RegisteredSource)object).source.getType();
    }
}

