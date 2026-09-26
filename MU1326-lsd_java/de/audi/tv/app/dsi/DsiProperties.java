/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.DsiProperties$DsiDownListener;
import de.audi.tv.app.dsi.DsiProperties$DsiUpListener;
import de.audi.tv.app.dsi.DsiProperties$Properties;

public class DsiProperties {
    public final DSICallListener dsiDownListener = new DsiProperties$DsiDownListener(this);
    public final DefaultTVListener dsiUpListener = new DsiProperties$DsiUpListener(this);
    private final DsiProperties$Properties myProperties;

    public DsiProperties(TVEnv tVEnv) {
        this.myProperties = tVEnv.properties.dsiProperties;
    }

    static /* synthetic */ DsiProperties$Properties access$000(DsiProperties dsiProperties) {
        return dsiProperties.myProperties;
    }
}

