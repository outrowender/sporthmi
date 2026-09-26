.version 50 0 
.class final super [113] 
.super [115] 
.implements [117] 
.field final synthetic [118] [119] 
.field private final synthetic [120] [121] 
.field private final synthetic [122] [123] 

.method [125] : [126] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [23] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [24] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [25] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [124] .code stack 4 locals 5 
        .catch [11] from L0 to L101 using L101 
L0:     ldc [4] 
L2:     ldc [5] 
L4:     aconst_null 
L5:     invokestatic [7] 
L8:     astore_1 
L9:     new [26] 
L12:    dup 
L13:    aload_1 
L14:    invokespecial [22] 
L17:    astore_2 
L18:    sipush 4096 
L21:    newarray byte 
L23:    astore_3 
L24:    iconst_0 
L25:    istore 4 
L27:    goto L38 
L30:    aload_2 
L31:    aload_3 
L32:    iconst_0 
L33:    iload 4 
L35:    invokevirtual [15] 
L38:    aload_0 
L39:    getfield [13] 
L42:    aload_3 
L43:    invokevirtual [16] 
L46:    dup 
L47:    istore 4 
L49:    iconst_m1 
L50:    if_icmpgt L30 
L53:    aload_2 
L54:    invokevirtual [17] 
L57:    aload_1 
L58:    invokevirtual [18] 
L61:    astore 5 
L63:    aload_0 
L64:    getfield [12] 
L67:    invokevirtual [19] 
L70:    ifeq L88 
L73:    aload_0 
L74:    getfield [12] 
L77:    aload 5 
L79:    aload_0 
L80:    getfield [14] 
L83:    iconst_1 
L84:    invokevirtual [20] 
L87:    areturn 
L88:    aload_0 
L89:    getfield [12] 
L92:    aload 5 
L94:    aload 5 
L96:    iconst_1 
L97:    invokevirtual [20] 
L100:   areturn 
L101:   pop 
L102:   aconst_null 
L103:   areturn 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = String [29] 
.const [5] = String [30] 
.const [6] = Class [31] 
.const [7] = Method [32] [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Field [38] [39] 
.const [13] = Field [40] [41] 
.const [14] = Field [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Class [66] 
.const [27] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 j9jar_ 
.const [30] = Utf8 '.tmp' 
.const [31] = Utf8 java/io/File 
.const [32] = Class [67] 
.const [33] = NameAndType [68] [69] 
.const [34] = Utf8 java/io/FileOutputStream 
.const [35] = Utf8 java/io/InputStream 
.const [36] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection 
.const [37] = Utf8 java/io/IOException 
.const [38] = Class [70] 
.const [39] = NameAndType [71] [72] 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Utf8 java/io/FileOutputStream 
.const [67] = Utf8 java/io/File 
.const [68] = Utf8 createTempFile 
.const [69] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File; 
.const [70] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [71] = Utf8 this$0 
.const [72] = Utf8 Lcom/ibm/oti/net/www/protocol/jar/JarURLConnection; 
.const [73] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [74] = Utf8 val$is 
.const [75] = Utf8 Ljava/io/InputStream; 
.const [76] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [77] = Utf8 val$externalForm 
.const [78] = Utf8 Ljava/lang/String; 
.const [79] = Utf8 java/io/FileOutputStream 
.const [80] = Utf8 write 
.const [81] = Utf8 ([BII)V 
.const [82] = Utf8 java/io/InputStream 
.const [83] = Utf8 read 
.const [84] = Utf8 ([B)I 
.const [85] = Utf8 java/io/FileOutputStream 
.const [86] = Utf8 close 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/io/File 
.const [89] = Utf8 getPath 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection 
.const [92] = Utf8 getUseCaches 
.const [93] = Utf8 ()Z 
.const [94] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection 
.const [95] = Utf8 openJarFile 
.const [96] = Utf8 (Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/jar/JarFile; 
.const [97] = Utf8 java/lang/Object 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 java/io/FileOutputStream 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Ljava/io/File;)V 
.const [103] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [104] = Utf8 this$0 
.const [105] = Utf8 Lcom/ibm/oti/net/www/protocol/jar/JarURLConnection; 
.const [106] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [107] = Utf8 val$is 
.const [108] = Utf8 Ljava/io/InputStream; 
.const [109] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [110] = Utf8 val$externalForm 
.const [111] = Utf8 Ljava/lang/String; 
.const [112] = Utf8 com/ibm/oti/net/www/protocol/jar/JarURLConnection$3 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 java/security/PrivilegedAction 
.const [117] = Class [116] 
.const [118] = Utf8 this$0 
.const [119] = Utf8 Lcom/ibm/oti/net/www/protocol/jar/JarURLConnection; 
.const [120] = Utf8 val$is 
.const [121] = Utf8 Ljava/io/InputStream; 
.const [122] = Utf8 val$externalForm 
.const [123] = Utf8 Ljava/lang/String; 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lcom/ibm/oti/net/www/protocol/jar/JarURLConnection;Ljava/io/InputStream;Ljava/lang/String;)V 
.const [127] = Utf8 run 
.const [128] = Utf8 ()Ljava/lang/Object; 
.end class 
