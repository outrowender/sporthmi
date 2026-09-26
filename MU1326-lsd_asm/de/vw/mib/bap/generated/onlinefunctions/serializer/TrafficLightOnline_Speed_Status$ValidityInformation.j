.version 50 0 
.class public final super [105] 
.super [107] 
.implements [109] 
.field private static final [110] [111] 
.field public [112] [113] 
.field private static final [114] [115] 

.method public [117] : [118] 
    .attribute [116] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     invokespecial [15] 
L8:     aload_0 
L9:     invokespecial [16] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [116] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [10] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [121] : [122] 
    .attribute [116] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [116] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [116] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [11] 
L9:     aload_2 
L10:    getfield [11] 
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

.method private enum [127] : [128] 
    .attribute [116] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [116] .code stack 2 locals 1 
L0:     new [20] 
L3:     dup 
L4:     invokespecial [18] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [12] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [12] 
L21:    pop 
L22:    aload_0 
L23:    getfield [11] 
L26:    ifeq L39 
L29:    aload_1 
L30:    ldc [6] 
L32:    invokevirtual [12] 
L35:    pop 
L36:    goto L46 
L39:    aload_1 
L40:    ldc [7] 
L42:    invokevirtual [12] 
L45:    pop 
L46:    aload_1 
L47:    invokevirtual [13] 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [116] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [116] .code stack 2 locals 0 
L0:     aload_1 
L1:     bipush 7 
L3:     invokeinterface [21] 0 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [11] 
L13:    invokeinterface [22] 0 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [116] .code stack 2 locals 0 
L0:     aload_1 
L1:     bipush 7 
L3:     invokeinterface [23] 0 
L8:     aload_0 
L9:     aload_1 
L10:    invokeinterface [24] 0 
L15:    putfield [19] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = String [27] 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Method [33] [34] 
.const [11] = Field [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Class [53] 
.const [21] = InterfaceMethod [54] [55] 
.const [22] = InterfaceMethod [56] [57] 
.const [23] = InterfaceMethod [58] [59] 
.const [24] = InterfaceMethod [60] [61] 
.const [25] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [26] = Utf8 java/lang/StringBuffer 
.const [27] = Utf8 'ValidityInformation:' 
.const [28] = Utf8 '\n - Bit 0: ' 
.const [29] = Utf8 'true  (RecommendedSpeed is valid' 
.const [30] = Utf8 'false  (RecommendedSpeed is invalid' 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [63] = Utf8 deserialize 
.const [64] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [65] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [66] = Utf8 recommendedSpeedIsValid 
.const [67] = Utf8 Z 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Utf8 append 
.const [70] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 toString 
.const [73] = Utf8 ()Ljava/lang/String; 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [78] = Utf8 internalReset 
.const [79] = Utf8 ()V 
.const [80] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [81] = Utf8 customInitialization 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 <init> 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [90] = Utf8 recommendedSpeedIsValid 
.const [91] = Utf8 Z 
.const [92] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [93] = Utf8 resetBits 
.const [94] = Utf8 (I)V 
.const [95] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [96] = Utf8 pushBoolean 
.const [97] = Utf8 (Z)V 
.const [98] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [99] = Utf8 discardBits 
.const [100] = Utf8 (I)V 
.const [101] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [102] = Utf8 popFrontBoolean 
.const [103] = Utf8 ()Z 
.const [104] = Utf8 de/vw/mib/bap/generated/onlinefunctions/serializer/TrafficLightOnline_Speed_Status$ValidityInformation 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [109] = Class [108] 
.const [110] = Utf8 RESERVED_BIT_1__7_BITSIZE 
.const [111] = Utf8 I 
.const [112] = Utf8 recommendedSpeedIsValid 
.const [113] = Utf8 Z 
.const [114] = Utf8 VALIDITY_INFORMATION_BITSIZE 
.const [115] = Utf8 I 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [121] = Utf8 internalReset 
.const [122] = Utf8 ()V 
.const [123] = Utf8 reset 
.const [124] = Utf8 ()V 
.const [125] = Utf8 equalTo 
.const [126] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [127] = Utf8 customInitialization 
.const [128] = Utf8 ()V 
.const [129] = Utf8 toString 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 bitSize 
.const [132] = Utf8 ()I 
.const [133] = Utf8 serialize 
.const [134] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [135] = Utf8 deserialize 
.const [136] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
