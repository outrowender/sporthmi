/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.Handler;
import de.audi.atip.utils.statemachine.Handler$DefaulftConverter;
import de.audi.atip.utils.statemachine.Handler$DefaultHandlingStrategy;
import de.audi.atip.utils.statemachine.Handler$IHandlingStrategy;
import de.audi.atip.utils.statemachine.Handler$IMessageCodeToStringConverter;
import de.audi.atip.utils.statemachine.SyncronousDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class Handler$HandlerBuilder {
    private IDispatcher dispatcher = new SyncronousDispatcher();
    private Handler$IHandlingStrategy handlingStrategy = new Handler$DefaultHandlingStrategy(null);
    private Handler$IMessageCodeToStringConverter messageCodeToStringConverter = new Handler$DefaulftConverter(null);

    public Handler$HandlerBuilder setDispatcher(IDispatcher iDispatcher) {
        this.dispatcher = iDispatcher;
        return this;
    }

    public Handler$HandlerBuilder setDispatcher(DispatcherBase dispatcherBase) {
        this.dispatcher = new DispatcherBaseAdapter(dispatcherBase);
        return this;
    }

    public Handler$HandlerBuilder setHandlingStrategy(Handler$IHandlingStrategy handler$IHandlingStrategy) {
        this.handlingStrategy = handler$IHandlingStrategy;
        return this;
    }

    public Handler$HandlerBuilder setMessageCodeToStringConverter(Handler$IMessageCodeToStringConverter handler$IMessageCodeToStringConverter) {
        this.messageCodeToStringConverter = handler$IMessageCodeToStringConverter;
        return this;
    }

    public Handler getHandler() {
        return new Handler(this.dispatcher, this.handlingStrategy, this.messageCodeToStringConverter);
    }
}

