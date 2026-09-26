/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.etc.AbstractETCPopupManager;
import de.audi.app.settings.etc.AbstractETCTextFactory;
import de.audi.app.settings.etc.ETCHandler$1;
import de.audi.app.settings.etc.ETCModels;
import de.audi.app.settings.etc.ETCPaymentHistoryListItem;
import de.audi.app.settings.etc.ETCPaymentHistoryListItem$PaymentListRow;
import de.audi.app.settings.etc.ETCSettings;
import de.audi.app.settings.etc.ETCTTSHandler;
import de.audi.app.settings.etc.PaymentFormatter;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.DSITollCollect;
import org.dsi.ifc.tollcollect.DSITollCollectListener;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public class ETCHandler
implements ButtonListener,
BaseListModelListener,
TimerListener,
PowerEventListener,
DSITollCollectListener,
MsgListener {
    private final int[] etcAttributes = new int[]{1, 2, 3, 4, 5};
    public static final int NO_CARD_INSERTED_TIMEOUT;
    private static final int ETC_STATE_CARD_IS_INSERTED;
    private static final int ETC_STATE_CARD_IS_REGISTERED;
    private static final int ETC_STATE_CARD_IS_NOT_INSERTED;
    private static final int ETC_STATE_CARD_IS_ACCESSED;
    private static final int ETC_STATE_CARD_IS_REGISTERED_YET;
    private static final int ETC_STATE_CARD_IS_DEFECT;
    private static final int ETC_STATE_SYSTEM_FAILURE;
    private static final int ETC_STATE_SYSTEM_UNSETUP;
    public static final int ERROR_POPUP_TYPE_UNDEFINED;
    public static final int ERROR_POPUP_TYPE_UNSETUP;
    public static final int ERROR_POPUP_TYPE_DSRCERR;
    public static final int ERROR_POPUP_TYPE_CARD_ERROR;
    public static final int ERROR_POPUP_TYPE_CARD_NONINSERT;
    public static final int ERROR_POPUP_TYPE_SYSTEM;
    public static final int ERROR_POPUP_TYPE_CARD_EXPIRED;
    public static final int ERROR_POPUP_TYPE_COMMUNICATION;
    public static final int ERROR_POPUP_TYPE_CARD_WRITE;
    public static final int ERROR_POPUP_TYPE_CARD_CHECK;
    public static final int ERROR_POPUP_TYPE_CARD_READ;
    public static final int PASS_GATE_ERROR_POPUP_TYPE_GATE_NOT_PASSABLE;
    public static final int PASS_GATE_ERROR_POPUP_TYPE_GATE_NOT_USABLE;
    public static final int PASS_GATE_ERROR_POPUP_TYPE_DANGER_GATE_NOT_USABLE;
    private final int[] errorCode2PopupTypeMapping = new int[]{-1, -1, 0, 1, 2, 3, 9, 7, 6, 11, 12, 5, 4, 4, 0};
    private static final int TOLL_OVER_AMOUNT;
    private static final int PASS_GATE_POPUP_TYPE_TOLL;
    private static final int PASS_GATE_POPUP_TYPE_TOLL_OVER;
    private static final int PASS_GATE_POPUP_TYPE_TOLL_REFUND;
    private static final int PASS_GATE_POPUP_TYPE_TOLL_REFUND_OVER;
    public static final int PAYMENT_HISTORY_LIST_COLUMN_COUNT_EVO;
    public static final int PAYMENT_HISTORY_LIST_COLUMN_COUNT_PORSCHE;
    private static final String CLASSNAME;
    private final SettingsEnv env;
    private final LogChannel log;
    private final ETCModels etcModels;
    private final ETCSettings etcSettings;
    private final ArrayList paymentInfoList;
    private final BaseListModelApp historyList;
    private final ETCTTSHandler ttsHandler;
    private Timer cardPickUpReminder = null;
    private boolean isCardInserted = false;
    private DSITollCollect dsi = null;
    private AbstractETCPopupManager popupManager;
    private volatile boolean isCardReaderPresent = false;
    private volatile boolean isClamp15ON = false;
    private volatile boolean isWaitingForPaymentHistoryList = false;
    private int paymentHistoryListColumnCount;
    private volatile boolean isPaymentHistoryEntered = false;

    public ETCHandler(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.log = settingsEnv.getFw().getLogChannel("App.Settings.ETC");
        this.etcModels = new ETCModels(settingsEnv);
        this.etcSettings = new ETCSettings(settingsEnv, this.etcModels, this.log);
        this.ttsHandler = new ETCTTSHandler(this.log);
        this.historyList = this.getETCModels().getETCPaymentHistoryList();
        this.paymentInfoList = new ArrayList(100);
        this.initModels();
    }

    private final void initModels() {
        this.getETCModels().getETCHardwareInformationButton().setButtonListener(this);
        this.getETCModels().getETCPaymentHistoryButton().setButtonListener(this);
        this.getETCModels().getETCSettingsButton().setButtonListener(this);
        this.historyList.setListener(this);
        this.getETCModels().getETCHardwareInformationButton().setStatus(0);
        this.setPaymentListState(false);
        this.getETCModels().getETCStatusChoice().setValue(2);
        this.getETCModels().getETCIconChoiceModel().setValue(0);
    }

    public final void setTextFactory(AbstractETCTextFactory abstractETCTextFactory) {
        this.ttsHandler.setTextFactory(abstractETCTextFactory);
    }

    public final void setPopupManager(AbstractETCPopupManager abstractETCPopupManager) {
        this.log.log(-2137614336, "%1 setPopupManager(%2)", (Object)"[ETCHandler]", (Object)abstractETCPopupManager);
        this.popupManager = abstractETCPopupManager;
        if (this.dsi != null) {
            this.dsi.setNotification(this.etcAttributes, (DSIListener)this);
        }
        if (this.isClamp15ON) {
            if (this.cardPickUpReminder != null) {
                this.cardPickUpReminder.cancel();
            }
            this.startCardReminder(true);
        }
    }

    private void startCardReminder(boolean bl) {
        long l = this.env.getETCCardRemiderTimeout();
        if (bl) {
            l -= this.env.getFw().getMonotonicTime();
        }
        this.log.log(1078071040, "%1 startCardReminder(): delay=%2 msec", (Object)"[ETCHandler]", l);
        if (l > 0L) {
            this.cardPickUpReminder = new Timer("ETC no card inserted", l, true, this);
            this.cardPickUpReminder.start();
        } else if (!this.isCardInserted) {
            this.showNoCardInsertedPopup();
        }
    }

    private final ETCModels getETCModels() {
        return this.etcModels;
    }

    private final ETCSettings getETCSettings() {
        return this.etcSettings;
    }

    public ETCTTSHandler getTTSHandler() {
        return this.ttsHandler;
    }

    public final void setDSI(DSITollCollect dSITollCollect) {
        this.dsi = dSITollCollect;
        if (dSITollCollect != null) {
            if (this.popupManager != null) {
                this.dsi.setNotification(this.etcAttributes, (DSIListener)this);
            }
        } else if (this.isWaitingForPaymentHistoryList) {
            this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
        }
    }

    public final void cleanup() {
        this.getETCModels().getETCHardwareInformationButton().setButtonListener(null);
        this.getETCModels().getETCPaymentHistoryButton().setButtonListener(null);
        this.getETCModels().getETCSettingsButton().setButtonListener(null);
        this.historyList.resetListener();
        if (this.cardPickUpReminder != null) {
            this.cardPickUpReminder.cancel();
        }
        this.dsi.clearNotification(this.etcAttributes, (DSIListener)this);
        this.dsi = null;
        this.getPaymentInfoList().clear();
    }

    private ArrayList getPaymentInfoList() {
        return this.paymentInfoList;
    }

    private TCPaymentInfo getETCPaymentHistoryItemByID(int n) {
        Iterator iterator = this.getPaymentInfoList().iterator();
        while (iterator.hasNext()) {
            TCPaymentInfo tCPaymentInfo = (TCPaymentInfo)iterator.next();
            if (n != tCPaymentInfo.getPaymentInfoID()) continue;
            return tCPaymentInfo;
        }
        return null;
    }

    private void showETCWarningPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCWarningPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 showETCWarningPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void showETCCardIStillInsertedReminderPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCCardIStillInsertedReminderPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 showETCCardIStillInsertedReminderPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void showETCTollAmountPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCTollAmountPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 showETCTollAmountPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void showETCNoCardInsertedReminderPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCNoCardInsertedReminderPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 showETCNoCardInsertedReminderPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void hideETCNoCardInsertedReminderPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.hideETCNoCardInsertedReminderPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 hideETCNoCardInsertedReminderPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void hideETCWarningPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.hideETCWarningPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 hideETCWarningPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void hideETCTollAmountPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.hideETCTollAmountPartialPopup();
        } else {
            this.log.log(-1601830656, "%1 hideETCTollAmountPartialPopup( ): popup manager is not available", (Object)"[ETCHandler]");
        }
    }

    private void showETCIsAvailableIcon(boolean bl) {
        this.log.log(-2137614336, "%1 showETCIsAvailableIcon(%2)", (Object)"[ETCHandler]", (Object)Boolean.toString(bl));
        if (bl) {
            this.getETCModels().getETCIconChoiceModel().setValue(1);
        } else {
            this.getETCModels().getETCIconChoiceModel().setValue(2);
        }
    }

    private void setCardInserted(boolean bl) {
        this.log.log(-2137614336, "%1 setCardInserted(%2)", (Object)"[ETCHandler]", (Object)Boolean.toString(bl));
        if (bl) {
            if (!this.isCardInserted) {
                this.hideETCNoCardInsertedReminderPartialPopup();
                if (this.isPaymentHistoryEntered) {
                    this.doRequestPaymentHistory(0);
                }
                this.setPaymentListState(true);
            }
        } else {
            this.setPaymentListState(false);
            this.historyList.removeAll();
            this.getPaymentInfoList().clear();
        }
        this.isCardInserted = bl;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "%1 asyncException( errorCode=%2): %3", (Object)"[ETCHandler]", (Object)Integer.toString(n), (Object)string);
        if (this.isWaitingForPaymentHistoryList) {
            this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
        }
    }

    private void setPaymentListState(boolean bl) {
        this.log.log(-2137614336, "%1 setPaymentListState( isEnabled=%2)", (Object)"[ETCHandler]", (Object)Boolean.toString(bl));
        this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setValue(bl ? 1 : 0);
    }

    public void enterETCSettings() {
        this.log.log(1078071040, "%1 enterETCSettings()", (Object)"[ETCHandler]");
    }

    public void enterETCPaymentHistory() {
        this.log.log(-2137614336, "%1 enterETCPaymentHistory()", (Object)"[ETCHandler]");
        this.isPaymentHistoryEntered = true;
    }

    public void leaveETCPaymentHistory() {
        this.log.log(-2137614336, "%1 leaveETCPaymentHistory()", (Object)"[ETCHandler]");
        this.isPaymentHistoryEntered = false;
    }

    private boolean isPaymentHistoryEntered() {
        return this.isPaymentHistoryEntered;
    }

    @Override
    public void updateCardState(int n, int n2) {
        this.log.log(1078071040, "%1 updateCardState( cardState=%2)", (Object)"[ETCHandler]", (long)n);
        if (1 == n2) {
            switch (n) {
                case 0: {
                    if (2 == this.getETCModels().getETCStatusChoice().getValue()) {
                        this.getETCModels().getETCStatusChoice().setValue(3);
                    }
                    this.showETCIsAvailableIcon(false);
                    break;
                }
                case 2: 
                case 4: {
                    this.getETCModels().getETCStatusChoice().setValue(1);
                    this.setCardInserted(true);
                    this.showETCIsAvailableIcon(true);
                    break;
                }
                case 3: {
                    this.getETCModels().getETCStatusChoice().setValue(5);
                    this.showETCIsAvailableIcon(false);
                    break;
                }
                case 1: {
                    this.getETCModels().getETCStatusChoice().setValue(2);
                    this.setCardInserted(false);
                    this.showETCIsAvailableIcon(false);
                    this.isWaitingForPaymentHistoryList = false;
                    this.setPaymentListState(false);
                    break;
                }
                default: {
                    this.log.log(10000, "%1 updateCardState(): unknown error code %2", (Object)"[ETCHandler]", (long)n);
                    break;
                }
            }
        } else {
            this.log.log(-2137614336, "ETCHandler.updateCardState: validFlag = %1, skip this card state %2 update!", (long)n2, (long)n);
        }
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void updateCardError(TCCardError var1_1, int var2_2) {
        block15: {
            block14: {
                this.log.log(1078071040, "ETCHandler#updateCardError(%1, %2)", (Object)var1_1, (long)var2_2);
                if (1 != var2_2) break block14;
                if (var1_1 == null) ** GOTO lbl53
                var3_3 = var1_1.getCardError();
                var4_4 = var1_1.getErrorCode();
                if (var4_4 == null) {
                    this.log.log(14808325, "%1 updateCardError(): undefined error code", (Object)"[ETCHandler]");
                    var4_4 = "";
                }
                if (var3_3 >= 0 && var3_3 < this.errorCode2PopupTypeMapping.length) {
                    var5_5 = this.errorCode2PopupTypeMapping[var3_3];
                    if (var5_5 == -1) {
                        if (var3_3 == 1) {
                            this.log.log(-2137614336, "%1 updateCardError(): undefined popup type, errorId=%2 (=NO_ERROR)", (Object)"[ETCHandler]", (long)var3_3);
                        } else {
                            this.log.log(10000, "%1 updateCardError(): undefined popup type, errorId=%2", (Object)"[ETCHandler]", (long)var3_3);
                        }
                        if (1 != var3_3 && 0 != var3_3) {
                            this.ttsHandler.speakErrorMessage(var3_3);
                        }
                        return;
                    }
                    this.hideETCWarningPartialPopup();
                    this.getETCModels().getETCErrorPopupTypeChoice().setValue(var5_5);
                    switch (var3_3) {
                        case 2: {
                            this.getETCModels().getETCStatusChoice().setValue(4);
                            break;
                        }
                        case 4: {
                            this.getETCModels().getETCStatusChoice().setValue(5);
                            break;
                        }
                        case 3: 
                        case 13: {
                            this.getETCModels().getETCStatusChoice().setValue(6);
                            break;
                        }
                        case 11: {
                            this.getETCModels().getETCStatusChoice().setValue(0);
                            this.setCardInserted(true);
                            break;
                        }
                        case 14: {
                            this.getETCModels().getETCStatusChoice().setValue(7);
                            break;
                        }
                        default: {
                            this.log.log(14808325, "%1 updateCardError(): card error does not change the card state: %2", (Object)"[ETCHandler]", (long)var3_3);
                        }
                    }
                    this.showETCIsAvailableIcon(var3_3 == 1);
                    this.setCardInserted(this.isCardErrorIndicatingCardInserted(var3_3));
                    this.getETCModels().getETCErrorCodeLabel().setText(var4_4);
                    this.showETCWarningPartialPopup();
                    this.ttsHandler.speakErrorMessage(var3_3);
                } else {
                    this.log.log(10000, "%1 updateCardError(): unsupported card error: id=%2 code=%3", (Object)"[ETCHandler]", (Object)Integer.toString(var3_3), (Object)var4_4);
                    return;
lbl53:
                    // 1 sources

                    this.log.log(10000, "%1 updateCardError(): card error is null, ignore this", (Object)"[ETCHandler]");
                }
                break block15;
            }
            this.log.log(-2137614336, "%1 updateCardError: validFlag = %2, do nothing!", (Object)"[ETCHandler]", (long)var2_2);
        }
    }

    private boolean isCardErrorIndicatingCardInserted(int n) {
        boolean bl;
        switch (n) {
            case 5: 
            case 14: {
                bl = false;
                break;
            }
            default: {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public void updateCardDateInformation(TCCardDateInformation tCCardDateInformation, int n) {
        this.log.log(1078071040, "%1 updateCardDateInformation(): %2", (Object)"[ETCHandler]", (Object)(1 == n ? "valid" : "invalid"));
    }

    @Override
    public void updateHardwareInformation(TCHardwareInformation[] tCHardwareInformationArray, int n) {
        this.log.log(1078071040, "%1 updateHardwareInformation(): %2", (Object)"[ETCHandler]", (Object)(tCHardwareInformationArray != null ? Arrays.asList(tCHardwareInformationArray) : null));
        if (1 == n) {
            this.getETCModels().getETCHardwareInformationButton().setStatus(1);
            if (tCHardwareInformationArray != null && tCHardwareInformationArray.length > 0) {
                this.isCardReaderPresent = true;
                block7: for (int i2 = 0; i2 < tCHardwareInformationArray.length; ++i2) {
                    switch (tCHardwareInformationArray[i2].getKey()) {
                        case 0: {
                            this.getETCModels().getETCHardwareTypeApprovalModelNameLabel().setText(tCHardwareInformationArray[i2].getValue());
                            continue block7;
                        }
                        case 1: {
                            this.getETCModels().getETCHardwareManufacturerNameLabel().setText(tCHardwareInformationArray[i2].getValue());
                            continue block7;
                        }
                        case 2: {
                            this.getETCModels().getETCHardwareIDNumberLabel().setText(tCHardwareInformationArray[i2].getValue());
                            continue block7;
                        }
                        case 3: {
                            this.getETCModels().getETCHardwareModelNameLabel().setText(tCHardwareInformationArray[i2].getValue());
                            continue block7;
                        }
                        case 4: {
                            this.getETCModels().getETCHardwareSerialNumberLabel().setText(tCHardwareInformationArray[i2].getValue());
                            continue block7;
                        }
                        default: {
                            this.log.log(10000, "%1 updateHardwareInformation(): unknown hardware key %2", (Object)"[ETCHandler]", (long)tCHardwareInformationArray[i2].getKey());
                        }
                    }
                }
            } else {
                this.isCardReaderPresent = false;
                this.log.log(10000, "%1 updateHardwareInformation(): invalid hardware information", (Object)"[ETCHandler]");
            }
        } else {
            this.log.log(-2137614336, "%1 updateHardwareInformation: validFlag = %2, skip this update!", (Object)"[ETCHandler]", (long)n);
        }
    }

    @Override
    public void updateCurrentTollPayment(NavPriceInfo navPriceInfo, int n) {
        this.log.log(1078071040, "%1 updateCurrentTollPayment(): %2 %3", (Object)"[ETCHandler]", (Object)navPriceInfo, (Object)(n == 1 ? "valid" : "invalid"));
        if (1 == n) {
            PaymentFormatter paymentFormatter = new PaymentFormatter(navPriceInfo, this.env, this.log);
            int n2 = navPriceInfo.getAmount() / 1000;
            boolean bl = false;
            if (n2 < 0) {
                bl = true;
                n2 *= -1;
            }
            if (this.getETCSettings().isAmountNoticeOn()) {
                this.hideETCTollAmountPartialPopup();
                if (n2 > -1601830656) {
                    this.getETCModels().getPopupPassGateChoice().setValue(bl ? 3 : 1);
                } else {
                    this.getETCModels().getPopupPassGateChoice().setValue(bl ? 2 : 0);
                }
                this.getETCModels().getPopupPassGateFeeLabel().setText(paymentFormatter.getAmountCurrencyString());
                this.showETCTollAmountPartialPopup();
            }
            if (this.isPaymentHistoryEntered()) {
                this.doRequestPaymentHistory(0);
                this.setPaymentListState(true);
            }
            if (this.getETCSettings().isAmountAnnouncementOn()) {
                this.ttsHandler.speakTollInfo(bl, n2 > -1601830656, n2);
            }
        } else {
            this.log.log(-2137614336, "%1 updateCurrentTollPayment: validFlag = %2, skip this update!", (Object)"[ETCHandler]", (long)n);
        }
    }

    @Override
    public void requestPaymentHistoryListResult(TCPaymentInfo[] tCPaymentInfoArray) {
        try {
            if (tCPaymentInfoArray != null && tCPaymentInfoArray.length > 0) {
                this.log.log(1078071040, "%1 <- requestPaymentHistoryListResult(): %2", (Object)"[ETCHandler]", (Object)Arrays.asList(tCPaymentInfoArray));
                if (this.isWaitingForPaymentHistoryList) {
                    this.isWaitingForPaymentHistoryList = false;
                    Arrays.sort(tCPaymentInfoArray, new ETCHandler$1(this));
                    this.historyList.removeAll();
                    this.getPaymentInfoList().clear();
                    Iterator iterator = Arrays.asList(tCPaymentInfoArray).iterator();
                    while (iterator.hasNext()) {
                        TCPaymentInfo tCPaymentInfo = (TCPaymentInfo)iterator.next();
                        ETCPaymentHistoryListItem eTCPaymentHistoryListItem = this.getPaymentHistoryListItem(tCPaymentInfo);
                        ETCPaymentHistoryListItem$PaymentListRow eTCPaymentHistoryListItem$PaymentListRow = eTCPaymentHistoryListItem.getRow();
                        this.getPaymentInfoList().add(tCPaymentInfo);
                        this.historyList.append(eTCPaymentHistoryListItem$PaymentListRow);
                    }
                }
                this.getETCModels().getETCPaymentHistoryButton().setStatus(this.isCardInserted ? 1 : 2);
                this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(this.isCardInserted ? 1 : 2);
                this.setPaymentListState(true);
            } else {
                this.log.log(1078071040, "%1 <- requestPaymentHistoryListResult(null): no payments available", (Object)"[ETCHandler]");
                this.setPaymentListState(false);
                this.isWaitingForPaymentHistoryList = false;
                this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
                this.historyList.removeAll();
                this.getPaymentInfoList().clear();
                this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(1);
            }
        }
        catch (Throwable throwable) {
            this.log.log(10000, "%1 <- requestPaymentHistoryListResult(): exception:", (Object)"[ETCHandler]", throwable);
            this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
            this.isWaitingForPaymentHistoryList = false;
            this.historyList.removeAll();
            this.getPaymentInfoList().clear();
            this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(1);
        }
    }

    @Override
    public void requestPaymentHistoryDetailsResult(int n, TCPaymentInfoDetails tCPaymentInfoDetails) {
        if (tCPaymentInfoDetails != null) {
            this.log.log(1078071040, "%1 <- requestPaymentHistoryDetailsResult(%2): %3", (Object)"[ETCHandler]", (Object)Integer.toString(n), (Object)tCPaymentInfoDetails.toString());
            this.historyList.setStatus(0);
            TCPaymentInfo tCPaymentInfo = this.getETCPaymentHistoryItemByID(n);
            if (tCPaymentInfo != null) {
                PaymentFormatter paymentFormatter = new PaymentFormatter(tCPaymentInfo, this.env, this.log);
                this.getETCModels().getETCPaymentHistoryDetailAmountLabel().setText(paymentFormatter.getAmountCurrencyString());
                this.getETCModels().getETCPaymentHistoryDetailTitleLabel().setText(paymentFormatter.getDateTimeText());
                this.getETCModels().getETCPaymentHistoryDetailEntranceICNameLabel().setText(tCPaymentInfoDetails.getEntranceIC());
                this.getETCModels().getETCPaymentHistoryDetailEntranceICRoadNameLabel().setText(tCPaymentInfoDetails.getEntranceMotorwayName());
                this.getETCModels().getETCPaymentHistoryDetailExitICNameLabel().setText(tCPaymentInfoDetails.getExitIC());
                this.getETCModels().getETCPaymentHistoryDetailExitICRoadNameLabel().setText(tCPaymentInfoDetails.getExitMotorwayName());
                this.getETCModels().getETCHistoryDetailsRefundChoiceModel().setValue(tCPaymentInfo.getTollAmount().getAmount() < 0 ? 1 : 0);
            }
            this.historyList.setStatus(1);
        } else {
            this.log.log(10000, "%1 <- requestPaymentHistoryDetailsResult(%2, null): invalid paymentInfoDetails", (Object)"[ETCHandler]", (long)n);
        }
    }

    @Override
    public void setLanguageResponse(boolean bl) {
    }

    public void setPaymentHistoryColumnCount(int n) {
        this.paymentHistoryListColumnCount = n;
    }

    protected ETCPaymentHistoryListItem getPaymentHistoryListItem(TCPaymentInfo tCPaymentInfo) {
        return new ETCPaymentHistoryListItem(tCPaymentInfo, this.paymentHistoryListColumnCount, this.env, this.log);
    }

    private void doRequestPaymentHistory(int n) {
        this.log.log(-2137614336, "ETCHandler#doRequestPaymentHistory() --> Entered");
        this.getETCModels().getETCPaymentHistoryButton().setStatus(0);
        this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(0);
        this.getETCModels().getETCPaymentHistoryButton().fireEvent(n);
        this.isWaitingForPaymentHistoryList = true;
        if (this.dsi != null) {
            this.dsi.requestPaymentHistoryList();
        } else {
            this.log.log(10000, "ETCHandler#doRequestPaymentHistory() - DSI NOT SET! Can not provide payment history!");
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "%1 keyTyped(%2, %3)", (Object)"[ETCHandler]", (long)n, (long)n2);
        switch (n) {
            case 1100282: {
                this.log.log(-2137614336, "%1 keyTyped: show hardware info", (Object)"[ETCHandler]");
                this.getETCModels().getETCHardwareInformationButton().fireEvent(n3);
                break;
            }
            case 1100281: {
                this.doRequestPaymentHistory(n3);
                break;
            }
            case 1100280: {
                this.log.log(-2137614336, "%1 keyTyped: show settings screen", (Object)"[ETCHandler]");
                this.getETCModels().getETCSettingsButton().fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "%1 keyTyped(): unknown button key ID %2", (Object)"[ETCHandler]", (long)n2);
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        TCPaymentInfo tCPaymentInfo;
        if (-188149760 == n && (tCPaymentInfo = (TCPaymentInfo)this.getPaymentInfoList().get(n2)) != null) {
            this.log.log(-2137614336, "%1 -> requestPaymentHistoryDetails(%2)", (Object)"[ETCHandler]", (long)tCPaymentInfo.getPaymentInfoID());
            this.dsi.requestPaymentHistoryDetails(tCPaymentInfo.getPaymentInfoID());
            this.historyList.setStatus(0);
            this.historyList.fireEvent(n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private void showNoCardInsertedPopup() {
        this.log.log(1078071040, "%1 showNoCardInsertedPopup()", (Object)"[ETCHandler]");
        if (this.isCardReaderPresent) {
            if (this.etcSettings.isETCWarningOn()) {
                if (!this.isCardInserted) {
                    this.hideETCNoCardInsertedReminderPartialPopup();
                    this.showETCNoCardInsertedReminderPartialPopup();
                    this.ttsHandler.speakWarningMessage(true);
                } else {
                    this.log.log(-2137614336, "%1 showNoCardInsertedPopup() ETC card is already inserted or no card reader is present", (Object)"[ETCHandler]");
                }
            } else {
                this.log.log(-2137614336, "%1 showNoCardInsertedPopup() ETC warning is disable", (Object)"[ETCHandler]");
            }
        } else {
            this.log.log(14808325, "%1 showNoCardInsertedPopup() no card reader is present", (Object)"[ETCHandler]");
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.cardPickUpReminder.equals(timer)) {
            this.showNoCardInsertedPopup();
        } else {
            this.log.log(10000, "%1 fireTimer(%2) unknown timer!", (Object)"[ETCHandler]", (Object)timer.getName());
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.cardPickUpReminder = null;
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(-2137614336, "%1 updateClampState(): clamp15:%2", (Object)"[ETCHandler]", (Object)(bl2 ? "ON" : "OFF"));
        this.isClamp15ON = bl2;
        if (this.popupManager != null && bl) {
            if (this.isClamp15ON) {
                if (this.isCardReaderPresent && !this.isCardInserted) {
                    this.startCardReminder(false);
                }
            } else {
                if (this.cardPickUpReminder != null) {
                    this.cardPickUpReminder.cancel();
                }
                if (!this.isCardReaderPresent) {
                    this.log.log(-2137614336, "%1 updateClampState(); ignore update of clamp states, no card reader is present", (Object)"[ETCHandler]");
                } else if (!this.isCardInserted) {
                    this.log.log(-2137614336, "%1 updateClampState(); card not inserted (or reader not registered)", (Object)"[ETCHandler]");
                } else if (this.getETCSettings() == null) {
                    this.log.log(-2137614336, "%1 updateClampState(); ETCSettings are null!", (Object)"[ETCHandler]");
                } else if (!this.getETCSettings().isCardReminderOn()) {
                    this.log.log(-2137614336, "%1 updateClampState(); card reminder is not on.", (Object)"[ETCHandler]");
                } else {
                    this.log.log(1078071040, "%1 updateClampState(); clamp15 is off, show a warning popup", (Object)"[ETCHandler]");
                    this.showETCCardIStillInsertedReminderPartialPopup();
                    this.ttsHandler.speakWarningMessage(false);
                }
            }
        } else {
            this.log.log(-2137614336, "%1 updateClampState(); ignore update of clamp states, no popupManager is yet available", (Object)"[ETCHandler]");
        }
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void processMsg(int n) {
        if (24 == n) {
            this.log.log(-2137614336, "%1 processMsg(%2): Restore default ETC settings!", (Object)"[ETCHandler]", (long)n);
            this.getETCSettings().restoreDefaultETCSettings();
        }
    }
}

