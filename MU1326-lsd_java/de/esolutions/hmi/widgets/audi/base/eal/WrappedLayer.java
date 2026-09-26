/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;

public class WrappedLayer
implements IWrappedLayer {
    private final String name;
    private final IWrappedNode3D node;
    private IWrappedNode3D ltrNode;
    private final int width;
    private final int height;
    private final int index;
    private boolean invalid;
    private boolean leftToRight = true;
    private IWrappedViewport viewport;

    public WrappedLayer(IWrappedViewport iWrappedViewport, String string, IWrappedNode3D iWrappedNode3D, IWrappedNode3D iWrappedNode3D2, int n, int n2, int n3) {
        this.viewport = iWrappedViewport;
        this.name = string;
        this.node = iWrappedNode3D;
        this.ltrNode = iWrappedNode3D2;
        this.width = n;
        this.height = n2;
        this.index = n3;
    }

    @Override
    public boolean isLayoutDirectionLeftToRight() {
        return this.leftToRight;
    }

    @Override
    public void setLayerOpacity(float f2) {
        this.node.setOpacity(f2);
    }

    @Override
    public void setLayoutDirectionLeftToRight(boolean bl) {
        this.leftToRight = bl;
        this.updateLtrNode();
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void updateLtrNode() {
        float f2 = this.leftToRight ? 1.0f : (float)32959;
        int n = this.leftToRight ? 0 : this.getLTRNode().getScreenWidth();
        this.getLTRNode().setScale(f2, 1.0f, 1.0f);
        this.getLTRNode().setPosition(n, 0.0f, 0.0f);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IWrappedNode3D getNode() {
        return this.getLTRNode();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean invalidateObject() {
        return this.node.invalidateObject();
    }

    @Override
    public void setInvalid(boolean bl) {
        this.invalid = bl;
    }

    @Override
    public boolean isInvalid() {
        return this.invalid;
    }

    private IWrappedNode3D getLTRNode() {
        return this.ltrNode;
    }

    public int getXOffsetBeforeFlip() {
        return (int)this.node.getX();
    }

    @Override
    public IWrappedNode3D getMainNode() {
        return this.node;
    }

    @Override
    public IWrappedViewport getViewport() {
        return this.viewport;
    }

    @Override
    public void setViewport(IWrappedViewport iWrappedViewport) {
        this.viewport = iWrappedViewport;
    }

    public String toString() {
        Buffer buffer = new Buffer(this.name.length() + 10);
        buffer.append("Layer[").append(this.name).append(", viewport=").append(this.viewport).append(']');
        return buffer.toString();
    }
}

