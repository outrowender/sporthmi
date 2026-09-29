/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class WidgetOffsetContainerR8
extends LayoutContainerController {
    private int x;
    private int y;
    private int width;
    private int height;

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (this.terminal.getCarCodingHelper().isR8()) {
            super.setBounds(this.x, this.y, this.width, this.height);
        }
    }
}

