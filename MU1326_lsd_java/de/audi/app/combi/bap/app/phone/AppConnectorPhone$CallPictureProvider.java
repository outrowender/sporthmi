/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.app.phone.AppConnectorPhone;
import de.audi.app.combi.bap.app.phone.AppConnectorPhone$1;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import org.dsi.ifc.global.ResourceLocator;

class AppConnectorPhone$CallPictureProvider
implements IPictureProvider {
    private final /* synthetic */ AppConnectorPhone this$0;

    private AppConnectorPhone$CallPictureProvider(AppConnectorPhone appConnectorPhone) {
        this.this$0 = appConnectorPhone;
    }

    @Override
    public void requestPicture(long l) {
        int n = (int)l;
        if (n >= 0 && n < 7) {
            int n2 = AppConnectorPhone.access$000(this.this$0) != null && AppConnectorPhone.access$000(this.this$0)[n] != null ? AppConnectorPhone.access$000(this.this$0)[n].getCallType() : 0;
            ResourceLocator resourceLocator = AppConnectorPhone.access$100(this.this$0) != null && AppConnectorPhone.access$100(this.this$0)[n] != null ? new ResourceLocator(AppConnectorPhone.access$100(this.this$0)[n].getPictureID(), AppConnectorPhone.access$100(this.this$0)[n].getPictureURL()) : new ResourceLocator();
            ((AbstractCombiModule)AppConnectorPhone.access$200(this.this$0)).getPictureManager().responseActiveCallPicture(n, n2, resourceLocator, false);
        } else {
            AppConnectorPhone.access$300(this.this$0).log(-1601830656, "[AppConnectorPhone.CallPictureProvider#requestPicture] invalid callID: %1", (long)n);
        }
    }

    @Override
    public void requestPicture(long l, int n) {
        this.requestPicture(l);
    }

    /* synthetic */ AppConnectorPhone$CallPictureProvider(AppConnectorPhone appConnectorPhone, AppConnectorPhone$1 appConnectorPhone$1) {
        this(appConnectorPhone);
    }
}

