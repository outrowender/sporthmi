.version 50 0 
.class public super [240] 
.super [242] 

.method public annotation [244] : [245] 
    .attribute [243] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [54] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [246] : [247] 
    .attribute [243] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     invokeinterface [56] 0 
L9:     istore_1 
L10:    iload_1 
L11:    iconst_1 
L12:    iand 
L13:    iconst_1 
L14:    if_icmpne L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [248] : [249] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [36] 
L4:     iconst_1 
L5:     iand 
L6:     iconst_1 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [250] : [251] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [36] 
L4:     bipush 32 
L6:     iand 
L7:     bipush 32 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [252] : [253] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [36] 
L4:     bipush 8 
L6:     iand 
L7:     bipush 8 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [254] : [255] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [36] 
L4:     iconst_4 
L5:     iand 
L6:     iconst_4 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [256] : [257] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokestatic [3] 
L4:     invokevirtual [37] 
L7:     pop 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [258] : [259] 
    .attribute [243] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [38] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     invokevirtual [39] 
L12:    i2l 
L13:    invokevirtual [40] 
L16:    pop 
L17:    aconst_null 
L18:    astore_2 
L19:    aload_0 
L20:    invokevirtual [39] 
L23:    tableswitch 0 
            L60 
            L72 
            L77 
            L77 
            L77 
            L123 
            default : L164 

L60:    invokestatic [6] 
L63:    astore_2 
L64:    aload_2 
L65:    invokestatic [7] 
L68:    astore_2 
L69:    goto L184 
L72:    aconst_null 
L73:    astore_2 
L74:    goto L184 
L77:    aload_0 
L78:    invokevirtual [41] 
L81:    astore_2 
L82:    aload_2 
L83:    ifnull L93 
L86:    aload_2 
L87:    invokevirtual [42] 
L90:    ifne L115 
L93:    aload_1 
L94:    invokevirtual [38] 
L97:    sipush 10000 
L100:   ldc [8] 
L102:   aload_2 
L103:   invokestatic [9] 
L106:   invokevirtual [43] 
L109:   pop 
L110:   aconst_null 
L111:   astore_2 
L112:   goto L184 
L115:   aload_2 
L116:   invokestatic [7] 
L119:   astore_2 
L120:   goto L184 
L123:   aload_0 
L124:   invokevirtual [41] 
L127:   astore_2 
L128:   aload_2 
L129:   ifnull L142 
L132:   aload_2 
L133:   invokevirtual [44] 
L136:   invokestatic [10] 
L139:   ifeq L184 
L142:   aconst_null 
L143:   astore_2 
L144:   aload_1 
L145:   invokevirtual [38] 
L148:   sipush 10000 
L151:   ldc [8] 
L153:   aload_2 
L154:   invokestatic [9] 
L157:   invokevirtual [43] 
L160:   pop 
L161:   goto L184 
L164:   aload_1 
L165:   invokevirtual [38] 
L168:   sipush 10000 
L171:   ldc [11] 
L173:   aload_0 
L174:   invokevirtual [39] 
L177:   i2l 
L178:   invokevirtual [40] 
L181:   pop 
L182:   aconst_null 
L183:   astore_2 
L184:   aload_1 
L185:   invokevirtual [38] 
L188:   ldc [4] 
L190:   ldc [12] 
L192:   aload_2 
L193:   invokevirtual [43] 
L196:   pop 
L197:   aload_2 
L198:   areturn 
L199:   nop 
L200:   
    .end code 
.end method 

.method private static [260] : [261] 
    .attribute [243] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual [45] 
L4:     istore_1 
L5:     aload_0 
L6:     invokevirtual [46] 
L9:     istore_2 
L10:    iload_1 
L11:    iload_2 
L12:    invokestatic [13] 
L15:    astore_0 
L16:    aload_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [262] : [263] 
    .attribute [243] .code stack 4 locals 2 
L0:     aload_1 
L1:     invokevirtual [38] 
L4:     astore 4 
L6:     aload 4 
L8:     ldc [4] 
L10:    ldc [14] 
L12:    aload_0 
L13:    invokevirtual [43] 
L16:    pop 
L17:    new [57] 
L20:    dup 
L21:    aload_2 
L22:    invokespecial [55] 
L25:    astore 5 
L27:    aload 5 
L29:    aload 4 
L31:    aload_0 
L32:    aload_3 
L33:    invokevirtual [47] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [264] : [265] 
    .attribute [243] .code stack 4 locals 2 
L0:     aload_1 
L1:     invokevirtual [38] 
L4:     astore 4 
L6:     aload 4 
L8:     ldc [4] 
L10:    ldc [16] 
L12:    aload_0 
L13:    invokevirtual [43] 
L16:    pop 
L17:    new [57] 
L20:    dup 
L21:    aload_2 
L22:    invokespecial [55] 
L25:    astore 5 
L27:    aload 5 
L29:    aload 4 
L31:    aload_0 
L32:    aload_3 
L33:    invokevirtual [48] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [266] : [267] 
    .attribute [243] .code stack 4 locals 2 
L0:     aload_1 
L1:     invokevirtual [38] 
L4:     astore_2 
L5:     aload_2 
L6:     ldc [4] 
L8:     ldc [17] 
L10:    aload_0 
L11:    invokestatic [9] 
L14:    invokevirtual [43] 
L17:    pop 
L18:    aload_0 
L19:    invokestatic [18] 
L22:    astore_3 
L23:    aload_3 
L24:    invokestatic [10] 
L27:    ifeq L41 
L30:    aload_2 
L31:    ldc [4] 
L33:    ldc [19] 
L35:    invokevirtual [49] 
L38:    pop 
L39:    iconst_0 
L40:    areturn 
L41:    aload_2 
L42:    ldc [4] 
L44:    ldc [20] 
L46:    aload_3 
L47:    invokevirtual [43] 
L50:    pop 
L51:    iconst_1 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public static [268] : [269] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [50] 
L4:     sipush 4433 
L7:     invokeinterface [58] 0 
L12:    ifne L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [270] : [271] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [50] 
L4:     sipush 4433 
L7:     invokeinterface [58] 0 
L12:    iconst_1 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [272] : [273] 
    .attribute [243] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L29 
L4:     aload_0 
L5:     invokestatic [21] 
L8:     ifeq L29 
L11:    aload_0 
L12:    invokevirtual [51] 
L15:    ifne L29 
L18:    aload_0 
L19:    invokevirtual [52] 
L22:    ifne L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [274] : [275] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L16 
L4:     aload_0 
L5:     invokevirtual [53] 
L8:     iconst_2 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [276] : [277] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L16 
L4:     aload_1 
L5:     invokevirtual [52] 
L8:     iload_0 
L9:     if_icmplt L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [278] : [279] 
    .attribute [243] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L16 
L4:     aload_0 
L5:     invokevirtual [53] 
L8:     iconst_3 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [59] [60] 
.const [3] = Method [61] [62] 
.const [4] = Int -2137614336 
.const [5] = String [63] 
.const [6] = Method [64] [65] 
.const [7] = Method [66] [67] 
.const [8] = String [68] 
.const [9] = Method [69] [70] 
.const [10] = Method [71] [72] 
.const [11] = String [73] 
.const [12] = String [74] 
.const [13] = Method [75] [76] 
.const [14] = String [77] 
.const [15] = Class [78] 
.const [16] = String [79] 
.const [17] = String [80] 
.const [18] = Method [81] [82] 
.const [19] = String [83] 
.const [20] = String [84] 
.const [21] = Method [85] [86] 
.const [22] = Class [87] 
.const [23] = Class [88] 
.const [24] = Class [89] 
.const [25] = Class [90] 
.const [26] = Class [91] 
.const [27] = Class [92] 
.const [28] = Class [93] 
.const [29] = Class [94] 
.const [30] = Class [95] 
.const [31] = Class [96] 
.const [32] = Class [97] 
.const [33] = Class [98] 
.const [34] = Class [99] 
.const [35] = Class [100] 
.const [36] = Method [101] [102] 
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
.const [51] = Method [131] [132] 
.const [52] = Method [133] [134] 
.const [53] = Method [135] [136] 
.const [54] = Method [137] [138] 
.const [55] = Method [139] [140] 
.const [56] = InterfaceMethod [141] [142] 
.const [57] = Class [143] 
.const [58] = InterfaceMethod [144] [145] 
.const [59] = Class [146] 
.const [60] = NameAndType [147] [148] 
.const [61] = Class [149] 
.const [62] = NameAndType [150] [151] 
.const [63] = Utf8 'PoiUtil#getLocation() - searchContext: %1' 
.const [64] = Class [152] 
.const [65] = NameAndType [153] [154] 
.const [66] = Class [155] 
.const [67] = NameAndType [156] [157] 
.const [68] = Utf8 'PoiUtil#getLocation() - failed to resolve navigable destination: %1!' 
.const [69] = Class [158] 
.const [70] = NameAndType [159] [160] 
.const [71] = Class [161] 
.const [72] = NameAndType [162] [163] 
.const [73] = Utf8 'PoiUtil#getLocation() - failed to resolve PoiSearchArea: %1!' 
.const [74] = Utf8 'PoiUtil#getLocation() - location: %1' 
.const [75] = Class [164] 
.const [76] = NameAndType [165] [166] 
.const [77] = Utf8 'PoiUtil#callPoi - location=%1' 
.const [78] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/CallPhoneNumberSequence 
.const [79] = Utf8 'PoiUtil#callPoi - liValueListElement=%1' 
.const [80] = Utf8 'PoiUtil#checkIfPoiIsCallable for location=%1' 
.const [81] = Class [167] 
.const [82] = NameAndType [168] [169] 
.const [83] = Utf8 'PoiUtil#checkIfPoiIsCallable - location has NO phonenumber' 
.const [84] = Utf8 'PoiUtil#checkIfPoiIsCallable - location has phonenumber %1' 
.const [85] = Class [170] 
.const [86] = NameAndType [171] [172] 
.const [87] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [90] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [91] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [92] = Utf8 de/audi/tghu/navi/app/util/TextUtil 
.const [93] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [94] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [95] = Utf8 de/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 org/dsi/ifc/global/NavLocation 
.const [98] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [99] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [100] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [101] = Class [173] 
.const [102] = NameAndType [174] [175] 
.const [103] = Class [176] 
.const [104] = NameAndType [177] [178] 
.const [105] = Class [179] 
.const [106] = NameAndType [180] [181] 
.const [107] = Class [182] 
.const [108] = NameAndType [183] [184] 
.const [109] = Class [185] 
.const [110] = NameAndType [186] [187] 
.const [111] = Class [188] 
.const [112] = NameAndType [189] [190] 
.const [113] = Class [191] 
.const [114] = NameAndType [192] [193] 
.const [115] = Class [194] 
.const [116] = NameAndType [195] [196] 
.const [117] = Class [197] 
.const [118] = NameAndType [198] [199] 
.const [119] = Class [200] 
.const [120] = NameAndType [201] [202] 
.const [121] = Class [203] 
.const [122] = NameAndType [204] [205] 
.const [123] = Class [206] 
.const [124] = NameAndType [207] [208] 
.const [125] = Class [209] 
.const [126] = NameAndType [210] [211] 
.const [127] = Class [212] 
.const [128] = NameAndType [213] [214] 
.const [129] = Class [215] 
.const [130] = NameAndType [216] [217] 
.const [131] = Class [218] 
.const [132] = NameAndType [219] [220] 
.const [133] = Class [221] 
.const [134] = NameAndType [222] [223] 
.const [135] = Class [224] 
.const [136] = NameAndType [225] [226] 
.const [137] = Class [227] 
.const [138] = NameAndType [228] [229] 
.const [139] = Class [230] 
.const [140] = NameAndType [231] [232] 
.const [141] = Class [233] 
.const [142] = NameAndType [234] [235] 
.const [143] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/CallPhoneNumberSequence 
.const [144] = Class [236] 
.const [145] = NameAndType [237] [238] 
.const [146] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [147] = Utf8 getLocationAccessor 
.const [148] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lde/audi/atip/interapp/locationaccessor/IMyLocationAccessor; 
.const [149] = Utf8 de/audi/tghu/navi/app/util/TextUtil 
.const [150] = Utf8 getPoi24hMarker 
.const [151] = Utf8 ()Ljava/lang/String; 
.const [152] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [153] = Utf8 getDynamicVicinityLocation 
.const [154] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [155] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [156] = Utf8 transformLocationBySurrounding 
.const [157] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/global/NavLocation; 
.const [158] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [159] = Utf8 formatLocationShort 
.const [160] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Ljava/lang/String; 
.const [161] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [162] = Utf8 isEmpty 
.const [163] = Utf8 (Ljava/lang/String;)Z 
.const [164] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [165] = Utf8 getLocationFromGeoPos 
.const [166] = Utf8 (II)Lorg/dsi/ifc/global/NavLocation; 
.const [167] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [168] = Utf8 getPhoneNumber 
.const [169] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Ljava/lang/String; 
.const [170] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [171] = Utf8 substringSearchIsRunning 
.const [172] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [173] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [174] = Utf8 getAdditionalFlags 
.const [175] = Utf8 ()I 
.const [176] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [177] = Utf8 append 
.const [178] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [179] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [180] = Utf8 getPOILogChannel 
.const [181] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [182] = Utf8 de/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea 
.const [183] = Utf8 getSearchContext 
.const [184] = Utf8 ()I 
.const [185] = Utf8 de/audi/atip/log/LogChannel 
.const [186] = Utf8 log 
.const [187] = Utf8 (ILjava/lang/String;J)Z 
.const [188] = Utf8 de/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea 
.const [189] = Utf8 getLocation 
.const [190] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [191] = Utf8 org/dsi/ifc/global/NavLocation 
.const [192] = Utf8 isPositionValid 
.const [193] = Utf8 ()Z 
.const [194] = Utf8 de/audi/atip/log/LogChannel 
.const [195] = Utf8 log 
.const [196] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [197] = Utf8 org/dsi/ifc/global/NavLocation 
.const [198] = Utf8 getCountry 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 org/dsi/ifc/global/NavLocation 
.const [201] = Utf8 getLongitude 
.const [202] = Utf8 ()I 
.const [203] = Utf8 org/dsi/ifc/global/NavLocation 
.const [204] = Utf8 getLatitude 
.const [205] = Utf8 ()I 
.const [206] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/CallPhoneNumberSequence 
.const [207] = Utf8 start 
.const [208] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/global/NavLocation;Lde/audi/atip/phone/ITelService;)V 
.const [209] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/CallPhoneNumberSequence 
.const [210] = Utf8 start 
.const [211] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/navigation/LIValueListElement;Lde/audi/atip/phone/ITelService;)V 
.const [212] = Utf8 de/audi/atip/log/LogChannel 
.const [213] = Utf8 log 
.const [214] = Utf8 (ILjava/lang/String;)Z 
.const [215] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [216] = Utf8 getFramework 
.const [217] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [218] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [219] = Utf8 getDistance 
.const [220] = Utf8 ()I 
.const [221] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [222] = Utf8 getNumberOfAvailableItems 
.const [223] = Utf8 ()I 
.const [224] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [225] = Utf8 getStatus 
.const [226] = Utf8 ()I 
.const [227] = Utf8 java/lang/Object 
.const [228] = Utf8 <init> 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/audi/tghu/navi/app/addressinput/poi/sequences/CallPhoneNumberSequence 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (Lde/audi/tghu/command/ICommandListFactory;)V 
.const [233] = Utf8 de/audi/atip/interapp/locationaccessor/IMyLocationAccessor 
.const [234] = Utf8 getAdditionalFlags 
.const [235] = Utf8 ()I 
.const [236] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [237] = Utf8 getSysConst 
.const [238] = Utf8 (I)I 
.const [239] = Utf8 de/audi/tghu/navi/app/addressinput/poi/PoiUtil 
.const [240] = Class [239] 
.const [241] = Utf8 java/lang/Object 
.const [242] = Class [241] 
.const [243] = Utf8 Code 
.const [244] = Utf8 <init> 
.const [245] = Utf8 ()V 
.const [246] = Utf8 isPoi24h 
.const [247] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Z 
.const [248] = Utf8 isPoi24h 
.const [249] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;)Z 
.const [250] = Utf8 isPayByCreditCardPossible 
.const [251] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;)Z 
.const [252] = Utf8 isDieselAvailable 
.const [253] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;)Z 
.const [254] = Utf8 hasTravelGuideAdditionalInfo 
.const [255] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;)Z 
.const [256] = Utf8 appendPoi24hMarker 
.const [257] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [258] = Utf8 getLocation 
.const [259] = Utf8 (Lde/audi/tghu/navi/app/addressinput/poi/searcharea/PoiSearchArea;Lde/audi/tghu/navi/app/NavigationEnv;)Lorg/dsi/ifc/global/NavLocation; 
.const [260] = Utf8 transformLocationBySurrounding 
.const [261] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/global/NavLocation; 
.const [262] = Utf8 callPoi 
.const [263] = Utf8 (Lorg/dsi/ifc/global/NavLocation;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/command/ICommandListFactory;Lde/audi/atip/phone/ITelService;)V 
.const [264] = Utf8 callPoi 
.const [265] = Utf8 (Lorg/dsi/ifc/navigation/LIValueListElement;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/command/ICommandListFactory;Lde/audi/atip/phone/ITelService;)V 
.const [266] = Utf8 checkIfPoiIsCallable 
.const [267] = Utf8 (Lorg/dsi/ifc/global/NavLocation;Lde/audi/tghu/navi/app/NavigationEnv;)Z 
.const [268] = Utf8 useFreeTextSearch 
.const [269] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)Z 
.const [270] = Utf8 useNvcTextSearch 
.const [271] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)Z 
.const [272] = Utf8 substringSearchStarted 
.const [273] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [274] = Utf8 substringSearchIsRunning 
.const [275] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [276] = Utf8 substringSearchHasItems 
.const [277] = Utf8 (ILorg/dsi/ifc/navigation/ValueListStatus;)Z 
.const [278] = Utf8 substringSearchEnded 
.const [279] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)Z 
.end class 
