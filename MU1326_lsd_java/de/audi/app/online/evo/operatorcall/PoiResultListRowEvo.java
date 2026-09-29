/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.operatorcall;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.online.app.operatorcall.data.AbstractHistoryCallData;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.NavigationHandler;
import org.dsi.ifc.online.OperatorCallResult;

public class PoiResultListRowEvo
extends PoiResultListRow {
    protected static final int COLUMN_CATEGORY;

    public PoiResultListRowEvo(OperatorCallResult operatorCallResult, NavigationHandler navigationHandler, AbstractHistoryCallData abstractHistoryCallData) {
        super(operatorCallResult, navigationHandler, abstractHistoryCallData);
    }

    public PoiResultListRowEvo(PoiResultListRow poiResultListRow) {
        super(poiResultListRow);
    }

    @Override
    public void createPropertyListCell() {
        this.setPropertyCell(4, new PropertyListCell(-299048008, new int[0]));
    }

    @Override
    public int getCategory() {
        PropertyListCell propertyListCell = (PropertyListCell)this.getCell(4);
        return propertyListCell.getCategory();
    }

    @Override
    public EvoListRow copy() {
        this.logChannel.log(-2137614336, "PoiResultListRowEvo#copy: called!");
        return new PoiResultListRowEvo(this);
    }
}

