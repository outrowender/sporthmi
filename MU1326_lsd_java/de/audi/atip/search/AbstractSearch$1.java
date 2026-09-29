/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search;

import de.audi.atip.search.AbstractSearch;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearch;

class AbstractSearch$1
implements IDSIClient {
    private final /* synthetic */ AbstractSearch this$0;

    AbstractSearch$1(AbstractSearch abstractSearch) {
        this.this$0 = abstractSearch;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        AbstractSearch.access$000(this.this$0, (DSISearch)dSIBase);
        if (AbstractSearch.access$100(this.this$0) != null) {
            this.this$0.setLanguage(AbstractSearch.access$100(this.this$0));
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return null;
    }
}

