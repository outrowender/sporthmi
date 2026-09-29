.version 50 0 
.class public super [247] 
.super [249] 
.implements [251] 
.field private static final [252] [253] 
.field private final [254] [255] 
.field private final [256] [257] 
.field private final [258] [259] 
.field private final [260] [261] 

.method public [263] : [264] 
    .attribute [262] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [51] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [52] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [53] 
L19:    aload_0 
L20:    aload_1 
L21:    invokevirtual [35] 
L24:    putfield [54] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [262] .code stack 5 locals 6 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    aload_0 
L13:    getfield [32] 
L16:    aload_0 
L17:    getfield [33] 
L20:    invokevirtual [38] 
L23:    astore_1 
L24:    new [55] 
L27:    dup 
L28:    invokespecial [48] 
L31:    astore_2 
L32:    bipush 10 
L34:    aload_1 
L35:    invokeinterface [56] 0 
L40:    invokestatic [5] 
L43:    istore_3 
L44:    iconst_0 
L45:    istore 4 
L47:    iload 4 
L49:    iload_3 
L50:    if_icmpge L139 
L53:    aload_1 
L54:    iload 4 
L56:    invokeinterface [57] 0 
L61:    astore 5 
L63:    aload 5 
L65:    ifnonnull L71 
L68:    goto L133 
L71:    aload 5 
L73:    instanceof [6] 
L76:    ifne L102 
L79:    aload_0 
L80:    getfield [36] 
L83:    ldc [2] 
L85:    ldc [7] 
L87:    aload 5 
L89:    invokespecial [49] 
L92:    invokevirtual [39] 
L95:    invokevirtual [40] 
L98:    pop 
L99:    goto L133 
L102:   aload 5 
L104:   checkcast [6] 
L107:   astore 6 
L109:   aload_2 
L110:   new [58] 
L113:   dup 
L114:   aload 6 
L116:   invokevirtual [41] 
L119:   aload 6 
L121:   invokevirtual [42] 
L124:   invokespecial [50] 
L127:   invokeinterface [59] 0 
L132:   pop 
L133:   iinc 4 1 
L136:   goto L47 
L139:   aload_2 
L140:   aload_2 
L141:   invokeinterface [60] 0 
L146:   anewarray [8] 
L149:   invokeinterface [61] 0 
L154:   checkcast [9] 
L157:   checkcast [9] 
L160:   areturn 
L161:   nop 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [262] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [2] 
L6:     ldc [10] 
L8:     aload_1 
L9:     invokevirtual [40] 
L12:    pop 
L13:    aload_0 
L14:    getfield [32] 
L17:    aload_0 
L18:    getfield [33] 
L21:    invokevirtual [38] 
L24:    astore_2 
L25:    aload_2 
L26:    ifnonnull L47 
L29:    aload_0 
L30:    getfield [36] 
L33:    ldc [11] 
L35:    ldc [12] 
L37:    aload_0 
L38:    getfield [33] 
L41:    i2l 
L42:    invokevirtual [43] 
L45:    pop 
L46:    return 
L47:    iconst_0 
L48:    istore_3 
L49:    iload_3 
L50:    aload_2 
L51:    invokeinterface [56] 0 
L56:    if_icmpge L141 
L59:    aload_2 
L60:    iload_3 
L61:    invokeinterface [57] 0 
L66:    astore 4 
L68:    aload 4 
L70:    ifnonnull L76 
L73:    goto L135 
L76:    aload 4 
L78:    instanceof [6] 
L81:    ifne L107 
L84:    aload_0 
L85:    getfield [36] 
L88:    ldc [2] 
L90:    ldc [13] 
L92:    aload 4 
L94:    invokespecial [49] 
L97:    invokevirtual [39] 
L100:   invokevirtual [40] 
L103:   pop 
L104:   goto L135 
L107:   aload 4 
L109:   checkcast [6] 
L112:   astore 5 
L114:   aload 5 
L116:   aload_1 
L117:   invokevirtual [44] 
L120:   aload 5 
L122:   aload_1 
L123:   invokevirtual [45] 
L126:   aload_2 
L127:   iload_3 
L128:   aload 5 
L130:   invokeinterface [62] 0 
L135:   iinc 3 1 
L138:   goto L49 
L141:   aload_0 
L142:   getfield [36] 
L145:   ldc [2] 
L147:   ldc [14] 
L149:   invokevirtual [37] 
L152:   pop 
L153:   return 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [262] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [2] 
L6:     ldc [15] 
L8:     invokevirtual [37] 
L11:    pop 
L12:    bipush 10 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [262] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [2] 
L6:     ldc [16] 
L8:     aload_1 
L9:     invokevirtual [40] 
L12:    pop 
L13:    aload_0 
L14:    getfield [32] 
L17:    aload_0 
L18:    getfield [33] 
L21:    invokevirtual [38] 
L24:    astore_2 
L25:    aload_2 
L26:    ifnull L127 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L112 
L37:    aload_2 
L38:    iload_3 
L39:    invokeinterface [57] 0 
L44:    astore 4 
L46:    aload 4 
L48:    instanceof [6] 
L51:    ifeq L92 
L54:    aload 4 
L56:    checkcast [6] 
L59:    astore 5 
L61:    aload_0 
L62:    getfield [36] 
L65:    aload 5 
L67:    aload_1 
L68:    iload_3 
L69:    aaload 
L70:    invokevirtual [46] 
L73:    aload_0 
L74:    getfield [34] 
L77:    invokestatic [17] 
L80:    aload_2 
L81:    iload_3 
L82:    aload 5 
L84:    invokeinterface [62] 0 
L89:    goto L106 
L92:    aload_0 
L93:    getfield [36] 
L96:    ldc [2] 
L98:    ldc [18] 
L100:   aload 4 
L102:   invokevirtual [40] 
L105:   pop 
L106:   iinc 3 1 
L109:   goto L31 
L112:   aload_0 
L113:   getfield [36] 
L116:   ldc [2] 
L118:   ldc [19] 
L120:   invokevirtual [37] 
L123:   pop 
L124:   goto L144 
L127:   aload_0 
L128:   getfield [36] 
L131:   ldc [11] 
L133:   ldc [20] 
L135:   aload_0 
L136:   getfield [33] 
L139:   i2l 
L140:   invokevirtual [43] 
L143:   pop 
L144:   return 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [262] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     ldc [2] 
L6:     ldc [21] 
L8:     invokevirtual [37] 
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
.const [3] = String [63] 
.const [4] = Class [64] 
.const [5] = Method [65] [66] 
.const [6] = Class [67] 
.const [7] = String [68] 
.const [8] = Class [69] 
.const [9] = Class [70] 
.const [10] = String [71] 
.const [11] = Int -1601830656 
.const [12] = String [72] 
.const [13] = String [73] 
.const [14] = String [74] 
.const [15] = String [75] 
.const [16] = String [76] 
.const [17] = Method [77] [78] 
.const [18] = String [79] 
.const [19] = String [80] 
.const [20] = String [81] 
.const [21] = String [82] 
.const [22] = Class [83] 
.const [23] = Class [84] 
.const [24] = Class [85] 
.const [25] = Class [86] 
.const [26] = Class [87] 
.const [27] = Class [88] 
.const [28] = Class [89] 
.const [29] = Class [90] 
.const [30] = Class [91] 
.const [31] = Class [92] 
.const [32] = Field [93] [94] 
.const [33] = Field [95] [96] 
.const [34] = Field [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Method [109] [110] 
.const [41] = Method [111] [112] 
.const [42] = Method [113] [114] 
.const [43] = Method [115] [116] 
.const [44] = Method [117] [118] 
.const [45] = Method [119] [120] 
.const [46] = Method [121] [122] 
.const [47] = Method [123] [124] 
.const [48] = Method [125] [126] 
.const [49] = Method [127] [128] 
.const [50] = Method [129] [130] 
.const [51] = Field [131] [132] 
.const [52] = Field [133] [134] 
.const [53] = Field [135] [136] 
.const [54] = Field [137] [138] 
.const [55] = Class [139] 
.const [56] = InterfaceMethod [140] [141] 
.const [57] = InterfaceMethod [142] [143] 
.const [58] = Class [144] 
.const [59] = InterfaceMethod [145] [146] 
.const [60] = InterfaceMethod [147] [148] 
.const [61] = InterfaceMethod [149] [150] 
.const [62] = InterfaceMethod [151] [152] 
.const [63] = Utf8 'PoiOnlineResultRRDListProvider#getRRDCalculationList()' 
.const [64] = Utf8 java/util/ArrayList 
.const [65] = Class [153] 
.const [66] = NameAndType [154] [155] 
.const [67] = Utf8 de/audi/app/navi/evo/poi/online/PoiOnlineListRow 
.const [68] = Utf8 'PoiOnlineResultRRDListProvider#getRRDCalculationList() Row is not null. But its not an instance of PoiOnlineListRow %1' 
.const [69] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [70] = Utf8 [Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [71] = Utf8 'PoiOnlineResultRRDListProvider#updateDirectionAndAirDistance(%1)' 
.const [72] = Utf8 'PoiOnlineResultRRDListProvider#updateDirectionAndAirDistance tiledListModel with ID = %1 is null' 
.const [73] = Utf8 'PoiOnlineResultRRDListProvider#getAllVisibleRowsFromListModel() Row is not null. But its not an instance of PoiOnlineListRow %1' 
.const [74] = Utf8 'PoiOnlineResultRRDListProvider#updateDirectionAndAirDistance: finished' 
.const [75] = Utf8 'PoiOnlineResultRRDListProvider#getRRDListCalculationLimit()' 
.const [76] = Utf8 'PoiOnlineResultRRDListProvider#updateRRDDistances(%1)' 
.const [77] = Class [156] 
.const [78] = NameAndType [157] [158] 
.const [79] = Utf8 'PoiOnlineResultRRDListProvider#updateRRDDistances() Row is null or its not an instance of PoiOnlineListRow %1' 
.const [80] = Utf8 'PoiOnlineResultRRDListProvider#updateRRDDistances - finished' 
.const [81] = Utf8 'PoiOnlineResultRRDListProvider#updateRRDDistances tiledListModel with ID = %1 is null' 
.const [82] = Utf8 'PoiOnlineResultRRDListProvider#unitsChanged()' 
.const [83] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [84] = Utf8 java/lang/Object 
.const [85] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [88] = Utf8 java/lang/Math 
.const [89] = Utf8 java/lang/Class 
.const [90] = Utf8 java/util/List 
.const [91] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [92] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceUtil 
.const [93] = Class [159] 
.const [94] = NameAndType [160] [161] 
.const [95] = Class [162] 
.const [96] = NameAndType [163] [164] 
.const [97] = Class [165] 
.const [98] = NameAndType [166] [167] 
.const [99] = Class [168] 
.const [100] = NameAndType [169] [170] 
.const [101] = Class [171] 
.const [102] = NameAndType [172] [173] 
.const [103] = Class [174] 
.const [104] = NameAndType [175] [176] 
.const [105] = Class [177] 
.const [106] = NameAndType [178] [179] 
.const [107] = Class [180] 
.const [108] = NameAndType [181] [182] 
.const [109] = Class [183] 
.const [110] = NameAndType [184] [185] 
.const [111] = Class [186] 
.const [112] = NameAndType [187] [188] 
.const [113] = Class [189] 
.const [114] = NameAndType [190] [191] 
.const [115] = Class [192] 
.const [116] = NameAndType [193] [194] 
.const [117] = Class [195] 
.const [118] = NameAndType [196] [197] 
.const [119] = Class [198] 
.const [120] = NameAndType [199] [200] 
.const [121] = Class [201] 
.const [122] = NameAndType [202] [203] 
.const [123] = Class [204] 
.const [124] = NameAndType [205] [206] 
.const [125] = Class [207] 
.const [126] = NameAndType [208] [209] 
.const [127] = Class [210] 
.const [128] = NameAndType [211] [212] 
.const [129] = Class [213] 
.const [130] = NameAndType [214] [215] 
.const [131] = Class [216] 
.const [132] = NameAndType [217] [218] 
.const [133] = Class [219] 
.const [134] = NameAndType [220] [221] 
.const [135] = Class [222] 
.const [136] = NameAndType [223] [224] 
.const [137] = Class [225] 
.const [138] = NameAndType [226] [227] 
.const [139] = Utf8 java/util/ArrayList 
.const [140] = Class [228] 
.const [141] = NameAndType [229] [230] 
.const [142] = Class [231] 
.const [143] = NameAndType [232] [233] 
.const [144] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [145] = Class [234] 
.const [146] = NameAndType [235] [236] 
.const [147] = Class [237] 
.const [148] = NameAndType [238] [239] 
.const [149] = Class [240] 
.const [150] = NameAndType [241] [242] 
.const [151] = Class [243] 
.const [152] = NameAndType [244] [245] 
.const [153] = Utf8 java/lang/Math 
.const [154] = Utf8 min 
.const [155] = Utf8 (II)I 
.const [156] = Utf8 de/audi/tghu/navi/app/slidinglist/poi/DistanceUtil 
.const [157] = Utf8 updateRRDfor 
.const [158] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/slidinglist/poi/DistanceDifferentiationRow;ILde/audi/tghu/navi/app/guidance/IVehicle;)V 
.const [159] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [160] = Utf8 env 
.const [161] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [162] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [163] = Utf8 modelID 
.const [164] = Utf8 I 
.const [165] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [166] = Utf8 vehicle 
.const [167] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [168] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [169] = Utf8 getPOILogChannel 
.const [170] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [171] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [172] = Utf8 poiLogChannel 
.const [173] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;)Z 
.const [177] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [178] = Utf8 getListModel 
.const [179] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ListModelApp; 
.const [180] = Utf8 java/lang/Class 
.const [181] = Utf8 getName 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 de/audi/atip/log/LogChannel 
.const [184] = Utf8 log 
.const [185] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [186] = Utf8 de/audi/app/navi/evo/poi/online/PoiOnlineListRow 
.const [187] = Utf8 getLongitude 
.const [188] = Utf8 ()I 
.const [189] = Utf8 de/audi/app/navi/evo/poi/online/PoiOnlineListRow 
.const [190] = Utf8 getLatitude 
.const [191] = Utf8 ()I 
.const [192] = Utf8 de/audi/atip/log/LogChannel 
.const [193] = Utf8 log 
.const [194] = Utf8 (ILjava/lang/String;J)Z 
.const [195] = Utf8 de/audi/app/navi/evo/poi/online/PoiOnlineListRow 
.const [196] = Utf8 updateDirection 
.const [197] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [198] = Utf8 de/audi/app/navi/evo/poi/online/PoiOnlineListRow 
.const [199] = Utf8 updateAirDistance 
.const [200] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [201] = Utf8 org/dsi/ifc/navigation/RrdCalculationInfo 
.const [202] = Utf8 getRrdInfo 
.const [203] = Utf8 ()I 
.const [204] = Utf8 java/lang/Object 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 java/util/ArrayList 
.const [208] = Utf8 <init> 
.const [209] = Utf8 ()V 
.const [210] = Utf8 java/lang/Object 
.const [211] = Utf8 getClass 
.const [212] = Utf8 ()Ljava/lang/Class; 
.const [213] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (II)V 
.const [216] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [217] = Utf8 env 
.const [218] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [219] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [220] = Utf8 modelID 
.const [221] = Utf8 I 
.const [222] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [223] = Utf8 vehicle 
.const [224] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [225] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [226] = Utf8 poiLogChannel 
.const [227] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [228] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [229] = Utf8 getLength 
.const [230] = Utf8 ()I 
.const [231] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [232] = Utf8 getRow 
.const [233] = Utf8 (I)Lde/audi/atip/hmi/model/BaseListRow; 
.const [234] = Utf8 java/util/List 
.const [235] = Utf8 add 
.const [236] = Utf8 (Ljava/lang/Object;)Z 
.const [237] = Utf8 java/util/List 
.const [238] = Utf8 size 
.const [239] = Utf8 ()I 
.const [240] = Utf8 java/util/List 
.const [241] = Utf8 toArray 
.const [242] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [243] = Utf8 de/audi/atip/hmi/modelaccess/ListModelApp 
.const [244] = Utf8 setRow 
.const [245] = Utf8 (ILde/audi/atip/hmi/model/BaseListRow;)V 
.const [246] = Utf8 de/audi/app/navi/evo/addressinput/poi/rrd/PoiOnlineResultRRDListProvider 
.const [247] = Class [246] 
.const [248] = Utf8 java/lang/Object 
.const [249] = Class [248] 
.const [250] = Utf8 de/audi/tghu/navi/app/addressinput/poi/rrd/IRRDListProvider 
.const [251] = Class [250] 
.const [252] = Utf8 CALCULATION_LIMIT_POI_RESULT 
.const [253] = Utf8 I 
.const [254] = Utf8 poiLogChannel 
.const [255] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [256] = Utf8 env 
.const [257] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [258] = Utf8 modelID 
.const [259] = Utf8 I 
.const [260] = Utf8 vehicle 
.const [261] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [262] = Utf8 Code 
.const [263] = Utf8 <init> 
.const [264] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;ILde/audi/tghu/navi/app/guidance/IVehicle;)V 
.const [265] = Utf8 getRRDCalculationList 
.const [266] = Utf8 ()[Lorg/dsi/ifc/global/NavLocationWgs84; 
.const [267] = Utf8 updateDirectionAndAirDistance 
.const [268] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [269] = Utf8 getRRDListCalculationLimit 
.const [270] = Utf8 ()I 
.const [271] = Utf8 updateRRDDistances 
.const [272] = Utf8 ([Lorg/dsi/ifc/navigation/RrdCalculationInfo;)V 
.const [273] = Utf8 unitsChanged 
.const [274] = Utf8 ()V 
.end class 
