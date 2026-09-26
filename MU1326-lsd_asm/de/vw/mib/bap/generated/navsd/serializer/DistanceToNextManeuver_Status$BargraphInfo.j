.version 50 0 
.class public final super [117] 
.super [119] 
.implements [121] 
.field public [122] [123] 
.field private static final [124] [125] 
.field public static final [126] [127] 
.field public static final [128] [129] 
.field public static final [130] [131] 
.field public [132] [133] 
.field private static final [134] [135] 

.method public [137] : [138] 
    .attribute [136] .code stack 1 locals 0 
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

.method public [139] : [140] 
    .attribute [136] .code stack 2 locals 0 
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

.method private [141] : [142] 
    .attribute [136] .code stack 2 locals 0 
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

.method public [143] : [144] 
    .attribute [136] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [136] .code stack 2 locals 1 
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

.method private enum [147] : [148] 
    .attribute [136] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [136] .code stack 2 locals 1 
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
L22:    aload_0 
L23:    getfield [14] 
L26:    lookupswitch 
            0 : L60 
            1 : L70 
            255 : L80 
            default : L90 

L60:    aload_1 
L61:    ldc [6] 
L63:    invokevirtual [16] 
L66:    pop 
L67:    goto L97 
L70:    aload_1 
L71:    ldc [7] 
L73:    invokevirtual [16] 
L76:    pop 
L77:    goto L97 
L80:    aload_1 
L81:    ldc [8] 
L83:    invokevirtual [16] 
L86:    pop 
L87:    goto L97 
L90:    aload_1 
L91:    ldc [9] 
L93:    invokevirtual [16] 
L96:    pop 
L97:    aload_1 
L98:    ldc [10] 
L100:   invokevirtual [16] 
L103:   pop 
L104:   aload_1 
L105:   aload_0 
L106:   getfield [15] 
L109:   invokevirtual [17] 
L112:   pop 
L113:   aload_1 
L114:   invokevirtual [18] 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [136] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iload_1 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [14] 
L5:     i2b 
L6:     invokeinterface [27] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [15] 
L16:    i2b 
L17:    invokeinterface [27] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [136] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [28] 0 
L7:     putfield [24] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [28] 0 
L17:    putfield [25] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Class [30] 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = String [34] 
.const [8] = String [35] 
.const [9] = String [36] 
.const [10] = String [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Method [40] [41] 
.const [14] = Field [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Class [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [30] = Utf8 java/lang/StringBuffer 
.const [31] = Utf8 'BargraphInfo:' 
.const [32] = Utf8 '\n - BargraphOnOff: ' 
.const [33] = Utf8 '0x00 (bargraph shall not be displayed)' 
.const [34] = Utf8 '0x01 (display bargraph)' 
.const [35] = Utf8 '0xFF (not supported)' 
.const [36] = Utf8 'UNKNOWN ENUM' 
.const [37] = Utf8 '\n - Bargraph - ' 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [40] = Class [71] 
.const [41] = NameAndType [72] [73] 
.const [42] = Class [74] 
.const [43] = NameAndType [75] [76] 
.const [44] = Class [77] 
.const [45] = NameAndType [78] [79] 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [72] = Utf8 deserialize 
.const [73] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [74] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [75] = Utf8 bargraphOnOff 
.const [76] = Utf8 I 
.const [77] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [78] = Utf8 bargraph 
.const [79] = Utf8 I 
.const [80] = Utf8 java/lang/StringBuffer 
.const [81] = Utf8 append 
.const [82] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Utf8 append 
.const [85] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 toString 
.const [88] = Utf8 ()Ljava/lang/String; 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [93] = Utf8 internalReset 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [96] = Utf8 customInitialization 
.const [97] = Utf8 ()V 
.const [98] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [105] = Utf8 bargraphOnOff 
.const [106] = Utf8 I 
.const [107] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [108] = Utf8 bargraph 
.const [109] = Utf8 I 
.const [110] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [111] = Utf8 pushByte 
.const [112] = Utf8 (B)V 
.const [113] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [114] = Utf8 popFrontByte 
.const [115] = Utf8 ()I 
.const [116] = Utf8 de/vw/mib/bap/generated/navsd/serializer/DistanceToNextManeuver_Status$BargraphInfo 
.const [117] = Class [116] 
.const [118] = Utf8 java/lang/Object 
.const [119] = Class [118] 
.const [120] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [121] = Class [120] 
.const [122] = Utf8 bargraphOnOff 
.const [123] = Utf8 I 
.const [124] = Utf8 BARGRAPH_ON_OFF_BITSIZE 
.const [125] = Utf8 I 
.const [126] = Utf8 BARGRAPH_ON_OFF_BARGRAPH_SHALL_NOT_BE_DISPLAYED 
.const [127] = Utf8 I 
.const [128] = Utf8 BARGRAPH_ON_OFF_DISPLAY_BARGRAPH 
.const [129] = Utf8 I 
.const [130] = Utf8 BARGRAPH_ON_OFF_NOT_SUPPORTED 
.const [131] = Utf8 I 
.const [132] = Utf8 bargraph 
.const [133] = Utf8 I 
.const [134] = Utf8 BARGRAPH_BITSIZE 
.const [135] = Utf8 I 
.const [136] = Utf8 Code 
.const [137] = Utf8 <init> 
.const [138] = Utf8 ()V 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [141] = Utf8 internalReset 
.const [142] = Utf8 ()V 
.const [143] = Utf8 reset 
.const [144] = Utf8 ()V 
.const [145] = Utf8 equalTo 
.const [146] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [147] = Utf8 customInitialization 
.const [148] = Utf8 ()V 
.const [149] = Utf8 toString 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 bitSize 
.const [152] = Utf8 ()I 
.const [153] = Utf8 serialize 
.const [154] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [155] = Utf8 deserialize 
.const [156] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
