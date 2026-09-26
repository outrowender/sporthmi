.version 50 0 
.class public super [113] 
.super [115] 

.method public annotation [117] : [118] 
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

.method public static [119] : [120] 
    .attribute [116] .code stack 2 locals 4 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [17] 0 
L17:    iload_2 
L18:    ifne L59 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [18] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [18] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    astore 5 
L53:    aload_0 
L54:    aload 5 
L56:    invokestatic [2] 
L59:    return 
L60:    
    .end code 
.end method 

.method public static [121] : [122] 
    .attribute [116] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [17] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [18] 0 
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

.method public static [123] : [124] 
    .attribute [116] .code stack 2 locals 5 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [19] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L59 
L13:    new [20] 
L16:    dup 
L17:    invokespecial [16] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [21] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [22] 
L33:    aload_0 
L34:    invokeinterface [21] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [23] 
L47:    aload_0 
L48:    invokestatic [5] 
L51:    astore 5 
L53:    aload_1 
L54:    aload 5 
L56:    putfield [24] 
L59:    aload_1 
L60:    areturn 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public static [125] : [126] 
    .attribute [116] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [19] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [21] 0 
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
.const [2] = Method [25] [26] 
.const [3] = Method [27] [28] 
.const [4] = Class [29] 
.const [5] = Method [30] [31] 
.const [6] = Method [32] [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = InterfaceMethod [49] [50] 
.const [18] = InterfaceMethod [51] [52] 
.const [19] = InterfaceMethod [53] [54] 
.const [20] = Class [55] 
.const [21] = InterfaceMethod [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Class [64] 
.const [26] = NameAndType [65] [66] 
.const [27] = Class [67] 
.const [28] = NameAndType [68] [69] 
.const [29] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [30] = Class [70] 
.const [31] = NameAndType [71] [72] 
.const [32] = Class [73] 
.const [33] = NameAndType [74] [75] 
.const [34] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsCategorySerializer 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [37] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsSerializer 
.const [38] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [39] = Class [76] 
.const [40] = NameAndType [77] [78] 
.const [41] = Class [79] 
.const [42] = NameAndType [80] [81] 
.const [43] = Class [82] 
.const [44] = NameAndType [83] [84] 
.const [45] = Class [85] 
.const [46] = NameAndType [86] [87] 
.const [47] = Class [88] 
.const [48] = NameAndType [89] [90] 
.const [49] = Class [91] 
.const [50] = NameAndType [92] [93] 
.const [51] = Class [94] 
.const [52] = NameAndType [95] [96] 
.const [53] = Class [97] 
.const [54] = NameAndType [98] [99] 
.const [55] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsSerializer 
.const [65] = Utf8 putOptionalNewsVarArray 
.const [66] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/tpegservices/News;)V 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsCategorySerializer 
.const [68] = Utf8 putOptionalNewsCategory 
.const [69] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/tpegservices/NewsCategory;)V 
.const [70] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsSerializer 
.const [71] = Utf8 getOptionalNewsVarArray 
.const [72] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/tpegservices/News; 
.const [73] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsCategorySerializer 
.const [74] = Utf8 getOptionalNewsCategory 
.const [75] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/tpegservices/NewsCategory; 
.const [76] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [77] = Utf8 getContentId 
.const [78] = Utf8 ()I 
.const [79] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [80] = Utf8 getNewsType 
.const [81] = Utf8 ()I 
.const [82] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [83] = Utf8 getNews 
.const [84] = Utf8 ()[Lorg/dsi/ifc/tpegservices/News; 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [92] = Utf8 putBool 
.const [93] = Utf8 (Z)V 
.const [94] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [95] = Utf8 putInt32 
.const [96] = Utf8 (I)V 
.const [97] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [98] = Utf8 getBool 
.const [99] = Utf8 ()Z 
.const [100] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [101] = Utf8 getInt32 
.const [102] = Utf8 ()I 
.const [103] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [104] = Utf8 contentId 
.const [105] = Utf8 I 
.const [106] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [107] = Utf8 newsType 
.const [108] = Utf8 I 
.const [109] = Utf8 org/dsi/ifc/tpegservices/NewsCategory 
.const [110] = Utf8 news 
.const [111] = Utf8 [Lorg/dsi/ifc/tpegservices/News; 
.const [112] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/NewsCategorySerializer 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 putOptionalNewsCategory 
.const [120] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/tpegservices/NewsCategory;)V 
.const [121] = Utf8 putOptionalNewsCategoryVarArray 
.const [122] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/tpegservices/NewsCategory;)V 
.const [123] = Utf8 getOptionalNewsCategory 
.const [124] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/tpegservices/NewsCategory; 
.const [125] = Utf8 getOptionalNewsCategoryVarArray 
.const [126] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/tpegservices/NewsCategory; 
.end class 
