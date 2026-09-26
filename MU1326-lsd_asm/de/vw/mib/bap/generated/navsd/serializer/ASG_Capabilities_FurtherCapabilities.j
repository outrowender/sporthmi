.version 50 0 
.class public final super [135] 
.super [137] 
.implements [139] 
.field public [140] [141] 
.field public [142] [143] 
.field public [144] [145] 
.field public [146] [147] 
.field private static final [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     invokespecial [21] 
L8:     aload_0 
L9:     invokespecial [22] 
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
L1:     invokespecial [23] 
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
L2:     putfield [25] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [26] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [27] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [28] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
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
L13:    if_icmpne L53 
L16:    aload_0 
L17:    getfield [15] 
L20:    aload_2 
L21:    getfield [15] 
L24:    if_icmpne L53 
L27:    aload_0 
L28:    getfield [16] 
L31:    aload_2 
L32:    getfield [16] 
L35:    if_icmpne L53 
L38:    aload_0 
L39:    getfield [17] 
L42:    aload_2 
L43:    getfield [17] 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
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
L0:     new [29] 
L3:     dup 
L4:     invokespecial [24] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [18] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [18] 
L21:    pop 
L22:    aload_0 
L23:    getfield [14] 
L26:    ifeq L39 
L29:    aload_1 
L30:    ldc [6] 
L32:    invokevirtual [18] 
L35:    pop 
L36:    goto L46 
L39:    aload_1 
L40:    ldc [7] 
L42:    invokevirtual [18] 
L45:    pop 
L46:    aload_1 
L47:    ldc [8] 
L49:    invokevirtual [18] 
L52:    pop 
L53:    aload_0 
L54:    getfield [15] 
L57:    ifeq L70 
L60:    aload_1 
L61:    ldc [6] 
L63:    invokevirtual [18] 
L66:    pop 
L67:    goto L77 
L70:    aload_1 
L71:    ldc [7] 
L73:    invokevirtual [18] 
L76:    pop 
L77:    aload_1 
L78:    ldc [9] 
L80:    invokevirtual [18] 
L83:    pop 
L84:    aload_0 
L85:    getfield [16] 
L88:    ifeq L101 
L91:    aload_1 
L92:    ldc [6] 
L94:    invokevirtual [18] 
L97:    pop 
L98:    goto L108 
L101:   aload_1 
L102:   ldc [7] 
L104:   invokevirtual [18] 
L107:   pop 
L108:   aload_1 
L109:   ldc [10] 
L111:   invokevirtual [18] 
L114:   pop 
L115:   aload_0 
L116:   getfield [17] 
L119:   ifeq L132 
L122:   aload_1 
L123:   ldc [6] 
L125:   invokevirtual [18] 
L128:   pop 
L129:   goto L139 
L132:   aload_1 
L133:   ldc [7] 
L135:   invokevirtual [18] 
L138:   pop 
L139:   aload_1 
L140:   invokevirtual [19] 
L143:   areturn 
L144:   
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [150] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 4 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [14] 
L5:     invokeinterface [30] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [15] 
L15:    invokeinterface [30] 0 
L20:    aload_1 
L21:    aload_0 
L22:    getfield [16] 
L25:    invokeinterface [30] 0 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [17] 
L35:    invokeinterface [30] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [31] 0 
L7:     putfield [25] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [31] 0 
L17:    putfield [26] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [31] 0 
L27:    putfield [27] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [31] 0 
L37:    putfield [28] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Method [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Field [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Field [73] [74] 
.const [29] = Class [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [33] = Utf8 java/lang/StringBuffer 
.const [34] = Utf8 'ASG_Capabilities_FurtherCapabilities:' 
.const [35] = Utf8 '\n - Bit 3: ' 
.const [36] = Utf8 'true  (reserved' 
.const [37] = Utf8 'false  (reserved' 
.const [38] = Utf8 '\n - Bit 2: ' 
.const [39] = Utf8 '\n - Bit 1: ' 
.const [40] = Utf8 '\n - Bit 0: ' 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Class [128] 
.const [77] = NameAndType [129] [130] 
.const [78] = Class [131] 
.const [79] = NameAndType [132] [133] 
.const [80] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [81] = Utf8 deserialize 
.const [82] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [83] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [84] = Utf8 reserved_bit_3 
.const [85] = Utf8 Z 
.const [86] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [87] = Utf8 reserved_bit_2 
.const [88] = Utf8 Z 
.const [89] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [90] = Utf8 reserved_bit_1 
.const [91] = Utf8 Z 
.const [92] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [93] = Utf8 reserved_bit_0 
.const [94] = Utf8 Z 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 append 
.const [97] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 toString 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 java/lang/Object 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [105] = Utf8 internalReset 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [108] = Utf8 customInitialization 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [117] = Utf8 reserved_bit_3 
.const [118] = Utf8 Z 
.const [119] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [120] = Utf8 reserved_bit_2 
.const [121] = Utf8 Z 
.const [122] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [123] = Utf8 reserved_bit_1 
.const [124] = Utf8 Z 
.const [125] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [126] = Utf8 reserved_bit_0 
.const [127] = Utf8 Z 
.const [128] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [129] = Utf8 pushBoolean 
.const [130] = Utf8 (Z)V 
.const [131] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [132] = Utf8 popFrontBoolean 
.const [133] = Utf8 ()Z 
.const [134] = Utf8 de/vw/mib/bap/generated/navsd/serializer/ASG_Capabilities_FurtherCapabilities 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [139] = Class [138] 
.const [140] = Utf8 reserved_bit_3 
.const [141] = Utf8 Z 
.const [142] = Utf8 reserved_bit_2 
.const [143] = Utf8 Z 
.const [144] = Utf8 reserved_bit_1 
.const [145] = Utf8 Z 
.const [146] = Utf8 reserved_bit_0 
.const [147] = Utf8 Z 
.const [148] = Utf8 ASG_CAPABILITIES_FURTHER_CAPABILITIES_BITSIZE 
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
.end class 
