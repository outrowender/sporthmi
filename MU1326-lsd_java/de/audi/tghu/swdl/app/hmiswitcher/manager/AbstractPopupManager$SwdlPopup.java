/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import java.util.StringTokenizer;

class AbstractPopupManager$SwdlPopup {
    int popUpType;
    String id;
    byte prio;
    int errorCode;
    int errorCodeDetail;
    String info;
    int hmiPopUpId;
    private final /* synthetic */ AbstractPopupManager this$0;

    AbstractPopupManager$SwdlPopup(AbstractPopupManager abstractPopupManager, int n, String string, byte by, int n2, int n3, String string2) {
        this.this$0 = abstractPopupManager;
        this.popUpType = n;
        this.id = string;
        this.prio = by;
        this.errorCode = n2;
        this.errorCodeDetail = n3;
        this.info = string2;
        this.hmiPopUpId = abstractPopupManager.getSwdlPopupID();
    }

    boolean isSingle() {
        return AbstractPopupManager.HMI_POPUP_SINGLE[this.popUpType];
    }

    void replace(AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup) {
        this.errorCode = abstractPopupManager$SwdlPopup.errorCode;
        this.errorCodeDetail = abstractPopupManager$SwdlPopup.errorCodeDetail;
        this.info = abstractPopupManager$SwdlPopup.info;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void doShow() {
        if (this.hmiPopUpId != 0) {
            Class clazz = AbstractPopupManager.class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (AbstractPopupManager.class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : AbstractPopupManager.class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
            synchronized (clazz) {
                AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.this$0.top();
                AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup2 = null;
                abstractPopupManager$SwdlPopup2 = this.isSingle() ? this.this$0.lookup(this.popUpType) : this.this$0.lookup(this.popUpType, this.id);
                if (abstractPopupManager$SwdlPopup2 == null) {
                    this.this$0.insert(this);
                    this.this$0.updatePopUp(abstractPopupManager$SwdlPopup);
                } else if (this.prio != abstractPopupManager$SwdlPopup2.prio) {
                    this.this$0.remove(abstractPopupManager$SwdlPopup2);
                    this.this$0.insert(this);
                    this.this$0.updatePopUp(abstractPopupManager$SwdlPopup);
                } else {
                    abstractPopupManager$SwdlPopup2.replace(this);
                    if (abstractPopupManager$SwdlPopup2.equals(abstractPopupManager$SwdlPopup)) {
                        abstractPopupManager$SwdlPopup.update();
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void doHide() {
        if (this.hmiPopUpId != 0) {
            Class clazz = AbstractPopupManager.class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup == null ? (AbstractPopupManager.class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup = AbstractPopupManager.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager$SwdlPopup")) : AbstractPopupManager.class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager$SwdlPopup;
            synchronized (clazz) {
                AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup = this.this$0.top();
                this.this$0.remove(this);
                this.this$0.updatePopUp(abstractPopupManager$SwdlPopup);
            }
        }
    }

    private void setSubTitle() {
        String string = AbstractPopupManager.access$000(this.this$0).getTextFactory().getSubTitleText(this.popUpType);
        AbstractPopupManager.access$100(this.this$0).getPopupSubtitle().setText(string);
    }

    private void setPopupText() {
        String[] stringArray;
        if (this.popUpType == 16) {
            stringArray = new String[]{Integer.toString(this.errorCode), this.info, Integer.toString(this.errorCode), Integer.toString(this.errorCodeDetail)};
        } else if (this.popUpType == 22) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.info, "&");
            if (stringTokenizer.countTokens() == 2) {
                stringArray = new String[]{"-", stringTokenizer.nextToken(), stringTokenizer.nextToken()};
            } else {
                stringArray = new String[stringTokenizer.countTokens()];
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    stringArray[i2] = stringTokenizer.nextToken();
                }
                if (stringArray.length > 2) {
                    String string = stringArray[0];
                    stringArray[0] = stringArray[1];
                    stringArray[1] = string;
                }
            }
        } else {
            stringArray = new String[]{this.id, this.info, Integer.toString(this.errorCode), Integer.toString(this.errorCodeDetail)};
        }
        AbstractPopupManager.access$100(this.this$0).getPopupTextLabel().setText(StringUtilities.formatMessage(AbstractPopupManager.access$200(this.this$0, this.popUpType), stringArray));
    }

    private void enableButtons() {
        AbstractPopupManager.access$100(this.this$0).getPopupActionChoice().setValue(AbstractPopupManager.HMI_SELECT_DEFAULT_BUTTON[this.popUpType]);
        this.this$0.getHMIService().getMenuModel(15866112).setFocusedItem(AbstractPopupManager.HMI_SELECT_DEFAULT_BUTTON[this.popUpType], FocusAdvice.KEEP_POSITION, -1L);
        AbstractPopupManager.access$100(this.this$0).getPopupSkipDeviceChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][0] > 0 ? 1 : 0);
        AbstractPopupManager.access$100(this.this$0).getPopupInterruptChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][1] > 0 ? 1 : 0);
        AbstractPopupManager.access$100(this.this$0).getPopupRetryChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][2] > 0 ? 1 : 0);
        AbstractPopupManager.access$100(this.this$0).getPopupCancelChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][3] > 0 ? 1 : 0);
        AbstractPopupManager.access$100(this.this$0).getPopupContinueChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][4] > 0 ? 1 : 0);
        AbstractPopupManager.access$100(this.this$0).getPopupOkChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][5] > 0 ? 1 : 0);
        AbstractPopupManager.access$100(this.this$0).getPopupSelectChoice().setValue(AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][6] > 0 ? 1 : 0);
    }

    private int getResponseCode(int n) {
        return AbstractPopupManager.HMI_POPUP_BUTTONS[this.popUpType][n];
    }

    void update() {
        this.setSubTitle();
        this.setPopupText();
    }

    void show() {
        this.update();
        this.enableButtons();
        this.this$0.showSwdlPopup(AbstractPopupManager.access$000(this.this$0).getTerminalId());
    }

    void hide() {
        this.this$0.hideSwdlPopup(AbstractPopupManager.access$000(this.this$0).getTerminalId());
    }

    static /* synthetic */ int access$300(AbstractPopupManager$SwdlPopup abstractPopupManager$SwdlPopup, int n) {
        return abstractPopupManager$SwdlPopup.getResponseCode(n);
    }
}

