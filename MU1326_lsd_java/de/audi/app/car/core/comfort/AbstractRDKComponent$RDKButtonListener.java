/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.AbstractRDKComponent;
import de.audi.app.car.core.comfort.AbstractRDKComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class AbstractRDKComponent$RDKButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractRDKComponent this$0;

    private AbstractRDKComponent$RDKButtonListener(AbstractRDKComponent abstractRDKComponent) {
        this.this$0 = abstractRDKComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractRDKComponent#keyPressed] modelID='%1', keyID='%2'", (long)n, (long)n2);
        switch (n) {
            case 600358: {
                AbstractRDKComponent.access$300(this.this$0, n3);
                break;
            }
            case 600362: {
                AbstractRDKComponent.access$400(this.this$0, n3);
                break;
            }
        }
    }

    /* synthetic */ AbstractRDKComponent$RDKButtonListener(AbstractRDKComponent abstractRDKComponent, AbstractRDKComponent$1 abstractRDKComponent$1) {
        this(abstractRDKComponent);
    }
}

