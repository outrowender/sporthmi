/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.abstractclasses;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.miniapps.MiniApp;

public abstract class AbstractBaseModelHandler
implements ButtonListener,
TiledListModelListener,
OptionModelListener,
MenuModelListener,
ChoiceListener {
    protected final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    protected IHMIServiceApp hmiService;
    private int terminal;
    private String modelName;
    private int modelId;

    protected abstract int[] getButtonIdsToRegister();

    protected abstract int[] getChoiceIdsToRegister();

    protected abstract int[] getMenuModelIdsToRegister();

    protected abstract int[] getTiledListIdsToRegister();

    protected abstract void buttonKeyPressed(int var1);

    protected abstract void listItemSelected(EvoListRow var1, int var2, int var3);

    protected abstract void listItemFocused(EvoListRow var1, int var2, int var3);

    protected abstract void optionKeyPressed(int var1, int var2, int var3);

    protected abstract void menuModelItemFocused(int var1, long var2, int var4);

    protected abstract void choiceModelItemSelected(int var1, int var2, int var3);

    public AbstractBaseModelHandler(IHMIServiceApp iHMIServiceApp) {
        this.hmiService = iHMIServiceApp;
        this.registerButtons();
        this.registerChoiceModels();
        this.registerTiledLists();
        this.registerMenuModels();
    }

    private void registerMenuModels() {
        int[] nArray = this.getMenuModelIdsToRegister();
        if (nArray != null && nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.registerMenuModel(nArray[i2]);
            }
        }
    }

    private void registerMenuModel(int n) {
        this.hmiService.getMenuModel(n).setListener(this);
    }

    private void registerButtons() {
        int[] nArray = this.getButtonIdsToRegister();
        if (nArray != null && nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.registerButton(nArray[i2]);
            }
        }
    }

    private void registerChoiceModels() {
        int[] nArray = this.getChoiceIdsToRegister();
        if (nArray != null && nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.registerChoiceModels(nArray[i2]);
            }
        }
    }

    private void registerChoiceModels(int n) {
        this.getChoiceModel(n).setChoiceListener(this);
    }

    private void registerTiledLists() {
        int[] nArray = this.getTiledListIdsToRegister();
        if (nArray != null && nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.registerTiledList(nArray[i2]);
            }
        }
    }

    public void registerMiniApp(MiniApp miniApp) {
        OptionModelApp optionModelApp = this.hmiService.getOptionModel(miniApp.getOptionModelID());
        int[] nArray = miniApp.getTargetTiledListModelIDs();
        if (nArray != null && nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                optionModelApp.setListener(this, nArray[i2]);
            }
        }
    }

    protected ChoiceModelApp getChoiceModel(int n) {
        return this.hmiService.getChoiceModel(n);
    }

    protected void setChoiceValue(int n, String string, int n2) {
        this.logChannel.log(100000000, "AbstractBaseModelHandler#setChoiceValue: %1 : %2 -> %3", (Object)string, (long)this.getChoiceValue(n), (long)n2);
        this.getChoiceModel(n).setValue(n2);
    }

    protected int getChoiceValue(int n) {
        return this.getChoiceModel(n).getValue();
    }

    public void setChoiceStatus(int n, String string, int n2) {
        this.logChannel.log(100000000, "AbstractBaseModelHandler#setChoiceStatus: %1 : %2 -> %3", (Object)string, (long)this.getChoiceStatus(n), (long)n2);
        this.getChoiceModel(n).setStatus(n2);
    }

    protected void toggleChoiceStatus(int n, String string) {
        int n2 = this.getChoiceStatus(n);
        this.setChoiceStatus(n, string, n2 ^ 1);
    }

    protected void toggleChoiceValue(int n, String string) {
        int n2 = this.getChoiceValue(n);
        this.setChoiceValue(n, string, n2 ^ 1);
    }

    protected int getChoiceStatus(int n) {
        return this.getChoiceModel(n).getStatus();
    }

    protected void setButtonStatus(int n, String string, int n2) {
        this.logChannel.log(100000000, "AbstractBaseModelHandler#setButtonStatus: %1 : %2 -> %3", (Object)string, (long)this.getButtonStatus(n), (long)n2);
        this.getButtonModel(n).setStatus(n2);
    }

    protected int getButtonStatus(int n) {
        return this.getButtonModel(n).getStatus();
    }

    private void registerButton(int n) {
        this.getButtonModel(n).setButtonListener(this);
    }

    protected ButtonModelApp getButtonModel(int n) {
        return this.hmiService.getButtonModel(n);
    }

    protected LabelModelApp getLabelModel(int n) {
        return this.hmiService.getLabelModel(n);
    }

    public void setLabelText(int n, String string, String string2) {
        this.getLabelModel(n).setText(string2);
    }

    protected String getLabelText(int n) {
        return this.getLabelModel(n).getText();
    }

    private void registerTiledList(int n) {
        this.getTiledListModel(n).setListener(this);
    }

    protected TiledListModelApp getTiledListModel(int n) {
        return this.hmiService.getTiledListModel(n);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    public void fireButtonEvent() {
        if (this.modelName != null && !"".equalsIgnoreCase(this.modelName)) {
            this.logChannel.log(100000000, "AbstractBaseModelHandler#fireButtonEvent: %1 ", (Object)this.modelName);
        } else {
            this.logChannel.log(100000000, "AbstractBaseModelHandler#fireButtonEvent! %1", (long)this.modelId);
        }
        this.getButtonModel(this.modelId).fireEvent(this.terminal);
    }

    public void fireTiledListEvent() {
        if (this.modelName != null && !"".equalsIgnoreCase(this.modelName)) {
            this.logChannel.log(100000000, "AbstractBaseModelHandler#fireTiledListEvent: %1 ", (Object)this.modelName);
        } else {
            this.logChannel.log(100000000, "AbstractBaseModelHandler#fireTiledListEvent!");
        }
        this.getTiledListModel(this.modelId).fireEvent(this.terminal);
    }

    public void fireOptionEvent() {
        if (this.modelName != null && !"".equalsIgnoreCase(this.modelName)) {
            this.logChannel.log(100000000, "AbstractBaseModelHandler#fireOptionEvent: %1 ", (Object)this.modelName);
        } else {
            this.logChannel.log(100000000, "AbstractBaseModelHandler#fireOptionEvent!");
        }
        this.getOptionModel(this.modelId).fireEvent(this.terminal);
    }

    protected void fireModelEvent(int n) {
        this.hmiService.getModelApp(n).fireEvent(0);
    }

    protected HMIModelApp getOptionModel(int n) {
        return this.hmiService.getOptionModel(n);
    }

    public void saveModelData(int n, int n2) {
        this.modelName = String.valueOf(n);
        this.modelId = n;
        this.terminal = n2;
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractBaseModelHandler#keyPressed called");
        this.saveModelData(n, n3);
        this.buttonKeyPressed(n);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractBaseModelHandler#itemSelected called");
        this.saveModelData(n, n4);
        this.listItemSelected(evoListRow, n, n2);
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractBaseModelHandler#itemFocused (for list models) called");
        this.saveModelData(n, n4);
        this.listItemFocused(evoListRow, n, n2);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "AbstractBaseModelHandler#keyPressed (optionModel = %1) called", (long)n);
        this.saveModelData(n, n5);
        this.optionKeyPressed(n, n2, n3);
    }

    public void setModelName(String string) {
        this.modelName = string;
    }

    public abstract void showPopup(int var1);

    public void enablePopups() {
        this.hmiService.enablePopups();
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "AbstractBaseModelHandler#itemFocused (for menu models) called with uniqueListRowID = %1", l);
        this.saveModelData(n2, n3);
        this.menuModelItemFocused(n2, l, n);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractBaseModelHandler#itemSelected called with modelId = %1", (long)n);
        this.saveModelData(n, n4);
        this.choiceModelItemSelected(n, n2, n3);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }
}

