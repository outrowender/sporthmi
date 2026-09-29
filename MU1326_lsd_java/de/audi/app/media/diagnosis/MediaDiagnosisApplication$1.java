/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;

class MediaDiagnosisApplication$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaTerminal val$terminal;
    private final /* synthetic */ MediaDiagnosisApplication this$0;

    MediaDiagnosisApplication$1(MediaDiagnosisApplication mediaDiagnosisApplication, String string, IMediaTerminal iMediaTerminal) {
        this.this$0 = mediaDiagnosisApplication;
        this.val$terminal = iMediaTerminal;
        super(string);
    }

    @Override
    public void run() {
        ISource iSource = this.val$terminal.getSourceController().getSource(2);
        if (iSource == null) {
            iSource = this.val$terminal.getSourceController().getSource(0);
        }
        if (iSource == null) {
            MediaDiagnosisApplication.access$000(this.this$0).main().log(-1601830656, "[%1.switchToInternalDrive] No internal drive found. ", (Object)"MediaDiagnosisApplication");
            return;
        }
        this.val$terminal.getSourceController().activateSource(new ActivationContext(iSource.getSlot(0)));
    }
}

