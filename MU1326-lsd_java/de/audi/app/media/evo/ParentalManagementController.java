/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo;

import de.audi.app.media.AbstractSettingsList;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;

public class ParentalManagementController
extends AbstractSettingsList
implements ButtonListener,
SpellerListener,
TimerListener,
IMediaParentalManagementListener {
    private static final int PMLIST_COLUMNS;
    private static final int PMLIST_COL_TEXT;
    private static final int PMLIST_COL_SELECTION;
    private static final int PMLIST_LEVEL_COUNT;
    private static final int MIN_PASSWORD_LENGTH;
    private static final int MAX_PASSWORD_LENGTH;
    private static final int MAX_WRONG_PASSWORD_TRIALS;
    private static final int STATE_PW_OK;
    private static final int STATE_PW_WRONG;
    private static final int STATE_PW_BLOCKED;
    private static final int CHANGE_PW_SPELLER_STATE_FIRST;
    private static final int CHANGE_PW_SPELLER_STATE_REPEAT;
    private static final String LOGCLASS;
    private final BaseListModelApp pmlist;
    private final SpellerModelApp entryPasswordSpeller;
    private final SpellerModelApp changePasswordSpeller;
    private final ChoiceModelApp entryPasswordState;
    private final ChoiceModelApp changePasswordState;
    private final ChoiceModelApp changeSpellerStatus;
    private final ButtonModelApp changeCurrentPasswortButton;
    private final Timer blockedByWrongPasswordTimer = new Timer("BlockedByWrongPasswordTimer", 0, true, this);
    private final IMediaDSIBaseController dsiBaseController;
    private int passwordTrialCount = 0;
    private String newPassword;

    public ParentalManagementController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.dsiBaseController = iMediaTerminal.getDSIBaseController();
        this.pmlist = this.getBaseListModel(-737344768);
        this.entryPasswordSpeller = this.getSpellerModel(1326514944);
        this.entryPasswordState = this.getChoiceModel(-619904256);
        this.changePasswordSpeller = this.getSpellerModel(-653458688);
        this.changePasswordState = this.getChoiceModel(-636681472);
        this.changeSpellerStatus = this.getChoiceModel(-670235904);
        this.changeCurrentPasswortButton = this.getButtonModel(-217251072);
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"ParentalManagementController");
        this.dsiBaseController.addParentalManagementListener(this);
        this.pmlist.removeAll();
        this.entryPasswordSpeller.setMinLength(4);
        this.entryPasswordSpeller.setMaxLength(8);
        this.changePasswordSpeller.setMinLength(4);
        this.changePasswordSpeller.setMaxLength(8);
        this.pmlist.setListener(this);
        this.entryPasswordSpeller.setSpellerListener(this);
        this.changePasswordSpeller.setSpellerListener(this);
        this.getButtonModel(-150142208).setButtonListener(this);
        this.changeCurrentPasswortButton.setButtonListener(this);
        this.getButtonModel(-1827667200).setButtonListener(this);
        this.getButtonModel(-1810889984).setButtonListener(this);
        this.prefillPMList();
        int n = this.getPMLevel();
        this.updateActiveEntry(n);
        this.getChoiceModel(-703790336).setValue(n);
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"ParentalManagementController");
        this.pmlist.setListener(null);
        this.entryPasswordSpeller.setSpellerListener(null);
        this.changePasswordSpeller.setSpellerListener(null);
        this.getButtonModel(-150142208).setButtonListener(null);
        this.changeCurrentPasswortButton.setButtonListener(null);
        this.getButtonModel(-1827667200).setButtonListener(null);
        this.getButtonModel(-1810889984).setButtonListener(null);
        this.dsiBaseController.removeParentalManagementListener(this);
    }

    @Override
    protected int getCheckboxColumn() {
        return 1;
    }

    @Override
    protected BaseListModelApp getListModel() {
        return this.pmlist;
    }

    @Override
    protected void entrySelected(int n) {
        EvoListRow evoListRow = this.pmlist.getRow(n);
        this.dsiBaseController.setParentalML(evoListRow.getInteger(0));
    }

    @Override
    public void updateParentalML(int n) {
        this.logger.hmi().log(1078071040, "[%1.updateParentalML] '%2'", (Object)"ParentalManagementController", (long)n);
        if (n < 0 || n > 8) {
            this.logger.dsi().log(-1601830656, "[%1.updateParentalML] unsupported pmLevel '%2', ignoring.", (Object)"ParentalManagementController", (long)n);
        }
        this.updateActiveEntry(n);
        this.getChoiceModel(-703790336).setValue(n);
        this.setPMLevel(n);
        this.pmlist.fireEvent(this.getTerminal().getTerminalID());
    }

    private void pmlSettingsSelected() {
        this.logger.hmi().log(1078071040, "[%1.enterPMLSettings] entered.", (Object)"ParentalManagementController");
        this.entryPasswordSpeller.clear();
        this.getChoiceModel(-1861221632).setValue(0);
        this.getButtonModel(-150142208).fireEvent(this.getTerminal().getTerminalID());
    }

    private void entrySpellerSelected() {
        this.logger.hmi().log(1078071040, "[%1.entrySpellerSelected] entered.", (Object)"ParentalManagementController");
        String string = this.entryPasswordSpeller.getText();
        if (string.equals(this.getPassword())) {
            this.passwordTrialCount = 0;
            this.entryPasswordState.setValue(0);
        } else {
            ++this.passwordTrialCount;
            if (this.passwordTrialCount >= 3) {
                this.entryPasswordState.setValue(2);
                this.blockedByWrongPasswordTimer.start();
            } else {
                this.entryPasswordState.setValue(1);
            }
        }
        this.entryPasswordSpeller.fireEvent(this.getTerminal().getTerminalID());
        this.entryPasswordSpeller.clear();
        this.getChoiceModel(-1861221632).setValue(0);
    }

    private void changingPasswordSelected() {
        this.logger.hmi().log(1078071040, "[%1.changingPasswordSelected] entered.", (Object)"ParentalManagementController");
        this.changeSpellerStatus.setValue(0);
        this.changeCurrentPasswortButton.fireEvent(this.getTerminal().getTerminalID());
        this.changePasswordSpeller.clear();
        this.getChoiceModel(-1861221632).setValue(0);
    }

    private void changeSpellerSelected() {
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelected] entered.", (Object)"ParentalManagementController");
        this.newPassword = this.changePasswordSpeller.getText();
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelected] new password is '%2'.", (Object)"ParentalManagementController", (Object)this.newPassword);
        this.changeSpellerStatus.setValue(1);
        this.changePasswordSpeller.fireEvent(this.getTerminal().getTerminalID());
        this.changePasswordSpeller.clear();
        this.getChoiceModel(-1861221632).setValue(0);
    }

    private void repeatChangeSpellerSelected() {
        this.logger.hmi().log(1078071040, "[%1.repeatChangeSpellerSelected] entered.", (Object)"ParentalManagementController");
        String string = this.changePasswordSpeller.getText();
        this.logger.hmi().log(1078071040, "[%1.changeSpellerSelected] repeated password is '%2'.", (Object)"ParentalManagementController", (Object)string);
        if (this.newPassword.equals(string)) {
            this.changePasswordState.setValue(0);
            this.setPassword(this.newPassword);
        } else {
            this.changePasswordState.setValue(1);
        }
        this.changeSpellerStatus.setValue(0);
        this.changePasswordSpeller.fireEvent(this.getTerminal().getTerminalID());
        this.changePasswordSpeller.clear();
        this.getChoiceModel(-1861221632).setValue(0);
    }

    private String getPassword() {
        String string = this.getTerminal().getMediaPersistence().getGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD");
        this.logger.main().log(1078071040, "[%1.getPassword] getting current password from persistence: '%2'.", (Object)"ParentalManagementController", (Object)string);
        if (string == null) {
            string = "1234";
            this.logger.main().log(1078071040, "[%1.getPassword] got null from persistence, using default value: '%2'.", (Object)"ParentalManagementController", (Object)string);
        }
        return string;
    }

    private void setPassword(String string) {
        this.logger.main().log(1078071040, "[%1.setPassword] storing new password in persistence.", (Object)"ParentalManagementController");
        this.getTerminal().getMediaPersistence().setGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", string);
    }

    private int getPMLevel() {
        int n = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL");
        this.logger.main().log(1078071040, "[%1.getPMLevel] getting current pm-level from persistence: '%2'.", (Object)"ParentalManagementController", (long)n);
        return n;
    }

    private void setPMLevel(int n) {
        this.logger.main().log(1078071040, "[%1.setPMLevel] storing new pm level ('%2') in persistence.", (Object)"ParentalManagementController", (long)n);
        this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL", n);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.entryPasswordState.setValue(0);
        this.passwordTrialCount = 0;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logger.hmi().log(1078071040, "[%1.textChanged] '%2'", (Object)"ParentalManagementController", (Object)string);
        this.getSpellerModel(n).setText(string);
        if (null != string && string.length() >= 4) {
            this.getChoiceModel(-1861221632).setValue(1);
        } else {
            this.getChoiceModel(-1861221632).setValue(0);
        }
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logger.hmi().log(1078071040, "[%1.keyPressed] modelID '%2'.", (Object)"ParentalManagementController", (long)n);
        switch (n) {
            case 200183: {
                this.pmlSettingsSelected();
                break;
            }
            case 200179: {
                this.changingPasswordSelected();
                break;
            }
            default: {
                this.logger.hmi().log(-1601830656, "[%1.keyPressed] unsupported modelID.");
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logger.hmi().log(1078071040, "[%1.KeyTyped] '%2'", (Object)"ParentalManagementController");
        switch (n) {
            case 200852: 
            case 201039: {
                this.entrySpellerSelected();
                break;
            }
            case 200153: 
            case 200851: {
                if (this.changeSpellerStatus.getValue() == 0) {
                    this.changeSpellerSelected();
                    break;
                }
                this.repeatChangeSpellerSelected();
                break;
            }
            default: {
                this.logger.hmi().log(-1601830656, "[%1.textChanged] unsupported modelID.");
            }
        }
    }

    private void prefillPMList() {
        BaseListModelApp baseListModelApp = this.pmlist.getCopy();
        baseListModelApp.setLength(9);
        for (int i2 = 0; i2 < 9; ++i2) {
            baseListModelApp.setRow(i2, this.createRow(i2));
        }
        this.pmlist.update(baseListModelApp);
    }

    private EvoListRow createRow(int n) {
        EvoListRow evoListRow = new EvoListRow(n, 2);
        evoListRow.setInteger(0, n);
        evoListRow.setInteger(1, 0);
        return evoListRow;
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("ParentalManagementController").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

