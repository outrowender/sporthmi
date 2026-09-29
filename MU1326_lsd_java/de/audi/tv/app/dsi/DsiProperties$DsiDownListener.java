/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DsiProperties;
import de.audi.tv.app.dsi.DsiProperties$Properties;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class DsiProperties$DsiDownListener
extends DSICallListener {
    private final /* synthetic */ DsiProperties this$0;

    public DsiProperties$DsiDownListener(DsiProperties dsiProperties) {
        this.this$0 = dsiProperties;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        DsiProperties$Properties.access$100(DsiProperties.access$000(this.this$0)).accept(serviceInfo);
    }
}

