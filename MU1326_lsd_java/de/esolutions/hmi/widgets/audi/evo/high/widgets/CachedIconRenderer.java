/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class CachedIconRenderer
extends IconRendererHigh {
    public CachedIconRenderer(IconController iconController) {
        super(iconController);
    }

    protected TextureDescription handleIntegerContent(Integer n, EALManager eALManager) {
        if (eALManager == null) {
            return null;
        }
        int n2 = n;
        int n3 = this.getAbstractController().getBitmap(n2);
        if (n3 >= 0 && AbstractWidget.hmiService != null) {
            HMIImage hMIImage = eALManager.getHMIImage(n3, this.getInitContext().getScreenID());
            return eALManager.createTextureDescription(hMIImage, this.getCache(eALManager, 2), this.useEalAtlas(), true);
        }
        return null;
    }
}

