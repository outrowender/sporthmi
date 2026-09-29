/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.androidauto2.DSIAndroidAuto2DefaultListener;
import de.audi.app.terminalmode.smartphone.androidauto2.UpdateApplication;
import de.audi.app.terminalmode.smartphone.androidauto2.UpdateResource;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;

public abstract class AbstractAndroidAuto2Handler
extends DSIAndroidAuto2DefaultListener {
    protected final LogChannel logger;
    protected final DSIAndroidAuto2 dsi;
    protected final IStateHandler stateHandler;
    protected final IContext context;

    public AbstractAndroidAuto2Handler(LogChannel logChannel, DSIAndroidAuto2 dSIAndroidAuto2, IStateHandler iStateHandler, IContext iContext) {
        this.logger = logChannel;
        this.dsi = dSIAndroidAuto2;
        this.stateHandler = iStateHandler;
        this.context = iContext;
    }

    protected abstract String getLogClass() {
    }

    protected boolean isValid(int n) {
        return 1 == n;
    }

    protected boolean isInvalid(int n) {
        return !this.isValid(n);
    }

    protected void requestDSIUpdate(Resource resource, ResourceOwner resourceOwner) {
        this.context.getCommandListHelper().create().addSingle(new UpdateResource(this.context, resource, resourceOwner, this.stateHandler)).execute(new StringBuffer().append(this.getLogClass()).append(".updateResource").toString());
    }

    protected void requestDSIUpdate(Application application, ApplicationOwner applicationOwner) {
        this.context.getCommandListHelper().create().addSingle(new UpdateApplication(this.context, application, applicationOwner, this.stateHandler)).execute(new StringBuffer().append(this.getLogClass()).append(".updateApplication").toString());
    }
}

