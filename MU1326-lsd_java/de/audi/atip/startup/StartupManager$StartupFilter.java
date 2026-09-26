/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.hmi.event.EALMergeEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.MMICombiSyncEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.RegisterPartialPopupsEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.view.IShowPopupRunnable;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$1;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;

class StartupManager$StartupFilter
extends BaseJobFilter
implements IJobFilter {
    private final /* synthetic */ StartupManager this$0;

    private StartupManager$StartupFilter(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    private void processNonStartupAffecting(Job job, int n) {
        Object object = job.getPayload();
        if (StartupManager.access$1800(this.this$0)) {
            super.enqueue(job, n);
        } else if (object instanceof KeyEvent && ((KeyEvent)object).getKeyCode() == 16) {
            super.enqueue(job, n);
        } else if (object instanceof RunnableEvent) {
            RunnableEvent runnableEvent = (RunnableEvent)object;
            if (runnableEvent.getRunnable() instanceof IShowPopupRunnable) {
                StartupManager.access$1902(this.this$0, true);
                super.enqueue(job, n);
            } else if (runnableEvent.isProcessBeforeFirstScreen()) {
                super.enqueue(job, n);
            } else {
                StartupManager.access$1700(this.this$0).log(-2137614336, "StartupManager: discard %1", (Object)job);
            }
        } else if (object instanceof RegisterPartialPopupsEvent) {
            super.enqueue(job, n);
        } else if (object instanceof MMICombiSyncEvent) {
            super.enqueue(job, n);
        } else if (object instanceof ModelUpdateEvent && ((ModelUpdateEvent)object).isForceUpdateActivated()) {
            super.enqueue(job, n);
        } else if (object instanceof EALMergeEvent) {
            if (StartupManager.access$1700(this.this$0).isDebug()) {
                StartupManager.access$1700(this.this$0).log(-2137614336, "StartupManager: enqueue EALMergeEvent for Node: %1", (Object)((EALMergeEvent)object).getNodeName());
            }
            super.enqueue(job, n);
        } else {
            StartupManager.access$1700(this.this$0).log(-2137614336, "StartupManager: discard %1", (Object)job);
        }
    }

    @Override
    public void enqueue(Job job, int n) {
        StartupManager.access$1700(this.this$0).log(-2137614336, "StartupManager: handle event %1", (Object)job);
        Object object = job.getPayload();
        if (StartupManager.access$2000(this.this$0) && !this.this$0.isStartupCompleted() && object instanceof KeyEvent && StartupManager.access$800(this.this$0).isValidLastmode((KeyEvent)object)) {
            StartupManager.access$1700(this.this$0).log(-2137614336, "StartupManager#postEvent: KeyEvent is valid lastmode");
            KeyEvent keyEvent = (KeyEvent)object;
            StartupManager.access$1700(this.this$0).log(1078071040, "StartupManager: intercept %1", (Object)keyEvent);
            if (keyEvent.getID() == 10402) {
                if (StartupManager.access$800(this.this$0).checkLastmodeChange(keyEvent)) {
                    if (StartupManager.access$1600(this.this$0) == null) {
                        StartupManager.access$1602(this.this$0, new KeyEvent(keyEvent.getReceiver(), 10401, keyEvent.getKeyCode(), keyEvent.getTerminalID()));
                    }
                    super.enqueue(new Job(StartupManager.access$1600(this.this$0)), n);
                    super.enqueue(new Job(keyEvent), n);
                }
                StartupManager.access$1602(this.this$0, null);
            } else {
                StartupManager.access$1602(this.this$0, keyEvent);
            }
        } else {
            this.processNonStartupAffecting(job, n);
        }
    }

    /* synthetic */ StartupManager$StartupFilter(StartupManager startupManager, StartupManager$1 startupManager$1) {
        this(startupManager);
    }
}

