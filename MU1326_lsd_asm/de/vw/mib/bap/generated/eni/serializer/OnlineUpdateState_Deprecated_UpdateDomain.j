.version 50 0 
.class public final super [177] 
.super [179] 
.implements [181] 
.field public [182] [183] 
.field public static final [184] [185] 
.field public [186] [187] 
.field public static final [188] [189] 
.field public [190] [191] 
.field public static final [192] [193] 
.field public [194] [195] 

.method public [197] : [198] 
    .attribute [196] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [31] 
L8:     dup 
L9:     invokespecial [26] 
L12:    putfield [32] 
L15:    aload_0 
L16:    invokespecial [27] 
L19:    aload_0 
L20:    invokespecial [28] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [196] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [201] : [202] 
    .attribute [196] .code stack 2 locals 0 
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

.method public [203] : [204] 
    .attribute [196] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     getfield [12] 
L8:     invokevirtual [17] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [196] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [12] 
L9:     aload_2 
L10:    getfield [12] 
L13:    invokevirtual [18] 
L16:    ifeq L56 
L19:    aload_0 
L20:    getfield [14] 
L23:    aload_2 
L24:    getfield [14] 
L27:    if_icmpne L56 
L30:    aload_0 
L31:    getfield [15] 
L34:    aload_2 
L35:    getfield [15] 
L38:    if_icmpne L56 
L41:    aload_0 
L42:    getfield [16] 
L45:    aload_2 
L46:    getfield [16] 
L49:    if_icmpne L56 
L52:    iconst_1 
L53:    goto L57 
L56:    iconst_0 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private enum [207] : [208] 
    .attribute [196] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [196] .code stack 3 locals 1 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [19] 
L14:    pop 
L15:    aload_1 
L16:    new [36] 
L19:    dup 
L20:    invokespecial [30] 
L23:    ldc [6] 
L25:    invokevirtual [19] 
L28:    aload_0 
L29:    getfield [12] 
L32:    invokevirtual [20] 
L35:    invokevirtual [19] 
L38:    invokevirtual [21] 
L41:    invokevirtual [19] 
L44:    pop 
L45:    aload_1 
L46:    new [36] 
L49:    dup 
L50:    invokespecial [30] 
L53:    ldc [7] 
L55:    invokevirtual [19] 
L58:    aload_0 
L59:    getfield [14] 
L62:    invokevirtual [22] 
L65:    invokevirtual [21] 
L68:    invokevirtual [19] 
L71:    pop 
L72:    aload_1 
L73:    new [36] 
L76:    dup 
L77:    invokespecial [30] 
L80:    ldc [8] 
L82:    invokevirtual [19] 
L85:    aload_0 
L86:    getfield [15] 
L89:    invokevirtual [22] 
L92:    invokevirtual [21] 
L95:    invokevirtual [19] 
L98:    pop 
L99:    aload_1 
L100:   new [36] 
L103:   dup 
L104:   invokespecial [30] 
L107:   ldc [9] 
L109:   invokevirtual [19] 
L112:   aload_0 
L113:   getfield [16] 
L116:   invokevirtual [22] 
L119:   invokevirtual [21] 
L122:   invokevirtual [19] 
L125:   pop 
L126:   aload_1 
L127:   invokevirtual [21] 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [196] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [196] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_1 
L5:     invokevirtual [23] 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [14] 
L13:    i2b 
L14:    invokeinterface [37] 0 
L19:    aload_1 
L20:    aload_0 
L21:    getfield [15] 
L24:    i2b 
L25:    invokeinterface [37] 0 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [16] 
L35:    i2b 
L36:    invokeinterface [37] 0 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [196] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_1 
L5:     invokevirtual [24] 
L8:     aload_0 
L9:     aload_1 
L10:    invokeinterface [38] 0 
L15:    putfield [33] 
L18:    aload_0 
L19:    aload_1 
L20:    invokeinterface [38] 0 
L25:    putfield [34] 
L28:    aload_0 
L29:    aload_1 
L30:    invokeinterface [38] 0 
L35:    putfield [35] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Class [40] 
.const [4] = Class [41] 
.const [5] = String [42] 
.const [6] = String [43] 
.const [7] = String [44] 
.const [8] = String [45] 
.const [9] = String [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Field [49] [50] 
.const [13] = Method [51] [52] 
.const [14] = Field [53] [54] 
.const [15] = Field [55] [56] 
.const [16] = Field [57] [58] 
.const [17] = Method [59] [60] 
.const [18] = Method [61] [62] 
.const [19] = Method [63] [64] 
.const [20] = Method [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Method [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Class [87] 
.const [32] = Field [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Field [92] [93] 
.const [35] = Field [94] [95] 
.const [36] = Class [96] 
.const [37] = InterfaceMethod [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [40] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Utf8 OnlineUpdateState_Deprecated_UpdateDomain 
.const [43] = Utf8 '\n - updateDomain0:' 
.const [44] = Utf8 '\n - updateDomain1:' 
.const [45] = Utf8 '\n - updateDomain2:' 
.const [46] = Utf8 '\n - updateDomain3:' 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [49] = Class [101] 
.const [50] = NameAndType [102] [103] 
.const [51] = Class [104] 
.const [52] = NameAndType [105] [106] 
.const [53] = Class [107] 
.const [54] = NameAndType [108] [109] 
.const [55] = Class [110] 
.const [56] = NameAndType [111] [112] 
.const [57] = Class [113] 
.const [58] = NameAndType [114] [115] 
.const [59] = Class [116] 
.const [60] = NameAndType [117] [118] 
.const [61] = Class [119] 
.const [62] = NameAndType [120] [121] 
.const [63] = Class [122] 
.const [64] = NameAndType [123] [124] 
.const [65] = Class [125] 
.const [66] = NameAndType [126] [127] 
.const [67] = Class [128] 
.const [68] = NameAndType [129] [130] 
.const [69] = Class [131] 
.const [70] = NameAndType [132] [133] 
.const [71] = Class [134] 
.const [72] = NameAndType [135] [136] 
.const [73] = Class [137] 
.const [74] = NameAndType [138] [139] 
.const [75] = Class [140] 
.const [76] = NameAndType [141] [142] 
.const [77] = Class [143] 
.const [78] = NameAndType [144] [145] 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Class [149] 
.const [82] = NameAndType [150] [151] 
.const [83] = Class [152] 
.const [84] = NameAndType [153] [154] 
.const [85] = Class [155] 
.const [86] = NameAndType [156] [157] 
.const [87] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [88] = Class [158] 
.const [89] = NameAndType [159] [160] 
.const [90] = Class [161] 
.const [91] = NameAndType [162] [163] 
.const [92] = Class [164] 
.const [93] = NameAndType [165] [166] 
.const [94] = Class [167] 
.const [95] = NameAndType [168] [169] 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Class [173] 
.const [100] = NameAndType [174] [175] 
.const [101] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [102] = Utf8 updateDomain0 
.const [103] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0; 
.const [104] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [105] = Utf8 deserialize 
.const [106] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [107] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [108] = Utf8 updateDomain1 
.const [109] = Utf8 I 
.const [110] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [111] = Utf8 updateDomain2 
.const [112] = Utf8 I 
.const [113] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [114] = Utf8 updateDomain3 
.const [115] = Utf8 I 
.const [116] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [117] = Utf8 reset 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [120] = Utf8 equalTo 
.const [121] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 append 
.const [124] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [125] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [126] = Utf8 toString 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 toString 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 append 
.const [133] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [134] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [135] = Utf8 serialize 
.const [136] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [137] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [138] = Utf8 deserialize 
.const [139] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [140] = Utf8 java/lang/Object 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [147] = Utf8 internalReset 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [150] = Utf8 customInitialization 
.const [151] = Utf8 ()V 
.const [152] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 java/lang/StringBuffer 
.const [156] = Utf8 <init> 
.const [157] = Utf8 ()V 
.const [158] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [159] = Utf8 updateDomain0 
.const [160] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0; 
.const [161] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [162] = Utf8 updateDomain1 
.const [163] = Utf8 I 
.const [164] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [165] = Utf8 updateDomain2 
.const [166] = Utf8 I 
.const [167] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [168] = Utf8 updateDomain3 
.const [169] = Utf8 I 
.const [170] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [171] = Utf8 pushByte 
.const [172] = Utf8 (B)V 
.const [173] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [174] = Utf8 popFrontByte 
.const [175] = Utf8 ()I 
.const [176] = Utf8 de/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain 
.const [177] = Class [176] 
.const [178] = Utf8 java/lang/Object 
.const [179] = Class [178] 
.const [180] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [181] = Class [180] 
.const [182] = Utf8 updateDomain0 
.const [183] = Utf8 Lde/vw/mib/bap/generated/eni/serializer/OnlineUpdateState_Deprecated_UpdateDomain0; 
.const [184] = Utf8 UPDATE_DOMAIN1_MIN 
.const [185] = Utf8 I 
.const [186] = Utf8 updateDomain1 
.const [187] = Utf8 I 
.const [188] = Utf8 UPDATE_DOMAIN2_MIN 
.const [189] = Utf8 I 
.const [190] = Utf8 updateDomain2 
.const [191] = Utf8 I 
.const [192] = Utf8 UPDATE_DOMAIN3_MIN 
.const [193] = Utf8 I 
.const [194] = Utf8 updateDomain3 
.const [195] = Utf8 I 
.const [196] = Utf8 Code 
.const [197] = Utf8 <init> 
.const [198] = Utf8 ()V 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [201] = Utf8 internalReset 
.const [202] = Utf8 ()V 
.const [203] = Utf8 reset 
.const [204] = Utf8 ()V 
.const [205] = Utf8 equalTo 
.const [206] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [207] = Utf8 customInitialization 
.const [208] = Utf8 ()V 
.const [209] = Utf8 toString 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 bitSize 
.const [212] = Utf8 ()I 
.const [213] = Utf8 serialize 
.const [214] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [215] = Utf8 deserialize 
.const [216] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
