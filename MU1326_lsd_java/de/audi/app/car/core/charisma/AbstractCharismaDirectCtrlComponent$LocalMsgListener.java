/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent;
import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent$1;
import de.audi.app.car.core.charisma.AbstractCharismaDirectCtrlComponent$JokerKeyButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.msg.MsgListener;

class AbstractCharismaDirectCtrlComponent$LocalMsgListener
implements MsgListener {
    private final /* synthetic */ AbstractCharismaDirectCtrlComponent this$0;

    private AbstractCharismaDirectCtrlComponent$LocalMsgListener(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent) {
        this.this$0 = abstractCharismaDirectCtrlComponent;
    }

    @Override
    public void processMsg(int n) {
        ButtonModelApp buttonModelApp;
        if (79 == n && 80 == AbstractCharismaDirectCtrlComponent.access$700(this.this$0, 395).getValue() && null != (buttonModelApp = AbstractCharismaDirectCtrlComponent.access$800(this.this$0, -1859450624))) {
            buttonModelApp.setButtonListener(new AbstractCharismaDirectCtrlComponent$JokerKeyButtonListener(this.this$0, null));
        }
    }

    /* synthetic */ AbstractCharismaDirectCtrlComponent$LocalMsgListener(AbstractCharismaDirectCtrlComponent abstractCharismaDirectCtrlComponent, AbstractCharismaDirectCtrlComponent$1 abstractCharismaDirectCtrlComponent$1) {
        this(abstractCharismaDirectCtrlComponent);
    }
}

