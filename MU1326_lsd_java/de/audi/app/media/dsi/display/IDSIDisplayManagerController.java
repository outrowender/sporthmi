/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.display;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.display.IMediaDisplayManagerListener;

public interface IDSIDisplayManagerController
extends IDSIController {
    default public void setDisplayManagerListener(IMediaDisplayManagerListener iMediaDisplayManagerListener) {
    }

    default public void setBrightness(int n, int n2) {
    }

    default public void setContrast(int n, int n2) {
    }

    default public void setColor(int n, int n2) {
    }

    default public void setTint(int n, int n2) {
    }
}

