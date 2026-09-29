/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;

class ActiveDestinationsManager$ActiveDestRow
extends EvoListRow {
    public static final int ICON_ID_COLUMNS;
    public static final int DESTINATION_COLUMN;
    public static final int ADDITIONAL_INFO_COLUMN;
    public static final int ETA_COLUMN;
    public static final int DTD_COLUMN;
    public static final int PROPERTY_COLUMN;
    public static final int TEXT_INDEX_COLUMN;
    public static final int LAYOUT_COLUMN;
    public static final int MAX_LIST_COLUMNS;
    private final /* synthetic */ ActiveDestinationsManager this$0;

    public ActiveDestinationsManager$ActiveDestRow(ActiveDestinationsManager activeDestinationsManager, long l, String string, String string2, int n, AbstractMetrics abstractMetrics, AbstractMetrics abstractMetrics2, int n2) {
        this.this$0 = activeDestinationsManager;
        super(l, 8);
        this.setPropertyCell(5, new PropertyListCell(160082217, new int[0]));
        this.setText(1, string);
        this.setText(2, string2);
        this.setInteger(0, n);
        this.setInteger(6, 0 == n ? 0 : 1);
        this.setInteger(7, n2);
        this.setMetrics(3, abstractMetrics);
        this.setMetrics(4, abstractMetrics2);
    }

    protected ActiveDestinationsManager$ActiveDestRow(ActiveDestinationsManager activeDestinationsManager, ActiveDestinationsManager$ActiveDestRow activeDestinationsManager$ActiveDestRow, DateMetric dateMetric, Distance distance) {
        this.this$0 = activeDestinationsManager;
        super(activeDestinationsManager$ActiveDestRow.getUniqueID(), 8);
        this.setPropertyCell(5, new PropertyListCell(160082217, new int[0]));
        this.setText(1, activeDestinationsManager$ActiveDestRow.getText(1));
        this.setText(2, activeDestinationsManager$ActiveDestRow.getText(2));
        this.setInteger(0, activeDestinationsManager$ActiveDestRow.getInteger(0));
        this.setInteger(7, activeDestinationsManager$ActiveDestRow.getInteger(7));
        this.setMetrics(3, dateMetric);
        this.setMetrics(4, distance);
    }

    private ActiveDestinationsManager$ActiveDestRow(ActiveDestinationsManager activeDestinationsManager, ActiveDestinationsManager$ActiveDestRow activeDestinationsManager$ActiveDestRow) {
        this(activeDestinationsManager, activeDestinationsManager$ActiveDestRow.getUniqueID(), activeDestinationsManager$ActiveDestRow.getText(1), activeDestinationsManager$ActiveDestRow.getText(2), activeDestinationsManager$ActiveDestRow.getInteger(0), activeDestinationsManager$ActiveDestRow.getMetrics(3), activeDestinationsManager$ActiveDestRow.getMetrics(4), activeDestinationsManager$ActiveDestRow.getInteger(7));
    }

    @Override
    public EvoListRow copy() {
        return new ActiveDestinationsManager$ActiveDestRow(this.this$0, this);
    }
}

