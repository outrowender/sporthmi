/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.WidgetKeyHandlerFactory;

public class VirtualButtonEvo
extends VirtualButton {
    private IWidgetKeyHandler keyHandler;

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        boolean bl = this.hasState(36);
        logChannelEvent.log(-2137614336, "VirtualButtonEvo#keyPressed active = %1, keyHandler = %2", bl, (Object)this.keyHandler);
        if (bl && this.keyHandler != null) {
            this.keyHandler.keyPressed(this, keyEvent);
            return;
        }
    }

    public void setKeyHandler(int n) {
        this.keyHandler = WidgetKeyHandlerFactory.createKeyHandler(n);
    }
}

