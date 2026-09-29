/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Handler$DefaulftConverter;
import de.audi.tv.app.util.Handler$DefaultHandlingStrategy;
import de.audi.tv.app.util.Handler$DispatcherBaseDispatcher;
import de.audi.tv.app.util.Handler$EventDispatcherDispatcher;
import de.audi.tv.app.util.Handler$IHandlingStrategy;
import de.audi.tv.app.util.Handler$IMessageCodeToStringConverter;
import de.audi.tv.app.util.Handler$SyncronousDispatcher;
import de.audi.tv.app.util.IDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class Handler$Builder {
    private IDispatcher dispatcher = new Handler$SyncronousDispatcher();
    private Handler$IHandlingStrategy handlingStrategy = new Handler$DefaultHandlingStrategy(null);
    private Handler$IMessageCodeToStringConverter messageCodeToStringConverter = new Handler$DefaulftConverter(null);

    public Handler$Builder setDispatcher(IDispatcher iDispatcher) {
        this.dispatcher = iDispatcher;
        return this;
    }

    public Handler$Builder setDispatcher(DispatcherBase dispatcherBase) {
        this.dispatcher = new Handler$DispatcherBaseDispatcher(dispatcherBase);
        return this;
    }

    public Handler$Builder setDispatcher(EventDispatcher eventDispatcher) {
        this.dispatcher = new Handler$EventDispatcherDispatcher(eventDispatcher);
        return this;
    }

    public Handler$Builder setHandlingStrategy(Handler$IHandlingStrategy handler$IHandlingStrategy) {
        this.handlingStrategy = handler$IHandlingStrategy;
        return this;
    }

    public Handler$Builder setMessageCodeToStringConverter(Handler$IMessageCodeToStringConverter handler$IMessageCodeToStringConverter) {
        this.messageCodeToStringConverter = handler$IMessageCodeToStringConverter;
        return this;
    }

    public Handler getHandler() {
        return new Handler(this.dispatcher, this.handlingStrategy, this.messageCodeToStringConverter, null);
    }
}

