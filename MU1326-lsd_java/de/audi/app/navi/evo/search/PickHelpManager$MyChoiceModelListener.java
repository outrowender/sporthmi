/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.PickHelpManager;
import de.audi.app.navi.evo.search.PickHelpManager$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class PickHelpManager$MyChoiceModelListener
extends DefaultChoiceListener {
    private final /* synthetic */ PickHelpManager this$0;

    private PickHelpManager$MyChoiceModelListener(PickHelpManager pickHelpManager) {
        this.this$0 = pickHelpManager;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        PickHelpManager.access$100(this.this$0).getLogChannel().log(1078071040, "%1#ChoiceModelListener.keyPressed model = %2 itemID = %3", (Object)"PickHelpManager", (long)n, (long)n2);
        switch (n) {
            case 401483: {
                this.this$0.setPickHelpState(0 == PickHelpManager.access$200(this.this$0).getValue() ? 1 : 0);
                PickHelpManager.access$100(this.this$0).fireModelEvent(n, n4);
                break;
            }
        }
    }

    /* synthetic */ PickHelpManager$MyChoiceModelListener(PickHelpManager pickHelpManager, PickHelpManager$1 pickHelpManager$1) {
        this(pickHelpManager);
    }
}

