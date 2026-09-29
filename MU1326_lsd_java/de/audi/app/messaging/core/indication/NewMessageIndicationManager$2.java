/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.indication;

import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.util.Logs;

class NewMessageIndicationManager$2
implements Runnable {
    private final /* synthetic */ int val$stateAspect;
    private final /* synthetic */ NewMessageIndicationManager this$0;

    NewMessageIndicationManager$2(NewMessageIndicationManager newMessageIndicationManager, int n) {
        this.this$0 = newMessageIndicationManager;
        this.val$stateAspect = n;
    }

    @Override
    public void run() {
        NewMessageIndicationManager.access$200(this.this$0).log(-2137614336, "[NewMessageIndicationManager#notifyObservers] stateAspect = %1", (long)this.val$stateAspect);
        INewMessageIndicationManagerObserver[] iNewMessageIndicationManagerObserverArray = NewMessageIndicationManager.access$300(this.this$0);
        for (int i2 = 0; i2 < iNewMessageIndicationManagerObserverArray.length; ++i2) {
            try {
                iNewMessageIndicationManagerObserverArray[i2].indicateIndicationStateChanged(this.val$stateAspect);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(NewMessageIndicationManager.access$400(this.this$0), exception, "[NewMessageIndicationManager#notifyObservers]");
            }
        }
    }
}

