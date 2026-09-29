/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.tghu.iconrenderer.IconRendererSimulation;
import org.dsi.ifc.global.ResourceLocator;

class IconRendererSimulation$1
extends Thread {
    private final /* synthetic */ IconRendererSimulation this$0;

    IconRendererSimulation$1(IconRendererSimulation iconRendererSimulation) {
        this.this$0 = iconRendererSimulation;
    }

    @Override
    public void run() {
        IconRendererSimulation.access$000(this.this$0).resourceIdForPOIIcon(new ResourceLocator(31585541));
    }
}

