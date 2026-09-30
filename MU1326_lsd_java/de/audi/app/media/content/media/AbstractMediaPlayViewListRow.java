/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaListRow;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.i18n.I18NString;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractMediaPlayViewListRow
extends AbstractMediaListRow {
    public AbstractMediaPlayViewListRow(long l, int n) {
        super(l, l, n);
    }

    public AbstractMediaPlayViewListRow(AbstractMediaPlayViewListRow abstractMediaPlayViewListRow) {
        super(abstractMediaPlayViewListRow);
    }

    public abstract void setTime(PlayTime var1);

    public abstract void setPlaying(boolean var1);

    public abstract void setDetailInfos(MediaDetailInfo var1);

    public abstract void setCoverArt(ResourceLocator var1);

    public abstract I18NString getTitle();

    public boolean isEnabled() {
        return false;
    }

    public void updatePlaytimeCapabilitiy(boolean bl) {
    }
}

