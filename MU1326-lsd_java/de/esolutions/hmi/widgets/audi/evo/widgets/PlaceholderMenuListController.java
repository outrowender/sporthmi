/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuListManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.BaseListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.DefaultTiledListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.OldListModelAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceholderMenuListController
extends AbstractWidgetController
implements PlaceholderMenuMultiItem,
PlaceholderMenuListManager {
    private PlaceholderMenuListManager listManager;
    private ListItemFactory listItemFactory;
    private int idColumn = -1;
    private int recordSetColumn = -1;
    private int enabledCoulumn = -1;
    private final Map recordSetWidgets = new HashMap();
    private PlaceholderMenuListController subMenuListController;
    private static final LogChannel LC;
    private IListWidgetDataAccess dataAccess;
    private static final int INDEX_LABEL;
    private static final int[] ICON_INDICES;
    private int sdsItemSelectedAction = 0;
    private int widgetID = -1;

    @Override
    public void add(AbstractWidget abstractWidget) {
        super.add(abstractWidget);
        if (abstractWidget instanceof PlaceholderMenuListController) {
            this.subMenuListController = (PlaceholderMenuListController)abstractWidget;
        }
    }

    private boolean checkDataAccess() {
        if (this.dataAccess == null) {
            listLogCh.log(10000, "PlaceholderMenuListController#checkDataAccess: no data access set. Model: %1", this.model);
            return false;
        }
        return true;
    }

    private boolean checkSubMenuController() {
        if (this.subMenuListController == null) {
            LC.log(10000, "PlaceholderMenuListController#checkSubMenuController: no sub list controller available. Model: %1", this.model);
            return false;
        }
        return true;
    }

    @Override
    public int getSubItemCount() {
        if (this.subMenuListController == null) {
            LC.log(-2137614336, "PlaceholderMenuListController#getSubItemCount No sublist");
            return 0;
        }
        return this.subMenuListController.getMultiItemCount();
    }

    @Override
    public boolean isMultiItem() {
        return true;
    }

    @Override
    public boolean isSubItem() {
        return false;
    }

    @Override
    public boolean isSelected() {
        if (!this.checkDataAccess()) {
            return false;
        }
        return this.dataAccess.getSelectedIndex() != -1;
    }

    @Override
    public boolean isSubSelection() {
        return false;
    }

    @Override
    public String getLabelText() {
        LC.log(-1601830656, "PlaceholderMenuListController#getLabelText MultiItem has no text.");
        return null;
    }

    @Override
    public void itemFocused() {
        LC.log(-1601830656, "PlaceholderMenuListController#itemFocused MultiItem cannot be focused.");
    }

    @Override
    public Object getIconData(int n) {
        LC.log(-1601830656, "PlaceholderMenuListController#getIconData MultiItem does not have icons.");
        return null;
    }

    @Override
    public int getMultiItemCount() {
        return this.getListModelLength();
    }

    private int getListModelLength() {
        if (!this.checkDataAccess()) {
            return 0;
        }
        return this.dataAccess.getLength();
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    @Override
    public boolean hasSubList() {
        return this.subMenuListController != null;
    }

    @Override
    public boolean isSelected(int n, int n2) {
        if (n2 == -1) {
            return this.isSelected(n);
        }
        if (!this.checkSubMenuController()) {
            return false;
        }
        return this.subMenuListController.isSelected(n2, -1);
    }

    private boolean isSelected(int n) {
        if (n == -1) {
            return false;
        }
        int n2 = this.getSelection();
        return n2 == n;
    }

    private int getSelection() {
        if (!this.checkDataAccess()) {
            return -1;
        }
        return this.dataAccess.getSelectedIndex();
    }

    @Override
    public boolean isVisible(int n, int n2) {
        if (n2 == -1) {
            return this.isVisible(n);
        }
        if (!this.checkSubMenuController()) {
            return false;
        }
        return this.subMenuListController.isVisible(n2, -1);
    }

    private boolean isVisible(int n) {
        return true;
    }

    @Override
    public boolean isEnabled(int n, int n2) {
        if (n2 == -1) {
            return this.isEnabled(n);
        }
        if (!this.checkSubMenuController()) {
            return false;
        }
        return this.subMenuListController.isEnabled(n2, -1);
    }

    private boolean isEnabled(int n) {
        if (this.enabledCoulumn == -1) {
            return true;
        }
        Object object = this.getRow(n);
        if (object == null) {
            return false;
        }
        int n2 = this.getIntegerCellValue(object, this.enabledCoulumn, "enabled");
        return n2 > 0;
    }

    @Override
    public void setParent(AbstractWidget abstractWidget) {
        super.setParent(abstractWidget);
        if (abstractWidget instanceof PlaceholderMenuListManager) {
            this.listManager = (PlaceholderMenuListManager)((Object)abstractWidget);
        }
        this.initializeDataAccess();
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        listLogCh.log(-2137614336, "PlaceholderMenuListController#processModelUpdateEvent: received model update. event: %1", (Object)modelUpdateEvent);
        if (this.dataAccess != null) {
            this.dataAccess.processModelUpdateEvent(modelUpdateEvent);
        }
        if (this.listManager != null) {
            this.listManager.listModelChanged(this, modelUpdateEvent);
        }
    }

    @Override
    public int getMainSelection() {
        return this.getSelection();
    }

    @Override
    public int getSubSelection() {
        if (!this.checkSubMenuController()) {
            return -1;
        }
        return this.subMenuListController.getMainSelection();
    }

    public String toString() {
        return new StringBuffer().append("PlaceholderMenuListController [listManager=").append(this.listManager).append(", modelID=").append(this.modelID).append("]").toString();
    }

    @Override
    public void itemSelected(int n, int n2) {
        LC.log(-2137614336, "PlaceholderMenuListController#itemSelected %1, %2", (long)n, (long)n2);
        if (n2 == -1) {
            this.itemSelected(n);
            return;
        }
        if (!this.checkSubMenuController()) {
            LC.log(10000, "PlaceholderMenuListController#itemSelected No sub menu controller");
            return;
        }
        this.subMenuListController.itemSelected(n2, -1);
    }

    private void itemSelected(int n) {
        if (!this.checkDataAccess()) {
            return;
        }
        Long l = this.dataAccess.getUniqueIDForItemIndex(n);
        if (l == null) {
            LC.log(10000, "PlaceholderMenuListController#itemSelected could not get unique id for index %1, Model %2", (Object)Util.createInteger(n), this.model);
            return;
        }
        this.dataAccess.itemSelected(l, n);
    }

    public void setRecordSetColumn(int n) {
        this.recordSetColumn = n;
    }

    public void setIdColumn(int n) {
        this.idColumn = n;
        this.initializeDataAccess();
    }

    public void setItemFactory(ListItemFactory listItemFactory) {
        this.listItemFactory = listItemFactory;
    }

    public PlaceholderMenuListManager getListManager() {
        return this.listManager;
    }

    @Override
    public void setListManager(PlaceholderMenuListManager placeholderMenuListManager) {
        this.listManager = placeholderMenuListManager;
    }

    public int getIdColumn() {
        return this.idColumn;
    }

    public int getRecordSetColumn() {
        return this.recordSetColumn;
    }

    @Override
    public String getLabelText(int n, int n2) {
        if (n2 == -1) {
            return this.getLabelText(n);
        }
        if (!this.checkSubMenuController()) {
            return null;
        }
        return this.subMenuListController.getLabelText(n2, -1);
    }

    @Override
    public Object getIconData(int n, int n2, int n3) {
        if (n2 == -1) {
            int n4 = ICON_INDICES[n3];
            return this.getImageData(n, n4);
        }
        if (!this.checkSubMenuController()) {
            return null;
        }
        return this.subMenuListController.getIconData(n2, -1, n3);
    }

    private Object getRow(int n) {
        if (!this.checkDataAccess()) {
            return null;
        }
        return this.dataAccess.getRow(n);
    }

    private String getLabelText(int n) {
        ListCell[] listCellArray;
        if (!this.checkDataAccess()) {
            return null;
        }
        int n2 = this.dataAccess.getLength();
        if (n >= n2) {
            LC.log(10000, "PlaceholderMenuListController#getLabelText: Row %1 is out of range (%2)", (long)n, (long)n2);
            return null;
        }
        Object object = this.getRow(n);
        if (object == null) {
            LC.log(10000, "PlaceholderMenuListController#getLabelText: Could not get row %1", (long)n);
            return null;
        }
        int n3 = this.getRecordSetForRow(object);
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.recordSetWidgets.get(Util.createInteger(n3));
        if (abstractWidgetController != null) {
            return this.getTextFromLayout(abstractWidgetController, object);
        }
        if (object instanceof ListCell[]) {
            listCellArray = (ListCell[])object;
        } else if (object instanceof GuiListRow) {
            listCellArray = new ListCell[]{new ObjectListCell(object)};
        } else {
            LC.log(10000, "PlaceholderMenuListController#getLabelText row is not of type ListCell[] or GuiListRow: %1", object);
            listCellArray = null;
        }
        AbstractWidgetController abstractWidgetController2 = this.listItemFactory.createListItem(n3, listCellArray);
        if (abstractWidgetController2 == null) {
            LC.log(-1601830656, "PlaceholderMenuListController#getLabelText: Could not create list item for row %1 and record set %2", (long)n, (long)n3);
            return null;
        }
        this.initializeLayoutController(abstractWidgetController2);
        this.recordSetWidgets.put(Util.createInteger(n3), abstractWidgetController2);
        this.add(abstractWidgetController2);
        return this.getTextFromLayout(abstractWidgetController2, object);
    }

    private Object getImageData(int n, int n2) {
        ListCell[] listCellArray;
        if (!this.checkDataAccess()) {
            return null;
        }
        Object object = this.dataAccess.getRow(n);
        if (object == null) {
            LC.log(10000, "PlaceholderMenuListController#getImageData: Could not get row %1", (long)n);
            return null;
        }
        int n3 = this.getRecordSetForRow(object);
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)this.recordSetWidgets.get(Util.createInteger(n3));
        if (abstractWidgetController != null) {
            return this.getImageDataFromLayout(abstractWidgetController, object, n2);
        }
        if (object instanceof ListCell[]) {
            listCellArray = (ListCell[])object;
        } else if (object instanceof GuiListRow) {
            listCellArray = new ListCell[]{new ObjectListCell(object)};
        } else {
            LC.log(10000, "PlaceholderMenuListController#getImageData row is not of type ListCell[] or GuiListRow: %1", object);
            listCellArray = null;
        }
        AbstractWidgetController abstractWidgetController2 = this.listItemFactory.createListItem(n3, listCellArray);
        if (abstractWidgetController2 == null) {
            LC.log(-1601830656, "PlaceholderMenuListController#getImageData: Could not create list item for row %1 and record set %2", (long)n, (long)n3);
            return null;
        }
        this.initializeLayoutController(abstractWidgetController2);
        this.recordSetWidgets.put(Util.createInteger(n3), abstractWidgetController2);
        this.add(abstractWidgetController2);
        return this.getImageDataFromLayout(abstractWidgetController2, object, n2);
    }

    private void initializeLayoutController(AbstractWidgetController abstractWidgetController) {
        List list = abstractWidgetController.getChildren();
        if (list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)list.get(i2);
            if (abstractWidgetController2 instanceof LabelController) {
                ((LabelController)abstractWidgetController2).setRenderer(null);
                continue;
            }
            if (abstractWidgetController2 instanceof IconController) {
                ((IconController)abstractWidgetController2).setRenderer(null);
                continue;
            }
            LC.log(-1601830656, "PlaceholderMenuListController#initializeLayoutController Unknown widget at index %1 in %2: %3", (Object)Util.createInteger(i2), (Object)this, (Object)abstractWidgetController2);
        }
    }

    private String getTextFromLayout(AbstractWidgetController abstractWidgetController, Object object) {
        if (abstractWidgetController.getChildrenSize() < 3) {
            LC.log(10000, "PlaceholderMenuListController#getTextFromLayout: 3 children needed, found %1", (long)abstractWidgetController.getChildrenSize());
            return null;
        }
        AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)abstractWidgetController.getChild(1);
        LC.log(-2137614336, "PlaceholderMenuListController#getTextFromLayout: child: %1", (Object)abstractWidgetController2);
        if (!(abstractWidgetController2 instanceof LabelController)) {
            LC.log(10000, "PlaceholderMenuListController#getTextFromLayout: child at index %1 has to be a label, found: %2", (Object)Util.createInteger(1), (Object)abstractWidgetController2);
            return null;
        }
        LabelController labelController = (LabelController)abstractWidgetController2;
        LC.log(-2137614336, "PlaceholderMenuListController#getTextFromLayout: label: %1 labelText: %2", (Object)labelController, (Object)labelController.getText());
        int n = labelController.getModelColumn();
        String string = StringUtility.getTextOrientationHintString(4, this.isLTR());
        LC.log(-2137614336, "PlaceholderMenuListController#getTextFromLayout: label.getModelColumn(): %1", (long)labelController.getModelColumn());
        Object object2 = this.getCell(object, n);
        Object object3 = this.calculateCellContent(labelController, object2);
        if (object3 == null) {
            return null;
        }
        if (object3 instanceof String) {
            LC.log(-2137614336, "PlaceholderMenuListController#getTextFromLayout: get String content from model: %1", object3);
            return this.textReplacement((String)object3, abstractWidgetController, object, string);
        }
        LC.log(10000, "PlaceholderMenuListController#getTextFromLayout: Unsupported content in cell: %1", object2);
        return null;
    }

    private String textReplacement(String string, AbstractWidgetController abstractWidgetController, Object object, String string2) {
        Object object2;
        ArrayList arrayList = new ArrayList();
        LC.log(-2137614336, "SelectionMenuRendererHigh#textReplacement subItemCount: %1", (long)abstractWidgetController.getChildrenSize());
        for (int i2 = 3; i2 < abstractWidgetController.getChildrenSize(); ++i2) {
            object2 = abstractWidgetController.getChild(i2);
            if (!(object2 instanceof LabelController)) continue;
            LabelController labelController = (LabelController)object2;
            int n = labelController.getModelColumn();
            LC.log(-2137614336, "PlaceholderMenuListController#textReplacement: label.getModelColumn(): %1", (long)labelController.getModelColumn());
            Object object3 = this.getCell(object, n);
            Object object4 = this.calculateCellContent(labelController, object3);
            arrayList.add(object4);
            LC.log(-2137614336, "SelectionMenuRendererHigh#textReplacement for replacementText: %1", object4);
        }
        if (!arrayList.isEmpty()) {
            Object[] objectArray = new String[arrayList.size()];
            arrayList.toArray(objectArray);
            object2 = StringUtilities.formatMessage(string, (String[])objectArray, string2);
            LC.log(-2137614336, "SelectionMenuRendererHigh#textReplacement result: %1", object2);
            return object2;
        }
        LC.log(-2137614336, "SelectionMenuRendererHigh#textReplacement  no replacementTexts");
        return string;
    }

    private Object getImageDataFromLayout(AbstractWidgetController abstractWidgetController, Object object, int n) {
        if (LC.isDebug()) {
            LC.log(-2137614336, "PlaceholderMenuListController#getImageDataFromLayout widget %1 not found in %2, row=%3", (Object)Util.createInteger(n), (Object)this, object);
        }
        if (abstractWidgetController.getChildrenSize() <= n) {
            LC.log(10000, "PlaceholderMenuListController#getImageDataFromLayout widget %1 not found in %2", (Object)Util.createInteger(n), (Object)this);
            return null;
        }
        AbstractWidgetController abstractWidgetController2 = (AbstractWidgetController)abstractWidgetController.getChild(n);
        if (!(abstractWidgetController2 instanceof IconController)) {
            LC.log(10000, "PlaceholderMenuListController#getImageDataFromLayout widget %1 (%2) is not an IconController in %3", (Object)Util.createInteger(n), (Object)abstractWidgetController2, (Object)this);
            return null;
        }
        IconController iconController = (IconController)abstractWidgetController2;
        int n2 = iconController.getModelColumn();
        if (n2 == -1) {
            return Util.createInteger(iconController.getBitmap(0));
        }
        Object object2 = this.getCell(object, n2);
        Object object3 = null;
        if (object2 instanceof HMIResourceLocator) {
            HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object2;
            if (hMIResourceLocator.getStatus() == 1) {
                object3 = Util.createInteger(0);
            } else if (!hMIResourceLocator.containsResourceURI() && iconController.getDefaultImageMode() == 1) {
                object3 = Util.createInteger(hMIResourceLocator.getResourceID());
            }
        }
        if (object3 == null) {
            object3 = this.calculateCellContent(iconController, object2);
        }
        if (object3 == null) {
            LC.log(10000, "PlaceholderMenuListController#getImageDataFromLayout widget %1 (%2) has no content in %3", (Object)Util.createInteger(n), (Object)abstractWidgetController2, (Object)this);
            return null;
        }
        if (object3 instanceof Integer) {
            int n3 = (Integer)object3;
            if (n3 == -1) {
                LC.log(10000, "PlaceholderMenuListController#getImageDataFromLayout widget %1 (%2) has content NONE in %3", (Object)Util.createInteger(n), (Object)abstractWidgetController2, (Object)this);
                return null;
            }
            return Util.createInteger(iconController.getBitmap(n3));
        }
        return object3;
    }

    private Object calculateCellContent(AbstractWidgetController abstractWidgetController, Object object) {
        if (object == null || abstractWidgetController == null) {
            return null;
        }
        abstractWidgetController.setModel(object);
        LC.log(-2137614336, "PlaceholderMenuListController#calculateCellContent widget %1 setModel %2", (Object)abstractWidgetController, object);
        ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent(null, 10301, -1, -1, 1, -1, -1);
        abstractWidgetController.processModelUpdateEvent(modelUpdateEvent);
        if (abstractWidgetController instanceof IconController) {
            return ((IconController)abstractWidgetController).getContent();
        }
        if (abstractWidgetController instanceof LabelController) {
            return ((LabelController)abstractWidgetController).getText();
        }
        LC.log(10000, "PlaceholderMenuListController#calculateCellContent unsupported widget %1", (Object)abstractWidgetController);
        return null;
    }

    private int getRecordSetForRow(Object object) {
        if (this.recordSetColumn == -1) {
            return 0;
        }
        return this.getIntegerCellValue(object, this.recordSetColumn, "record set");
    }

    private Object getCell(Object object, int n) {
        if (n == -1) {
            return null;
        }
        if (!this.checkDataAccess()) {
            return null;
        }
        return this.dataAccess.getCell(object, n);
    }

    private int getIntegerCellValue(Object object, int n, String string) {
        Object object2 = this.getCell(object, n);
        if (object2 == null) {
            LC.log(10000, "PlaceholderMenuListController#getIntegerCellValue: %1 cell in column %2 is null.", (Object)string, (long)n);
            return -1;
        }
        if (object2 instanceof IntegerListCell) {
            return ((IntegerListCell)object2).getValue();
        }
        if (object2 instanceof Integer) {
            return (Integer)object2;
        }
        LC.log(10000, "PlaceholderMenuListController#getIntegerCellValue: %1 column %3 is not an integer, but: %2", (Object)string, (Object)object2.getClass(), (long)n);
        return -1;
    }

    @Override
    public AbstractWidgetController getWidget() {
        return this;
    }

    @Override
    public void listModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, ModelUpdateEvent modelUpdateEvent) {
        if (this.listManager != null) {
            this.listManager.subListModelChanged(this, placeholderMenuMultiItem, modelUpdateEvent);
        }
    }

    @Override
    public void subListModelChanged(PlaceholderMenuMultiItem placeholderMenuMultiItem, PlaceholderMenuMultiItem placeholderMenuMultiItem2, ModelUpdateEvent modelUpdateEvent) {
    }

    public void setEnabledColumn(int n) {
        this.enabledCoulumn = n;
    }

    @Override
    public PlaceholderMenuMultiItem getSubMenuMultiItem() {
        return this.subMenuListController;
    }

    public IListWidgetDataAccess getDataAccess() {
        return this.dataAccess;
    }

    public void setDataAccess(IListWidgetDataAccess iListWidgetDataAccess) {
        this.dataAccess = iListWidgetDataAccess;
        this.initializeDataAccess();
    }

    public void initializeDataAccess() {
        if (this.dataAccess == null) {
            this.dataAccess = this.createDataAccess();
            if (this.dataAccess == null) {
                return;
            }
        }
        if (this.model instanceof HMIModelGUI) {
            this.dataAccess.setModel((HMIModel)this.model);
        }
        if (this.parent != null) {
            int n = this.parent.getChildren().indexOf(this);
            if (n == -1) {
                n = this.parent.getChildren().size();
            }
            this.dataAccess.setListWidgetIndex(n);
        }
        if (this.dataAccess instanceof OldListModelAccess) {
            ((OldListModelAccess)this.dataAccess).setIdColumn(this.idColumn);
        }
    }

    private IListWidgetDataAccess createDataAccess() {
        if (this.model == null) {
            return null;
        }
        if (this.model instanceof TiledListModel) {
            return new DefaultTiledListModelAccess();
        }
        if (this.model instanceof BaseListModelApp) {
            return new BaseListModelAccess();
        }
        return this.createDefaultDataAccess();
    }

    private OldListModelAccess createDefaultDataAccess() {
        if (this.model instanceof ListModelGUI) {
            return new OldListModelAccess();
        }
        return null;
    }

    @Override
    public void setModel(Object object) {
        super.setModel(object);
        this.initializeDataAccess();
    }

    @Override
    public void setModel(HMIModelGUI hMIModelGUI) {
        super.setModel(hMIModelGUI);
        this.initializeDataAccess();
    }

    @Override
    public void disconnecting() {
        if (this.dataAccess != null) {
            this.dataAccess.disconnect();
        }
        super.disconnecting();
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        if (this.dataAccess == null) {
            this.dataAccess = this.createDefaultDataAccess();
            this.initializeDataAccess();
            listLogCh.log(-2137614336, "PlaceholderMenuListController#initializeWidget: create default DataAccess: %1", (Object)this.dataAccess);
        }
        if (this.dataAccess != null) {
            this.dataAccess.connect(this.initContext);
        }
    }

    @Override
    public int getSdsItemSelectedAction() {
        return this.sdsItemSelectedAction;
    }

    public void setSdsItemSelectedAction(int n) {
        this.sdsItemSelectedAction = n;
    }

    @Override
    public int getSdsCommand() {
        return -1;
    }

    @Override
    public int getInternalID() {
        return -1;
    }

    @Override
    public int getWidgetID() {
        return this.widgetID;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    @Override
    public boolean isLockable() {
        return false;
    }

    static {
        ICON_INDICES = new int[]{0, 2, 3, 4};
        if (AbstractWidget.framework != null) {
            LC = logPlaceholderMenuListController;
        } else {
            LC = null;
            System.err.println("PlaceholderMenuListController: Warning: no framework available");
        }
    }
}

