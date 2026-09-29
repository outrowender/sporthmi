.version 50 0 
.class super [87] 
.super [89] 
.field private static [90] [91] 

.method static [93] : [94] 
    .attribute [92] .code stack 1 locals 1 
L0:     ldc [4] 
L2:     invokestatic [6] 
L5:     astore_0 
L6:     aload_0 
L7:     ifnonnull L13 
L10:    ldc [7] 
L12:    astore_0 
L13:    aload_0 
L14:    invokestatic [9] 
L17:    putstatic [20] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [21] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [92] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnonnull L7 
L4:     ldc [11] 
L6:     astore_1 
        .catch [16] from L7 to L32 using L32 
L7:     aload_0 
L8:     getstatic [10] 
L11:    aload_1 
L12:    invokestatic [13] 
L15:    aload_1 
L16:    invokestatic [14] 
L19:    aload_1 
L20:    invokestatic [15] 
L23:    invokevirtual [17] 
L26:    invokevirtual [18] 
L29:    goto L37 
L32:    pop 
L33:    aload_0 
L34:    invokevirtual [19] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = String [24] 
.const [5] = Class [25] 
.const [6] = Method [26] [27] 
.const [7] = String [28] 
.const [8] = Class [29] 
.const [9] = Method [30] [31] 
.const [10] = Field [32] [33] 
.const [11] = String [34] 
.const [12] = Class [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Class [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Utf8 java/lang/String$ConsolePrintStream 
.const [23] = Utf8 java/io/PrintStream 
.const [24] = Utf8 'console.encoding' 
.const [25] = Utf8 java/lang/System 
.const [26] = Class [53] 
.const [27] = NameAndType [54] [55] 
.const [28] = Utf8 ISO8859_1 
.const [29] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [30] = Class [56] 
.const [31] = NameAndType [57] [58] 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Utf8 null 
.const [35] = Utf8 java/lang/String 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Utf8 java/io/IOException 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Utf8 java/lang/System 
.const [54] = Utf8 getProperty 
.const [55] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [56] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [57] = Utf8 getDefaultConverter 
.const [58] = Utf8 (Ljava/lang/String;)Lcom/ibm/oti/io/CharacterConverter; 
.const [59] = Utf8 java/lang/String$ConsolePrintStream 
.const [60] = Utf8 converter 
.const [61] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [62] = Utf8 java/lang/String 
.const [63] = Utf8 access$0 
.const [64] = Utf8 (Ljava/lang/String;)[C 
.const [65] = Utf8 java/lang/String 
.const [66] = Utf8 access$1 
.const [67] = Utf8 (Ljava/lang/String;)I 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 access$2 
.const [70] = Utf8 (Ljava/lang/String;)I 
.const [71] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [72] = Utf8 convert 
.const [73] = Utf8 ([CII)[B 
.const [74] = Utf8 java/lang/String$ConsolePrintStream 
.const [75] = Utf8 write 
.const [76] = Utf8 ([B)V 
.const [77] = Utf8 java/lang/String$ConsolePrintStream 
.const [78] = Utf8 setError 
.const [79] = Utf8 ()V 
.const [80] = Utf8 java/lang/String$ConsolePrintStream 
.const [81] = Utf8 converter 
.const [82] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [83] = Utf8 java/io/PrintStream 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Ljava/io/OutputStream;Z)V 
.const [86] = Utf8 java/lang/String$ConsolePrintStream 
.const [87] = Class [86] 
.const [88] = Utf8 java/io/PrintStream 
.const [89] = Class [88] 
.const [90] = Utf8 converter 
.const [91] = Utf8 Lcom/ibm/oti/io/CharacterConverter; 
.const [92] = Utf8 Code 
.const [93] = Utf8 <clinit> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Ljava/io/OutputStream;)V 
.const [97] = Utf8 print 
.const [98] = Utf8 (Ljava/lang/String;)V 
.end class 
