/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.mediator.AbstractEventMediator;
import java.util.NoSuchElementException;

public class FunctionAccessMediator
extends AbstractEventMediator {
    public static final int FS_FUNCTIONAL;
    public static final int FS_UNAVAILABLE;
    public static final int FS_DISABLED;
    public static final int FS_BLOCKED1;
    public static final int FS_BLOCKED2;
    public static final int FS_BLOCKED3;
    private static final int FUNCTIONAL;
    private static final int UNAVAILABLE;
    private static final int BLOCKED1;
    private static final int BLOCKED2;
    private static final int BLOCKED3;
    private int functionalAction;
    private int unavailableAction;
    private int blocked1Action;
    private int blocked2Action;
    private int blocked3Action;
    private int mediatorState = -1;

    public FunctionAccessMediator(MediatorManager mediatorManager, int n, int n2, int n3, int n4, int n5, int n6) {
        this(-1L, mediatorManager, n, n2, n3, n4, n5, n6);
    }

    public FunctionAccessMediator(long l, MediatorManager mediatorManager, int n, int n2, int n3, int n4, int n5, int n6) {
        super(l, mediatorManager, -1, n6);
        this.functionalAction = n;
        this.unavailableAction = n2;
        this.blocked1Action = n3;
        this.blocked2Action = n4;
        this.blocked3Action = n5;
    }

    @Override
    public void start() {
        this.startListening();
        this.resetPostponedAction();
        this.evaluateFunctionState();
        this.started = true;
    }

    @Override
    public void stop() {
        this.stopListening();
        this.started = false;
    }

    @Override
    public int activate(boolean bl) {
        this.active = false;
        this.start();
        super.activate(false);
        return this.getPostponedAction();
    }

    @Override
    public int reactivate(boolean bl) {
        if (bl) {
            this.active = false;
        }
        if (!this.started || bl) {
            this.start();
        }
        return super.reactivate(false);
    }

    @Override
    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        this.manager.getEventLogChannel().log(1078071040, "mediator received model-update event (m%1.u%2) ", (long)n, (long)n2);
        if (this.triggerModelIDList[0] == n) {
            if (n2 == 1) {
                this.evaluateFunctionState();
            }
            this.manager.getEventLogChannel().log(1078071040, "mediator processed model-update event (m%1) ", (long)n);
        }
    }

    private void evaluateFunctionState() {
        int n = 1;
        try {
            n = ((ChoiceModel)this.manager.getModel(this.triggerModelIDList[0])).getValue();
        }
        catch (NoSuchElementException noSuchElementException) {
            this.manager.getLogChannel().log(10000, "mediator unable to retrieve function state model (m%1)", (long)this.triggerModelIDList[0], (Throwable)noSuchElementException);
            n = 1;
        }
        catch (ClassCastException classCastException) {
            this.manager.getLogChannel().log(10000, "mediator unable to retrieve function state model (m%1)", (long)this.triggerModelIDList[0], (Throwable)classCastException);
            n = 1;
        }
        if (n == 0) {
            if (this.mediatorState != 0) {
                this.mediatorState = 0;
                this.triggerAction(this.functionalAction);
            }
        } else if (n == 3 && this.blocked1Action != -1) {
            if (this.mediatorState != 2) {
                this.mediatorState = 2;
                this.triggerAction(this.blocked1Action);
            }
        } else if (n == 4 && this.blocked2Action != -1) {
            if (this.mediatorState != 3) {
                this.mediatorState = 3;
                this.triggerAction(this.blocked2Action);
            }
        } else if (n == 5 && this.blocked3Action != -1) {
            if (this.mediatorState != 4) {
                this.mediatorState = 4;
                this.triggerAction(this.blocked3Action);
            }
        } else if (this.mediatorState != 1) {
            this.mediatorState = 1;
            this.triggerAction(this.unavailableAction);
        }
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public void kill() {
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }
}

