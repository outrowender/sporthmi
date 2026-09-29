.version 50 0 
.class public final super [143] 
.super [145] 
.implements [147] 
.field public [148] [149] 
.field public [150] [151] 
.field public [152] [153] 
.field public [154] [155] 
.field private static final [156] [157] 

.method public [159] : [160] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     invokespecial [25] 
L8:     aload_0 
L9:     invokespecial [26] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [29] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [30] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [31] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [32] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [158] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_2 
L10:    getfield [18] 
L13:    if_icmpne L53 
L16:    aload_0 
L17:    getfield [19] 
L20:    aload_2 
L21:    getfield [19] 
L24:    if_icmpne L53 
L27:    aload_0 
L28:    getfield [20] 
L31:    aload_2 
L32:    getfield [20] 
L35:    if_icmpne L53 
L38:    aload_0 
L39:    getfield [21] 
L42:    aload_2 
L43:    getfield [21] 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method private enum [169] : [170] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [158] .code stack 2 locals 1 
L0:     new [33] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [22] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [22] 
L21:    pop 
L22:    aload_0 
L23:    getfield [18] 
L26:    ifeq L39 
L29:    aload_1 
L30:    ldc [6] 
L32:    invokevirtual [22] 
L35:    pop 
L36:    goto L46 
L39:    aload_1 
L40:    ldc [7] 
L42:    invokevirtual [22] 
L45:    pop 
L46:    aload_1 
L47:    ldc [8] 
L49:    invokevirtual [22] 
L52:    pop 
L53:    aload_0 
L54:    getfield [19] 
L57:    ifeq L70 
L60:    aload_1 
L61:    ldc [6] 
L63:    invokevirtual [22] 
L66:    pop 
L67:    goto L77 
L70:    aload_1 
L71:    ldc [7] 
L73:    invokevirtual [22] 
L76:    pop 
L77:    aload_1 
L78:    ldc [9] 
L80:    invokevirtual [22] 
L83:    pop 
L84:    aload_0 
L85:    getfield [20] 
L88:    ifeq L101 
L91:    aload_1 
L92:    ldc [10] 
L94:    invokevirtual [22] 
L97:    pop 
L98:    goto L108 
L101:   aload_1 
L102:   ldc [11] 
L104:   invokevirtual [22] 
L107:   pop 
L108:   aload_1 
L109:   ldc [12] 
L111:   invokevirtual [22] 
L114:   pop 
L115:   aload_0 
L116:   getfield [21] 
L119:   ifeq L132 
L122:   aload_1 
L123:   ldc [13] 
L125:   invokevirtual [22] 
L128:   pop 
L129:   goto L139 
L132:   aload_1 
L133:   ldc [14] 
L135:   invokevirtual [22] 
L138:   pop 
L139:   aload_1 
L140:   invokevirtual [23] 
L143:   areturn 
L144:   
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [158] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 4 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [18] 
L5:     invokeinterface [34] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [19] 
L15:    invokeinterface [34] 0 
L20:    aload_1 
L21:    aload_0 
L22:    getfield [20] 
L25:    invokeinterface [34] 0 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [21] 
L35:    invokeinterface [34] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [35] 0 
L7:     putfield [29] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [35] 0 
L17:    putfield [30] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [35] 0 
L27:    putfield [31] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [35] 0 
L37:    putfield [32] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = Class [37] 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = String [40] 
.const [7] = String [41] 
.const [8] = String [42] 
.const [9] = String [43] 
.const [10] = String [44] 
.const [11] = String [45] 
.const [12] = String [46] 
.const [13] = String [47] 
.const [14] = String [48] 
.const [15] = Class [49] 
.const [16] = Class [50] 
.const [17] = Method [51] [52] 
.const [18] = Field [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Field [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Class [83] 
.const [34] = InterfaceMethod [84] [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [37] = Utf8 java/lang/StringBuffer 
.const [38] = Utf8 'AnyVoiceTag:' 
.const [39] = Utf8 '\n - Bit 3: ' 
.const [40] = Utf8 'true  (reserved' 
.const [41] = Utf8 'false  (reserved' 
.const [42] = Utf8 '\n - Bit 2: ' 
.const [43] = Utf8 '\n - Bit 1: ' 
.const [44] = Utf8 'true  (voice tag for standard number available' 
.const [45] = Utf8 'false  (no voice tag for standard number available' 
.const [46] = Utf8 '\n - Bit 0: ' 
.const [47] = Utf8 'true  (any voice tag available' 
.const [48] = Utf8 'false  (no voice tag available' 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Class [121] 
.const [74] = NameAndType [122] [123] 
.const [75] = Class [124] 
.const [76] = NameAndType [125] [126] 
.const [77] = Class [127] 
.const [78] = NameAndType [128] [129] 
.const [79] = Class [130] 
.const [80] = NameAndType [131] [132] 
.const [81] = Class [133] 
.const [82] = NameAndType [134] [135] 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Class [136] 
.const [85] = NameAndType [137] [138] 
.const [86] = Class [139] 
.const [87] = NameAndType [140] [141] 
.const [88] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [89] = Utf8 deserialize 
.const [90] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [91] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [92] = Utf8 reserved_bit_3 
.const [93] = Utf8 Z 
.const [94] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [95] = Utf8 reserved_bit_2 
.const [96] = Utf8 Z 
.const [97] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [98] = Utf8 voiceTagForStandardNumberAvailable 
.const [99] = Utf8 Z 
.const [100] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [101] = Utf8 anyVoiceTagAvailable 
.const [102] = Utf8 Z 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 append 
.const [105] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 toString 
.const [108] = Utf8 ()Ljava/lang/String; 
.const [109] = Utf8 java/lang/Object 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [113] = Utf8 internalReset 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [116] = Utf8 customInitialization 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 java/lang/StringBuffer 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [125] = Utf8 reserved_bit_3 
.const [126] = Utf8 Z 
.const [127] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [128] = Utf8 reserved_bit_2 
.const [129] = Utf8 Z 
.const [130] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [131] = Utf8 voiceTagForStandardNumberAvailable 
.const [132] = Utf8 Z 
.const [133] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [134] = Utf8 anyVoiceTagAvailable 
.const [135] = Utf8 Z 
.const [136] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [137] = Utf8 pushBoolean 
.const [138] = Utf8 (Z)V 
.const [139] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [140] = Utf8 popFrontBoolean 
.const [141] = Utf8 ()Z 
.const [142] = Utf8 de/vw/mib/bap/generated/telephone/serializer/Phonebook_Data$AnyVoiceTag 
.const [143] = Class [142] 
.const [144] = Utf8 java/lang/Object 
.const [145] = Class [144] 
.const [146] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [147] = Class [146] 
.const [148] = Utf8 reserved_bit_3 
.const [149] = Utf8 Z 
.const [150] = Utf8 reserved_bit_2 
.const [151] = Utf8 Z 
.const [152] = Utf8 voiceTagForStandardNumberAvailable 
.const [153] = Utf8 Z 
.const [154] = Utf8 anyVoiceTagAvailable 
.const [155] = Utf8 Z 
.const [156] = Utf8 ANY_VOICE_TAG_BITSIZE 
.const [157] = Utf8 I 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [163] = Utf8 internalReset 
.const [164] = Utf8 ()V 
.const [165] = Utf8 reset 
.const [166] = Utf8 ()V 
.const [167] = Utf8 equalTo 
.const [168] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [169] = Utf8 customInitialization 
.const [170] = Utf8 ()V 
.const [171] = Utf8 toString 
.const [172] = Utf8 ()Ljava/lang/String; 
.const [173] = Utf8 bitSize 
.const [174] = Utf8 ()I 
.const [175] = Utf8 serialize 
.const [176] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [177] = Utf8 deserialize 
.const [178] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
