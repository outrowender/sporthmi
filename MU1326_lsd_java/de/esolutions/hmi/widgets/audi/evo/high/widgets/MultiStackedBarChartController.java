/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiStackedBarChartRenderer;
import java.util.HashMap;
import java.util.Map;

public class MultiStackedBarChartController
extends AbstractWidgetController {
    private MultiStackedBarChartRenderer renderer;
    private static final int DEFAULT_BAR_WIDTH = 12;
    private static final int DEFAULT_BAR_HEIGHT = 178;
    private int barCount;
    private int precalculatedBarWidth = 12;
    private int precalculatedBarHeight = 178;
    private int postcalculatedBarWidth = 12;
    private int postcalculatedBarHeight = 178;
    private int barMargin;
    private int chartWidth;
    private int chartHeigt;
    private int indexGap;
    private ModelStubController precalculatedBar;
    private ModelStubController postcalculatedBar;
    private Map precalculatedData = new HashMap();
    private Map postcalculatedData = new HashMap();

    public void add(AbstractWidget abstractWidget) {
        if (this.precalculatedBar == null && abstractWidget instanceof ModelStubController) {
            this.precalculatedBar = (ModelStubController)abstractWidget;
        } else if (this.postcalculatedBar == null && abstractWidget instanceof ModelStubController) {
            this.postcalculatedBar = (ModelStubController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    protected void initializeWidget() {
        super.initializeWidget();
    }

    public void connected(InitializationContext initializationContext) {
        this.readPrecalculatedData();
        this.readPostCalculatedDate();
        super.connected(initializationContext);
    }

    private void readPrecalculatedData() {
        if (this.precalculatedBar == null) {
            return;
        }
        Object object = this.precalculatedBar.getModel();
        if (object instanceof BaseListModel) {
            int n = ((BaseListModel)object).getLength();
            for (int i2 = 0; i2 < n; ++i2) {
                this.precalculatedData.put(new Integer(i2), ((BaseListModel)object).getGuiRow(i2));
            }
        }
        this.setCompositesDirty(true);
    }

    private void readPostCalculatedDate() {
        if (this.postcalculatedBar == null) {
            return;
        }
        Object object = this.postcalculatedBar.getModel();
        if (object instanceof BaseListModel) {
            int n = ((BaseListModel)object).getLength();
            for (int i2 = 0; i2 < n; ++i2) {
                EvoListRow evoListRow = ((BaseListModel)object).getRow(i2);
                this.postcalculatedData.put(new Integer(i2), evoListRow);
            }
        }
        this.setCompositesDirty(true);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.precalculatedBar.getModelID() == modelUpdateEvent.getModelId() && ((BaseListModel)this.precalculatedBar.getModel()).getStatus() == 1) {
            this.readPrecalculatedData();
        }
        if (this.postcalculatedBar.getModelID() == modelUpdateEvent.getModelId() && ((BaseListModel)this.postcalculatedBar.getModel()).getStatus() == 1) {
            this.readPostCalculatedDate();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void setRenderer(MultiStackedBarChartRenderer multiStackedBarChartRenderer) {
        this.renderer = multiStackedBarChartRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public int getBarCount() {
        return this.barCount;
    }

    public void setBarCount(int n) {
        this.barCount = n;
    }

    public int getPrecalculatedBarWidth() {
        return this.precalculatedBarWidth;
    }

    public void setPrecalculatedBarWidth(int n) {
        this.precalculatedBarWidth = n;
    }

    public int getPrecalculatedBarHeight() {
        return this.precalculatedBarHeight;
    }

    public void setPrecalculatedBarHeight(int n) {
        this.precalculatedBarHeight = n;
    }

    public int getPostcalculatedBarWidth() {
        return this.postcalculatedBarWidth;
    }

    public void setPostcalculatedBarWidth(int n) {
        this.postcalculatedBarWidth = n;
    }

    public int getPostcalculatedBarHeight() {
        return this.postcalculatedBarHeight;
    }

    public void setPostcalculatedBarHeight(int n) {
        this.postcalculatedBarHeight = n;
    }

    public int getBarMargin() {
        return this.barMargin;
    }

    public void setBarMargin(int n) {
        this.barMargin = n;
    }

    public int getChartWidth() {
        return this.chartWidth;
    }

    public void setChartWidth(int n) {
        this.chartWidth = n;
    }

    public int getChartHeigt() {
        return this.chartHeigt;
    }

    public void setChartHeigt(int n) {
        this.chartHeigt = n;
    }

    public float getPrecalculatedData(int n, int n2) {
        Object object = this.precalculatedData.get(new Integer(n));
        if (object == null || !(object instanceof EvoListRow)) {
            return -1.0f;
        }
        Object object2 = ((EvoListRow)object).getCell(n2);
        if (object2 instanceof Integer) {
            return new Float(((Integer)object2).intValue()).floatValue();
        }
        if (object2 instanceof Long) {
            return new Float(((Long)object2).floatValue()).floatValue() / 100.0f;
        }
        return 0.0f;
    }

    public void setPrecalculatedData(Map map) {
        this.precalculatedData = map;
    }

    public float getPostcalculatedData(int n, int n2) {
        Object object = this.postcalculatedData.get(new Integer(n));
        if (object == null || !(object instanceof EvoListRow)) {
            return -1.0f;
        }
        Object object2 = ((EvoListRow)object).getCell(n2);
        if (object2 instanceof Integer) {
            return new Float(((Integer)object2).intValue()).floatValue();
        }
        if (object2 instanceof Long) {
            return new Float(((Long)object2).floatValue()).floatValue() / 100.0f;
        }
        return 0.0f;
    }

    public void setPostcalculatedData(Map map) {
        this.postcalculatedData = map;
    }

    public int getIndexGap() {
        return this.indexGap;
    }

    public void setIndexGap(int n) {
        this.indexGap = n;
    }
}

