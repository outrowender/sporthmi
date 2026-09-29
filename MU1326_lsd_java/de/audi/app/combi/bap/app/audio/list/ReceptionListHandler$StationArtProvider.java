/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler;
import de.audi.app.combi.bap.app.audio.list.ReceptionListHandler$1;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import org.dsi.ifc.global.ResourceLocator;

class ReceptionListHandler$StationArtProvider
implements IPictureProvider {
    private final /* synthetic */ ReceptionListHandler this$0;

    private ReceptionListHandler$StationArtProvider(ReceptionListHandler receptionListHandler) {
        this.this$0 = receptionListHandler;
    }

    @Override
    public void requestPicture(long l) {
        this.requestPicture(l, 255);
    }

    @Override
    public void requestPicture(long l, int n) {
        CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)this.this$0.getArrayElement((int)l);
        if (combiBAPReceptionListEntry != null) {
            String string = combiBAPReceptionListEntry.getPictureURL();
            ResourceLocator resourceLocator = string == null ? new ResourceLocator(-1) : new ResourceLocator(string);
            ((AbstractCombiModule)ReceptionListHandler.access$000(this.this$0)).getPictureManager().responseStationArt(l, n, resourceLocator, false);
        } else {
            ReceptionListHandler.access$200(this.this$0).log(-1601830656, "[%1.StationArtProvider#requestPicture] no entry available for entryID: %2", (Object)ReceptionListHandler.access$100(this.this$0), l);
            ((AbstractCombiModule)ReceptionListHandler.access$300(this.this$0)).getPictureManager().responseStationArt(l, n, null, false);
        }
    }

    /* synthetic */ ReceptionListHandler$StationArtProvider(ReceptionListHandler receptionListHandler, ReceptionListHandler$1 receptionListHandler$1) {
        this(receptionListHandler);
    }
}

