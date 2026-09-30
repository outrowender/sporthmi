/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class ResourceLocatorModel
extends AbstractModel
implements ResourceLocatorModelApp,
ResourceLocatorModelGUI {
    private static final HMIResourceLocator NULL_RESOURCE_LOCATOR = new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI);
    private volatile HMIResourceLocator resource = NULL_RESOURCE_LOCATOR;

    public ResourceLocatorModel(int n) {
        super(n, 0);
    }

    public ResourceLocatorModel(int n, int n2) {
        super(n, n2);
    }

    public boolean isEmpty() {
        return this.resource == NULL_RESOURCE_LOCATOR;
    }

    public int getModelType() {
        return 22;
    }

    public HMIResourceLocator getResourceLocator() {
        return this.resource;
    }

    public void setResourceLocator(int n, String string) {
        this.setResourceLocator(n, string, true);
    }

    public void setResourceLocatorWithoutEvent(int n, String string) {
        this.setResourceLocator(n, string, false);
    }

    private void setResourceLocator(int n, String string, boolean bl) {
        this.lc.log(10000000, "(%3) [ResourceLocatorModel.setResourceLocator] id:%2 uri:%1", (Object)string, (long)n, (long)this.id);
        this.resource = new HMIResourceLocator(n, string);
        if (bl) {
            this.fireModelUpdateEvent(1);
        }
    }

    public void setResourceLocator(int n, String string, int n2) {
        this.lc.log(10000000, "(%3) [ResourceLocatorModel.setResourceLocator] id:%2 uri:%1", (Object)string, (long)n, (long)this.id);
        this.lc.log(10000000, "(%2) [ResourceLocatorModel.setResourceLocator] status:%1", (long)n2, (long)this.id);
        this.resource = new HMIResourceLocator(n, string);
        this.resource.setStatus(n2);
        this.fireModelUpdateEvent(1);
    }

    public void setResourceLocator(HMIResourceLocator hMIResourceLocator) {
        this.lc.log(10000000, "(%2) [ResourceLocatorModel.setResourceLocator] loc:%1", (Object)hMIResourceLocator, (long)this.id);
        this.resource = new HMIResourceLocator(hMIResourceLocator);
        this.fireModelUpdateEvent(1);
    }

    public String dumpContent() {
        Buffer buffer = new Buffer(300);
        buffer.append(super.dumpContent());
        buffer.append("\nresource: ").append(this.resource);
        return buffer.toString();
    }

    public void resetListener() {
    }
}

