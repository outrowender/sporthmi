.version 50 0 
.class public super [174] 
.super [176] 
.field private static final [177] [178] 
.field private static final [179] [180] 
.field private static final [181] [182] 
.field private static final [183] [184] 
.field private static final [185] [186] 
.field private static final [187] [188] 
.field private static final [189] [190] 
.field private static final [191] [192] 
.field private final [193] [194] 
.field private final [195] [196] 

.method public [198] : [199] 
    .attribute [197] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [42] 
L7:     aload_0 
L8:     aload 5 
L10:    putfield [44] 
L13:    aload_0 
L14:    aload 4 
L16:    iconst_0 
L17:    invokestatic [2] 
L20:    putfield [45] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [197] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [36] 
L12:    aload_0 
L13:    getfield [34] 
L16:    i2l 
L17:    invokevirtual [37] 
L20:    pop 
L21:    ldc [5] 
L23:    istore_1 
L24:    iconst_0 
L25:    invokestatic [6] 
L28:    aload_0 
L29:    getfield [34] 
L32:    tableswitch 4 
            L81 
            L60 
            L104 
            default : L130 

L60:    aload_0 
L61:    getfield [35] 
L64:    ldc [3] 
L66:    ldc [7] 
L68:    aload_0 
L69:    invokevirtual [36] 
L72:    invokevirtual [38] 
L75:    pop 
L76:    iconst_m1 
L77:    istore_1 
L78:    goto L135 
L81:    aload_0 
L82:    getfield [35] 
L85:    ldc [3] 
L87:    ldc [8] 
L89:    aload_0 
L90:    invokevirtual [36] 
L93:    invokevirtual [38] 
L96:    pop 
L97:    sipush 300 
L100:   istore_1 
L101:   goto L135 
L104:   aload_0 
L105:   getfield [35] 
L108:   ldc [3] 
L110:   ldc [9] 
L112:   aload_0 
L113:   invokevirtual [36] 
L116:   invokevirtual [38] 
L119:   pop 
L120:   aload_0 
L121:   getfield [33] 
L124:   invokeinterface [46] 0 
L129:   return 
L130:   aload_0 
L131:   invokespecial [43] 
L134:   istore_1 
L135:   iload_1 
L136:   ldc [5] 
L138:   if_icmpne L149 
L141:   aload_0 
L142:   sipush 3001 
L145:   invokevirtual [39] 
L148:   return 
L149:   aload_0 
L150:   getfield [35] 
L153:   ldc [3] 
L155:   ldc [10] 
L157:   aload_0 
L158:   invokevirtual [36] 
L161:   iload_1 
L162:   i2l 
L163:   invokevirtual [37] 
L166:   pop 
L167:   aload_0 
L168:   getfield [33] 
L171:   iload_1 
L172:   invokeinterface [47] 0 
L177:   return 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method private [202] : [203] 
    .attribute [197] .code stack 6 locals 3 
L0:     invokestatic [11] 
L3:     iconst_0 
L4:     aaload 
L5:     astore_1 
L6:     ldc [5] 
L8:     istore_2 
        .catch [13] from L9 to L14 using L17 
L9:     aload_1 
L10:    invokestatic [12] 
L13:    istore_2 
L14:    goto L36 
L17:    astore_3 
L18:    aload_0 
L19:    getfield [35] 
L22:    ldc [14] 
L24:    ldc [15] 
L26:    aload_0 
L27:    invokevirtual [36] 
L30:    aload_1 
L31:    invokevirtual [40] 
L34:    iload_2 
L35:    areturn 
L36:    aload_0 
L37:    getfield [34] 
L40:    tableswitch 0 
            L72 
            L97 
            L155 
            L128 
            default : L174 

L72:    aload_0 
L73:    getfield [35] 
L76:    ldc [3] 
L78:    ldc [16] 
L80:    aload_0 
L81:    invokevirtual [36] 
L84:    invokevirtual [38] 
L87:    pop 
L88:    iload_2 
L89:    sipush 1000 
L92:    imul 
L93:    istore_2 
L94:    goto L197 
L97:    aload_0 
L98:    getfield [35] 
L101:   ldc [3] 
L103:   ldc [17] 
L105:   aload_0 
L106:   invokevirtual [36] 
L109:   invokevirtual [38] 
L112:   pop 
L113:   iload_2 
L114:   sipush 1760 
L117:   imul 
L118:   i2d 
L119:   ldc2_w [48] 
L122:   dmul 
L123:   d2i 
L124:   istore_2 
L125:   goto L197 
L128:   aload_0 
L129:   getfield [35] 
L132:   ldc [3] 
L134:   ldc [18] 
L136:   aload_0 
L137:   invokevirtual [36] 
L140:   invokevirtual [38] 
L143:   pop 
L144:   iload_2 
L145:   i2d 
L146:   ldc2_w [48] 
L149:   dmul 
L150:   d2i 
L151:   istore_2 
L152:   goto L197 
L155:   aload_0 
L156:   getfield [35] 
L159:   ldc [3] 
L161:   ldc [19] 
L163:   aload_0 
L164:   invokevirtual [36] 
L167:   invokevirtual [38] 
L170:   pop 
L171:   goto L197 
L174:   aload_0 
L175:   getfield [35] 
L178:   ldc [14] 
L180:   ldc [20] 
L182:   aload_0 
L183:   invokevirtual [36] 
L186:   aload_0 
L187:   getfield [34] 
L190:   i2l 
L191:   invokevirtual [37] 
L194:   pop 
L195:   iload_2 
L196:   areturn 
L197:   iload_2 
L198:   areturn 
L199:   nop 
L200:   
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [197] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [3] 
L6:     ldc [21] 
L8:     aload_0 
L9:     invokevirtual [36] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [37] 
L17:    pop 
L18:    iload_1 
L19:    invokestatic [22] 
L22:    istore_2 
L23:    aload_0 
L24:    getfield [35] 
L27:    ldc [3] 
L29:    ldc [23] 
L31:    aload_0 
L32:    invokevirtual [36] 
L35:    iload_2 
L36:    i2l 
L37:    invokevirtual [37] 
L40:    pop 
L41:    aload_0 
L42:    iload_2 
L43:    invokevirtual [39] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [197] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ldc [3] 
L6:     ldc [24] 
L8:     aload_0 
L9:     invokevirtual [36] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [37] 
L17:    pop 
L18:    aload_0 
L19:    iload_1 
L20:    invokevirtual [41] 
L23:    return 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [50] [51] 
.const [3] = Int -2137614336 
.const [4] = String [52] 
.const [5] = Int 128 
.const [6] = Method [53] [54] 
.const [7] = String [55] 
.const [8] = String [56] 
.const [9] = String [57] 
.const [10] = String [58] 
.const [11] = Method [59] [60] 
.const [12] = Method [61] [62] 
.const [13] = Class [63] 
.const [14] = Int -1601830656 
.const [15] = String [64] 
.const [16] = String [65] 
.const [17] = String [66] 
.const [18] = String [67] 
.const [19] = String [68] 
.const [20] = String [69] 
.const [21] = String [70] 
.const [22] = Method [71] [72] 
.const [23] = String [73] 
.const [24] = String [74] 
.const [25] = Class [75] 
.const [26] = Class [76] 
.const [27] = Class [77] 
.const [28] = Class [78] 
.const [29] = Class [79] 
.const [30] = Class [80] 
.const [31] = Class [81] 
.const [32] = Class [82] 
.const [33] = Field [83] [84] 
.const [34] = Field [85] [86] 
.const [35] = Field [87] [88] 
.const [36] = Method [89] [90] 
.const [37] = Method [91] [92] 
.const [38] = Method [93] [94] 
.const [39] = Method [95] [96] 
.const [40] = Method [97] [98] 
.const [41] = Method [99] [100] 
.const [42] = Method [101] [102] 
.const [43] = Method [103] [104] 
.const [44] = Field [105] [106] 
.const [45] = Field [107] [108] 
.const [46] = InterfaceMethod [109] [110] 
.const [47] = InterfaceMethod [111] [112] 
.const [48] = Double +0x1D42C3C9EECBFBp-53 
.const [50] = Class [113] 
.const [51] = NameAndType [114] [115] 
.const [52] = Utf8 '%1#execute: distanceType=%2' 
.const [53] = Class [116] 
.const [54] = NameAndType [117] [118] 
.const [55] = Utf8 '[%1#processBlockRouteValueSet] Blocking next section!' 
.const [56] = Utf8 '[%1#processBlockRouteValueSet] Blocking next street!' 
.const [57] = Utf8 '[%1#processBlockRouteValueSet] Unblocking next section!' 
.const [58] = Utf8 '%1#execute: distance=%2!' 
.const [59] = Class [119] 
.const [60] = NameAndType [120] [121] 
.const [61] = Class [122] 
.const [62] = NameAndType [123] [124] 
.const [63] = Utf8 java/lang/NumberFormatException 
.const [64] = Utf8 "[%1#execute: No number found in '%2', returning DISTANCE_UKNOWN!" 
.const [65] = Utf8 '[%1#execute: Kilometers recognized, multiplying distance with 1000!' 
.const [66] = Utf8 '[%1#execute: Miles recognized, multiplying distance with 1760 * 0,9144!' 
.const [67] = Utf8 '%1#execute: Yards recognized, multiplying distance with 1760 * 0,9144!' 
.const [68] = Utf8 '%1#execute: Meters recognized, no multiplication needed!' 
.const [69] = Utf8 '%1#execute: Unhandled distanceType %2, sending ERROR!' 
.const [70] = Utf8 '%1#responseBlockRoute: result=%2' 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Utf8 '%1#responseBlockRoute: sdsRes=%2!' 
.const [74] = Utf8 '%1#responseUnblockRoute: result=%2, calling responseBlockRoute!' 
.const [75] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [76] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [77] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [80] = Utf8 de/audi/atip/interapp/NaviService 
.const [81] = Utf8 java/lang/Integer 
.const [82] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [83] = Class [128] 
.const [84] = NameAndType [129] [130] 
.const [85] = Class [131] 
.const [86] = NameAndType [132] [133] 
.const [87] = Class [134] 
.const [88] = NameAndType [135] [136] 
.const [89] = Class [137] 
.const [90] = NameAndType [138] [139] 
.const [91] = Class [140] 
.const [92] = NameAndType [141] [142] 
.const [93] = Class [143] 
.const [94] = NameAndType [144] [145] 
.const [95] = Class [146] 
.const [96] = NameAndType [147] [148] 
.const [97] = Class [149] 
.const [98] = NameAndType [150] [151] 
.const [99] = Class [152] 
.const [100] = NameAndType [153] [154] 
.const [101] = Class [155] 
.const [102] = NameAndType [156] [157] 
.const [103] = Class [158] 
.const [104] = NameAndType [159] [160] 
.const [105] = Class [161] 
.const [106] = NameAndType [162] [163] 
.const [107] = Class [164] 
.const [108] = NameAndType [165] [166] 
.const [109] = Class [167] 
.const [110] = NameAndType [168] [169] 
.const [111] = Class [170] 
.const [112] = NameAndType [171] [172] 
.const [113] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [114] = Utf8 retrieveInteger 
.const [115] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [116] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [117] = Utf8 setNavInfoDistance 
.const [118] = Utf8 (I)V 
.const [119] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [120] = Utf8 getSlotModelStrings 
.const [121] = Utf8 ()[Ljava/lang/String; 
.const [122] = Utf8 java/lang/Integer 
.const [123] = Utf8 parseInt 
.const [124] = Utf8 (Ljava/lang/String;)I 
.const [125] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [126] = Utf8 getGenericSDSResult 
.const [127] = Utf8 (B)I 
.const [128] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [129] = Utf8 service 
.const [130] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [131] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [132] = Utf8 distanceType 
.const [133] = Utf8 I 
.const [134] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [135] = Utf8 logger 
.const [136] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [137] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [138] = Utf8 getName 
.const [139] = Utf8 ()Ljava/lang/String; 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [146] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [147] = Utf8 sendResult 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [152] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [153] = Utf8 responseBlockRoute 
.const [154] = Utf8 (B)V 
.const [155] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [158] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [159] = Utf8 getDistanceFromSlot 
.const [160] = Utf8 ()I 
.const [161] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [162] = Utf8 service 
.const [163] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [164] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [165] = Utf8 distanceType 
.const [166] = Utf8 I 
.const [167] = Utf8 de/audi/atip/interapp/NaviService 
.const [168] = Utf8 unblockRoute 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/audi/atip/interapp/NaviService 
.const [171] = Utf8 blockRoute 
.const [172] = Utf8 (I)V 
.const [173] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviBlockRouteValueSetCommand 
.const [174] = Class [173] 
.const [175] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [176] = Class [175] 
.const [177] = Utf8 DISTANCE_UKNOWN 
.const [178] = Utf8 I 
.const [179] = Utf8 TYPE_KILOMETERS 
.const [180] = Utf8 I 
.const [181] = Utf8 TYPE_MILES 
.const [182] = Utf8 I 
.const [183] = Utf8 TYPE_METERS 
.const [184] = Utf8 I 
.const [185] = Utf8 TYPE_YARDS 
.const [186] = Utf8 I 
.const [187] = Utf8 TYPE_NEXT_STREET 
.const [188] = Utf8 I 
.const [189] = Utf8 TYPE_NEXT_SECTION 
.const [190] = Utf8 I 
.const [191] = Utf8 TYPE_NO_U_TURN 
.const [192] = Utf8 I 
.const [193] = Utf8 service 
.const [194] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [195] = Utf8 distanceType 
.const [196] = Utf8 I 
.const [197] = Utf8 Code 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/atip/interapp/NaviService;)V 
.const [200] = Utf8 execute 
.const [201] = Utf8 ()V 
.const [202] = Utf8 getDistanceFromSlot 
.const [203] = Utf8 ()I 
.const [204] = Utf8 responseBlockRoute 
.const [205] = Utf8 (B)V 
.const [206] = Utf8 responseUnblockRoute 
.const [207] = Utf8 (B)V 
.end class 
