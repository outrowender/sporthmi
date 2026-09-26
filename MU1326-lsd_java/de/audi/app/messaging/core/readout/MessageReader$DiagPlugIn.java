/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.IReadable;
import de.audi.app.messaging.core.readout.MessageReader;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.util.Arrays;
import java.util.ArrayList;

final class MessageReader$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$DiagPlugIn(MessageReader messageReader) {
        this.this$0 = messageReader;
    }

    public Object getTtsMarkup() {
        String string = null;
        IReadable iReadable = MessageReader.access$1000(this.this$0).getReadable();
        if (iReadable == null) {
            string = String.valueOf(null);
        } else {
            ArrayList arrayList = new ArrayList(2);
            while (iReadable.hasNextSpeakTask()) {
                arrayList.add(iReadable.nextSpeakTask());
            }
            string = Arrays.toMultiLineString(arrayList.toArray());
        }
        return string;
    }

    public Object getReadableProvider() {
        return String.valueOf(MessageReader.access$1000(this.this$0));
    }
}

