/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.accessibility;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.accessibility.AbstractAccessibility;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class Accessibility
extends AbstractAccessibility
implements ChoiceListener {
    private final ChoiceModelApp accessibilityModel = this.getChoiceModel(2500231);

    public Accessibility(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected void updateModels(int n, boolean bl) {
        this.log.log(10000000, "Accessibility#updateModelValue(): btState=%2, visible=%1", bl, (long)n);
        this.accessibilityModel.setValue(n == 0 ? (bl ? 0 : 1) : 2);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1000000, "Accessibility#itemSelected(): modelID=%1, itemID=%2", (long)n, (long)n2);
        if (n == this.accessibilityModel.getID()) {
            if (n2 != 2 || this.isTurnOffValid()) {
                this.accessibilityModel.setValue(n2);
                this.btStateSelected(n2);
            } else {
                this.log.log(10000000, "Accessibility#itemSelected(): Ignoring selection");
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void init() {
        super.init();
        this.accessibilityModel.setChoiceListener(this);
    }

    public void deinit() {
        this.accessibilityModel.resetListener();
        super.deinit();
    }
}

