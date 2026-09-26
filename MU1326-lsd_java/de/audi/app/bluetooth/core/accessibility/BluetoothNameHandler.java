/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;

public class BluetoothNameHandler
extends AbstractBluetoothComponent
implements SpellerListener,
ButtonListener {
    private static final int MIN_LENGTH;
    private static final int MAX_LENGTH;
    private static final int MODEL_STATUS_ENABLE;
    private static final int MODEL_STATUS_DISABLE;
    private final int[] attributeNotifications = new int[]{9};
    private String userFriendlyName;
    protected final SpellerModelApp nameSpeller = this.getSpellerModel(505816576);
    protected final SpellerModelApp nameSpeller2 = this.getSpellerModel(-819583488);
    private final TextfieldModelApp nameTextfield = this.getTextfieldModel(489039360);
    private final ButtonModelApp setNameButton = this.getButtonModel(522593792);

    public BluetoothNameHandler(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
        if (n != 1) {
            return;
        }
        this.log.log(-2137614336, "BluetoothNameHandler#updateUserFriendlyName(): %1", (Object)string);
        this.userFriendlyName = string;
        this.nameSpeller.setText(string);
        this.nameSpeller2.setText(string);
        this.updateSpellerStatus();
        this.nameTextfield.setText1(string);
    }

    protected void updateSpellerStatus() {
        this.nameSpeller.setStatus(this.isValid(this.nameSpeller.getText()) ? 0 : 1);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (n == this.nameSpeller.getID()) {
            this.log.log(14808325, "BluetoothNameHandler#textChanged(): Text=\"%1\"", (Object)string);
            this.nameSpeller.setText(string);
            this.updateSpellerStatus();
        } else if (n == this.nameSpeller2.getID()) {
            this.log.log(14808325, "BluetoothNameHandler#textChanged(): Text=\"%1\"", (Object)string);
            if (string.length() <= 20) {
                this.nameSpeller.setText(string);
            }
            this.updateSpellerStatus();
            this.nameSpeller2.fireEvent(n2);
        }
    }

    private boolean isValid(String string) {
        return string != null && string.length() >= 4 && string.length() <= 20;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "BluetoothNameHandler#keyTyped(): %1", (long)n);
        if (n == this.nameTextfield.getID()) {
            this.nameSpeller.setText(this.userFriendlyName);
            this.nameSpeller2.setText(this.userFriendlyName);
            this.updateSpellerStatus();
            this.nameTextfield.fireEvent(n3);
        } else if (n == this.setNameButton.getID() || n == this.nameSpeller.getID()) {
            this.applyUserFriendlyName(n3);
        }
    }

    protected void applyUserFriendlyName(int n) {
        this.dsiBluetooth.setUserFriendlyName(this.nameSpeller.getText());
        this.setNameButton.fireEvent(n);
        this.nameSpeller.fireEvent(n);
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void init() {
        super.init();
        this.nameSpeller.setSpellerListener(this);
        this.nameSpeller.setMinLength(4);
        this.nameSpeller.setMaxLength(20);
        this.nameSpeller2.setSpellerListener(this);
        this.nameSpeller2.setMinLength(4);
        this.nameSpeller2.setMaxLength(20);
        this.nameTextfield.setButtonListener(this);
        this.setNameButton.setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.nameSpeller.resetListener();
        this.nameSpeller2.resetListener();
        this.nameTextfield.resetListener();
        this.setNameButton.resetListener();
        super.deinit();
    }
}

