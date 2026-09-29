.version 50 0 
.class public super [238] 
.super [240] 
.implements [242] 
.field private static final [243] [244] 
.field private final [245] [246] 
.field private final [247] [248] 
.field private final [249] [250] 

.method public [252] : [253] 
    .attribute [251] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [51] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [37] 
L14:    putfield [52] 
L17:    aload_0 
L18:    aload_3 
L19:    putfield [53] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [251] .code stack 7 locals 7 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [40] 
L11:    pop 
L12:    iconst_0 
L13:    anewarray [4] 
L16:    astore_1 
L17:    aload_0 
L18:    getfield [39] 
L21:    invokevirtual [41] 
L24:    invokevirtual [42] 
L27:    astore_3 
L28:    aload_3 
L29:    ifnull L194 
L32:    aload_3 
L33:    invokeinterface [55] 0 
L38:    astore 4 
L40:    aload_3 
L41:    invokeinterface [56] 0 
L46:    astore 5 
L48:    aload 4 
L50:    ifnull L164 
L53:    aload 4 
L55:    arraylength 
L56:    ifle L164 
L59:    aload 5 
L61:    ifnull L164 
L64:    aload 5 
L66:    arraylength 
L67:    ifle L164 
L70:    bipush 10 
L72:    aload 4 
L74:    arraylength 
L75:    invokestatic [5] 
L78:    istore 6 
L80:    iload 6 
L82:    anewarray [4] 
L85:    astore_1 
L86:    iconst_0 
L87:    istore 7 
L89:    iload 7 
L91:    iload 6 
L93:    if_icmpge L161 
L96:    aload_1 
L97:    iload 7 
L99:    new [54] 
L102:   dup 
L103:   invokespecial [49] 
L106:   aastore 
L107:   aload_1 
L108:   iload 7 
L110:   aaload 
L111:   aload 4 
L113:   iload 7 
L115:   iaload 
L116:   putfield [57] 
L119:   aload_1 
L120:   iload 7 
L122:   aaload 
L123:   aload 5 
L125:   iload 7 
L127:   iaload 
L128:   putfield [58] 
L131:   aload_0 
L132:   getfield [38] 
L135:   ldc [2] 
L137:   ldc [6] 
L139:   aload 4 
L141:   iload 7 
L143:   iaload 
L144:   i2l 
L145:   aload 5 
L147:   iload 7 
L149:   iaload 
L150:   i2l 
L151:   invokevirtual [43] 
L154:   pop 
L155:   iinc 7 1 
L158:   goto L89 
L161:   goto L176 
L164:   aload_0 
L165:   getfield [38] 
L168:   ldc [7] 
L170:   ldc [8] 
L172:   invokevirtual [40] 
L175:   pop 
L176:   aload_0 
L177:   getfield [38] 
L180:   ldc [2] 
L182:   ldc [9] 
L184:   aload_1 
L185:   arraylength 
L186:   i2l 
L187:   invokevirtual [44] 
L190:   pop 
L191:   goto L206 
L194:   aload_0 
L195:   getfield [38] 
L198:   ldc [7] 
L200:   ldc [10] 
L202:   invokevirtual [40] 
L205:   pop 
L206:   aload_1 
L207:   areturn 
L208:   
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [251] .code stack 7 locals 8 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     invokevirtual [40] 
L11:    pop 
L12:    aload_0 
L13:    getfield [39] 
L16:    invokevirtual [41] 
L19:    invokevirtual [42] 
L22:    astore_2 
L23:    iconst_0 
L24:    newarray int 
L26:    astore_3 
L27:    iconst_0 
L28:    newarray int 
L30:    astore 4 
L32:    iconst_0 
L33:    newarray int 
L35:    astore 5 
L37:    iconst_0 
L38:    newarray int 
L40:    astore 6 
L42:    aload_2 
L43:    invokeinterface [55] 0 
L48:    ifnull L87 
L51:    aload_2 
L52:    invokeinterface [56] 0 
L57:    ifnull L87 
L60:    aload_2 
L61:    invokeinterface [55] 0 
L66:    astore_3 
L67:    aload_2 
L68:    invokeinterface [56] 0 
L73:    astore 4 
L75:    aload_3 
L76:    arraylength 
L77:    newarray int 
L79:    astore 5 
L81:    aload_3 
L82:    arraylength 
L83:    newarray int 
L85:    astore 6 
L87:    aload_3 
L88:    ifnull L263 
L91:    aload_3 
L92:    arraylength 
L93:    ifle L263 
L96:    aload 4 
L98:    ifnull L263 
L101:   aload 4 
L103:   arraylength 
L104:   ifle L263 
L107:   iconst_0 
L108:   istore 7 
L110:   iload 7 
L112:   aload_3 
L113:   arraylength 
L114:   if_icmpge L260 
L117:   aload_1 
L118:   ifnull L188 
L121:   aload 5 
L123:   iload 7 
L125:   aload_1 
L126:   invokevirtual [45] 
L129:   aload_1 
L130:   invokevirtual [46] 
L133:   aload 4 
L135:   iload 7 
L137:   iaload 
L138:   aload_3 
L139:   iload 7 
L141:   iaload 
L142:   invokestatic [13] 
L145:   iastore 
L146:   aload_1 
L147:   aload 4 
L149:   iload 7 
L151:   iaload 
L152:   aload_3 
L153:   iload 7 
L155:   iaload 
L156:   invokestatic [14] 
L159:   istore 8 
L161:   aload_0 
L162:   getfield [36] 
L165:   aload_1 
L166:   invokeinterface [59] 0 
L171:   istore 9 
L173:   aload 6 
L175:   iload 7 
L177:   iload 8 
L179:   iload 9 
L181:   invokestatic [15] 
L184:   iastore 
L185:   goto L208 
L188:   aload 5 
L190:   iload 7 
L192:   iconst_0 
L193:   iastore 
L194:   aload 6 
L196:   iload 7 
L198:   iconst_0 
L199:   iastore 
L200:   new [60] 
L203:   dup 
L204:   invokespecial [50] 
L207:   astore_1 
L208:   aload_0 
L209:   getfield [38] 
L212:   ldc [11] 
L214:   ldc [17] 
L216:   aload 5 
L218:   iload 7 
L220:   iaload 
L221:   i2l 
L222:   aload 6 
L224:   iload 7 
L226:   iaload 
L227:   i2l 
L228:   invokevirtual [43] 
L231:   pop 
L232:   aload_0 
L233:   getfield [38] 
L236:   ldc [11] 
L238:   ldc [18] 
L240:   aload_1 
L241:   invokevirtual [46] 
L244:   i2l 
L245:   aload_1 
L246:   invokevirtual [45] 
L249:   i2l 
L250:   invokevirtual [43] 
L253:   pop 
L254:   iinc 7 1 
L257:   goto L110 
L260:   goto L275 
L263:   aload_0 
L264:   getfield [38] 
L267:   ldc [11] 
L269:   ldc [19] 
L271:   invokevirtual [40] 
L274:   pop 
L275:   aload_2 
L276:   ifnull L309 
L279:   aload_0 
L280:   getfield [38] 
L283:   ldc [11] 
L285:   ldc [20] 
L287:   aload 5 
L289:   arraylength 
L290:   i2l 
L291:   aload 6 
L293:   arraylength 
L294:   i2l 
L295:   invokevirtual [43] 
L298:   pop 
L299:   aload_2 
L300:   aload 5 
L302:   aload 6 
L304:   invokeinterface [61] 0 
L309:   return 
L310:   nop 
L311:   nop 
L312:   
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [251] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [11] 
L6:     ldc [21] 
L8:     invokevirtual [40] 
L11:    pop 
L12:    bipush 10 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [251] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [2] 
L6:     ldc [22] 
L8:     aload_1 
L9:     invokevirtual [47] 
L12:    pop 
L13:    aload_0 
L14:    getfield [39] 
L17:    invokevirtual [41] 
L20:    invokevirtual [42] 
L23:    astore_2 
L24:    aload_2 
L25:    ifnull L53 
L28:    aload_0 
L29:    getfield [38] 
L32:    ldc [2] 
L34:    ldc [23] 
L36:    aload_1 
L37:    arraylength 
L38:    i2l 
L39:    invokevirtual [44] 
L42:    pop 
L43:    aload_2 
L44:    aload_1 
L45:    invokeinterface [62] 0 
L50:    goto L65 
L53:    aload_0 
L54:    getfield [38] 
L57:    ldc [2] 
L59:    ldc [24] 
L61:    invokevirtual [40] 
L64:    pop 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [251] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [11] 
L6:     ldc [25] 
L8:     invokevirtual [40] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [63] 
.const [4] = Class [64] 
.const [5] = Method [65] [66] 
.const [6] = String [67] 
.const [7] = Int -1601830656 
.const [8] = String [68] 
.const [9] = String [69] 
.const [10] = String [70] 
.const [11] = Int -2137614336 
.const [12] = String [71] 
.const [13] = Method [72] [73] 
.const [14] = Method [74] [75] 
.const [15] = Method [76] [77] 
.const [16] = Class [78] 
.const [17] = String [79] 
.const [18] = String [80] 
.const [19] = String [81] 
.const [20] = String [82] 
.const [21] = String [83] 
.const [22] = String [84] 
.const [23] = String [85] 
.const [24] = String [86] 
.const [25] = String [87] 
.const [26] = Class [88] 
.const [27] = Class [89] 
.const [28] = Class [90] 
.const [29] = Class [91] 
.const [30] = Class [92] 
.const [31] = Class [93] 
.const [32] = Class [94] 
.const [33] = Class [95] 
.const [34] = Class [96] 
.const [35] = Class [97] 
.const [36] = Field [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Field [102] [103] 
.const [39] = Field [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Method [114] [115] 
.const [45] = Method [116] [117] 
.const [46] = Method [118] [119] 
.const [47] = Method [120] [121] 
.const [48] = Method [122] [123] 
.const [49] = Method [124] [125] 
.const [50] = Method [126] [127] 
.const [51] = Field [128] [129] 
.const [52] = Field [130] [131] 
.const [53] = Field [132] [133] 
.const [54] = Class [134] 
.const [55] = InterfaceMethod [135] [136] 
.const [56] = InterfaceMethod [137] [138] 
.const [57] = Field [139] [140] 
.const [58] = Field [141] [142] 
.const [59] = InterfaceMethod [143] [144] 
.const [60] = Class [145] 
.const [61] = InterfaceMethod [146] [147] 
.const [62] = InterfaceMethod [148] [149] 
.const [63] = Utf8 'RemoteHMIResultRRDListProvider#getRRDCalculationList: Called' 
.const [64] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [65] = Class [150] 
.const [66] = NameAndType [151] [152] 
.const [67] = Utf8 'RemoteHMIResultRRDListProvider#getRRDCalculationList: lat %1, lon %2' 
.const [68] = Utf8 'RemoteHMIResultRRDListProvider#triggerRRDCalculation() - Failed to trigger RRD calculation!' 
.const [69] = Utf8 'RemoteHMIResultRRDListProvider#getRRDCalculationList: requesting RRD with %1 entries' 
.const [70] = Utf8 'RemoteHMIResultRRDListProvider#getRRDCalculationList: naviService empty, no calculation possible' 
.const [71] = Utf8 'RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: Called' 
.const [72] = Class [153] 
.const [73] = NameAndType [154] [155] 
.const [74] = Class [156] 
.const [75] = NameAndType [157] [158] 
.const [76] = Class [159] 
.const [77] = NameAndType [160] [161] 
.const [78] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [79] = Utf8 'RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: distance %1, direction %2' 
.const [80] = Utf8 'RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: vehiclepos lat %1, vehiclepos lon %2' 
.const [81] = Utf8 'RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: requested Lat and lon empty' 
.const [82] = Utf8 'RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: updating %1/%2 entries of distances and directions' 
.const [83] = Utf8 'RemoteHMIResultRRDListProvider#getRRDListCalculationLimit()' 
.const [84] = Utf8 'RemoteHMIResultRRDListProvider#updateRRDDistances: Called with distances %1' 
.const [85] = Utf8 'RemoteHMIResultRRDListProvider#updateRRDDistances: updating %1 entries' 
.const [86] = Utf8 'RemoteHMIResultRRDListProvider#updateRRDDistances: naviService null, not updating RRD distance' 
.const [87] = Utf8 'RemoteHMIResultRRDListProvider#unitsChanged()' 
.const [88] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [93] = Utf8 de/audi/tghu/navi/app/InterAppService 
.const [94] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [95] = Utf8 java/lang/Math 
.const [96] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [97] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [98] = Class [162] 
.const [99] = NameAndType [163] [164] 
.const [100] = Class [165] 
.const [101] = NameAndType [166] [167] 
.const [102] = Class [168] 
.const [103] = NameAndType [169] [170] 
.const [104] = Class [171] 
.const [105] = NameAndType [172] [173] 
.const [106] = Class [174] 
.const [107] = NameAndType [175] [176] 
.const [108] = Class [177] 
.const [109] = NameAndType [178] [179] 
.const [110] = Class [180] 
.const [111] = NameAndType [181] [182] 
.const [112] = Class [183] 
.const [113] = NameAndType [184] [185] 
.const [114] = Class [186] 
.const [115] = NameAndType [187] [188] 
.const [116] = Class [189] 
.const [117] = NameAndType [190] [191] 
.const [118] = Class [192] 
.const [119] = NameAndType [193] [194] 
.const [120] = Class [195] 
.const [121] = NameAndType [196] [197] 
.const [122] = Class [198] 
.const [123] = NameAndType [199] [200] 
.const [124] = Class [201] 
.const [125] = NameAndType [202] [203] 
.const [126] = Class [204] 
.const [127] = NameAndType [205] [206] 
.const [128] = Class [207] 
.const [129] = NameAndType [208] [209] 
.const [130] = Class [210] 
.const [131] = NameAndType [211] [212] 
.const [132] = Class [213] 
.const [133] = NameAndType [214] [215] 
.const [134] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [135] = Class [216] 
.const [136] = NameAndType [217] [218] 
.const [137] = Class [219] 
.const [138] = NameAndType [220] [221] 
.const [139] = Class [222] 
.const [140] = NameAndType [223] [224] 
.const [141] = Class [225] 
.const [142] = NameAndType [226] [227] 
.const [143] = Class [228] 
.const [144] = NameAndType [229] [230] 
.const [145] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [146] = Class [231] 
.const [147] = NameAndType [232] [233] 
.const [148] = Class [234] 
.const [149] = NameAndType [235] [236] 
.const [150] = Utf8 java/lang/Math 
.const [151] = Utf8 min 
.const [152] = Utf8 (II)I 
.const [153] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [154] = Utf8 computeAirDistance 
.const [155] = Utf8 (IIII)I 
.const [156] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [157] = Utf8 computeAbsoluteDirection 
.const [158] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;II)I 
.const [159] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [160] = Utf8 convertRotatingDirection 
.const [161] = Utf8 (II)I 
.const [162] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [163] = Utf8 vehicle 
.const [164] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [165] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [166] = Utf8 getPOILogChannel 
.const [167] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [168] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [169] = Utf8 poiLogChannel 
.const [170] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [171] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [172] = Utf8 navigation 
.const [173] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;)Z 
.const [177] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [178] = Utf8 getInterAppService 
.const [179] = Utf8 ()Lde/audi/tghu/navi/app/InterAppService; 
.const [180] = Utf8 de/audi/tghu/navi/app/InterAppService 
.const [181] = Utf8 getNaviOnlineService 
.const [182] = Utf8 ()Lde/audi/atip/interapp/NaviOnlineService; 
.const [183] = Utf8 de/audi/atip/log/LogChannel 
.const [184] = Utf8 log 
.const [185] = Utf8 (ILjava/lang/String;JJ)Z 
.const [186] = Utf8 de/audi/atip/log/LogChannel 
.const [187] = Utf8 log 
.const [188] = Utf8 (ILjava/lang/String;J)Z 
.const [189] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [190] = Utf8 getLongitude 
.const [191] = Utf8 ()I 
.const [192] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [193] = Utf8 getLatitude 
.const [194] = Utf8 ()I 
.const [195] = Utf8 de/audi/atip/log/LogChannel 
.const [196] = Utf8 log 
.const [197] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [198] = Utf8 java/lang/Object 
.const [199] = Utf8 <init> 
.const [200] = Utf8 ()V 
.const [201] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [202] = Utf8 <init> 
.const [203] = Utf8 ()V 
.const [204] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [208] = Utf8 vehicle 
.const [209] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [210] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [211] = Utf8 poiLogChannel 
.const [212] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [213] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [214] = Utf8 navigation 
.const [215] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [216] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [217] = Utf8 getRequestedLatitudes 
.const [218] = Utf8 ()[I 
.const [219] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [220] = Utf8 getRequestedLongitudes 
.const [221] = Utf8 ()[I 
.const [222] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [223] = Utf8 latitude 
.const [224] = Utf8 I 
.const [225] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [226] = Utf8 longitude 
.const [227] = Utf8 I 
.const [228] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [229] = Utf8 getHeading 
.const [230] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)I 
.const [231] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [232] = Utf8 updateDirectionAndAirDistance 
.const [233] = Utf8 ([I[I)V 
.const [234] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [235] = Utf8 updateRRDDistances 
.const [236] = Utf8 ([Lorg/dsi/ifc/navigation/RrdCalculationInfo;)V 
.const [237] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/RemoteHMIResultRRDListProvider 
.const [238] = Class [237] 
.const [239] = Utf8 java/lang/Object 
.const [240] = Class [239] 
.const [241] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider 
.const [242] = Class [241] 
.const [243] = Utf8 CALCULATION_LIMIT_RHMI_RESULT 
.const [244] = Utf8 I 
.const [245] = Utf8 poiLogChannel 
.const [246] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [247] = Utf8 vehicle 
.const [248] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [249] = Utf8 navigation 
.const [250] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [251] = Utf8 Code 
.const [252] = Utf8 <init> 
.const [253] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/guidance/IVehicle;Lde/audi/tghu/navi/app/Navigation;)V 
.const [254] = Utf8 getRRDCalculationList 
.const [255] = Utf8 ()[Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [256] = Utf8 updateDirectionAndAirDistance 
.const [257] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [258] = Utf8 getRRDListCalculationLimit 
.const [259] = Utf8 ()I 
.const [260] = Utf8 updateRRDDistances 
.const [261] = Utf8 ([Lorg/dsi/ifc/navigation/RrdCalculationInfo;)V 
.const [262] = Utf8 unitsChanged 
.const [263] = Utf8 ()V 
.end class 
