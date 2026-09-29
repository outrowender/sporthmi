/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaComponent;
import de.audi.app.car.core.charisma.AbstractCharismaComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractCharismaComponent$JokerKeyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractCharismaComponent this$0;

    private AbstractCharismaComponent$JokerKeyButtonListener(AbstractCharismaComponent abstractCharismaComponent) {
        this.this$0 = abstractCharismaComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 600977: {
                AbstractCharismaComponent.access$000(this.this$0, "keyPressed", n, n2, true);
                break;
            }
            default: {
                AbstractCharismaComponent.access$100(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (-1859450624 == n) {
            int n4 = AbstractCharismaComponent.access$200(this.this$0, 395).getValue();
            switch (n4) {
                case 81: {
                    this.this$0.toggleESound();
                    break;
                }
                default: {
                    AbstractCharismaComponent.access$300(this.this$0, "keyReleased", n, n2, false);
                    break;
                }
            }
        } else {
            AbstractCharismaComponent.access$400(this.this$0, "keyReleased", n, n2, false);
        }
    }

    /* synthetic */ AbstractCharismaComponent$JokerKeyButtonListener(AbstractCharismaComponent abstractCharismaComponent, AbstractCharismaComponent$1 abstractCharismaComponent$1) {
        this(abstractCharismaComponent);
    }
}

