/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class AbstractTooltipFormatter
implements ITooltipFormatter {
    protected static final String ARROW_ONE_DIRECTION;
    protected static final String ARROW_BIDIRECTIONAL;
    protected final ITooltipFormatter$TooltipFormatterEnvironment env;

    public AbstractTooltipFormatter(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        this.env = iTooltipFormatter$TooltipFormatterEnvironment;
    }

    @Override
    public String formatAdbEntry(AdbEntry adbEntry, int n) {
        try {
            if (adbEntry != null) {
                String string = adbEntry.getCombinedName();
                AddressData addressData = MapUtils.extractAddressDataOfEntryType(adbEntry.getAddressData(), n);
                if (addressData == null) {
                    return null;
                }
                AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
                abstractTooltipFormatter$TooltipStringBuilder.addString(string);
                NavLocation navLocation = this.env.getNavLocation(addressData.getNavLocation());
                String string2 = LocationFormatter.formatCity(navLocation);
                String string3 = LocationFormatter.formatStreetHousenumber(navLocation);
                this.addCityAndStreet(abstractTooltipFormatter$TooltipStringBuilder, string2, string3);
                if (!abstractTooltipFormatter$TooltipStringBuilder.isEmpty()) {
                    return abstractTooltipFormatter$TooltipStringBuilder.toString();
                }
                this.env.getLogChannel().log(-2137614336, "AbstractTooltipFormatter#formatAdbEntry(): failed to format location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                return null;
            }
            this.env.getLogChannel().log(-2137614336, "AbstractTooltipFormatter#formatAdbEntry(): adbEntry is null");
            return null;
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "AbstractTooltipFormatter#formatAdbEntry() - %1", (Throwable)exception);
            return null;
        }
    }

    @Override
    public String formatHomeLocation(NavLocation navLocation) {
        return this.formatLocation(navLocation);
    }

    @Override
    public String formatPicNavLocation(NavLocation navLocation) {
        return this.formatLocation(navLocation);
    }

    protected void addCityAndStreet(AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder, String string, String string2) {
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(string);
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(string2);
    }

    @Override
    public String formatFallback(NavLocation navLocation) {
        String string = LocationFormatter.formatLatitude(navLocation);
        String string2 = LocationFormatter.formatLongitude(navLocation);
        if (Util.isEmpty(string) || Util.isEmpty(string2)) {
            this.env.getLogChannel().log(-2137614336, "AbstractTooltipFormatter#addCityAndStreet(): failed to format geocoordinates");
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
                    buffer.append(" <-> ");
                } else {
                    buffer.append(" -> ");
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

    protected abstract String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
    }

    @Override
    public String formatPOI3D(NavLocation navLocation) {
        return this.formatPOI(navLocation);
    }

    @Override
    public String formatBuilding(NavLocation navLocation) {
        return this.formatPOI(navLocation);
    }

    @Override
    public String formatTMC(TmcMessage tmcMessage) {
        return this.formatTMC(null, -1, -1, tmcMessage.getDirectionOfRoad1(), tmcMessage.getDirectionOfRoad2(), tmcMessage.isIsBidirectional(), tmcMessage.getEventText(), tmcMessage.getStartLocation(), tmcMessage.isIsArea(), tmcMessage.getAffectedRoadLength());
    }

    @Override
    public String formatTMC(TmcListElement tmcListElement) {
        return this.formatTMC(null, -1, -1, tmcListElement.getDirectionOfRoad1(), tmcListElement.getDirectionOfRoad2(), tmcListElement.isIsBidirectional(), new String[]{tmcListElement.description}, null, false, -1L);
    }
}

