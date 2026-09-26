.version 50 0 
.class public final super [161] 
.super [163] 
.implements [165] 
.field public final [166] [167] 
.field public [168] [169] 
.field private static final [170] [171] 

.method public [173] : [174] 
    .attribute [172] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     new [29] 
L8:     dup 
L9:     invokespecial [24] 
L12:    putfield [30] 
L15:    aload_0 
L16:    invokespecial [25] 
L19:    aload_0 
L20:    invokespecial [26] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [177] : [178] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [172] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     getfield [11] 
L8:     invokevirtual [14] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [172] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [11] 
L9:     aload_2 
L10:    getfield [11] 
L13:    invokevirtual [15] 
L16:    ifeq L34 
L19:    aload_0 
L20:    getfield [13] 
L23:    aload_2 
L24:    getfield [13] 
L27:    if_icmpne L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method private enum [183] : [184] 
    .attribute [172] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [172] .code stack 2 locals 1 
L0:     new [32] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [16] 
L14:    pop 
L15:    aload_1 
L16:    ldc [6] 
L18:    invokevirtual [16] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [11] 
L27:    invokevirtual [17] 
L30:    invokevirtual [16] 
L33:    pop 
L34:    aload_1 
L35:    ldc [7] 
L37:    invokevirtual [16] 
L40:    pop 
L41:    aload_1 
L42:    aload_0 
L43:    getfield [13] 
L46:    invokevirtual [18] 
L49:    pop 
L50:    aload_1 
L51:    invokevirtual [19] 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [172] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iload_1 
L3:     aload_0 
L4:     getfield [11] 
L7:     invokevirtual [20] 
L10:    iadd 
L11:    istore_1 
L12:    iinc 1 8 
L15:    iload_1 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_1 
L5:     invokevirtual [21] 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [13] 
L13:    i2b 
L14:    invokeinterface [33] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_1 
L5:     invokevirtual [22] 
L8:     aload_0 
L9:     aload_1 
L10:    invokeinterface [34] 0 
L15:    putfield [31] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [193] : [194] 
    .attribute [172] .code stack 1 locals 0 
L0:     bipush 25 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [172] .code stack 1 locals 0 
L0:     invokestatic [8] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = Class [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = Method [41] [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Field [45] [46] 
.const [12] = Method [47] [48] 
.const [13] = Field [49] [50] 
.const [14] = Method [51] [52] 
.const [15] = Method [53] [54] 
.const [16] = Method [55] [56] 
.const [17] = Method [57] [58] 
.const [18] = Method [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Class [81] 
.const [30] = Field [82] [83] 
.const [31] = Field [84] [85] 
.const [32] = Class [86] 
.const [33] = InterfaceMethod [87] [88] 
.const [34] = InterfaceMethod [89] [90] 
.const [35] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [36] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [37] = Utf8 java/lang/StringBuffer 
.const [38] = Utf8 'GeneralInfoSwitches_SetGet:' 
.const [39] = Utf8 '\n - OnOffSwitches - ' 
.const [40] = Utf8 '\n - Reserve1 - ' 
.const [41] = Class [91] 
.const [42] = NameAndType [92] [93] 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [45] = Class [94] 
.const [46] = NameAndType [95] [96] 
.const [47] = Class [97] 
.const [48] = NameAndType [98] [99] 
.const [49] = Class [100] 
.const [50] = NameAndType [101] [102] 
.const [51] = Class [103] 
.const [52] = NameAndType [104] [105] 
.const [53] = Class [106] 
.const [54] = NameAndType [107] [108] 
.const [55] = Class [109] 
.const [56] = NameAndType [110] [111] 
.const [57] = Class [112] 
.const [58] = NameAndType [113] [114] 
.const [59] = Class [115] 
.const [60] = NameAndType [116] [117] 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Class [124] 
.const [66] = NameAndType [125] [126] 
.const [67] = Class [127] 
.const [68] = NameAndType [128] [129] 
.const [69] = Class [130] 
.const [70] = NameAndType [131] [132] 
.const [71] = Class [133] 
.const [72] = NameAndType [134] [135] 
.const [73] = Class [136] 
.const [74] = NameAndType [137] [138] 
.const [75] = Class [139] 
.const [76] = NameAndType [140] [141] 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [82] = Class [148] 
.const [83] = NameAndType [149] [150] 
.const [84] = Class [151] 
.const [85] = NameAndType [152] [153] 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [92] = Utf8 functionId 
.const [93] = Utf8 ()I 
.const [94] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [95] = Utf8 onOffSwitches 
.const [96] = Utf8 Lde/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches; 
.const [97] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [98] = Utf8 deserialize 
.const [99] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [100] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [101] = Utf8 reserve1 
.const [102] = Utf8 I 
.const [103] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [104] = Utf8 reset 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [107] = Utf8 equalTo 
.const [108] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 append 
.const [111] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [112] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [113] = Utf8 toString 
.const [114] = Utf8 ()Ljava/lang/String; 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 append 
.const [117] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [118] = Utf8 java/lang/StringBuffer 
.const [119] = Utf8 toString 
.const [120] = Utf8 ()Ljava/lang/String; 
.const [121] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [122] = Utf8 bitSize 
.const [123] = Utf8 ()I 
.const [124] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [125] = Utf8 serialize 
.const [126] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [127] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [128] = Utf8 deserialize 
.const [129] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [130] = Utf8 java/lang/Object 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [137] = Utf8 internalReset 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [140] = Utf8 customInitialization 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 java/lang/StringBuffer 
.const [146] = Utf8 <init> 
.const [147] = Utf8 ()V 
.const [148] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [149] = Utf8 onOffSwitches 
.const [150] = Utf8 Lde/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches; 
.const [151] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [152] = Utf8 reserve1 
.const [153] = Utf8 I 
.const [154] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [155] = Utf8 pushByte 
.const [156] = Utf8 (B)V 
.const [157] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [158] = Utf8 popFrontByte 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_SetGet 
.const [161] = Class [160] 
.const [162] = Utf8 java/lang/Object 
.const [163] = Class [162] 
.const [164] = Utf8 de/vw/mib/bap/requests/SetGetProperty 
.const [165] = Class [164] 
.const [166] = Utf8 onOffSwitches 
.const [167] = Utf8 Lde/vw/mib/bap/generated/audiosd/serializer/GeneralInfoSwitches_OnOffSwitches; 
.const [168] = Utf8 reserve1 
.const [169] = Utf8 I 
.const [170] = Utf8 RESERVE1_BITSIZE 
.const [171] = Utf8 I 
.const [172] = Utf8 Code 
.const [173] = Utf8 <init> 
.const [174] = Utf8 ()V 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [177] = Utf8 internalReset 
.const [178] = Utf8 ()V 
.const [179] = Utf8 reset 
.const [180] = Utf8 ()V 
.const [181] = Utf8 equalTo 
.const [182] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [183] = Utf8 customInitialization 
.const [184] = Utf8 ()V 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 bitSize 
.const [188] = Utf8 ()I 
.const [189] = Utf8 serialize 
.const [190] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [191] = Utf8 deserialize 
.const [192] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [193] = Utf8 functionId 
.const [194] = Utf8 ()I 
.const [195] = Utf8 getFunctionId 
.const [196] = Utf8 ()I 
.end class 
