/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.api.INode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;

public class WrappedNode3DQuickDraw
extends WrappedNode3D
implements IWrappedNode3DQuickDraw {
    private final INode3DQuickDraw node;
    private float lineWidth;
    private int color;

    public WrappedNode3DQuickDraw(INode3DQuickDraw iNode3DQuickDraw, int n, int n2, int n3, boolean bl) {
        super(iNode3DQuickDraw, n, n2, false, n3, bl);
        this.node = iNode3DQuickDraw;
    }

    public INode3DQuickDraw getQuickDrawNode() {
        return this.node;
    }

    public void resetTransformation() {
        super.resetTransformation();
    }

    public void add(float f2, float f3) {
        if (f2 == 0.0f && f3 == 0.0f) {
            return;
        }
        if (this.node != null) {
            Vec2f vec2f = new Vec2f(f2 -= this.unscaledWidth / 2.0f, f3 -= this.unscaledHeight / 2.0f);
            this.node.add(vec2f);
        }
    }

    public void setLineWidth(float f2) {
        if (this.lineWidth == f2) {
            return;
        }
        this.lineWidth = f2;
        if (this.node != null) {
            this.node.setLineWidth(f2);
        }
    }

    public void setLineColor(int n) {
        if (this.sameColor(n)) {
            return;
        }
        this.storeColor(n);
        if (this.node != null) {
            this.node.setColor(n);
        }
    }

    private void storeColor(int n) {
        this.color = n;
    }

    private boolean sameColor(int n) {
        return this.color == n;
    }

    public void clearArea() {
        if (this.node != null) {
            this.node.clearArea();
        }
    }
}

