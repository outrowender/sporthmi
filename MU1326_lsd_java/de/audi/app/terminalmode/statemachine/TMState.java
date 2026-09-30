/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.SpeechMode;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMState {
    private final GMap<Application, Property<ApplicationOwner>> applicationOwnerPropertyMap;
    private final GMap<Resource, Property<ResourceOwner>> resourceOwnerPropertyMap;
    private final ResourceState[] resourceStates;
    private final Object stateMutex = new Object();
    private SpeechMode speechMode;
    private final boolean[] accessRestricted;
    private final LoggingPropertyFactory statePropertyFactory = LoggingPropertyFactory.create();

    public TMState() {
        this.applicationOwnerPropertyMap = Generics.newHashMapWithCapacity(3);
        this.resourceOwnerPropertyMap = Generics.newHashMapWithCapacity(7);
        this.resourceStates = new ResourceState[7];
        Property<ApplicationOwner> property = this.statePropertyFactory.createProperty(Application.SPEECH.name());
        Property<ApplicationOwner> property2 = this.statePropertyFactory.createProperty(Application.NAVI.name());
        Property<ApplicationOwner> property3 = this.statePropertyFactory.createProperty(Application.PHONE.name());
        property.accept(ApplicationOwner.NOBODY);
        property2.accept(ApplicationOwner.NOBODY);
        property3.accept(ApplicationOwner.NOBODY);
        this.applicationOwnerPropertyMap.put(Application.SPEECH, property);
        this.applicationOwnerPropertyMap.put(Application.NAVI, property2);
        this.applicationOwnerPropertyMap.put(Application.PHONE, property3);
        Property<ResourceOwner> property4 = this.statePropertyFactory.createProperty(Resource.SCREEN.name());
        Property<ResourceOwner> property5 = this.statePropertyFactory.createProperty(Resource.AUDIO_MEDIA.name());
        Property<ResourceOwner> property6 = this.statePropertyFactory.createProperty(Resource.AUDIO_PHONE.name());
        Property<ResourceOwner> property7 = this.statePropertyFactory.createProperty(Resource.AUDIO_SPEECH.name());
        Property<ResourceOwner> property8 = this.statePropertyFactory.createProperty(Resource.AUDIO_RINGTONE.name());
        Property<ResourceOwner> property9 = this.statePropertyFactory.createProperty(Resource.NOTIFICATION.name());
        Property<ResourceOwner> property10 = this.statePropertyFactory.createProperty(Resource.AUDIO_GUIDANCE.name());
        property4.accept(ResourceOwner.MAINUNIT);
        property5.accept(ResourceOwner.MAINUNIT);
        property6.accept(ResourceOwner.MAINUNIT);
        property7.accept(ResourceOwner.MAINUNIT);
        property8.accept(ResourceOwner.MAINUNIT);
        property9.accept(ResourceOwner.DEVICE);
        property10.accept(ResourceOwner.MAINUNIT);
        this.resourceOwnerPropertyMap.put(Resource.SCREEN, property4);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_MEDIA, property5);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_PHONE, property6);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_SPEECH, property7);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_RINGTONE, property8);
        this.resourceOwnerPropertyMap.put(Resource.NOTIFICATION, property9);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_GUIDANCE, property10);
        this.resourceStates[Resource.SCREEN.ordinal()] = ResourceState.NORMAL;
        this.resourceStates[Resource.AUDIO_MEDIA.ordinal()] = ResourceState.NORMAL;
        this.resourceStates[Resource.AUDIO_PHONE.ordinal()] = ResourceState.NORMAL;
        this.resourceStates[Resource.AUDIO_SPEECH.ordinal()] = ResourceState.NORMAL;
        this.resourceStates[Resource.AUDIO_RINGTONE.ordinal()] = ResourceState.NORMAL;
        this.resourceStates[Resource.NOTIFICATION.ordinal()] = ResourceState.NORMAL;
        this.resourceStates[Resource.AUDIO_GUIDANCE.ordinal()] = ResourceState.NORMAL;
        this.speechMode = SpeechMode.NONE;
        this.accessRestricted = new boolean[7];
    }

    public TMState(TMState tMState) {
        this.applicationOwnerPropertyMap = Generics.newHashMapWithCapacity(tMState.applicationOwnerPropertyMap.size());
        this.resourceOwnerPropertyMap = Generics.newHashMapWithCapacity(tMState.resourceOwnerPropertyMap.size());
        this.resourceStates = new ResourceState[7];
        this.accessRestricted = new boolean[7];
        this.copyFrom(tMState);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void update(TMState tMState) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.applicationOwnerPropertyMap.get(Application.SPEECH).accept(tMState.getOwnerForApplication(Application.SPEECH));
            this.applicationOwnerPropertyMap.get(Application.NAVI).accept(tMState.getOwnerForApplication(Application.NAVI));
            this.applicationOwnerPropertyMap.get(Application.PHONE).accept(tMState.getOwnerForApplication(Application.PHONE));
            this.resourceOwnerPropertyMap.get(Resource.SCREEN).accept(tMState.getOwnerForResource(Resource.SCREEN));
            this.resourceOwnerPropertyMap.get(Resource.AUDIO_MEDIA).accept(tMState.getOwnerForResource(Resource.AUDIO_MEDIA));
            this.resourceOwnerPropertyMap.get(Resource.AUDIO_PHONE).accept(tMState.getOwnerForResource(Resource.AUDIO_PHONE));
            this.resourceOwnerPropertyMap.get(Resource.AUDIO_SPEECH).accept(tMState.getOwnerForResource(Resource.AUDIO_SPEECH));
            this.resourceOwnerPropertyMap.get(Resource.AUDIO_RINGTONE).accept(tMState.getOwnerForResource(Resource.AUDIO_RINGTONE));
            this.resourceOwnerPropertyMap.get(Resource.NOTIFICATION).accept(tMState.getOwnerForResource(Resource.NOTIFICATION));
            this.resourceOwnerPropertyMap.get(Resource.AUDIO_GUIDANCE).accept(tMState.getOwnerForResource(Resource.AUDIO_GUIDANCE));
            this.resourceStates[Resource.SCREEN.ordinal()] = tMState.resourceStates[Resource.SCREEN.ordinal()];
            this.resourceStates[Resource.AUDIO_MEDIA.ordinal()] = tMState.resourceStates[Resource.AUDIO_MEDIA.ordinal()];
            this.resourceStates[Resource.AUDIO_PHONE.ordinal()] = tMState.resourceStates[Resource.AUDIO_PHONE.ordinal()];
            this.resourceStates[Resource.AUDIO_SPEECH.ordinal()] = tMState.resourceStates[Resource.AUDIO_SPEECH.ordinal()];
            this.resourceStates[Resource.AUDIO_RINGTONE.ordinal()] = tMState.resourceStates[Resource.AUDIO_RINGTONE.ordinal()];
            this.resourceStates[Resource.NOTIFICATION.ordinal()] = tMState.resourceStates[Resource.NOTIFICATION.ordinal()];
            this.resourceStates[Resource.AUDIO_GUIDANCE.ordinal()] = tMState.resourceStates[Resource.AUDIO_GUIDANCE.ordinal()];
            this.speechMode = tMState.speechMode;
            System.arraycopy((Object)tMState.accessRestricted, 0, (Object)this.accessRestricted, 0, tMState.accessRestricted.length);
        }
    }

    private void copyFrom(TMState tMState) {
        Property<ApplicationOwner> property = this.statePropertyFactory.createProperty(Application.SPEECH.name());
        Property<ApplicationOwner> property2 = this.statePropertyFactory.createProperty(Application.NAVI.name());
        Property<ApplicationOwner> property3 = this.statePropertyFactory.createProperty(Application.PHONE.name());
        property.accept(tMState.getOwnerForApplication(Application.SPEECH));
        property2.accept(tMState.getOwnerForApplication(Application.NAVI));
        property3.accept(tMState.getOwnerForApplication(Application.PHONE));
        this.applicationOwnerPropertyMap.put(Application.SPEECH, property);
        this.applicationOwnerPropertyMap.put(Application.NAVI, property2);
        this.applicationOwnerPropertyMap.put(Application.PHONE, property3);
        Property<ResourceOwner> property4 = this.statePropertyFactory.createProperty(Resource.SCREEN.name());
        Property<ResourceOwner> property5 = this.statePropertyFactory.createProperty(Resource.AUDIO_MEDIA.name());
        Property<ResourceOwner> property6 = this.statePropertyFactory.createProperty(Resource.AUDIO_PHONE.name());
        Property<ResourceOwner> property7 = this.statePropertyFactory.createProperty(Resource.AUDIO_SPEECH.name());
        Property<ResourceOwner> property8 = this.statePropertyFactory.createProperty(Resource.AUDIO_RINGTONE.name());
        Property<ResourceOwner> property9 = this.statePropertyFactory.createProperty(Resource.NOTIFICATION.name());
        Property<ResourceOwner> property10 = this.statePropertyFactory.createProperty(Resource.AUDIO_GUIDANCE.name());
        property4.accept(tMState.getOwnerForResource(Resource.SCREEN));
        property5.accept(tMState.getOwnerForResource(Resource.AUDIO_MEDIA));
        property6.accept(tMState.getOwnerForResource(Resource.AUDIO_PHONE));
        property7.accept(tMState.getOwnerForResource(Resource.AUDIO_SPEECH));
        property8.accept(tMState.getOwnerForResource(Resource.AUDIO_RINGTONE));
        property9.accept(tMState.getOwnerForResource(Resource.NOTIFICATION));
        property10.accept(tMState.getOwnerForResource(Resource.AUDIO_GUIDANCE));
        this.resourceOwnerPropertyMap.put(Resource.SCREEN, property4);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_MEDIA, property5);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_PHONE, property6);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_SPEECH, property7);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_RINGTONE, property8);
        this.resourceOwnerPropertyMap.put(Resource.NOTIFICATION, property9);
        this.resourceOwnerPropertyMap.put(Resource.AUDIO_GUIDANCE, property10);
        this.resourceStates[Resource.SCREEN.ordinal()] = tMState.resourceStates[Resource.SCREEN.ordinal()];
        this.resourceStates[Resource.AUDIO_MEDIA.ordinal()] = tMState.resourceStates[Resource.AUDIO_MEDIA.ordinal()];
        this.resourceStates[Resource.AUDIO_PHONE.ordinal()] = tMState.resourceStates[Resource.AUDIO_PHONE.ordinal()];
        this.resourceStates[Resource.AUDIO_SPEECH.ordinal()] = tMState.resourceStates[Resource.AUDIO_SPEECH.ordinal()];
        this.resourceStates[Resource.AUDIO_RINGTONE.ordinal()] = tMState.resourceStates[Resource.AUDIO_RINGTONE.ordinal()];
        this.resourceStates[Resource.NOTIFICATION.ordinal()] = tMState.resourceStates[Resource.NOTIFICATION.ordinal()];
        this.resourceStates[Resource.AUDIO_GUIDANCE.ordinal()] = tMState.resourceStates[Resource.AUDIO_GUIDANCE.ordinal()];
        this.speechMode = tMState.speechMode;
        System.arraycopy((Object)tMState.accessRestricted, 0, (Object)this.accessRestricted, 0, tMState.accessRestricted.length);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAppOwnerMainUnit(Application application) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.getOwnerForApplication(application).is(ApplicationOwner.MAINUNIT);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAppOwnerDevice(Application application) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.getOwnerForApplication(application).is(ApplicationOwner.DEVICE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAppFree(Application application) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.getOwnerForApplication(application).is(ApplicationOwner.NOBODY);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isResourceOwnerMainUnit(Resource resource) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.getOwnerForResource(resource).is(ResourceOwner.MAINUNIT);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isResourceOwnerDevice(Resource resource) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.getOwnerForResource(resource).is(ResourceOwner.DEVICE);
        }
    }

    public boolean isResourceStatePaused(Resource resource) {
        return this.getStateForResource(resource).is((T[])new ResourceState[]{ResourceState.PAUSED, ResourceState.PAUSED_BY_MUTE});
    }

    public boolean isResourceStatePausedByMute(Resource resource) {
        return this.getStateForResource(resource).is(ResourceState.PAUSED_BY_MUTE);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ApplicationOwner getOwnerForApplication(Application application) {
        Object object = this.stateMutex;
        synchronized (object) {
            return (ApplicationOwner)this.applicationOwnerPropertyMap.get(application).get();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ResourceOwner getOwnerForResource(Resource resource) {
        Object object = this.stateMutex;
        synchronized (object) {
            return (ResourceOwner)this.resourceOwnerPropertyMap.get(resource).get();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ResourceState getStateForResource(Resource resource) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.resourceStates[resource.ordinal()];
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SpeechMode getSpeechMode() {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.speechMode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setOwnerForApplication(Application application, ApplicationOwner applicationOwner) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.applicationOwnerPropertyMap.get(application).accept(applicationOwner);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setOwnerForResource(Resource resource, ResourceOwner resourceOwner) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.resourceOwnerPropertyMap.get(resource).accept(resourceOwner);
            if (Resource.AUDIO_MEDIA.is(resource) && ResourceOwner.MAINUNIT.is(resourceOwner)) {
                this.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setStateForResource(Resource resource, ResourceState resourceState) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.resourceStates[resource.ordinal()] = resourceState;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSpeechMode(SpeechMode speechMode) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.speechMode = speechMode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ApplicationOwner[] getAppOwner() {
        Object object = this.stateMutex;
        synchronized (object) {
            ApplicationOwner[] applicationOwnerArray = new ApplicationOwner[3];
            applicationOwnerArray[Application.SPEECH.ordinal()] = (ApplicationOwner)this.applicationOwnerPropertyMap.get(Application.SPEECH).get();
            applicationOwnerArray[Application.NAVI.ordinal()] = (ApplicationOwner)this.applicationOwnerPropertyMap.get(Application.NAVI).get();
            applicationOwnerArray[Application.PHONE.ordinal()] = (ApplicationOwner)this.applicationOwnerPropertyMap.get(Application.PHONE).get();
            return applicationOwnerArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ResourceOwner[] getResourceOwner() {
        Object object = this.stateMutex;
        synchronized (object) {
            ResourceOwner[] resourceOwnerArray = new ResourceOwner[7];
            resourceOwnerArray[Resource.SCREEN.ordinal()] = this.getOwnerForResource(Resource.SCREEN);
            resourceOwnerArray[Resource.AUDIO_MEDIA.ordinal()] = this.getOwnerForResource(Resource.AUDIO_MEDIA);
            resourceOwnerArray[Resource.AUDIO_PHONE.ordinal()] = this.getOwnerForResource(Resource.AUDIO_PHONE);
            resourceOwnerArray[Resource.AUDIO_SPEECH.ordinal()] = this.getOwnerForResource(Resource.AUDIO_SPEECH);
            resourceOwnerArray[Resource.AUDIO_RINGTONE.ordinal()] = this.getOwnerForResource(Resource.AUDIO_RINGTONE);
            resourceOwnerArray[Resource.NOTIFICATION.ordinal()] = this.getOwnerForResource(Resource.NOTIFICATION);
            resourceOwnerArray[Resource.AUDIO_GUIDANCE.ordinal()] = this.getOwnerForResource(Resource.AUDIO_GUIDANCE);
            return resourceOwnerArray;
        }
    }

    public void updateCurrentResourceState(IResource[] iResourceArray) {
        block8: for (int i2 = 0; i2 < iResourceArray.length; ++i2) {
            IResource iResource = iResourceArray[i2];
            if (null == iResource || 0 == iResource.getResourceId()) continue;
            switch (iResource.getResourceId()) {
                case 1: {
                    this.setOwnerForResource(Resource.SCREEN, this.hmiOwnerFromDsiResource(iResource));
                    continue block8;
                }
                case 3: {
                    ResourceOwner resourceOwner = this.hmiOwnerFromDsiResource(iResource);
                    if (ResourceOwner.MAINUNIT.is(resourceOwner) && ResourceOwner.DEVICE.is(this.getOwnerForResource(Resource.AUDIO_MEDIA)) && this.getStateForResource(Resource.AUDIO_MEDIA).is((T[])new ResourceState[]{ResourceState.PAUSED, ResourceState.PAUSED_BY_MUTE})) {
                        this.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
                        continue block8;
                    }
                    if (ResourceOwner.DEVICE.is(resourceOwner) && ResourceOwner.DEVICE.is(this.getOwnerForResource(Resource.AUDIO_MEDIA)) && this.getStateForResource(Resource.AUDIO_MEDIA).is((T[])new ResourceState[]{ResourceState.PAUSED_BY_MUTE, ResourceState.PAUSED})) {
                        this.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
                        this.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
                        continue block8;
                    }
                    this.setOwnerForResource(Resource.AUDIO_MEDIA, resourceOwner);
                    continue block8;
                }
                case 4: {
                    this.setOwnerForResource(Resource.AUDIO_PHONE, this.hmiOwnerFromDsiResource(iResource));
                    continue block8;
                }
                case 5: {
                    this.setOwnerForResource(Resource.AUDIO_SPEECH, this.hmiOwnerFromDsiResource(iResource));
                    continue block8;
                }
                case 7: {
                    this.setOwnerForResource(Resource.AUDIO_RINGTONE, this.hmiOwnerFromDsiResource(iResource));
                    continue block8;
                }
                case 8: {
                    this.setOwnerForResource(Resource.NOTIFICATION, this.hmiOwnerFromDsiResource(iResource));
                    continue block8;
                }
            }
        }
    }

    public void restrictAccessTo(Resource resource) {
        this.setAccessRestricted(resource, true);
    }

    public void allowAccessTo(Resource resource) {
        this.setAccessRestricted(resource, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAccessRestricted(Resource resource, boolean bl) {
        Object object = this.stateMutex;
        synchronized (object) {
            this.accessRestricted[resource.ordinal()] = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isAccessRestricted(Resource resource) {
        Object object = this.stateMutex;
        synchronized (object) {
            return this.accessRestricted[resource.ordinal()];
        }
    }

    private ResourceOwner hmiOwnerFromDsiResource(IResource iResource) {
        switch (iResource.getOwner()) {
            case 2: {
                return ResourceOwner.DEVICE;
            }
            case 1: {
                return ResourceOwner.MAINUNIT;
            }
        }
        return ResourceOwner.MAINUNIT;
    }

    public void updateCurrentAppState(IAppState[] iAppStateArray) {
        block5: for (int i2 = 0; i2 < iAppStateArray.length; ++i2) {
            IAppState iAppState = iAppStateArray[i2];
            if (null == iAppState || 0 == iAppState.getAppStateId()) continue;
            switch (iAppState.getAppStateId()) {
                case 2: {
                    this.modifyOwner(Application.NAVI, iAppState.getOwner());
                    continue block5;
                }
                case 1: {
                    this.modifyOwner(Application.PHONE, iAppState.getOwner());
                    continue block5;
                }
                case 3: {
                    this.modifySpeechMode(iAppState.getOwner(), iAppState.getSpeechMode());
                    this.modifyOwner(Application.SPEECH, iAppState.getOwner());
                    continue block5;
                }
            }
        }
    }

    public ReadOnlyProperty<ApplicationOwner> getApplicationProperty(Application application) {
        if (!this.applicationOwnerPropertyMap.containsKey(application)) {
            throw new IllegalArgumentException("Property map is created in constructor, and the key was not found");
        }
        return this.applicationOwnerPropertyMap.get(application);
    }

    public ReadOnlyProperty<ResourceOwner> getResourceProperty(Resource resource) {
        return Preconditions.checkNotNull(this.resourceOwnerPropertyMap.get(resource));
    }

    private void modifyOwner(Application application, int n) {
        if (0 == n || 1 == n) {
            if (this.isAppOwnerDevice(application)) {
                this.setOwnerForApplication(application, ApplicationOwner.NOBODY);
            }
        } else if (2 == n) {
            this.setOwnerForApplication(application, ApplicationOwner.DEVICE);
        } else if (this.isAppOwnerDevice(application)) {
            this.setOwnerForApplication(application, ApplicationOwner.NOBODY);
        }
    }

    private void modifySpeechMode(int n, int n2) {
        boolean bl;
        boolean bl2 = bl = 2 == n || 0 == n && this.isAppOwnerDevice(Application.SPEECH);
        if (bl) {
            switch (n2) {
                case 1: {
                    this.setSpeechMode(SpeechMode.SPEEKING);
                    break;
                }
                case 2: {
                    this.setSpeechMode(SpeechMode.RECOGNIZING);
                    break;
                }
                default: {
                    this.setSpeechMode(SpeechMode.NONE);
                }
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("TMState[").append(this.format(this.getOwnerForResource(Resource.SCREEN), "TM on screen", "MMI on screen")).append(this.isAccessRestricted(Resource.SCREEN) ? " - access restricted" : "").append(", ").append(this.format(this.getOwnerForResource(Resource.NOTIFICATION), "No notifications", "Notifications on mobile")).append(", Apps[").append(this.format(this.getOwnerForApplication(Application.NAVI), "", " TM-Navi", " MMI-Navi")).append(this.format(this.getOwnerForApplication(Application.PHONE), "", " TM-Phone", ", MMI-Phone")).append(this.format(this.getOwnerForApplication(Application.SPEECH), "", " TM-Speech", ", MMI-Speech")).append("]").append(", Audio[").append(this.format(this.getOwnerForResource(Resource.AUDIO_PHONE), "TM-Phone", "MMI-Phone")).append(this.format(this.getOwnerForResource(Resource.AUDIO_SPEECH), ", TM-Speech", ", MMI-Speech")).append(this.format(this.getOwnerForResource(Resource.AUDIO_RINGTONE), ", TM-Ringtone", ", MMI-Ringtone")).append(this.format(this.getOwnerForResource(Resource.AUDIO_GUIDANCE), ", TM-Guidance", ", MMI-Guidance")).append(this.format(this.getOwnerForResource(Resource.AUDIO_MEDIA), ", TM-Media", ", MMI-Media")).append(this.isAccessRestricted(Resource.AUDIO_MEDIA) ? " - access restricted" : "").append(" - ").append(this.getStateForResource(Resource.AUDIO_MEDIA).name()).append("]]");
        return buffer.toString();
    }

    private String format(ResourceOwner resourceOwner, String string, String string2) {
        if (ResourceOwner.DEVICE.is(resourceOwner)) {
            return string;
        }
        if (ResourceOwner.MAINUNIT.is(resourceOwner)) {
            return string2;
        }
        return "UNEXPECTED_VALUE!";
    }

    private String format(ApplicationOwner applicationOwner, String string, String string2, String string3) {
        if (ApplicationOwner.DEVICE.is(applicationOwner)) {
            return string2;
        }
        if (ApplicationOwner.MAINUNIT.is(applicationOwner)) {
            return string3;
        }
        if (ApplicationOwner.NOBODY.is(applicationOwner)) {
            return string;
        }
        return "UNEXPECTED_VALUE!";
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + TMState.hashCode(this.getAppOwner());
        n = 31 * n + TMState.hashCode(this.getResourceOwner());
        n = 31 * n + TMState.hashCode(this.resourceStates);
        n = 31 * n + this.speechMode.ordinal();
        n = 31 * n + TMState.hashCode(this.accessRestricted);
        return n;
    }

    private static int hashCode(ResourceOwner[] resourceOwnerArray) {
        int n = 31;
        if (resourceOwnerArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < resourceOwnerArray.length; ++i2) {
            n2 = n * n2 + resourceOwnerArray[i2].ordinal();
        }
        return n2;
    }

    private static int hashCode(ResourceState[] resourceStateArray) {
        int n = 31;
        if (resourceStateArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < resourceStateArray.length; ++i2) {
            n2 = n * n2 + resourceStateArray[i2].ordinal();
        }
        return n2;
    }

    private static int hashCode(ApplicationOwner[] applicationOwnerArray) {
        int n = 31;
        if (applicationOwnerArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < applicationOwnerArray.length; ++i2) {
            n2 = n * n2 + applicationOwnerArray[i2].ordinal();
        }
        return n2;
    }

    private static int hashCode(boolean[] blArray) {
        int n = 31;
        if (blArray == null) {
            return 0;
        }
        int n2 = 1;
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            n2 = n * n2 + (blArray[i2] ? 1 : 0);
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        TMState tMState = (TMState)object;
        if (!this.applicationOwnerPropertyMap.equals(tMState.applicationOwnerPropertyMap)) {
            return false;
        }
        if (!this.resourceOwnerPropertyMap.equals(tMState.resourceOwnerPropertyMap)) {
            return false;
        }
        if (!Arrays.equals(this.resourceStates, tMState.resourceStates)) {
            return false;
        }
        if (this.speechMode != tMState.speechMode) {
            return false;
        }
        return Arrays.equals(this.accessRestricted, tMState.accessRestricted);
    }
}

