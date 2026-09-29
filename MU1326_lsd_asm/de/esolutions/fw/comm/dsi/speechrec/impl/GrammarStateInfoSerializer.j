.version 50 0 
.class public super [99] 
.super [101] 

.method public annotation [103] : [104] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [105] : [106] 
    .attribute [102] .code stack 2 locals 3 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [13] 0 
L17:    iload_2 
L18:    ifne L47 
L21:    aload_1 
L22:    invokevirtual [9] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [14] 0 
L33:    aload_1 
L34:    invokevirtual [10] 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokeinterface [15] 0 
L47:    return 
L48:    
    .end code 
.end method 

.method public static [107] : [108] 
    .attribute [102] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [13] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [14] 0 
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

.method public static [109] : [110] 
    .attribute [102] .code stack 2 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [16] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L47 
L13:    new [17] 
L16:    dup 
L17:    invokespecial [12] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [18] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [19] 
L33:    aload_0 
L34:    invokeinterface [20] 0 
L39:    astore 4 
L41:    aload_1 
L42:    aload 4 
L44:    putfield [21] 
L47:    aload_1 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [111] : [112] 
    .attribute [102] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [16] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [18] 0 
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
.const [2] = Method [22] [23] 
.const [3] = Class [24] 
.const [4] = Method [25] [26] 
.const [5] = Class [27] 
.const [6] = Class [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Method [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = InterfaceMethod [39] [40] 
.const [14] = InterfaceMethod [41] [42] 
.const [15] = InterfaceMethod [43] [44] 
.const [16] = InterfaceMethod [45] [46] 
.const [17] = Class [47] 
.const [18] = InterfaceMethod [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = Field [54] [55] 
.const [22] = Class [56] 
.const [23] = NameAndType [57] [58] 
.const [24] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [25] = Class [59] 
.const [26] = NameAndType [60] [61] 
.const [27] = Utf8 de/esolutions/fw/comm/dsi/speechrec/impl/GrammarStateInfoSerializer 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [30] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [31] = Class [62] 
.const [32] = NameAndType [63] [64] 
.const [33] = Class [65] 
.const [34] = NameAndType [66] [67] 
.const [35] = Class [68] 
.const [36] = NameAndType [69] [70] 
.const [37] = Class [71] 
.const [38] = NameAndType [72] [73] 
.const [39] = Class [74] 
.const [40] = NameAndType [75] [76] 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Utf8 de/esolutions/fw/comm/dsi/speechrec/impl/GrammarStateInfoSerializer 
.const [57] = Utf8 putOptionalGrammarStateInfo 
.const [58] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/speechrec/GrammarStateInfo;)V 
.const [59] = Utf8 de/esolutions/fw/comm/dsi/speechrec/impl/GrammarStateInfoSerializer 
.const [60] = Utf8 getOptionalGrammarStateInfo 
.const [61] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/speechrec/GrammarStateInfo; 
.const [62] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [63] = Utf8 getGrammarStatus 
.const [64] = Utf8 ()I 
.const [65] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [66] = Utf8 getSlotIds 
.const [67] = Utf8 ()[I 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [72] = Utf8 <init> 
.const [73] = Utf8 ()V 
.const [74] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [75] = Utf8 putBool 
.const [76] = Utf8 (Z)V 
.const [77] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [78] = Utf8 putInt32 
.const [79] = Utf8 (I)V 
.const [80] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [81] = Utf8 putOptionalInt32VarArray 
.const [82] = Utf8 ([I)V 
.const [83] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [84] = Utf8 getBool 
.const [85] = Utf8 ()Z 
.const [86] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [87] = Utf8 getInt32 
.const [88] = Utf8 ()I 
.const [89] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [90] = Utf8 grammarStatus 
.const [91] = Utf8 I 
.const [92] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [93] = Utf8 getOptionalInt32VarArray 
.const [94] = Utf8 ()[I 
.const [95] = Utf8 org/dsi/ifc/speechrec/GrammarStateInfo 
.const [96] = Utf8 slotIds 
.const [97] = Utf8 [I 
.const [98] = Utf8 de/esolutions/fw/comm/dsi/speechrec/impl/GrammarStateInfoSerializer 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 putOptionalGrammarStateInfo 
.const [106] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/speechrec/GrammarStateInfo;)V 
.const [107] = Utf8 putOptionalGrammarStateInfoVarArray 
.const [108] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/speechrec/GrammarStateInfo;)V 
.const [109] = Utf8 getOptionalGrammarStateInfo 
.const [110] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/speechrec/GrammarStateInfo; 
.const [111] = Utf8 getOptionalGrammarStateInfoVarArray 
.const [112] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/speechrec/GrammarStateInfo; 
.end class 
