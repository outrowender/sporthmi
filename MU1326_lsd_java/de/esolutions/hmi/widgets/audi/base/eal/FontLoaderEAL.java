/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import java.util.HashMap;
import java.util.Iterator;

public class FontLoaderEAL
extends FontLoader {
    private static final int ICON_FONT_ID_PLAIN = 1;
    private static final int ICON_FONT_ID_BOLD = 2;
    protected String fontPath;
    protected static LogChannel logHybridCalls;
    protected final HashMap fonts = new HashMap();

    public FontLoaderEAL(HMITerminalImpl hMITerminalImpl) {
        super(hMITerminalImpl);
        logHybridCalls = AbstractWidget.framework.getLogChannel("Ext.HybridHWGCalls");
        this.fontPath = System.getProperty("hwg.font.path");
    }

    public void clearFontCache() {
        logHybridCalls.log(10000000, "FontLoader#clearFontCache before destroyFont (multiple fonts) call");
        Iterator iterator = this.fonts.values().iterator();
        while (iterator.hasNext()) {
            IWrappedFont iWrappedFont = (IWrappedFont)iterator.next();
            this.destroyFont(iWrappedFont);
        }
        logHybridCalls.log(10000000, "FontLoader#clearFontCache after destroyFont (multiple fonts) call");
        this.fonts.clear();
    }

    protected EALManager getEALManager() {
        return ((HMITerminalEAL)((Object)this.terminal)).getEALManager();
    }

    public Iterator getAllFonts() {
        return this.fonts.keySet().iterator();
    }

    public void destroyFont(Object object) {
        this.getEALManager().destroy((IWrappedFont)object);
    }

    public Object getFont(int n, int n2) {
        int n3;
        String string;
        if (n != 1 && n != 2) {
            string = STANDARD_FONT_PLAIN;
            n3 = 0;
            AbstractWidget.logChannel.log(10000000, "FontLoaderEAL#getFont no font defined for reference %1, returning standard font", (long)n);
        } else if (n == 1) {
            string = STANDARD_FONT_PLAIN;
            n3 = 0;
            AbstractWidget.logChannel.log(10000000, "FontLoaderEAL#getFont using plain font");
        } else {
            string = STANDARD_FONT_BOLD;
            n3 = AbstractWidget.framework.isAsia() ? 0 : 1;
            AbstractWidget.logChannel.log(10000000, "FontLoaderEAL#getFont using bold");
        }
        return this.getFont(string, n3, n2);
    }

    public Object getFont(String string, int n, int n2) {
        return null;
    }
}

