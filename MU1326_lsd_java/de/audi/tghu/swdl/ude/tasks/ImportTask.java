/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.IEClient;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.util.ListIterator;

public final class ImportTask
extends AbstractIETask {
    public ImportTask(IEApp iEApp, ListIterator listIterator) {
        super(iEApp, listIterator, "ImportTask");
    }

    void startNexTask() {
        IEClient iEClient = this.getNextIEClient();
        iEClient.startImport(this);
    }

    void finished(boolean bl) {
        this.ieApp.importFinished(bl);
    }
}

