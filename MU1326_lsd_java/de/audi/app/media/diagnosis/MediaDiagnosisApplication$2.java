/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;

class MediaDiagnosisApplication$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ISource val$source;
    private final /* synthetic */ int val$pSlotIdx;
    private final /* synthetic */ IMediaTerminal val$terminal;
    private final /* synthetic */ MediaDiagnosisApplication this$0;

    MediaDiagnosisApplication$2(MediaDiagnosisApplication mediaDiagnosisApplication, String string, ISource iSource, int n, IMediaTerminal iMediaTerminal) {
        this.this$0 = mediaDiagnosisApplication;
        this.val$source = iSource;
        this.val$pSlotIdx = n;
        this.val$terminal = iMediaTerminal;
        super(string);
    }

    @Override
    public void run() {
        ISourceSlot iSourceSlot = this.val$source.getSlot(this.val$pSlotIdx);
        this.val$terminal.getSourceController().activateSource(new ActivationContext(iSourceSlot));
    }
}

