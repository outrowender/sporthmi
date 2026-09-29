/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;

public class WrappedNode3DVisibility
extends WrappedNode3D {
    private IWrappedViewport viewport;

    public WrappedNode3DVisibility(INode3D iNode3D, float f2, float f3, boolean bl, int n, IWrappedViewport iWrappedViewport, boolean bl2) {
        super(iNode3D, f2, f3, bl, n, bl2);
        this.viewport = iWrappedViewport;
        this.setVisible(false);
    }

    @Override
    public boolean remove(IWrappedNode3D iWrappedNode3D) {
        boolean bl = super.remove(iWrappedNode3D);
        this.updateVisibility();
        return bl;
    }

    @Override
    public void addByIndex(IWrappedNode3D iWrappedNode3D, int n) {
        super.addByIndex(iWrappedNode3D, n);
        this.updateVisibility();
    }

    public void updateVisibility() {
        boolean bl = false;
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.size(); ++i2) {
                IWrappedNode3D iWrappedNode3D = (IWrappedNode3D)this.children.get(i2);
                if (!iWrappedNode3D.isVisible()) continue;
                bl = true;
                logChannel3DEngineLayersAndViewports.log(-2137614336, "WrappedNode3DVisibility#updateVisibility: at least one visible child");
                break;
            }
        }
        if (this.visible == bl) {
            if (logChannel3DEngineLayersAndViewports.isDebug()) {
                logChannel3DEngineLayersAndViewports.log(-2137614336, "WrappedNode3DVisibility#updateVisibility: %2 no visibility change, visible = %1", bl, (Object)this.getNode().getName());
            }
            return;
        }
        if (logChannel3DEngineLayersAndViewports.isInfo()) {
            logChannel3DEngineLayersAndViewports.log(1078071040, "WrappedNode3DVisibility#updateVisibility: %3, %2 visibility set to %1", bl, (Object)this.getNode().getName(), (Object)this.viewport);
        }
        this.setVisible(bl);
        if (this.viewport != null) {
            this.viewport.setVisible(bl);
        }
    }

    @Override
    public String toString() {
        String string = "WrappedNode3DVisibility[";
        Buffer buffer = new Buffer();
        buffer.append(string).append(this.getNodeName());
        buffer.append(", parent=").append(this.getParent()).append(']');
        return buffer.toString();
    }

    @Override
    public void resetTransformation() {
        boolean bl = this.isVisible();
        super.resetTransformation();
        this.setVisible(bl);
    }
}

