/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.core.eco.AbstractCharismaEcoComponent;
import de.audi.app.car.core.eco.AbstractCharismaEcoComponent$1;
import de.audi.app.car.core.eco.AbstractCharismaEcoComponent$JokerKeyButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;

class AbstractCharismaEcoComponent$LocalMsgListener
implements MsgListener {
    private final /* synthetic */ AbstractCharismaEcoComponent this$0;

    private AbstractCharismaEcoComponent$LocalMsgListener(AbstractCharismaEcoComponent abstractCharismaEcoComponent) {
        this.this$0 = abstractCharismaEcoComponent;
    }

    @Override
    public void processMsg(int n) {
        ButtonModelApp buttonModelApp;
        if (79 == n && 82 == AbstractCharismaEcoComponent.access$600(this.this$0, 395).getValue() && null != (buttonModelApp = AbstractCharismaEcoComponent.access$700(this.this$0, -1859450624))) {
            buttonModelApp.setButtonListener(new AbstractCharismaEcoComponent$JokerKeyButtonListener(this.this$0, null));
        }
    }

    /* synthetic */ AbstractCharismaEcoComponent$LocalMsgListener(AbstractCharismaEcoComponent abstractCharismaEcoComponent, AbstractCharismaEcoComponent$1 abstractCharismaEcoComponent$1) {
        this(abstractCharismaEcoComponent);
    }
}

