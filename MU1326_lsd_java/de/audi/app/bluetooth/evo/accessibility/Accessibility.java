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
    private final ChoiceModelApp accessibilityModel = this.getChoiceModel(-2027543040);

    public Accessibility(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected void updateModels(int n, boolean bl) {
        this.log.log(-2137614336, "Accessibility#updateModelValue(): btState=%2, visible=%1", bl, (long)n);
        this.accessibilityModel.setValue(n == 0 ? (bl ? 0 : 1) : 2);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "Accessibility#itemSelected(): modelID=%1, itemID=%2", (long)n, (long)n2);
        if (n == this.accessibilityModel.getID()) {
            if (n2 != 2 || this.isTurnOffValid()) {
                this.accessibilityModel.setValue(n2);
                this.btStateSelected(n2);
            } else {
                this.log.log(-2137614336, "Accessibility#itemSelected(): Ignoring selection");
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void init() {
        super.init();
        this.accessibilityModel.setChoiceListener(this);
    }

    @Override
    public void deinit() {
        this.accessibilityModel.resetListener();
        super.deinit();
    }
}

