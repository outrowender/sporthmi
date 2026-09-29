.version 50 0 
.class public super [151] 
.super [153] 

.method public annotation [155] : [156] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [157] : [158] 
    .attribute [154] .code stack 3 locals 6 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [21] 0 
L17:    iload_2 
L18:    ifne L71 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    lstore_3 
L26:    aload_0 
L27:    lload_3 
L28:    invokeinterface [22] 0 
L33:    aload_1 
L34:    invokevirtual [16] 
L37:    istore 5 
L39:    aload_0 
L40:    iload 5 
L42:    invokeinterface [23] 0 
L47:    aload_1 
L48:    invokevirtual [17] 
L51:    astore 6 
L53:    aload_0 
L54:    aload 6 
L56:    invokestatic [2] 
L59:    aload_1 
L60:    invokevirtual [18] 
L63:    astore 7 
L65:    aload_0 
L66:    aload 7 
L68:    invokestatic [3] 
L71:    return 
L72:    
    .end code 
.end method 

.method public static [159] : [160] 
    .attribute [154] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [21] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [23] 0 
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
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [161] : [162] 
    .attribute [154] .code stack 3 locals 7 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [24] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L71 
L13:    new [25] 
L16:    dup 
L17:    invokespecial [20] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [26] 0 
L27:    lstore_3 
L28:    aload_1 
L29:    lload_3 
L30:    putfield [27] 
L33:    aload_0 
L34:    invokeinterface [28] 0 
L39:    istore 5 
L41:    aload_1 
L42:    iload 5 
L44:    putfield [29] 
L47:    aload_0 
L48:    invokestatic [6] 
L51:    astore 6 
L53:    aload_1 
L54:    aload 6 
L56:    putfield [30] 
L59:    aload_0 
L60:    invokestatic [7] 
L63:    astore 7 
L65:    aload_1 
L66:    aload 7 
L68:    putfield [31] 
L71:    aload_1 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public static [163] : [164] 
    .attribute [154] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [24] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [28] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [5] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [8] 
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
.const [2] = Method [32] [33] 
.const [3] = Method [34] [35] 
.const [4] = Method [36] [37] 
.const [5] = Class [38] 
.const [6] = Method [39] [40] 
.const [7] = Method [41] [42] 
.const [8] = Method [43] [44] 
.const [9] = Class [45] 
.const [10] = Class [46] 
.const [11] = Class [47] 
.const [12] = Class [48] 
.const [13] = Class [49] 
.const [14] = Class [50] 
.const [15] = Method [51] [52] 
.const [16] = Method [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = InterfaceMethod [63] [64] 
.const [22] = InterfaceMethod [65] [66] 
.const [23] = InterfaceMethod [67] [68] 
.const [24] = InterfaceMethod [69] [70] 
.const [25] = Class [71] 
.const [26] = InterfaceMethod [72] [73] 
.const [27] = Field [74] [75] 
.const [28] = InterfaceMethod [76] [77] 
.const [29] = Field [78] [79] 
.const [30] = Field [80] [81] 
.const [31] = Field [82] [83] 
.const [32] = Class [84] 
.const [33] = NameAndType [85] [86] 
.const [34] = Class [87] 
.const [35] = NameAndType [88] [89] 
.const [36] = Class [90] 
.const [37] = NameAndType [91] [92] 
.const [38] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [39] = Class [93] 
.const [40] = NameAndType [94] [95] 
.const [41] = Class [96] 
.const [42] = NameAndType [97] [98] 
.const [43] = Class [99] 
.const [44] = NameAndType [100] [101] 
.const [45] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListEntrySerializer 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [48] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/FolderEntrySerializer 
.const [49] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [50] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [51] = Class [102] 
.const [52] = NameAndType [103] [104] 
.const [53] = Class [105] 
.const [54] = NameAndType [106] [107] 
.const [55] = Class [108] 
.const [56] = NameAndType [109] [110] 
.const [57] = Class [111] 
.const [58] = NameAndType [112] [113] 
.const [59] = Class [114] 
.const [60] = NameAndType [115] [116] 
.const [61] = Class [117] 
.const [62] = NameAndType [118] [119] 
.const [63] = Class [120] 
.const [64] = NameAndType [121] [122] 
.const [65] = Class [123] 
.const [66] = NameAndType [124] [125] 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Class [129] 
.const [70] = NameAndType [130] [131] 
.const [71] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [72] = Class [132] 
.const [73] = NameAndType [133] [134] 
.const [74] = Class [135] 
.const [75] = NameAndType [136] [137] 
.const [76] = Class [138] 
.const [77] = NameAndType [139] [140] 
.const [78] = Class [141] 
.const [79] = NameAndType [142] [143] 
.const [80] = Class [144] 
.const [81] = NameAndType [145] [146] 
.const [82] = Class [147] 
.const [83] = NameAndType [148] [149] 
.const [84] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/FolderEntrySerializer 
.const [85] = Utf8 putOptionalFolderEntry 
.const [86] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/FolderEntry;)V 
.const [87] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [88] = Utf8 putOptionalMessageListEntry 
.const [89] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/MessageListEntry;)V 
.const [90] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListEntrySerializer 
.const [91] = Utf8 putOptionalListEntry 
.const [92] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/ListEntry;)V 
.const [93] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/FolderEntrySerializer 
.const [94] = Utf8 getOptionalFolderEntry 
.const [95] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/FolderEntry; 
.const [96] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/MessageListEntrySerializer 
.const [97] = Utf8 getOptionalMessageListEntry 
.const [98] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [99] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListEntrySerializer 
.const [100] = Utf8 getOptionalListEntry 
.const [101] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/ListEntry; 
.const [102] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [103] = Utf8 getListEntryId 
.const [104] = Utf8 ()J 
.const [105] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [106] = Utf8 getType 
.const [107] = Utf8 ()I 
.const [108] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [109] = Utf8 getFolderEntry 
.const [110] = Utf8 ()Lorg/dsi/ifc/messaging/FolderEntry; 
.const [111] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [112] = Utf8 getMessageListEntry 
.const [113] = Utf8 ()Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [121] = Utf8 putBool 
.const [122] = Utf8 (Z)V 
.const [123] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [124] = Utf8 putInt64 
.const [125] = Utf8 (J)V 
.const [126] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [127] = Utf8 putInt32 
.const [128] = Utf8 (I)V 
.const [129] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [130] = Utf8 getBool 
.const [131] = Utf8 ()Z 
.const [132] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [133] = Utf8 getInt64 
.const [134] = Utf8 ()J 
.const [135] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [136] = Utf8 listEntryId 
.const [137] = Utf8 J 
.const [138] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [139] = Utf8 getInt32 
.const [140] = Utf8 ()I 
.const [141] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [142] = Utf8 type 
.const [143] = Utf8 I 
.const [144] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [145] = Utf8 folderEntry 
.const [146] = Utf8 Lorg/dsi/ifc/messaging/FolderEntry; 
.const [147] = Utf8 org/dsi/ifc/messaging/ListEntry 
.const [148] = Utf8 messageListEntry 
.const [149] = Utf8 Lorg/dsi/ifc/messaging/MessageListEntry; 
.const [150] = Utf8 de/esolutions/fw/comm/dsi/messaging/impl/ListEntrySerializer 
.const [151] = Class [150] 
.const [152] = Utf8 java/lang/Object 
.const [153] = Class [152] 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 putOptionalListEntry 
.const [158] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/messaging/ListEntry;)V 
.const [159] = Utf8 putOptionalListEntryVarArray 
.const [160] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/messaging/ListEntry;)V 
.const [161] = Utf8 getOptionalListEntry 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/messaging/ListEntry; 
.const [163] = Utf8 getOptionalListEntryVarArray 
.const [164] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/messaging/ListEntry; 
.end class 
