.version 50 0 
.class public final super [157] 
.super [159] 
.implements [161] 
.field public [162] [163] 
.field private static final [164] [165] 
.field public [166] [167] 
.field private static final [168] [169] 
.field public static final [170] [171] 
.field public static final [172] [173] 
.field public static final [174] [175] 
.field public static final [176] [177] 
.field public static final [178] [179] 
.field public static final [180] [181] 
.field public static final [182] [183] 
.field public [184] [185] 
.field private static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 
.field public static final [192] [193] 

.method public [195] : [196] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     invokespecial [29] 
L8:     aload_0 
L9:     invokespecial [30] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [199] : [200] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [33] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [34] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [35] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [194] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [22] 
L9:     aload_2 
L10:    getfield [22] 
L13:    if_icmpne L42 
L16:    aload_0 
L17:    getfield [23] 
L20:    aload_2 
L21:    getfield [23] 
L24:    if_icmpne L42 
L27:    aload_0 
L28:    getfield [24] 
L31:    aload_2 
L32:    getfield [24] 
L35:    if_icmpne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private enum [205] : [206] 
    .attribute [194] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [194] .code stack 2 locals 1 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [32] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [25] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [25] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [22] 
L27:    invokevirtual [26] 
L30:    pop 
L31:    aload_1 
L32:    ldc [6] 
L34:    invokevirtual [25] 
L37:    pop 
L38:    aload_0 
L39:    getfield [23] 
L42:    lookupswitch 
            0 : L108 
            1 : L118 
            2 : L128 
            3 : L138 
            4 : L148 
            5 : L158 
            255 : L168 
            default : L178 

L108:   aload_1 
L109:   ldc [7] 
L111:   invokevirtual [25] 
L114:   pop 
L115:   goto L185 
L118:   aload_1 
L119:   ldc [8] 
L121:   invokevirtual [25] 
L124:   pop 
L125:   goto L185 
L128:   aload_1 
L129:   ldc [9] 
L131:   invokevirtual [25] 
L134:   pop 
L135:   goto L185 
L138:   aload_1 
L139:   ldc [10] 
L141:   invokevirtual [25] 
L144:   pop 
L145:   goto L185 
L148:   aload_1 
L149:   ldc [11] 
L151:   invokevirtual [25] 
L154:   pop 
L155:   goto L185 
L158:   aload_1 
L159:   ldc [12] 
L161:   invokevirtual [25] 
L164:   pop 
L165:   goto L185 
L168:   aload_1 
L169:   ldc [13] 
L171:   invokevirtual [25] 
L174:   pop 
L175:   goto L185 
L178:   aload_1 
L179:   ldc [14] 
L181:   invokevirtual [25] 
L184:   pop 
L185:   aload_1 
L186:   ldc [15] 
L188:   invokevirtual [25] 
L191:   pop 
L192:   aload_0 
L193:   getfield [24] 
L196:   lookupswitch 
            0 : L232 
            1 : L242 
            255 : L252 
            default : L262 

L232:   aload_1 
L233:   ldc [16] 
L235:   invokevirtual [25] 
L238:   pop 
L239:   goto L269 
L242:   aload_1 
L243:   ldc [17] 
L245:   invokevirtual [25] 
L248:   pop 
L249:   goto L269 
L252:   aload_1 
L253:   ldc [18] 
L255:   invokevirtual [25] 
L258:   pop 
L259:   goto L269 
L262:   aload_1 
L263:   ldc [14] 
L265:   invokevirtual [25] 
L268:   pop 
L269:   aload_1 
L270:   invokevirtual [27] 
L273:   areturn 
L274:   nop 
L275:   nop 
L276:   
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [194] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 32 
L5:     iinc 1 8 
L8:     iinc 1 8 
L11:    iload_1 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [22] 
L5:     invokeinterface [37] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [23] 
L15:    i2b 
L16:    invokeinterface [38] 0 
L21:    aload_1 
L22:    aload_0 
L23:    getfield [24] 
L26:    i2b 
L27:    invokeinterface [38] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [39] 0 
L7:     putfield [33] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [40] 0 
L17:    putfield [34] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [40] 0 
L27:    putfield [35] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [41] 
.const [3] = Class [42] 
.const [4] = String [43] 
.const [5] = String [44] 
.const [6] = String [45] 
.const [7] = String [46] 
.const [8] = String [47] 
.const [9] = String [48] 
.const [10] = String [49] 
.const [11] = String [50] 
.const [12] = String [51] 
.const [13] = String [52] 
.const [14] = String [53] 
.const [15] = String [54] 
.const [16] = String [55] 
.const [17] = String [56] 
.const [18] = String [57] 
.const [19] = Class [58] 
.const [20] = Class [59] 
.const [21] = Method [60] [61] 
.const [22] = Field [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Method [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Method [82] [83] 
.const [33] = Field [84] [85] 
.const [34] = Field [86] [87] 
.const [35] = Field [88] [89] 
.const [36] = Class [90] 
.const [37] = InterfaceMethod [91] [92] 
.const [38] = InterfaceMethod [93] [94] 
.const [39] = InterfaceMethod [95] [96] 
.const [40] = InterfaceMethod [97] [98] 
.const [41] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Utf8 'NewDistanceToDestination:' 
.const [44] = Utf8 '\n - Distance - ' 
.const [45] = Utf8 '\n - Unit: ' 
.const [46] = Utf8 '0x00 (meter)' 
.const [47] = Utf8 '0x01 (kilometer)' 
.const [48] = Utf8 '0x02 (yard)' 
.const [49] = Utf8 '0x03 (feet)' 
.const [50] = Utf8 '0x04 (mile (UK and US (statute mile)))' 
.const [51] = Utf8 '0x05 (quarter mile(s) (n* 1/4mile))' 
.const [52] = Utf8 '0xFF (not supported / no information about unit available)' 
.const [53] = Utf8 'UNKNOWN ENUM' 
.const [54] = Utf8 '\n - TypeOfDistance: ' 
.const [55] = Utf8 '0x00 (road distance)' 
.const [56] = Utf8 '0x01 (linear distance)' 
.const [57] = Utf8 '0xFF (distance invalid)' 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [60] = Class [99] 
.const [61] = NameAndType [100] [101] 
.const [62] = Class [102] 
.const [63] = NameAndType [103] [104] 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Class [108] 
.const [67] = NameAndType [109] [110] 
.const [68] = Class [111] 
.const [69] = NameAndType [112] [113] 
.const [70] = Class [114] 
.const [71] = NameAndType [115] [116] 
.const [72] = Class [117] 
.const [73] = NameAndType [118] [119] 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Class [126] 
.const [79] = NameAndType [127] [128] 
.const [80] = Class [129] 
.const [81] = NameAndType [130] [131] 
.const [82] = Class [132] 
.const [83] = NameAndType [133] [134] 
.const [84] = Class [135] 
.const [85] = NameAndType [136] [137] 
.const [86] = Class [138] 
.const [87] = NameAndType [139] [140] 
.const [88] = Class [141] 
.const [89] = NameAndType [142] [143] 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Class [144] 
.const [92] = NameAndType [145] [146] 
.const [93] = Class [147] 
.const [94] = NameAndType [148] [149] 
.const [95] = Class [150] 
.const [96] = NameAndType [151] [152] 
.const [97] = Class [153] 
.const [98] = NameAndType [154] [155] 
.const [99] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [100] = Utf8 deserialize 
.const [101] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [102] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [103] = Utf8 distance 
.const [104] = Utf8 I 
.const [105] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [106] = Utf8 unit 
.const [107] = Utf8 I 
.const [108] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [109] = Utf8 typeOfDistance 
.const [110] = Utf8 I 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 append 
.const [113] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 toString 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 java/lang/Object 
.const [121] = Utf8 <init> 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [124] = Utf8 internalReset 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [127] = Utf8 customInitialization 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [136] = Utf8 distance 
.const [137] = Utf8 I 
.const [138] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [139] = Utf8 unit 
.const [140] = Utf8 I 
.const [141] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [142] = Utf8 typeOfDistance 
.const [143] = Utf8 I 
.const [144] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [145] = Utf8 pushInt 
.const [146] = Utf8 (I)V 
.const [147] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [148] = Utf8 pushByte 
.const [149] = Utf8 (B)V 
.const [150] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [151] = Utf8 popFrontInt 
.const [152] = Utf8 ()I 
.const [153] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [154] = Utf8 popFrontByte 
.const [155] = Utf8 ()I 
.const [156] = Utf8 de/vw/mib/bap/generated/navsd/serializer/SemidynamicRouteGuidance_Status$NewDistanceToDestination 
.const [157] = Class [156] 
.const [158] = Utf8 java/lang/Object 
.const [159] = Class [158] 
.const [160] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [161] = Class [160] 
.const [162] = Utf8 distance 
.const [163] = Utf8 I 
.const [164] = Utf8 DISTANCE_BITSIZE 
.const [165] = Utf8 I 
.const [166] = Utf8 unit 
.const [167] = Utf8 I 
.const [168] = Utf8 UNIT_BITSIZE 
.const [169] = Utf8 I 
.const [170] = Utf8 UNIT_METER 
.const [171] = Utf8 I 
.const [172] = Utf8 UNIT_KILOMETER 
.const [173] = Utf8 I 
.const [174] = Utf8 UNIT_YARD 
.const [175] = Utf8 I 
.const [176] = Utf8 UNIT_FEET 
.const [177] = Utf8 I 
.const [178] = Utf8 UNIT_MILE_UK_AND_US_STATUTE_MILE 
.const [179] = Utf8 I 
.const [180] = Utf8 UNIT_QUARTER_MILES_N_1_4MILE 
.const [181] = Utf8 I 
.const [182] = Utf8 UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE 
.const [183] = Utf8 I 
.const [184] = Utf8 typeOfDistance 
.const [185] = Utf8 I 
.const [186] = Utf8 TYPE_OF_DISTANCE_BITSIZE 
.const [187] = Utf8 I 
.const [188] = Utf8 TYPE_OF_DISTANCE_ROAD_DISTANCE 
.const [189] = Utf8 I 
.const [190] = Utf8 TYPE_OF_DISTANCE_LINEAR_DISTANCE 
.const [191] = Utf8 I 
.const [192] = Utf8 TYPE_OF_DISTANCE_DISTANCE_INVALID 
.const [193] = Utf8 I 
.const [194] = Utf8 Code 
.const [195] = Utf8 <init> 
.const [196] = Utf8 ()V 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [199] = Utf8 internalReset 
.const [200] = Utf8 ()V 
.const [201] = Utf8 reset 
.const [202] = Utf8 ()V 
.const [203] = Utf8 equalTo 
.const [204] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [205] = Utf8 customInitialization 
.const [206] = Utf8 ()V 
.const [207] = Utf8 toString 
.const [208] = Utf8 ()Ljava/lang/String; 
.const [209] = Utf8 bitSize 
.const [210] = Utf8 ()I 
.const [211] = Utf8 serialize 
.const [212] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [213] = Utf8 deserialize 
.const [214] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
