/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.ModelInternals;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelGroup {
    private static final LogChannel LC = AbstractModelBank.getModelLogChannel();
    private final List eventList = new ArrayList(2);
    private final List registeredModels = new ArrayList(6);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(HMIModelApp hMIModelApp) {
        List list = this.registeredModels;
        synchronized (list) {
            if (hMIModelApp != null && this.registeredModels != null) {
                hMIModelApp.setModelGroup(this);
                this.registeredModels.add(hMIModelApp);
            } else {
                LC.log(10000, "ModelGroup.add( null )! ");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void remove(HMIModelApp hMIModelApp) {
        List list = this.registeredModels;
        synchronized (list) {
            if (hMIModelApp != null && this.registeredModels != null) {
                this.registeredModels.remove(hMIModelApp);
                hMIModelApp.setModelGroup(null);
            } else {
                LC.log(10000, "ModelGroup.remove( null )! ");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void replaceOrAdd(HMIModelApp hMIModelApp, HMIModelApp hMIModelApp2) {
        if (hMIModelApp == hMIModelApp2) {
            return;
        }
        if (hMIModelApp == null) {
            this.add(hMIModelApp2);
        }
        List list = this.registeredModels;
        synchronized (list) {
            int n = this.registeredModels.indexOf(hMIModelApp);
            if (n == -1) {
                hMIModelApp2.setModelGroup(this);
                this.registeredModels.add(hMIModelApp2);
            } else {
                hMIModelApp2.setModelGroup(this);
                if (hMIModelApp != null && this.registeredModels != null) {
                    hMIModelApp.setModelGroup(null);
                    this.registeredModels.set(n, hMIModelApp2);
                } else {
                    LC.log(10000, "ModelGroup.replaceOrAdd( null )! Cannot unregister old model.");
                    this.registeredModels.add(hMIModelApp2);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeAll() {
        List list = this.registeredModels;
        synchronized (list) {
            int n = this.registeredModels.size();
            for (int i2 = 0; i2 < n; ++i2) {
                HMIModelApp hMIModelApp = (HMIModelApp)this.registeredModels.get(i2);
                hMIModelApp.setModelGroup(null);
            }
            this.registeredModels.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ModelUpdateEvent packageEventsAndClear() {
        Object[] objectArray;
        Object object = this.eventList;
        synchronized (object) {
            int n = this.eventList.size();
            if (n > 0) {
                objectArray = new ModelUpdateEvent[n];
                this.eventList.toArray(objectArray);
                this.eventList.clear();
            } else {
                objectArray = null;
            }
        }
        if (objectArray != null) {
            object = AbstractModelBank.getHMIservice();
            ModelUpdateEvent modelUpdateEvent = object.getModelUpdateEvent(-1);
            modelUpdateEvent.setModelType(100);
            modelUpdateEvent.setNestedEvents((ModelUpdateEvent[])objectArray);
            return modelUpdateEvent;
        }
        return null;
    }

    public void flush() {
        LC.log(10000000, "ModelGroup.flush()");
        ModelUpdateEvent modelUpdateEvent = this.packageEventsAndClear();
        if (modelUpdateEvent != null) {
            AbstractModelBank.getHMIservice().postModelUpdateEvent(modelUpdateEvent);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addEvent(ModelUpdateEvent modelUpdateEvent) {
        LC.log(10000000, "ModelGroup.addEvent(): id=%1, updateType=%2 ", (long)modelUpdateEvent.getID(), (long)modelUpdateEvent.getUpdateType());
        Object[] objectArray = modelUpdateEvent.getNestedEvents();
        List list = this.eventList;
        synchronized (list) {
            if (objectArray == null) {
                this.eventList.add(modelUpdateEvent);
            } else {
                this.eventList.addAll(Arrays.asList(objectArray));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean connected() {
        ModelInternals[] modelInternalsArray;
        List list = this.registeredModels;
        synchronized (list) {
            modelInternalsArray = (ModelInternals[])this.registeredModels.toArray(new ModelInternals[this.registeredModels.size()]);
        }
        for (int i2 = 0; i2 < modelInternalsArray.length; ++i2) {
            if (!modelInternalsArray[i2].connected()) continue;
            return true;
        }
        return false;
    }
}

