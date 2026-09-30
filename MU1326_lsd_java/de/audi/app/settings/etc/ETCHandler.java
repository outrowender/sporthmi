/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.etc.AbstractETCPopupManager;
import de.audi.app.settings.etc.AbstractETCTextFactory;
import de.audi.app.settings.etc.ETCModels;
import de.audi.app.settings.etc.ETCPaymentHistoryListItem;
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
import java.util.Comparator;
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
    public static final int NO_CARD_INSERTED_TIMEOUT = 60000;
    private static final int ETC_STATE_CARD_IS_INSERTED = 0;
    private static final int ETC_STATE_CARD_IS_REGISTERED = 1;
    private static final int ETC_STATE_CARD_IS_NOT_INSERTED = 2;
    private static final int ETC_STATE_CARD_IS_ACCESSED = 3;
    private static final int ETC_STATE_CARD_IS_REGISTERED_YET = 4;
    private static final int ETC_STATE_CARD_IS_DEFECT = 5;
    private static final int ETC_STATE_SYSTEM_FAILURE = 6;
    private static final int ETC_STATE_SYSTEM_UNSETUP = 7;
    public static final int ERROR_POPUP_TYPE_UNDEFINED = -1;
    public static final int ERROR_POPUP_TYPE_UNSETUP = 0;
    public static final int ERROR_POPUP_TYPE_DSRCERR = 1;
    public static final int ERROR_POPUP_TYPE_CARD_ERROR = 2;
    public static final int ERROR_POPUP_TYPE_CARD_NONINSERT = 3;
    public static final int ERROR_POPUP_TYPE_SYSTEM = 4;
    public static final int ERROR_POPUP_TYPE_CARD_EXPIRED = 5;
    public static final int ERROR_POPUP_TYPE_COMMUNICATION = 6;
    public static final int ERROR_POPUP_TYPE_CARD_WRITE = 7;
    public static final int ERROR_POPUP_TYPE_CARD_CHECK = 8;
    public static final int ERROR_POPUP_TYPE_CARD_READ = 9;
    public static final int PASS_GATE_ERROR_POPUP_TYPE_GATE_NOT_PASSABLE = 10;
    public static final int PASS_GATE_ERROR_POPUP_TYPE_GATE_NOT_USABLE = 11;
    public static final int PASS_GATE_ERROR_POPUP_TYPE_DANGER_GATE_NOT_USABLE = 12;
    private final int[] errorCode2PopupTypeMapping = new int[]{-1, -1, 0, 1, 2, 3, 9, 7, 6, 11, 12, 5, 4, 4, 0};
    private static final int TOLL_OVER_AMOUNT = 100000;
    private static final int PASS_GATE_POPUP_TYPE_TOLL = 0;
    private static final int PASS_GATE_POPUP_TYPE_TOLL_OVER = 1;
    private static final int PASS_GATE_POPUP_TYPE_TOLL_REFUND = 2;
    private static final int PASS_GATE_POPUP_TYPE_TOLL_REFUND_OVER = 3;
    public static final int PAYMENT_HISTORY_LIST_COLUMN_COUNT_EVO = 5;
    public static final int PAYMENT_HISTORY_LIST_COLUMN_COUNT_PORSCHE = 7;
    private static final String CLASSNAME = "[ETCHandler]";
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
        this.log.log(10000000, "%1 setPopupManager(%2)", (Object)CLASSNAME, (Object)abstractETCPopupManager);
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
        this.log.log(1000000, "%1 startCardReminder(): delay=%2 msec", (Object)CLASSNAME, l);
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
            this.log.log(100000, "%1 showETCWarningPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void showETCCardIStillInsertedReminderPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCCardIStillInsertedReminderPartialPopup();
        } else {
            this.log.log(100000, "%1 showETCCardIStillInsertedReminderPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void showETCTollAmountPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCTollAmountPartialPopup();
        } else {
            this.log.log(100000, "%1 showETCTollAmountPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void showETCNoCardInsertedReminderPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.showETCNoCardInsertedReminderPartialPopup();
        } else {
            this.log.log(100000, "%1 showETCNoCardInsertedReminderPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void hideETCNoCardInsertedReminderPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.hideETCNoCardInsertedReminderPartialPopup();
        } else {
            this.log.log(100000, "%1 hideETCNoCardInsertedReminderPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void hideETCWarningPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.hideETCWarningPartialPopup();
        } else {
            this.log.log(100000, "%1 hideETCWarningPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void hideETCTollAmountPartialPopup() {
        if (this.popupManager != null) {
            this.popupManager.hideETCTollAmountPartialPopup();
        } else {
            this.log.log(100000, "%1 hideETCTollAmountPartialPopup( ): popup manager is not available", (Object)CLASSNAME);
        }
    }

    private void showETCIsAvailableIcon(boolean bl) {
        this.log.log(10000000, "%1 showETCIsAvailableIcon(%2)", (Object)CLASSNAME, (Object)Boolean.toString(bl));
        if (bl) {
            this.getETCModels().getETCIconChoiceModel().setValue(1);
        } else {
            this.getETCModels().getETCIconChoiceModel().setValue(2);
        }
    }

    private void setCardInserted(boolean bl) {
        this.log.log(10000000, "%1 setCardInserted(%2)", (Object)CLASSNAME, (Object)Boolean.toString(bl));
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

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "%1 asyncException( errorCode=%2): %3", (Object)CLASSNAME, (Object)Integer.toString(n), (Object)string);
        if (this.isWaitingForPaymentHistoryList) {
            this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
        }
    }

    private void setPaymentListState(boolean bl) {
        this.log.log(10000000, "%1 setPaymentListState( isEnabled=%2)", (Object)CLASSNAME, (Object)Boolean.toString(bl));
        this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setValue(bl ? 1 : 0);
    }

    public void enterETCSettings() {
        this.log.log(1000000, "%1 enterETCSettings()", (Object)CLASSNAME);
    }

    public void enterETCPaymentHistory() {
        this.log.log(10000000, "%1 enterETCPaymentHistory()", (Object)CLASSNAME);
        this.isPaymentHistoryEntered = true;
    }

    public void leaveETCPaymentHistory() {
        this.log.log(10000000, "%1 leaveETCPaymentHistory()", (Object)CLASSNAME);
        this.isPaymentHistoryEntered = false;
    }

    private boolean isPaymentHistoryEntered() {
        return this.isPaymentHistoryEntered;
    }

    public void updateCardState(int n, int n2) {
        this.log.log(1000000, "%1 updateCardState( cardState=%2)", (Object)CLASSNAME, (long)n);
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
                    this.log.log(10000, "%1 updateCardState(): unknown error code %2", (Object)CLASSNAME, (long)n);
                    break;
                }
            }
        } else {
            this.log.log(10000000, "ETCHandler.updateCardState: validFlag = %1, skip this card state %2 update!", (long)n2, (long)n);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void updateCardError(TCCardError var1_1, int var2_2) {
        block15: {
            block14: {
                this.log.log(1000000, "ETCHandler#updateCardError(%1, %2)", (Object)var1_1, (long)var2_2);
                if (1 != var2_2) break block14;
                if (var1_1 == null) ** GOTO lbl53
                var3_3 = var1_1.getCardError();
                var4_4 = var1_1.getErrorCode();
                if (var4_4 == null) {
                    this.log.log(100000000, "%1 updateCardError(): undefined error code", (Object)"[ETCHandler]");
                    var4_4 = "";
                }
                if (var3_3 >= 0 && var3_3 < this.errorCode2PopupTypeMapping.length) {
                    var5_5 = this.errorCode2PopupTypeMapping[var3_3];
                    if (var5_5 == -1) {
                        if (var3_3 == 1) {
                            this.log.log(10000000, "%1 updateCardError(): undefined popup type, errorId=%2 (=NO_ERROR)", (Object)"[ETCHandler]", (long)var3_3);
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
                            this.log.log(100000000, "%1 updateCardError(): card error does not change the card state: %2", (Object)"[ETCHandler]", (long)var3_3);
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
            this.log.log(10000000, "%1 updateCardError: validFlag = %2, do nothing!", (Object)"[ETCHandler]", (long)var2_2);
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

    public void updateCardDateInformation(TCCardDateInformation tCCardDateInformation, int n) {
        this.log.log(1000000, "%1 updateCardDateInformation(): %2", (Object)CLASSNAME, (Object)(1 == n ? "valid" : "invalid"));
    }

    public void updateHardwareInformation(TCHardwareInformation[] tCHardwareInformationArray, int n) {
        this.log.log(1000000, "%1 updateHardwareInformation(): %2", (Object)CLASSNAME, (Object)(tCHardwareInformationArray != null ? Arrays.asList(tCHardwareInformationArray) : null));
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
                            this.log.log(10000, "%1 updateHardwareInformation(): unknown hardware key %2", (Object)CLASSNAME, (long)tCHardwareInformationArray[i2].getKey());
                        }
                    }
                }
            } else {
                this.isCardReaderPresent = false;
                this.log.log(10000, "%1 updateHardwareInformation(): invalid hardware information", (Object)CLASSNAME);
            }
        } else {
            this.log.log(10000000, "%1 updateHardwareInformation: validFlag = %2, skip this update!", (Object)CLASSNAME, (long)n);
        }
    }

    public void updateCurrentTollPayment(NavPriceInfo navPriceInfo, int n) {
        this.log.log(1000000, "%1 updateCurrentTollPayment(): %2 %3", (Object)CLASSNAME, (Object)navPriceInfo, (Object)(n == 1 ? "valid" : "invalid"));
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
                if (n2 > 100000) {
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
                this.ttsHandler.speakTollInfo(bl, n2 > 100000, n2);
            }
        } else {
            this.log.log(10000000, "%1 updateCurrentTollPayment: validFlag = %2, skip this update!", (Object)CLASSNAME, (long)n);
        }
    }

    public void requestPaymentHistoryListResult(TCPaymentInfo[] tCPaymentInfoArray) {
        try {
            if (tCPaymentInfoArray != null && tCPaymentInfoArray.length > 0) {
                this.log.log(1000000, "%1 <- requestPaymentHistoryListResult(): %2", (Object)CLASSNAME, (Object)Arrays.asList(tCPaymentInfoArray));
                if (this.isWaitingForPaymentHistoryList) {
                    this.isWaitingForPaymentHistoryList = false;
                    Arrays.sort(tCPaymentInfoArray, new Comparator(){

                        public int compare(Object object, Object object2) {
                            long l;
                            long l2 = ((TCPaymentInfo)object).getTimeStamp().getTime();
                            if (l2 == (l = ((TCPaymentInfo)object2).getTimeStamp().getTime())) {
                                return 0;
                            }
                            return l > l2 ? 1 : -1;
                        }
                    });
                    this.historyList.removeAll();
                    this.getPaymentInfoList().clear();
                    Iterator iterator = Arrays.asList(tCPaymentInfoArray).iterator();
                    while (iterator.hasNext()) {
                        TCPaymentInfo tCPaymentInfo = (TCPaymentInfo)iterator.next();
                        ETCPaymentHistoryListItem eTCPaymentHistoryListItem = this.getPaymentHistoryListItem(tCPaymentInfo);
                        ETCPaymentHistoryListItem.PaymentListRow paymentListRow = eTCPaymentHistoryListItem.getRow();
                        this.getPaymentInfoList().add(tCPaymentInfo);
                        this.historyList.append(paymentListRow);
                    }
                }
                this.getETCModels().getETCPaymentHistoryButton().setStatus(this.isCardInserted ? 1 : 2);
                this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(this.isCardInserted ? 1 : 2);
                this.setPaymentListState(true);
            } else {
                this.log.log(1000000, "%1 <- requestPaymentHistoryListResult(null): no payments available", (Object)CLASSNAME);
                this.setPaymentListState(false);
                this.isWaitingForPaymentHistoryList = false;
                this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
                this.historyList.removeAll();
                this.getPaymentInfoList().clear();
                this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(1);
            }
        }
        catch (Throwable throwable) {
            this.log.log(10000, "%1 <- requestPaymentHistoryListResult(): exception:", (Object)CLASSNAME, throwable);
            this.getETCModels().getETCPaymentHistoryButton().setStatus(2);
            this.isWaitingForPaymentHistoryList = false;
            this.historyList.removeAll();
            this.getPaymentInfoList().clear();
            this.getETCModels().getETCPaymentHistoryButtonAvailableChoice().setStatus(1);
        }
    }

    public void requestPaymentHistoryDetailsResult(int n, TCPaymentInfoDetails tCPaymentInfoDetails) {
        if (tCPaymentInfoDetails != null) {
            this.log.log(1000000, "%1 <- requestPaymentHistoryDetailsResult(%2): %3", (Object)CLASSNAME, (Object)Integer.toString(n), (Object)tCPaymentInfoDetails.toString());
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
            this.log.log(10000, "%1 <- requestPaymentHistoryDetailsResult(%2, null): invalid paymentInfoDetails", (Object)CLASSNAME, (long)n);
        }
    }

    public void setLanguageResponse(boolean bl) {
    }

    public void setPaymentHistoryColumnCount(int n) {
        this.paymentHistoryListColumnCount = n;
    }

    protected ETCPaymentHistoryListItem getPaymentHistoryListItem(TCPaymentInfo tCPaymentInfo) {
        return new ETCPaymentHistoryListItem(tCPaymentInfo, this.paymentHistoryListColumnCount, this.env, this.log);
    }

    private void doRequestPaymentHistory(int n) {
        this.log.log(10000000, "ETCHandler#doRequestPaymentHistory() --> Entered");
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

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "%1 keyTyped(%2, %3)", (Object)CLASSNAME, (long)n, (long)n2);
        switch (n) {
            case 1100282: {
                this.log.log(10000000, "%1 keyTyped: show hardware info", (Object)CLASSNAME);
                this.getETCModels().getETCHardwareInformationButton().fireEvent(n3);
                break;
            }
            case 1100281: {
                this.doRequestPaymentHistory(n3);
                break;
            }
            case 1100280: {
                this.log.log(10000000, "%1 keyTyped: show settings screen", (Object)CLASSNAME);
                this.getETCModels().getETCSettingsButton().fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "%1 keyTyped(): unknown button key ID %2", (Object)CLASSNAME, (long)n2);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        TCPaymentInfo tCPaymentInfo;
        if (1100276 == n && (tCPaymentInfo = (TCPaymentInfo)this.getPaymentInfoList().get(n2)) != null) {
            this.log.log(10000000, "%1 -> requestPaymentHistoryDetails(%2)", (Object)CLASSNAME, (long)tCPaymentInfo.getPaymentInfoID());
            this.dsi.requestPaymentHistoryDetails(tCPaymentInfo.getPaymentInfoID());
            this.historyList.setStatus(0);
            this.historyList.fireEvent(n4);
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private void showNoCardInsertedPopup() {
        this.log.log(1000000, "%1 showNoCardInsertedPopup()", (Object)CLASSNAME);
        if (this.isCardReaderPresent) {
            if (this.etcSettings.isETCWarningOn()) {
                if (!this.isCardInserted) {
                    this.hideETCNoCardInsertedReminderPartialPopup();
                    this.showETCNoCardInsertedReminderPartialPopup();
                    this.ttsHandler.speakWarningMessage(true);
                } else {
                    this.log.log(10000000, "%1 showNoCardInsertedPopup() ETC card is already inserted or no card reader is present", (Object)CLASSNAME);
                }
            } else {
                this.log.log(10000000, "%1 showNoCardInsertedPopup() ETC warning is disable", (Object)CLASSNAME);
            }
        } else {
            this.log.log(100000000, "%1 showNoCardInsertedPopup() no card reader is present", (Object)CLASSNAME);
        }
    }

    public void fireTimer(Timer timer) {
        if (this.cardPickUpReminder.equals(timer)) {
            this.showNoCardInsertedPopup();
        } else {
            this.log.log(10000, "%1 fireTimer(%2) unknown timer!", (Object)CLASSNAME, (Object)timer.getName());
        }
    }

    public void cancelTimer(Timer timer) {
        this.cardPickUpReminder = null;
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.log.log(10000000, "%1 updateClampState(): clamp15:%2", (Object)CLASSNAME, (Object)(bl2 ? "ON" : "OFF"));
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
                    this.log.log(10000000, "%1 updateClampState(); ignore update of clamp states, no card reader is present", (Object)CLASSNAME);
                } else if (!this.isCardInserted) {
                    this.log.log(10000000, "%1 updateClampState(); card not inserted (or reader not registered)", (Object)CLASSNAME);
                } else if (this.getETCSettings() == null) {
                    this.log.log(10000000, "%1 updateClampState(); ETCSettings are null!", (Object)CLASSNAME);
                } else if (!this.getETCSettings().isCardReminderOn()) {
                    this.log.log(10000000, "%1 updateClampState(); card reminder is not on.", (Object)CLASSNAME);
                } else {
                    this.log.log(1000000, "%1 updateClampState(); clamp15 is off, show a warning popup", (Object)CLASSNAME);
                    this.showETCCardIStillInsertedReminderPartialPopup();
                    this.ttsHandler.speakWarningMessage(false);
                }
            }
        } else {
            this.log.log(10000000, "%1 updateClampState(); ignore update of clamp states, no popupManager is yet available", (Object)CLASSNAME);
        }
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void processMsg(int n) {
        if (24 == n) {
            this.log.log(10000000, "%1 processMsg(%2): Restore default ETC settings!", (Object)CLASSNAME, (long)n);
            this.getETCSettings().restoreDefaultETCSettings();
        }
    }
}

