/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.state.providers.MediaListSourceStateProvider;
import de.esolutions.fw.util.commons.Buffer;

class MediaListSourceStateProvider$2
implements IDiagnosisDataProvider {
    private final /* synthetic */ MediaListSourceStateProvider this$0;

    MediaListSourceStateProvider$2(MediaListSourceStateProvider mediaListSourceStateProvider) {
        this.this$0 = mediaListSourceStateProvider;
    }

    @Override
    public String getDiagValue() {
        if (MediaListSourceStateProvider.access$100(this.this$0) == null) {
            return "";
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < MediaListSourceStateProvider.access$100(this.this$0).length; ++i2) {
            buffer.append(LogUtil.mediaInfoToStr(MediaListSourceStateProvider.access$100(this.this$0)[i2])).append("\n");
        }
        return buffer.toString();
    }

    @Override
    public String getDiagKey() {
        return "DSIMediaBase.mediaList";
    }
}

