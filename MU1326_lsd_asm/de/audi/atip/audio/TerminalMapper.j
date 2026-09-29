.version 50 0 
.class public final super [61] 
.super [63] 
.field public static final [64] [65] 

.method public static [67] : [68] 
    .attribute [66] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 2 
            L32 
            L32 
            L32 
            L32 
            default : L34 

L32:    iconst_2 
L33:    areturn 
L34:    iconst_1 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public static [69] : [70] 
    .attribute [66] .code stack 4 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L36 
            L36 
            L42 
            L38 
            L40 
            default : L44 

L36:    iconst_0 
L37:    areturn 
L38:    iconst_3 
L39:    areturn 
L40:    iconst_4 
L41:    areturn 
L42:    iconst_2 
L43:    areturn 
L44:    new [14] 
L47:    dup 
L48:    new [15] 
L51:    dup 
L52:    invokespecial [10] 
L55:    ldc [4] 
L57:    invokevirtual [7] 
L60:    iload_0 
L61:    invokevirtual [8] 
L64:    invokevirtual [9] 
L67:    invokespecial [11] 
L70:    athrow 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [71] : [72] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     new [16] 
L7:     dup 
L8:     invokespecial [13] 
L11:    athrow 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = String [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Method [22] [23] 
.const [8] = Method [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Class [36] 
.const [15] = Class [37] 
.const [16] = Class [38] 
.const [17] = Utf8 java/lang/IllegalArgumentException 
.const [18] = Utf8 java/lang/StringBuffer 
.const [19] = Utf8 'Unknown audio terminal: ' 
.const [20] = Utf8 java/lang/IllegalAccessError 
.const [21] = Utf8 java/lang/Object 
.const [22] = Class [39] 
.const [23] = NameAndType [40] [41] 
.const [24] = Class [42] 
.const [25] = NameAndType [43] [44] 
.const [26] = Class [45] 
.const [27] = NameAndType [46] [47] 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Utf8 java/lang/IllegalArgumentException 
.const [37] = Utf8 java/lang/StringBuffer 
.const [38] = Utf8 java/lang/IllegalAccessError 
.const [39] = Utf8 java/lang/StringBuffer 
.const [40] = Utf8 append 
.const [41] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [42] = Utf8 java/lang/StringBuffer 
.const [43] = Utf8 append 
.const [44] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [45] = Utf8 java/lang/StringBuffer 
.const [46] = Utf8 toString 
.const [47] = Utf8 ()Ljava/lang/String; 
.const [48] = Utf8 java/lang/StringBuffer 
.const [49] = Utf8 <init> 
.const [50] = Utf8 ()V 
.const [51] = Utf8 java/lang/IllegalArgumentException 
.const [52] = Utf8 <init> 
.const [53] = Utf8 (Ljava/lang/String;)V 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 java/lang/IllegalAccessError 
.const [58] = Utf8 <init> 
.const [59] = Utf8 ()V 
.const [60] = Utf8 de/audi/atip/audio/TerminalMapper 
.const [61] = Class [60] 
.const [62] = Utf8 java/lang/Object 
.const [63] = Class [62] 
.const [64] = Utf8 OLD_CONN_LIMIT 
.const [65] = Utf8 I 
.const [66] = Utf8 Code 
.const [67] = Utf8 toAudioTerminal 
.const [68] = Utf8 (I)I 
.const [69] = Utf8 toHmiTerminal 
.const [70] = Utf8 (I)I 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.end class 
