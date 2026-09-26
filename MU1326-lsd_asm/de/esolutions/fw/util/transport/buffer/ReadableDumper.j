.version 50 0 
.class public super [103] 
.super [105] 

.method public annotation [107] : [108] 
    .attribute [106] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [109] : [110] 
    .attribute [106] .code stack 4 locals 8 
L0:     getstatic [2] 
L3:     new [26] 
L6:     dup 
L7:     invokespecial [24] 
L10:    ldc [4] 
L12:    invokevirtual [17] 
L15:    iload_1 
L16:    invokevirtual [18] 
L19:    invokevirtual [19] 
L22:    invokevirtual [20] 
        .catch [10] from L25 to L238 using L241 
L25:    aload_0 
L26:    invokeinterface [27] 0 
L31:    astore_2 
L32:    iconst_0 
L33:    istore_3 
L34:    iload_3 
L35:    iload_1 
L36:    if_icmpge L238 
L39:    iload_1 
L40:    iload_3 
L41:    isub 
L42:    istore 4 
L44:    iload 4 
L46:    bipush 16 
L48:    if_icmple L55 
L51:    bipush 16 
L53:    istore 4 
L55:    new [26] 
L58:    dup 
L59:    invokespecial [24] 
L62:    ldc [5] 
L64:    invokevirtual [17] 
L67:    iload_3 
L68:    invokestatic [6] 
L71:    invokevirtual [17] 
L74:    invokevirtual [19] 
L77:    astore 5 
L79:    aload 5 
L81:    invokevirtual [21] 
L84:    istore 6 
L86:    new [26] 
L89:    dup 
L90:    invokespecial [24] 
L93:    aload 5 
L95:    iload 6 
L97:    bipush 8 
L99:    isub 
L100:   iload 6 
L102:   invokevirtual [22] 
L105:   invokevirtual [17] 
L108:   ldc [7] 
L110:   invokevirtual [17] 
L113:   invokevirtual [19] 
L116:   astore 5 
L118:   new [26] 
L121:   dup 
L122:   aload 5 
L124:   invokespecial [25] 
L127:   astore 7 
L129:   iconst_0 
L130:   istore 8 
L132:   iload 8 
L134:   iload 4 
L136:   if_icmpge L220 
L139:   new [26] 
L142:   dup 
L143:   invokespecial [24] 
L146:   ldc [8] 
L148:   invokevirtual [17] 
L151:   aload_2 
L152:   iload_3 
L153:   baload 
L154:   invokestatic [6] 
L157:   invokevirtual [17] 
L160:   invokevirtual [19] 
L163:   astore 9 
L165:   aload 9 
L167:   invokevirtual [21] 
L170:   istore 6 
L172:   aload 9 
L174:   iload 6 
L176:   iconst_2 
L177:   isub 
L178:   iload 6 
L180:   invokevirtual [22] 
L183:   astore 9 
L185:   aload 7 
L187:   new [26] 
L190:   dup 
L191:   invokespecial [24] 
L194:   aload 9 
L196:   invokevirtual [17] 
L199:   ldc [9] 
L201:   invokevirtual [17] 
L204:   invokevirtual [19] 
L207:   invokevirtual [17] 
L210:   pop 
L211:   iinc 3 1 
L214:   iinc 8 1 
L217:   goto L132 
L220:   aload 7 
L222:   invokevirtual [19] 
L225:   astore 5 
L227:   getstatic [2] 
L230:   aload 5 
L232:   invokevirtual [20] 
L235:   goto L34 
L238:   goto L242 
L241:   astore_2 
L242:   return 
L243:   nop 
L244:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [28] [29] 
.const [3] = Class [30] 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = Method [33] [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Class [42] 
.const [15] = Class [43] 
.const [16] = Class [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Method [55] [56] 
.const [23] = Method [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Method [61] [62] 
.const [26] = Class [63] 
.const [27] = InterfaceMethod [64] [65] 
.const [28] = Class [66] 
.const [29] = NameAndType [67] [68] 
.const [30] = Utf8 java/lang/StringBuffer 
.const [31] = Utf8 'Buffer: size=' 
.const [32] = Utf8 '00000000' 
.const [33] = Class [69] 
.const [34] = NameAndType [70] [71] 
.const [35] = Utf8 ': ' 
.const [36] = Utf8 '00' 
.const [37] = Utf8 ' ' 
.const [38] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 java/lang/System 
.const [41] = Utf8 java/io/PrintStream 
.const [42] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [43] = Utf8 java/lang/Integer 
.const [44] = Utf8 java/lang/String 
.const [45] = Class [72] 
.const [46] = NameAndType [73] [74] 
.const [47] = Class [75] 
.const [48] = NameAndType [76] [77] 
.const [49] = Class [78] 
.const [50] = NameAndType [79] [80] 
.const [51] = Class [81] 
.const [52] = NameAndType [82] [83] 
.const [53] = Class [84] 
.const [54] = NameAndType [85] [86] 
.const [55] = Class [87] 
.const [56] = NameAndType [88] [89] 
.const [57] = Class [90] 
.const [58] = NameAndType [91] [92] 
.const [59] = Class [93] 
.const [60] = NameAndType [94] [95] 
.const [61] = Class [96] 
.const [62] = NameAndType [97] [98] 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Class [99] 
.const [65] = NameAndType [100] [101] 
.const [66] = Utf8 java/lang/System 
.const [67] = Utf8 out 
.const [68] = Utf8 Ljava/io/PrintStream; 
.const [69] = Utf8 java/lang/Integer 
.const [70] = Utf8 toHexString 
.const [71] = Utf8 (I)Ljava/lang/String; 
.const [72] = Utf8 java/lang/StringBuffer 
.const [73] = Utf8 append 
.const [74] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Utf8 append 
.const [77] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [78] = Utf8 java/lang/StringBuffer 
.const [79] = Utf8 toString 
.const [80] = Utf8 ()Ljava/lang/String; 
.const [81] = Utf8 java/io/PrintStream 
.const [82] = Utf8 println 
.const [83] = Utf8 (Ljava/lang/String;)V 
.const [84] = Utf8 java/lang/String 
.const [85] = Utf8 length 
.const [86] = Utf8 ()I 
.const [87] = Utf8 java/lang/String 
.const [88] = Utf8 substring 
.const [89] = Utf8 (II)Ljava/lang/String; 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Ljava/lang/String;)V 
.const [99] = Utf8 de/esolutions/fw/util/transport/IReadable 
.const [100] = Utf8 getData 
.const [101] = Utf8 ()[B 
.const [102] = Utf8 de/esolutions/fw/util/transport/buffer/ReadableDumper 
.const [103] = Class [102] 
.const [104] = Utf8 java/lang/Object 
.const [105] = Class [104] 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 ()V 
.const [109] = Utf8 dump 
.const [110] = Utf8 (Lde/esolutions/fw/util/transport/IReadable;I)V 
.end class 
