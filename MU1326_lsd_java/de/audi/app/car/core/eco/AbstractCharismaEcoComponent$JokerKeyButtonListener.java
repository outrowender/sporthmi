/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.core.eco.AbstractCharismaEcoComponent;
import de.audi.app.car.core.eco.AbstractCharismaEcoComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractCharismaEcoComponent$JokerKeyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractCharismaEcoComponent this$0;

    private AbstractCharismaEcoComponent$JokerKeyButtonListener(AbstractCharismaEcoComponent abstractCharismaEcoComponent) {
        this.this$0 = abstractCharismaEcoComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 600977: {
                AbstractCharismaEcoComponent.access$000(this.this$0, "keyPressed", n, n2, true);
                break;
            }
            default: {
                AbstractCharismaEcoComponent.access$100(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (-1859450624 == n) {
            int n4 = AbstractCharismaEcoComponent.access$200(this.this$0, 395).getValue();
            switch (n4) {
                case 82: {
                    int n5 = AbstractCharismaEcoComponent.access$300(this.this$0, 1949174016).getValue();
                    this.this$0.dsiSetStartStop(0 == n5);
                    break;
                }
                default: {
                    AbstractCharismaEcoComponent.access$400(this.this$0, "keyReleased", n, n2, false);
                    break;
                }
            }
        } else {
            AbstractCharismaEcoComponent.access$500(this.this$0, "keyReleased", n, n2, false);
        }
    }

    /* synthetic */ AbstractCharismaEcoComponent$JokerKeyButtonListener(AbstractCharismaEcoComponent abstractCharismaEcoComponent, AbstractCharismaEcoComponent$1 abstractCharismaEcoComponent$1) {
        this(abstractCharismaEcoComponent);
    }
}

