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
    private static final int PMLIST_COLUMNS = 2;
    private static final int PMLIST_COL_TEXT = 0;
    private static final int PMLIST_COL_SELECTION = 1;
    private static final int PMLIST_LEVEL_COUNT = 9;
    private static final int MIN_PASSWORD_LENGTH = 4;
    private static final int MAX_PASSWORD_LENGTH = 8;
    private static final int MAX_WRONG_PASSWORD_TRIALS = 3;
    private static final int STATE_PW_OK = 0;
    private static final int STATE_PW_WRONG = 1;
    private static final int STATE_PW_BLOCKED = 2;
    private static final int CHANGE_PW_SPELLER_STATE_FIRST = 0;
    private static final int CHANGE_PW_SPELLER_STATE_REPEAT = 1;
    private static final String LOGCLASS = "ParentalManagementController";
    private final BaseListModelApp pmlist;
    private final SpellerModelApp entryPasswordSpeller;
    private final SpellerModelApp changePasswordSpeller;
    private final ChoiceModelApp entryPasswordState;
    private final ChoiceModelApp changePasswordState;
    private final ChoiceModelApp changeSpellerStatus;
    private final ButtonModelApp changeCurrentPasswortButton;
    private final Timer blockedByWrongPasswordTimer = new Timer("BlockedByWrongPasswordTimer", 60000L, true, this);
    private final IMediaDSIBaseController dsiBaseController;
    private int passwordTrialCount = 0;
    private String newPassword;

    public ParentalManagementController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.dsiBaseController = iMediaTerminal.getDSIBaseController();
        this.pmlist = this.getBaseListModel(200148);
        this.entryPasswordSpeller = this.getSpellerModel(201039);
        this.entryPasswordState = this.getChoiceModel(200155);
        this.changePasswordSpeller = this.getSpellerModel(200153);
        this.changePasswordState = this.getChoiceModel(200154);
        this.changeSpellerStatus = this.getChoiceModel(200152);
        this.changeCurrentPasswortButton = this.getButtonModel(200179);
    }

    public void init() {
        this.logger.main().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiBaseController.addParentalManagementListener(this);
        this.pmlist.removeAll();
        this.entryPasswordSpeller.setMinLength(4);
        this.entryPasswordSpeller.setMaxLength(8);
        this.changePasswordSpeller.setMinLength(4);
        this.changePasswordSpeller.setMaxLength(8);
        this.pmlist.setListener(this);
        this.entryPasswordSpeller.setSpellerListener(this);
        this.changePasswordSpeller.setSpellerListener(this);
        this.getButtonModel(200183).setButtonListener(this);
        this.changeCurrentPasswortButton.setButtonListener(this);
        this.getButtonModel(200851).setButtonListener(this);
        this.getButtonModel(200852).setButtonListener(this);
        this.prefillPMList();
        int n = this.getPMLevel();
        this.updateActiveEntry(n);
        this.getChoiceModel(200150).setValue(n);
    }

    public void deinit() {
        this.logger.main().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.pmlist.setListener(null);
        this.entryPasswordSpeller.setSpellerListener(null);
        this.changePasswordSpeller.setSpellerListener(null);
        this.getButtonModel(200183).setButtonListener(null);
        this.changeCurrentPasswortButton.setButtonListener(null);
        this.getButtonModel(200851).setButtonListener(null);
        this.getButtonModel(200852).setButtonListener(null);
        this.dsiBaseController.removeParentalManagementListener(this);
    }

    protected int getCheckboxColumn() {
        return 1;
    }

    protected BaseListModelApp getListModel() {
        return this.pmlist;
    }

    protected void entrySelected(int n) {
        EvoListRow evoListRow = this.pmlist.getRow(n);
        this.dsiBaseController.setParentalML(evoListRow.getInteger(0));
    }

    public void updateParentalML(int n) {
        this.logger.hmi().log(1000000, "[%1.updateParentalML] '%2'", (Object)LOGCLASS, (long)n);
        if (n < 0 || n > 8) {
            this.logger.dsi().log(100000, "[%1.updateParentalML] unsupported pmLevel '%2', ignoring.", (Object)LOGCLASS, (long)n);
        }
        this.updateActiveEntry(n);
        this.getChoiceModel(200150).setValue(n);
        this.setPMLevel(n);
        this.pmlist.fireEvent(this.getTerminal().getTerminalID());
    }

    private void pmlSettingsSelected() {
        this.logger.hmi().log(1000000, "[%1.enterPMLSettings] entered.", (Object)LOGCLASS);
        this.entryPasswordSpeller.clear();
        this.getChoiceModel(200849).setValue(0);
        this.getButtonModel(200183).fireEvent(this.getTerminal().getTerminalID());
    }

    private void entrySpellerSelected() {
        this.logger.hmi().log(1000000, "[%1.entrySpellerSelected] entered.", (Object)LOGCLASS);
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
        this.getChoiceModel(200849).setValue(0);
    }

    private void changingPasswordSelected() {
        this.logger.hmi().log(1000000, "[%1.changingPasswordSelected] entered.", (Object)LOGCLASS);
        this.changeSpellerStatus.setValue(0);
        this.changeCurrentPasswortButton.fireEvent(this.getTerminal().getTerminalID());
        this.changePasswordSpeller.clear();
        this.getChoiceModel(200849).setValue(0);
    }

    private void changeSpellerSelected() {
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelected] entered.", (Object)LOGCLASS);
        this.newPassword = this.changePasswordSpeller.getText();
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelected] new password is '%2'.", (Object)LOGCLASS, (Object)this.newPassword);
        this.changeSpellerStatus.setValue(1);
        this.changePasswordSpeller.fireEvent(this.getTerminal().getTerminalID());
        this.changePasswordSpeller.clear();
        this.getChoiceModel(200849).setValue(0);
    }

    private void repeatChangeSpellerSelected() {
        this.logger.hmi().log(1000000, "[%1.repeatChangeSpellerSelected] entered.", (Object)LOGCLASS);
        String string = this.changePasswordSpeller.getText();
        this.logger.hmi().log(1000000, "[%1.changeSpellerSelected] repeated password is '%2'.", (Object)LOGCLASS, (Object)string);
        if (this.newPassword.equals(string)) {
            this.changePasswordState.setValue(0);
            this.setPassword(this.newPassword);
        } else {
            this.changePasswordState.setValue(1);
        }
        this.changeSpellerStatus.setValue(0);
        this.changePasswordSpeller.fireEvent(this.getTerminal().getTerminalID());
        this.changePasswordSpeller.clear();
        this.getChoiceModel(200849).setValue(0);
    }

    private String getPassword() {
        String string = this.getTerminal().getMediaPersistence().getGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD");
        this.logger.main().log(1000000, "[%1.getPassword] getting current password from persistence: '%2'.", (Object)LOGCLASS, (Object)string);
        if (string == null) {
            string = "1234";
            this.logger.main().log(1000000, "[%1.getPassword] got null from persistence, using default value: '%2'.", (Object)LOGCLASS, (Object)string);
        }
        return string;
    }

    private void setPassword(String string) {
        this.logger.main().log(1000000, "[%1.setPassword] storing new password in persistence.", (Object)LOGCLASS);
        this.getTerminal().getMediaPersistence().setGlobalStringProperty("GLOBAL_KEY_DVDV_PM_PASSWORD", string);
    }

    private int getPMLevel() {
        int n = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL");
        this.logger.main().log(1000000, "[%1.getPMLevel] getting current pm-level from persistence: '%2'.", (Object)LOGCLASS, (long)n);
        return n;
    }

    private void setPMLevel(int n) {
        this.logger.main().log(1000000, "[%1.setPMLevel] storing new pm level ('%2') in persistence.", (Object)LOGCLASS, (long)n);
        this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_DVDV_PM_LEVEL", n);
    }

    public void fireTimer(Timer timer) {
        this.entryPasswordState.setValue(0);
        this.passwordTrialCount = 0;
    }

    public void cancelTimer(Timer timer) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logger.hmi().log(1000000, "[%1.textChanged] '%2'", (Object)LOGCLASS, (Object)string);
        this.getSpellerModel(n).setText(string);
        if (null != string && string.length() >= 4) {
            this.getChoiceModel(200849).setValue(1);
        } else {
            this.getChoiceModel(200849).setValue(0);
        }
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logger.hmi().log(1000000, "[%1.keyPressed] modelID '%2'.", (Object)LOGCLASS, (long)n);
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
                this.logger.hmi().log(100000, "[%1.keyPressed] unsupported modelID.");
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logger.hmi().log(1000000, "[%1.KeyTyped] '%2'", (Object)LOGCLASS);
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
                this.logger.hmi().log(100000, "[%1.textChanged] unsupported modelID.");
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

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

