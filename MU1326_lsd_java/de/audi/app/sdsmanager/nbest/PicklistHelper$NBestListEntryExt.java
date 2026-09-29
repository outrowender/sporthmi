/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.nbest;

import de.audi.app.sdsmanager.nbest.PicklistHelper;
import de.audi.app.sdsmanager.nbest.PicklistHelper$1;
import org.dsi.ifc.speechrec.NBestListEntry;

class PicklistHelper$NBestListEntryExt
extends NBestListEntry {
    private boolean used = false;
    private int ggSize = 0;
    private final /* synthetic */ PicklistHelper this$0;

    private PicklistHelper$NBestListEntryExt(PicklistHelper picklistHelper) {
        this.this$0 = picklistHelper;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void setUsed(boolean bl) {
        this.used = bl;
    }

    public int getGGSize() {
        return this.ggSize;
    }

    public void setGGSize(int n) {
        this.ggSize = n;
    }

    /* synthetic */ PicklistHelper$NBestListEntryExt(PicklistHelper picklistHelper, PicklistHelper$1 picklistHelper$1) {
        this(picklistHelper);
    }
}

