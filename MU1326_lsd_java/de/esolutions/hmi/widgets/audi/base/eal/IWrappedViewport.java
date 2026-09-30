/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode2DLink;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import java.util.List;

public interface IWrappedViewport {
    public IWrappedTexture enableOffscreen();

    public IWrappedTexture enableOffscreen(int var1, int var2);

    public void disableOffscreen();

    public INode2DLink getLink();

    public String getName();

    public INode3DScene getScene();

    public int getWidth();

    public int getHeight();

    public int getIndex();

    public void destroyTexture();

    public IWrappedTexture getTexture();

    public boolean isAutomaticallyCreated();

    public int getLayerCount();

    public void removeLayer(IWrappedLayer var1);

    public void addLayer(IWrappedLayer var1);

    public void setVisible(boolean var1);

    public List getLayers();

    public void setForceInvisible(boolean var1);
}

