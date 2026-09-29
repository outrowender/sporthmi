/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

public class FocusedPropertyObject
implements IFocusedPropertyObject {
    private int category = 0;
    private int[] properties = null;
    private int modelID = -1;
    private int row = 0;
    private int widgetID = 0;
    private IRightDrawerActionReceiver actionReceiverWidget = null;

    public FocusedPropertyObject() {
    }

    public FocusedPropertyObject(int n, int[] nArray) {
        this.category = n;
        this.properties = nArray;
    }

    public void setPropertyListCell(PropertyListCell propertyListCell) {
        this.setPropertyListCell(propertyListCell, -1, 0);
    }

    public void setPropertyListCell(PropertyListCell propertyListCell, int n, int n2) {
        this.category = propertyListCell.getCategory();
        this.properties = propertyListCell.getProperties();
        this.modelID = n;
        this.row = n2;
    }

    public void setCategory(int n) {
        this.category = n;
    }

    @Override
    public int getCategory() {
        return this.category;
    }

    public void setProperties(int[] nArray) {
        this.properties = nArray;
    }

    @Override
    public int[] getProperties() {
        return this.properties;
    }

    @Override
    public void setModelID(int n) {
        this.modelID = n;
    }

    @Override
    public int getModelID() {
        return this.modelID;
    }

    @Override
    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getWidgetID() {
        return this.widgetID;
    }

    public String toString() {
        Buffer buffer = new Buffer("FocusPropertyObject[category: ");
        buffer.append(this.category);
        buffer.append(", row:");
        buffer.append(this.row);
        buffer.append(", modelID: ");
        buffer.append(", properties: (");
        if (this.properties != null) {
            for (int i2 = 0; i2 < this.properties.length; ++i2) {
                if (i2 > 0) {
                    buffer.append(", ");
                }
                buffer.append(this.properties[i2]);
            }
        } else {
            buffer.append("null");
        }
        buffer.append(")]");
        return buffer.toString();
    }

    @Override
    public IRightDrawerActionReceiver getActionReceiverWidget() {
        return this.actionReceiverWidget;
    }

    @Override
    public void setActionReceiverWidget(IRightDrawerActionReceiver iRightDrawerActionReceiver) {
        this.actionReceiverWidget = iRightDrawerActionReceiver;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.category;
        n = 31 * n + this.modelID;
        n = 31 * n + FocusedPropertyObject.hashCode(this.properties);
        n = 31 * n + this.row;
        n = 31 * n + this.widgetID;
        return n;
    }

    private static int hashCode(int[] nArray) {
        int n = 31;
        if (nArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 = n * n2 + nArray[i2];
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof FocusedPropertyObject)) {
            return false;
        }
        FocusedPropertyObject focusedPropertyObject = (FocusedPropertyObject)object;
        if (this.category != focusedPropertyObject.category) {
            return false;
        }
        if (this.modelID != focusedPropertyObject.modelID) {
            return false;
        }
        if (!Arrays.equals(this.properties, focusedPropertyObject.properties)) {
            return false;
        }
        if (this.row != focusedPropertyObject.row) {
            return false;
        }
        return this.widgetID == focusedPropertyObject.widgetID;
    }
}

