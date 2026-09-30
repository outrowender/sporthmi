/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.hotspot;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.hotspot.CommandSetProfile;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.networking.Profile;

public abstract class AbstractHotSpotProfile
extends AbstractWlanComponent
implements ButtonListener,
SpellerListener,
ChoiceListener {
    private static final String PASSWORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#*+-_";
    private static final int CRYPTO_WPA2 = 0;
    private static final int CRYPTO_WAPI = 1;
    private static final int CRYPTO_WEP = 2;
    private static final int CRYPTO_WPA = 3;
    private static final int MIN_SSID_LENGTH = 1;
    private static final int MAX_SSID_LENGTH = 32;
    private static final int MAX_PASSWORD_LENGTH_WEP = 13;
    private static final int MIN_PASSWORD_LENGTH_WEP = 8;
    private static final int MAX_PASSWORD_LENGTH_WPA = 63;
    private static final int MIN_PASSWORD_LENGTH_WPA = 8;
    private final int[] attributeNotifications = new int[]{22};
    protected Profile profile;
    private int encryption = 0;
    private final TextfieldModelApp ssidTextfield = this.getTextfieldModel(2500018);
    protected final SpellerModelApp ssidSpeller = this.getSpellerModel(2500019);
    protected final SpellerModelApp ssidSpeller2 = this.getSpellerModel(2500299);
    private final TextfieldModelApp passwordTextfield = this.getTextfieldModel(2500015);
    protected final SpellerModelApp passwordSpeller = this.getSpellerModel(2500016);
    protected final SpellerModelApp passwordSpeller2 = this.getSpellerModel(2500315);
    private final ChoiceModelApp visibilityChoice = this.getChoiceModel(2500020);
    private final ChoiceModelApp encriptionChoice = this.getChoiceModel(2500370);

    public AbstractHotSpotProfile(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public void updateProfile(Profile profile, int n) {
        if (n != 1 || profile == null) {
            return;
        }
        this.log.log(1000000, "AbstractHotSpotProfile#updateProfile(): %1", (Object)profile);
        this.profile = profile;
        String string = profile.getSSID();
        this.ssidTextfield.setText1(string);
        this.encryption = this.getCryptoChoiceValue(profile.getCryptoModel());
        this.encriptionChoice.setValue(this.encryption);
        this.passwordSpeller.setMinLength(this.encryption == 2 ? 8 : 8);
        this.passwordSpeller.setMaxLength(this.encryption == 2 ? 13 : 63);
        this.passwordSpeller2.setMinLength(this.encryption == 2 ? 8 : 8);
        this.passwordSpeller2.setMaxLength(this.encryption == 2 ? 13 : 63);
        String string2 = profile.getKeys()[profile.getKeyNumber()];
        this.passwordTextfield.setText1(string2);
        this.visibilityChoice.setValue(profile.isSSIDBroadcast() ? 1 : 0);
    }

    private int getCryptoChoiceValue(int n) {
        switch (n) {
            case 2: 
            case 3: {
                return 2;
            }
            case 4: 
            case 5: {
                return 3;
            }
            case 6: 
            case 7: {
                return 0;
            }
            case 10: {
                return 1;
            }
        }
        this.log.log(100000, "AbstractHotSpotProfile#getCryptoChoiceValue(): No mapping for cryptoModel %1!", (long)n);
        return 0;
    }

    private int getDSICryptoValue(int n) {
        switch (n) {
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 1: {
                return 10;
            }
        }
        return 7;
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.visibilityChoice.getID()) {
            this.log.log(1000000, "AbstractHotSpotProfile#itemSelected(): Visibility changed (0=off, 1=on):%1", (long)n2);
            this.visibilityChoice.setValue(n2);
            this.requestSetProfile();
        } else if (n == this.encriptionChoice.getID()) {
            this.encryption = n2;
            this.log.log(1000000, "AbstractHotSpotProfile#itemSelected(): Encription type changed: %1", (long)n2);
            this.encriptionChoice.setValue(n2);
            this.requestSetProfile();
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.ssidTextfield.getID()) {
            this.log.log(1000000, "AbstractHotSpotProfile#keyTyped(): preparing to change SSID: %1", (Object)this.ssidTextfield.getText1());
            this.ssidSpeller.setText(this.profile.getSSID());
            this.updateSsidSpellerStatus();
            this.ssidTextfield.fireEvent(n3);
        } else if (n == this.ssidSpeller2.getID()) {
            this.log.log(1000000, "AbstractHotSpotProfile#keyTyped(): preparing to change SSID: %1", (Object)this.ssidSpeller2.getText());
            this.ssidSpeller.setText(this.profile.getSSID());
            this.updateSsidSpellerStatus();
            this.ssidSpeller2.fireEvent(n3);
        } else if (n == this.passwordTextfield.getID()) {
            this.log.log(1000000, "AbstractHotSpotProfile#keyTyped(): preparing to change password: %1", (Object)this.passwordTextfield.getText1());
            this.passwordSpeller.setText(this.profile.getKeys()[this.profile.getKeyNumber()]);
            this.updatePasswordSpellerStatus();
            this.passwordTextfield.fireEvent(n3);
        } else if (n == this.passwordSpeller2.getID()) {
            this.log.log(1000000, "AbstractHotSpotProfile#keyTyped(): preparing to change password: %1", (Object)this.passwordSpeller2.getText());
            this.passwordSpeller.setText(this.profile.getKeys()[this.profile.getKeyNumber()]);
            this.updatePasswordSpellerStatus();
            this.passwordSpeller2.fireEvent(n3);
        }
    }

    protected abstract void updateSsidSpellerStatus();

    protected abstract void updatePasswordSpellerStatus();

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    protected void newSsidEntered() {
        this.log.log(1000000, "AbstractHotSpotProfile#newSsidEntered(): new SSID entered: %1", (Object)this.ssidSpeller.getText());
        this.ssidTextfield.setText1(this.ssidSpeller.getText());
        this.ssidSpeller2.setText(this.ssidSpeller.getText());
        this.requestSetProfile();
    }

    protected void newPasswordEntered() {
        this.log.log(1000000, "AbstractHotSpotProfile#newPasswordEntered(): new password entered: %1", (Object)this.passwordSpeller.getText());
        this.passwordTextfield.setText1(this.passwordSpeller.getText());
        this.passwordSpeller2.setText(this.passwordSpeller.getText());
        this.requestSetProfile();
    }

    private void requestSetProfile() {
        Profile profile = new Profile();
        profile.identifier = this.profile.getIdentifier();
        profile.name = this.profile.getName();
        profile.keys = this.getPassword(this.encryption == 2, this.passwordTextfield.getText1());
        profile.keyNumber = 0;
        profile.sSIDBroadcast = this.visibilityChoice.getValue() == 1;
        profile.sSID = this.ssidTextfield.getText1();
        profile.cryptoModel = this.getDSICryptoValue(this.encryption);
        profile.authenticationModel = this.encryption == 2 ? 2 : 1;
        profile.active = this.profile.active;
        profile.channel = this.profile.channel;
        this.log.log(10000000, "AbstractHotSpotProfile#requestSetProfile(): %1", (Object)profile);
        CommandSetProfile.schedule(this.wlanApplication, this.dsiWlan, profile);
    }

    private String[] getPassword(boolean bl, String string) {
        String[] stringArray;
        if (this.isPasswordValid(bl, string)) {
            String[] stringArray2 = new String[1];
            stringArray = stringArray2;
            stringArray2[0] = string;
        } else {
            String[] stringArray3 = new String[1];
            stringArray = stringArray3;
            stringArray3[0] = this.generateRandomPassword(bl ? 13 : 8);
        }
        return stringArray;
    }

    protected boolean isPasswordValid(boolean bl, String string) {
        return bl ? string.length() == 13 : string.length() >= 8 && string.length() <= 63;
    }

    private String generateRandomPassword(int n) {
        Buffer buffer = new Buffer("");
        while (n-- > 0) {
            buffer.append(PASSWORD_CHARS.charAt((int)(Math.random() * (double)PASSWORD_CHARS.length() % (double)PASSWORD_CHARS.length())));
        }
        return buffer.toString();
    }

    public void init() {
        super.init();
        this.ssidSpeller.setSpellerListener(this);
        this.ssidSpeller.setMinLength(1);
        this.ssidSpeller.setMaxLength(32);
        this.ssidSpeller2.setSpellerListener(this);
        this.ssidSpeller2.setMinLength(1);
        this.ssidSpeller2.setMaxLength(32);
        this.ssidTextfield.setButtonListener(this);
        this.passwordSpeller.setSpellerListener(this);
        this.passwordSpeller2.setSpellerListener(this);
        this.passwordTextfield.setButtonListener(this);
        this.visibilityChoice.setChoiceListener(this);
        this.encriptionChoice.setChoiceListener(this);
    }

    public void deinit() {
        this.ssidSpeller.resetListener();
        this.ssidSpeller2.resetListener();
        this.ssidTextfield.resetListener();
        this.passwordSpeller.resetListener();
        this.passwordSpeller2.resetListener();
        this.passwordTextfield.resetListener();
        this.visibilityChoice.resetListener();
        this.encriptionChoice.resetListener();
        super.deinit();
    }
}

