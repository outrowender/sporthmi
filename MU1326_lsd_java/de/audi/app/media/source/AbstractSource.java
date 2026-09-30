/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.state.SourceStateUpdate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSource
extends AbstractMediaTerminalComponent
implements ISource {
    private static final String LOGCLASS = "AbstractSource";
    protected static final int STATE_INACTIVE = 0;
    protected static final int STATE_ACTIVE = 1;
    protected static final int STATE_DEVICE_ACTIVATED = 2;
    protected static final int CLAMP_S_STATE_UNDEFINED = 0;
    protected static final int CLAMP_S_STATE_OFF = 1;
    protected static final int CLAMP_S_STATE_ON = 2;
    private final Object mutexSourceChangeListener = new Object();
    private final int source;
    private final String srcName;
    private volatile int activeState = 0;
    private volatile List registeredSourceListener;
    private volatile boolean available = false;
    private final Collection updateTypes;

    public AbstractSource(IMediaTerminal iMediaTerminal, int n, String string) {
        super(iMediaTerminal);
        this.source = n;
        this.srcName = string;
        this.registeredSourceListener = new LinkedList();
        this.updateTypes = new ArrayList(1);
    }

    protected abstract ISourceSlot getDefaultEmptySlot(int var1);

    public int getType() {
        return this.source;
    }

    public final String getName() {
        return this.srcName;
    }

    protected final void setActiveState(int n) {
        if (this.logger.main().isInfo()) {
            this.logger.main().log(1000000, "[%1.setActiveState] [%2] '%3'", (Object)LOGCLASS, (Object)this.srcName, (Object)AbstractSource.getActiveSourceStateStr(n));
        }
        this.activeState = n;
    }

    protected final int getActiveState() {
        return this.activeState;
    }

    public final boolean isActive() {
        return this.activeState > 0;
    }

    public final boolean isDeviceActivated() {
        return this.activeState == 2;
    }

    public void deinit() {
    }

    public void deactivate(boolean bl) {
        this.logger.main().log(1000000, "[%1.deactivate] [%2]", (Object)LOGCLASS, (Object)this);
        this.setActiveState(0);
    }

    public ISourceSlot getSlot(int n) {
        try {
            return (ISourceSlot)this.getSlots().get(n);
        }
        catch (Exception exception) {
            this.logger.main().log(100000, "[%1.getSlot] [%2] %3", (Object)LOGCLASS, (Object)this, (Object)exception);
            this.logger.main().log(1000000, "[%1.getSlot] [%2] Slot '%3' not found: %2", (Object)LOGCLASS, (Object)this, (long)n);
            return this.getDefaultEmptySlot(n);
        }
    }

    public ISourceSlot getSlot(ISourceSlot iSourceSlot) {
        try {
            if (iSourceSlot.getSource().getType() != this.getType()) {
                this.logger.main().log(1000000, "[%1.getSlot] [%2] Wrong source type", (Object)LOGCLASS, (Object)this);
                return null;
            }
            return this.getSlot(iSourceSlot.getIndex());
        }
        catch (Exception exception) {
            this.logger.main().log(100000, "[%1.getSlot] [%2] %3", (Object)LOGCLASS, (Object)this, (Object)exception);
            this.logger.main().log(1000000, "[%1.getSlot] [%2] Slot '%3' not found", (Object)LOGCLASS, (Object)this, (long)iSourceSlot.getIndex());
            return this.getDefaultEmptySlot(iSourceSlot.getIndex());
        }
    }

    protected static final boolean isValidSlot(List list, int n) {
        return n >= 0 && list.size() > n;
    }

    public final boolean isEmpty() {
        Iterator iterator = this.getSlots().iterator();
        while (iterator.hasNext()) {
            ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
            if (iSourceSlot.isEmpty()) continue;
            return false;
        }
        return true;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public final void setAvailable(boolean bl) {
        if (this.available == bl) {
            return;
        }
        this.available = bl;
        List list = this.getSourceListener();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((ISourceListener)iterator.next()).sourceAvailable(this, this.available);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void addSourceListener(ISourceListener iSourceListener) {
        this.logger.main().log(1000000, "[%1.addSourceListener] [%2] '%3'", (Object)LOGCLASS, (Object)this.getName(), (Object)iSourceListener);
        if (iSourceListener == null) {
            throw new IllegalArgumentException();
        }
        Object object = this.mutexSourceChangeListener;
        synchronized (object) {
            if (this.registeredSourceListener.contains(iSourceListener)) {
                this.logger.main().log(1000000, "[%1.addSourceListener] [%2] Already added.", (Object)LOGCLASS, (Object)this);
                return;
            }
            LinkedList linkedList = new LinkedList(this.registeredSourceListener);
            linkedList.add(iSourceListener);
            this.registeredSourceListener = linkedList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void removeSourceListener(ISourceListener iSourceListener) {
        this.logger.main().log(1000000, "[%1.removeSourceListener] [%2] '%3'", (Object)LOGCLASS, (Object)this.getName(), (Object)iSourceListener);
        Object object = this.mutexSourceChangeListener;
        synchronized (object) {
            LinkedList linkedList = new LinkedList(this.registeredSourceListener);
            if (linkedList.remove(iSourceListener)) {
                this.registeredSourceListener = linkedList;
            }
        }
    }

    List getSourceListener() {
        return this.registeredSourceListener;
    }

    public void addSlotListener(ISourceSlotListener iSourceSlotListener, boolean bl) {
        this.getTerminal().getSourceController().addSourceSlotListener(this, iSourceSlotListener, bl);
    }

    public void removeSlotListener(ISourceSlotListener iSourceSlotListener) {
        this.getTerminal().getSourceController().removeSlotListener(this, iSourceSlotListener);
    }

    public boolean processSourceStateUpdate(SourceStateUpdate sourceStateUpdate) {
        switch (sourceStateUpdate.getType()) {
            case 2: {
                this.logger.main().log(10000000, "[%1.processSourceStateUpdate] [%2] UPDATE_TYPE_AVAILABILITY available=%3", (Object)LOGCLASS, (Object)this, (Object)((Boolean)sourceStateUpdate.getUpdate()).toString());
                this.setAvailable((Boolean)sourceStateUpdate.getUpdate());
                return true;
            }
        }
        throw new RuntimeException("Override this method if source specific handling is required");
    }

    public Collection getUpdateTypes() {
        return this.updateTypes;
    }

    protected final void addUpdateType(int n) {
        this.updateTypes.add(new Integer(n));
    }

    public boolean equals(Object object) {
        try {
            return ((AbstractSource)object).getType() == this.getType();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return this.getType();
    }

    private static String getActiveSourceStateStr(int n) {
        switch (n) {
            case 0: {
                return "INACTIVE";
            }
            case 1: {
                return "ACTIVE";
            }
            case 2: {
                return "DEVICE ACTIVATED";
            }
        }
        return "UNKNOWN";
    }

    public int getSlotNumberByPartition(int n, int n2) {
        return n;
    }

    public ISourceSlot getActivatableSlot(ISourceSlot iSourceSlot) {
        return iSourceSlot;
    }

    public boolean isLastSelectedSlot(ISourceSlot iSourceSlot) {
        return true;
    }

    public int getNumberOfSlots() {
        return this.getSlots().size();
    }

    public String toString() {
        return this.getName();
    }
}

