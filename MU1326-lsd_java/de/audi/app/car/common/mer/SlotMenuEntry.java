/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IncludeMenuEntry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public class SlotMenuEntry
extends MenuEntry {
    private final int[] acceptedIncludeMenuEntryIDs;

    public SlotMenuEntry(int n, String string, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int[] nArray) {
        super(n, string, iFrameworkAccess, logChannel);
        this.state = 1;
        this.acceptedIncludeMenuEntryIDs = nArray != null ? nArray : new int[0];
    }

    @Override
    public void setChildren(IMenuEntry[] iMenuEntryArray) {
        this.logChannel.log(1000, "[%1('%2')#setChildren] tried to perform invalid action on slot menu entry", (Object)this.getType(), (Object)this);
    }

    protected boolean bindMenuEntry(IncludeMenuEntry includeMenuEntry) {
        boolean bl = this.acceptsIncludeCandidate(includeMenuEntry);
        String string = "[%1('%2')#bindMenuEntry] didn't accept %3('%4')";
        if (bl) {
            this.releaseMenuEntry();
            super.setChildren(new IMenuEntry[]{includeMenuEntry});
            string = "[%1('%2')#bindMenuEntry] link between virtual menu entries was established: %3('%4')";
        }
        if (this.logChannel.isInfo()) {
            this.logChannel.log(1078071040, string, (Object)this.getType(), (Object)this, (Object)includeMenuEntry.getType(), (Object)includeMenuEntry);
        }
        return bl;
    }

    private boolean acceptsIncludeCandidate(IncludeMenuEntry includeMenuEntry) {
        for (int i2 = 0; i2 < this.acceptedIncludeMenuEntryIDs.length; ++i2) {
            if (this.acceptedIncludeMenuEntryIDs[i2] != includeMenuEntry.getID()) continue;
            return true;
        }
        return false;
    }

    public boolean isEmptySlot() {
        return this.getChildren() == null || this.getChildren().length < 1 || this.getChildren()[0] == null;
    }

    @Override
    protected void setState(int n) {
        if (this.isEmptySlot()) {
            n = 1;
        }
        this.logChannel.log(1078071040, "[%1('%2')#setState] state='%3'", (Object)this.getType(), (Object)this, (long)n);
        this.state = n;
    }

    @Override
    public boolean isRegistrable() {
        return false;
    }

    protected boolean releaseMenuEntry() {
        if (!this.isEmptySlot()) {
            IncludeMenuEntry includeMenuEntry = (IncludeMenuEntry)this.getChildren()[0];
            includeMenuEntry.setParent(null);
            super.setChildren(null);
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1078071040, "[%1('%2')#releaseMenuEntry] link between virtual menu entries was cut: released %3='%4'", (Object)this.getType(), (Object)this, (Object)includeMenuEntry.getType(), (Object)includeMenuEntry);
            }
            return true;
        }
        return false;
    }

    @Override
    public MenuEntryType getType() {
        return MenuEntryType.SLOT_MENU_ENTRY;
    }
}

