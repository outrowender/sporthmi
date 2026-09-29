.version 50 0 
.class public super [45] 
.super [47] 
.field public static final [48] [49] 

.method public annotation [51] : [52] 
    .attribute [50] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [53] : [54] 
    .attribute [50] .code stack 3 locals 3 
L0:     iload_2 
L1:     istore 4 
L3:     aload_0 
L4:     aload_1 
L5:     invokevirtual [8] 
L8:     astore 5 
L10:    aload 5 
L12:    ifnonnull L27 
L15:    aload_0 
L16:    aload_1 
L17:    iload 4 
L19:    invokevirtual [9] 
L22:    istore 4 
L24:    goto L80 
L27:    aload 5 
L29:    invokevirtual [10] 
L32:    astore 6 
L34:    aload 6 
L36:    ldc [2] 
L38:    invokevirtual [11] 
L41:    ifeq L50 
L44:    iconst_1 
L45:    istore 4 
L47:    goto L80 
L50:    aload 6 
L52:    ldc [3] 
L54:    invokevirtual [11] 
L57:    ifeq L67 
L60:    bipush 10 
L62:    istore 4 
L64:    goto L80 
L67:    aload 6 
L69:    ldc [4] 
L71:    invokevirtual [11] 
L74:    ifeq L80 
L77:    iconst_5 
L78:    istore 4 
L80:    iload_3 
L81:    ifeq L92 
L84:    iload 4 
L86:    iconst_m1 
L87:    if_icmpne L92 
L90:    iconst_m1 
L91:    areturn 
L92:    iload 4 
L94:    iconst_1 
L95:    if_icmpge L104 
L98:    iconst_1 
L99:    istore 4 
L101:   goto L115 
L104:   iload 4 
L106:   bipush 10 
L108:   if_icmple L115 
L111:   bipush 10 
L113:   istore 4 
L115:   iload 4 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [13] 
.const [3] = String [14] 
.const [4] = String [15] 
.const [5] = Class [16] 
.const [6] = Class [17] 
.const [7] = Class [18] 
.const [8] = Method [19] [20] 
.const [9] = Method [21] [22] 
.const [10] = Method [23] [24] 
.const [11] = Method [25] [26] 
.const [12] = Method [27] [28] 
.const [13] = Utf8 min 
.const [14] = Utf8 max 
.const [15] = Utf8 norm 
.const [16] = Utf8 java/lang/Object 
.const [17] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [18] = Utf8 java/lang/String 
.const [19] = Class [29] 
.const [20] = NameAndType [30] [31] 
.const [21] = Class [32] 
.const [22] = NameAndType [33] [34] 
.const [23] = Class [35] 
.const [24] = NameAndType [36] [37] 
.const [25] = Class [38] 
.const [26] = NameAndType [39] [40] 
.const [27] = Class [41] 
.const [28] = NameAndType [42] [43] 
.const [29] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [30] = Utf8 getStringValue 
.const [31] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [32] = Utf8 de/esolutions/fw/util/config/query/ConfigPathQuery 
.const [33] = Utf8 getIntegerValue 
.const [34] = Utf8 (Ljava/lang/String;I)I 
.const [35] = Utf8 java/lang/String 
.const [36] = Utf8 toLowerCase 
.const [37] = Utf8 ()Ljava/lang/String; 
.const [38] = Utf8 java/lang/String 
.const [39] = Utf8 equals 
.const [40] = Utf8 (Ljava/lang/Object;)Z 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 <init> 
.const [43] = Utf8 ()V 
.const [44] = Utf8 de/esolutions/fw/util/config/commons/PriorityParser 
.const [45] = Class [44] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [46] 
.const [48] = Utf8 DISABLED 
.const [49] = Utf8 I 
.const [50] = Utf8 Code 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 parse 
.const [54] = Utf8 (Lde/esolutions/fw/util/config/query/ConfigPathQuery;Ljava/lang/String;IZ)I 
.end class 
