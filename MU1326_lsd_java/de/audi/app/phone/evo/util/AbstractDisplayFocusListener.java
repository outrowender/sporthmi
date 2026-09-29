/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.util;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultChoiceListener;
import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;

public abstract class AbstractDisplayFocusListener
extends TelDefaultChoiceListener {
    public AbstractDisplayFocusListener(ITelApplication iTelApplication, int n) {
        super(iTelApplication, n);
    }

    public AbstractDisplayFocusListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string, n);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = bl = DrawerFocusUtil.isFocusLost(n2) && !DrawerFocusUtil.isReasonReInit(n2);
        if (bl) {
            this.log.log(1078071040, "[AbstractTelDefaultLeftDrawerOpenCloseChoiceListener#itemSelected] focus lost.");
            this.focusLost();
        } else {
            this.log.log(1078071040, "[AbstractTelDefaultLeftDrawerOpenCloseChoiceListener#itemSelected] focus obtained.");
            this.focusGained();
        }
    }

    protected abstract void focusLost() {
    }

    protected abstract void focusGained() {
    }
}

