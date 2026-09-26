.version 50 0 
.class public final super [205] 
.super [207] 
.implements [209] 
.field public [210] [211] 
.field private static final [212] [213] 
.field public static final [214] [215] 
.field public static final [216] [217] 
.field public static final [218] [219] 
.field public static final [220] [221] 
.field public [222] [223] 
.field private static final [224] [225] 
.field public static final [226] [227] 
.field public static final [228] [229] 
.field public [230] [231] 
.field private static final [232] [233] 
.field public [234] [235] 
.field private static final [236] [237] 
.field public [238] [239] 
.field private static final [240] [241] 
.field public [242] [243] 
.field private static final [244] [245] 
.field public [246] [247] 
.field private static final [248] [249] 

.method public [251] : [252] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     invokespecial [33] 
L8:     aload_0 
L9:     invokespecial [34] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [255] : [256] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [37] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [38] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [39] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [40] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [41] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [42] 
L30:    aload_0 
L31:    iconst_0 
L32:    putfield [43] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [250] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [22] 
L9:     aload_2 
L10:    getfield [22] 
L13:    if_icmpne L86 
L16:    aload_0 
L17:    getfield [23] 
L20:    aload_2 
L21:    getfield [23] 
L24:    if_icmpne L86 
L27:    aload_0 
L28:    getfield [24] 
L31:    aload_2 
L32:    getfield [24] 
L35:    if_icmpne L86 
L38:    aload_0 
L39:    getfield [25] 
L42:    aload_2 
L43:    getfield [25] 
L46:    if_icmpne L86 
L49:    aload_0 
L50:    getfield [26] 
L53:    aload_2 
L54:    getfield [26] 
L57:    if_icmpne L86 
L60:    aload_0 
L61:    getfield [27] 
L64:    aload_2 
L65:    getfield [27] 
L68:    if_icmpne L86 
L71:    aload_0 
L72:    getfield [28] 
L75:    aload_2 
L76:    getfield [28] 
L79:    if_icmpne L86 
L82:    iconst_1 
L83:    goto L87 
L86:    iconst_0 
L87:    areturn 
L88:    
    .end code 
.end method 

.method private enum [261] : [262] 
    .attribute [250] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [250] .code stack 2 locals 1 
L0:     new [44] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [29] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [29] 
L21:    pop 
L22:    aload_0 
L23:    getfield [22] 
L26:    lookupswitch 
            0 : L68 
            1 : L78 
            2 : L88 
            15 : L98 
            default : L108 

L68:    aload_1 
L69:    ldc [6] 
L71:    invokevirtual [29] 
L74:    pop 
L75:    goto L115 
L78:    aload_1 
L79:    ldc [7] 
L81:    invokevirtual [29] 
L84:    pop 
L85:    goto L115 
L88:    aload_1 
L89:    ldc [8] 
L91:    invokevirtual [29] 
L94:    pop 
L95:    goto L115 
L98:    aload_1 
L99:    ldc [9] 
L101:   invokevirtual [29] 
L104:   pop 
L105:   goto L115 
L108:   aload_1 
L109:   ldc [10] 
L111:   invokevirtual [29] 
L114:   pop 
L115:   aload_1 
L116:   ldc [11] 
L118:   invokevirtual [29] 
L121:   pop 
L122:   aload_0 
L123:   getfield [23] 
L126:   lookupswitch 
            0 : L152 
            1 : L162 
            default : L172 

L152:   aload_1 
L153:   ldc [12] 
L155:   invokevirtual [29] 
L158:   pop 
L159:   goto L179 
L162:   aload_1 
L163:   ldc [13] 
L165:   invokevirtual [29] 
L168:   pop 
L169:   goto L179 
L172:   aload_1 
L173:   ldc [10] 
L175:   invokevirtual [29] 
L178:   pop 
L179:   aload_1 
L180:   ldc [14] 
L182:   invokevirtual [29] 
L185:   pop 
L186:   aload_1 
L187:   aload_0 
L188:   getfield [24] 
L191:   invokevirtual [30] 
L194:   pop 
L195:   aload_1 
L196:   ldc [15] 
L198:   invokevirtual [29] 
L201:   pop 
L202:   aload_1 
L203:   aload_0 
L204:   getfield [25] 
L207:   invokevirtual [30] 
L210:   pop 
L211:   aload_1 
L212:   ldc [16] 
L214:   invokevirtual [29] 
L217:   pop 
L218:   aload_1 
L219:   aload_0 
L220:   getfield [26] 
L223:   invokevirtual [30] 
L226:   pop 
L227:   aload_1 
L228:   ldc [17] 
L230:   invokevirtual [29] 
L233:   pop 
L234:   aload_1 
L235:   aload_0 
L236:   getfield [27] 
L239:   invokevirtual [30] 
L242:   pop 
L243:   aload_1 
L244:   ldc [18] 
L246:   invokevirtual [29] 
L249:   pop 
L250:   aload_1 
L251:   aload_0 
L252:   getfield [28] 
L255:   invokevirtual [30] 
L258:   pop 
L259:   aload_1 
L260:   invokevirtual [31] 
L263:   areturn 
L264:   
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [250] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 4 
L5:     iinc 1 4 
L8:     iinc 1 8 
L11:    iinc 1 8 
L14:    iinc 1 8 
L17:    iinc 1 8 
L20:    iinc 1 8 
L23:    iload_1 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [250] .code stack 3 locals 0 
L0:     aload_1 
L1:     iconst_4 
L2:     aload_0 
L3:     getfield [22] 
L6:     invokeinterface [45] 0 
L11:    aload_1 
L12:    iconst_4 
L13:    aload_0 
L14:    getfield [23] 
L17:    invokeinterface [45] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [24] 
L27:    i2b 
L28:    invokeinterface [46] 0 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [25] 
L38:    i2b 
L39:    invokeinterface [46] 0 
L44:    aload_1 
L45:    aload_0 
L46:    getfield [26] 
L49:    i2b 
L50:    invokeinterface [46] 0 
L55:    aload_1 
L56:    aload_0 
L57:    getfield [27] 
L60:    i2b 
L61:    invokeinterface [46] 0 
L66:    aload_1 
L67:    aload_0 
L68:    getfield [28] 
L71:    i2b 
L72:    invokeinterface [46] 0 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [250] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_4 
L3:     invokeinterface [47] 0 
L8:     putfield [37] 
L11:    aload_0 
L12:    aload_1 
L13:    iconst_4 
L14:    invokeinterface [47] 0 
L19:    putfield [38] 
L22:    aload_0 
L23:    aload_1 
L24:    invokeinterface [48] 0 
L29:    putfield [39] 
L32:    aload_0 
L33:    aload_1 
L34:    invokeinterface [48] 0 
L39:    putfield [40] 
L42:    aload_0 
L43:    aload_1 
L44:    invokeinterface [48] 0 
L49:    putfield [41] 
L52:    aload_0 
L53:    aload_1 
L54:    invokeinterface [48] 0 
L59:    putfield [42] 
L62:    aload_0 
L63:    aload_1 
L64:    invokeinterface [48] 0 
L69:    putfield [43] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [49] 
.const [3] = Class [50] 
.const [4] = String [51] 
.const [5] = String [52] 
.const [6] = String [53] 
.const [7] = String [54] 
.const [8] = String [55] 
.const [9] = String [56] 
.const [10] = String [57] 
.const [11] = String [58] 
.const [12] = String [59] 
.const [13] = String [60] 
.const [14] = String [61] 
.const [15] = String [62] 
.const [16] = String [63] 
.const [17] = String [64] 
.const [18] = String [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Method [68] [69] 
.const [22] = Field [70] [71] 
.const [23] = Field [72] [73] 
.const [24] = Field [74] [75] 
.const [25] = Field [76] [77] 
.const [26] = Field [78] [79] 
.const [27] = Field [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Field [100] [101] 
.const [38] = Field [102] [103] 
.const [39] = Field [104] [105] 
.const [40] = Field [106] [107] 
.const [41] = Field [108] [109] 
.const [42] = Field [110] [111] 
.const [43] = Field [112] [113] 
.const [44] = Class [114] 
.const [45] = InterfaceMethod [115] [116] 
.const [46] = InterfaceMethod [117] [118] 
.const [47] = InterfaceMethod [119] [120] 
.const [48] = InterfaceMethod [121] [122] 
.const [49] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Utf8 'TimeInfo:' 
.const [52] = Utf8 '\n - TimeInfoType: ' 
.const [53] = Utf8 '0x0 (TimeToDestination)' 
.const [54] = Utf8 '0x1 (ArrivalTime)' 
.const [55] = Utf8 '0x2 (ArrivalTime is local time in another time zone (DF4.1))' 
.const [56] = Utf8 '0xF (not supported (= any time info type))' 
.const [57] = Utf8 'UNKNOWN ENUM' 
.const [58] = Utf8 '\n - NavigationTimeFormat: ' 
.const [59] = Utf8 '0x0 (24 hour format)' 
.const [60] = Utf8 '0x1 (12 hour format)' 
.const [61] = Utf8 '\n - Minute - ' 
.const [62] = Utf8 '\n - Hour - ' 
.const [63] = Utf8 '\n - Day - ' 
.const [64] = Utf8 '\n - Month - ' 
.const [65] = Utf8 '\n - Year - ' 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Class [165] 
.const [97] = NameAndType [166] [167] 
.const [98] = Class [168] 
.const [99] = NameAndType [169] [170] 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Class [177] 
.const [105] = NameAndType [178] [179] 
.const [106] = Class [180] 
.const [107] = NameAndType [181] [182] 
.const [108] = Class [183] 
.const [109] = NameAndType [184] [185] 
.const [110] = Class [186] 
.const [111] = NameAndType [187] [188] 
.const [112] = Class [189] 
.const [113] = NameAndType [190] [191] 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Class [192] 
.const [116] = NameAndType [193] [194] 
.const [117] = Class [195] 
.const [118] = NameAndType [196] [197] 
.const [119] = Class [198] 
.const [120] = NameAndType [199] [200] 
.const [121] = Class [201] 
.const [122] = NameAndType [202] [203] 
.const [123] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [124] = Utf8 deserialize 
.const [125] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [126] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [127] = Utf8 timeInfoType 
.const [128] = Utf8 I 
.const [129] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [130] = Utf8 navigationTimeFormat 
.const [131] = Utf8 I 
.const [132] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [133] = Utf8 minute 
.const [134] = Utf8 I 
.const [135] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [136] = Utf8 hour 
.const [137] = Utf8 I 
.const [138] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [139] = Utf8 day 
.const [140] = Utf8 I 
.const [141] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [142] = Utf8 month 
.const [143] = Utf8 I 
.const [144] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [145] = Utf8 year 
.const [146] = Utf8 I 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 append 
.const [149] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [150] = Utf8 java/lang/StringBuffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [153] = Utf8 java/lang/StringBuffer 
.const [154] = Utf8 toString 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 java/lang/Object 
.const [157] = Utf8 <init> 
.const [158] = Utf8 ()V 
.const [159] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [160] = Utf8 internalReset 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [163] = Utf8 customInitialization 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [172] = Utf8 timeInfoType 
.const [173] = Utf8 I 
.const [174] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [175] = Utf8 navigationTimeFormat 
.const [176] = Utf8 I 
.const [177] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [178] = Utf8 minute 
.const [179] = Utf8 I 
.const [180] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [181] = Utf8 hour 
.const [182] = Utf8 I 
.const [183] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [184] = Utf8 day 
.const [185] = Utf8 I 
.const [186] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [187] = Utf8 month 
.const [188] = Utf8 I 
.const [189] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [190] = Utf8 year 
.const [191] = Utf8 I 
.const [192] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [193] = Utf8 pushBits 
.const [194] = Utf8 (II)V 
.const [195] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [196] = Utf8 pushByte 
.const [197] = Utf8 (B)V 
.const [198] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [199] = Utf8 popFrontBits 
.const [200] = Utf8 (I)I 
.const [201] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [202] = Utf8 popFrontByte 
.const [203] = Utf8 ()I 
.const [204] = Utf8 de/vw/mib/bap/generated/navsd/serializer/TimeToDestination_Status$TimeInfo 
.const [205] = Class [204] 
.const [206] = Utf8 java/lang/Object 
.const [207] = Class [206] 
.const [208] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [209] = Class [208] 
.const [210] = Utf8 timeInfoType 
.const [211] = Utf8 I 
.const [212] = Utf8 TIME_INFO_TYPE_BITSIZE 
.const [213] = Utf8 I 
.const [214] = Utf8 TIME_INFO_TYPE_TIME_TO_DESTINATION 
.const [215] = Utf8 I 
.const [216] = Utf8 TIME_INFO_TYPE_ARRIVAL_TIME 
.const [217] = Utf8 I 
.const [218] = Utf8 TIME_INFO_TYPE_ARRIVAL_TIME_IS_LOCAL_TIME_IN_ANOTHER_TIME_ZONE_DF4_1 
.const [219] = Utf8 I 
.const [220] = Utf8 TIME_INFO_TYPE_NOT_SUPPORTED_ANY_TIME_INFO_TYPE 
.const [221] = Utf8 I 
.const [222] = Utf8 navigationTimeFormat 
.const [223] = Utf8 I 
.const [224] = Utf8 NAVIGATION_TIME_FORMAT_BITSIZE 
.const [225] = Utf8 I 
.const [226] = Utf8 NAVIGATION_TIME_FORMAT_24_HOUR_FORMAT 
.const [227] = Utf8 I 
.const [228] = Utf8 NAVIGATION_TIME_FORMAT_12_HOUR_FORMAT 
.const [229] = Utf8 I 
.const [230] = Utf8 minute 
.const [231] = Utf8 I 
.const [232] = Utf8 MINUTE_BITSIZE 
.const [233] = Utf8 I 
.const [234] = Utf8 hour 
.const [235] = Utf8 I 
.const [236] = Utf8 HOUR_BITSIZE 
.const [237] = Utf8 I 
.const [238] = Utf8 day 
.const [239] = Utf8 I 
.const [240] = Utf8 DAY_BITSIZE 
.const [241] = Utf8 I 
.const [242] = Utf8 month 
.const [243] = Utf8 I 
.const [244] = Utf8 MONTH_BITSIZE 
.const [245] = Utf8 I 
.const [246] = Utf8 year 
.const [247] = Utf8 I 
.const [248] = Utf8 YEAR_BITSIZE 
.const [249] = Utf8 I 
.const [250] = Utf8 Code 
.const [251] = Utf8 <init> 
.const [252] = Utf8 ()V 
.const [253] = Utf8 <init> 
.const [254] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [255] = Utf8 internalReset 
.const [256] = Utf8 ()V 
.const [257] = Utf8 reset 
.const [258] = Utf8 ()V 
.const [259] = Utf8 equalTo 
.const [260] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [261] = Utf8 customInitialization 
.const [262] = Utf8 ()V 
.const [263] = Utf8 toString 
.const [264] = Utf8 ()Ljava/lang/String; 
.const [265] = Utf8 bitSize 
.const [266] = Utf8 ()I 
.const [267] = Utf8 serialize 
.const [268] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [269] = Utf8 deserialize 
.const [270] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
