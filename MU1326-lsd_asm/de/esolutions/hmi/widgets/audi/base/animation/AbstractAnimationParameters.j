.version 50 0 
.class public super abstract [127] 
.super [129] 
.field protected [130] [131] 

.method public [133] : [134] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [32] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 5 locals 5 
L0:     aload_1 
L1:     ifnonnull L9 
L4:     aload_0 
L5:     invokevirtual [19] 
L8:     astore_1 
L9:     aload_1 
L10:    ifnonnull L26 
L13:    aload_0 
L14:    getfield [18] 
L17:    ldc [2] 
L19:    ldc [3] 
L21:    invokevirtual [20] 
L24:    pop 
L25:    return 
L26:    aload_0 
L27:    getfield [18] 
L30:    ldc [4] 
L32:    ldc [5] 
L34:    aload_1 
L35:    invokevirtual [21] 
L38:    pop 
L39:    new [33] 
L42:    dup 
L43:    new [34] 
L46:    dup 
L47:    aload_1 
L48:    invokespecial [30] 
L51:    invokespecial [31] 
L54:    astore_2 
L55:    aload_2 
L56:    invokevirtual [22] 
L59:    astore_3 
L60:    aload_3 
L61:    ifnull L96 
L64:    aload_3 
L65:    invokevirtual [23] 
L68:    invokevirtual [24] 
L71:    ifle L88 
L74:    aload_3 
L75:    ldc [8] 
L77:    invokevirtual [25] 
L80:    ifne L88 
L83:    aload_0 
L84:    aload_3 
L85:    invokevirtual [26] 
L88:    aload_2 
L89:    invokevirtual [22] 
L92:    astore_3 
L93:    goto L60 
L96:    aload_0 
L97:    getfield [18] 
L100:   ldc [4] 
L102:   ldc [9] 
L104:   invokevirtual [20] 
L107:   pop 
        .catch [10] from L108 to L112 using L115 
        .catch [10] from L55 to L108 using L125 
L108:   aload_2 
L109:   invokevirtual [27] 
L112:   goto L175 
L115:   astore 4 
L117:   aload 4 
L119:   invokevirtual [28] 
L122:   goto L175 
L125:   astore 4 
L127:   aload_0 
L128:   getfield [18] 
L131:   ldc [4] 
L133:   ldc [11] 
L135:   invokevirtual [20] 
L138:   pop 
        .catch [10] from L139 to L143 using L146 
        .catch [0] from L55 to L108 using L156 
        .catch [0] from L125 to L139 using L156 
L139:   aload_2 
L140:   invokevirtual [27] 
L143:   goto L175 
L146:   astore 4 
L148:   aload 4 
L150:   invokevirtual [28] 
L153:   goto L175 
L156:   astore 5 
        .catch [10] from L158 to L162 using L165 
        .catch [0] from L156 to L158 using L156 
        .catch [12] from L39 to L175 using L178 
L158:   aload_2 
L159:   invokevirtual [27] 
L162:   goto L172 
L165:   astore 6 
L167:   aload 6 
L169:   invokevirtual [28] 
L172:   aload 5 
L174:   athrow 
L175:   goto L191 
L178:   astore_2 
L179:   aload_0 
L180:   getfield [18] 
L183:   ldc [4] 
L185:   ldc [13] 
L187:   invokevirtual [20] 
L190:   pop 
L191:   return 
L192:   
    .end code 
.end method 

.method protected abstract [137] : [138] 
    .attribute [132] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [139] : [140] 
    .attribute [132] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1601830656 
.const [3] = String [35] 
.const [4] = Int -2137614336 
.const [5] = String [36] 
.const [6] = Class [37] 
.const [7] = Class [38] 
.const [8] = String [39] 
.const [9] = String [40] 
.const [10] = Class [41] 
.const [11] = String [42] 
.const [12] = Class [43] 
.const [13] = String [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Class [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Method [69] [70] 
.const [29] = Method [71] [72] 
.const [30] = Method [73] [74] 
.const [31] = Method [75] [76] 
.const [32] = Field [77] [78] 
.const [33] = Class [79] 
.const [34] = Class [80] 
.const [35] = Utf8 'AnimationParameters#readAnimationParametersFromFile animationParametersFile could not be found!' 
.const [36] = Utf8 'AnimationParameters#readAnimationParametersFromFile animationParametersFile: %1 ' 
.const [37] = Utf8 java/io/BufferedReader 
.const [38] = Utf8 java/io/FileReader 
.const [39] = Utf8 '\\' 
.const [40] = Utf8 'AnimationParameters#readAnimationParametersFromFile animationParameters read successfully!' 
.const [41] = Utf8 java/io/IOException 
.const [42] = Utf8 "AnimationParameters#readAnimationParametersFromFile couldn't read parameters" 
.const [43] = Utf8 java/io/FileNotFoundException 
.const [44] = Utf8 "AnimationParameters#readAnimationParametersFromFile couldn't find parameters file" 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationParameters 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 java/lang/String 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Class [93] 
.const [58] = NameAndType [94] [95] 
.const [59] = Class [96] 
.const [60] = NameAndType [97] [98] 
.const [61] = Class [99] 
.const [62] = NameAndType [100] [101] 
.const [63] = Class [102] 
.const [64] = NameAndType [103] [104] 
.const [65] = Class [105] 
.const [66] = NameAndType [106] [107] 
.const [67] = Class [108] 
.const [68] = NameAndType [109] [110] 
.const [69] = Class [111] 
.const [70] = NameAndType [112] [113] 
.const [71] = Class [114] 
.const [72] = NameAndType [115] [116] 
.const [73] = Class [117] 
.const [74] = NameAndType [118] [119] 
.const [75] = Class [120] 
.const [76] = NameAndType [121] [122] 
.const [77] = Class [123] 
.const [78] = NameAndType [124] [125] 
.const [79] = Utf8 java/io/BufferedReader 
.const [80] = Utf8 java/io/FileReader 
.const [81] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationParameters 
.const [82] = Utf8 logAnimation 
.const [83] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationParameters 
.const [85] = Utf8 getConfigFileName 
.const [86] = Utf8 ()Ljava/lang/String; 
.const [87] = Utf8 de/audi/atip/log/LogChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (ILjava/lang/String;)Z 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [93] = Utf8 java/io/BufferedReader 
.const [94] = Utf8 readLine 
.const [95] = Utf8 ()Ljava/lang/String; 
.const [96] = Utf8 java/lang/String 
.const [97] = Utf8 trim 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/String 
.const [100] = Utf8 length 
.const [101] = Utf8 ()I 
.const [102] = Utf8 java/lang/String 
.const [103] = Utf8 startsWith 
.const [104] = Utf8 (Ljava/lang/String;)Z 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationParameters 
.const [106] = Utf8 readAnimationParameters 
.const [107] = Utf8 (Ljava/lang/String;)V 
.const [108] = Utf8 java/io/BufferedReader 
.const [109] = Utf8 close 
.const [110] = Utf8 ()V 
.const [111] = Utf8 java/io/IOException 
.const [112] = Utf8 printStackTrace 
.const [113] = Utf8 ()V 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 java/io/FileReader 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Ljava/lang/String;)V 
.const [120] = Utf8 java/io/BufferedReader 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (Ljava/io/Reader;)V 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationParameters 
.const [124] = Utf8 logAnimation 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationParameters 
.const [127] = Class [126] 
.const [128] = Utf8 java/lang/Object 
.const [129] = Class [128] 
.const [130] = Utf8 logAnimation 
.const [131] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [135] = Utf8 readAnimationParametersFromFile 
.const [136] = Utf8 (Ljava/lang/String;)V 
.const [137] = Utf8 getConfigFileName 
.const [138] = Utf8 ()Ljava/lang/String; 
.const [139] = Utf8 readAnimationParameters 
.const [140] = Utf8 (Ljava/lang/String;)V 
.end class 
