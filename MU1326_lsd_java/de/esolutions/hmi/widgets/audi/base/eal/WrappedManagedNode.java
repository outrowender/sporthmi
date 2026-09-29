/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.util.Util;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedManagedNode;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WrappedManagedNode
implements IWrappedManagedNode,
IWidgetLogChannel {
    private final INode2DManaged node;
    private final List viewports = new ArrayList();
    private final Map childNodes = new HashMap();

    public WrappedManagedNode(INode2DManaged iNode2DManaged) {
        this.node = iNode2DManaged;
    }

    @Override
    public INode2DManaged getNode() {
        return this.node;
    }

    @Override
    public ITexture enableOffscreen(int n, int n2, FlagTexture flagTexture) {
        return this.node.enableOffscreen(n, n2, flagTexture);
    }

    @Override
    public boolean addViewport(IWrappedViewport iWrappedViewport) {
        this.viewports.add(iWrappedViewport);
        return this.node.addToScreen(iWrappedViewport.getLink(), iWrappedViewport.getIndex());
    }

    @Override
    public boolean addToScreen(INode2D iNode2D, int n) {
        return this.node.addToScreen(iNode2D, n);
    }

    @Override
    public boolean addAuto(INode2D iNode2D, int n) {
        return this.node.addAuto(iNode2D, n);
    }

    @Override
    public boolean removeFromScreen(INode2D iNode2D) {
        return this.node.removeFromScreen(iNode2D);
    }

    @Override
    public INode2D getChildByIndex(int n) {
        INode2D iNode2D;
        Integer n2 = Util.createInteger(n);
        INode2D iNode2D2 = (INode2D)this.childNodes.get(n2);
        if (iNode2D2 != null) {
            if (iNode2D2.isValid()) {
                return iNode2D2;
            }
            logChannel3DEngine.log(-1601830656, "WrappedManagedNode#getChildByIndex cached child at index %1 is invalid", (long)n);
            this.childNodes.remove(n2);
            iNode2D2.dispose();
        }
        if ((iNode2D = this.node.getChildByIndex(n)).isValid()) {
            this.childNodes.put(n2, iNode2D);
            return iNode2D;
        }
        logChannel3DEngine.log(1078071040, "WrappedManagedNode#getChildByIndex no valid child found at index %1", (long)n);
        iNode2D.dispose();
        return null;
    }

    @Override
    public boolean remove(IWrappedViewport iWrappedViewport) {
        boolean bl;
        if (!this.viewports.remove(iWrappedViewport)) {
            logChannel3DEngine.log(10000, "WrappedManagedNode#remove no child layer '%1' not found", (Object)iWrappedViewport.getName());
        }
        if (!(bl = this.node.removeFromScreen(iWrappedViewport.getLink()))) {
            logChannel3DEngine.log(10000, "WrappedManagedNode#remove could not remove layer '%1'", (Object)iWrappedViewport.getName());
        }
        return bl;
    }

    @Override
    public List getViewports() {
        return Collections.unmodifiableList(this.viewports);
    }

    @Override
    public String getName() {
        return this.node.getName();
    }
}

