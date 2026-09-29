/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.SDSEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.Iterator;

public class MenuSDSEventHandler
implements IWidgetLogChannel,
WidgetConstants,
IMenuCallback {
    private static final int RESPONSE_OK;
    private static final int RESPONSE_INVALID;
    private static final int RESPONSE_ERROR;
    private static final int RESPONSE_DISABLED;
    private static final int MODELVALUE_PAGENUMBER_MENU_EMPTY;
    private static final int MODELVALUE_PAGENUMBER_ONLY_ONE_PAGE;
    private static final int MODELVALUE_PAGENUMBER_FIRST_PAGE;
    private static final int MODELVALUE_PAGENUMBER_MIDDLE_PAGE;
    private static final int MODELVALUE_PAGENUMBER_LAST_PAGE;
    private MenuController menu;
    private ChoiceModelApp sdsEnumerationModel;
    private boolean sdsActive;

    public MenuSDSEventHandler(MenuController menuController) {
        this.menu = menuController;
    }

    public void processSDSEvent(SDSEvent sDSEvent) {
        int n = this.processCommand(sDSEvent.getSDSCommand(), sDSEvent);
        sDSEvent.consume();
        this.sendResponse(sDSEvent, n);
    }

    private void sendResponse(SDSEvent sDSEvent, int n) {
        if (!this.shouldSendResponse(sDSEvent.getResponseType(), n)) {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#sendResponse: don't send response. process result: %2. Event: %1", (Object)sDSEvent, (long)n);
            return;
        }
        int[] nArray = sDSEvent.getAnswers();
        if (nArray == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#sendResponse: event's answers are null. process result %2. Event: %1", (Object)sDSEvent, (long)n);
            return;
        }
        if (nArray.length <= n) {
            if (n == 3 && nArray.length > 1) {
                menuLogCh.log(-1601830656, "MenuSDSEventHandler#sendResponse: event has no answer for process result %2. answers length: %3, use RESPONSE_INVALID instead. Event: %1", (Object)sDSEvent, (long)n, (long)nArray.length);
                n = 1;
            } else {
                menuLogCh.log(-1601830656, "MenuSDSEventHandler#sendResponse: event has no answer for process result %2. answers length: %3. Event: %1", (Object)sDSEvent, (long)n, (long)nArray.length);
                return;
            }
        }
        int n2 = nArray[n];
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#sendResponse: send answer %1 for process result %2", (long)n2, (long)n);
        AbstractWidget.sdsService.sendResult(n2);
    }

    private boolean shouldSendResponse(int n, int n2) {
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#shouldSendResponse: responseType=%1, processStatus=%2", (long)n, (long)n2);
        if (AbstractWidget.sdsService == null) {
            menuLogCh.log(10000, "MenuSDSEventHandler#shouldSendResponse: sdsService is not present, cannot call sendResult");
            return false;
        }
        return n != 0 && (n2 != 0 || n == 2);
    }

    private int processCommand(int n, SDSEvent sDSEvent) {
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#processCommand sdsCommand: %3, (%1), event: %2", (Object)this.menu, (Object)sDSEvent, (long)n);
        switch (n) {
            case 4: {
                return this.goPageUpDown(true, sDSEvent.getValue());
            }
            case 3: {
                return this.goPageUpDown(false, sDSEvent.getValue());
            }
            case 1: {
                return this.gotoFirstPage(sDSEvent.getValue());
            }
            case 2: {
                return this.gotoLastPage(sDSEvent.getValue());
            }
            case 5: {
                return this.selectRow(sDSEvent.getValue() - 1, true);
            }
            case 6: {
                return this.selectRowAbsolute(sDSEvent.getValue());
            }
            case 7: {
                return this.selectRow(sDSEvent.getValue() - 1, false);
            }
            case 8: {
                return this.readLineAbsolute(sDSEvent.getValue());
            }
            case 9: {
                return this.readLine(sDSEvent.getValue() - 1);
            }
            case 10: {
                return this.readLineById(sDSEvent.getValue());
            }
        }
        menuLogCh.log(10000, "MenuSDSEventHandler#processCommand unknown SDSEvent command type: %1", (long)n);
        return 2;
    }

    private int selectRow(int n, boolean bl) {
        MenuViewport menuViewport = this.menu.getViewport();
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#selectRow: row number: %2, current viewport: %1", (Object)menuViewport, (long)n);
        if (menuViewport.isEmpty()) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#selectRow: invalid, because viewport is empty");
            return 1;
        }
        MenuItemIndex menuItemIndex = this.findRowInViewport(n);
        if (menuItemIndex == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#selectRow: invalid, because viewport doesn't contain row %1", (long)n);
            return 1;
        }
        if (!this.menu.isEnabled(menuItemIndex)) {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#selectRow: found disabled item %1 for relative row %1, viewport: %2. Ignore event, because item is disabled", (Object)menuItemIndex, (Object)menuViewport, (long)n);
            return 3;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#selectRow: found item %1 for relative row %3, viewport: %2", (Object)menuItemIndex, (Object)menuViewport, (long)n);
        this.menu.setSelectedIndex(menuItemIndex);
        this.menu.relayout();
        this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
        this.notifySDSEnumerationModelRow(n);
        this.notifySDSEnumerationModelStatus(menuItemIndex);
        if (bl) {
            this.sendKeyPressedToItem(menuItemIndex);
        } else {
            this.sendKeyPressedToSdsService(menuItemIndex);
        }
        return 0;
    }

    private void notifySDSEnumerationModelRow(int n) {
        ChoiceModelApp choiceModelApp = this.getSdsEnumerationModel();
        if (choiceModelApp != null) {
            int n2 = n + 1;
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifySDSEnumerationModelRow: set value %1 to model SDS_ENUMERATION_NUMBER_CHOICE (%2)", (long)n2, (long)choiceModelApp.getID());
            choiceModelApp.setValue(n2);
        }
    }

    private void notifyEnumerationModelRowAndStatus(MenuItemIndex menuItemIndex) {
        int n = this.getSdsRowNumberOnCurrentPage(menuItemIndex);
        if (n != -1) {
            this.notifySDSEnumerationModelRow(n);
        }
        this.notifySDSEnumerationModelStatus(menuItemIndex);
    }

    private void notifySDSEnumerationModelStatus(MenuItemIndex menuItemIndex) {
        AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemSingle) {
            this.notifySDSEnumerationModelStatus(-1);
        } else {
            this.notifySDSEnumerationModelStatus(menuItemIndex.widgetPart);
        }
    }

    private void notifySDSEnumerationModelStatus(int n) {
        ChoiceModelApp choiceModelApp = this.getSdsEnumerationModel();
        if (choiceModelApp != null) {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifySDSEnumerationModelStatus: set status %1 to model SDS_ENUMERATION_NUMBER_CHOICE (%2)", (long)n, (long)choiceModelApp.getID());
            choiceModelApp.setStatus(n);
        }
    }

    private int selectRowAbsolute(int n) {
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#selectRowAbsolute: row number: %1", (long)n);
        MenuItemIndex menuItemIndex = this.findRowInMenu(n);
        if (menuItemIndex == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#selectRowAbsolute: invalid, because menu doesn't contain row %1", (long)n);
            return 1;
        }
        if (!this.menu.isEnabled(menuItemIndex)) {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#selectRow: found disabled item %1 for absolute row %2. Ignore event, because item is disabled", (Object)menuItemIndex, (long)n);
            return 3;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#selectRowAbsolute: found item %1 for absolute row %2", (Object)menuItemIndex, (long)n);
        this.menu.setSelectedIndex(menuItemIndex);
        this.menu.relayout();
        this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
        this.notifyEnumerationModelRowAndStatus(menuItemIndex);
        this.sendKeyPressedToItem(menuItemIndex);
        return 0;
    }

    private MenuItemIndex findRowInMenu(int n) {
        return this.findRowItem(n, this.menu.iterator(this.menu.getFirstMenuItem(), true, true));
    }

    private void sendKeyPressedToItem(MenuItemIndex menuItemIndex) {
        KeyEvent keyEvent = new KeyEvent(null, 0, 17, this.menu.getTerminal().getTerminalID());
        AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiItem) {
            IMenuItemMultiItem iMenuItemMultiItem = (IMenuItemMultiItem)((Object)abstractWidget);
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#sendKeyPressedToItem: simulate keyPress on item %1, multi item: %2", (Object)menuItemIndex, (Object)iMenuItemMultiItem);
            iMenuItemMultiItem.keyPressed(keyEvent, menuItemIndex.widgetPart);
            iMenuItemMultiItem.keyReleased(keyEvent, menuItemIndex.widgetPart);
        } else {
            if (menuLogCh.isDebug()) {
                menuLogCh.log(-2137614336, "MenuSDSEventHandler#sendKeyPressedToItem: simulate keyPress on item %1, single item: %2 with text: %3", (Object)menuItemIndex, (Object)abstractWidget, (Object)abstractWidget.getDiagnosisText());
            }
            abstractWidget.keyPressed(keyEvent);
            abstractWidget.keyReleased(keyEvent);
        }
    }

    private MenuItemIndex findRowItem(int n, Iterator iterator) {
        Object object;
        int n2 = 0;
        MenuItemIndex menuItemIndex = null;
        while (iterator.hasNext()) {
            object = (MenuItemIndex)iterator.next();
            menuItemIndex = object;
            if (!this.isSdsItem((MenuItemIndex)object)) continue;
            if (n == n2) {
                return object;
            }
            ++n2;
        }
        if (n2 < n) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#findRowItem: looking for row %1, but iteration contains only %2 SDS items", (long)n, (long)n2);
            return null;
        }
        if (menuItemIndex == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#findRowItem: looking for row %1, but iteration is empty", (long)n);
            return null;
        }
        if (!this.menu.getAnimationManager().getLayoutData().alignTop) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#findRowItem: looking for row %1 just after iteration, but menu is bottom aligned, so no partially visible item at bottom", (long)n);
            return null;
        }
        object = this.menu.iterator(menuItemIndex, true, false);
        if (!object.hasNext()) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#findRowItem: looking for row %1, but there are no more items after iteration", (long)n);
            return null;
        }
        MenuItemIndex menuItemIndex2 = (MenuItemIndex)object.next();
        if (!this.isSdsItem(menuItemIndex2)) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#findRowItem: looking for partially visible row %2, but item %3 is not a SDS item", (Object)menuItemIndex2, (long)n);
            return null;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#findRowItem: select partially visible item %1 at row %2", (Object)menuItemIndex2, (long)n);
        return menuItemIndex2;
    }

    private MenuItemIndex findRowItemById(int n, Iterator iterator) {
        while (iterator.hasNext()) {
            int n2;
            MenuItemIndex menuItemIndex = (MenuItemIndex)iterator.next();
            AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
            if (!(abstractWidget instanceof IMenuItem) || (n2 = ((IMenuItem)((Object)abstractWidget)).getWidgetID()) != n) continue;
            return menuItemIndex;
        }
        menuLogCh.log(-1601830656, "MenuSDSEventHandler#findRowItemById: can not find menu item with ID %1", (long)n);
        return null;
    }

    private int getSdsRowNumberOnCurrentPage(MenuItemIndex menuItemIndex) {
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.isEmpty()) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#getSdsRowNumberOnCurrentPage: SDS item %1 not found, current viewport is empty", (Object)menuItemIndex);
            return -1;
        }
        int n = 0;
        Iterator iterator = this.menu.iterator(menuViewport.start, menuViewport.end, true);
        while (iterator.hasNext()) {
            MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
            if (!this.isSdsItem(menuItemIndex2)) continue;
            if (menuItemIndex2.equals(menuItemIndex)) {
                return n;
            }
            ++n;
        }
        menuLogCh.log(-1601830656, "MenuSDSEventHandler#getSdsRowNumberOnCurrentPage: SDS item %1 not found in current viewport: %2", (Object)menuItemIndex, (Object)menuViewport);
        return -1;
    }

    public boolean isSdsItem(MenuItemIndex menuItemIndex) {
        int n = this.getSdsItemSelectedAction(menuItemIndex);
        return n == 2;
    }

    private int goPageUpDown(boolean bl, int n) {
        MenuViewport menuViewport = this.menu.getViewport();
        if (menuViewport.isEmpty()) {
            return 0;
        }
        boolean bl2 = this.menu.scrollPage(bl);
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#goPage: value=%1 and scrollDown=%2 and success=%3", (long)n, bl ? 1L : 0L, bl2 ? 1L : 0L);
        if (n == 11) {
            this.menu.setSelectedIndex(null);
        }
        return bl2 ? 0 : 1;
    }

    private int gotoFirstPage(int n) {
        MenuItemIndex menuItemIndex;
        if (n == 11) {
            this.menu.setSelectedIndex(null);
        }
        if ((menuItemIndex = this.menu.getFirstMenuItem()) != null) {
            this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
            return 0;
        }
        menuLogCh.log(-1601830656, "MenuSDSEventHandler#gotoFirstPage: invalid, because menu is empty");
        return 1;
    }

    private int gotoLastPage(int n) {
        MenuItemIndex menuItemIndex;
        if (n == 11) {
            this.menu.setSelectedIndex(null);
        }
        if ((menuItemIndex = this.menu.getLastMenuItem()) != null) {
            this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
            return 0;
        }
        menuLogCh.log(-1601830656, "MenuSDSEventHandler#gotoLastPage: invalid, because menu is empty");
        return 1;
    }

    private int readLineAbsolute(int n) {
        MenuItemIndex menuItemIndex = this.findRowInMenu(n);
        if (menuItemIndex == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#readLineAbsolute: invalid, because menu doesn't contain row %1", (long)n);
            return 1;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#readLineAbsolute: found item %1 for absolute row %2", (Object)menuItemIndex, (long)n);
        this.menu.setSelectedIndex(menuItemIndex);
        this.menu.relayout();
        this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
        this.notifyEnumerationModelRowAndStatus(menuItemIndex);
        return 0;
    }

    private int readLine(int n) {
        MenuViewport menuViewport = this.menu.getViewport();
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#readLine: row number: %2, current viewport: %1", (Object)menuViewport, (long)n);
        if (menuViewport.isEmpty()) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#readLine: invalid, because viewport is empty");
            return 1;
        }
        MenuItemIndex menuItemIndex = this.findRowInViewport(n);
        if (menuItemIndex == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#readLine: invalid, because viewport doesn't contain row %1", (long)n);
            return 1;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#readLine: found item %1 for relative row %3, viewport: %2", (Object)menuItemIndex, (Object)menuViewport, (long)n);
        this.menu.setSelectedIndex(menuItemIndex);
        this.menu.relayout();
        this.menu.focusItemImmediately(menuItemIndex, FocusAdvice.KEEP_POSITION);
        this.notifySDSEnumerationModelRow(n);
        this.notifySDSEnumerationModelStatus(menuItemIndex);
        return 0;
    }

    private MenuItemIndex findRowInViewport(int n) {
        MenuViewport menuViewport = this.menu.getViewport();
        return this.findRowItem(n, this.menu.iterator(menuViewport.start, menuViewport.end, true));
    }

    private int readLineById(int n) {
        MenuItemIndex menuItemIndex = this.findRowItemById(n, this.menu.iterator(this.menu.getFirstMenuItem(), true, true));
        if (menuItemIndex == null) {
            menuLogCh.log(-1601830656, "MenuSDSEventHandler#readLineById: invalid, because menu doesn't contain widgetId %1", (long)n);
            return 1;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#readLineById: found item %1 for widgetId %2", (Object)menuItemIndex, (long)n);
        this.menu.setSelectedIndex(menuItemIndex);
        this.menu.relayout();
        this.notifyEnumerationModelRowAndStatus(menuItemIndex);
        return 0;
    }

    public boolean isSdsActive() {
        return this.sdsActive;
    }

    public void setSdsActive(boolean bl) {
        if (this.sdsActive == bl) {
            return;
        }
        this.sdsActive = bl;
        if (this.sdsActive && this.menu.isConnected()) {
            this.viewportUpdated(true);
        }
    }

    private ChoiceModelApp getSdsEnumerationModel() {
        if (this.sdsEnumerationModel == null) {
            int n = 242;
            this.sdsEnumerationModel = (ChoiceModelApp)((Object)this.getModel(n));
            if (this.sdsEnumerationModel == null) {
                menuLogCh.log(10000, "MenuSDSEventHandler#getSdsEnumerationModel: model SDS_ENUMERATION_NUMBER_CHOICE (%1) not available", (long)n);
            }
        }
        return this.sdsEnumerationModel;
    }

    private ChoiceModelApp getSdsLineNumberChoiceModel() {
        int n = 252;
        ChoiceModelApp choiceModelApp = (ChoiceModelApp)((Object)this.getModel(n));
        if (choiceModelApp == null) {
            menuLogCh.log(10000, "MenuSDSEventHandler#getSdsLineNumberChoiceModel: model SDS_LINE_NUMBER_CHOICE (%1) not available", (long)n);
        }
        return choiceModelApp;
    }

    private LabelModelApp getSdsLineNumberLabelModel() {
        int n = 548;
        LabelModelApp labelModelApp = (LabelModelApp)((Object)this.getModel(n));
        if (labelModelApp == null) {
            menuLogCh.log(10000, "MenuSDSEventHandler#getSdsLineNumberLabelModel: model SDS_LINE_NUMBER_LABEL (%1) not available", (long)n);
        }
        return labelModelApp;
    }

    private ChoiceModelApp getSdsPageNumberModel() {
        int n = 550;
        ChoiceModelApp choiceModelApp = (ChoiceModelApp)((Object)this.getModel(n));
        if (choiceModelApp == null) {
            menuLogCh.log(10000, "MenuSDSEventHandler#getSdsPageNumberModel: model SDS_PAGE_NUMBER_CHOICE (%1) not available", (long)n);
        }
        return choiceModelApp;
    }

    private HMIModel getModel(int n) {
        return AbstractWidget.hmiService.getModel(this.menu.getTerminal().getTerminalID(), n);
    }

    @Override
    public void viewportUpdated(boolean bl) {
        if (!this.sdsActive) {
            return;
        }
        MenuViewport menuViewport = this.menu.getViewport();
        int n = 0;
        if (!menuViewport.isEmpty()) {
            Iterator iterator = this.menu.iterator(this.menu.getViewport().start, this.menu.getViewport().end, true);
            while (iterator.hasNext()) {
                MenuItemIndex menuItemIndex = (MenuItemIndex)iterator.next();
                if (!this.isSdsItem(menuItemIndex)) continue;
                ++n;
            }
        }
        this.notifyPageRowsModel(n);
        this.notifyPageNumbersModel(this.getValueForPageNumbersModel(menuViewport));
    }

    private int getValueForPageNumbersModel(MenuViewport menuViewport) {
        if (menuViewport.isEmpty()) {
            return -1;
        }
        boolean bl = this.menu.iterator(menuViewport.start, false, false).hasNext();
        boolean bl2 = this.menu.iterator(menuViewport.end, true, false).hasNext();
        if (!bl && !bl2) {
            return 0;
        }
        if (!bl) {
            return 1;
        }
        if (!bl2) {
            return 3;
        }
        return 2;
    }

    private void notifyPageRowsModel(int n) {
        ChoiceModelApp choiceModelApp = this.getSdsLineNumberChoiceModel();
        if (choiceModelApp != null) {
            if (choiceModelApp.getValue() == n) {
                menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifyPageRowsModel: don't call model SDS_LINE_NUMBER_CHOICE (%2), because value is already correct: %1", (long)n, (long)choiceModelApp.getID());
            } else {
                menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifyPageRowsModel: set value %1 at model SDS_LINE_NUMBER_CHOICE (%2)", (long)n, (long)choiceModelApp.getID());
                choiceModelApp.setValue(n);
            }
        }
        LabelModelApp labelModelApp = this.getSdsLineNumberLabelModel();
        String string = "?";
        if (labelModelApp != null) {
            if (string.equals(labelModelApp.getText())) {
                menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifyPageRowsModel: don't call model SDS_LINE_NUMBER_LABEL (%2), because value is already correct: '%1'", (Object)string, (long)labelModelApp.getID());
            } else {
                menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifyPageRowsModel: set value '%1' at model SDS_LINE_NUMBER_LABEL (%2)", (Object)string, (long)labelModelApp.getID());
                labelModelApp.setText(string);
            }
        }
    }

    private void notifyPageNumbersModel(int n) {
        ChoiceModelApp choiceModelApp = this.getSdsPageNumberModel();
        if (choiceModelApp == null) {
            return;
        }
        if (choiceModelApp.getValue() == n) {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifyPageNumbersModel: don't call model SDS_PAGE_NUMBER_CHOICE (%2), because value is already correct: %1", (long)n, (long)choiceModelApp.getID());
            return;
        }
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#notifyPageNumbersModel: set value %1 at SDS_PAGE_NUMBER_CHOICE (%2) model", (long)n, (long)choiceModelApp.getID());
        choiceModelApp.setValue(n);
    }

    @Override
    public void menuLayouted() {
    }

    public void keyPressedOnMenuItem(KeyEvent keyEvent, MenuItemIndex menuItemIndex) {
        if (AbstractWidget.sdsService == null || !AbstractWidget.sdsService.isSDSActive()) {
            return;
        }
        if (this.menu.isEnabled(menuItemIndex)) {
            this.notifyEnumerationModelRowAndStatus(menuItemIndex);
            this.callSdsServiceOnKeyPress(keyEvent, menuItemIndex);
        } else {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#keyPressedOnMenuItem: item %1 is disabled, ignore keyPress", (Object)menuItemIndex);
            keyEvent.setSdsAction(3);
            keyEvent.consume(false);
        }
    }

    private void callSdsServiceOnKeyPress(KeyEvent keyEvent, MenuItemIndex menuItemIndex) {
        int n = this.getSdsItemSelectedAction(menuItemIndex);
        menuLogCh.log(-2137614336, "MenuSDSEventHandler#callSdsServiceOnKeyPress: keyPress on item %1 with SDS Action %2", (Object)menuItemIndex, (long)n);
        if (n == 1) {
            keyEvent.setSdsAction(n);
        } else if (n == 2) {
            keyEvent.consume();
            keyEvent.setSdsAction(n);
            this.sendKeyPressedToSdsService(menuItemIndex);
        } else if (n == 3) {
            keyEvent.setSdsAction(n);
        }
    }

    private void sendKeyPressedToSdsService(MenuItemIndex menuItemIndex) {
        if (AbstractWidget.sdsService == null) {
            menuLogCh.log(10000, "MenuSDSEventHandler#sendKeyPressedToSdsService: sdsService is not present, cannot call itemSelected for item %1", (Object)menuItemIndex);
            return;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.menu.getChild(menuItemIndex.widget);
        int n = abstractWidgetController.getModelID();
        if (abstractWidgetController instanceof ListController) {
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#sendKeyPressedToSdsService: list item %1 was selected on listmodel %2. ", (Object)menuItemIndex, (long)n);
            AbstractWidget.sdsService.itemSelected(n, menuItemIndex.widgetPart);
        } else {
            int n2 = abstractWidgetController instanceof MenuItemController ? ((MenuItemController)abstractWidgetController).getSdsCommand() : -1;
            menuLogCh.log(-2137614336, "MenuSDSEventHandler#sendKeyPressedToSdsService: item %1 was selected with modelID: %2, sdsCommand: %3", (Object)menuItemIndex, (long)n, (long)n2);
            AbstractWidget.sdsService.keyTyped(n, n2);
        }
    }

    private int getSdsItemSelectedAction(MenuItemIndex menuItemIndex) {
        AbstractWidget abstractWidget = this.menu.getChild(menuItemIndex.widget);
        if (abstractWidget instanceof IMenuItemMultiLine) {
            return ((IMenuItemMultiLine)((Object)abstractWidget)).getSdsItemSelectedAction(menuItemIndex.widgetPart);
        }
        if (abstractWidget instanceof IMenuItemMultiItem) {
            return ((IMenuItemMultiItem)((Object)abstractWidget)).getSdsItemSelectedAction(menuItemIndex.widgetPart);
        }
        if (abstractWidget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)abstractWidget)).getSdsItemSelectedAction();
        }
        menuLogCh.log(10000, "MenuSDSEventHandler#getSdsItemSelectedAction: widget %1 is not a correct IMenuItem: %2", (Object)menuItemIndex, (Object)abstractWidget);
        return 0;
    }

    @Override
    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    @Override
    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    @Override
    public void menuFocusChangeFinished() {
    }

    @Override
    public void setActiveMenuController(MenuController menuController) {
    }

    @Override
    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }
}

