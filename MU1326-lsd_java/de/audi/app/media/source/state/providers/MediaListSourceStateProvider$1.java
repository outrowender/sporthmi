/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.state.providers.MediaListSourceStateProvider;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.media.DeviceInfo;

class MediaListSourceStateProvider$1
implements IDiagnosisDataProvider {
    private final /* synthetic */ MediaListSourceStateProvider this$0;

    MediaListSourceStateProvider$1(MediaListSourceStateProvider mediaListSourceStateProvider) {
        this.this$0 = mediaListSourceStateProvider;
    }

    @Override
    public String getDiagValue() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < MediaListSourceStateProvider.access$000(this.this$0).length; ++i2) {
            List list = MediaListSourceStateProvider.access$000(this.this$0)[i2];
            if (list == null) continue;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                buffer.append(LogUtil.deviceInfoToStr((DeviceInfo)iterator.next())).append("\n");
            }
        }
        return buffer.toString();
    }

    @Override
    public String getDiagKey() {
        return "DSIMediaBase.deviceList";
    }
}

