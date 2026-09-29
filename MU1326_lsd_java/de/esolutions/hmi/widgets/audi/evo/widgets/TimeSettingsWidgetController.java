/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractTimeDateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeSettingsWidgetController
extends AbstractTimeDateController {
    private static final int INDEX_TEXT_AM;
    private static final int INDEX_TEXT_PM;
    public static byte cursorPosHours;
    public static byte cursorPosMinutes;
    protected ITimeDateSetttingsRenderer renderer;
    private boolean timeFormat12Hours = true;
    private int[] textIds;
    private List cachedLineDescription;
    private long cachedHours;
    private long cachedMinutes;
    private boolean cachedTimeFormat12Hours;
    private int cachedAmPm;
    private int[] labelArrangement = new int[4];
    private static final int LTR;
    private static final int RTL;
    private int currentDirection = -1;
    private int lastDirection = -1;

    @Override
    public void connected(InitializationContext initializationContext) {
        if (!this.isConnected()) {
            super.connected(initializationContext);
            this.cachedLineDescription = null;
            menuItemLogCh.log(-2137614336, "TimeSettingsWidgetController#connected %1", (long)this.hashCode());
            if (this.model instanceof MetricsModel) {
                DateMetric dateMetric = (DateMetric)((MetricsModel)this.model).getMetric();
                if (dateMetric != null) {
                    this.timeFormat12Hours = dateMetric.getTimeFormat() == 11;
                    Calendar calendar = this.getCalendar();
                    this.readDataFromModel(this.model, calendar);
                } else {
                    menuItemLogCh.log(10000, "TimerSettingsWidgetController#connected Metric contained in the model is null.");
                }
            }
            this.setArrangement();
        }
    }

    private void setArrangement() {
        if (this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation()) {
            this.labelArrangement[0] = 0;
            this.labelArrangement[1] = 1;
            this.labelArrangement[2] = 2;
            this.labelArrangement[3] = 3;
            cursorPosHours = 0;
            cursorPosMinutes = 1;
            this.currentDirection = 0;
        } else {
            this.labelArrangement[3] = 0;
            this.labelArrangement[2] = 1;
            this.labelArrangement[1] = 2;
            this.labelArrangement[0] = 3;
            cursorPosHours = 1;
            cursorPosMinutes = 0;
            this.currentDirection = 1;
        }
    }

    @Override
    protected void enterEditableMode() {
        super.enterEditableMode();
        this.isInEditableMode = true;
        this.setHighlighted(true);
        this.cursorPosition = cursorPosHours;
        this.switchOFFParentMenuCursor();
    }

    @Override
    protected void exitEditableMode() {
        this.isInEditableMode = false;
        this.setHighlighted(false);
        this.cursorPosition = -1;
        this.switchONParentMenuCursor();
        this.writeDataToModel();
    }

    @Override
    protected void exitEditableModeWithoutSavings() {
        this.isInEditableMode = false;
        this.setHighlighted(false);
        this.cursorPosition = -1;
        this.switchONParentMenuCursor();
        this.readDataFromModel(this.getModel(), this.getCalendar());
    }

    @Override
    public List getLineDescription() {
        boolean bl;
        int n = this.getCalendar().get(11);
        if (this.isAmPm()) {
            n = this.getCalendar().get(10);
        }
        if (n == 0 && this.isAmPm()) {
            n = 12;
        }
        int n2 = this.getCalendar().get(12);
        int n3 = this.getCalendar().get(9);
        boolean bl2 = (long)n != this.cachedHours;
        boolean bl3 = (long)n2 != this.cachedMinutes;
        boolean bl4 = n3 != this.cachedAmPm;
        boolean bl5 = this.timeFormat12Hours != this.cachedTimeFormat12Hours;
        boolean bl6 = bl = this.lastDirection != this.currentDirection;
        if (bl2 || bl3 || bl4 || bl5 || bl || this.cachedLineDescription == null) {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(new LineElement(String.valueOf(n), true, this.renderer.getTextWidth("00"), this.currentDirection == 1 ? 1 : 3));
            arrayList.add(new LineElement(":"));
            arrayList.add(new LineElement(new StringBuffer().append(TimeSettingsWidgetController.appendOneLeadingZero(n2)).append(n2).toString(), true));
            if (this.isAmPm()) {
                int n4 = this.getTextID(0);
                int n5 = this.getTextID(1);
                int n6 = -1;
                n6 = n3 == 1 ? n5 : n4;
                if (n6 != -1) {
                    String string = this.getText(n6);
                    if ("".equals(string)) {
                        string = n3 == 1 ? "p.m." : "a.m.";
                    }
                    int n7 = this.renderer.getTextWidth("0");
                    int n8 = Math.max(this.renderer.getTextWidth(this.getText(n4)), this.renderer.getTextWidth(this.getText(n5)));
                    int n9 = 8;
                    int n10 = (n8 + n9) / n7 + 1;
                    arrayList.add(new LineElement(string, false, n10 * n7, 2));
                } else {
                    arrayList.add(new LineElement(n3 == 1 ? "PM" : "AM"));
                }
            } else {
                arrayList.add(new LineElement(""));
            }
            arrayList = TimeSettingsWidgetController.permutate(arrayList, this.labelArrangement);
            this.lastDirection = this.currentDirection;
            this.cachedLineDescription = arrayList;
            this.cachedHours = n;
            this.cachedMinutes = n2;
            this.cachedAmPm = n3;
            this.cachedTimeFormat12Hours = this.isAmPm();
            return arrayList;
        }
        return this.cachedLineDescription;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    private int getTextID(int n) {
        if (this.textIds != null && n >= 0 && n < this.textIds.length) {
            return this.textIds[n];
        }
        return -1;
    }

    private boolean isAmPm() {
        return this.timeFormat12Hours;
    }

    @Override
    public boolean isInEditableMode() {
        return this.isInEditableMode;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        menuItemLogCh.log(-2137614336, "TimeSettingsWidget#keyReleased KeyCode = %1", (long)keyEvent.getKeyCode());
        if (this.dds_pressed && keyEvent.getKeyCode() == 17) {
            if (this.getCurrentVisState() == 1) {
                this.enterEditableMode();
            } else if (this.getCurrentVisState() == 3) {
                if (this.cursorPosition == cursorPosHours) {
                    this.cursorPosition = cursorPosMinutes;
                } else {
                    this.exitEditableMode();
                }
            }
            this.setCompositesDirty(true);
            this.dds_pressed = false;
            keyEvent.consume();
        } else if (keyEvent.getKeyCode() == 15 && this.isInEditableMode()) {
            this.exitEditableModeWithoutSavings();
            this.setCompositesDirty(true);
            keyEvent.consume();
        }
    }

    @Override
    public void keyTurned1(WheelButtonEvent wheelButtonEvent) {
        if (this.getCurrentVisState() == 3) {
            int n = wheelButtonEvent.getClickCount();
            if (this.cursorPosition == cursorPosHours) {
                this.getCalendar().roll(11, n);
            } else {
                this.getCalendar().roll(12, n);
            }
            this.setCompositesDirty(true);
            wheelButtonEvent.consume();
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        menuItemLogCh.log(-2137614336, "TimeSettingsWidgetController#processModelUpdateEvent");
        int n = modelUpdateEvent.getModelType();
        if (n == 9) {
            switch (modelUpdateEvent.getUpdateType()) {
                case 1: 
                case 14: {
                    if (this.getCursorPos() != -1) break;
                    this.readDataFromModel(this.model, this.getCalendar());
                    break;
                }
                case 13: {
                    DateMetric dateMetric = (DateMetric)((MetricsModel)this.model).getMetric();
                    this.timeFormat12Hours = dateMetric.getTimeFormat() == 11;
                    this.invalidateParentLayout();
                    break;
                }
            }
            this.setCompositesDirty(true);
        }
    }

    public void setRenderer(ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer) {
        this.renderer = iTimeDateSetttingsRenderer;
        if (iTimeDateSetttingsRenderer != null) {
            iTimeDateSetttingsRenderer.setClipping(false);
        }
    }

    public void setTextIds(int[] nArray) {
        this.textIds = nArray;
    }

    static {
        cursorPosHours = 0;
        cursorPosMinutes = 1;
    }
}

