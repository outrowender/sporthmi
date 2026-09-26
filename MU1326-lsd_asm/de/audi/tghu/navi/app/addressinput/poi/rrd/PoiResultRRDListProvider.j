.version 50 0 
.class public super [281] 
.super [283] 
.implements [285] 
.field public static final [286] [287] 
.field private final [288] [289] 
.field private final [290] [291] 
.field private final [292] [293] 
.field private final [294] [295] 

.method public [297] : [298] 
    .attribute [296] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     iload_2 
L7:     invokevirtual [28] 
L10:    putfield [48] 
L13:    aload_0 
L14:    iload_2 
L15:    putfield [49] 
L18:    aload_0 
L19:    aload_3 
L20:    putfield [50] 
L23:    aload_0 
L24:    aload_1 
L25:    invokevirtual [32] 
L28:    putfield [51] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [296] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    new [52] 
L15:    dup 
L16:    invokespecial [44] 
L19:    astore_1 
L20:    iconst_0 
L21:    istore_2 
L22:    iload_2 
L23:    bipush 10 
L25:    if_icmpge L108 
L28:    aload_0 
L29:    getfield [29] 
L32:    iload_2 
L33:    invokeinterface [53] 0 
L38:    astore_3 
L39:    aload_3 
L40:    ifnonnull L46 
L43:    goto L102 
L46:    aload_3 
L47:    instanceof [5] 
L50:    ifne L68 
L53:    aload_0 
L54:    getfield [33] 
L57:    ldc [2] 
L59:    ldc [6] 
L61:    invokevirtual [34] 
L64:    pop 
L65:    goto L102 
L68:    aload_3 
L69:    checkcast [5] 
L72:    astore 4 
L74:    aload_1 
L75:    new [54] 
L78:    dup 
L79:    aload 4 
L81:    invokeinterface [55] 0 
L86:    aload 4 
L88:    invokeinterface [56] 0 
L93:    invokespecial [45] 
L96:    invokeinterface [57] 0 
L101:   pop 
L102:   iinc 2 1 
L105:   goto L22 
L108:   aload_1 
L109:   aload_1 
L110:   invokeinterface [58] 0 
L115:   anewarray [7] 
L118:   invokeinterface [59] 0 
L123:   checkcast [8] 
L126:   checkcast [8] 
L129:   areturn 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [301] : [302] 
    .attribute [296] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [29] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [29] 
L11:    invokeinterface [60] 0 
L16:    ifne L59 
L19:    aload_0 
L20:    getfield [29] 
L23:    ifnonnull L46 
L26:    aload_0 
L27:    getfield [33] 
L30:    ldc [9] 
L32:    ldc [10] 
L34:    aload_0 
L35:    getfield [30] 
L38:    i2l 
L39:    invokevirtual [35] 
L42:    pop 
L43:    goto L58 
L46:    aload_0 
L47:    getfield [33] 
L50:    ldc [9] 
L52:    ldc [11] 
L54:    invokevirtual [34] 
L57:    pop 
L58:    return 
L59:    aload_0 
L60:    getfield [29] 
L63:    invokeinterface [61] 0 
L68:    astore_2 
L69:    iconst_0 
L70:    istore_3 
L71:    iload_3 
L72:    aload_2 
L73:    invokeinterface [60] 0 
L78:    if_icmpge L132 
L81:    aload_2 
L82:    iload_3 
L83:    invokeinterface [53] 0 
L88:    ifnonnull L94 
L91:    goto L126 
L94:    aload_2 
L95:    iload_3 
L96:    invokeinterface [53] 0 
L101:   checkcast [5] 
L104:   aload_1 
L105:   invokeinterface [62] 0 
L110:   aload_2 
L111:   iload_3 
L112:   invokeinterface [53] 0 
L117:   checkcast [5] 
L120:   aload_1 
L121:   invokeinterface [63] 0 
L126:   iinc 3 1 
L129:   goto L71 
L132:   aload_0 
L133:   getfield [29] 
L136:   aload_2 
L137:   invokeinterface [64] 0 
L142:   return 
L143:   nop 
L144:   
    .end code 
.end method 

.method public [303] : [304] 
    .attribute [296] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [2] 
L6:     ldc [12] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    bipush 10 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [305] : [306] 
    .attribute [296] .code stack 4 locals 4 
L0:     new [65] 
L3:     dup 
L4:     invokespecial [46] 
L7:     astore_2 
L8:     iconst_0 
L9:     istore_3 
L10:    iload_3 
L11:    aload_1 
L12:    arraylength 
L13:    if_icmpge L67 
L16:    aload_1 
L17:    iload_3 
L18:    aaload 
L19:    ifnonnull L32 
L22:    aload_2 
L23:    ldc [14] 
L25:    invokevirtual [36] 
L28:    pop 
L29:    goto L61 
L32:    aload_2 
L33:    new [66] 
L36:    dup 
L37:    invokespecial [47] 
L40:    aload_1 
L41:    iload_3 
L42:    aaload 
L43:    invokevirtual [37] 
L46:    invokevirtual [38] 
L49:    ldc [16] 
L51:    invokevirtual [38] 
L54:    invokevirtual [39] 
L57:    invokevirtual [36] 
L60:    pop 
L61:    iinc 3 1 
L64:    goto L10 
L67:    aload_0 
L68:    getfield [33] 
L71:    ldc [2] 
L73:    ldc [17] 
L75:    aload_2 
L76:    invokevirtual [40] 
L79:    invokevirtual [41] 
L82:    pop 
L83:    iconst_0 
L84:    istore_3 
L85:    iload_3 
L86:    aload_1 
L87:    arraylength 
L88:    if_icmpge L161 
L91:    aload_1 
L92:    iload_3 
L93:    aaload 
L94:    astore 4 
L96:    aload 4 
L98:    ifnull L155 
L101:   aload_0 
L102:   getfield [29] 
L105:   iload_3 
L106:   invokeinterface [53] 0 
L111:   astore 5 
L113:   aload 5 
L115:   instanceof [5] 
L118:   ifeq L155 
L121:   aload_0 
L122:   getfield [33] 
L125:   aload 5 
L127:   checkcast [5] 
L130:   aload_1 
L131:   iload_3 
L132:   aaload 
L133:   invokevirtual [42] 
L136:   aload_0 
L137:   getfield [31] 
L140:   invokestatic [18] 
L143:   aload_0 
L144:   getfield [29] 
L147:   iload_3 
L148:   aload 5 
L150:   invokeinterface [67] 0 
L155:   iinc 3 1 
L158:   goto L85 
L161:   return 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 

.method public [307] : [308] 
    .attribute [296] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [2] 
L6:     ldc [19] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [68] 
.const [4] = Class [69] 
.const [5] = Class [70] 
.const [6] = String [71] 
.const [7] = Class [72] 
.const [8] = Class [73] 
.const [9] = Int -1601830656 
.const [10] = String [74] 
.const [11] = String [75] 
.const [12] = String [76] 
.const [13] = Class [77] 
.const [14] = String [78] 
.const [15] = Class [79] 
.const [16] = String [80] 
.const [17] = String [81] 
.const [18] = Method [82] [83] 
.const [19] = String [84] 
.const [20] = Class [85] 
.const [21] = Class [86] 
.const [22] = Class [87] 
.const [23] = Class [88] 
.const [24] = Class [89] 
.const [25] = Class [90] 
.const [26] = Class [91] 
.const [27] = Class [92] 
.const [28] = Method [93] [94] 
.const [29] = Field [95] [96] 
.const [30] = Field [97] [98] 
.const [31] = Field [99] [100] 
.const [32] = Method [101] [102] 
.const [33] = Field [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Method [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Method [125] [126] 
.const [45] = Method [127] [128] 
.const [46] = Method [129] [130] 
.const [47] = Method [131] [132] 
.const [48] = Field [133] [134] 
.const [49] = Field [135] [136] 
.const [50] = Field [137] [138] 
.const [51] = Field [139] [140] 
.const [52] = Class [141] 
.const [53] = InterfaceMethod [142] [143] 
.const [54] = Class [144] 
.const [55] = InterfaceMethod [145] [146] 
.const [56] = InterfaceMethod [147] [148] 
.const [57] = InterfaceMethod [149] [150] 
.const [58] = InterfaceMethod [151] [152] 
.const [59] = InterfaceMethod [153] [154] 
.const [60] = InterfaceMethod [155] [156] 
.const [61] = InterfaceMethod [157] [158] 
.const [62] = InterfaceMethod [159] [160] 
.const [63] = InterfaceMethod [161] [162] 
.const [64] = InterfaceMethod [163] [164] 
.const [65] = Class [165] 
.const [66] = Class [166] 
.const [67] = InterfaceMethod [167] [168] 
.const [68] = Utf8 'PoiResultRRDListProvider#getRRDCalculationList()' 
.const [69] = Utf8 java/util/ArrayList 
.const [70] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [71] = Utf8 'PoiResultRRDListProvider#getAllVisibleRowsFromListModel() Row is not null. But its not an instance of DistanceDifferentiationRow' 
.const [72] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [73] = Utf8 [Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [74] = Utf8 'PoiResultRRDListProvider#updateDirectionAndAirDistance listModel with ID = %1 is null' 
.const [75] = Utf8 'PoiResultRRDListProvider#updateDirectionAndAirDistance List is empty' 
.const [76] = Utf8 'PoiResultRRDListProvider#getRRDListCalculationLimit()' 
.const [77] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [78] = Utf8 '[null]; ' 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Utf8 '; ' 
.const [81] = Utf8 'PoiResultRRDListProvider#updateRRDDistances(%1)' 
.const [82] = Class [169] 
.const [83] = NameAndType [170] [171] 
.const [84] = Utf8 'PoiResultRRDListProvider#unitsChanged()' 
.const [85] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [90] = Utf8 java/util/List 
.const [91] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [92] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceUtil 
.const [93] = Class [172] 
.const [94] = NameAndType [173] [174] 
.const [95] = Class [175] 
.const [96] = NameAndType [176] [177] 
.const [97] = Class [178] 
.const [98] = NameAndType [179] [180] 
.const [99] = Class [181] 
.const [100] = NameAndType [182] [183] 
.const [101] = Class [184] 
.const [102] = NameAndType [185] [186] 
.const [103] = Class [187] 
.const [104] = NameAndType [188] [189] 
.const [105] = Class [190] 
.const [106] = NameAndType [191] [192] 
.const [107] = Class [193] 
.const [108] = NameAndType [194] [195] 
.const [109] = Class [196] 
.const [110] = NameAndType [197] [198] 
.const [111] = Class [199] 
.const [112] = NameAndType [200] [201] 
.const [113] = Class [202] 
.const [114] = NameAndType [203] [204] 
.const [115] = Class [205] 
.const [116] = NameAndType [206] [207] 
.const [117] = Class [208] 
.const [118] = NameAndType [209] [210] 
.const [119] = Class [211] 
.const [120] = NameAndType [212] [213] 
.const [121] = Class [214] 
.const [122] = NameAndType [215] [216] 
.const [123] = Class [217] 
.const [124] = NameAndType [218] [219] 
.const [125] = Class [220] 
.const [126] = NameAndType [221] [222] 
.const [127] = Class [223] 
.const [128] = NameAndType [224] [225] 
.const [129] = Class [226] 
.const [130] = NameAndType [227] [228] 
.const [131] = Class [229] 
.const [132] = NameAndType [230] [231] 
.const [133] = Class [232] 
.const [134] = NameAndType [233] [234] 
.const [135] = Class [235] 
.const [136] = NameAndType [236] [237] 
.const [137] = Class [238] 
.const [138] = NameAndType [239] [240] 
.const [139] = Class [241] 
.const [140] = NameAndType [242] [243] 
.const [141] = Utf8 java/util/ArrayList 
.const [142] = Class [244] 
.const [143] = NameAndType [245] [246] 
.const [144] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [145] = Class [247] 
.const [146] = NameAndType [248] [249] 
.const [147] = Class [250] 
.const [148] = NameAndType [251] [252] 
.const [149] = Class [253] 
.const [150] = NameAndType [254] [255] 
.const [151] = Class [256] 
.const [152] = NameAndType [257] [258] 
.const [153] = Class [259] 
.const [154] = NameAndType [260] [261] 
.const [155] = Class [262] 
.const [156] = NameAndType [263] [264] 
.const [157] = Class [265] 
.const [158] = NameAndType [266] [267] 
.const [159] = Class [268] 
.const [160] = NameAndType [269] [270] 
.const [161] = Class [271] 
.const [162] = NameAndType [272] [273] 
.const [163] = Class [274] 
.const [164] = NameAndType [275] [276] 
.const [165] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Class [277] 
.const [168] = NameAndType [278] [279] 
.const [169] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceUtil 
.const [170] = Utf8 updateRRDfor 
.const [171] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow;ILde/audi/tghu/navi/app/guidance/IVehicle;)V 
.const [172] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [173] = Utf8 getBaseListModel 
.const [174] = Utf8 (I)Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [175] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [176] = Utf8 listModel 
.const [177] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [178] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [179] = Utf8 modelId 
.const [180] = Utf8 I 
.const [181] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [182] = Utf8 vehicle 
.const [183] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [184] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [185] = Utf8 getPOILogChannel 
.const [186] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [187] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [188] = Utf8 poiLogChannel 
.const [189] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [190] = Utf8 de/audi/atip/log/LogChannel 
.const [191] = Utf8 log 
.const [192] = Utf8 (ILjava/lang/String;)Z 
.const [193] = Utf8 de/audi/atip/log/LogChannel 
.const [194] = Utf8 log 
.const [195] = Utf8 (ILjava/lang/String;J)Z 
.const [196] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [197] = Utf8 append 
.const [198] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [199] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [200] = Utf8 toString 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 java/lang/StringBuffer 
.const [203] = Utf8 append 
.const [204] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [205] = Utf8 java/lang/StringBuffer 
.const [206] = Utf8 toString 
.const [207] = Utf8 ()Ljava/lang/String; 
.const [208] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [209] = Utf8 toString 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 de/audi/atip/log/LogChannel 
.const [212] = Utf8 log 
.const [213] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [214] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [215] = Utf8 getRrdInfo 
.const [216] = Utf8 ()I 
.const [217] = Utf8 java/lang/Object 
.const [218] = Utf8 <init> 
.const [219] = Utf8 ()V 
.const [220] = Utf8 java/util/ArrayList 
.const [221] = Utf8 <init> 
.const [222] = Utf8 ()V 
.const [223] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (II)V 
.const [226] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ()V 
.const [229] = Utf8 java/lang/StringBuffer 
.const [230] = Utf8 <init> 
.const [231] = Utf8 ()V 
.const [232] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [233] = Utf8 listModel 
.const [234] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [235] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [236] = Utf8 modelId 
.const [237] = Utf8 I 
.const [238] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [239] = Utf8 vehicle 
.const [240] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [241] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [242] = Utf8 poiLogChannel 
.const [243] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [244] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [245] = Utf8 getRow 
.const [246] = Utf8 (I)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [247] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [248] = Utf8 getLongitude 
.const [249] = Utf8 ()I 
.const [250] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [251] = Utf8 getLatitude 
.const [252] = Utf8 ()I 
.const [253] = Utf8 java/util/List 
.const [254] = Utf8 add 
.const [255] = Utf8 (Ljava/lang/Object;)Z 
.const [256] = Utf8 java/util/List 
.const [257] = Utf8 size 
.const [258] = Utf8 ()I 
.const [259] = Utf8 java/util/List 
.const [260] = Utf8 toArray 
.const [261] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [262] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [263] = Utf8 getLength 
.const [264] = Utf8 ()I 
.const [265] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [266] = Utf8 getCopy 
.const [267] = Utf8 ()Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [268] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [269] = Utf8 updateDirection 
.const [270] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [271] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow 
.const [272] = Utf8 updateAirDistance 
.const [273] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [274] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [275] = Utf8 update 
.const [276] = Utf8 (Lde/audi/atip/hmi/model/list/BaseListModelApp;)V 
.const [277] = Utf8 de/audi/atip/hmi/model/list/BaseListModelApp 
.const [278] = Utf8 setRow 
.const [279] = Utf8 (ILde/audi/atip/hmi/model/list/EvoListRow;)V 
.const [280] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/PoiResultRRDListProvider 
.const [281] = Class [280] 
.const [282] = Utf8 java/lang/Object 
.const [283] = Class [282] 
.const [284] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider 
.const [285] = Class [284] 
.const [286] = Utf8 CALCULATION_LIMIT_POI_RESULT 
.const [287] = Utf8 I 
.const [288] = Utf8 poiLogChannel 
.const [289] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [290] = Utf8 listModel 
.const [291] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [292] = Utf8 modelId 
.const [293] = Utf8 I 
.const [294] = Utf8 vehicle 
.const [295] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [296] = Utf8 Code 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;ILde/audi/tghu/navi/app/guidance/IVehicle;)V 
.const [299] = Utf8 getRRDCalculationList 
.const [300] = Utf8 ()[Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [301] = Utf8 updateDirectionAndAirDistance 
.const [302] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [303] = Utf8 getRRDListCalculationLimit 
.const [304] = Utf8 ()I 
.const [305] = Utf8 updateRRDDistances 
.const [306] = Utf8 ([Lorg/dsi/ifc/navigation/RrdCalculationInfo;)V 
.const [307] = Utf8 unitsChanged 
.const [308] = Utf8 ()V 
.end class 
