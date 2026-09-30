/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.app.car.common.mer.SlotMenuEntry;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class IncludeMenuEntry
extends MenuEntry {
    private final int[] acceptedSlotIDs;
    private boolean isCurrentlyMoving = false;

    public IncludeMenuEntry(int n, String string, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int[] nArray) {
        super(n, string, iFrameworkAccess, logChannel);
        this.state = 1;
        this.acceptedSlotIDs = nArray != null ? nArray : new int[0];
    }

    public boolean isBoundToSlot() {
        return this.getParent() != null;
    }

    protected boolean isBoundToSlot(SlotMenuEntry slotMenuEntry) {
        return this.isBoundToSlot() && this.getParent().equals(slotMenuEntry);
    }

    protected boolean acceptsSlotCandidate(SlotMenuEntry slotMenuEntry) {
        for (int i2 = 0; i2 < this.acceptedSlotIDs.length; ++i2) {
            if (this.acceptedSlotIDs[i2] != slotMenuEntry.getID()) continue;
            return true;
        }
        return false;
    }

    public boolean moveToSlot(SlotMenuEntry slotMenuEntry) {
        boolean bl = false;
        if (this.acceptsSlotCandidate(slotMenuEntry)) {
            bl = this.rebindBidirectionalSlotIncludeConnection(slotMenuEntry);
        } else if (this.logChannel.isInfo()) {
            this.logChannel.log(1000000, "[%1('%2')#moveToSlot] didn't accept target %3('%4')", (Object)this.getType(), (Object)this, (Object)slotMenuEntry.getType(), (Object)slotMenuEntry);
        }
        this.updateState(this.getState());
        return bl;
    }

    private boolean rebindBidirectionalSlotIncludeConnection(SlotMenuEntry slotMenuEntry) {
        if (this.isBoundToSlot(slotMenuEntry)) {
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[%1('%2')#rebindBidirectionalSlotIncludeConnection] menu entry is already bound to target %3('%4')", (Object)this.getType(), (Object)this, (Object)slotMenuEntry.getType(), (Object)slotMenuEntry);
            }
            return false;
        }
        SlotMenuEntry slotMenuEntry2 = (SlotMenuEntry)this.getParent();
        this.leaveSlot();
        this.isCurrentlyMoving = true;
        boolean bl = slotMenuEntry.bindMenuEntry(this);
        if (!bl && slotMenuEntry2 != null) {
            slotMenuEntry2.bindMenuEntry(this);
        }
        return bl;
    }

    public void setParent(IMenuEntry iMenuEntry) {
        if (iMenuEntry == null || iMenuEntry.isType(MenuEntryType.SLOT_MENU_ENTRY) && this.isCurrentlyMoving) {
            super.setParent(iMenuEntry);
            this.isCurrentlyMoving = false;
        } else {
            this.logChannel.log(1000, "[IncludeMenuEntry('%1')#setParent] setParent was called in the wrong context: parent %2='%3', isIncludeMECurrentlyMoving='%4'", (Object)this, (Object)iMenuEntry.getType(), (Object)iMenuEntry, (Object)this.isCurrentlyMoving);
        }
    }

    public boolean leaveSlot() {
        if (this.getParent() != null) {
            return ((SlotMenuEntry)this.getParent()).releaseMenuEntry();
        }
        return false;
    }

    public boolean isLeaf() {
        return false;
    }

    public MenuEntryType getType() {
        return MenuEntryType.INCLUDE_MENU_ENTRY;
    }

    protected void setState(int n) {
        this.logChannel.log(1000000, "[%1('%2')#setState] state='%3'", (Object)this.getType(), (Object)this, (long)n);
        this.state = n;
    }

    public void updateState(int n) {
        int n2 = this.getState();
        super.updateState(n);
        if (n2 == this.getState() && this.isBoundToSlot()) {
            this.getParent().updateState(this.getState());
        }
    }

    public boolean isRegistrable() {
        return false;
    }

    public int[] getAcceptedSlotIDs() {
        return this.acceptedSlotIDs;
    }
}

