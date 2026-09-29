/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.DataBrowserCategoryList;
import de.audi.app.media.evo.content.data.DataBrowserCategoryListRow;
import de.audi.atip.hmi.model.list.EvoListRow;

class DataBrowserCategoryList$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ EvoListRow val$row;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ DataBrowserCategoryList this$0;

    DataBrowserCategoryList$2(DataBrowserCategoryList dataBrowserCategoryList, String string, EvoListRow evoListRow, int n) {
        this.this$0 = dataBrowserCategoryList;
        this.val$row = evoListRow;
        this.val$terminal = n;
        super(string);
    }

    @Override
    public void run() {
        DataBrowserCategoryList.access$400(this.this$0).hmi().log(1078071040, "[%1.itemSelected] '%2'", (Object)"DataBrowserCategoryList", (Object)this.val$row);
        DataBrowserCategoryList.access$500(this.this$0, ((DataBrowserCategoryListRow)this.val$row).getCategoryID());
        DataBrowserCategoryList.access$600(this.this$0).fireEvent(this.val$terminal);
    }
}

