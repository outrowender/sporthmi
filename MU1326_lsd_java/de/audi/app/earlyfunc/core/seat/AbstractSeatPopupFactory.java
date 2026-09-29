/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.seat.AbstractSeatPopinComponent;
import de.audi.app.earlyfunc.core.seat.ISeatMainController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupController;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandler;
import de.audi.app.earlyfunc.core.seat.ISeatPopupHandlerController;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import java.util.List;

public abstract class AbstractSeatPopupFactory {
    private final ICarApplication application;
    private final LogChannel logChannel;
    private final AbstractSeatPopinComponent component;

    protected AbstractSeatPopupFactory(ICarApplication iCarApplication, LogChannel logChannel, AbstractSeatPopinComponent abstractSeatPopinComponent) {
        this.application = iCarApplication;
        this.logChannel = logChannel;
        this.component = abstractSeatPopinComponent;
    }

    public abstract ISeatMainController createInstanceMainController() {
    }

    public abstract ISeatPopupController createInstancePopupController() {
    }

    public abstract ISeatPopupHandler createInstancePopupHandler() {
    }

    public abstract ISeatPopupHandlerController createInstancePopupHandlerController() {
    }

    public abstract void addSeatPopups(List list) {
    }

    public abstract void addPneumaticSeatPopups(List list) {
    }

    public abstract void init() {
    }

    public abstract void deinit() {
    }

    public abstract int[] getPopupIDs() {
    }

    public ICarApplication getApplication() {
        return this.application;
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public AbstractSeatPopinComponent getComponent() {
        return this.component;
    }

    protected ChoiceModelApp getChoiceModel(int n) {
        return this.getApplication().getFrameworkAccess().getHMIService().getChoiceModel(n);
    }
}

