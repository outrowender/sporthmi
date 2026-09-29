/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.combi.bap.app.audio.AppConnectorMedia;
import de.audi.app.combi.bap.app.audio.AppConnectorMedia$1;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceMediaListener;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

class AppConnectorMedia$CoverArtProvider
implements IPictureProvider {
    private final Map id2pictureURL = new HashMap();
    private final /* synthetic */ AppConnectorMedia this$0;

    private AppConnectorMedia$CoverArtProvider(AppConnectorMedia appConnectorMedia) {
        this.this$0 = appConnectorMedia;
    }

    @Override
    public void requestPicture(long l) {
        this.requestPicture(l, 255);
    }

    @Override
    public void requestPicture(long l, int n) {
        Long l2 = new Long(l);
        if (this.id2pictureURL.containsKey(l2)) {
            ((AbstractCombiModule)AppConnectorMedia.access$000(this.this$0)).getPictureManager().responseCoverArt(l, n, (ResourceLocator)this.id2pictureURL.get(l2), false);
        } else if (AppConnectorMedia.access$100(this.this$0) instanceof CombiBAPServiceMediaListener) {
            AppConnectorMedia.access$200(this.this$0).log(-2137614336, "[AppConnectorMedia.CoverArtProvider#requestPicture] call media service 'requestCoverArt(bapEntryID=%1)'", l);
            ((AbstractCombiModule)AppConnectorMedia.access$300(this.this$0)).getPictureManager().responseCoverArt(l, n, null, false);
        }
    }

    public void addToMapping(long l, ResourceLocator resourceLocator) {
        this.id2pictureURL.put(new Long(l), resourceLocator);
    }

    public void clearMapping() {
        this.id2pictureURL.clear();
    }

    /* synthetic */ AppConnectorMedia$CoverArtProvider(AppConnectorMedia appConnectorMedia, AppConnectorMedia$1 appConnectorMedia$1) {
        this(appConnectorMedia);
    }
}

