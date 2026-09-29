/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.SourceManager;
import de.audi.tv.app.SourceManager$1;
import de.audi.tv.app.SourceManager$Properties;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

class SourceManager$TVListener
extends DefaultTVListener {
    private final /* synthetic */ SourceManager this$0;

    private SourceManager$TVListener(SourceManager sourceManager) {
        this.this$0 = sourceManager;
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        SourceManager$Properties.access$100(SourceManager.access$500(this.this$0)).accept(new Boolean(startUpConfig.isAvSrcAvail()));
        SourceManager.access$600(this.this$0).setAvSourceAvailable(startUpConfig.avSrcAvail);
        SourceManager.access$200(this.this$0).log(1078071040, "[SourceManager.updateStartUpMUConfig] AV source available: %1", startUpConfig.isAvSrcAvail());
    }

    @Override
    public void updateSelectedSource(int n) {
        SourceManager$Properties.access$700(SourceManager.access$500(this.this$0)).accept(new Integer(n));
        SourceManager.access$200(this.this$0).log(1078071040, "[SourceManager.TVListener.updateSelectedSource] Source selected: %1", (long)n);
    }

    /* synthetic */ SourceManager$TVListener(SourceManager sourceManager, SourceManager$1 sourceManager$1) {
        this(sourceManager);
    }
}

