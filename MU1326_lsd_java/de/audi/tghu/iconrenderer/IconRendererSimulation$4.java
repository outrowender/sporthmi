/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.tghu.iconrenderer.IconRendererSimulation;
import org.dsi.ifc.global.ResourceLocator;

class IconRendererSimulation$4
extends Thread {
    private final /* synthetic */ IconRendererSimulation this$0;

    IconRendererSimulation$4(IconRendererSimulation iconRendererSimulation) {
        this.this$0 = iconRendererSimulation;
    }

    @Override
    public void run() {
        IconRendererSimulation.access$000(this.this$0).resourceIdForTrafficRegulationIcon(new ResourceLocator(31585541));
    }
}

