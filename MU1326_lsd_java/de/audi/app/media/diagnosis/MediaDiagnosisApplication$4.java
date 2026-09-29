/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.diagnosis.MediaDiagnosisApplication;
import de.audi.app.media.source.ActivationContext;

class MediaDiagnosisApplication$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaTerminal val$terminal;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ MediaDiagnosisApplication this$0;

    MediaDiagnosisApplication$4(MediaDiagnosisApplication mediaDiagnosisApplication, String string, IMediaTerminal iMediaTerminal, int n) {
        this.this$0 = mediaDiagnosisApplication;
        this.val$terminal = iMediaTerminal;
        this.val$terminalID = n;
        super(string);
    }

    @Override
    public void run() {
        this.val$terminal.getSourceController().activateSource(new ActivationContext(MediaDiagnosisApplication.access$100(this.this$0)[this.val$terminalID]));
    }
}

