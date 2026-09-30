/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.browser;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FunctionalLink {
    public static final String COMMAND_UNKNOWN = "unknown_command";
    public static final String COMMAND_REQUEST_LOCATION = "request_location";
    public static final String COMMAND_OPEN_URL = "open_url";
    public static final String COMMAND_QUIT = "quit";
    public static final String COMMAND_USE_ADDRESS = "use_address";
    public static final String COMMAND_USE_PHONE_NUMBER = "use_phone_number";
    public static final String COMMAND_ADD_TO_FAVORITE = "save_as_favorite";
    public static final String COMMAND_NAVIGATE_TO = "navigate_to";
    public static final String COMMAND_ADD_STOPOVER = "add_stopover";
    public static final String COMMAND_PLAY_VIDEO = "play_video";
    private static final String[] COMMAND_LIST = new String[]{"request_location", "open_url", "quit", "use_address", "use_phone_number", "add_stopover", "navigate_to", "play_video", "save_as_favorite"};
    public static final String PARAM_POIID = "poiid";
    public static final String PARAM_LATITUDE = "lat";
    public static final String PARAM_LONGITUDE = "lon";
    public static final String PARAM_URL = "url";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_DESC = "desc";
    public static final String PARAM_STREET = "street";
    public static final String PARAM_ZIP = "zip";
    public static final String PARAM_REGION = "region";
    public static final String PARAM_CITY = "city";
    public static final String PARAM_COUNTRY = "country";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_SPEED_LIMIT = "speedlimit";
    public static final String PARAM_FILE = "file";
    public static final String GLOBAL_VAR_CUR_LAT = "$(cur_lat)";
    public static final String GLOBAL_VAR_CUR_LON = "$(cur_lon)";
    public static final String GLOBAL_VAR_DEST_LAT = "$(dest_lat)";
    public static final String GLOBAL_VAR_DEST_LON = "$(dest_lon)";
    public static final String GLOBAL_VAR_VIN = "$(vin)";
    public static final String GLOBAL_VAR_REV = "$(rev)";
    public static final String GLOBAL_VAR_LAN = "$(lan)";
    public static final String GLOBAL_VAR_DAY = "$(day)";
    public static final String GLOBAL_VAR_OEM = "$(oem)";
    public static final String GLOBAL_VAR_XRES = "$(xres)";
    public static final String GLOBAL_VAR_YRES = "$(yres)";
    public static final String GLOBAL_VAR_UNIT_DIST = "$(unitDist)";
    public static final String GLOBAL_VAR_UNIT_VEL = "$(unitVel)";
    public static final String GLOBAL_VAR_UNIT_TEMP = "$(unitTemp)";
    public static final String GLOBAL_VAR_UNIT_PRESS = "$(unitPress)";
    public static final String GLOBAL_VAR_UNIT_FUEL = "$(unitFuel)";
    public static final String GLOBAL_VAR_CUR_HEADING = "$(cur_heading)";
    public static final String GLOBAL_VAR_HU_REGION = "$(hu_region)";
    public static final String[] GLOBAL_VARIABLES = new String[]{"$(cur_lat)", "$(cur_lon)", "$(dest_lat)", "$(dest_lon)", "$(vin)", "$(rev)", "$(lan)", "$(day)", "$(oem)", "$(xres)", "$(yres)", "$(unitDist)", "$(unitVel)", "$(unitTemp)", "$(unitPress)", "$(unitFuel)", "$(cur_heading)", "$(hu_region)"};
    public static final String VAR_REQUEST_LOCATION_LONGITUDE = "$(in_lon)";
    public static final String VAR_REQUEST_LOCATION_LATITUDE = "$(in_lat)";
    private static final String[] REQUEST_LOCATION_VARIABLES = new String[]{"$(in_lon)", "$(in_lat)"};
    private static final String EFI_PREFIX = "action:";
    private static final char CHAR_PARAM_START = '?';
    private static final char CHAR_PARAM_SEPERATOR = '&';
    private static final char CHAR_PARAM_END = '=';
    private static final char CHAR_GLOBAL_VAR_START = '$';
    private static final char CHAR_GLOBAL_VAR_END = ')';
    private String functionalLinkStr;
    private String command;
    private Map parameterMap;
    private Map variableMap;
    private LogChannel logChannel;

    public FunctionalLink(LogChannel logChannel, String string) {
        this.logChannel = logChannel;
        this.parameterMap = new HashMap();
        this.variableMap = new HashMap();
        this.functionalLinkStr = string;
        if (string != null) {
            this.parseFunctionalLink();
        }
    }

    public String getCommand() {
        return this.command;
    }

    public Set getParameters() {
        return new HashSet(this.parameterMap.keySet());
    }

    public Set getVariables() {
        return new HashSet(this.variableMap.keySet());
    }

    public String getValue(String string) {
        return this.getValue(string, true);
    }

    public String getValue(String string, boolean bl) {
        if (string != null) {
            Object object = null;
            if (this.parameterMap != null) {
                object = this.parameterMap.get(string);
            }
            if (this.variableMap != null && object == null && (object = this.variableMap.get(string)) instanceof VariableValue) {
                object = ((VariableValue)object).value;
            }
            if (object instanceof String) {
                if (bl) {
                    return URLDecoder.decode((String)object);
                }
                return (String)object;
            }
        }
        return null;
    }

    public void setValue(String string, String string2) {
        if (string != null) {
            String string3 = this.getVariableKey(string);
            if (this.variableMap != null && string3 != null && this.variableMap.containsKey(string3)) {
                VariableValue variableValue = null;
                Object object = this.variableMap.get(string3);
                if (object instanceof VariableValue) {
                    variableValue = (VariableValue)object;
                    variableValue.value = string2;
                } else if (this.logChannel != null) {
                    this.logChannel.log(100000, "FunctionalLink#setValue(variable, value) - can not set unknown variable: %1", (Object)string);
                }
            }
        }
    }

    public String getUrl() {
        Object object = this.parameterMap.get(PARAM_URL);
        if (object instanceof String) {
            String string = (String)object;
            string = this.decodeUrl(string);
            return this.replaceAllVariables(string);
        }
        return null;
    }

    public String toString() {
        String string = this.functionalLinkStr.substring(EFI_PREFIX.length());
        this.replaceAllVariables(string);
        return string;
    }

    private String decodeUrl(String string) {
        String string2 = string;
        string2 = this.replace(string2, "%26", "&");
        string2 = this.replace(string2, "%3D", "=");
        string2 = this.replace(string2, "%2F", "/");
        string2 = this.replace(string2, "%3F", "?");
        string2 = this.replace(string2, "%3A", ":");
        return string2;
    }

    private String replaceAllVariables(String string) {
        String string2 = string;
        if (COMMAND_OPEN_URL.equalsIgnoreCase(this.command)) {
            string2 = this.replaceVariables(GLOBAL_VARIABLES, string2, true);
            string2 = this.replaceVariables(GLOBAL_VARIABLES, string2, false);
        } else if (COMMAND_REQUEST_LOCATION.equalsIgnoreCase(this.command)) {
            string2 = this.replaceVariables(GLOBAL_VARIABLES, string2, true);
            string2 = this.replaceVariables(GLOBAL_VARIABLES, string2, false);
            string2 = this.replaceVariables(REQUEST_LOCATION_VARIABLES, string2, true);
            string2 = this.replaceVariables(REQUEST_LOCATION_VARIABLES, string2, false);
        } else {
            string2 = this.replaceVariables(GLOBAL_VARIABLES, string2, false);
        }
        return string2;
    }

    private String replaceVariables(String[] stringArray, String string, boolean bl) {
        String string2 = string;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string3;
            Object object = this.variableMap.get(stringArray[i2]);
            if (!(object instanceof VariableValue)) continue;
            VariableValue variableValue = (VariableValue)object;
            String string4 = variableValue.placeholder;
            if (string4 == null) continue;
            if (bl) {
                string4 = this.encodeVariable(string4);
            }
            if ((string3 = variableValue.value) == null) continue;
            string3 = URLEncoder.encode(string3);
            string2 = this.replace(string2, string4, string3);
        }
        return string2;
    }

    private String encodeVariable(String string) {
        if (string != null && string.length() > 0) {
            return URLEncoder.encode(string);
        }
        return null;
    }

    private String replace(String string, String string2, String string3) {
        if (string == null || string2 == null) {
            if (this.logChannel != null) {
                this.logChannel.log(100000, "FunctionalLink#replace() source: %1, pattern: %2 - either one was null => return source", (Object)string, (Object)string2);
            }
            return string;
        }
        int n = string2.length();
        Buffer buffer = new Buffer();
        int n2 = -1;
        int n3 = 0;
        while ((n2 = string.indexOf(string2, n3)) != -1) {
            buffer.append(string.substring(n3, n2));
            buffer.append(string3);
            n3 = n2 + n;
        }
        buffer.append(string.substring(n3));
        return buffer.toString();
    }

    private void parseFunctionalLink() {
        if (this.functionalLinkStr.toLowerCase().startsWith(EFI_PREFIX)) {
            String string = this.functionalLinkStr.substring(EFI_PREFIX.length());
            for (int i2 = 0; i2 < COMMAND_LIST.length; ++i2) {
                if (!string.startsWith(COMMAND_LIST[i2])) continue;
                this.command = COMMAND_LIST[i2];
                string = string.substring(COMMAND_LIST[i2].length());
                break;
            }
            if (this.command == null) {
                this.command = COMMAND_UNKNOWN;
            } else {
                if (COMMAND_QUIT.equalsIgnoreCase(this.command)) {
                    return;
                }
                this.findVariables(string);
                this.findParameters(string);
            }
        } else {
            this.findParameters(this.functionalLinkStr);
        }
    }

    private void findParameters(String string) {
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(string);
        int n = -1;
        int n2 = -1;
        String string2 = null;
        boolean bl = false;
        char c2 = stringCharacterIterator.first();
        while (!bl) {
            switch (c2) {
                case '&': 
                case '?': 
                case '\uffff': {
                    if (c2 == '\uffff') {
                        bl = true;
                    }
                    n = stringCharacterIterator.getIndex();
                    int n3 = stringCharacterIterator.getIndex();
                    if (n2 > -1 && n3 > -1) {
                        String string3 = null;
                        if (++n2 != n3) {
                            string3 = string.substring(n2, n3);
                        }
                        if (string2 != null) {
                            string2 = string2.toLowerCase();
                            if (string3 != null) {
                                String string4 = this.getVariableKey(string3);
                                if (string4 != null && this.variableMap.containsKey(string4)) {
                                    if (this.logChannel != null) {
                                        this.logChannel.log(10000000, "FunctionalLink#findParameters - ignore param with global variable value: %1 = %2", (Object)string2, (Object)string3);
                                    }
                                } else {
                                    this.parameterMap.put(string2, string3);
                                    if (this.logChannel != null) {
                                        this.logChannel.log(10000000, "FunctionalLink#findParameters - found param: %1 = %2", (Object)string2, (Object)string3);
                                    }
                                }
                            } else {
                                this.parameterMap.put(string2, null);
                                if (this.logChannel != null) {
                                    this.logChannel.log(10000000, "FunctionalLink#findParameters - found empty param: %1 = null", (Object)string2);
                                }
                            }
                            string2 = null;
                        }
                    }
                    n2 = -1;
                    break;
                }
                case '=': {
                    int n4 = stringCharacterIterator.getIndex();
                    n2 = stringCharacterIterator.getIndex();
                    if (n > -1 && n4 > -1) {
                        string2 = string.substring(n + 1, n4);
                    }
                    n = -1;
                    break;
                }
            }
            c2 = stringCharacterIterator.next();
        }
    }

    private void findVariables(String string) {
        String string2 = string;
        if (COMMAND_REQUEST_LOCATION.equalsIgnoreCase(this.command) || COMMAND_OPEN_URL.equalsIgnoreCase(this.command)) {
            string2 = URLDecoder.decode(string2);
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(string2);
        int n = -1;
        boolean bl = false;
        char c2 = stringCharacterIterator.first();
        while (!bl) {
            switch (c2) {
                case '\uffff': {
                    bl = true;
                    break;
                }
                case '$': {
                    n = stringCharacterIterator.getIndex();
                    break;
                }
                case ')': {
                    String string3;
                    String string4;
                    int n2 = stringCharacterIterator.getIndex();
                    if (n > -1 && n2 > -1 && (string4 = this.getVariableKey(string3 = string2.substring(n, n2 + 1))) != null) {
                        this.variableMap.put(string4, new VariableValue(string3));
                        if (this.logChannel != null) {
                            this.logChannel.log(10000000, "found global variable: %1", (Object)string4);
                        }
                    }
                    n = -1;
                    break;
                }
            }
            c2 = stringCharacterIterator.next();
        }
    }

    private String getVariableKey(String string) {
        String string2 = null;
        if (string != null) {
            int n;
            for (n = 0; n < GLOBAL_VARIABLES.length; ++n) {
                string2 = GLOBAL_VARIABLES[n];
                if (!string.equalsIgnoreCase(string2)) continue;
                return string2;
            }
            for (n = 0; n < REQUEST_LOCATION_VARIABLES.length; ++n) {
                string2 = REQUEST_LOCATION_VARIABLES[n];
                if (!string.equalsIgnoreCase(string2)) continue;
                return string2;
            }
        }
        return null;
    }

    private static class VariableValue {
        String placeholder;
        String value;

        public VariableValue(String string) {
            this(string, null);
        }

        public VariableValue(String string, String string2) {
            this.placeholder = string;
            this.value = string2;
        }
    }
}

