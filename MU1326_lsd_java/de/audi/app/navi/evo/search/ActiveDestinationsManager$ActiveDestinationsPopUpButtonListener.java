/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.app.navi.evo.search.ActiveDestinationsManager$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class ActiveDestinationsManager$ActiveDestinationsPopUpButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ ActiveDestinationsManager this$0;

    private ActiveDestinationsManager$ActiveDestinationsPopUpButtonListener(ActiveDestinationsManager activeDestinationsManager) {
        this.this$0 = activeDestinationsManager;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        ActiveDestinationsManager.access$300(this.this$0).log(-2137614336, "%1#keyPressed modelID = %2", (Object)"ActiveDestinationsManager", (long)n);
        switch (n) {
            case 401248: {
                ActiveDestinationsManager.access$902(this.this$0, true);
                ActiveDestinationsManager.access$500(this.this$0).startRouteGuidanceToSingleDestination(ActiveDestinationsManager.access$1000(this.this$0));
                ActiveDestinationsManager.access$400(this.this$0).remove(ActiveDestinationsManager.access$400(this.this$0).getRow(0).getUniqueID());
                ActiveDestinationsManager.access$702(this.this$0, ActiveDestinationsManager.access$1000(this.this$0));
                ActiveDestinationsManager.access$1002(this.this$0, null);
                ActiveDestinationsManager.access$800(this.this$0).setValue(1);
                ActiveDestinationsManager.access$1100(this.this$0).fireEvent(n3);
                break;
            }
            case 401247: {
                ActiveDestinationsManager.access$500(this.this$0).stopRouteGuidance();
                ActiveDestinationsManager.access$600(this.this$0);
                ActiveDestinationsManager.access$702(this.this$0, null);
                ActiveDestinationsManager.access$1002(this.this$0, null);
                ActiveDestinationsManager.access$800(this.this$0).setValue(0);
                ActiveDestinationsManager.access$1200(this.this$0).fireEvent(n3);
                break;
            }
        }
    }

    /* synthetic */ ActiveDestinationsManager$ActiveDestinationsPopUpButtonListener(ActiveDestinationsManager activeDestinationsManager, ActiveDestinationsManager$1 activeDestinationsManager$1) {
        this(activeDestinationsManager);
    }
}

