/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChange;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.ITMStateListener;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.SpeechMode;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tghu.command.CommandList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IStateHandler {
    public void updateStates(IAppState[] var1, IResource[] var2);

    public TMState getCurrentState();

    public void setOwnerForApplication(Application var1, ApplicationOwner var2);

    public void setSpeechMode(SpeechMode var1);

    public void setOwnerForResource(Resource var1, ResourceOwner var2);

    public void setStateForResource(Resource var1, ResourceState var2);

    public CommandList changeState(TMState var1, IRequestor var2, long var3);

    public CommandList changeState(TMState var1, IRequestor var2);

    public void setServiceStatus(boolean var1);

    public void updateState(TMState var1);

    public void addStateListener(ITMStateListener var1);

    public void removeStateListener(ITMStateListener var1);

    public void addStateChangeActions(GMap<IStateChange, IStateChangeAction.IStateChangeActionOverride> var1);

    public void removeStateChangeActions();

    public ReadOnlyProperty<ApplicationOwner> getStateApplicationProperty(Application var1);

    public ReadOnlyProperty<ResourceOwner> getStateResourceProperty(Resource var1);

    public ReadOnlyProperty<Boolean> getServiceStartedProperty();

    public void setLastScreenWasEntertainment(boolean var1);

    public boolean getLastScreenWasEntertainment();
}

