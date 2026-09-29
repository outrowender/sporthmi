/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.app.navi.evo.search.ActiveDestinationsManager$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class ActiveDestinationsManager$ActiveDestinationsListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ ActiveDestinationsManager this$0;

    private ActiveDestinationsManager$ActiveDestinationsListListener(ActiveDestinationsManager activeDestinationsManager) {
        this.this$0 = activeDestinationsManager;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        ActiveDestinationsManager.access$300(this.this$0).log(-2137614336, "%1#itemSelected row = %2, index = %3", (Object)"ActiveDestinationsManager", (Object)evoListRow, (long)n2);
        if (ActiveDestinationsManager.access$400(this.this$0).getLength() == 1) {
            ActiveDestinationsManager.access$500(this.this$0).stopRouteGuidance();
            ActiveDestinationsManager.access$600(this.this$0);
            ActiveDestinationsManager.access$702(this.this$0, null);
            ActiveDestinationsManager.access$800(this.this$0).setValue(0);
        } else if (ActiveDestinationsManager.access$400(this.this$0).getLength() == 2 && n2 == 1) {
            ActiveDestinationsManager.access$902(this.this$0, true);
            ActiveDestinationsManager.access$500(this.this$0).startRouteGuidanceToSingleDestination(ActiveDestinationsManager.access$700(this.this$0));
            ActiveDestinationsManager.access$400(this.this$0).remove(evoListRow.getUniqueID());
            ActiveDestinationsManager.access$1002(this.this$0, null);
            ActiveDestinationsManager.access$800(this.this$0).setValue(1);
        } else {
            ActiveDestinationsManager.access$800(this.this$0).setValue(2);
        }
        ActiveDestinationsManager.access$400(this.this$0).fireEvent(n4);
    }

    /* synthetic */ ActiveDestinationsManager$ActiveDestinationsListListener(ActiveDestinationsManager activeDestinationsManager, ActiveDestinationsManager$1 activeDestinationsManager$1) {
        this(activeDestinationsManager);
    }
}

