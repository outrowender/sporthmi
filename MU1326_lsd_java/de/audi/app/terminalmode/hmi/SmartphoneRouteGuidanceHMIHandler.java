/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.hmi.SmartphoneRouteGuidanceHMIHandler$1;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.ModelBindings$ChoiceModelBinding;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.observables.Subscription;

public class SmartphoneRouteGuidanceHMIHandler
implements ITerminalModeComponent {
    private static final int SMARTPHONE_RG_INACTIVE;
    private static final int SMARTPHONE_RG_ACTIVE;
    private final LogChannel logger;
    private final IStateHandler stateHandler;
    private final IContext context;
    private final ModelBindings modelBinding = SilentModelBindings.create();
    private volatile Subscription subscription;
    private volatile ModelBindings$ChoiceModelBinding choiceModel;

    public SmartphoneRouteGuidanceHMIHandler(IStateHandler iStateHandler, LogChannel logChannel, IContext iContext) {
        this.logger = logChannel;
        this.stateHandler = iStateHandler;
        this.context = iContext;
    }

    @Override
    public void init() {
        this.choiceModel = this.modelBinding.from(this.context.getChoiceModel(5554));
        this.subscription = this.stateHandler.getStateApplicationProperty(Application.NAVI).observe().distinctUntilChanged().map((Function)new SmartphoneRouteGuidanceHMIHandler$1(this)).distinctUntilChanged().log(this.logger, "[SmartphoneRouteGuidanceHMIHandler.updateState]").redirectTo(this.choiceModel.intValue());
    }

    @Override
    public void deinit() {
        this.subscription.cancel();
        this.choiceModel = null;
    }
}

