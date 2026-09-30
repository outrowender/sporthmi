/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.evo;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.IContextStateListener;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.ap.IActionProxyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvoAppContextListenersDistributor
extends AbstractEcallComponent
implements IActionProxyListener {
    private final int IN_CONTEXT_ENTERED_ACTION_PROXY;
    private final int CONTEXT_LEFT_ACTION_PROXY;
    private final List contextStateListeners = new ArrayList();
    static /* synthetic */ Class class$de$audi$app$ecall$proxy$IEcallEvoActionProxyIDs;

    public EvoAppContextListenersDistributor(IEcallApplication iEcallApplication, int n, int n2) {
        super(iEcallApplication, "App.Ecall.Main");
        this.IN_CONTEXT_ENTERED_ACTION_PROXY = n;
        this.CONTEXT_LEFT_ACTION_PROXY = n2;
    }

    public void init() {
        super.init();
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(this.IN_CONTEXT_ENTERED_ACTION_PROXY, this);
        this.getApplication().getActionProxyDispatcher().addActionProxyListener(this.CONTEXT_LEFT_ACTION_PROXY, this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(this.IN_CONTEXT_ENTERED_ACTION_PROXY, this);
        this.getApplication().getActionProxyDispatcher().removeActionProxyListener(this.CONTEXT_LEFT_ACTION_PROXY, this);
        this.contextStateListeners.clear();
    }

    void registerContextStateListener(IContextStateListener iContextStateListener) {
        this.contextStateListeners.add(iContextStateListener);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        this.log.log(10000000, "EvoEcallOpenClosePopupHandler#actionProxyCallPerformed(): methodId %1 ", (Object)String.valueOf(n));
        EcallUtil.logStructFieldForDbg(this.log, class$de$audi$app$ecall$proxy$IEcallEvoActionProxyIDs == null ? (class$de$audi$app$ecall$proxy$IEcallEvoActionProxyIDs = EvoAppContextListenersDistributor.class$("de.audi.app.ecall.proxy.IEcallEvoActionProxyIDs")) : class$de$audi$app$ecall$proxy$IEcallEvoActionProxyIDs, n);
        if (n == this.IN_CONTEXT_ENTERED_ACTION_PROXY) {
            this.log.log(10000000, "EvoOpenCloseEcallPopupHandler#actionProxyCallPerformed(): context entered");
            this.notifyOnContextEntered();
        } else if (n == this.CONTEXT_LEFT_ACTION_PROXY) {
            this.notifyOnContextLeft();
        } else {
            this.log.log(1000000, "EvoEcallOpenClosePopupHandler#actionProxyCallPerformed(): unhandled methodId=%1", (long)n);
        }
    }

    private void notifyOnContextEntered() {
        Iterator iterator = this.contextStateListeners.iterator();
        while (iterator.hasNext()) {
            ((IContextStateListener)iterator.next()).onContextEntered();
        }
    }

    private void notifyOnContextLeft() {
        Iterator iterator = this.contextStateListeners.iterator();
        while (iterator.hasNext()) {
            ((IContextStateListener)iterator.next()).onContextLeft();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

