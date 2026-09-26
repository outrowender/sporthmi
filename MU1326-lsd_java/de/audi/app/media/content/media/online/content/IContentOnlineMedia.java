/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.online.content.IOnlineMusicStateListener;

public interface IContentOnlineMedia
extends IContentMedia {
    default public void setOnlineMusicStateListener(IOnlineMusicStateListener iOnlineMusicStateListener) {
    }
}

