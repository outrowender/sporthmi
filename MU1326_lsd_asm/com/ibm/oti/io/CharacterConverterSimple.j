.version 50 0 
.class super abstract [90] 
.super [92] 
.field private static final [93] [94] 

.method static [96] : [97] 
    .attribute [95] .code stack 1 locals 0 
L0:     invokestatic [5] 
L3:     putstatic [19] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method annotation [98] : [99] 
    .attribute [95] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method abstract [100] : [101] 
    .attribute [95] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method abstract [102] : [103] 
    .attribute [95] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method abstract [104] : [105] 
    .attribute [95] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private native [106] : [107] 
    .attribute [95] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [95] .code stack 7 locals 3 
L0:     getstatic [6] 
L3:     ifeq L22 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     aload_3 
L10:    iload 4 
L12:    iload 5 
L14:    aload_0 
L15:    invokevirtual [15] 
L18:    invokespecial [21] 
L21:    areturn 
L22:    aload_0 
L23:    invokevirtual [15] 
L26:    astore 6 
L28:    iload 5 
L30:    istore 7 
L32:    goto L72 
L35:    aload_1 
L36:    iload_2 
L37:    iinc 2 1 
L40:    baload 
L41:    istore 8 
L43:    aload_3 
L44:    iload 4 
L46:    iinc 4 1 
L49:    iload 8 
L51:    ifge L68 
L54:    aload 6 
L56:    iload 8 
L58:    sipush 128 
L61:    iadd 
L62:    invokevirtual [16] 
L65:    goto L70 
L68:    iload 8 
L70:    i2c 
L71:    castore 
L72:    iinc 7 -1 
L75:    iload 7 
L77:    ifge L35 
L80:    iload_2 
L81:    areturn 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private native [110] : [111] 
    .attribute [95] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [112] : [113] 
    .attribute [95] .code stack 6 locals 8 
L0:     getstatic [6] 
L3:     ifeq L22 
L6:     aload_0 
L7:     aload_1 
L8:     iload_2 
L9:     iload_3 
L10:    aload_0 
L11:    invokevirtual [17] 
L14:    aload_0 
L15:    invokevirtual [18] 
L18:    invokespecial [22] 
L21:    areturn 
L22:    iload_3 
L23:    newarray byte 
L25:    astore 4 
L27:    iconst_0 
L28:    istore 5 
L30:    iload_2 
L31:    iload_3 
L32:    iadd 
L33:    istore 6 
L35:    aload_0 
L36:    invokevirtual [17] 
L39:    astore 7 
L41:    aload_0 
L42:    invokevirtual [18] 
L45:    astore 8 
L47:    iload_2 
L48:    istore 9 
L50:    goto L174 
L53:    aload_1 
L54:    iload 9 
L56:    caload 
L57:    istore 10 
L59:    iload 10 
L61:    bipush 127 
L63:    if_icmpgt L80 
L66:    aload 4 
L68:    iload 5 
L70:    iinc 5 1 
L73:    iload 10 
L75:    i2b 
L76:    bastore 
L77:    goto L171 
L80:    aload 7 
L82:    iload 10 
L84:    invokestatic [9] 
L87:    istore 11 
L89:    iload 11 
L91:    iflt L113 
L94:    aload 4 
L96:    iload 5 
L98:    iinc 5 1 
L101:   aload 8 
L103:   iload 11 
L105:   invokevirtual [16] 
L108:   i2b 
L109:   bastore 
L110:   goto L171 
L113:   iload 10 
L115:   ldc [10] 
L117:   if_icmplt L161 
L120:   iload 10 
L122:   ldc [11] 
L124:   if_icmpge L161 
L127:   iload 9 
L129:   iconst_1 
L130:   iadd 
L131:   iload 6 
L133:   if_icmpge L161 
L136:   aload_1 
L137:   iload 9 
L139:   iconst_1 
L140:   iadd 
L141:   caload 
L142:   ldc [11] 
L144:   if_icmplt L161 
L147:   aload_1 
L148:   iload 9 
L150:   iconst_1 
L151:   iadd 
L152:   caload 
L153:   ldc [12] 
L155:   if_icmpge L161 
L158:   iinc 9 1 
L161:   aload 4 
L163:   iload 5 
L165:   iinc 5 1 
L168:   bipush 63 
L170:   bastore 
L171:   iinc 9 1 
L174:   iload 9 
L176:   iload 6 
L178:   if_icmplt L53 
L181:   iload 5 
L183:   aload 4 
L185:   arraylength 
L186:   if_icmpge L209 
L189:   iload 5 
L191:   newarray byte 
L193:   astore 9 
L195:   aload 4 
L197:   iconst_0 
L198:   aload 9 
L200:   iconst_0 
L201:   iload 5 
L203:   invokestatic [14] 
L206:   aload 9 
L208:   areturn 
L209:   aload 4 
L211:   areturn 
L212:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Method [26] [27] 
.const [6] = Field [28] [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Method [32] [33] 
.const [10] = Int 14155776 
.const [11] = Int 14417920 
.const [12] = Int 14680064 
.const [13] = Class [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = Method [47] [48] 
.const [21] = Method [49] [50] 
.const [22] = Method [51] [52] 
.const [23] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [24] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [25] = Utf8 com/ibm/oti/vm/VM 
.const [26] = Class [53] 
.const [27] = NameAndType [54] [55] 
.const [28] = Class [56] 
.const [29] = NameAndType [57] [58] 
.const [30] = Utf8 java/lang/String 
.const [31] = Utf8 com/ibm/oti/util/BinarySearch 
.const [32] = Class [59] 
.const [33] = NameAndType [60] [61] 
.const [34] = Utf8 java/lang/System 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Utf8 com/ibm/oti/vm/VM 
.const [54] = Utf8 useNatives 
.const [55] = Utf8 ()Z 
.const [56] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [57] = Utf8 useNative 
.const [58] = Utf8 Z 
.const [59] = Utf8 com/ibm/oti/util/BinarySearch 
.const [60] = Utf8 binarySearch 
.const [61] = Utf8 (Ljava/lang/String;C)I 
.const [62] = Utf8 java/lang/System 
.const [63] = Utf8 arraycopy 
.const [64] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [65] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [66] = Utf8 byteTable 
.const [67] = Utf8 ()Ljava/lang/String; 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 charAt 
.const [70] = Utf8 (I)C 
.const [71] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [72] = Utf8 charKeys 
.const [73] = Utf8 ()Ljava/lang/String; 
.const [74] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [75] = Utf8 charValues 
.const [76] = Utf8 ()Ljava/lang/String; 
.const [77] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [78] = Utf8 useNative 
.const [79] = Utf8 Z 
.const [80] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [84] = Utf8 convertImpl 
.const [85] = Utf8 ([BI[CIILjava/lang/String;)I 
.const [86] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [87] = Utf8 convertImpl 
.const [88] = Utf8 ([CIILjava/lang/String;Ljava/lang/String;)[B 
.const [89] = Utf8 com/ibm/oti/io/CharacterConverterSimple 
.const [90] = Class [89] 
.const [91] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [92] = Class [91] 
.const [93] = Utf8 useNative 
.const [94] = Utf8 Z 
.const [95] = Utf8 Code 
.const [96] = Utf8 <clinit> 
.const [97] = Utf8 ()V 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 byteTable 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 charKeys 
.const [103] = Utf8 ()Ljava/lang/String; 
.const [104] = Utf8 charValues 
.const [105] = Utf8 ()Ljava/lang/String; 
.const [106] = Utf8 convertImpl 
.const [107] = Utf8 ([BI[CIILjava/lang/String;)I 
.const [108] = Utf8 convert 
.const [109] = Utf8 ([BI[CII)I 
.const [110] = Utf8 convertImpl 
.const [111] = Utf8 ([CIILjava/lang/String;Ljava/lang/String;)[B 
.const [112] = Utf8 convert 
.const [113] = Utf8 ([CII)[B 
.end class 
