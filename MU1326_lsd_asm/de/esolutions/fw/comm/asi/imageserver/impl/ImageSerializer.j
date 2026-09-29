.version 50 0 
.class public super [137] 
.super [139] 

.method public annotation [141] : [142] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [140] .code stack 2 locals 5 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [18] 0 
L17:    iload_2 
L18:    ifne L73 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokestatic [2] 
L31:    aload_1 
L32:    invokevirtual [13] 
L35:    istore 4 
L37:    aload_0 
L38:    iload 4 
L40:    invokeinterface [18] 0 
L45:    aload_1 
L46:    invokevirtual [14] 
L49:    astore 5 
L51:    aload_0 
L52:    aload 5 
L54:    invokeinterface [19] 0 
L59:    aload_1 
L60:    invokevirtual [15] 
L63:    istore 6 
L65:    aload_0 
L66:    iload 6 
L68:    invokeinterface [20] 0 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public static [145] : [146] 
    .attribute [140] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [18] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [20] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [147] : [148] 
    .attribute [140] .code stack 2 locals 6 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L73 
L13:    new [22] 
L16:    dup 
L17:    invokespecial [17] 
L20:    astore_1 
L21:    aload_0 
L22:    invokestatic [5] 
L25:    astore_3 
L26:    aload_1 
L27:    aload_3 
L28:    putfield [23] 
L31:    aload_0 
L32:    invokeinterface [21] 0 
L37:    istore 4 
L39:    aload_1 
L40:    iload 4 
L42:    putfield [24] 
L45:    aload_0 
L46:    invokeinterface [25] 0 
L51:    astore 5 
L53:    aload_1 
L54:    aload 5 
L56:    putfield [26] 
L59:    aload_0 
L60:    invokeinterface [27] 0 
L65:    istore 6 
L67:    aload_1 
L68:    iload 6 
L70:    putfield [28] 
L73:    aload_1 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method public static [149] : [150] 
    .attribute [140] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [21] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [27] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [4] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [6] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [29] [30] 
.const [3] = Method [31] [32] 
.const [4] = Class [33] 
.const [5] = Method [34] [35] 
.const [6] = Method [36] [37] 
.const [7] = Class [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Method [43] [44] 
.const [13] = Method [45] [46] 
.const [14] = Method [47] [48] 
.const [15] = Method [49] [50] 
.const [16] = Method [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = InterfaceMethod [55] [56] 
.const [19] = InterfaceMethod [57] [58] 
.const [20] = InterfaceMethod [59] [60] 
.const [21] = InterfaceMethod [61] [62] 
.const [22] = Class [63] 
.const [23] = Field [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = InterfaceMethod [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = InterfaceMethod [72] [73] 
.const [28] = Field [74] [75] 
.const [29] = Class [76] 
.const [30] = NameAndType [77] [78] 
.const [31] = Class [79] 
.const [32] = NameAndType [80] [81] 
.const [33] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [34] = Class [82] 
.const [35] = NameAndType [83] [84] 
.const [36] = Class [85] 
.const [37] = NameAndType [86] [87] 
.const [38] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageSerializer 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [41] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageInfoSerializer 
.const [42] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [43] = Class [88] 
.const [44] = NameAndType [89] [90] 
.const [45] = Class [91] 
.const [46] = NameAndType [92] [93] 
.const [47] = Class [94] 
.const [48] = NameAndType [95] [96] 
.const [49] = Class [97] 
.const [50] = NameAndType [98] [99] 
.const [51] = Class [100] 
.const [52] = NameAndType [101] [102] 
.const [53] = Class [103] 
.const [54] = NameAndType [104] [105] 
.const [55] = Class [106] 
.const [56] = NameAndType [107] [108] 
.const [57] = Class [109] 
.const [58] = NameAndType [110] [111] 
.const [59] = Class [112] 
.const [60] = NameAndType [113] [114] 
.const [61] = Class [115] 
.const [62] = NameAndType [116] [117] 
.const [63] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Class [121] 
.const [67] = NameAndType [122] [123] 
.const [68] = Class [124] 
.const [69] = NameAndType [125] [126] 
.const [70] = Class [127] 
.const [71] = NameAndType [128] [129] 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageInfoSerializer 
.const [77] = Utf8 putOptionalImageInfo 
.const [78] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/imageserver/ImageInfo;)V 
.const [79] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageSerializer 
.const [80] = Utf8 putOptionalImage 
.const [81] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/imageserver/Image;)V 
.const [82] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageInfoSerializer 
.const [83] = Utf8 getOptionalImageInfo 
.const [84] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/imageserver/ImageInfo; 
.const [85] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageSerializer 
.const [86] = Utf8 getOptionalImage 
.const [87] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/imageserver/Image; 
.const [88] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [89] = Utf8 getInfo 
.const [90] = Utf8 ()Lde/esolutions/fw/comm/asi/imageserver/ImageInfo; 
.const [91] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [92] = Utf8 isConverted 
.const [93] = Utf8 ()Z 
.const [94] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [95] = Utf8 getData 
.const [96] = Utf8 ()[B 
.const [97] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [98] = Utf8 getDataSize 
.const [99] = Utf8 ()I 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [107] = Utf8 putBool 
.const [108] = Utf8 (Z)V 
.const [109] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [110] = Utf8 putOptionalInt8VarArray 
.const [111] = Utf8 ([B)V 
.const [112] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [113] = Utf8 putInt32 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [116] = Utf8 getBool 
.const [117] = Utf8 ()Z 
.const [118] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [119] = Utf8 info 
.const [120] = Utf8 Lde/esolutions/fw/comm/asi/imageserver/ImageInfo; 
.const [121] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [122] = Utf8 converted 
.const [123] = Utf8 Z 
.const [124] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [125] = Utf8 getOptionalInt8VarArray 
.const [126] = Utf8 ()[B 
.const [127] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [128] = Utf8 data 
.const [129] = Utf8 [B 
.const [130] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [131] = Utf8 getInt32 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/esolutions/fw/comm/asi/imageserver/Image 
.const [134] = Utf8 dataSize 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/fw/comm/asi/imageserver/impl/ImageSerializer 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 putOptionalImage 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/asi/imageserver/Image;)V 
.const [145] = Utf8 putOptionalImageVarArray 
.const [146] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lde/esolutions/fw/comm/asi/imageserver/Image;)V 
.const [147] = Utf8 getOptionalImage 
.const [148] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/asi/imageserver/Image; 
.const [149] = Utf8 getOptionalImageVarArray 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lde/esolutions/fw/comm/asi/imageserver/Image; 
.end class 
