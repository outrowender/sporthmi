/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.List;

public class SizeableIconController
extends IconController {
    private int actualHeight;
    private int actualWidth;

    public void setBounds(int n, int n2, int n3, int n4) {
        if (this.actualWidth != -1 && this.actualHeight != -1) {
            MenuItemController menuItemController;
            List list;
            super.setBounds(n, n2, this.actualWidth, this.actualHeight);
            if (this.getParent() instanceof MenuItemController && (list = (menuItemController = (MenuItemController)this.getParent()).getChildren()) != null && list.size() > 0) {
                int n5 = 0;
                int n6 = 0;
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    if (!(list.get(i2) instanceof SelectionCursorController)) continue;
                    SelectionCursorController selectionCursorController = (SelectionCursorController)list.get(i2);
                    n5 = selectionCursorController.getY();
                    n6 = selectionCursorController.getHeight();
                    break;
                }
                this.setX(this.getX() - (this.actualWidth - this.getPreferredWidth()));
                this.setY(n5 + (n6 - this.actualHeight) / 2);
                this.setCompositesDirty(true);
            }
        } else {
            super.setBounds(n, n2, this.getPreferredWidth(), this.getPreferredHeight());
        }
    }

    public int getActualHeight() {
        return this.actualHeight;
    }

    public void setActualHeight(int n) {
        this.actualHeight = n;
    }

    public int getActualWidth() {
        return this.actualWidth;
    }

    public void setActualWidth(int n) {
        this.actualWidth = n;
    }
}

