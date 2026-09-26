.version 50 0 
.class public super [87] 
.super [89] 
.field public [90] [91] 
.field public [92] [93] 
.field public [94] [95] 
.field public [96] [97] 
.field public [98] [99] 
.field public [100] [101] 

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

.method public [105] : [106] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [12] 
L5:     aload_0 
L6:     aconst_null 
L7:     putfield [13] 
L10:    aload_0 
L11:    aconst_null 
L12:    putfield [14] 
L15:    aload_0 
L16:    aconst_null 
L17:    putfield [15] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     ifnonnull L12 
L7:     aload_0 
L8:     getfield [6] 
L11:    areturn 
L12:    aload_0 
L13:    getfield [7] 
L16:    invokevirtual [8] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public static [109] : [110] 
    .attribute [102] .code stack 2 locals 9 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokestatic [2] 
L7:     istore_2 
L8:     aload_1 
L9:     getfield [9] 
L12:    invokestatic [2] 
L15:    istore_3 
L16:    iload_2 
L17:    iload_3 
L18:    if_icmpeq L47 
L21:    iload_2 
L22:    iconst_1 
L23:    if_icmpne L31 
L26:    iload_3 
L27:    iconst_2 
L28:    if_icmpeq L41 
L31:    iload_2 
L32:    iconst_2 
L33:    if_icmpne L45 
L36:    iload_3 
L37:    iconst_1 
L38:    if_icmpne L45 
L41:    iconst_1 
L42:    goto L46 
L45:    iconst_0 
L46:    areturn 
L47:    iload_2 
L48:    bipush 44 
L50:    if_icmpeq L59 
L53:    iload_2 
L54:    bipush 43 
L56:    if_icmpne L196 
L59:    aload_0 
L60:    getfield [10] 
L63:    astore 4 
L65:    aload_1 
L66:    getfield [10] 
L69:    astore 5 
L71:    aload 4 
L73:    ifnull L86 
L76:    aload 4 
L78:    invokeinterface [16] 0 
L83:    goto L87 
L86:    iconst_0 
L87:    istore 6 
L89:    aload 5 
L91:    ifnull L104 
L94:    aload 5 
L96:    invokeinterface [16] 0 
L101:   goto L105 
L104:   iconst_0 
L105:   istore 7 
L107:   iload 6 
L109:   iload 7 
L111:   if_icmpeq L116 
L114:   iconst_0 
L115:   areturn 
L116:   iconst_0 
L117:   istore 8 
L119:   iload 8 
L121:   iload 6 
L123:   if_icmpge L196 
L126:   aload 4 
L128:   iload 8 
L130:   invokeinterface [17] 0 
L135:   invokestatic [2] 
L138:   istore 9 
L140:   aload 5 
L142:   iload 8 
L144:   invokeinterface [17] 0 
L149:   invokestatic [2] 
L152:   istore 10 
L154:   iload 9 
L156:   iload 10 
L158:   if_icmpeq L190 
L161:   iload 9 
L163:   iconst_1 
L164:   if_icmpne L173 
L167:   iload 10 
L169:   iconst_2 
L170:   if_icmpeq L190 
L173:   iload 9 
L175:   iconst_2 
L176:   if_icmpne L188 
L179:   iload 10 
L181:   iconst_1 
L182:   if_icmpne L188 
L185:   goto L190 
L188:   iconst_0 
L189:   areturn 
L190:   iinc 8 1 
L193:   goto L119 
L196:   iconst_1 
L197:   areturn 
L198:   nop 
L199:   nop 
L200:   
    .end code 
.end method 

.method private static [111] : [112] 
    .attribute [102] .code stack 2 locals 0 
L0:     iload_0 
L1:     bipush 20 
L3:     if_icmpgt L8 
L6:     iload_0 
L7:     areturn 
L8:     iload_0 
L9:     bipush 29 
L11:    if_icmpgt L16 
L14:    iconst_2 
L15:    areturn 
L16:    iload_0 
L17:    bipush 42 
L19:    if_icmpgt L24 
L22:    iconst_4 
L23:    areturn 
L24:    iload_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [18] [19] 
.const [3] = Class [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = Field [23] [24] 
.const [7] = Field [25] [26] 
.const [8] = Method [27] [28] 
.const [9] = Field [29] [30] 
.const [10] = Field [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Field [37] [38] 
.const [14] = Field [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = InterfaceMethod [43] [44] 
.const [17] = InterfaceMethod [45] [46] 
.const [18] = Class [47] 
.const [19] = NameAndType [48] [49] 
.const [20] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 org/apache/xerces/xs/ShortList 
.const [23] = Class [50] 
.const [24] = NameAndType [51] [52] 
.const [25] = Class [53] 
.const [26] = NameAndType [54] [55] 
.const [27] = Class [56] 
.const [28] = NameAndType [57] [58] 
.const [29] = Class [59] 
.const [30] = NameAndType [60] [61] 
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
.const [47] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [48] = Utf8 convertToPrimitiveKind 
.const [49] = Utf8 (S)S 
.const [50] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [51] = Utf8 normalizedValue 
.const [52] = Utf8 Ljava/lang/String; 
.const [53] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [54] = Utf8 actualValue 
.const [55] = Utf8 Ljava/lang/Object; 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 toString 
.const [58] = Utf8 ()Ljava/lang/String; 
.const [59] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [60] = Utf8 actualValueType 
.const [61] = Utf8 S 
.const [62] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [63] = Utf8 itemValueTypes 
.const [64] = Utf8 Lorg/apache/xerces/xs/ShortList; 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [69] = Utf8 normalizedValue 
.const [70] = Utf8 Ljava/lang/String; 
.const [71] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [72] = Utf8 actualValue 
.const [73] = Utf8 Ljava/lang/Object; 
.const [74] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [75] = Utf8 memberType 
.const [76] = Utf8 Lorg/apache/xerces/impl/dv/XSSimpleType; 
.const [77] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [78] = Utf8 memberTypes 
.const [79] = Utf8 [Lorg/apache/xerces/impl/dv/XSSimpleType; 
.const [80] = Utf8 org/apache/xerces/xs/ShortList 
.const [81] = Utf8 getLength 
.const [82] = Utf8 ()I 
.const [83] = Utf8 org/apache/xerces/xs/ShortList 
.const [84] = Utf8 item 
.const [85] = Utf8 (I)S 
.const [86] = Utf8 org/apache/xerces/impl/dv/ValidatedInfo 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 normalizedValue 
.const [91] = Utf8 Ljava/lang/String; 
.const [92] = Utf8 actualValue 
.const [93] = Utf8 Ljava/lang/Object; 
.const [94] = Utf8 actualValueType 
.const [95] = Utf8 S 
.const [96] = Utf8 memberType 
.const [97] = Utf8 Lorg/apache/xerces/impl/dv/XSSimpleType; 
.const [98] = Utf8 memberTypes 
.const [99] = Utf8 [Lorg/apache/xerces/impl/dv/XSSimpleType; 
.const [100] = Utf8 itemValueTypes 
.const [101] = Utf8 Lorg/apache/xerces/xs/ShortList; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 reset 
.const [106] = Utf8 ()V 
.const [107] = Utf8 stringValue 
.const [108] = Utf8 ()Ljava/lang/String; 
.const [109] = Utf8 isComparable 
.const [110] = Utf8 (Lorg/apache/xerces/impl/dv/ValidatedInfo;Lorg/apache/xerces/impl/dv/ValidatedInfo;)Z 
.const [111] = Utf8 convertToPrimitiveKind 
.const [112] = Utf8 (S)S 
.end class 
