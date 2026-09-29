.version 50 0 
.class public final super [269] 
.super [271] 
.implements [273] 
.field public [274] [275] 
.field private static final [276] [277] 
.field public static final [278] [279] 
.field public static final [280] [281] 
.field public static final [282] [283] 
.field public static final [284] [285] 
.field public static final [286] [287] 
.field public static final [288] [289] 
.field public [290] [291] 
.field private static final [292] [293] 
.field public final [294] [295] 
.field private static final [296] [297] 
.field public final [298] [299] 
.field public [300] [301] 
.field private static final [302] [303] 
.field public static final [304] [305] 
.field public static final [306] [307] 
.field public static final [308] [309] 

.method public [311] : [312] 
    .attribute [310] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [46] 
L4:     aload_0 
L5:     new [53] 
L8:     dup 
L9:     iconst_4 
L10:    invokespecial [47] 
L13:    putfield [54] 
L16:    aload_0 
L17:    new [55] 
L20:    dup 
L21:    invokespecial [48] 
L24:    putfield [56] 
L27:    aload_0 
L28:    invokespecial [49] 
L31:    aload_0 
L32:    invokespecial [50] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [313] : [314] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [51] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [315] : [316] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [57] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [58] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [59] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [317] : [318] 
    .attribute [310] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_0 
L5:     getfield [25] 
L8:     invokevirtual [31] 
L11:    aload_0 
L12:    getfield [26] 
L15:    invokevirtual [32] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [319] : [320] 
    .attribute [310] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [4] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [28] 
L9:     aload_2 
L10:    getfield [28] 
L13:    if_icmpne L70 
L16:    aload_0 
L17:    getfield [29] 
L20:    aload_2 
L21:    getfield [29] 
L24:    if_icmpne L70 
L27:    aload_0 
L28:    getfield [25] 
L31:    aload_2 
L32:    getfield [25] 
L35:    invokevirtual [33] 
L38:    ifeq L70 
L41:    aload_0 
L42:    getfield [26] 
L45:    aload_2 
L46:    getfield [26] 
L49:    invokevirtual [34] 
L52:    ifeq L70 
L55:    aload_0 
L56:    getfield [30] 
L59:    aload_2 
L60:    getfield [30] 
L63:    if_icmpne L70 
L66:    iconst_1 
L67:    goto L71 
L70:    iconst_0 
L71:    areturn 
L72:    
    .end code 
.end method 

.method private enum [321] : [322] 
    .attribute [310] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [323] : [324] 
    .attribute [310] .code stack 2 locals 1 
L0:     new [60] 
L3:     dup 
L4:     invokespecial [52] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [6] 
L11:    invokevirtual [35] 
L14:    pop 
L15:    aload_1 
L16:    ldc [7] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    aload_0 
L23:    getfield [28] 
L26:    tableswitch 0 
            L64 
            L74 
            L84 
            L94 
            L104 
            L114 
            default : L124 

L64:    aload_1 
L65:    ldc [8] 
L67:    invokevirtual [35] 
L70:    pop 
L71:    goto L131 
L74:    aload_1 
L75:    ldc [9] 
L77:    invokevirtual [35] 
L80:    pop 
L81:    goto L131 
L84:    aload_1 
L85:    ldc [10] 
L87:    invokevirtual [35] 
L90:    pop 
L91:    goto L131 
L94:    aload_1 
L95:    ldc [11] 
L97:    invokevirtual [35] 
L100:   pop 
L101:   goto L131 
L104:   aload_1 
L105:   ldc [12] 
L107:   invokevirtual [35] 
L110:   pop 
L111:   goto L131 
L114:   aload_1 
L115:   ldc [13] 
L117:   invokevirtual [35] 
L120:   pop 
L121:   goto L131 
L124:   aload_1 
L125:   ldc [14] 
L127:   invokevirtual [35] 
L130:   pop 
L131:   aload_1 
L132:   ldc [15] 
L134:   invokevirtual [35] 
L137:   pop 
L138:   aload_1 
L139:   aload_0 
L140:   getfield [29] 
L143:   invokevirtual [36] 
L146:   pop 
L147:   aload_1 
L148:   ldc [16] 
L150:   invokevirtual [35] 
L153:   pop 
L154:   aload_1 
L155:   aload_0 
L156:   getfield [25] 
L159:   invokevirtual [37] 
L162:   invokevirtual [35] 
L165:   pop 
L166:   aload_1 
L167:   ldc [17] 
L169:   invokevirtual [35] 
L172:   pop 
L173:   aload_1 
L174:   aload_0 
L175:   getfield [26] 
L178:   invokevirtual [38] 
L181:   invokevirtual [35] 
L184:   pop 
L185:   aload_1 
L186:   ldc [18] 
L188:   invokevirtual [35] 
L191:   pop 
L192:   aload_0 
L193:   getfield [30] 
L196:   tableswitch 0 
            L224 
            L234 
            L244 
            default : L254 

L224:   aload_1 
L225:   ldc [19] 
L227:   invokevirtual [35] 
L230:   pop 
L231:   goto L261 
L234:   aload_1 
L235:   ldc [20] 
L237:   invokevirtual [35] 
L240:   pop 
L241:   goto L261 
L244:   aload_1 
L245:   ldc [21] 
L247:   invokevirtual [35] 
L250:   pop 
L251:   goto L261 
L254:   aload_1 
L255:   ldc [14] 
L257:   invokevirtual [35] 
L260:   pop 
L261:   aload_1 
L262:   invokevirtual [39] 
L265:   areturn 
L266:   nop 
L267:   nop 
L268:   
    .end code 
.end method 

.method public [325] : [326] 
    .attribute [310] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [25] 
L13:    invokevirtual [40] 
L16:    iadd 
L17:    istore_1 
L18:    iload_1 
L19:    aload_0 
L20:    getfield [26] 
L23:    invokevirtual [41] 
L26:    iadd 
L27:    istore_1 
L28:    iinc 1 8 
L31:    iload_1 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     i2b 
L6:     invokeinterface [61] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [29] 
L16:    i2b 
L17:    invokeinterface [61] 0 
L22:    aload_0 
L23:    getfield [25] 
L26:    aload_1 
L27:    invokevirtual [42] 
L30:    aload_0 
L31:    getfield [26] 
L34:    aload_1 
L35:    invokevirtual [43] 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [30] 
L43:    i2b 
L44:    invokeinterface [61] 0 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [62] 0 
L7:     putfield [57] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [62] 0 
L17:    putfield [58] 
L20:    aload_0 
L21:    getfield [25] 
L24:    aload_1 
L25:    invokevirtual [44] 
L28:    aload_0 
L29:    getfield [26] 
L32:    aload_1 
L33:    invokevirtual [45] 
L36:    aload_0 
L37:    aload_1 
L38:    invokeinterface [62] 0 
L43:    putfield [59] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public static [331] : [332] 
    .attribute [310] .code stack 1 locals 0 
L0:     bipush 16 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [310] .code stack 1 locals 0 
L0:     invokestatic [22] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [63] 
.const [3] = Class [64] 
.const [4] = Class [65] 
.const [5] = Class [66] 
.const [6] = String [67] 
.const [7] = String [68] 
.const [8] = String [69] 
.const [9] = String [70] 
.const [10] = String [71] 
.const [11] = String [72] 
.const [12] = String [73] 
.const [13] = String [74] 
.const [14] = String [75] 
.const [15] = String [76] 
.const [16] = String [77] 
.const [17] = String [78] 
.const [18] = String [79] 
.const [19] = String [80] 
.const [20] = String [81] 
.const [21] = String [82] 
.const [22] = Method [83] [84] 
.const [23] = Class [85] 
.const [24] = Class [86] 
.const [25] = Field [87] [88] 
.const [26] = Field [89] [90] 
.const [27] = Method [91] [92] 
.const [28] = Field [93] [94] 
.const [29] = Field [95] [96] 
.const [30] = Field [97] [98] 
.const [31] = Method [99] [100] 
.const [32] = Method [101] [102] 
.const [33] = Method [103] [104] 
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
.const [48] = Method [133] [134] 
.const [49] = Method [135] [136] 
.const [50] = Method [137] [138] 
.const [51] = Method [139] [140] 
.const [52] = Method [141] [142] 
.const [53] = Class [143] 
.const [54] = Field [144] [145] 
.const [55] = Class [146] 
.const [56] = Field [147] [148] 
.const [57] = Field [149] [150] 
.const [58] = Field [151] [152] 
.const [59] = Field [153] [154] 
.const [60] = Class [155] 
.const [61] = InterfaceMethod [156] [157] 
.const [62] = InterfaceMethod [158] [159] 
.const [63] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [64] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [65] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 'TrafficLightOnline_Info_Status:' 
.const [68] = Utf8 '\n - TrafficLight: ' 
.const [69] = Utf8 '0x00 (no traffic light)' 
.const [70] = Utf8 '0x01 (green traffic light)' 
.const [71] = Utf8 '0x02 (yellow traffic light)' 
.const [72] = Utf8 '0x03 (red traffic light)' 
.const [73] = Utf8 '0x04 (grey traffic light)' 
.const [74] = Utf8 '0x05 (synchronised traffic lights)' 
.const [75] = Utf8 'UNKNOWN ENUM' 
.const [76] = Utf8 '\n - MainDirection - ' 
.const [77] = Utf8 '\n - Sidestreets - ' 
.const [78] = Utf8 '\n - TrafficLightWarnings - ' 
.const [79] = Utf8 '\n - TrafficLightLayout: ' 
.const [80] = Utf8 '0x00 (vertical layout, red top)' 
.const [81] = Utf8 '0x01 (horizontal layout, red left)' 
.const [82] = Utf8 '0x02 (horizontal layout, red right)' 
.const [83] = Class [160] 
.const [84] = NameAndType [161] [162] 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [87] = Class [163] 
.const [88] = NameAndType [164] [165] 
.const [89] = Class [166] 
.const [90] = NameAndType [167] [168] 
.const [91] = Class [169] 
.const [92] = NameAndType [170] [171] 
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
.const [141] = Class [244] 
.const [142] = NameAndType [245] [246] 
.const [143] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [144] = Class [247] 
.const [145] = NameAndType [248] [249] 
.const [146] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [147] = Class [250] 
.const [148] = NameAndType [251] [252] 
.const [149] = Class [253] 
.const [150] = NameAndType [254] [255] 
.const [151] = Class [256] 
.const [152] = NameAndType [257] [258] 
.const [153] = Class [259] 
.const [154] = NameAndType [260] [261] 
.const [155] = Utf8 java/lang/StringBuffer 
.const [156] = Class [262] 
.const [157] = NameAndType [263] [264] 
.const [158] = Class [265] 
.const [159] = NameAndType [266] [267] 
.const [160] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [161] = Utf8 functionId 
.const [162] = Utf8 ()I 
.const [163] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [164] = Utf8 sidestreets 
.const [165] = Utf8 Lde/vw/mib/bap/datatypes/BAPString; 
.const [166] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [167] = Utf8 trafficLightWarnings 
.const [168] = Utf8 Lde/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings; 
.const [169] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [170] = Utf8 deserialize 
.const [171] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [172] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [173] = Utf8 trafficLight 
.const [174] = Utf8 I 
.const [175] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [176] = Utf8 mainDirection 
.const [177] = Utf8 I 
.const [178] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [179] = Utf8 trafficLightLayout 
.const [180] = Utf8 I 
.const [181] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [182] = Utf8 reset 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [185] = Utf8 reset 
.const [186] = Utf8 ()V 
.const [187] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [188] = Utf8 equalTo 
.const [189] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [190] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [191] = Utf8 equalTo 
.const [192] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 append 
.const [195] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [196] = Utf8 java/lang/StringBuffer 
.const [197] = Utf8 append 
.const [198] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [199] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [200] = Utf8 toString 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [203] = Utf8 toString 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 java/lang/StringBuffer 
.const [206] = Utf8 toString 
.const [207] = Utf8 ()Ljava/lang/String; 
.const [208] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [209] = Utf8 bitSize 
.const [210] = Utf8 ()I 
.const [211] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [212] = Utf8 bitSize 
.const [213] = Utf8 ()I 
.const [214] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [215] = Utf8 serialize 
.const [216] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [217] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [218] = Utf8 serialize 
.const [219] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [220] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [221] = Utf8 deserialize 
.const [222] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [223] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [224] = Utf8 deserialize 
.const [225] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [226] = Utf8 java/lang/Object 
.const [227] = Utf8 <init> 
.const [228] = Utf8 ()V 
.const [229] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [230] = Utf8 <init> 
.const [231] = Utf8 (I)V 
.const [232] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings 
.const [233] = Utf8 <init> 
.const [234] = Utf8 ()V 
.const [235] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [236] = Utf8 internalReset 
.const [237] = Utf8 ()V 
.const [238] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [239] = Utf8 customInitialization 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 java/lang/StringBuffer 
.const [245] = Utf8 <init> 
.const [246] = Utf8 ()V 
.const [247] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [248] = Utf8 sidestreets 
.const [249] = Utf8 Lde/vw/mib/bap/datatypes/BAPString; 
.const [250] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [251] = Utf8 trafficLightWarnings 
.const [252] = Utf8 Lde/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings; 
.const [253] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [254] = Utf8 trafficLight 
.const [255] = Utf8 I 
.const [256] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [257] = Utf8 mainDirection 
.const [258] = Utf8 I 
.const [259] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [260] = Utf8 trafficLightLayout 
.const [261] = Utf8 I 
.const [262] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [263] = Utf8 pushByte 
.const [264] = Utf8 (B)V 
.const [265] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [266] = Utf8 popFrontByte 
.const [267] = Utf8 ()I 
.const [268] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status 
.const [269] = Class [268] 
.const [270] = Utf8 java/lang/Object 
.const [271] = Class [270] 
.const [272] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [273] = Class [272] 
.const [274] = Utf8 trafficLight 
.const [275] = Utf8 I 
.const [276] = Utf8 TRAFFIC_LIGHT_BITSIZE 
.const [277] = Utf8 I 
.const [278] = Utf8 TRAFFIC_LIGHT_NO_TRAFFIC_LIGHT 
.const [279] = Utf8 I 
.const [280] = Utf8 TRAFFIC_LIGHT_GREEN_TRAFFIC_LIGHT 
.const [281] = Utf8 I 
.const [282] = Utf8 TRAFFIC_LIGHT_YELLOW_TRAFFIC_LIGHT 
.const [283] = Utf8 I 
.const [284] = Utf8 TRAFFIC_LIGHT_RED_TRAFFIC_LIGHT 
.const [285] = Utf8 I 
.const [286] = Utf8 TRAFFIC_LIGHT_GREY_TRAFFIC_LIGHT 
.const [287] = Utf8 I 
.const [288] = Utf8 TRAFFIC_LIGHT_SYNCHRONISED_TRAFFIC_LIGHTS 
.const [289] = Utf8 I 
.const [290] = Utf8 mainDirection 
.const [291] = Utf8 I 
.const [292] = Utf8 MAIN_DIRECTION_BITSIZE 
.const [293] = Utf8 I 
.const [294] = Utf8 sidestreets 
.const [295] = Utf8 Lde/vw/mib/bap/datatypes/BAPString; 
.const [296] = Utf8 MAX_SIDESTREETS_LENGTH 
.const [297] = Utf8 I 
.const [298] = Utf8 trafficLightWarnings 
.const [299] = Utf8 Lde/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Info_Status$TrafficLightWarnings; 
.const [300] = Utf8 trafficLightLayout 
.const [301] = Utf8 I 
.const [302] = Utf8 TRAFFIC_LIGHT_LAYOUT_BITSIZE 
.const [303] = Utf8 I 
.const [304] = Utf8 TRAFFIC_LIGHT_LAYOUT_VERTICAL_LAYOUT_RED_TOP 
.const [305] = Utf8 I 
.const [306] = Utf8 TRAFFIC_LIGHT_LAYOUT_HORIZONTAL_LAYOUT_RED_LEFT 
.const [307] = Utf8 I 
.const [308] = Utf8 TRAFFIC_LIGHT_LAYOUT_HORIZONTAL_LAYOUT_RED_RIGHT 
.const [309] = Utf8 I 
.const [310] = Utf8 Code 
.const [311] = Utf8 <init> 
.const [312] = Utf8 ()V 
.const [313] = Utf8 <init> 
.const [314] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [315] = Utf8 internalReset 
.const [316] = Utf8 ()V 
.const [317] = Utf8 reset 
.const [318] = Utf8 ()V 
.const [319] = Utf8 equalTo 
.const [320] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [321] = Utf8 customInitialization 
.const [322] = Utf8 ()V 
.const [323] = Utf8 toString 
.const [324] = Utf8 ()Ljava/lang/String; 
.const [325] = Utf8 bitSize 
.const [326] = Utf8 ()I 
.const [327] = Utf8 serialize 
.const [328] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [329] = Utf8 deserialize 
.const [330] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [331] = Utf8 functionId 
.const [332] = Utf8 ()I 
.const [333] = Utf8 getFunctionId 
.const [334] = Utf8 ()I 
.end class 
