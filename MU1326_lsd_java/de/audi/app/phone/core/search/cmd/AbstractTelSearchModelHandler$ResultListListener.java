/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultBaseListListener;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;

class AbstractTelSearchModelHandler$ResultListListener
extends TelDefaultBaseListListener {
    private final /* synthetic */ AbstractTelSearchModelHandler this$0;

    public AbstractTelSearchModelHandler$ResultListListener(AbstractTelSearchModelHandler abstractTelSearchModelHandler, ITelApplication iTelApplication) {
        this.this$0 = abstractTelSearchModelHandler;
        super(iTelApplication, "App.Phone.Search", abstractTelSearchModelHandler.getSearchResultListModel().getID());
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getNodeType() == 1) {
            this.this$0.parentNodeSelected((SearchResultListRow)evoListRow, n, n4);
        } else if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getNodeType() == 0) {
            this.this$0.searchResultSelected((SearchResultListRow)evoListRow, n4, n);
        } else {
            this.this$0.childNodeSelected(evoListRow, n4, n);
        }
    }
}

