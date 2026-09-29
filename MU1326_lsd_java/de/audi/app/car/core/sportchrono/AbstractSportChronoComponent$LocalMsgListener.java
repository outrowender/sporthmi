/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.sportchrono;

import de.audi.app.car.core.sportchrono.AbstractSportChronoComponent;
import de.audi.app.car.core.sportchrono.AbstractSportChronoComponent$1;
import de.audi.app.car.core.sportchrono.AbstractSportChronoComponent$JokerKeyButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;

class AbstractSportChronoComponent$LocalMsgListener
implements MsgListener {
    private final /* synthetic */ AbstractSportChronoComponent this$0;

    private AbstractSportChronoComponent$LocalMsgListener(AbstractSportChronoComponent abstractSportChronoComponent) {
        this.this$0 = abstractSportChronoComponent;
    }

    @Override
    public void processMsg(int n) {
        if (79 == n) {
            ButtonModelApp buttonModelApp;
            int n2 = AbstractSportChronoComponent.access$500(this.this$0, 395).getValue();
            if (70 == n2 && null != (buttonModelApp = AbstractSportChronoComponent.access$600(this.this$0, -1859450624))) {
                buttonModelApp.setButtonListener(new AbstractSportChronoComponent$JokerKeyButtonListener(this.this$0, null));
            }
            if (71 == n2 && null != (buttonModelApp = AbstractSportChronoComponent.access$800(this.this$0, -1859450624))) {
                buttonModelApp.setButtonListener(new AbstractSportChronoComponent$JokerKeyButtonListener(this.this$0, null));
            }
        }
    }

    /* synthetic */ AbstractSportChronoComponent$LocalMsgListener(AbstractSportChronoComponent abstractSportChronoComponent, AbstractSportChronoComponent$1 abstractSportChronoComponent$1) {
        this(abstractSportChronoComponent);
    }
}

