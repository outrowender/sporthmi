/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent;
import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractCharismaDirectCtrlComponent$JokerKeyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractCharismaDirectCtrlComponent this$0;

    private AbstractCharismaDirectCtrlComponent$JokerKeyButtonListener(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent) {
        this.this$0 = abstractCharismaDirectCtrlComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 600977: {
                AbstractCharismaDirectCtrlComponent.access$100(this.this$0, "keyPressed", n, n2, true);
                break;
            }
            default: {
                AbstractCharismaDirectCtrlComponent.access$200(this.this$0, "keyPressed", n, n2, false);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (-1859450624 == n) {
            int n4 = AbstractCharismaDirectCtrlComponent.access$300(this.this$0, 395).getValue();
            switch (n4) {
                case 80: {
                    int n5 = AbstractCharismaDirectCtrlComponent.access$400(this.this$0, 724633856).getValue();
                    AbstractCharismaDirectCtrlComponent.access$000(this.this$0, 0 == n5);
                    break;
                }
                default: {
                    AbstractCharismaDirectCtrlComponent.access$500(this.this$0, "keyReleased", n, n2, false);
                    break;
                }
            }
        } else {
            AbstractCharismaDirectCtrlComponent.access$600(this.this$0, "keyReleased", n, n2, false);
        }
    }

    /* synthetic */ AbstractCharismaDirectCtrlComponent$JokerKeyButtonListener(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, AbstractCharismaDirectCtrlComponent$1 abstractCharismaDirectCtrlComponent$1) {
        this(abstractCharismaDirectCtrlComponent);
    }
}

