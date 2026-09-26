.version 50 0 
.class public final super [137] 
.super [139] 
.implements [141] 
.field public [142] [143] 
.field private static final [144] [145] 
.field public [146] [147] 
.field private static final [148] [149] 
.field public static final [150] [151] 
.field public static final [152] [153] 
.field public static final [154] [155] 
.field public static final [156] [157] 
.field public static final [158] [159] 
.field public static final [160] [161] 
.field public static final [162] [163] 

.method public [165] : [166] 
    .attribute [164] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     invokespecial [24] 
L8:     aload_0 
L9:     invokespecial [25] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [164] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [169] : [170] 
    .attribute [164] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [28] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [29] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [164] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [164] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_2 
L10:    getfield [18] 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    getfield [19] 
L20:    aload_2 
L21:    getfield [19] 
L24:    if_icmpne L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private enum [175] : [176] 
    .attribute [164] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [164] .code stack 2 locals 1 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [27] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [20] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [18] 
L27:    invokevirtual [21] 
L30:    pop 
L31:    aload_1 
L32:    ldc [6] 
L34:    invokevirtual [20] 
L37:    pop 
L38:    aload_0 
L39:    getfield [19] 
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
L111:   invokevirtual [20] 
L114:   pop 
L115:   goto L185 
L118:   aload_1 
L119:   ldc [8] 
L121:   invokevirtual [20] 
L124:   pop 
L125:   goto L185 
L128:   aload_1 
L129:   ldc [9] 
L131:   invokevirtual [20] 
L134:   pop 
L135:   goto L185 
L138:   aload_1 
L139:   ldc [10] 
L141:   invokevirtual [20] 
L144:   pop 
L145:   goto L185 
L148:   aload_1 
L149:   ldc [11] 
L151:   invokevirtual [20] 
L154:   pop 
L155:   goto L185 
L158:   aload_1 
L159:   ldc [12] 
L161:   invokevirtual [20] 
L164:   pop 
L165:   goto L185 
L168:   aload_1 
L169:   ldc [13] 
L171:   invokevirtual [20] 
L174:   pop 
L175:   goto L185 
L178:   aload_1 
L179:   ldc [14] 
L181:   invokevirtual [20] 
L184:   pop 
L185:   aload_1 
L186:   invokevirtual [22] 
L189:   areturn 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [164] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 32 
L5:     iinc 1 8 
L8:     iload_1 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [164] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [18] 
L5:     invokeinterface [31] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [19] 
L15:    i2b 
L16:    invokeinterface [32] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [164] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [33] 0 
L7:     putfield [28] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [34] 0 
L17:    putfield [29] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = String [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = String [41] 
.const [9] = String [42] 
.const [10] = String [43] 
.const [11] = String [44] 
.const [12] = String [45] 
.const [13] = String [46] 
.const [14] = String [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Method [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Field [74] [75] 
.const [30] = Class [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = InterfaceMethod [83] [84] 
.const [35] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [36] = Utf8 java/lang/StringBuffer 
.const [37] = Utf8 'DistanceToNextManeuver:' 
.const [38] = Utf8 '\n - Distance - ' 
.const [39] = Utf8 '\n - Unit: ' 
.const [40] = Utf8 '0x00 (meter)' 
.const [41] = Utf8 '0x01 (kilometer)' 
.const [42] = Utf8 '0x02 (yard)' 
.const [43] = Utf8 '0x03 (feet)' 
.const [44] = Utf8 '0x04 (mile (UK and US (statute mile)))' 
.const [45] = Utf8 '0x05 (quarter mile(s) (n* 1/4mile))' 
.const [46] = Utf8 '0xFF (not supported)' 
.const [47] = Utf8 'UNKNOWN ENUM' 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Class [106] 
.const [65] = NameAndType [107] [108] 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Class [118] 
.const [73] = NameAndType [119] [120] 
.const [74] = Class [121] 
.const [75] = NameAndType [122] [123] 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Class [124] 
.const [78] = NameAndType [125] [126] 
.const [79] = Class [127] 
.const [80] = NameAndType [128] [129] 
.const [81] = Class [130] 
.const [82] = NameAndType [131] [132] 
.const [83] = Class [133] 
.const [84] = NameAndType [134] [135] 
.const [85] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [86] = Utf8 deserialize 
.const [87] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [88] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [89] = Utf8 distance 
.const [90] = Utf8 I 
.const [91] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [92] = Utf8 unit 
.const [93] = Utf8 I 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Utf8 append 
.const [96] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 toString 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [107] = Utf8 internalReset 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [110] = Utf8 customInitialization 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 <init> 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [119] = Utf8 distance 
.const [120] = Utf8 I 
.const [121] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [122] = Utf8 unit 
.const [123] = Utf8 I 
.const [124] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [125] = Utf8 pushInt 
.const [126] = Utf8 (I)V 
.const [127] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [128] = Utf8 pushByte 
.const [129] = Utf8 (B)V 
.const [130] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [131] = Utf8 popFrontInt 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [134] = Utf8 popFrontByte 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$DistanceToNextManeuver 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [141] = Class [140] 
.const [142] = Utf8 distance 
.const [143] = Utf8 I 
.const [144] = Utf8 DISTANCE_BITSIZE 
.const [145] = Utf8 I 
.const [146] = Utf8 unit 
.const [147] = Utf8 I 
.const [148] = Utf8 UNIT_BITSIZE 
.const [149] = Utf8 I 
.const [150] = Utf8 UNIT_METER 
.const [151] = Utf8 I 
.const [152] = Utf8 UNIT_KILOMETER 
.const [153] = Utf8 I 
.const [154] = Utf8 UNIT_YARD 
.const [155] = Utf8 I 
.const [156] = Utf8 UNIT_FEET 
.const [157] = Utf8 I 
.const [158] = Utf8 UNIT_MILE_UK_AND_US_STATUTE_MILE 
.const [159] = Utf8 I 
.const [160] = Utf8 UNIT_QUARTER_MILES_N_1_4MILE 
.const [161] = Utf8 I 
.const [162] = Utf8 UNIT_NOT_SUPPORTED 
.const [163] = Utf8 I 
.const [164] = Utf8 Code 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 <init> 
.const [168] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [169] = Utf8 internalReset 
.const [170] = Utf8 ()V 
.const [171] = Utf8 reset 
.const [172] = Utf8 ()V 
.const [173] = Utf8 equalTo 
.const [174] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [175] = Utf8 customInitialization 
.const [176] = Utf8 ()V 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 bitSize 
.const [180] = Utf8 ()I 
.const [181] = Utf8 serialize 
.const [182] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [183] = Utf8 deserialize 
.const [184] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
