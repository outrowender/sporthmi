.version 50 0 
.class public super [260] 
.super [262] 
.field private [263] [264] 
.field public static final [265] [266] 
.field protected [267] [268] 
.field protected [269] [270] 
.field protected [271] [272] 

.method public [274] : [275] 
    .attribute [273] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [44] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [47] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [48] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [49] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [276] : [277] 
    .attribute [273] .code stack 9 locals 9 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [45] 
L7:     astore_2 
L8:     aload_1 
L9:     invokeinterface [51] 0 
L14:    astore_3 
L15:    aload_3 
L16:    ifnull L28 
L19:    aload_3 
L20:    invokeinterface [52] 0 
L25:    goto L29 
L28:    aconst_null 
L29:    astore 4 
L31:    aload 4 
L33:    ifnonnull L45 
L36:    aconst_null 
L37:    astore 5 
L39:    aconst_null 
L40:    astore 6 
L42:    goto L71 
L45:    aload 4 
L47:    invokevirtual [34] 
L50:    invokestatic [3] 
L53:    invokestatic [4] 
L56:    astore 5 
L58:    aload 4 
L60:    invokevirtual [35] 
L63:    invokestatic [3] 
L66:    invokestatic [4] 
L69:    astore 6 
L71:    aload_1 
L72:    invokeinterface [53] 0 
L77:    invokestatic [4] 
L80:    astore 7 
L82:    aload_0 
L83:    getfield [32] 
L86:    ldc [5] 
L88:    ldc [6] 
L90:    aload 5 
L92:    aload 6 
L94:    aload 7 
L96:    invokevirtual [36] 
L99:    new [54] 
L102:   dup 
L103:   aload_0 
L104:   aload_1 
L105:   aload_2 
L106:   aload 7 
L108:   aload 4 
L110:   aload 5 
L112:   aload 6 
L114:   invokespecial [46] 
L117:   astore 8 
L119:   aload_1 
L120:   aload 8 
L122:   ldc [8] 
L124:   invokeinterface [55] 0 
L129:   pop 
L130:   aload_2 
L131:   invokevirtual [37] 
L134:   ifeq L138 
L137:   return 
L138:   aload_0 
L139:   getfield [33] 
L142:   invokevirtual [38] 
L145:   invokevirtual [39] 
L148:   astore 9 
L150:   aload 9 
L152:   ifnull L165 
L155:   aload 9 
L157:   invokeinterface [56] 0 
L162:   ifne L202 
L165:   aload 9 
L167:   ifnull L183 
L170:   aload 9 
L172:   invokeinterface [56] 0 
L177:   invokestatic [9] 
L180:   goto L185 
L183:   ldc [10] 
L185:   astore 10 
L187:   aload_0 
L188:   getfield [32] 
L191:   ldc [11] 
L193:   ldc [12] 
L195:   aload 10 
L197:   invokevirtual [40] 
L200:   pop 
L201:   return 
L202:   aload_0 
L203:   getfield [32] 
L206:   ldc [5] 
L208:   ldc [13] 
L210:   aload_0 
L211:   getfield [31] 
L214:   aload 4 
L216:   invokevirtual [41] 
L219:   pop 
L220:   aload_0 
L221:   getfield [31] 
L224:   ifeq L255 
L227:   aload 4 
L229:   ifnonnull L255 
L232:   aload_0 
L233:   getfield [32] 
L236:   ldc [5] 
L238:   ldc [14] 
L240:   invokevirtual [42] 
L243:   pop 
L244:   aload 9 
L246:   aload_2 
L247:   invokeinterface [57] 0 
L252:   goto L275 
L255:   aload_0 
L256:   getfield [32] 
L259:   ldc [5] 
L261:   ldc [15] 
L263:   invokevirtual [42] 
L266:   pop 
L267:   aload 9 
L269:   aload_2 
L270:   invokeinterface [58] 0 
L275:   return 
L276:   
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [273] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [38] 
L7:     invokevirtual [39] 
L10:    astore_1 
L11:    aload_1 
L12:    ifnull L42 
L15:    aload_0 
L16:    getfield [32] 
L19:    ldc [5] 
L21:    ldc [16] 
L23:    invokevirtual [42] 
L26:    pop 
L27:    aload_1 
L28:    invokeinterface [59] 0 
L33:    aload_1 
L34:    invokeinterface [60] 0 
L39:    goto L54 
L42:    aload_0 
L43:    getfield [32] 
L46:    ldc [11] 
L48:    ldc [17] 
L50:    invokevirtual [42] 
L53:    pop 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [280] : [281] 
    .attribute [273] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [47] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [273] .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [38] 
L7:     invokevirtual [39] 
L10:    astore 4 
L12:    aload 4 
L14:    ifnull L69 
L17:    aload 4 
L19:    invokeinterface [56] 0 
L24:    ifeq L69 
L27:    aload_3 
L28:    invokeinterface [61] 0 
L33:    astore 5 
L35:    aload 5 
L37:    invokevirtual [34] 
L40:    invokestatic [3] 
L43:    istore 6 
L45:    aload 5 
L47:    invokevirtual [35] 
L50:    invokestatic [3] 
L53:    istore 7 
L55:    aload 4 
L57:    aload_1 
L58:    aload_2 
L59:    aload_3 
L60:    iload 6 
L62:    iload 7 
L64:    invokeinterface [62] 0 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public interface [284] : [285] 
    .attribute [273] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [286] : [287] 
    .attribute [273] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [63] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [64] 
.const [3] = Method [65] [66] 
.const [4] = Method [67] [68] 
.const [5] = Int 1078071040 
.const [6] = String [69] 
.const [7] = Class [70] 
.const [8] = Int -129 
.const [9] = Method [71] [72] 
.const [10] = String [73] 
.const [11] = Int -1601830656 
.const [12] = String [74] 
.const [13] = String [75] 
.const [14] = String [76] 
.const [15] = String [77] 
.const [16] = String [78] 
.const [17] = String [79] 
.const [18] = Class [80] 
.const [19] = Class [81] 
.const [20] = Class [82] 
.const [21] = Class [83] 
.const [22] = Class [84] 
.const [23] = Class [85] 
.const [24] = Class [86] 
.const [25] = Class [87] 
.const [26] = Class [88] 
.const [27] = Class [89] 
.const [28] = Class [90] 
.const [29] = Class [91] 
.const [30] = Class [92] 
.const [31] = Field [93] [94] 
.const [32] = Field [95] [96] 
.const [33] = Field [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Method [109] [110] 
.const [40] = Method [111] [112] 
.const [41] = Method [113] [114] 
.const [42] = Method [115] [116] 
.const [43] = Field [117] [118] 
.const [44] = Method [119] [120] 
.const [45] = Method [121] [122] 
.const [46] = Method [123] [124] 
.const [47] = Field [125] [126] 
.const [48] = Field [127] [128] 
.const [49] = Field [129] [130] 
.const [50] = Class [131] 
.const [51] = InterfaceMethod [132] [133] 
.const [52] = InterfaceMethod [134] [135] 
.const [53] = InterfaceMethod [136] [137] 
.const [54] = Class [138] 
.const [55] = InterfaceMethod [139] [140] 
.const [56] = InterfaceMethod [141] [142] 
.const [57] = InterfaceMethod [143] [144] 
.const [58] = InterfaceMethod [145] [146] 
.const [59] = InterfaceMethod [147] [148] 
.const [60] = InterfaceMethod [149] [150] 
.const [61] = InterfaceMethod [151] [152] 
.const [62] = InterfaceMethod [153] [154] 
.const [63] = Field [155] [156] 
.const [64] = Utf8 java/util/ArrayList 
.const [65] = Class [157] 
.const [66] = NameAndType [158] [159] 
.const [67] = Class [160] 
.const [68] = NameAndType [161] [162] 
.const [69] = Utf8 'RrdCalculationHandler#triggerRrdCalculation: reference point (%1;%2) set for list start=%3' 
.const [70] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler$1 
.const [71] = Class [163] 
.const [72] = NameAndType [164] [165] 
.const [73] = Utf8 null 
.const [74] = Utf8 'RrdCalculationHandler#triggerRrdCalculation: navi not available or not fully operable (%1), cannot trigger RRD calculation' 
.const [75] = Utf8 'RrdCalculationHandler#triggerRrdCalculation: RRD calculation enabled = %1, referencePoint=%2' 
.const [76] = Utf8 'RrdCalculationHandler#triggerRrdCalculation: triggering RRD distance calculation' 
.const [77] = Utf8 'RrdCalculationHandler#triggerRrdCalculation: triggering air distance calculation' 
.const [78] = Utf8 'RrdCalculationHandler#exitRRD(): stopping Rrd calculation' 
.const [79] = Utf8 'RrdCalculationHandler#exitRrd() rrd calculation not stopped because navi was null' 
.const [80] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [81] = Utf8 java/lang/Object 
.const [82] = Utf8 de/audi/remotehmi/ui/mib2/grid/IGridList 
.const [83] = Utf8 de/audi/remotehmi/ui/mib2/grid/IReferencePoint 
.const [84] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [85] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [86] = Utf8 de/audi/atip/util/Util 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [89] = Utf8 de/audi/tghu/online/app/remotehmi/NaviComponent 
.const [90] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [91] = Utf8 java/lang/Boolean 
.const [92] = Utf8 de/audi/remotehmi/ui/mib2/grid/IGrid 
.const [93] = Class [166] 
.const [94] = NameAndType [167] [168] 
.const [95] = Class [169] 
.const [96] = NameAndType [170] [171] 
.const [97] = Class [172] 
.const [98] = NameAndType [173] [174] 
.const [99] = Class [175] 
.const [100] = NameAndType [176] [177] 
.const [101] = Class [178] 
.const [102] = NameAndType [179] [180] 
.const [103] = Class [181] 
.const [104] = NameAndType [182] [183] 
.const [105] = Class [184] 
.const [106] = NameAndType [185] [186] 
.const [107] = Class [187] 
.const [108] = NameAndType [188] [189] 
.const [109] = Class [190] 
.const [110] = NameAndType [191] [192] 
.const [111] = Class [193] 
.const [112] = NameAndType [194] [195] 
.const [113] = Class [196] 
.const [114] = NameAndType [197] [198] 
.const [115] = Class [199] 
.const [116] = NameAndType [200] [201] 
.const [117] = Class [202] 
.const [118] = NameAndType [203] [204] 
.const [119] = Class [205] 
.const [120] = NameAndType [206] [207] 
.const [121] = Class [208] 
.const [122] = NameAndType [209] [210] 
.const [123] = Class [211] 
.const [124] = NameAndType [212] [213] 
.const [125] = Class [214] 
.const [126] = NameAndType [215] [216] 
.const [127] = Class [217] 
.const [128] = NameAndType [218] [219] 
.const [129] = Class [220] 
.const [130] = NameAndType [221] [222] 
.const [131] = Utf8 java/util/ArrayList 
.const [132] = Class [223] 
.const [133] = NameAndType [224] [225] 
.const [134] = Class [226] 
.const [135] = NameAndType [227] [228] 
.const [136] = Class [229] 
.const [137] = NameAndType [230] [231] 
.const [138] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler$1 
.const [139] = Class [232] 
.const [140] = NameAndType [233] [234] 
.const [141] = Class [235] 
.const [142] = NameAndType [236] [237] 
.const [143] = Class [238] 
.const [144] = NameAndType [239] [240] 
.const [145] = Class [241] 
.const [146] = NameAndType [242] [243] 
.const [147] = Class [244] 
.const [148] = NameAndType [245] [246] 
.const [149] = Class [247] 
.const [150] = NameAndType [248] [249] 
.const [151] = Class [250] 
.const [152] = NameAndType [251] [252] 
.const [153] = Class [253] 
.const [154] = NameAndType [254] [255] 
.const [155] = Class [256] 
.const [156] = NameAndType [257] [258] 
.const [157] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [158] = Utf8 degreeToWgs84 
.const [159] = Utf8 (D)I 
.const [160] = Utf8 de/audi/atip/util/Util 
.const [161] = Utf8 createInteger 
.const [162] = Utf8 (I)Ljava/lang/Integer; 
.const [163] = Utf8 java/lang/Boolean 
.const [164] = Utf8 toString 
.const [165] = Utf8 (Z)Ljava/lang/String; 
.const [166] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [167] = Utf8 isRrdCalculationEnabled 
.const [168] = Utf8 Z 
.const [169] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [170] = Utf8 logChannel 
.const [171] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [172] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [173] = Utf8 remoteHmiService 
.const [174] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [175] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [176] = Utf8 getLatitude 
.const [177] = Utf8 ()D 
.const [178] = Utf8 de/audi/remotehmi/ui/mib2/grid/GeoPosition 
.const [179] = Utf8 getLongitude 
.const [180] = Utf8 ()D 
.const [181] = Utf8 de/audi/atip/log/LogChannel 
.const [182] = Utf8 log 
.const [183] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [184] = Utf8 java/util/ArrayList 
.const [185] = Utf8 isEmpty 
.const [186] = Utf8 ()Z 
.const [187] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [188] = Utf8 getNaviComponent 
.const [189] = Utf8 ()Lde/audi/tghu/online/app/remotehmi/NaviComponent; 
.const [190] = Utf8 de/audi/tghu/online/app/remotehmi/NaviComponent 
.const [191] = Utf8 getNaviOnlineService 
.const [192] = Utf8 ()Lde/audi/atip/interapp/NaviOnlineService; 
.const [193] = Utf8 de/audi/atip/log/LogChannel 
.const [194] = Utf8 log 
.const [195] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [196] = Utf8 de/audi/atip/log/LogChannel 
.const [197] = Utf8 log 
.const [198] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;)Z 
.const [199] = Utf8 de/audi/atip/log/LogChannel 
.const [200] = Utf8 log 
.const [201] = Utf8 (ILjava/lang/String;)Z 
.const [202] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [203] = Utf8 immediateDistanceUpdate 
.const [204] = Utf8 Z 
.const [205] = Utf8 java/lang/Object 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 java/util/ArrayList 
.const [209] = Utf8 <init> 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler$1 
.const [212] = Utf8 <init> 
.const [213] = Utf8 (Lde/audi/tghu/online/app/remotehmi/RrdCalculationHandler;Lde/audi/remotehmi/ui/mib2/grid/IGridList;Ljava/util/ArrayList;Ljava/lang/Integer;Lde/audi/remotehmi/ui/mib2/grid/GeoPosition;Ljava/lang/Integer;Ljava/lang/Integer;)V 
.const [214] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [215] = Utf8 isRrdCalculationEnabled 
.const [216] = Utf8 Z 
.const [217] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [218] = Utf8 logChannel 
.const [219] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [220] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [221] = Utf8 remoteHmiService 
.const [222] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [223] = Utf8 de/audi/remotehmi/ui/mib2/grid/IGridList 
.const [224] = Utf8 getReferencePoint 
.const [225] = Utf8 ()Lde/audi/remotehmi/ui/mib2/grid/IReferencePoint; 
.const [226] = Utf8 de/audi/remotehmi/ui/mib2/grid/IReferencePoint 
.const [227] = Utf8 getGeoLocation 
.const [228] = Utf8 ()Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [229] = Utf8 de/audi/remotehmi/ui/mib2/grid/IGridList 
.const [230] = Utf8 getIdRangeStart 
.const [231] = Utf8 ()I 
.const [232] = Utf8 de/audi/remotehmi/ui/mib2/grid/IGridList 
.const [233] = Utf8 forEachGrid 
.const [234] = Utf8 (Lde/audi/remotehmi/ui/mib2/grid/IGridAction;I)I 
.const [235] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [236] = Utf8 getIsNaviFullyOperable 
.const [237] = Utf8 ()Z 
.const [238] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [239] = Utf8 triggerRRDRequest 
.const [240] = Utf8 (Ljava/util/ArrayList;)V 
.const [241] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [242] = Utf8 triggerADRequest 
.const [243] = Utf8 (Ljava/util/ArrayList;)V 
.const [244] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [245] = Utf8 exitRRD 
.const [246] = Utf8 ()V 
.const [247] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [248] = Utf8 exitAD 
.const [249] = Utf8 ()V 
.const [250] = Utf8 de/audi/remotehmi/ui/mib2/grid/IGrid 
.const [251] = Utf8 getGeoPosition 
.const [252] = Utf8 ()Lde/audi/remotehmi/ui/mib2/grid/GeoPosition; 
.const [253] = Utf8 de/audi/atip/interapp/NaviOnlineService 
.const [254] = Utf8 swapModel 
.const [255] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;II)V 
.const [256] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [257] = Utf8 immediateDistanceUpdate 
.const [258] = Utf8 Z 
.const [259] = Utf8 de/audi/tghu/online/app/remotehmi/RrdCalculationHandler 
.const [260] = Class [259] 
.const [261] = Utf8 java/lang/Object 
.const [262] = Class [261] 
.const [263] = Utf8 immediateDistanceUpdate 
.const [264] = Utf8 Z 
.const [265] = Utf8 INCREMENT_FOR_RRD 
.const [266] = Utf8 I 
.const [267] = Utf8 remoteHmiService 
.const [268] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [269] = Utf8 logChannel 
.const [270] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [271] = Utf8 isRrdCalculationEnabled 
.const [272] = Utf8 Z 
.const [273] = Utf8 Code 
.const [274] = Utf8 <init> 
.const [275] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/online/app/remotehmi/RemoteHMIService;)V 
.const [276] = Utf8 triggerRrdCalculation 
.const [277] = Utf8 (Lde/audi/remotehmi/ui/mib2/grid/IGridList;)V 
.const [278] = Utf8 exitRrd 
.const [279] = Utf8 ()V 
.const [280] = Utf8 setRrdCalculationEnabled 
.const [281] = Utf8 (Z)V 
.const [282] = Utf8 updateGrid 
.const [283] = Utf8 (Lde/audi/remotehmi/ui/mib2/grid/IGridList;Lde/audi/remotehmi/ui/mib2/grid/IGrid;Lde/audi/remotehmi/ui/mib2/grid/IGrid;)V 
.const [284] = Utf8 isImmediateDistanceUpdate 
.const [285] = Utf8 ()Z 
.const [286] = Utf8 setImmediateDistanceUpdate 
.const [287] = Utf8 (Z)V 
.end class 
