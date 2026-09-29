.version 50 0 
.class final super [119] 
.super [121] 
.field private static final [122] [123] 
.field public [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     new [24] 
L8:     dup 
L9:     invokespecial [21] 
L12:    putfield [25] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [126] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     ifeq L15 
L7:     new [26] 
L10:    dup 
L11:    invokespecial [22] 
L14:    athrow 
L15:    aload_1 
L16:    instanceof [6] 
L19:    ifne L34 
L22:    new [27] 
L25:    dup 
L26:    aload_1 
L27:    invokevirtual [11] 
L30:    invokespecial [23] 
L33:    athrow 
L34:    aload_0 
L35:    getfield [9] 
L38:    aload_1 
L39:    invokevirtual [12] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokevirtual [13] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [126] .code stack 2 locals 6 
L0:     aload_1 
L1:     instanceof [6] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_1 
L10:    checkcast [6] 
L13:    astore_3 
L14:    aload_3 
L15:    getfield [14] 
L18:    istore 4 
L20:    iconst_0 
L21:    istore 5 
L23:    iconst_0 
L24:    istore 6 
L26:    aload_0 
L27:    getfield [9] 
L30:    invokevirtual [15] 
L33:    istore 7 
L35:    goto L151 
L38:    aload_0 
L39:    getfield [9] 
L42:    iload 6 
L44:    invokevirtual [16] 
L47:    checkcast [6] 
L50:    astore_2 
L51:    aload_2 
L52:    aload_3 
L53:    invokevirtual [17] 
L56:    ifeq L148 
L59:    aload_2 
L60:    getfield [14] 
L63:    bipush 8 
L65:    iand 
L66:    bipush 8 
L68:    if_icmpne L78 
L71:    iload 5 
L73:    bipush 8 
L75:    ior 
L76:    istore 5 
L78:    aload_3 
L79:    getfield [18] 
L82:    aload_2 
L83:    getfield [18] 
L86:    if_icmplt L148 
L89:    aload_3 
L90:    getfield [19] 
L93:    aload_2 
L94:    getfield [19] 
L97:    if_icmpgt L148 
L100:   aload_2 
L101:   getfield [14] 
L104:   iconst_1 
L105:   iand 
L106:   iconst_1 
L107:   if_icmpne L116 
L110:   iload 5 
L112:   iconst_1 
L113:   ior 
L114:   istore 5 
L116:   aload_2 
L117:   getfield [14] 
L120:   iconst_4 
L121:   iand 
L122:   iconst_4 
L123:   if_icmpne L132 
L126:   iload 5 
L128:   iconst_4 
L129:   ior 
L130:   istore 5 
L132:   aload_2 
L133:   getfield [14] 
L136:   iconst_2 
L137:   iand 
L138:   iconst_2 
L139:   if_icmpne L148 
L142:   iload 5 
L144:   iconst_2 
L145:   ior 
L146:   istore 5 
L148:   iinc 6 1 
L151:   iload 6 
L153:   iload 7 
L155:   if_icmpge L168 
L158:   iload 5 
L160:   iload 4 
L162:   iand 
L163:   iload 4 
L165:   if_icmpne L38 
L168:   iload 5 
L170:   iload 4 
L172:   iand 
L173:   iload 4 
L175:   if_icmpne L180 
L178:   iconst_1 
L179:   areturn 
L180:   iconst_0 
L181:   areturn 
L182:   nop 
L183:   nop 
L184:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = Class [30] 
.const [5] = Class [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Field [35] [36] 
.const [10] = Method [37] [38] 
.const [11] = Method [39] [40] 
.const [12] = Method [41] [42] 
.const [13] = Method [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Field [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Class [65] 
.const [25] = Field [66] [67] 
.const [26] = Class [68] 
.const [27] = Class [69] 
.const [28] = Utf8 java/net/SocketPermissionCollection 
.const [29] = Utf8 java/security/PermissionCollection 
.const [30] = Utf8 java/util/Vector 
.const [31] = Utf8 java/lang/IllegalStateException 
.const [32] = Utf8 java/net/SocketPermission 
.const [33] = Utf8 java/lang/IllegalArgumentException 
.const [34] = Utf8 java/security/Permission 
.const [35] = Class [70] 
.const [36] = NameAndType [71] [72] 
.const [37] = Class [73] 
.const [38] = NameAndType [74] [75] 
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
.const [55] = Class [100] 
.const [56] = NameAndType [101] [102] 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Utf8 java/util/Vector 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Utf8 java/lang/IllegalStateException 
.const [69] = Utf8 java/lang/IllegalArgumentException 
.const [70] = Utf8 java/net/SocketPermissionCollection 
.const [71] = Utf8 permissions 
.const [72] = Utf8 Ljava/util/Vector; 
.const [73] = Utf8 java/net/SocketPermissionCollection 
.const [74] = Utf8 isReadOnly 
.const [75] = Utf8 ()Z 
.const [76] = Utf8 java/security/Permission 
.const [77] = Utf8 toString 
.const [78] = Utf8 ()Ljava/lang/String; 
.const [79] = Utf8 java/util/Vector 
.const [80] = Utf8 addElement 
.const [81] = Utf8 (Ljava/lang/Object;)V 
.const [82] = Utf8 java/util/Vector 
.const [83] = Utf8 elements 
.const [84] = Utf8 ()Ljava/util/Enumeration; 
.const [85] = Utf8 java/net/SocketPermission 
.const [86] = Utf8 actionsMask 
.const [87] = Utf8 I 
.const [88] = Utf8 java/util/Vector 
.const [89] = Utf8 size 
.const [90] = Utf8 ()I 
.const [91] = Utf8 java/util/Vector 
.const [92] = Utf8 elementAt 
.const [93] = Utf8 (I)Ljava/lang/Object; 
.const [94] = Utf8 java/net/SocketPermission 
.const [95] = Utf8 checkHost 
.const [96] = Utf8 (Ljava/net/SocketPermission;)Z 
.const [97] = Utf8 java/net/SocketPermission 
.const [98] = Utf8 portMin 
.const [99] = Utf8 I 
.const [100] = Utf8 java/net/SocketPermission 
.const [101] = Utf8 portMax 
.const [102] = Utf8 I 
.const [103] = Utf8 java/security/PermissionCollection 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 java/util/Vector 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 java/lang/IllegalStateException 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 java/lang/IllegalArgumentException 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Ljava/lang/String;)V 
.const [115] = Utf8 java/net/SocketPermissionCollection 
.const [116] = Utf8 permissions 
.const [117] = Utf8 Ljava/util/Vector; 
.const [118] = Utf8 java/net/SocketPermissionCollection 
.const [119] = Class [118] 
.const [120] = Utf8 java/security/PermissionCollection 
.const [121] = Class [120] 
.const [122] = Utf8 serialVersionUID 
.const [123] = Utf8 J 
.const [124] = Utf8 permissions 
.const [125] = Utf8 Ljava/util/Vector; 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 add 
.const [130] = Utf8 (Ljava/security/Permission;)V 
.const [131] = Utf8 elements 
.const [132] = Utf8 ()Ljava/util/Enumeration; 
.const [133] = Utf8 implies 
.const [134] = Utf8 (Ljava/security/Permission;)Z 
.end class 
