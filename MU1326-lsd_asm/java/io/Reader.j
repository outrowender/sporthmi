.version 50 0 
.class public super abstract [62] 
.super [64] 
.field protected [65] [66] 

.method protected [68] : [69] 
    .attribute [67] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     aload_0 
L6:     putfield [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [70] : [71] 
    .attribute [67] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_1 
L5:     ifnull L16 
L8:     aload_0 
L9:     aload_1 
L10:    putfield [13] 
L13:    goto L24 
L16:    new [14] 
L19:    dup 
L20:    invokespecial [10] 
L23:    athrow 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public abstract [72] : [73] 
    .attribute [67] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [74] : [75] 
    .attribute [67] .code stack 2 locals 0 
L0:     new [15] 
L3:     dup 
L4:     invokespecial [11] 
L7:     athrow 
L8:     
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [67] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [78] : [79] 
    .attribute [67] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [7] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L27 using L32 
L7:     iconst_1 
L8:     newarray char 
L10:    astore_2 
L11:    aload_0 
L12:    aload_2 
L13:    iconst_0 
L14:    iconst_1 
L15:    invokevirtual [8] 
L18:    iconst_m1 
L19:    if_icmpeq L28 
L22:    aload_2 
L23:    iconst_0 
L24:    caload 
L25:    aload_1 
L26:    monitorexit 
L27:    areturn 
        .catch [0] from L28 to L30 using L32 
L28:    aload_1 
L29:    monitorexit 
L30:    iconst_m1 
L31:    areturn 
        .catch [0] from L32 to L34 using L32 
L32:    aload_1 
L33:    monitorexit 
L34:    athrow 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [80] : [81] 
    .attribute [67] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     aload_1 
L4:     arraylength 
L5:     invokevirtual [8] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public abstract [82] : [83] 
    .attribute [67] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [67] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [86] : [87] 
    .attribute [67] .code stack 2 locals 0 
L0:     new [15] 
L3:     dup 
L4:     invokespecial [11] 
L7:     athrow 
L8:     
    .end code 
.end method 

.method public [88] : [89] 
    .attribute [67] .code stack 4 locals 6 
L0:     lload_1 
L1:     lconst_0 
L2:     lcmp 
L3:     iflt L118 
L6:     aload_0 
L7:     getfield [7] 
L10:    dup 
L11:    astore_3 
L12:    monitorenter 
        .catch [0] from L13 to L64 using L115 
L13:    lconst_0 
L14:    lstore 4 
L16:    lload_1 
L17:    ldc_w [1] 
L20:    lcmp 
L21:    ifge L29 
L24:    lload_1 
L25:    l2i 
L26:    goto L32 
L29:    sipush 512 
L32:    istore 6 
L34:    iload 6 
L36:    newarray char 
L38:    astore 7 
L40:    goto L103 
L43:    aload_0 
L44:    aload 7 
L46:    iconst_0 
L47:    iload 6 
L49:    invokevirtual [8] 
L52:    istore 8 
L54:    iload 8 
L56:    iconst_m1 
L57:    if_icmpne L65 
L60:    lload 4 
L62:    aload_3 
L63:    monitorexit 
L64:    freturn 
        .catch [0] from L65 to L84 using L115 
L65:    lload 4 
L67:    iload 8 
L69:    i2l 
L70:    ladd 
L71:    lstore 4 
L73:    iload 8 
L75:    iload 6 
L77:    if_icmpge L85 
L80:    lload 4 
L82:    aload_3 
L83:    monitorexit 
L84:    freturn 
        .catch [0] from L85 to L114 using L115 
L85:    lload_1 
L86:    lload 4 
L88:    lsub 
L89:    iload 6 
L91:    i2l 
L92:    lcmp 
L93:    ifge L103 
L96:    lload_1 
L97:    lload 4 
L99:    lsub 
L100:   l2i 
L101:   istore 6 
L103:   lload 4 
L105:   lload_1 
L106:   lcmp 
L107:   iflt L43 
L110:   lload 4 
L112:   aload_3 
L113:   monitorexit 
L114:   freturn 
        .catch [0] from L115 to L117 using L115 
L115:   aload_3 
L116:   monitorexit 
L117:   athrow 
L118:   new [16] 
L121:   dup 
L122:   invokespecial [12] 
L125:   athrow 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [18] 
.const [3] = Class [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Field [23] [24] 
.const [8] = Method [25] [26] 
.const [9] = Method [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Class [37] 
.const [15] = Class [38] 
.const [16] = Class [39] 
.const [17] = Int 131072 
.const [18] = Utf8 java/io/Reader 
.const [19] = Utf8 java/lang/Object 
.const [20] = Utf8 java/lang/NullPointerException 
.const [21] = Utf8 java/io/IOException 
.const [22] = Utf8 java/lang/IllegalArgumentException 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Utf8 java/lang/NullPointerException 
.const [38] = Utf8 java/io/IOException 
.const [39] = Utf8 java/lang/IllegalArgumentException 
.const [40] = Utf8 java/io/Reader 
.const [41] = Utf8 lock 
.const [42] = Utf8 Ljava/lang/Object; 
.const [43] = Utf8 java/io/Reader 
.const [44] = Utf8 read 
.const [45] = Utf8 ([CII)I 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 <init> 
.const [48] = Utf8 ()V 
.const [49] = Utf8 java/lang/NullPointerException 
.const [50] = Utf8 <init> 
.const [51] = Utf8 ()V 
.const [52] = Utf8 java/io/IOException 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 java/lang/IllegalArgumentException 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 java/io/Reader 
.const [59] = Utf8 lock 
.const [60] = Utf8 Ljava/lang/Object; 
.const [61] = Utf8 java/io/Reader 
.const [62] = Class [61] 
.const [63] = Utf8 java/lang/Object 
.const [64] = Class [63] 
.const [65] = Utf8 lock 
.const [66] = Utf8 Ljava/lang/Object; 
.const [67] = Utf8 Code 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Ljava/lang/Object;)V 
.const [72] = Utf8 close 
.const [73] = Utf8 ()V 
.const [74] = Utf8 mark 
.const [75] = Utf8 (I)V 
.const [76] = Utf8 markSupported 
.const [77] = Utf8 ()Z 
.const [78] = Utf8 read 
.const [79] = Utf8 ()I 
.const [80] = Utf8 read 
.const [81] = Utf8 ([C)I 
.const [82] = Utf8 read 
.const [83] = Utf8 ([CII)I 
.const [84] = Utf8 ready 
.const [85] = Utf8 ()Z 
.const [86] = Utf8 reset 
.const [87] = Utf8 ()V 
.const [88] = Utf8 skip 
.const [89] = Utf8 (J)J 
.end class 
