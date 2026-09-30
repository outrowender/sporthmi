/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.display;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.display.IMediaDisplayManagerListener;

public interface IDSIDisplayManagerController
extends IDSIController {
    public void setDisplayManagerListener(IMediaDisplayManagerListener var1);

    public void setBrightness(int var1, int var2);

    public void setContrast(int var1, int var2);

    public void setColor(int var1, int var2);

    public void setTint(int var1, int var2);
}

