/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class AbstractTooltipFormatter
implements ITooltipFormatter {
    protected static final String ARROW_ONE_DIRECTION = " -> ";
    protected static final String ARROW_BIDIRECTIONAL = " <-> ";
    protected final ITooltipFormatter.TooltipFormatterEnvironment env;

    public AbstractTooltipFormatter(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        this.env = tooltipFormatterEnvironment;
    }

    public String formatAdbEntry(AdbEntry adbEntry, int n) {
        try {
            if (adbEntry != null) {
                String string = adbEntry.getCombinedName();
                AddressData addressData = MapUtils.extractAddressDataOfEntryType(adbEntry.getAddressData(), n);
                if (addressData == null) {
                    return null;
                }
                TooltipStringBuilder tooltipStringBuilder = new TooltipStringBuilder();
                tooltipStringBuilder.addString(string);
                NavLocation navLocation = this.env.getNavLocation(addressData.getNavLocation());
                String string2 = LocationFormatter.formatCity(navLocation);
                String string3 = LocationFormatter.formatStreetHousenumber(navLocation);
                this.addCityAndStreet(tooltipStringBuilder, string2, string3);
                if (!tooltipStringBuilder.isEmpty()) {
                    return tooltipStringBuilder.toString();
                }
                this.env.getLogChannel().log(10000000, "AbstractTooltipFormatter#formatAdbEntry(): failed to format location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                return null;
            }
            this.env.getLogChannel().log(10000000, "AbstractTooltipFormatter#formatAdbEntry(): adbEntry is null");
            return null;
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "AbstractTooltipFormatter#formatAdbEntry() - %1", (Throwable)exception);
            return null;
        }
    }

    public String formatHomeLocation(NavLocation navLocation) {
        return this.formatLocation(navLocation);
    }

    public String formatPicNavLocation(NavLocation navLocation) {
        return this.formatLocation(navLocation);
    }

    protected void addCityAndStreet(TooltipStringBuilder tooltipStringBuilder, String string, String string2) {
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(string);
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(string2);
    }

    public String formatFallback(NavLocation navLocation) {
        String string = LocationFormatter.formatLatitude(navLocation);
        String string2 = LocationFormatter.formatLongitude(navLocation);
        if (Util.isEmpty(string) || Util.isEmpty(string2)) {
            this.env.getLogChannel().log(10000000, "AbstractTooltipFormatter#addCityAndStreet(): failed to format geocoordinates");
            return null;
        }
        return StringUtilities.formatMessage("%1\n%2", new String[]{string, string2});
    }

    protected String formatTMCDirectionOrArea(String string, String string2, boolean bl, String string3, boolean bl2) {
        if (bl2) {
            return string3;
        }
        if (!Util.isEmpty(string)) {
            Buffer buffer = new Buffer();
            buffer.append(string);
            if (!Util.isEmpty(string2)) {
                if (bl) {
                    buffer.append(ARROW_BIDIRECTIONAL);
                } else {
                    buffer.append(ARROW_ONE_DIRECTION);
                }
                buffer.append(string2);
            }
            return buffer.toString();
        }
        if (!Util.isEmpty(string2)) {
            return string2;
        }
        return null;
    }

    protected String formatTMCRoadNameAndMessageCount(String string, int n, int n2) {
        Buffer buffer = new Buffer();
        if (!Util.isEmpty(string)) {
            buffer.append(string);
        }
        if (n > 0 && n2 >= n) {
            buffer.append(' ');
            buffer.append('(');
            buffer.append(n);
            buffer.append('/');
            buffer.append(n2);
            buffer.append(')');
        }
        return buffer.toString();
    }

    protected String formatTMCText(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0 && !Util.isEmpty(stringArray[0])) {
            return stringArray[0];
        }
        return null;
    }

    protected abstract String formatTMC(String var1, int var2, int var3, String var4, String var5, boolean var6, String[] var7, String var8, boolean var9, long var10);

    public String formatPOI3D(NavLocation navLocation) {
        return this.formatPOI(navLocation);
    }

    public String formatBuilding(NavLocation navLocation) {
        return this.formatPOI(navLocation);
    }

    public String formatTMC(TmcMessage tmcMessage) {
        return this.formatTMC(null, -1, -1, tmcMessage.getDirectionOfRoad1(), tmcMessage.getDirectionOfRoad2(), tmcMessage.isIsBidirectional(), tmcMessage.getEventText(), tmcMessage.getStartLocation(), tmcMessage.isIsArea(), tmcMessage.getAffectedRoadLength());
    }

    public String formatTMC(TmcListElement tmcListElement) {
        return this.formatTMC(null, -1, -1, tmcListElement.getDirectionOfRoad1(), tmcListElement.getDirectionOfRoad2(), tmcListElement.isIsBidirectional(), new String[]{tmcListElement.description}, null, false, -1L);
    }

    public class TooltipStringBuilder {
        private final Buffer buffer = new Buffer();
        private boolean lineBreakRequested = false;
        private boolean separatorNeeded = false;

        public boolean addLineBreak() {
            if (this.buffer.length() > 0) {
                this.lineBreakRequested = true;
                this.separatorNeeded = false;
                return true;
            }
            return false;
        }

        public boolean addString(String string, String string2) {
            if (!Util.isEmpty(string)) {
                if (this.lineBreakRequested) {
                    this.buffer.append('\n');
                    this.lineBreakRequested = false;
                }
                if (this.separatorNeeded) {
                    this.buffer.append(string2);
                }
                this.buffer.append(string);
                this.separatorNeeded = true;
                return true;
            }
            return false;
        }

        public boolean addString(String string) {
            return this.addString(string, ", ");
        }

        public boolean addStringWithoutComma(String string) {
            return this.addString(string, " ");
        }

        public boolean addStringWithoutSeparator(String string) {
            return this.addString(string, "");
        }

        public String toString() {
            if (this.buffer.length() == 0) {
                return null;
            }
            return this.buffer.toString();
        }

        public boolean isEmpty() {
            return this.buffer.length() == 0;
        }
    }
}

