/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.esolutions.hmi.widgets.audi.evo.widgets.IMultilineTextFiledRenderer;

public class ViewPort {
    private IMultilineTextFiledRenderer renderer;
    public int x;
    public int w;
    public float y;
    public float h;
    public float vpY;
    public int vpFirstVisibleLine;
    public int vpLastVisibleLine;
    public int vpNoVisibleLines;

    public ViewPort(ViewPort viewPort) {
        this.x = viewPort.x;
        this.y = viewPort.y;
        this.w = viewPort.w;
        this.h = viewPort.h;
        this.vpY = viewPort.vpY;
        this.renderer = viewPort.renderer;
        this.vpFirstVisibleLine = viewPort.vpFirstVisibleLine;
        this.vpLastVisibleLine = viewPort.vpLastVisibleLine;
        this.vpNoVisibleLines = viewPort.vpNoVisibleLines;
    }

    public ViewPort(int n, int n2, int n3, int n4, int n5, IMultilineTextFiledRenderer iMultilineTextFiledRenderer) {
        this.x = n;
        this.y = n2;
        this.w = n3;
        this.h = n4;
        this.vpY = n5;
        this.renderer = iMultilineTextFiledRenderer;
    }

    public void setYOffset(int n) {
        this.vpFirstVisibleLine = n / this.renderer.getLineHeight();
        this.vpLastVisibleLine = (int)((float)n + this.h) / this.renderer.getLineHeight();
        this.vpNoVisibleLines = this.vpLastVisibleLine - this.vpFirstVisibleLine;
        this.vpY = n;
    }

    public void updateVPYOffset(int n, int n2, int n3, int n4) {
        this.vpFirstVisibleLine = n;
        this.vpLastVisibleLine = n2;
        this.vpNoVisibleLines = n3;
        this.h = n4;
        this.vpY = this.vpFirstVisibleLine * this.renderer.getLineHeight();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + Float.floatToIntBits(this.h);
        n = 31 * n + this.vpFirstVisibleLine;
        n = 31 * n + this.vpLastVisibleLine;
        n = 31 * n + this.vpNoVisibleLines;
        n = 31 * n + Float.floatToIntBits(this.vpY);
        n = 31 * n + this.w;
        n = 31 * n + this.x;
        n = 31 * n + Float.floatToIntBits(this.y);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ViewPort)) {
            return false;
        }
        ViewPort viewPort = (ViewPort)object;
        if (Float.floatToIntBits(this.h) != Float.floatToIntBits(viewPort.h)) {
            return false;
        }
        if (this.vpFirstVisibleLine != viewPort.vpFirstVisibleLine) {
            return false;
        }
        if (this.vpLastVisibleLine != viewPort.vpLastVisibleLine) {
            return false;
        }
        if (this.vpNoVisibleLines != viewPort.vpNoVisibleLines) {
            return false;
        }
        if (Float.floatToIntBits(this.vpY) != Float.floatToIntBits(viewPort.vpY)) {
            return false;
        }
        if (this.w != viewPort.w) {
            return false;
        }
        if (this.x != viewPort.x) {
            return false;
        }
        return Float.floatToIntBits(this.y) == Float.floatToIntBits(viewPort.y);
    }
}

