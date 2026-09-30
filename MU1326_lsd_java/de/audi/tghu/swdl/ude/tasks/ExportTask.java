/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.util.ListIterator;

public final class ExportTask
extends AbstractIETask {
    public ExportTask(IEApp iEApp, ListIterator listIterator) {
        super(iEApp, listIterator, "ExportTask");
    }

    void startNexTask() {
        this.getNextIEClient().startExport(this);
    }

    void finished(boolean bl) {
        this.ieApp.exportFinished(bl);
    }
}

