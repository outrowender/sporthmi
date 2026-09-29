.version 50 0 
.class public super [111] 
.super [113] 

.method public annotation [115] : [116] 
    .attribute [114] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [117] : [118] 
    .attribute [114] .code stack 2 locals 5 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [15] 0 
L17:    iload_2 
L18:    ifne L75 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [15] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [15] 0 
L47:    aload_1 
L48:    invokevirtual [11] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [15] 0 
L61:    aload_1 
L62:    invokevirtual [12] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [15] 0 
L75:    return 
L76:    
    .end code 
.end method 

.method public static [119] : [120] 
    .attribute [114] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [15] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [16] 0 
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
L41:    invokestatic [2] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [121] : [122] 
    .attribute [114] .code stack 2 locals 6 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [17] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L75 
L13:    new [18] 
L16:    dup 
L17:    invokespecial [14] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [17] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [19] 
L33:    aload_0 
L34:    invokeinterface [17] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [20] 
L47:    aload_0 
L48:    invokeinterface [17] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [21] 
L61:    aload_0 
L62:    invokeinterface [17] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [22] 
L75:    aload_1 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public static [123] : [124] 
    .attribute [114] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [17] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [23] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [3] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [4] 
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
.const [2] = Method [24] [25] 
.const [3] = Class [26] 
.const [4] = Method [27] [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Method [33] [34] 
.const [10] = Method [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = InterfaceMethod [45] [46] 
.const [16] = InterfaceMethod [47] [48] 
.const [17] = InterfaceMethod [49] [50] 
.const [18] = Class [51] 
.const [19] = Field [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = InterfaceMethod [60] [61] 
.const [24] = Class [62] 
.const [25] = NameAndType [63] [64] 
.const [26] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [27] = Class [65] 
.const [28] = NameAndType [66] [67] 
.const [29] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCIndicationsSerializer 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [32] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [33] = Class [68] 
.const [34] = NameAndType [69] [70] 
.const [35] = Class [71] 
.const [36] = NameAndType [72] [73] 
.const [37] = Class [74] 
.const [38] = NameAndType [75] [76] 
.const [39] = Class [77] 
.const [40] = NameAndType [78] [79] 
.const [41] = Class [80] 
.const [42] = NameAndType [81] [82] 
.const [43] = Class [83] 
.const [44] = NameAndType [84] [85] 
.const [45] = Class [86] 
.const [46] = NameAndType [87] [88] 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Class [104] 
.const [59] = NameAndType [105] [106] 
.const [60] = Class [107] 
.const [61] = NameAndType [108] [109] 
.const [62] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCIndicationsSerializer 
.const [63] = Utf8 putOptionalBCIndications 
.const [64] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carkombi/BCIndications;)V 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCIndicationsSerializer 
.const [66] = Utf8 getOptionalBCIndications 
.const [67] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carkombi/BCIndications; 
.const [68] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [69] = Utf8 isWashingWater 
.const [70] = Utf8 ()Z 
.const [71] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [72] = Utf8 isOilLevel 
.const [73] = Utf8 ()Z 
.const [74] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [75] = Utf8 isTyrePressure 
.const [76] = Utf8 ()Z 
.const [77] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [78] = Utf8 isTankLevel 
.const [79] = Utf8 ()Z 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [87] = Utf8 putBool 
.const [88] = Utf8 (Z)V 
.const [89] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [90] = Utf8 putInt32 
.const [91] = Utf8 (I)V 
.const [92] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [93] = Utf8 getBool 
.const [94] = Utf8 ()Z 
.const [95] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [96] = Utf8 washingWater 
.const [97] = Utf8 Z 
.const [98] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [99] = Utf8 oilLevel 
.const [100] = Utf8 Z 
.const [101] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [102] = Utf8 tyrePressure 
.const [103] = Utf8 Z 
.const [104] = Utf8 org/dsi/ifc/carkombi/BCIndications 
.const [105] = Utf8 tankLevel 
.const [106] = Utf8 Z 
.const [107] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [108] = Utf8 getInt32 
.const [109] = Utf8 ()I 
.const [110] = Utf8 de/esolutions/fw/comm/dsi/carkombi/impl/BCIndicationsSerializer 
.const [111] = Class [110] 
.const [112] = Utf8 java/lang/Object 
.const [113] = Class [112] 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 putOptionalBCIndications 
.const [118] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/carkombi/BCIndications;)V 
.const [119] = Utf8 putOptionalBCIndicationsVarArray 
.const [120] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/carkombi/BCIndications;)V 
.const [121] = Utf8 getOptionalBCIndications 
.const [122] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/carkombi/BCIndications; 
.const [123] = Utf8 getOptionalBCIndicationsVarArray 
.const [124] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/carkombi/BCIndications; 
.end class 
