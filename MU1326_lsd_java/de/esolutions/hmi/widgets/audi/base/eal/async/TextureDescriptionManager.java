/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.async.ITexDescrAsyncStates;
import java.util.Set;

public class TextureDescriptionManager {
    SimpleIntObjectMap hashTexDescrMap = new SimpleIntObjectMap(500);
    private static TextureDescriptionManager instance = null;

    private TextureDescriptionManager() {
    }

    public static synchronized TextureDescriptionManager getInstance() {
        if (instance == null) {
            instance = new TextureDescriptionManager();
            AbstractWidget.logImageAsync.setLogThreshold(-2137614336);
        }
        return instance;
    }

    public boolean cancelRequest(TextureDescription textureDescription, Object object) {
        if (textureDescription instanceof ITexDescrAsyncStates) {
            ITexDescrAsyncStates iTexDescrAsyncStates = (ITexDescrAsyncStates)textureDescription;
            return iTexDescrAsyncStates.removeReceiver(object);
        }
        return true;
    }

    public TextureDescription getCachedTextureDescription(int n) {
        TextureDescription textureDescription = (TextureDescription)this.hashTexDescrMap.get(n);
        if (AbstractWidget.logImageAsync.isDebug() || AbstractWidget.logImage.isDebug()) {
            LogChannel logChannel = textureDescription instanceof ITexDescrAsyncStates ? AbstractWidget.logImageAsync : AbstractWidget.logImage;
            logChannel.log(-2137614336, "TextureDescriptionManager#getCachedTextureDescription the cached reference is %1", (Object)textureDescription);
        }
        return textureDescription;
    }

    public TextureDescription getCachedTextureDescription(HMIImage hMIImage) {
        String string = hMIImage.getPath();
        if (string == null) {
            return null;
        }
        TextureDescription textureDescription = (TextureDescription)this.hashTexDescrMap.get(string.hashCode());
        if (AbstractWidget.logImageAsync.isDebug() || AbstractWidget.logImage.isDebug()) {
            LogChannel logChannel = textureDescription instanceof ITexDescrAsyncStates ? AbstractWidget.logImageAsync : AbstractWidget.logImage;
            logChannel.log(-2137614336, "TextureDescriptionManager#getCachedTextureDescription the cached reference is %1", (Object)textureDescription);
        }
        return textureDescription;
    }

    public TextureDescription getCachedTextureDescription(TextureDescription textureDescription) {
        if (textureDescription == null) {
            return null;
        }
        Object object = textureDescription.getCacheKey();
        if (object == null) {
            return null;
        }
        TextureDescription textureDescription2 = this.getCachedTextureDescription(object.hashCode());
        return textureDescription2;
    }

    public Set getReferences(TextureDescription textureDescription) {
        return textureDescription instanceof ITexDescrAsyncStates ? ((ITexDescrAsyncStates)textureDescription).getIUpdatableReceiver() : null;
    }

    public boolean hasTextureDescription(int n) {
        return this.hashTexDescrMap.get(n) != null;
    }

    public boolean hasTextureDescription(HMIImage hMIImage) {
        return this.hashTexDescrMap.get(hMIImage.getPath().hashCode()) != null;
    }

    public boolean hasTextureDescription(TextureDescription textureDescription) {
        return this.hashTexDescrMap.get(textureDescription.getCacheKey().hashCode()) != null;
    }

    public TextureDescription put(TextureDescription textureDescription) {
        if (textureDescription == null || textureDescription.getCacheKey() == null) {
            return null;
        }
        TextureDescription textureDescription2 = null;
        int n = textureDescription.getCacheKey().hashCode();
        if (this.hasTextureDescription(n)) {
            textureDescription2 = this.getCachedTextureDescription(n);
        } else {
            this.hashTexDescrMap.add(n, textureDescription);
            textureDescription2 = textureDescription;
        }
        return textureDescription2;
    }

    public void removeTextureDescription(TextureDescription textureDescription) {
        if (textureDescription == null || textureDescription.getCache() == null || textureDescription.getCacheKey() == null) {
            return;
        }
        Object object = textureDescription.getCacheKey();
        LogChannel logChannel = null;
        if (AbstractWidget.logImageAsync.isDebug() || AbstractWidget.logImage.isDebug()) {
            LogChannel logChannel2 = logChannel = textureDescription instanceof ITexDescrAsyncStates ? AbstractWidget.logImageAsync : AbstractWidget.logImage;
        }
        if (logChannel != null) {
            if (!this.hasTextureDescription(textureDescription)) {
                logChannel.log(-2137614336, "TextureDescriptionManager#removeTextureDescription description is not cached.");
            } else {
                logChannel.log(-2137614336, "TextureDescriptionManager#removeTextureDescription removing descr: %1", (Object)textureDescription);
            }
        }
        if (!(object instanceof TextureDescription)) {
            this.hashTexDescrMap.remove(object.hashCode());
        }
    }

    public void resetManager() {
        this.hashTexDescrMap.clear();
        instance = null;
    }
}

