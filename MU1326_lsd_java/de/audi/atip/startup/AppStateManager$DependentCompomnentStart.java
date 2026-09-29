/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.ComponentState;
import java.util.List;

public class AppStateManager$DependentCompomnentStart {
    private final String componentName;
    private final List queue;
    private final boolean startSubComponents;
    private final /* synthetic */ AppStateManager this$0;

    AppStateManager$DependentCompomnentStart(AppStateManager appStateManager, String string, List list, boolean bl) {
        this.this$0 = appStateManager;
        this.componentName = string;
        this.queue = list;
        this.startSubComponents = bl;
    }

    void reCheckDependency() {
        ComponentState componentState = this.this$0.getComponentByName(this.componentName);
        if (componentState != null && componentState.hasDependentComponents()) {
            componentState.enqueueCheckDependencies(this.queue, true, this.startSubComponents);
        }
    }
}

