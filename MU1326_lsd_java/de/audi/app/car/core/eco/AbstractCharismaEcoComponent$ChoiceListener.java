/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.core.eco.AbstractCharismaEcoComponent;
import de.audi.app.car.core.eco.AbstractCharismaEcoComponent$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

final class AbstractCharismaEcoComponent$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AbstractCharismaEcoComponent this$0;

    private AbstractCharismaEcoComponent$ChoiceListener(AbstractCharismaEcoComponent abstractCharismaEcoComponent) {
        this.this$0 = abstractCharismaEcoComponent;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractCharismaEcoComponent#itemSelected] %1, %2", (long)n, (long)n2);
        boolean bl = 1 == n2;
        switch (n) {
            case 601716: {
                this.this$0.dsiSetStartStop(this.this$0.invertHMIStartStop ? !bl : bl);
                break;
            }
            case 601707: {
                this.this$0.dsiSetFreeRolling(bl);
                break;
            }
        }
    }

    /* synthetic */ AbstractCharismaEcoComponent$ChoiceListener(AbstractCharismaEcoComponent abstractCharismaEcoComponent, AbstractCharismaEcoComponent$1 abstractCharismaEcoComponent$1) {
        this(abstractCharismaEcoComponent);
    }
}

