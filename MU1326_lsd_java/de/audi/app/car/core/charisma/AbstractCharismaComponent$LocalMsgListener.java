/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaComponent;
import de.audi.app.car.core.charisma.AbstractCharismaComponent$1;
import de.audi.app.car.core.charisma.AbstractCharismaComponent$JokerKeyButtonListener;
import de.audi.atip.msg.MsgListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;

class AbstractCharismaComponent$LocalMsgListener
implements MsgListener {
    private final /* synthetic */ AbstractCharismaComponent this$0;

    private AbstractCharismaComponent$LocalMsgListener(AbstractCharismaComponent abstractCharismaComponent) {
        this.this$0 = abstractCharismaComponent;
    }

    @Override
    public void processMsg(int n) {
        if (79 == n) {
            Object object;
            boolean bl;
            int n2 = AbstractCharismaComponent.access$500(this.this$0, 395).getValue();
            boolean bl2 = bl = 2 == n2;
            if (AbstractCharismaComponent.access$600(this.this$0) != null && AbstractCharismaComponent.access$600(this.this$0).isButton1() != bl && this.isRelevantJokerKeyMeaningChange(n2)) {
                object = new CharismaProgButton(bl, false, false, false, false);
                if (this.this$0.getLogChannel().isDebug()) {
                    this.this$0.getLogChannel().log(-2137614336, "processMsg: dsi.setCharismaProgButton( %1 )", object);
                }
                this.this$0.getDSI().setCharismaProgButton((CharismaProgButton)object);
            }
            if (81 == n2 && null != (object = AbstractCharismaComponent.access$700(this.this$0, -1859450624))) {
                object.setButtonListener(new AbstractCharismaComponent$JokerKeyButtonListener(this.this$0, null));
            }
            AbstractCharismaComponent.access$902(this.this$0, n2);
        }
    }

    private boolean isRelevantJokerKeyMeaningChange(int n) {
        return AbstractCharismaComponent.access$900(this.this$0) == 2 && n != 2 || AbstractCharismaComponent.access$900(this.this$0) != 2 && n == 2;
    }

    /* synthetic */ AbstractCharismaComponent$LocalMsgListener(AbstractCharismaComponent abstractCharismaComponent, AbstractCharismaComponent$1 abstractCharismaComponent$1) {
        this(abstractCharismaComponent);
    }
}

