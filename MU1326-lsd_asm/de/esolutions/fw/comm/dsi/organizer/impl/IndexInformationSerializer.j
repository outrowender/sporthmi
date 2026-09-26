.version 50 0 
.class public super [101] 
.super [103] 

.method public annotation [105] : [106] 
    .attribute [104] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [107] : [108] 
    .attribute [104] .code stack 2 locals 3 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [16] 0 
L17:    iload_2 
L18:    ifne L45 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [17] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokestatic [2] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public static [109] : [110] 
    .attribute [104] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [16] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [17] 0 
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

.method public static [111] : [112] 
    .attribute [104] .code stack 2 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [18] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L45 
L13:    new [19] 
L16:    dup 
L17:    invokespecial [15] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [20] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [21] 
L33:    aload_0 
L34:    invokestatic [5] 
L37:    astore 4 
L39:    aload_1 
L40:    aload 4 
L42:    putfield [22] 
L45:    aload_1 
L46:    areturn 
L47:    nop 
L48:    
    .end code 
.end method 

.method public static [113] : [114] 
    .attribute [104] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [18] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [20] 0 
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
.const [2] = Method [23] [24] 
.const [3] = Method [25] [26] 
.const [4] = Class [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = InterfaceMethod [45] [46] 
.const [17] = InterfaceMethod [47] [48] 
.const [18] = InterfaceMethod [49] [50] 
.const [19] = Class [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = Field [54] [55] 
.const [22] = Field [56] [57] 
.const [23] = Class [58] 
.const [24] = NameAndType [59] [60] 
.const [25] = Class [61] 
.const [26] = NameAndType [62] [63] 
.const [27] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [28] = Class [64] 
.const [29] = NameAndType [65] [66] 
.const [30] = Class [67] 
.const [31] = NameAndType [68] [69] 
.const [32] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/IndexInformationSerializer 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [35] = Utf8 de/esolutions/fw/comm/dsi/global/impl/CharacterInfoSerializer 
.const [36] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Utf8 de/esolutions/fw/comm/dsi/global/impl/CharacterInfoSerializer 
.const [59] = Utf8 putOptionalCharacterInfoVarArray 
.const [60] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/global/CharacterInfo;)V 
.const [61] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/IndexInformationSerializer 
.const [62] = Utf8 putOptionalIndexInformation 
.const [63] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/organizer/IndexInformation;)V 
.const [64] = Utf8 de/esolutions/fw/comm/dsi/global/impl/CharacterInfoSerializer 
.const [65] = Utf8 getOptionalCharacterInfoVarArray 
.const [66] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/global/CharacterInfo; 
.const [67] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/IndexInformationSerializer 
.const [68] = Utf8 getOptionalIndexInformation 
.const [69] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/IndexInformation; 
.const [70] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [71] = Utf8 getViewtype 
.const [72] = Utf8 ()I 
.const [73] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [74] = Utf8 getCharacterInfo 
.const [75] = Utf8 ()[Lorg/dsi/ifc/global/CharacterInfo; 
.const [76] = Utf8 java/lang/Object 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [83] = Utf8 putBool 
.const [84] = Utf8 (Z)V 
.const [85] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [86] = Utf8 putInt32 
.const [87] = Utf8 (I)V 
.const [88] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [89] = Utf8 getBool 
.const [90] = Utf8 ()Z 
.const [91] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [92] = Utf8 getInt32 
.const [93] = Utf8 ()I 
.const [94] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [95] = Utf8 viewtype 
.const [96] = Utf8 I 
.const [97] = Utf8 org/dsi/ifc/organizer/IndexInformation 
.const [98] = Utf8 characterInfo 
.const [99] = Utf8 [Lorg/dsi/ifc/global/CharacterInfo; 
.const [100] = Utf8 de/esolutions/fw/comm/dsi/organizer/impl/IndexInformationSerializer 
.const [101] = Class [100] 
.const [102] = Utf8 java/lang/Object 
.const [103] = Class [102] 
.const [104] = Utf8 Code 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 putOptionalIndexInformation 
.const [108] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/organizer/IndexInformation;)V 
.const [109] = Utf8 putOptionalIndexInformationVarArray 
.const [110] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/organizer/IndexInformation;)V 
.const [111] = Utf8 getOptionalIndexInformation 
.const [112] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/organizer/IndexInformation; 
.const [113] = Utf8 getOptionalIndexInformationVarArray 
.const [114] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/organizer/IndexInformation; 
.end class 
