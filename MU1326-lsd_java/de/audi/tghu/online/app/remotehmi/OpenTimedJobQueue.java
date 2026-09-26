/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.esolutions.fw.util.commons.job.TimedJobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.util.List;

public class OpenTimedJobQueue
extends TimedJobQueue {
    public OpenTimedJobQueue(ITimeSource iTimeSource) {
        super(iTimeSource);
    }

    @Override
    public List getJobs() {
        return super.getJobs();
    }
}

