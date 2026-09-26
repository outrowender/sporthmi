/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.DsiProperties;
import de.audi.tv.app.dsi.DsiProperties$Properties;
import org.dsi.ifc.tvtuner.ProgramInfo;

public class DsiProperties$DsiUpListener
extends DefaultTVListener {
    private final /* synthetic */ DsiProperties this$0;

    public DsiProperties$DsiUpListener(DsiProperties dsiProperties) {
        this.this$0 = dsiProperties;
    }

    @Override
    public void updateSelectedService(ProgramInfo programInfo) {
        DsiProperties$Properties.access$200(DsiProperties.access$000(this.this$0)).accept(programInfo.serviceInfo);
        DsiProperties$Properties.access$300(DsiProperties.access$000(this.this$0)).accept(programInfo);
        DsiProperties$Properties.access$400(DsiProperties.access$000(this.this$0)).accept(new Integer(programInfo.casStatus));
    }
}

