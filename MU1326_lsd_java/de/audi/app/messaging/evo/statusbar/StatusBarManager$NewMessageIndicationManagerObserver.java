/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.statusbar;

import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.evo.statusbar.StatusBarManager;
import de.audi.app.messaging.evo.statusbar.StatusBarManager$1;

class StatusBarManager$NewMessageIndicationManagerObserver
implements INewMessageIndicationManagerObserver {
    private final /* synthetic */ StatusBarManager this$0;

    private StatusBarManager$NewMessageIndicationManagerObserver(StatusBarManager statusBarManager) {
        this.this$0 = statusBarManager;
    }

    @Override
    public void indicateIndicationStateChanged(int n) {
        StatusBarManager.access$100(this.this$0).log(-2137614336, "[StatusBarManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
        StatusBarManager.access$200(this.this$0);
    }

    /* synthetic */ StatusBarManager$NewMessageIndicationManagerObserver(StatusBarManager statusBarManager, StatusBarManager$1 statusBarManager$1) {
        this(statusBarManager);
    }
}

