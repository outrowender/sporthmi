/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.IActionProxyListener;
import java.util.Map;

public abstract class AbstractTelActionProxyListener
extends AbstractPhoneComponent
implements IActionProxyListener {
    private final int methodID;

    public AbstractTelActionProxyListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string);
        this.methodID = n;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(this.methodID, this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(this.methodID, this);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        if (n == this.methodID) {
            this.actionProxyCalled(map);
        } else {
            this.log.log(-1601830656, "[AbstractTelActionProxyListener#actionProxyCallPerformed] unhandled method ID %1", (long)n);
        }
    }

    protected abstract void actionProxyCalled(Map map) {
    }
}

