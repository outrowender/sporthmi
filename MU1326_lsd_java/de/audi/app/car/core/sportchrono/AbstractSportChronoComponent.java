/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.sportchrono;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.sportchrono.AbstractDSICarStopWatchAdapter;
import de.audi.app.car.core.sportchrono.AbstractSportChronoComponent$LocalMsgListener;
import de.audi.app.car.core.sportchrono.ISportChronoAccess;
import de.audi.app.car.core.sportchrono.ISportChronoControl;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public abstract class AbstractSportChronoComponent
extends AbstractDSICarStopWatchAdapter
implements ISportChronoAccess,
ISportChronoControl {
    private final AbstractSportChronoComponent$LocalMsgListener msgListener = new AbstractSportChronoComponent$LocalMsgListener(this, null);

    public AbstractSportChronoComponent(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    @Override
    public String getName() {
        return "SportChrono";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getCurrentViewOptions() {
        return "none";
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(79, this.msgListener);
    }

    @Override
    public void deinit() {
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this.msgListener);
        super.deinit();
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public IFrameworkAccess getFrameworkAccess() {
        return this.getApplication().getFrameworkAccess();
    }

    static /* synthetic */ void access$000(AbstractSportChronoComponent abstractSportChronoComponent, String string, int n, int n2, boolean bl) {
        abstractSportChronoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$100(AbstractSportChronoComponent abstractSportChronoComponent, String string, int n, int n2, boolean bl) {
        abstractSportChronoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractSportChronoComponent abstractSportChronoComponent, int n) {
        return abstractSportChronoComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$300(AbstractSportChronoComponent abstractSportChronoComponent, String string, int n, int n2, boolean bl) {
        abstractSportChronoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$400(AbstractSportChronoComponent abstractSportChronoComponent, String string, int n, int n2, boolean bl) {
        abstractSportChronoComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$500(AbstractSportChronoComponent abstractSportChronoComponent, int n) {
        return abstractSportChronoComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$600(AbstractSportChronoComponent abstractSportChronoComponent, int n) {
        return abstractSportChronoComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$800(AbstractSportChronoComponent abstractSportChronoComponent, int n) {
        return abstractSportChronoComponent.getButtonModel(n);
    }
}

