/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

public class Bounds {
    private int x;
    private int y;
    private int width;
    private int height;

    public Bounds(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public Bounds(Bounds bounds) {
        this(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public Bounds(AbstractWidget abstractWidget) {
        this(abstractWidget.getX(), abstractWidget.getY(), abstractWidget.getWidth(), abstractWidget.getHeight());
    }

    public void join(Bounds bounds) {
        int n = Math.min(this.x, bounds.x);
        int n2 = Math.min(this.y, bounds.y);
        int n3 = Math.max(this.x + this.width, bounds.x + bounds.width);
        int n4 = n3 - n;
        int n5 = Math.max(this.y + this.height, bounds.y + bounds.height);
        int n6 = n5 - n2;
        this.setX(n);
        this.setY(n2);
        this.setWidth(n4);
        this.setHeight(n6);
    }

    public void setBoundsToWidget(AbstractWidget abstractWidget) {
        abstractWidget.setBounds(this.x, this.y, this.width, this.height);
    }

    public int getXDiff(Bounds bounds) {
        return bounds.x - this.x;
    }

    public int getYDiff(Bounds bounds) {
        return bounds.y - this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int n) {
        this.x = n;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int n) {
        this.y = n;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }
}

