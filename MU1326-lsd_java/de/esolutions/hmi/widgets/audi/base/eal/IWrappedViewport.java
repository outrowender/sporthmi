/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.INode2DLink;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import java.util.List;

public interface IWrappedViewport {
    default public IWrappedTexture enableOffscreen() {
    }

    default public IWrappedTexture enableOffscreen(int n, int n2) {
    }

    default public void disableOffscreen() {
    }

    default public INode2DLink getLink() {
    }

    default public String getName() {
    }

    default public INode3DScene getScene() {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public int getIndex() {
    }

    default public void destroyTexture() {
    }

    default public IWrappedTexture getTexture() {
    }

    default public boolean isAutomaticallyCreated() {
    }

    default public int getLayerCount() {
    }

    default public void removeLayer(IWrappedLayer iWrappedLayer) {
    }

    default public void addLayer(IWrappedLayer iWrappedLayer) {
    }

    default public void setVisible(boolean bl) {
    }

    default public List getLayers() {
    }

    default public void setForceInvisible(boolean bl) {
    }
}

