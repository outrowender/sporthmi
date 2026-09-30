/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.service;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.service.AbstractTelAudiServiceHandler;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.service.TelEvoAudiServiceListRow;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class TelEvoAudiServiceHandler
extends AbstractTelAudiServiceHandler
implements BaseListModelListener {
    private static final int CONTEXT_AUDISERVICE = 5;
    private static final int SERVICETYPE_INFO_BREAKDOWN = 1;
    private static final int SERVICETYPE_INFO = 2;
    private static final int SERVICETYPE_BREAKDOWN = 3;
    private static final int INFO_SELECTED = 0;
    private static final int BREAKDOWN_SELECTED = 1;
    private static final int INFO_AND_BREAKDOWN_SELECTED = 2;

    public TelEvoAudiServiceHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    public void init() {
        super.init();
        this.getMainAvailabilityList().setListener(this);
        this.getSubAvailabilityList().setListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getMainAvailabilityList().resetListener();
        this.getSubAvailabilityList().resetListener();
    }

    private BaseListModelApp getMainAvailabilityList() {
        return this.getBaseListModel(300753);
    }

    private BaseListModelApp getSubAvailabilityList() {
        return this.getBaseListModel(300754);
    }

    private ChoiceModelApp getSelectedServiceChoice() {
        return this.getChoiceModel(300755);
    }

    protected void updateServiceAvailability(int n) {
        switch (n) {
            case 0: {
                this.setNoServiceAvailable();
                break;
            }
            case 1: {
                this.setInfoServiceAvailable();
                break;
            }
            case 2: {
                this.setBreakdownServiceAvailable();
                break;
            }
            case 3: {
                this.setInfoBreakdownServiceAvailable();
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoAudiServiceHandler#updateServiceAvailability] unknown seserviceAvailability %1", (long)n);
            }
        }
    }

    private void setNoServiceAvailable() {
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getMainAvailabilityList());
        modelGroup.add(this.getSubAvailabilityList());
        this.getMainAvailabilityList().removeAll();
        this.getSubAvailabilityList().removeAll();
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private void setInfoBreakdownServiceAvailable() {
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getMainAvailabilityList());
        modelGroup.add(this.getSubAvailabilityList());
        BaseListModelApp baseListModelApp = this.getMainAvailabilityList().getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.append(new TelEvoAudiServiceListRow(1L, 1));
        this.getMainAvailabilityList().update(baseListModelApp);
        BaseListModelApp baseListModelApp2 = this.getSubAvailabilityList().getCopy();
        baseListModelApp2.removeAll();
        baseListModelApp2.append(new TelEvoAudiServiceListRow(1L, 2));
        baseListModelApp2.append(new TelEvoAudiServiceListRow(2L, 3));
        this.getSubAvailabilityList().update(baseListModelApp2);
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private void setInfoServiceAvailable() {
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getMainAvailabilityList());
        modelGroup.add(this.getSubAvailabilityList());
        BaseListModelApp baseListModelApp = this.getMainAvailabilityList().getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.append(new TelEvoAudiServiceListRow(1L, 2));
        this.getMainAvailabilityList().update(baseListModelApp);
        BaseListModelApp baseListModelApp2 = this.getSubAvailabilityList().getCopy();
        baseListModelApp2.removeAll();
        this.getSubAvailabilityList().update(baseListModelApp2);
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private void setBreakdownServiceAvailable() {
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getMainAvailabilityList());
        modelGroup.add(this.getSubAvailabilityList());
        BaseListModelApp baseListModelApp = this.getMainAvailabilityList().getCopy();
        baseListModelApp.removeAll();
        baseListModelApp.append(new TelEvoAudiServiceListRow(1L, 3));
        this.getMainAvailabilityList().update(baseListModelApp);
        BaseListModelApp baseListModelApp2 = this.getSubAvailabilityList().getCopy();
        baseListModelApp2.removeAll();
        this.getSubAvailabilityList().update(baseListModelApp2);
        modelGroup.flush();
        modelGroup.removeAll();
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelEvoAudiServiceHandler#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedBaseList(evoListRow, n, n2, n3, n4));
        }
        if (evoListRow instanceof TelEvoAudiServiceListRow) {
            TelEvoAudiServiceListRow telEvoAudiServiceListRow = (TelEvoAudiServiceListRow)evoListRow;
            BaseListModelApp baseListModelApp = this.getBaseListModel(n);
            int n5 = telEvoAudiServiceListRow.getServiceType();
            if (n == this.getMainAvailabilityList().getID()) {
                this.getSubAvailabilityList().setSelectedIndex(-1);
                this.getChoiceModel(300716).setValue(5);
                switch (n5) {
                    case 1: {
                        this.log.log(10000000, "[TelEvoAudiServiceHandler#itemSelected] audi service in main list model selected.");
                        this.getSelectedServiceChoice().setValue(2);
                        baseListModelApp.setSelectedIndex(n2);
                        baseListModelApp.fireEvent(n4);
                        break;
                    }
                    case 3: {
                        this.log.log(10000000, "[TelEvoAudiServiceHandler#itemSelected] service call in main list model selected.");
                        this.getSelectedServiceChoice().setValue(1);
                        baseListModelApp.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
                        baseListModelApp.fireEvent(n4);
                        break;
                    }
                    case 2: {
                        this.log.log(10000000, "[TelEvoAudiServiceHandler#itemSelected] info call in main list model selected.");
                        this.getSelectedServiceChoice().setValue(0);
                        baseListModelApp.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
                        baseListModelApp.fireEvent(n4);
                        break;
                    }
                    default: {
                        this.log.log(100000, "[TelEvoAudiServiceHandler#itemSelected] Unknown service type %1", (long)n5);
                        break;
                    }
                }
            } else if (n == this.getSubAvailabilityList().getID()) {
                switch (n5) {
                    case 3: {
                        this.log.log(10000000, "[TelEvoAudiServiceHandler#itemSelected] service call in sub list model selected.");
                        this.getSelectedServiceChoice().setValue(1);
                        baseListModelApp.setSelectedIndex(n2);
                        baseListModelApp.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
                        baseListModelApp.fireEvent(n4);
                        break;
                    }
                    case 2: {
                        this.log.log(10000000, "[TelEvoAudiServiceHandler#itemSelected] info call in sub list model selected.");
                        this.getSelectedServiceChoice().setValue(0);
                        baseListModelApp.setSelectedIndex(n2);
                        baseListModelApp.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
                        baseListModelApp.fireEvent(n4);
                        break;
                    }
                    default: {
                        this.log.log(100000, "[TelEvoAudiServiceHandler#itemSelected] Unknown service type %1", (long)n5);
                        break;
                    }
                }
            } else {
                this.log.log(100000, "[TelEvoAudiServiceHandler#itemSelected] unknown model %1", (long)n);
            }
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

