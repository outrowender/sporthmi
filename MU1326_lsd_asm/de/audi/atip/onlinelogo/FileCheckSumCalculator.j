.version 50 0 
.class public super [95] 
.super [97] 
.field public static final [98] [99] 
.field private static final [100] [101] 

.method public annotation [103] : [104] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 4 locals 9 
L0:     aconst_null 
L1:     astore_2 
L2:     sipush 1024 
L5:     newarray byte 
L7:     astore_3 
L8:     new [23] 
L11:    dup 
L12:    aload_1 
L13:    invokespecial [20] 
L16:    astore 4 
L18:    aload 4 
L20:    invokevirtual [14] 
L23:    ifne L28 
L26:    aconst_null 
L27:    areturn 
        .catch [5] from L28 to L35 using L38 
L28:    ldc [3] 
L30:    invokestatic [4] 
L33:    astore 5 
L35:    goto L42 
L38:    astore 6 
L40:    aconst_null 
L41:    areturn 
        .catch [7] from L42 to L53 using L56 
L42:    new [24] 
L45:    dup 
L46:    aload 4 
L48:    invokespecial [21] 
L51:    astore 6 
L53:    goto L60 
L56:    astore 7 
L58:    aconst_null 
L59:    areturn 
L60:    aload 5 
L62:    ifnull L180 
L65:    iconst_0 
L66:    istore 8 
L68:    aload 6 
L70:    aload_3 
L71:    invokevirtual [15] 
L74:    dup 
L75:    istore 7 
L77:    iconst_m1 
L78:    if_icmpeq L100 
L81:    iload 8 
L83:    iload 7 
L85:    iadd 
L86:    istore 8 
L88:    aload 5 
L90:    aload_3 
L91:    iconst_0 
L92:    iload 7 
L94:    invokevirtual [16] 
L97:    goto L68 
L100:   aload 5 
L102:   invokevirtual [17] 
L105:   astore_2 
L106:   aload 6 
L108:   invokevirtual [18] 
L111:   aload 6 
L113:   ifnull L180 
        .catch [8] from L116 to L121 using L124 
        .catch [8] from L65 to L111 using L132 
L116:   aload 6 
L118:   invokevirtual [18] 
L121:   goto L180 
L124:   astore 7 
L126:   aconst_null 
L127:   astore 6 
L129:   goto L180 
L132:   astore 7 
L134:   aconst_null 
L135:   astore_2 
L136:   aload 6 
L138:   ifnull L180 
        .catch [8] from L141 to L146 using L149 
        .catch [0] from L65 to L111 using L157 
        .catch [0] from L132 to L136 using L157 
L141:   aload 6 
L143:   invokevirtual [18] 
L146:   goto L180 
L149:   astore 7 
L151:   aconst_null 
L152:   astore 6 
L154:   goto L180 
L157:   astore 9 
L159:   aload 6 
L161:   ifnull L177 
        .catch [8] from L164 to L169 using L172 
        .catch [0] from L157 to L159 using L157 
L164:   aload 6 
L166:   invokevirtual [18] 
L169:   goto L177 
L172:   astore 10 
L174:   aconst_null 
L175:   astore 6 
L177:   aload 9 
L179:   athrow 
L180:   aload_2 
L181:   ifnull L196 
L184:   new [25] 
L187:   dup 
L188:   aload_2 
L189:   invokestatic [10] 
L192:   invokespecial [22] 
L195:   areturn 
L196:   aconst_null 
L197:   areturn 
L198:   nop 
L199:   nop 
L200:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = String [27] 
.const [4] = Method [28] [29] 
.const [5] = Class [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Method [35] [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Class [58] 
.const [24] = Class [59] 
.const [25] = Class [60] 
.const [26] = Utf8 java/io/File 
.const [27] = Utf8 SHA1 
.const [28] = Class [61] 
.const [29] = NameAndType [62] [63] 
.const [30] = Utf8 java/security/NoSuchAlgorithmException 
.const [31] = Utf8 java/io/FileInputStream 
.const [32] = Utf8 java/io/FileNotFoundException 
.const [33] = Utf8 java/io/IOException 
.const [34] = Utf8 java/lang/String 
.const [35] = Class [64] 
.const [36] = NameAndType [65] [66] 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 de/audi/atip/onlinelogo/FileCheckSumCalculator$Base64 
.const [39] = Utf8 java/security/MessageDigest 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Class [85] 
.const [53] = NameAndType [86] [87] 
.const [54] = Class [88] 
.const [55] = NameAndType [89] [90] 
.const [56] = Class [91] 
.const [57] = NameAndType [92] [93] 
.const [58] = Utf8 java/io/File 
.const [59] = Utf8 java/io/FileInputStream 
.const [60] = Utf8 java/lang/String 
.const [61] = Utf8 java/security/MessageDigest 
.const [62] = Utf8 getInstance 
.const [63] = Utf8 (Ljava/lang/String;)Ljava/security/MessageDigest; 
.const [64] = Utf8 de/audi/atip/onlinelogo/FileCheckSumCalculator$Base64 
.const [65] = Utf8 encode 
.const [66] = Utf8 ([B)[B 
.const [67] = Utf8 java/io/File 
.const [68] = Utf8 canRead 
.const [69] = Utf8 ()Z 
.const [70] = Utf8 java/io/FileInputStream 
.const [71] = Utf8 read 
.const [72] = Utf8 ([B)I 
.const [73] = Utf8 java/security/MessageDigest 
.const [74] = Utf8 update 
.const [75] = Utf8 ([BII)V 
.const [76] = Utf8 java/security/MessageDigest 
.const [77] = Utf8 digest 
.const [78] = Utf8 ()[B 
.const [79] = Utf8 java/io/FileInputStream 
.const [80] = Utf8 close 
.const [81] = Utf8 ()V 
.const [82] = Utf8 java/lang/Object 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/io/File 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Ljava/lang/String;)V 
.const [88] = Utf8 java/io/FileInputStream 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Ljava/io/File;)V 
.const [91] = Utf8 java/lang/String 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ([B)V 
.const [94] = Utf8 de/audi/atip/onlinelogo/FileCheckSumCalculator 
.const [95] = Class [94] 
.const [96] = Utf8 java/lang/Object 
.const [97] = Class [96] 
.const [98] = Utf8 CHECKSUM_ALG 
.const [99] = Utf8 Ljava/lang/String; 
.const [100] = Utf8 READ_BUFFER_SIZE 
.const [101] = Utf8 I 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 calcChecksum 
.const [106] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.end class 
