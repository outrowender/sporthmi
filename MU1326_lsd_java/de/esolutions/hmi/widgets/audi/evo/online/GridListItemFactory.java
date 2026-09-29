/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.online.GridWidgetFactory;
import de.esolutions.hmi.widgets.audi.evo.online.WidgetUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

public class GridListItemFactory
extends GridWidgetFactory
implements ListItemFactory {
    public GridListItemFactory(int n, AbstractScreenFactory abstractScreenFactory) {
        super(n, abstractScreenFactory);
    }

    @Override
    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
        if (listCellArray == null || listCellArray.length != 1) {
            int n2 = listCellArray == null ? 0 : listCellArray.length;
            log.log(10000, "GridListItemFactory#createListItem: No line will be rendered. Exactly one model row must be given, but length=%2, modelRowArray=%1,", (Object)listCellArray, (long)n2);
            return this.createListItemNoData();
        }
        ListCell listCell = listCellArray[0];
        if (!(listCell instanceof ObjectListCell)) {
            log.log(10000, "GridListItemFactory#createListItem: modelRow[0] contains no ObjectListCell container! No line will be rendered. listCell=%1", (Object)listCell);
            return this.createListItemNoData();
        }
        ObjectListCell objectListCell = (ObjectListCell)listCell;
        Object object = objectListCell.getValue();
        if (!(object instanceof GridListRow)) {
            log.log(10000, "GridListItemFactory#createListItem: ObjectListCell container contains no instance of GridListRow! No line will be rendered. rowObject=%1", object);
            return this.createListItemNoData();
        }
        GridListRow gridListRow = (GridListRow)object;
        IGrid iGrid = gridListRow.getGrid();
        if (iGrid == null) {
            log.log(10000, "GridListItemFactory#createListItem: GridListRow contains no grid! No line will be rendered.");
            return this.createListItemNoData();
        }
        IGrid iGrid2 = WidgetUtilities.getLayoutedGrid(iGrid, GridListRow.calculateLayoutType(n));
        if (iGrid2 == null) {
            iGrid2 = iGrid;
        }
        int n3 = (int)gridListRow.getUniqueID();
        MenuItemController menuItemController = this.createMenuItem(n3);
        menuItemController.setEnabled(iGrid.isEnabled());
        log.log(-2137614336, "GridListItemFactory#createListItem: menuitem: %1, enabled: %2, grid enalbed: %3", (Object)iGrid.getId(), (Object)Boolean.toString(menuItemController.isEnabled()), (Object)Boolean.toString(iGrid.isEnabled()));
        if (iGrid.getInfoText() != null) {
            menuItemController.setInfolineTextDisabled(iGrid.getInfoText());
        }
        GridLayout gridLayout = this.createLayoutWithWidgets(iGrid2, null, menuItemController, n3, null, false);
        menuItemController.setLayoutManager(gridLayout);
        return menuItemController;
    }

    @Override
    public AbstractWidgetController createListItemNoData() {
        return null;
    }
}

