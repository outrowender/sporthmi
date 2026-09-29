/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;

public class ResourceUpdate {
    private final Resource resource;
    private final ResourceOwner owner;

    public ResourceUpdate(Resource resource, ResourceOwner resourceOwner) {
        this.resource = resource;
        this.owner = resourceOwner;
    }

    public Resource getResource() {
        return this.resource;
    }

    public ResourceOwner getOwner() {
        return this.owner;
    }
}

