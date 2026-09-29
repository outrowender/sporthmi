.version 50 0 
.class super [335] 
.super [337] 
.implements [339] 
.field private final synthetic [340] [341] 

.method private [343] : [344] 
    .attribute [342] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [54] 
L5:     aload_0 
L6:     invokespecial [49] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [345] : [346] 
    .attribute [342] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokestatic [2] 
L7:     invokevirtual [29] 
L10:    ifeq L29 
L13:    aload_0 
L14:    getfield [28] 
L17:    invokestatic [2] 
L20:    ldc [3] 
L22:    ldc [4] 
L24:    aload_1 
L25:    invokevirtual [30] 
L28:    pop 
L29:    new [55] 
L32:    dup 
L33:    invokespecial [50] 
L36:    astore_2 
L37:    aload_2 
L38:    aload_1 
L39:    getfield [31] 
L42:    putfield [56] 
L45:    aload_2 
L46:    aload_1 
L47:    getfield [32] 
L50:    putfield [57] 
L53:    aload_2 
L54:    aload_1 
L55:    getfield [33] 
L58:    invokestatic [6] 
L61:    putfield [58] 
L64:    aload_2 
L65:    aload_1 
L66:    getfield [34] 
L69:    invokestatic [6] 
L72:    putfield [59] 
L75:    aload_2 
L76:    aload_0 
L77:    aload_1 
L78:    getfield [35] 
L81:    invokespecial [51] 
L84:    putfield [60] 
        .catch [7] from L87 to L95 using L98 
L87:    aload_0 
L88:    getfield [28] 
L91:    aload_2 
L92:    invokevirtual [36] 
L95:    goto L116 
L98:    astore_3 
L99:    aload_0 
L100:   getfield [28] 
L103:   invokestatic [2] 
L106:   sipush 10000 
L109:   ldc [8] 
L111:   aload_3 
L112:   invokevirtual [37] 
L115:   pop 
L116:   return 
L117:   nop 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method private [347] : [348] 
    .attribute [342] .code stack 2 locals 0 
L0:     iload_1 
L1:     bipush 100 
L3:     idiv 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [349] : [350] 
    .attribute [342] .code stack 4 locals 1 
        .catch [7] from L0 to L8 using L11 
L0:     aload_0 
L1:     getfield [28] 
L4:     iload_1 
L5:     invokevirtual [38] 
L8:     goto L29 
L11:    astore_2 
L12:    aload_0 
L13:    getfield [28] 
L16:    invokestatic [2] 
L19:    sipush 10000 
L22:    ldc [9] 
L24:    aload_2 
L25:    invokevirtual [37] 
L28:    pop 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [351] : [352] 
    .attribute [342] .code stack 17 locals 7 
L0:     aload_2 
L1:     arraylength 
L2:     anewarray [10] 
L5:     astore 4 
L7:     iconst_0 
L8:     istore 5 
L10:    iload 5 
L12:    aload_2 
L13:    arraylength 
L14:    if_icmpge L156 
L17:    aload_2 
L18:    iload 5 
L20:    aaload 
L21:    astore 6 
L23:    aload_1 
L24:    iload 5 
L26:    aaload 
L27:    astore 7 
L29:    aload 6 
L31:    invokestatic [11] 
L34:    astore 8 
L36:    iconst_1 
L37:    anewarray [12] 
L40:    dup 
L41:    iconst_0 
L42:    aload 6 
L44:    aload_3 
L45:    invokestatic [13] 
L48:    invokevirtual [39] 
L51:    aastore 
L52:    astore 9 
L54:    new [61] 
L57:    dup 
L58:    aload 8 
L60:    invokeinterface [62] 0 
L65:    invokestatic [6] 
L68:    aload 8 
L70:    invokeinterface [63] 0 
L75:    invokestatic [6] 
L78:    aload 8 
L80:    invokeinterface [64] 0 
L85:    aload 8 
L87:    invokeinterface [65] 0 
L92:    aload 8 
L94:    invokeinterface [66] 0 
L99:    aload 8 
L101:   invokeinterface [67] 0 
L106:   aload 8 
L108:   invokeinterface [68] 0 
L113:   aload 8 
L115:   invokeinterface [69] 0 
L120:   aload 9 
L122:   aload 7 
L124:   invokevirtual [40] 
L127:   aload 7 
L129:   invokevirtual [41] 
L132:   aload 7 
L134:   invokevirtual [42] 
L137:   i2d 
L138:   invokespecial [52] 
L141:   astore 10 
L143:   aload 4 
L145:   iload 5 
L147:   aload 10 
L149:   aastore 
L150:   iinc 5 1 
L153:   goto L10 
        .catch [7] from L156 to L165 using L168 
L156:   aload_0 
L157:   getfield [28] 
L160:   aload 4 
L162:   invokevirtual [43] 
L165:   goto L188 
L168:   astore 5 
L170:   aload_0 
L171:   getfield [28] 
L174:   invokestatic [2] 
L177:   sipush 10000 
L180:   ldc [9] 
L182:   aload 5 
L184:   invokevirtual [37] 
L187:   pop 
L188:   return 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method public [353] : [354] 
    .attribute [342] .code stack 5 locals 2 
L0:     new [70] 
L3:     dup 
L4:     invokespecial [53] 
L7:     astore_2 
L8:     aload_2 
L9:     aload_1 
L10:    getfield [44] 
L13:    putfield [71] 
L16:    aload_2 
L17:    aload_1 
L18:    getfield [45] 
L21:    l2d 
L22:    putfield [72] 
L25:    aload_2 
L26:    aload_1 
L27:    getfield [46] 
L30:    ldc_w [1] 
L33:    lmul 
L34:    l2d 
L35:    putfield [73] 
        .catch [7] from L38 to L46 using L49 
L38:    aload_0 
L39:    getfield [28] 
L42:    aload_2 
L43:    invokevirtual [47] 
L46:    goto L67 
L49:    astore_3 
L50:    aload_0 
L51:    getfield [28] 
L54:    invokestatic [2] 
L57:    sipush 10000 
L60:    ldc [15] 
L62:    aload_3 
L63:    invokevirtual [37] 
L66:    pop 
L67:    return 
L68:    
    .end code 
.end method 

.method synthetic [355] : [356] 
    .attribute [342] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [48] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [75] [76] 
.const [3] = Int 14808325 
.const [4] = String [77] 
.const [5] = Class [78] 
.const [6] = Method [79] [80] 
.const [7] = Class [81] 
.const [8] = String [82] 
.const [9] = String [83] 
.const [10] = Class [84] 
.const [11] = Method [85] [86] 
.const [12] = Class [87] 
.const [13] = Method [88] [89] 
.const [14] = Class [90] 
.const [15] = String [91] 
.const [16] = Class [92] 
.const [17] = Class [93] 
.const [18] = Class [94] 
.const [19] = Class [95] 
.const [20] = Class [96] 
.const [21] = Class [97] 
.const [22] = Class [98] 
.const [23] = Class [99] 
.const [24] = Class [100] 
.const [25] = Class [101] 
.const [26] = Class [102] 
.const [27] = Class [103] 
.const [28] = Field [104] [105] 
.const [29] = Method [106] [107] 
.const [30] = Method [108] [109] 
.const [31] = Field [110] [111] 
.const [32] = Field [112] [113] 
.const [33] = Field [114] [115] 
.const [34] = Field [116] [117] 
.const [35] = Field [118] [119] 
.const [36] = Method [120] [121] 
.const [37] = Method [122] [123] 
.const [38] = Method [124] [125] 
.const [39] = Method [126] [127] 
.const [40] = Method [128] [129] 
.const [41] = Method [130] [131] 
.const [42] = Method [132] [133] 
.const [43] = Method [134] [135] 
.const [44] = Field [136] [137] 
.const [45] = Field [138] [139] 
.const [46] = Field [140] [141] 
.const [47] = Method [142] [143] 
.const [48] = Method [144] [145] 
.const [49] = Method [146] [147] 
.const [50] = Method [148] [149] 
.const [51] = Method [150] [151] 
.const [52] = Method [152] [153] 
.const [53] = Method [154] [155] 
.const [54] = Field [156] [157] 
.const [55] = Class [158] 
.const [56] = Field [159] [160] 
.const [57] = Field [161] [162] 
.const [58] = Field [163] [164] 
.const [59] = Field [165] [166] 
.const [60] = Field [167] [168] 
.const [61] = Class [169] 
.const [62] = InterfaceMethod [170] [171] 
.const [63] = InterfaceMethod [172] [173] 
.const [64] = InterfaceMethod [174] [175] 
.const [65] = InterfaceMethod [176] [177] 
.const [66] = InterfaceMethod [178] [179] 
.const [67] = InterfaceMethod [180] [181] 
.const [68] = InterfaceMethod [182] [183] 
.const [69] = InterfaceMethod [184] [185] 
.const [70] = Class [186] 
.const [71] = Field [187] [188] 
.const [72] = Field [189] [190] 
.const [73] = Field [191] [192] 
.const [74] = Int -402456576 
.const [75] = Class [193] 
.const [76] = NameAndType [194] [195] 
.const [77] = Utf8 'NaviTabletServiceListener#updateCarPosition %1' 
.const [78] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [79] = Class [196] 
.const [80] = NameAndType [197] [198] 
.const [81] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [82] = Utf8 'NaviTabletServiceListener#updateCarPosition ' 
.const [83] = Utf8 'NaviTabletServiceListener#updateRouteGuidanceActive ' 
.const [84] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo 
.const [85] = Class [199] 
.const [86] = NameAndType [200] [201] 
.const [87] = Utf8 java/lang/String 
.const [88] = Class [202] 
.const [89] = NameAndType [203] [204] 
.const [90] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo 
.const [91] = Utf8 'NaviTabletServiceListener#updateNextDestinationInfo ' 
.const [92] = Utf8 de/audi/app/navi/sdis/NaviASIProvider$NaviTabletServiceListener 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [97] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [98] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [99] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AddressFormatter 
.const [100] = Utf8 de/audi/tghu/navi/app/util/addressformatting/LocationFormattingResponse 
.const [101] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [102] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [103] = Utf8 org/dsi/ifc/navigation/RgInfoForNextDestination 
.const [104] = Class [205] 
.const [105] = NameAndType [206] [207] 
.const [106] = Class [208] 
.const [107] = NameAndType [209] [210] 
.const [108] = Class [211] 
.const [109] = NameAndType [212] [213] 
.const [110] = Class [214] 
.const [111] = NameAndType [215] [216] 
.const [112] = Class [217] 
.const [113] = NameAndType [218] [219] 
.const [114] = Class [220] 
.const [115] = NameAndType [221] [222] 
.const [116] = Class [223] 
.const [117] = NameAndType [224] [225] 
.const [118] = Class [226] 
.const [119] = NameAndType [227] [228] 
.const [120] = Class [229] 
.const [121] = NameAndType [230] [231] 
.const [122] = Class [232] 
.const [123] = NameAndType [233] [234] 
.const [124] = Class [235] 
.const [125] = NameAndType [236] [237] 
.const [126] = Class [238] 
.const [127] = NameAndType [239] [240] 
.const [128] = Class [241] 
.const [129] = NameAndType [242] [243] 
.const [130] = Class [244] 
.const [131] = NameAndType [245] [246] 
.const [132] = Class [247] 
.const [133] = NameAndType [248] [249] 
.const [134] = Class [250] 
.const [135] = NameAndType [251] [252] 
.const [136] = Class [253] 
.const [137] = NameAndType [254] [255] 
.const [138] = Class [256] 
.const [139] = NameAndType [257] [258] 
.const [140] = Class [259] 
.const [141] = NameAndType [260] [261] 
.const [142] = Class [262] 
.const [143] = NameAndType [263] [264] 
.const [144] = Class [265] 
.const [145] = NameAndType [266] [267] 
.const [146] = Class [268] 
.const [147] = NameAndType [269] [270] 
.const [148] = Class [271] 
.const [149] = NameAndType [272] [273] 
.const [150] = Class [274] 
.const [151] = NameAndType [275] [276] 
.const [152] = Class [277] 
.const [153] = NameAndType [278] [279] 
.const [154] = Class [280] 
.const [155] = NameAndType [281] [282] 
.const [156] = Class [283] 
.const [157] = NameAndType [284] [285] 
.const [158] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [159] = Class [286] 
.const [160] = NameAndType [287] [288] 
.const [161] = Class [289] 
.const [162] = NameAndType [290] [291] 
.const [163] = Class [292] 
.const [164] = NameAndType [293] [294] 
.const [165] = Class [295] 
.const [166] = NameAndType [296] [297] 
.const [167] = Class [298] 
.const [168] = NameAndType [299] [300] 
.const [169] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo 
.const [170] = Class [301] 
.const [171] = NameAndType [302] [303] 
.const [172] = Class [304] 
.const [173] = NameAndType [305] [306] 
.const [174] = Class [307] 
.const [175] = NameAndType [308] [309] 
.const [176] = Class [310] 
.const [177] = NameAndType [311] [312] 
.const [178] = Class [313] 
.const [179] = NameAndType [314] [315] 
.const [180] = Class [316] 
.const [181] = NameAndType [317] [318] 
.const [182] = Class [319] 
.const [183] = NameAndType [320] [321] 
.const [184] = Class [322] 
.const [185] = NameAndType [323] [324] 
.const [186] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo 
.const [187] = Class [325] 
.const [188] = NameAndType [326] [327] 
.const [189] = Class [328] 
.const [190] = NameAndType [329] [330] 
.const [191] = Class [331] 
.const [192] = NameAndType [332] [333] 
.const [193] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [194] = Utf8 access$300 
.const [195] = Utf8 (Lde/audi/app/navi/sdis/NaviASIProvider;)Lde/audi/atip/log/LogChannel; 
.const [196] = Utf8 de/audi/atip/interapp/NavigationUtilities 
.const [197] = Utf8 wgs84ToDegree 
.const [198] = Utf8 (I)D 
.const [199] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [200] = Utf8 getLocationAccessor 
.const [201] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lde/audi/atip/interapp/locationaccessor/IMyLocationAccessor; 
.const [202] = Utf8 de/audi/tghu/navi/app/util/addressformatting/AddressFormatter 
.const [203] = Utf8 formatOneLine 
.const [204] = Utf8 (Lorg/dsi/ifc/global/NavLocation;Lde/audi/tghu/navi/app/NavigationEnv;)Lde/audi/tghu/navi/app/util/addressformatting/LocationFormattingResponse; 
.const [205] = Utf8 de/audi/app/navi/sdis/NaviASIProvider$NaviTabletServiceListener 
.const [206] = Utf8 this$0 
.const [207] = Utf8 Lde/audi/app/navi/sdis/NaviASIProvider; 
.const [208] = Utf8 de/audi/atip/log/LogChannel 
.const [209] = Utf8 isDebug2 
.const [210] = Utf8 ()Z 
.const [211] = Utf8 de/audi/atip/log/LogChannel 
.const [212] = Utf8 log 
.const [213] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [214] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [215] = Utf8 directionAngle 
.const [216] = Utf8 I 
.const [217] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [218] = Utf8 height 
.const [219] = Utf8 I 
.const [220] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [221] = Utf8 latitude 
.const [222] = Utf8 I 
.const [223] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [224] = Utf8 longitude 
.const [225] = Utf8 I 
.const [226] = Utf8 org/dsi/ifc/navigation/PosPosition 
.const [227] = Utf8 speed 
.const [228] = Utf8 I 
.const [229] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [230] = Utf8 updateCarPosition 
.const [231] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/CarPosition;)V 
.const [232] = Utf8 de/audi/atip/log/LogChannel 
.const [233] = Utf8 log 
.const [234] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [235] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [236] = Utf8 updateRouteGuidanceActive 
.const [237] = Utf8 (Z)V 
.const [238] = Utf8 de/audi/tghu/navi/app/util/addressformatting/LocationFormattingResponse 
.const [239] = Utf8 getFirstLineAsText 
.const [240] = Utf8 ()Ljava/lang/String; 
.const [241] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [242] = Utf8 getStartDistance 
.const [243] = Utf8 ()I 
.const [244] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [245] = Utf8 getEndDistance 
.const [246] = Utf8 ()I 
.const [247] = Utf8 org/dsi/ifc/navigation/NavRouteListData 
.const [248] = Utf8 getRemainingTravelTime 
.const [249] = Utf8 ()I 
.const [250] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [251] = Utf8 updateDestinationInfo 
.const [252] = Utf8 ([Lde/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo;)V 
.const [253] = Utf8 org/dsi/ifc/navigation/RgInfoForNextDestination 
.const [254] = Utf8 destinationIndex 
.const [255] = Utf8 I 
.const [256] = Utf8 org/dsi/ifc/navigation/RgInfoForNextDestination 
.const [257] = Utf8 distanceToNextDest 
.const [258] = Utf8 J 
.const [259] = Utf8 org/dsi/ifc/navigation/RgInfoForNextDestination 
.const [260] = Utf8 timeToNextDest 
.const [261] = Utf8 J 
.const [262] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [263] = Utf8 updateNextDestinationInfo 
.const [264] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo;)V 
.const [265] = Utf8 de/audi/app/navi/sdis/NaviASIProvider$NaviTabletServiceListener 
.const [266] = Utf8 <init> 
.const [267] = Utf8 (Lde/audi/app/navi/sdis/NaviASIProvider;)V 
.const [268] = Utf8 java/lang/Object 
.const [269] = Utf8 <init> 
.const [270] = Utf8 ()V 
.const [271] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [272] = Utf8 <init> 
.const [273] = Utf8 ()V 
.const [274] = Utf8 de/audi/app/navi/sdis/NaviASIProvider$NaviTabletServiceListener 
.const [275] = Utf8 convertFromcmsToms 
.const [276] = Utf8 (I)I 
.const [277] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/DestinationInfo 
.const [278] = Utf8 <init> 
.const [279] = Utf8 (DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;IID)V 
.const [280] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo 
.const [281] = Utf8 <init> 
.const [282] = Utf8 ()V 
.const [283] = Utf8 de/audi/app/navi/sdis/NaviASIProvider$NaviTabletServiceListener 
.const [284] = Utf8 this$0 
.const [285] = Utf8 Lde/audi/app/navi/sdis/NaviASIProvider; 
.const [286] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [287] = Utf8 angle 
.const [288] = Utf8 I 
.const [289] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [290] = Utf8 height 
.const [291] = Utf8 I 
.const [292] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [293] = Utf8 latitude 
.const [294] = Utf8 D 
.const [295] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [296] = Utf8 longitude 
.const [297] = Utf8 D 
.const [298] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/CarPosition 
.const [299] = Utf8 speed 
.const [300] = Utf8 I 
.const [301] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [302] = Utf8 getLongitude 
.const [303] = Utf8 ()I 
.const [304] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [305] = Utf8 getLatitude 
.const [306] = Utf8 ()I 
.const [307] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [308] = Utf8 getCountry 
.const [309] = Utf8 ()Ljava/lang/String; 
.const [310] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [311] = Utf8 getTown 
.const [312] = Utf8 ()Ljava/lang/String; 
.const [313] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [314] = Utf8 getStreet 
.const [315] = Utf8 ()Ljava/lang/String; 
.const [316] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [317] = Utf8 getJunction 
.const [318] = Utf8 ()Ljava/lang/String; 
.const [319] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [320] = Utf8 getHousenumber 
.const [321] = Utf8 ()Ljava/lang/String; 
.const [322] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [323] = Utf8 getPoiName 
.const [324] = Utf8 ()Ljava/lang/String; 
.const [325] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo 
.const [326] = Utf8 destinationIndex 
.const [327] = Utf8 I 
.const [328] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo 
.const [329] = Utf8 distanceToNextDestination 
.const [330] = Utf8 D 
.const [331] = Utf8 de/esolutions/fw/comm/asi/hmisync/navigation/NextDestinationInfo 
.const [332] = Utf8 timeToNextDestiantion 
.const [333] = Utf8 D 
.const [334] = Utf8 de/audi/app/navi/sdis/NaviASIProvider$NaviTabletServiceListener 
.const [335] = Class [334] 
.const [336] = Utf8 java/lang/Object 
.const [337] = Class [336] 
.const [338] = Utf8 de/audi/tghu/navi/app/sdis/INaviTabletServiceListener 
.const [339] = Class [338] 
.const [340] = Utf8 this$0 
.const [341] = Utf8 Lde/audi/app/navi/sdis/NaviASIProvider; 
.const [342] = Utf8 Code 
.const [343] = Utf8 <init> 
.const [344] = Utf8 (Lde/audi/app/navi/sdis/NaviASIProvider;)V 
.const [345] = Utf8 updateCarPosition 
.const [346] = Utf8 (Lorg/dsi/ifc/navigation/PosPosition;)V 
.const [347] = Utf8 convertFromcmsToms 
.const [348] = Utf8 (I)I 
.const [349] = Utf8 updateRouteGuidanceActive 
.const [350] = Utf8 (Z)V 
.const [351] = Utf8 updateDestinationInfo 
.const [352] = Utf8 ([Lorg/dsi/ifc/navigation/NavRouteListData;[Lorg/dsi/ifc/global/NavLocation;Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [353] = Utf8 updateNextDestinationInfo 
.const [354] = Utf8 (Lorg/dsi/ifc/navigation/RgInfoForNextDestination;)V 
.const [355] = Utf8 <init> 
.const [356] = Utf8 (Lde/audi/app/navi/sdis/NaviASIProvider;Lde/audi/app/navi/sdis/NaviASIProvider$1;)V 
.end class 
