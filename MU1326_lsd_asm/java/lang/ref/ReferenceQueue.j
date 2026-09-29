.version 50 0 
.class public super [107] 
.super [109] 
.field private [110] [111] 
.field private [112] [113] 
.field private [114] [115] 
.field private [116] [117] 
.field private static final [118] [119] 

.method public [121] : [122] 
    .attribute [120] .code stack 5 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L14 using L84 
L4:     aload_0 
L5:     getfield [8] 
L8:     ifeq L15 
L11:    aconst_null 
L12:    aload_2 
L13:    monitorexit 
L14:    areturn 
        .catch [0] from L15 to L81 using L84 
L15:    aload_0 
L16:    getfield [9] 
L19:    aload_0 
L20:    getfield [10] 
L23:    aaload 
L24:    astore_1 
L25:    aload_0 
L26:    getfield [9] 
L29:    aload_0 
L30:    dup 
L31:    getfield [10] 
L34:    dup_x1 
L35:    iconst_1 
L36:    iadd 
L37:    putfield [20] 
L40:    aconst_null 
L41:    aastore 
L42:    aload_1 
L43:    invokevirtual [11] 
L46:    aload_0 
L47:    getfield [10] 
L50:    aload_0 
L51:    getfield [9] 
L54:    arraylength 
L55:    if_icmpne L63 
L58:    aload_0 
L59:    iconst_0 
L60:    putfield [20] 
L63:    aload_0 
L64:    getfield [10] 
L67:    aload_0 
L68:    getfield [12] 
L71:    if_icmpne L79 
L74:    aload_0 
L75:    iconst_1 
L76:    putfield [18] 
L79:    aload_2 
L80:    monitorexit 
L81:    goto L87 
        .catch [0] from L84 to L86 using L84 
L84:    aload_2 
L85:    monitorexit 
L86:    athrow 
L87:    aload_1 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [120] .code stack 3 locals 0 
L0:     aload_0 
L1:     lconst_0 
L2:     invokevirtual [13] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [120] .code stack 5 locals 2 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     ifge L14 
L6:     new [22] 
L9:     dup 
L10:    invokespecial [14] 
L13:    athrow 
L14:    aload_0 
L15:    dup 
L16:    astore 4 
L18:    monitorenter 
        .catch [0] from L19 to L42 using L120 
L19:    aload_0 
L20:    getfield [8] 
L23:    ifeq L43 
L26:    aload_0 
L27:    lload_1 
L28:    invokespecial [15] 
L31:    aload_0 
L32:    getfield [8] 
L35:    ifeq L43 
L38:    aconst_null 
L39:    aload 4 
L41:    monitorexit 
L42:    areturn 
        .catch [0] from L43 to L117 using L120 
L43:    aload_0 
L44:    getfield [9] 
L47:    aload_0 
L48:    getfield [10] 
L51:    aaload 
L52:    astore_3 
L53:    aload_0 
L54:    getfield [9] 
L57:    aload_0 
L58:    dup 
L59:    getfield [10] 
L62:    dup_x1 
L63:    iconst_1 
L64:    iadd 
L65:    putfield [20] 
L68:    aconst_null 
L69:    aastore 
L70:    aload_3 
L71:    invokevirtual [11] 
L74:    aload_0 
L75:    getfield [10] 
L78:    aload_0 
L79:    getfield [9] 
L82:    arraylength 
L83:    if_icmpne L91 
L86:    aload_0 
L87:    iconst_0 
L88:    putfield [20] 
L91:    aload_0 
L92:    getfield [10] 
L95:    aload_0 
L96:    getfield [12] 
L99:    if_icmpne L110 
L102:   aload_0 
L103:   iconst_1 
L104:   putfield [18] 
L107:   goto L114 
L110:   aload_0 
L111:   invokespecial [16] 
L114:   aload 4 
L116:   monitorexit 
L117:   goto L124 
        .catch [0] from L120 to L123 using L120 
L120:   aload 4 
L122:   monitorexit 
L123:   athrow 
L124:   aload_3 
L125:   areturn 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method [127] : [128] 
    .attribute [120] .code stack 6 locals 3 
L0:     aload_0 
L1:     dup 
L2:     astore_2 
L3:     monitorenter 
        .catch [0] from L4 to L160 using L163 
L4:     aload_0 
L5:     getfield [8] 
L8:     ifne L115 
L11:    aload_0 
L12:    getfield [10] 
L15:    aload_0 
L16:    getfield [12] 
L19:    if_icmpne L115 
L22:    aload_0 
L23:    getfield [9] 
L26:    arraylength 
L27:    i2d 
L28:    ldc2_w [23] 
L31:    dmul 
L32:    d2i 
L33:    istore_3 
L34:    iload_3 
L35:    anewarray [4] 
L38:    astore 4 
L40:    aload_0 
L41:    getfield [9] 
L44:    aload_0 
L45:    getfield [10] 
L48:    aload 4 
L50:    iconst_0 
L51:    aload_0 
L52:    getfield [9] 
L55:    arraylength 
L56:    aload_0 
L57:    getfield [10] 
L60:    isub 
L61:    invokestatic [7] 
L64:    aload_0 
L65:    getfield [12] 
L68:    ifle L95 
L71:    aload_0 
L72:    getfield [9] 
L75:    iconst_0 
L76:    aload 4 
L78:    aload_0 
L79:    getfield [9] 
L82:    arraylength 
L83:    aload_0 
L84:    getfield [10] 
L87:    isub 
L88:    aload_0 
L89:    getfield [12] 
L92:    invokestatic [7] 
L95:    aload_0 
L96:    iconst_0 
L97:    putfield [20] 
L100:   aload_0 
L101:   aload_0 
L102:   getfield [9] 
L105:   arraylength 
L106:   putfield [21] 
L109:   aload_0 
L110:   aload 4 
L112:   putfield [19] 
L115:   aload_0 
L116:   getfield [9] 
L119:   aload_0 
L120:   dup 
L121:   getfield [12] 
L124:   dup_x1 
L125:   iconst_1 
L126:   iadd 
L127:   putfield [21] 
L130:   aload_1 
L131:   aastore 
L132:   aload_0 
L133:   getfield [12] 
L136:   aload_0 
L137:   getfield [9] 
L140:   arraylength 
L141:   if_icmpne L149 
L144:   aload_0 
L145:   iconst_0 
L146:   putfield [21] 
L149:   aload_0 
L150:   iconst_0 
L151:   putfield [18] 
L154:   aload_0 
L155:   invokespecial [16] 
L158:   aload_2 
L159:   monitorexit 
L160:   goto L166 
        .catch [0] from L163 to L165 using L163 
L163:   aload_2 
L164:   monitorexit 
L165:   athrow 
L166:   iconst_1 
L167:   areturn 
L168:   
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [120] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     sipush 128 
L8:     anewarray [4] 
L11:    putfield [19] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [20] 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [21] 
L24:    aload_0 
L25:    iconst_1 
L26:    putfield [18] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Class [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Method [30] [31] 
.const [8] = Field [32] [33] 
.const [9] = Field [34] [35] 
.const [10] = Field [36] [37] 
.const [11] = Method [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Class [60] 
.const [23] = Double +0x1199999999999Ap-52 
.const [25] = Utf8 java/lang/ref/ReferenceQueue 
.const [26] = Utf8 java/lang/Object 
.const [27] = Utf8 java/lang/ref/Reference 
.const [28] = Utf8 java/lang/IllegalArgumentException 
.const [29] = Utf8 java/lang/System 
.const [30] = Class [61] 
.const [31] = NameAndType [62] [63] 
.const [32] = Class [64] 
.const [33] = NameAndType [65] [66] 
.const [34] = Class [67] 
.const [35] = NameAndType [68] [69] 
.const [36] = Class [70] 
.const [37] = NameAndType [71] [72] 
.const [38] = Class [73] 
.const [39] = NameAndType [74] [75] 
.const [40] = Class [76] 
.const [41] = NameAndType [77] [78] 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Utf8 java/lang/IllegalArgumentException 
.const [61] = Utf8 java/lang/System 
.const [62] = Utf8 arraycopy 
.const [63] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [64] = Utf8 java/lang/ref/ReferenceQueue 
.const [65] = Utf8 empty 
.const [66] = Utf8 Z 
.const [67] = Utf8 java/lang/ref/ReferenceQueue 
.const [68] = Utf8 references 
.const [69] = Utf8 [Ljava/lang/ref/Reference; 
.const [70] = Utf8 java/lang/ref/ReferenceQueue 
.const [71] = Utf8 head 
.const [72] = Utf8 I 
.const [73] = Utf8 java/lang/ref/Reference 
.const [74] = Utf8 dequeue 
.const [75] = Utf8 ()V 
.const [76] = Utf8 java/lang/ref/ReferenceQueue 
.const [77] = Utf8 tail 
.const [78] = Utf8 I 
.const [79] = Utf8 java/lang/ref/ReferenceQueue 
.const [80] = Utf8 remove 
.const [81] = Utf8 (J)Ljava/lang/ref/Reference; 
.const [82] = Utf8 java/lang/IllegalArgumentException 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 wait 
.const [87] = Utf8 (J)V 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 notifyAll 
.const [90] = Utf8 ()V 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 java/lang/ref/ReferenceQueue 
.const [95] = Utf8 empty 
.const [96] = Utf8 Z 
.const [97] = Utf8 java/lang/ref/ReferenceQueue 
.const [98] = Utf8 references 
.const [99] = Utf8 [Ljava/lang/ref/Reference; 
.const [100] = Utf8 java/lang/ref/ReferenceQueue 
.const [101] = Utf8 head 
.const [102] = Utf8 I 
.const [103] = Utf8 java/lang/ref/ReferenceQueue 
.const [104] = Utf8 tail 
.const [105] = Utf8 I 
.const [106] = Utf8 java/lang/ref/ReferenceQueue 
.const [107] = Class [106] 
.const [108] = Utf8 java/lang/Object 
.const [109] = Class [108] 
.const [110] = Utf8 references 
.const [111] = Utf8 [Ljava/lang/ref/Reference; 
.const [112] = Utf8 head 
.const [113] = Utf8 I 
.const [114] = Utf8 tail 
.const [115] = Utf8 I 
.const [116] = Utf8 empty 
.const [117] = Utf8 Z 
.const [118] = Utf8 DEFAULT_QUEUE_SIZE 
.const [119] = Utf8 I 
.const [120] = Utf8 Code 
.const [121] = Utf8 poll 
.const [122] = Utf8 ()Ljava/lang/ref/Reference; 
.const [123] = Utf8 remove 
.const [124] = Utf8 ()Ljava/lang/ref/Reference; 
.const [125] = Utf8 remove 
.const [126] = Utf8 (J)Ljava/lang/ref/Reference; 
.const [127] = Utf8 enqueue 
.const [128] = Utf8 (Ljava/lang/ref/Reference;)Z 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.end class 
