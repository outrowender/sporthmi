/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager;
import de.audi.atip.error.Incident;
import java.util.List;

class ErrorManager$2
implements Runnable {
    private final /* synthetic */ Incident val$error;
    private final /* synthetic */ List val$sync;
    private final /* synthetic */ ErrorManager this$0;

    ErrorManager$2(ErrorManager errorManager, Incident incident, List list) {
        this.this$0 = errorManager;
        this.val$error = incident;
        this.val$sync = list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        ErrorManager.access$1000(this.this$0, this.val$error);
        this.val$sync.add(new Object());
        List list = this.val$sync;
        synchronized (list) {
            super.notifyAll();
        }
    }
}

