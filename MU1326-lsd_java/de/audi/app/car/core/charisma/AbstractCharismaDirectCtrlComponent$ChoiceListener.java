/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent;
import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class AbstractCharismaDirectCtrlComponent$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractCharismaDirectCtrlComponent this$0;

    private AbstractCharismaDirectCtrlComponent$ChoiceListener(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent) {
        this.this$0 = abstractCharismaDirectCtrlComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractCharismaDirectCtrlComponent#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
        switch (n) {
            case 602411: {
                AbstractCharismaDirectCtrlComponent.access$000(this.this$0, 1 == n2);
                break;
            }
            default: {
                return;
            }
        }
    }

    /* synthetic */ AbstractCharismaDirectCtrlComponent$ChoiceListener(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, AbstractCharismaDirectCtrlComponent$1 abstractCharismaDirectCtrlComponent$1) {
        this(abstractCharismaDirectCtrlComponent);
    }
}

