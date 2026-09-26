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
import java.util.Iterator;

class MediaDiagnosisApplication$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ISource val$source;
    private final /* synthetic */ int val$deviceId;
    private final /* synthetic */ IMediaTerminal val$terminal;
    private final /* synthetic */ MediaDiagnosisApplication this$0;

    MediaDiagnosisApplication$3(MediaDiagnosisApplication mediaDiagnosisApplication, String string, ISource iSource, int n, IMediaTerminal iMediaTerminal) {
        this.this$0 = mediaDiagnosisApplication;
        this.val$source = iSource;
        this.val$deviceId = n;
        this.val$terminal = iMediaTerminal;
        super(string);
    }

    @Override
    public void run() {
        ISourceSlot iSourceSlot;
        Iterator iterator = this.val$source.getSlots().iterator();
        int n = -1;
        while (iterator.hasNext()) {
            iSourceSlot = (ISourceSlot)iterator.next();
            if (iSourceSlot.getDeviceIndex() != this.val$deviceId) continue;
            n = iSourceSlot.getIndex();
            break;
        }
        if (n == -1) {
            n = this.val$deviceId;
        }
        iSourceSlot = this.val$source.getSlot(n);
        this.val$terminal.getSourceController().activateSource(new ActivationContext(iSourceSlot));
    }
}

