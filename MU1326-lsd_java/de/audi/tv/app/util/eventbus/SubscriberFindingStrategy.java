/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.eventbus;

import java.util.List;

interface SubscriberFindingStrategy {
    default public List findAllSubscribers(Object object) {
    }
}

