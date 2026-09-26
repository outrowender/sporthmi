/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.listener.ContentEnabledListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfolineTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubElementMenuController
extends MenuItemController
implements ContentEnabledListener {
    private LabelController label;
    private ComboBoxController comboBox;
    private Map visibilityMap;
    public static final int CHAIN_ALL_ACTIONS;
    public static final int CHAIN_ALL_TRIGGER;
    private int maxShownEntries = -1;
    private boolean keyWasPressedToOpenAudiConnect = false;

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public List getVisibleMenuItems() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < this.getChildrenSize(); ++i2) {
            if (!(this.getChild(i2) instanceof MenuItemController) || !this.getChild(i2).isVisible()) continue;
            arrayList.add(this.getChild(i2));
        }
        return arrayList;
    }

    public List getAllMenuItems() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
            if (!(this.getChild(i2) instanceof MenuItemController)) continue;
            arrayList.add(this.getChild(i2));
        }
        return arrayList;
    }

    public boolean hasSubElements() {
        return this.getVisibleMenuItems().size() > 1;
    }

    private int[] getSubElementTextIDs() {
        List list = this.getAllMenuItems();
        if (list.isEmpty()) {
            return null;
        }
        int[] nArray = new int[list.size() - 1];
        for (int i2 = 1; i2 < list.size(); ++i2) {
            nArray[i2 - 1] = ((MenuItemController)list.get(i2)).getLabelId();
        }
        return nArray;
    }

    private int getLabelTextID() {
        if (this.getVisibleMenuItems().size() == 1) {
            return ((MenuItemController)this.getVisibleMenuItems().get(0)).getLabelId();
        }
        return ((MenuItemController)this.getAllMenuItems().get(0)).getLabelId();
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (this.label == null) {
            this.label = this.createLabel(this.getLabelTextID());
            this.add(this.label);
        }
        if (this.comboBox == null) {
            this.comboBox = this.createComboBox(this.getLabelTextID(), this.getSubElementTextIDs());
            this.add(this.comboBox);
        }
        MenuItemController menuItemController = (MenuItemController)this.getTopItem();
        AxisConstraints axisConstraints = new AxisConstraints(2);
        axisConstraints.grow = new float[]{0.0f, 1.0f};
        axisConstraints.shrink = new float[]{1.0f, 1.0f};
        axisConstraints.gaps = new int[]{0, 0, 0};
        axisConstraints.tabulatorIDs = new int[]{-1, -1, -1};
        AxisConstraints axisConstraints2 = new AxisConstraints(1);
        axisConstraints2.alignment = new int[]{7};
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumnConstraints(axisConstraints);
        gridLayout.setRowConstraints(axisConstraints2);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(1, 0);
        gridLayoutHints.ignoreForCellSizes = true;
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{new GridLayoutHints(0, 0), new GridLayoutHints(1, 0), gridLayoutHints}, new AbstractWidgetController[]{this.label, menuItemController, this.comboBox});
        this.setLayoutManager(gridLayout);
        LayoutContainerController.autoLayoutSetup(gridLayout);
        this.updateVisibility();
        for (int i2 = 1; i2 < this.getChildrenSize() - 1; ++i2) {
            if (!(this.getChild(i2) instanceof MenuItemController)) continue;
            this.processEnabledToCombobox((MenuItemController)this.getChild(i2));
        }
    }

    @Override
    protected void afterConnected() {
        super.afterConnected();
        MenuItemController menuItemController = (MenuItemController)this.getTopItem();
        GridLayout gridLayout = (GridLayout)menuItemController.getLayoutManager();
        ((AxisConstraints)gridLayout.getColumnConstraints()).gaps = null;
        ((AxisConstraints)gridLayout.getRowConstraints()).gaps = null;
        this.calculateNewLayout();
    }

    public SubElementMenuController() {
        this.setType(16);
    }

    private void updateMaxShownEntriesFromModel() {
        if (this.isRemoteHMISubElement()) {
            int n = ((ChoiceModelGUI)this.model).getValue();
            if (n < this.getChildrenSize()) {
                this.maxShownEntries = n;
            }
        } else {
            this.maxShownEntries = -1;
        }
    }

    private void updateChildVisibility() {
        if (this.maxShownEntries != -1) {
            if (this.comboBox != null && this.comboBox.getMenu() != null) {
                int n;
                MenuController menuController = this.comboBox.getMenu();
                int n2 = -1;
                int n3 = -1;
                for (n = 0; n < menuController.getChildrenSize(); ++n) {
                    if (menuController.getChild(n) instanceof MenuItemController && n2 == -1) {
                        n2 = n;
                    }
                    if (n2 == -1 || menuController.getChild(n) instanceof MenuItemController) continue;
                    n3 = n;
                }
                if (n3 == -1) {
                    n3 = n - 1;
                }
                int n4 = n2 + this.maxShownEntries;
                for (int i2 = n2; i2 <= n3; ++i2) {
                    if (i2 < n4) {
                        this.comboBox.getMenu().getChild(i2).setVisible(true);
                        continue;
                    }
                    this.comboBox.getMenu().getChild(i2).setVisible(false);
                }
            }
            this.calculateNewLayout();
        }
    }

    private void updateVisibility() {
        this.updateMaxShownEntriesFromModel();
        this.updateChildVisibility();
        this.syncVisibility();
        if (this.hasSubElements()) {
            this.label.setVisible(false);
            this.comboBox.setVisible(true);
            this.getTopItem().setVisible(true);
        } else {
            this.label.setTextIds(new int[]{this.getLabelTextID()});
            this.label.setVisible(true);
            this.comboBox.setVisible(false);
            this.getTopItem().setVisible(false);
        }
        this.label.updateContent();
        this.label.setCompositesDirty(true);
        this.comboBox.setCompositesDirty(true);
        this.setVisible(this.getVisibleMenuItems().size() > 0);
    }

    private AbstractWidget getTopItem() {
        return this.getChild(0);
    }

    private void syncVisibility() {
        if (this.visibilityMap == null) {
            this.visibilityMap = new HashMap();
        }
        Iterator iterator = this.visibilityMap.keySet().iterator();
        Integer n = null;
        Boolean bl = null;
        while (iterator.hasNext()) {
            try {
                n = (Integer)iterator.next();
                bl = (Boolean)this.visibilityMap.get(n);
                ((MenuItemController)this.getAllMenuItems().get(n)).setVisible(bl);
            }
            catch (Exception exception) {
                logChannel.log(10000, "SubElementMenuController#syncVisibility: invalid visibilityMap entry Key: %1 Value: %2.", (Object)n, bl);
            }
        }
    }

    private LabelController createLabel(int n) {
        LabelController labelController = new LabelController();
        labelController.setRenderer(((ExtHMITerminalEvo)((Object)this.terminal)).getRendererFactory().createLabelRenderer(labelController));
        labelController.setTextIds(new int[]{n});
        labelController.setChainedAction(3, 17);
        return labelController;
    }

    private ComboBoxController createComboBox(int n, int[] nArray) {
        ComboBoxController comboBoxController = new ComboBoxController(1);
        comboBoxController.setRenderer(((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).getRendererFactory().createComboRenderer(comboBoxController, this.renderer));
        comboBoxController.setTextIds(nArray);
        comboBoxController.setLabelTextID(n);
        comboBoxController.setChainedAction(3, 17);
        return comboBoxController;
    }

    private void processEnabledToCombobox(MenuItemController menuItemController) {
        int n = -1;
        for (int i2 = 1; i2 < this.getChildrenSize() - 1; ++i2) {
            if (!menuItemController.equals(this.getChild(i2))) continue;
            n = i2;
            break;
        }
        if (n != -1 && this.comboBox != null) {
            MenuController menuController = this.comboBox.getMenu();
            MenuItemController menuItemController2 = (MenuItemController)menuController.getChild(n + 1);
            menuItemController2.setEnabled(menuItemController.isEnabled());
        }
    }

    @Override
    public void setContentEnabled(int n, boolean bl) {
    }

    @Override
    public void setContentVisible(int n, boolean bl) {
        if (this.visibilityMap == null) {
            this.visibilityMap = new HashMap();
        }
        this.visibilityMap.put(Util.createInteger(n), bl);
        this.updateVisibility();
    }

    private int getModelStatus() {
        if (this.model != null) {
            return ((ChoiceModelGUI)this.model).getStatus();
        }
        return -1;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int n;
        if (keyEvent.getKeyCode() == 15) {
            if (this.comboBox.isOpen()) {
                keyEvent.consume();
                this.comboBox.close();
            }
            return;
        }
        this.updateVisibility();
        if (this.isRemoteHMISubElement() && keyEvent.getKeyCode() == 17 && (n = this.getModelStatus()) != 1) {
            if (n == 3) {
                this.keyWasPressedToOpenAudiConnect = true;
                ((ChoiceModelGUI)this.model).keyPressed(n, this.getTerminal().getTerminalID());
            } else {
                this.keyWasPressedToOpenAudiConnect = false;
            }
            return;
        }
        if (this.isEnabled()) {
            List list = this.getVisibleMenuItems();
            if (keyEvent.getKeyCode() == 17 && !this.comboBox.isOpen()) {
                if (this.comboBox.isVisible()) {
                    if (this.isRemoteHMISubElement()) {
                        this.synchronizeMenuItems();
                    }
                    this.comboBox.open();
                    keyEvent.consume();
                } else {
                    int n2 = list.size();
                    if (n2 == 1) {
                        ((MenuItemController)list.get(0)).keyPressed(keyEvent);
                    } else {
                        logChannel.log(10000, "SubElementMenuController#keyPressed: Expected 1 visible item, but found: %1.", (long)n2);
                    }
                }
            } else if (keyEvent.getKeyCode() == 17 && this.comboBox.isOpen()) {
                int n3 = this.comboBox.menuItemIndexToComboIndex(this.comboBox.getMenu().getFocusedIndex());
                ((MenuItemController)list.get(n3)).keyPressed(keyEvent);
                this.comboBox.close();
            }
        }
    }

    private boolean isRemoteHMISubElement() {
        if (this.model != null) {
            int n = ((ChoiceModelGUI)this.model).getID();
            return n == -2128607744 || n == 1847403264;
        }
        return false;
    }

    private InfolineTimerController getInfoLineTimer() {
        InfolineTimerController infolineTimerController = null;
        if (this.getParent() instanceof MenuController) {
            infolineTimerController = ((MenuController)this.getParent()).getInfolineTimer();
        }
        return infolineTimerController;
    }

    @Override
    public void setFocused(boolean bl) {
        super.setFocused(bl);
        if (this.isRemoteHMISubElement()) {
            this.setInfoLineTimerForRemoteHMI();
            if (!bl) {
                this.keyWasPressedToOpenAudiConnect = false;
            }
        }
    }

    private void setInfoLineTimerForRemoteHMI() {
        InfolineTimerController infolineTimerController = this.getInfoLineTimer();
        if (infolineTimerController != null) {
            int n = this.getModelStatus();
            if (n != 0) {
                infolineTimerController.setActive(true);
                infolineTimerController.restartTimer();
            } else {
                infolineTimerController.cancelTimer();
                infolineTimerController.setActive(false);
            }
        }
    }

    private void synchronizeMenuItems() {
        MenuController menuController = this.comboBox.getMenu();
        for (int i2 = 0; i2 < this.getChildrenSize() - 1; ++i2) {
            if (!(this.getChild(i2 + 1) instanceof MenuItemController)) continue;
            LabelController labelController = (LabelController)this.getChild(i2 + 1).getChildren().get(0);
            LabelController labelController2 = (LabelController)((MenuItemController)menuController.getChild(i2 + 2)).getChildren().get(0);
            labelController2.setText(labelController.getText());
            labelController2.setCompositesDirty(true);
        }
        menuController.setCompositesDirty(true);
        this.calculateNewLayout();
    }

    @Override
    protected String calculateInfolineContent() {
        return ((MenuItemController)this.getTopItem()).calculateInfolineContent();
    }

    private void calculateNewLayout() {
        MenuController menuController = this.comboBox.getMenu();
        int n = 0;
        for (int i2 = 1; i2 < this.getChildrenSize(); ++i2) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.getChild(i2);
            if (!menuController.isMenuItem(abstractWidgetController) || abstractWidgetController.getChildrenSize() <= 0 || !(abstractWidgetController.getChild(0) instanceof LabelController)) continue;
            MenuItemController menuItemController = (MenuItemController)abstractWidgetController;
            menuItemController.setMarginBottom(0);
            menuItemController.setGlassplateInsetsTop(0);
            LabelController labelController = (LabelController)abstractWidgetController.getChild(0);
            n = Math.max(n, labelController.getPreferredWidth());
        }
        Layout layout = ((HMITerminalImpl)menuController.getTerminal()).getLayout();
        int n2 = layout.getIntegerConstant(33);
        int n3 = layout.getIntegerConstant(32);
        int n4 = layout.getIntegerConstant(0);
        int n5 = Math.max(n4, n += n2 + n3);
        int n6 = layout.getIntegerConstant(75);
        int n7 = layout.getIntegerConstant(74);
        if (n5 > n6 && n6 != -1) {
            n5 = n6;
        } else if (n5 < n7 && n6 != -1) {
            n5 = n7;
        }
        menuController.setWidth(n5);
        menuController.relayout();
        menuController.setCompositesDirty(true);
        this.comboBox.updateScrollbarBounds();
        this.comboBox.doLayout();
    }

    @Override
    public void invalidateLayout(AbstractWidget abstractWidget) {
        super.invalidateLayout(abstractWidget);
        if (this.isConnectedSubtree() && abstractWidget != this.label) {
            this.updateVisibility();
        }
    }

    @Override
    public void setX(int n) {
        super.setX(n);
        if (this.comboBox != null) {
            this.comboBox.setCompositesDirty(true);
        }
    }

    @Override
    public void setY(int n) {
        super.setY(n);
        if (this.comboBox != null) {
            if (this.comboBox.isOpen()) {
                this.comboBox.prepareForOpen();
            }
            this.comboBox.setCompositesDirty(true);
        }
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        super.setBounds(n, n2, n3, n4);
        if (this.comboBox != null) {
            if (this.comboBox.isOpen()) {
                this.comboBox.prepareForOpen();
            }
            this.comboBox.setCompositesDirty(true);
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateMaxShownEntriesFromModel();
        if (this.isFocused() && this.getModelStatus() == 1 && this.comboBox.isVisible()) {
            this.updateVisibility();
            this.synchronizeMenuItems();
            if (this.keyWasPressedToOpenAudiConnect) {
                this.keyWasPressedToOpenAudiConnect = false;
                this.comboBox.open();
            }
            if (this.comboBox.isOpen()) {
                this.comboBox.calculateAndAnimateBackground();
            }
        }
        if (this.isRemoteHMISubElement()) {
            this.setInfoLineTimerForRemoteHMI();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public ComboBoxController getComboBox() {
        return this.comboBox;
    }

    @Override
    public void setEnabled(boolean bl) {
        if (this.comboBox != null) {
            this.comboBox.setEnabled(bl);
        }
        super.setEnabled(bl);
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        this.comboBox.reset();
        super.handleFocusChanged(n, n2, n3);
    }

    @Override
    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (!bl && this.isConnected() && this.comboBox.isOpen()) {
            this.comboBox.close();
        }
    }

    @Override
    public void disconnecting() {
        this.keyWasPressedToOpenAudiConnect = false;
        super.disconnecting();
    }

    public void childEnabledChanged(MenuItemController menuItemController) {
        if (menuItemController != this.getTopItem()) {
            this.processEnabledToCombobox(menuItemController);
            return;
        }
        this.setEnabled(menuItemController.isEnabled());
    }
}

