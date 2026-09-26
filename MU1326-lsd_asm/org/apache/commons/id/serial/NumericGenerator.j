.version 50 0 
.class public super [65] 
.super [67] 
.implements [69] 
.field private static final [70] [71] 
.field private [72] [73] 
.field private [74] [75] 

.method public [77] : [78] 
    .attribute [76] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     lconst_0 
L6:     putfield [13] 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [14] 
L14:    aload_0 
L15:    lload_2 
L16:    putfield [13] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     i2l 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [76] .code stack 2 locals 0 
L0:     lconst_1 
L1:     freturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [83] : [84] 
    .attribute [76] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [76] .code stack 7 locals 5 
L0:     lconst_0 
L1:     lstore_1 
L2:     aload_0 
L3:     getfield [10] 
L6:     ifeq L40 
L9:     aload_0 
L10:    dup 
L11:    astore_3 
L12:    monitorenter 
        .catch [0] from L13 to L27 using L30 
L13:    aload_0 
L14:    dup 
L15:    getfield [9] 
L18:    dup2_x1 
L19:    lconst_1 
L20:    ladd 
L21:    putfield [13] 
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
L45:    getfield [9] 
L48:    ldc2_w [16] 
L51:    lcmp 
L52:    ifne L65 
L55:    new [15] 
L58:    dup 
L59:    ldc [4] 
L61:    invokespecial [12] 
L64:    athrow 
L65:    aload_0 
L66:    dup 
L67:    getfield [9] 
L70:    dup2_x1 
L71:    lconst_1 
L72:    ladd 
L73:    putfield [13] 
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
L89:    lload_1 
L90:    invokestatic [5] 
L93:    areturn 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [18] [19] 
.const [3] = Class [20] 
.const [4] = String [21] 
.const [5] = Method [22] [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Field [27] [28] 
.const [10] = Field [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Class [39] 
.const [16] = Long 9223372036854775807L 
.const [18] = Class [40] 
.const [19] = NameAndType [41] [42] 
.const [20] = Utf8 java/lang/IllegalStateException 
.const [21] = Utf8 'The maximum number of identifiers has been reached' 
.const [22] = Class [43] 
.const [23] = NameAndType [44] [45] 
.const [24] = Utf8 org/apache/commons/id/serial/NumericGenerator 
.const [25] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [26] = Utf8 java/lang/Long 
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
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Utf8 java/lang/IllegalStateException 
.const [40] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [41] = Utf8 MAX_LONG_NUMERIC_VALUE_LENGTH 
.const [42] = Utf8 I 
.const [43] = Utf8 java/lang/Long 
.const [44] = Utf8 toString 
.const [45] = Utf8 (J)Ljava/lang/String; 
.const [46] = Utf8 org/apache/commons/id/serial/NumericGenerator 
.const [47] = Utf8 count 
.const [48] = Utf8 J 
.const [49] = Utf8 org/apache/commons/id/serial/NumericGenerator 
.const [50] = Utf8 wrapping 
.const [51] = Utf8 Z 
.const [52] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 java/lang/IllegalStateException 
.const [56] = Utf8 <init> 
.const [57] = Utf8 (Ljava/lang/String;)V 
.const [58] = Utf8 org/apache/commons/id/serial/NumericGenerator 
.const [59] = Utf8 count 
.const [60] = Utf8 J 
.const [61] = Utf8 org/apache/commons/id/serial/NumericGenerator 
.const [62] = Utf8 wrapping 
.const [63] = Utf8 Z 
.const [64] = Utf8 org/apache/commons/id/serial/NumericGenerator 
.const [65] = Class [64] 
.const [66] = Utf8 org/apache/commons/id/AbstractStringIdentifierGenerator 
.const [67] = Class [66] 
.const [68] = Utf8 java/io/Serializable 
.const [69] = Class [68] 
.const [70] = Utf8 serialVersionUID 
.const [71] = Utf8 J 
.const [72] = Utf8 wrapping 
.const [73] = Utf8 Z 
.const [74] = Utf8 count 
.const [75] = Utf8 J 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (ZJ)V 
.const [79] = Utf8 maxLength 
.const [80] = Utf8 ()J 
.const [81] = Utf8 minLength 
.const [82] = Utf8 ()J 
.const [83] = Utf8 isWrap 
.const [84] = Utf8 ()Z 
.const [85] = Utf8 setWrap 
.const [86] = Utf8 (Z)V 
.const [87] = Utf8 nextStringIdentifier 
.const [88] = Utf8 ()Ljava/lang/String; 
.end class 
