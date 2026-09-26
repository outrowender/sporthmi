/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.MediaCore;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MediaCore$2
implements IDiagnosisDataProvider {
    private final /* synthetic */ MediaCore this$0;

    MediaCore$2(MediaCore mediaCore) {
        this.this$0 = mediaCore;
    }

    @Override
    public String getDiagValue() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MediaCore.access$100(this.this$0).dump(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream.toString();
    }

    @Override
    public String getDiagKey() {
        return "Dispatcher";
    }
}

