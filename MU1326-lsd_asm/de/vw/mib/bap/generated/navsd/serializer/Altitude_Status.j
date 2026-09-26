.version 50 0 
.class public final super [133] 
.super [135] 
.implements [137] 
.field public [138] [139] 
.field private static final [140] [141] 
.field public [142] [143] 
.field private static final [144] [145] 
.field public static final [146] [147] 
.field public static final [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     invokespecial [20] 
L8:     aload_0 
L9:     invokespecial [21] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [155] : [156] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [24] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [25] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [150] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [14] 
L9:     aload_2 
L10:    getfield [14] 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    getfield [15] 
L20:    aload_2 
L21:    getfield [15] 
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

.method private enum [161] : [162] 
    .attribute [150] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [150] .code stack 2 locals 1 
L0:     new [26] 
L3:     dup 
L4:     invokespecial [23] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [16] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [16] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [14] 
L27:    invokevirtual [17] 
L30:    pop 
L31:    aload_1 
L32:    ldc [6] 
L34:    invokevirtual [16] 
L37:    pop 
L38:    aload_0 
L39:    getfield [15] 
L42:    lookupswitch 
            0 : L68 
            1 : L78 
            default : L88 

L68:    aload_1 
L69:    ldc [7] 
L71:    invokevirtual [16] 
L74:    pop 
L75:    goto L95 
L78:    aload_1 
L79:    ldc [8] 
L81:    invokevirtual [16] 
L84:    pop 
L85:    goto L95 
L88:    aload_1 
L89:    ldc [9] 
L91:    invokevirtual [16] 
L94:    pop 
L95:    aload_1 
L96:    invokevirtual [18] 
L99:    areturn 
L100:   
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [150] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 16 
L5:     iinc 1 8 
L8:     iload_1 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [14] 
L5:     i2s 
L6:     invokeinterface [27] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [15] 
L16:    i2b 
L17:    invokeinterface [28] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [29] 0 
L7:     i2s 
L8:     putfield [24] 
L11:    aload_0 
L12:    aload_1 
L13:    invokeinterface [30] 0 
L18:    putfield [25] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [171] : [172] 
    .attribute [150] .code stack 1 locals 0 
L0:     bipush 47 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [150] .code stack 1 locals 0 
L0:     invokestatic [10] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Class [32] 
.const [4] = String [33] 
.const [5] = String [34] 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = String [37] 
.const [9] = String [38] 
.const [10] = Method [39] [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Method [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Field [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Field [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Class [69] 
.const [27] = InterfaceMethod [70] [71] 
.const [28] = InterfaceMethod [72] [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [32] = Utf8 java/lang/StringBuffer 
.const [33] = Utf8 'Altitude_Status:' 
.const [34] = Utf8 '\n - Altitude - ' 
.const [35] = Utf8 '\n - Unit: ' 
.const [36] = Utf8 '0x00 (meter)' 
.const [37] = Utf8 '0x01 (feet)' 
.const [38] = Utf8 'UNKNOWN ENUM' 
.const [39] = Class [78] 
.const [40] = NameAndType [79] [80] 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Class [117] 
.const [68] = NameAndType [118] [119] 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Class [120] 
.const [71] = NameAndType [121] [122] 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Class [126] 
.const [75] = NameAndType [127] [128] 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [79] = Utf8 functionId 
.const [80] = Utf8 ()I 
.const [81] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [82] = Utf8 deserialize 
.const [83] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [84] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [85] = Utf8 altitude 
.const [86] = Utf8 I 
.const [87] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [88] = Utf8 unit 
.const [89] = Utf8 I 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Utf8 append 
.const [92] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 toString 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [103] = Utf8 internalReset 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [106] = Utf8 customInitialization 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [115] = Utf8 altitude 
.const [116] = Utf8 I 
.const [117] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [118] = Utf8 unit 
.const [119] = Utf8 I 
.const [120] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [121] = Utf8 pushShort 
.const [122] = Utf8 (S)V 
.const [123] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [124] = Utf8 pushByte 
.const [125] = Utf8 (B)V 
.const [126] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [127] = Utf8 popFrontShort 
.const [128] = Utf8 ()I 
.const [129] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [130] = Utf8 popFrontByte 
.const [131] = Utf8 ()I 
.const [132] = Utf8 de/vw/mib/bap/generated/navsd/serializer/Altitude_Status 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Object 
.const [135] = Class [134] 
.const [136] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [137] = Class [136] 
.const [138] = Utf8 altitude 
.const [139] = Utf8 I 
.const [140] = Utf8 ALTITUDE_BITSIZE 
.const [141] = Utf8 I 
.const [142] = Utf8 unit 
.const [143] = Utf8 I 
.const [144] = Utf8 UNIT_BITSIZE 
.const [145] = Utf8 I 
.const [146] = Utf8 UNIT_METER 
.const [147] = Utf8 I 
.const [148] = Utf8 UNIT_FEET 
.const [149] = Utf8 I 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 ()V 
.const [153] = Utf8 <init> 
.const [154] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [155] = Utf8 internalReset 
.const [156] = Utf8 ()V 
.const [157] = Utf8 reset 
.const [158] = Utf8 ()V 
.const [159] = Utf8 equalTo 
.const [160] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [161] = Utf8 customInitialization 
.const [162] = Utf8 ()V 
.const [163] = Utf8 toString 
.const [164] = Utf8 ()Ljava/lang/String; 
.const [165] = Utf8 bitSize 
.const [166] = Utf8 ()I 
.const [167] = Utf8 serialize 
.const [168] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [169] = Utf8 deserialize 
.const [170] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [171] = Utf8 functionId 
.const [172] = Utf8 ()I 
.const [173] = Utf8 getFunctionId 
.const [174] = Utf8 ()I 
.end class 
