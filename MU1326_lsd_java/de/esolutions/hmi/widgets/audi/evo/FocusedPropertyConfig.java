/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.property.PropertyModelGui;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IFocusedPropertyProvider;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyObject;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;

public class FocusedPropertyConfig
extends AbstractWidgetController
implements IFocusedPropertyProvider {
    private FocusedPropertyObject focusedPropertyObject = new FocusedPropertyObject();
    private boolean standalone = false;

    public FocusedPropertyConfig() {
    }

    public FocusedPropertyConfig(int n, int[] nArray) {
        this.focusedPropertyObject.setCategory(n);
        this.focusedPropertyObject.setProperties(nArray);
    }

    public void setWidgetID(int n) {
        this.focusedPropertyObject.setWidgetID(n);
    }

    public void initializeWidget() {
        super.initializeWidget();
        this.updateValue();
        boolean bl = this.standalone = !(this.parent instanceof IMenuItemSingle);
        if (this.standalone && this.isVisible()) {
            this.terminal.getDrawerFocusManager().registerFocusPropertyProvider(this);
        }
    }

    public void disconnecting() {
        super.disconnecting();
        if (this.standalone) {
            this.terminal.getDrawerFocusManager().deRegisterFocusPropertyProvider(this);
        }
    }

    public void setStandalone(boolean bl) {
        this.standalone = bl;
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (this.standalone && this.terminal != null) {
            if (bl) {
                this.terminal.getDrawerFocusManager().registerFocusPropertyProvider(this);
            } else {
                this.terminal.getDrawerFocusManager().deRegisterFocusPropertyProvider(this);
            }
        }
    }

    public void setCategory(int n) {
        this.focusedPropertyObject.setCategory(n);
    }

    public int getCategory() {
        return this.focusedPropertyObject.getCategory();
    }

    public void setProperties(int[] nArray) {
        this.focusedPropertyObject.setProperties(nArray);
    }

    public int[] getProperties() {
        return this.focusedPropertyObject.getProperties();
    }

    public IFocusedPropertyObject getCurrentFocusedPropertyObject() {
        return this.focusedPropertyObject;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 14) {
            this.updateValue();
            this.terminal.getDrawerConditionEngine().setFocusedProperty(this.focusedPropertyObject);
        }
    }

    private void updateValue() {
        if (this.model != null) {
            PropertyModelGui propertyModelGui = (PropertyModelGui)this.model;
            this.focusedPropertyObject.setCategory(propertyModelGui.getCategory());
            this.focusedPropertyObject.setProperties(propertyModelGui.getProperties());
        }
    }
}

