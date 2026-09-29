/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager;
import de.audi.atip.error.ErrorManager$1;
import de.audi.atip.error.Incident;

final class ErrorManager$WatchDogAlarm
implements Runnable {
    private Runnable payload = null;
    private Incident incident = null;
    private final /* synthetic */ ErrorManager this$0;

    private ErrorManager$WatchDogAlarm(ErrorManager errorManager, Runnable runnable, Incident incident) {
        this.this$0 = errorManager;
        this.payload = runnable;
        this.incident = incident;
    }

    @Override
    public void run() {
        if (this.payload != null) {
            this.payload.run();
        }
        if (this.incident != null) {
            ErrorManager.access$1200(this.this$0, this.incident);
        }
    }

    /* synthetic */ ErrorManager$WatchDogAlarm(ErrorManager errorManager, Runnable runnable, Incident incident, ErrorManager$1 errorManager$1) {
        this(errorManager, runnable, incident);
    }
}

