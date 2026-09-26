/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import de.audi.app.data.core.AbstractDataConfigurationComponent;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.profile.APNSpellersHandler;
import de.audi.app.data.core.profile.ApnAvailability;
import de.audi.app.data.core.profile.CommandSetDataProfile;
import de.audi.app.data.core.profile.IDataProfile;
import de.audi.app.data.core.profile.ProfileList;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.networking.CDataProfile;

public abstract class AbstractDataProfile
extends AbstractDataConfigurationComponent
implements IDataProfile,
ButtonListener {
    public static final int PROFILE_INVALID;
    public static final int PROFILE_NA;
    public static final int PROFILE_AVAILABLE;
    public static final int PROFILE_MULTI;
    private static final String WLAN_PROFILE_NAME;
    private static final String UNKNOWN_PROFILE_NAME;
    private static final String UNKNOWN_PROFILE_PROVIDER_NAME;
    private static final String EMPTY;
    private final int[] attributeNotifications = new int[]{1, 2};
    private volatile CDataProfile[] availableProfiles;
    private volatile int activeProfile;
    private volatile CDataProfile profile;
    protected final CDataProfile editProfile = new CDataProfile();
    protected final SpellerModelApp apnSpeller = this.getSpellerModel(606479872);
    protected final SpellerModelApp apnSpeller2 = this.getSpellerModel(-853137920);
    private final ButtonModelApp apnButton = this.getButtonModel(0x26262600);
    protected final TextfieldModelApp apnTextfield = this.getTextfieldModel(623257088);
    protected final SpellerModelApp usernameSpeller = this.getSpellerModel(1025910272);
    protected final SpellerModelApp usernameSpeller2 = this.getSpellerModel(-836360704);
    private final ButtonModelApp usernameButton = this.getButtonModel(1042687488);
    protected final TextfieldModelApp usernameTextfield = this.getTextfieldModel(1009133056);
    protected final SpellerModelApp passwordSpeller = this.getSpellerModel(841360896);
    protected final SpellerModelApp passwordSpeller2 = this.getSpellerModel(-635034112);
    private final ButtonModelApp passwordButton = this.getButtonModel(858138112);
    protected final TextfieldModelApp passwordTextfield = this.getTextfieldModel(-1893325312);
    private final ButtonModelApp applyButton = this.getButtonModel(1210459648);
    protected final SpellerModelApp apn2Speller = this.getSpellerModel(170337792);
    protected final SpellerModelApp apn2Speller2 = this.getSpellerModel(203892224);
    private final ButtonModelApp apn2Button = this.getButtonModel(136783360);
    protected final TextfieldModelApp apn2Textfield = this.getTextfieldModel(220669440);
    protected final SpellerModelApp apn2UsernameSpeller = this.getSpellerModel(120006144);
    protected final SpellerModelApp apn2UsernameSpeller2 = this.getSpellerModel(52897280);
    private final ButtonModelApp apn2UsernameButton = this.getButtonModel(153560576);
    protected final TextfieldModelApp apn2UsernameTextfield = this.getTextfieldModel(36120064);
    protected final SpellerModelApp apn2PasswordSpeller = this.getSpellerModel(237446656);
    protected final SpellerModelApp apn2PasswordSpeller2 = this.getSpellerModel(187115008);
    private final ButtonModelApp apn2PasswordButton = this.getButtonModel(103228928);
    protected final TextfieldModelApp apn2PasswordTextfield = this.getTextfieldModel(69674496);
    private final ButtonModelApp apn2ApplyButton = this.getButtonModel(86451712);
    protected final ChoiceModelApp profileAvailableChoice = this.getChoiceModel(874915328);
    private final ChoiceModelApp setProfileResultChoice = this.getChoiceModel(-467261952);
    private final ChoiceModelApp wlanProfileChoice = this.getChoiceModel(1663444480);
    private final ChoiceModelApp apnAvailabilityChoice = this.getChoiceModel(19342848);
    private final ProfileList profileList = new ProfileList(this, this.getBaseListModel(2099652096));
    protected APNSpellersHandler apn1SpellersHandler;
    protected APNSpellersHandler apn2SpellersHandler;
    private boolean profileIdOk = false;
    private int profileState;

    private static final boolean isUnknownProfile(CDataProfile cDataProfile) {
        return cDataProfile != null && "<empty>".equals(cDataProfile.getDataProfileName()) && "<unknown>".equals(cDataProfile.getProvider());
    }

    private static final boolean isValidProfile(CDataProfile cDataProfile) {
        return cDataProfile != null && cDataProfile.getProvider() != null;
    }

    public AbstractDataProfile(IDataApplication iDataApplication) {
        super(iDataApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    @Override
    public void discardProfileEdits() {
        this.log.log(-2137614336, "AbstractDataProfile#discardProfileEdits(): Profile settings left, resetting to current profile");
        this.setHmiProfile(this.profile);
    }

    @Override
    public void automaticProfileResponse(CDataProfile cDataProfile) {
        this.log.log(-2137614336, "AbstractDataProfile#automaticProfileResponse(): %1", (Object)cDataProfile);
        if (AbstractDataProfile.isValidProfile(cDataProfile)) {
            if (this.activeProfile == 0) {
                if (!AbstractDataProfile.isUnknownProfile(cDataProfile)) {
                    this.setDataProfile(cDataProfile, this.applyButton.getID());
                }
            } else if (AbstractDataProfile.isUnknownProfile(cDataProfile)) {
                cDataProfile.profileID = this.activeProfile;
                this.setDataProfile(cDataProfile, this.applyButton.getID());
            } else {
                this.setDataProfile(cDataProfile, this.applyButton.getID());
            }
        }
    }

    @Override
    public void updateSimState(boolean bl, boolean bl2, boolean bl3) {
        String string = new StringBuffer().append("simState=").append(bl).append(", phoneOn=").append(bl2).append(", unlocked=").append(bl3).append(", profileIdOk=").append(this.profileIdOk).toString();
        this.log.log(1078071040, "AbstractDataProfile#updateSimState(): %1", (Object)string);
        if (bl && bl2 && bl3) {
            if (this.profileIdOk || this.profileState == 2 || this.profileState == 0) {
                this.profileAvailableChoice.setStatus(1);
            } else {
                this.profileAvailableChoice.setStatus(0);
            }
        } else {
            this.profileAvailableChoice.setStatus(1);
        }
    }

    @Override
    public void esimActiveCheckIfisProfileStateAvailable(boolean bl) {
        if (bl && !this.profileIdOk) {
            this.profileAvailableChoice.setStatus(0);
        }
    }

    @Override
    public void updateActiveProfile(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractDataProfile#updateActiveProfile(): activeProfile=%1", (long)n);
        this.activeProfile = n;
        this.profileIdOk = false;
        if (this.availableProfiles != null) {
            for (int i2 = 0; i2 < this.availableProfiles.length; ++i2) {
                CDataProfile cDataProfile = this.availableProfiles[i2];
                if (cDataProfile == null || cDataProfile.getProfileID() != n || AbstractDataProfile.isUnknownProfile(cDataProfile)) continue;
                this.setHmiProfile(this.availableProfiles[i2]);
                this.profileAvailableChoice.setValue(1);
                this.profileAvailableChoice.setStatus(1);
                this.profileIdOk = true;
                break;
            }
        }
        if (!this.profileIdOk) {
            this.log.log(1078071040, "AbstractDataProfile#updateActiveProfile(): Cannot find profile %1 in available profiles or profile is 'unknown'", (long)n);
            if (!AbstractDataProfile.isUnknownProfile(this.profile)) {
                this.clearHmiProfile();
            }
        }
    }

    @Override
    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        if (n != 1) {
            return;
        }
        this.availableProfiles = cDataProfileArray;
        this.log.log(1078071040, "AbstractDataProfile#updateAvailableProfiles(): %1", (Object)Converter.array2String(cDataProfileArray));
        this.profileState = 0;
        if (cDataProfileArray == null || cDataProfileArray.length == 0) {
            this.profileState = -1;
            this.apnAvailabilityChoice.setValue(ApnAvailability.NONE.value);
            this.profileAvailableChoice.setStatus(1);
            this.profileAvailableChoice.setValue(this.profileState);
            this.clearHmiProfile();
        } else {
            if (cDataProfileArray.length > 1) {
                this.profileState = 2;
                this.profileList.updateProfiles(cDataProfileArray);
                this.clearHmiProfile();
                this.apnAvailabilityChoice.setValue(ApnAvailability.NONE.value);
            } else {
                CDataProfile cDataProfile = cDataProfileArray[0];
                if (AbstractDataProfile.isUnknownProfile(cDataProfile)) {
                    this.profileState = 0;
                } else {
                    this.profileState = 1;
                    this.wlanProfileChoice.setValue("WLAN_tethering".equals(cDataProfile.getDataProfileName()) ? 1 : 0);
                }
                this.apnAvailabilityChoice.setValue(ApnAvailability.valueOf((CDataProfile)cDataProfile).value);
                this.setHmiProfile(cDataProfile);
            }
            this.profileAvailableChoice.setValue(this.profileState);
            this.profileAvailableChoice.setStatus(1);
        }
        this.dataApplication.getSimStateListener().updateProfileState(this.profileState);
        this.dataApplication.getOnline().updateProfileState(this.profileState);
    }

    private void clearHmiProfile() {
        this.setHmiProfile(new CDataProfile(0, null, null, null, null, 0, null, true, null, null, null, false));
    }

    private void setHmiProfile(CDataProfile cDataProfile) {
        this.log.log(-2137614336, "AbstractDataProfile#setHmiProfile(): Updating profile: %1", (Object)cDataProfile);
        if (cDataProfile == null) {
            this.log.log(-1601830656, "AbstractDataProfile#setHmiProfile(): profile is null");
            return;
        }
        this.profile = cDataProfile;
        this.editProfile.dataAPN = cDataProfile.dataAPN;
        this.editProfile.dataAPN2 = cDataProfile.dataAPN2;
        this.editProfile.dataAuthentication = cDataProfile.dataAuthentication;
        this.editProfile.dataPassword = cDataProfile.dataPassword;
        this.editProfile.dataPassword2 = cDataProfile.dataPassword2;
        this.editProfile.dataProfileName = cDataProfile.dataProfileName;
        this.editProfile.dataUserName = cDataProfile.dataUserName;
        this.editProfile.dataUserName2 = cDataProfile.dataUserName2;
        this.editProfile.profileID = cDataProfile.profileID;
        this.editProfile.provider = cDataProfile.provider;
        this.editProfile.isAPNvisible = cDataProfile.isAPNvisible;
        this.editProfile.isAPN2visible = cDataProfile.isAPN2visible;
        String string = this.profile.getDataAPN();
        String string2 = this.profile.getDataAPN2();
        this.apnTextfield.setText1(string);
        this.apn2Textfield.setText1(string2);
        String string3 = this.profile.getDataUserName();
        String string4 = this.profile.getDataUserName2();
        this.usernameTextfield.setText1(APNSpellersHandler.stars(string3));
        this.apn2UsernameTextfield.setText1(APNSpellersHandler.stars(string4));
        String string5 = this.profile.getDataPassword();
        String string6 = this.profile.getDataPassword2();
        this.passwordTextfield.setText1(APNSpellersHandler.stars(string5));
        this.apn2PasswordTextfield.setText1(APNSpellersHandler.stars(string6));
        this.apn1SpellersHandler.setupHMIValue(string, string3, string5);
        this.apn2SpellersHandler.setupHMIValue(string2, string4, string6);
    }

    protected void profileSelected(CDataProfile cDataProfile) {
        this.log.log(1078071040, "AbstractDataProfile#profileSelected(): %1", (Object)cDataProfile);
        this.setDataProfile(cDataProfile, this.applyButton.getID());
    }

    private void setDataProfile(CDataProfile cDataProfile, int n) {
        CDataProfile cDataProfile2 = this.validateProfile(cDataProfile);
        this.log.log(1078071040, "AbstractDataProfile#setDataProfile(): %1", (Object)cDataProfile2);
        this.profileAvailableChoice.setStatus(0);
        CommandSetDataProfile.schedule(this.dataApplication, this.dsiDataConfiguration, cDataProfile2, this.profileAvailableChoice, this.apnAvailabilityChoice, this.setProfileResultChoice, n);
    }

    private CDataProfile validateProfile(CDataProfile cDataProfile) {
        if (AbstractDataProfile.isUnknownProfile(cDataProfile)) {
            this.log.log(-2137614336, "AbstractDataProfile#validateProfile(): resetting unkown profile fields");
            cDataProfile.dataProfileName = "";
            cDataProfile.provider = "";
        }
        return cDataProfile;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.apnButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): APN entered: %1", (Object)this.apnSpeller.getText());
            this.editProfile.dataAPN = this.apnSpeller.getText();
            this.apnSpeller2.setText(this.apnSpeller.getText());
            this.apnTextfield.setText1(this.apnSpeller.getText());
            this.apnButton.fireEvent(n3);
        } else if (n == this.apn2Button.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): APN2 entered: %1", (Object)this.apnSpeller.getText());
            this.editProfile.dataAPN2 = this.apn2Speller.getText();
            this.apn2Speller2.setText(this.apn2Speller.getText());
            this.apn2Textfield.setText1(this.apn2Speller.getText());
            this.apn2Button.fireEvent(n3);
        } else if (n == this.usernameButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): User name entered: %1", (Object)this.usernameSpeller.getText());
            this.editProfile.dataUserName = this.usernameSpeller.getText();
            this.usernameSpeller2.setText(APNSpellersHandler.stars(this.usernameSpeller.getText()));
            this.usernameTextfield.setText1(APNSpellersHandler.stars(this.usernameSpeller.getText()));
            this.usernameButton.fireEvent(n3);
        } else if (n == this.apn2UsernameButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): User name APN2 entered: %1", (Object)this.usernameSpeller.getText());
            this.editProfile.dataUserName2 = this.apn2UsernameSpeller.getText();
            this.apn2UsernameSpeller2.setText(APNSpellersHandler.stars(this.apn2UsernameSpeller.getText()));
            this.apn2UsernameTextfield.setText1(APNSpellersHandler.stars(this.apn2UsernameSpeller.getText()));
            this.apn2UsernameButton.fireEvent(n3);
        } else if (n == this.passwordButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): Password entered: %1", (Object)this.passwordSpeller.getText());
            this.editProfile.dataPassword = this.passwordSpeller.getText();
            this.passwordTextfield.setText1(APNSpellersHandler.stars(this.passwordSpeller.getText()));
            this.passwordSpeller2.setText(APNSpellersHandler.stars(this.passwordSpeller.getText()));
            this.passwordButton.fireEvent(n3);
        } else if (n == this.apn2PasswordButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): Password APN2 entered: %1", (Object)this.passwordSpeller.getText());
            this.editProfile.dataPassword2 = this.apn2PasswordSpeller.getText();
            this.apn2PasswordTextfield.setText1(APNSpellersHandler.stars(this.apn2PasswordSpeller.getText()));
            this.apn2PasswordSpeller2.setText(APNSpellersHandler.stars(this.apn2PasswordSpeller.getText()));
            this.apn2PasswordButton.fireEvent(n3);
        } else if (n == this.applyButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): applyButton");
            this.setDataProfile(this.editProfile, this.applyButton.getID());
        } else if (n == this.apn2ApplyButton.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): applyButton APN2");
            this.setDataProfile(this.editProfile, this.apn2ApplyButton.getID());
        } else if (n == this.apnTextfield.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): apnTextfield");
            this.apn1SpellersHandler.onApnTextFieldClick(this.editProfile.getDataAPN());
            this.apnTextfield.fireEvent(n3);
        } else if (n == this.apn2Textfield.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): apn2Textfield");
            this.apn2SpellersHandler.onApnTextFieldClick(this.editProfile.getDataAPN2());
            this.apn2Textfield.fireEvent(n3);
        } else if (n == this.usernameTextfield.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): usernameTextfield");
            this.apn1SpellersHandler.onUsernameTextFieldClick(this.editProfile.getDataUserName());
            this.usernameTextfield.fireEvent(n3);
        } else if (n == this.apn2UsernameTextfield.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): usernameTextfield APN2");
            this.apn2SpellersHandler.onUsernameTextFieldClick(this.editProfile.getDataUserName2());
            this.apn2UsernameTextfield.fireEvent(n3);
        } else if (n == this.passwordTextfield.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): passwordTextfield");
            this.apn1SpellersHandler.onPasswordTextFieldClick(this.editProfile.getDataPassword());
            this.passwordTextfield.fireEvent(n3);
        } else if (n == this.apn2PasswordTextfield.getID()) {
            this.log.log(1078071040, "AbstractDataProfile#keyTyped(): passwordTextfield APN2");
            this.apn2SpellersHandler.onPasswordTextFieldClick(this.editProfile.getDataPassword2());
            this.apn2PasswordTextfield.fireEvent(n3);
        }
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
    public void init() {
        super.init();
        this.apn1SpellersHandler.init();
        this.apn2SpellersHandler.init();
        this.profileAvailableChoice.setValue(-1);
        this.profileAvailableChoice.setStatus(1);
        this.apnButton.setButtonListener(this);
        this.apn2Button.setButtonListener(this);
        this.apnTextfield.setButtonListener(this);
        this.apn2Textfield.setButtonListener(this);
        this.usernameButton.setButtonListener(this);
        this.apn2UsernameButton.setButtonListener(this);
        this.usernameTextfield.setButtonListener(this);
        this.apn2UsernameTextfield.setButtonListener(this);
        this.passwordButton.setButtonListener(this);
        this.apn2PasswordButton.setButtonListener(this);
        this.passwordTextfield.setButtonListener(this);
        this.apn2PasswordTextfield.setButtonListener(this);
        this.applyButton.setButtonListener(this);
        this.apn2ApplyButton.setButtonListener(this);
        this.profileList.init();
    }

    @Override
    public void deinit() {
        this.profileList.deinit();
        this.apn1SpellersHandler.deinit();
        this.apn2SpellersHandler.deinit();
        this.apnButton.resetListener();
        this.apn2Button.resetListener();
        this.apnTextfield.resetListener();
        this.apn2Textfield.resetListener();
        this.usernameButton.resetListener();
        this.apn2UsernameButton.resetListener();
        this.usernameTextfield.resetListener();
        this.apn2UsernameTextfield.resetListener();
        this.passwordButton.resetListener();
        this.apn2PasswordButton.resetListener();
        this.passwordTextfield.resetListener();
        this.apn2PasswordTextfield.resetListener();
        this.applyButton.resetListener();
        this.apn2ApplyButton.resetListener();
        super.deinit();
    }
}

