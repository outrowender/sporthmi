/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.settings.TVNormList;
import de.audi.tv.app.settings.TVNormList$1;
import de.audi.tv.app.settings.TVNormList$TVNormRow;

class TVNormList$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ TVNormList this$0;

    private TVNormList$ListListener(TVNormList tVNormList) {
        this.this$0 = tVNormList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        TVNormList.access$200((TVNormList)this.this$0).lcHMI.log(1078071040, "[TVNormList.ListListener.listItemSelected] item:%1", evoListRow.getUniqueID());
        TVNormList.access$300(this.this$0, ((TVNormList$TVNormRow)evoListRow).id);
        TVNormList.access$200(this.this$0).getBaseListModel(1454122752).fireEvent(n4);
    }

    /* synthetic */ TVNormList$ListListener(TVNormList tVNormList, TVNormList$1 tVNormList$1) {
        this(tVNormList);
    }
}

