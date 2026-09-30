/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import java.util.List;

public interface IWrappedManagedNode {
    public INode2DManaged getNode();

    public ITexture enableOffscreen(int var1, int var2, FlagTexture var3);

    public boolean addViewport(IWrappedViewport var1);

    public boolean addToScreen(INode2D var1, int var2);

    public boolean addAuto(INode2D var1, int var2);

    public boolean removeFromScreen(INode2D var1);

    public INode2D getChildByIndex(int var1);

    public boolean remove(IWrappedViewport var1);

    public List getViewports();

    public String getName();
}

