/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

public class RectangleParameters {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public RectangleParameters(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public RectangleParameters(AbstractWidget abstractWidget) {
        this.x = abstractWidget.getX();
        this.y = abstractWidget.getY();
        this.width = abstractWidget.getWidth();
        this.height = abstractWidget.getHeight();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public RectangleParameters getInterpolatedRectangle(RectangleParameters rectangleParameters, float f2) {
        int n = RectangleParameters.getInterpolatedValue(this.getX(), rectangleParameters.getX(), f2);
        int n2 = RectangleParameters.getInterpolatedValue(this.getY(), rectangleParameters.getY(), f2);
        int n3 = RectangleParameters.getInterpolatedValue(this.getWidth(), rectangleParameters.getWidth(), f2);
        int n4 = RectangleParameters.getInterpolatedValue(this.getHeight(), rectangleParameters.getHeight(), f2);
        return new RectangleParameters(n, n2, n3, n4);
    }

    private static int getInterpolatedValue(int n, int n2, float f2) {
        return Math.round((float)n + (float)(n2 - n) * f2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append("BoundsAnimationParameter [");
        stringBuffer.append(this.x);
        stringBuffer.append(", ");
        stringBuffer.append(this.y);
        stringBuffer.append(' ');
        stringBuffer.append(this.width);
        stringBuffer.append('x');
        stringBuffer.append(this.height);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

