.version 50 0 
.class public super [61] 
.super [63] 
.implements [65] 
.field private static final [66] [67] 
.field private [68] [69] 
.field private [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     lconst_0 
L6:     putfield [12] 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [13] 
L14:    aload_0 
L15:    lload_2 
L16:    putfield [12] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [75] : [76] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [13] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [72] .code stack 7 locals 5 
L0:     lconst_0 
L1:     lstore_1 
L2:     aload_0 
L3:     getfield [8] 
L6:     ifeq L40 
L9:     aload_0 
L10:    dup 
L11:    astore_3 
L12:    monitorenter 
        .catch [0] from L13 to L27 using L30 
L13:    aload_0 
L14:    dup 
L15:    getfield [7] 
L18:    dup2_x1 
L19:    lconst_1 
L20:    ladd 
L21:    putfield [12] 
L24:    lstore_1 
L25:    aload_3 
L26:    monitorexit 
L27:    goto L37 
        .catch [0] from L30 to L34 using L30 
L30:    astore 4 
L32:    aload_3 
L33:    monitorexit 
L34:    aload 4 
L36:    athrow 
L37:    goto L89 
L40:    aload_0 
L41:    dup 
L42:    astore_3 
L43:    monitorenter 
        .catch [0] from L44 to L79 using L82 
L44:    aload_0 
L45:    getfield [7] 
L48:    ldc2_w [16] 
L51:    lcmp 
L52:    ifne L65 
L55:    new [14] 
L58:    dup 
L59:    ldc [3] 
L61:    invokespecial [10] 
L64:    athrow 
L65:    aload_0 
L66:    dup 
L67:    getfield [7] 
L70:    dup2_x1 
L71:    lconst_1 
L72:    ladd 
L73:    putfield [12] 
L76:    lstore_1 
L77:    aload_3 
L78:    monitorexit 
L79:    goto L89 
        .catch [0] from L82 to L86 using L82 
L82:    astore 5 
L84:    aload_3 
L85:    monitorexit 
L86:    aload 5 
L88:    athrow 
L89:    new [15] 
L92:    dup 
L93:    lload_1 
L94:    invokespecial [11] 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [18] 
.const [3] = String [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Field [23] [24] 
.const [8] = Field [25] [26] 
.const [9] = Method [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Field [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Class [37] 
.const [15] = Class [38] 
.const [16] = Long 9223372036854775807L 
.const [18] = Utf8 java/lang/IllegalStateException 
.const [19] = Utf8 'The maximum number of identifiers has been reached' 
.const [20] = Utf8 java/lang/Long 
.const [21] = Utf8 org/apache/commons/id/serial/LongGenerator 
.const [22] = Utf8 org/apache/commons/id/AbstractLongIdentifierGenerator 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Utf8 java/lang/IllegalStateException 
.const [38] = Utf8 java/lang/Long 
.const [39] = Utf8 org/apache/commons/id/serial/LongGenerator 
.const [40] = Utf8 count 
.const [41] = Utf8 J 
.const [42] = Utf8 org/apache/commons/id/serial/LongGenerator 
.const [43] = Utf8 wrapping 
.const [44] = Utf8 Z 
.const [45] = Utf8 org/apache/commons/id/AbstractLongIdentifierGenerator 
.const [46] = Utf8 <init> 
.const [47] = Utf8 ()V 
.const [48] = Utf8 java/lang/IllegalStateException 
.const [49] = Utf8 <init> 
.const [50] = Utf8 (Ljava/lang/String;)V 
.const [51] = Utf8 java/lang/Long 
.const [52] = Utf8 <init> 
.const [53] = Utf8 (J)V 
.const [54] = Utf8 org/apache/commons/id/serial/LongGenerator 
.const [55] = Utf8 count 
.const [56] = Utf8 J 
.const [57] = Utf8 org/apache/commons/id/serial/LongGenerator 
.const [58] = Utf8 wrapping 
.const [59] = Utf8 Z 
.const [60] = Utf8 org/apache/commons/id/serial/LongGenerator 
.const [61] = Class [60] 
.const [62] = Utf8 org/apache/commons/id/AbstractLongIdentifierGenerator 
.const [63] = Class [62] 
.const [64] = Utf8 java/io/Serializable 
.const [65] = Class [64] 
.const [66] = Utf8 serialVersionUID 
.const [67] = Utf8 J 
.const [68] = Utf8 wrapping 
.const [69] = Utf8 Z 
.const [70] = Utf8 count 
.const [71] = Utf8 J 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (ZJ)V 
.const [75] = Utf8 isWrap 
.const [76] = Utf8 ()Z 
.const [77] = Utf8 setWrap 
.const [78] = Utf8 (Z)V 
.const [79] = Utf8 nextLongIdentifier 
.const [80] = Utf8 ()Ljava/lang/Long; 
.end class 
