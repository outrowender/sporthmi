/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver$EmptyImplementation;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$1;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$EntryListObserver$1;

final class MultipleMessageReadoutService$EntryListObserver
extends IEntryListObserver$EmptyImplementation {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    private MultipleMessageReadoutService$EntryListObserver(MultipleMessageReadoutService multipleMessageReadoutService) {
        this.this$0 = multipleMessageReadoutService;
    }

    @Override
    public void indicateListDataResponseOnFolderChange() {
        MultipleMessageReadoutService.access$4400(this.this$0).getExecutorManager().getInternalTaskDispatcher().execute(new MultipleMessageReadoutService$EntryListObserver$1(this));
    }

    /* synthetic */ MultipleMessageReadoutService$EntryListObserver(MultipleMessageReadoutService multipleMessageReadoutService, MultipleMessageReadoutService$1 multipleMessageReadoutService$1) {
        this(multipleMessageReadoutService);
    }

    static /* synthetic */ MultipleMessageReadoutService access$3600(MultipleMessageReadoutService$EntryListObserver multipleMessageReadoutService$EntryListObserver) {
        return multipleMessageReadoutService$EntryListObserver.this$0;
    }
}

