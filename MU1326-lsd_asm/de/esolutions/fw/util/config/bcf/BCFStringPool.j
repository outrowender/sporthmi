.version 50 0 
.class public super [143] 
.super [145] 
.field private [146] [147] 

.method [149] : [150] 
    .attribute [148] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     new [23] 
L8:     dup 
L9:     bipush 10 
L11:    invokespecial [21] 
L14:    putfield [24] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method [151] : [152] 
    .attribute [148] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     new [25] 
L7:     dup 
L8:     aload_1 
L9:     invokespecial [22] 
L12:    invokeinterface [26] 0 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method [153] : [154] 
    .attribute [148] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     iload_1 
L5:     invokeinterface [27] 0 
L10:    checkcast [3] 
L13:    astore_2 
L14:    aload_2 
L15:    invokevirtual [12] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method [155] : [156] 
    .attribute [148] .code stack 5 locals 11 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [11] 
L6:     invokeinterface [28] 0 
L11:    istore_2 
L12:    iload_2 
L13:    anewarray [3] 
L16:    astore_3 
L17:    aload_0 
L18:    getfield [11] 
L21:    invokeinterface [29] 0 
L26:    astore 4 
L28:    aload 4 
L30:    invokeinterface [30] 0 
L35:    ifeq L172 
L38:    aload 4 
L40:    invokeinterface [31] 0 
L45:    checkcast [3] 
L48:    astore 5 
L50:    aload 5 
L52:    invokevirtual [13] 
L55:    istore 6 
L57:    iconst_0 
L58:    istore 7 
L60:    iconst_0 
L61:    istore 8 
L63:    iload 8 
L65:    iload_1 
L66:    if_icmpge L156 
L69:    aload_3 
L70:    iload 8 
L72:    aaload 
L73:    astore 9 
L75:    aload 9 
L77:    invokevirtual [13] 
L80:    istore 10 
L82:    iload 10 
L84:    iload 6 
L86:    if_icmple L118 
L89:    aload 9 
L91:    aload 5 
L93:    invokevirtual [14] 
L96:    istore 11 
L98:    iload 11 
L100:   iflt L115 
L103:   iconst_1 
L104:   istore 7 
L106:   aload 5 
L108:   aload 9 
L110:   iload 11 
L112:   invokevirtual [15] 
L115:   goto L150 
L118:   aload 5 
L120:   aload 9 
L122:   invokevirtual [14] 
L125:   istore 11 
L127:   iload 11 
L129:   iflt L150 
L132:   iconst_1 
L133:   istore 7 
L135:   aload 9 
L137:   aload 5 
L139:   iload 11 
L141:   invokevirtual [15] 
L144:   aload_3 
L145:   iload 8 
L147:   aload 5 
L149:   aastore 
L150:   iinc 8 1 
L153:   goto L63 
L156:   iload 7 
L158:   ifne L169 
L161:   aload_3 
L162:   iload_1 
L163:   aload 5 
L165:   aastore 
L166:   iinc 1 1 
L169:   goto L28 
L172:   new [23] 
L175:   dup 
L176:   iload_1 
L177:   invokespecial [21] 
L180:   astore 5 
L182:   iconst_0 
L183:   istore 6 
L185:   iconst_0 
L186:   istore 7 
L188:   iload 7 
L190:   iload_1 
L191:   if_icmpge L236 
L194:   aload_3 
L195:   iload 7 
L197:   aaload 
L198:   invokevirtual [16] 
L201:   astore 8 
L203:   aload_3 
L204:   iload 7 
L206:   aaload 
L207:   iload 6 
L209:   invokevirtual [17] 
L212:   iload 6 
L214:   iconst_1 
L215:   aload 8 
L217:   arraylength 
L218:   iadd 
L219:   iadd 
L220:   istore 6 
L222:   aload 5 
L224:   aload 8 
L226:   invokevirtual [18] 
L229:   pop 
L230:   iinc 7 1 
L233:   goto L188 
L236:   iload 6 
L238:   newarray byte 
L240:   astore 7 
L242:   iconst_0 
L243:   istore 8 
L245:   aload 5 
L247:   invokevirtual [19] 
L250:   astore 9 
L252:   aload 9 
L254:   invokeinterface [30] 0 
L259:   ifeq L303 
L262:   aload 9 
L264:   invokeinterface [31] 0 
L269:   checkcast [4] 
L272:   checkcast [4] 
L275:   astore 10 
L277:   aload 10 
L279:   iconst_0 
L280:   aload 7 
L282:   iload 8 
L284:   aload 10 
L286:   arraylength 
L287:   invokestatic [5] 
L290:   iload 8 
L292:   iconst_1 
L293:   aload 10 
L295:   arraylength 
L296:   iadd 
L297:   iadd 
L298:   istore 8 
L300:   goto L252 
L303:   aload 7 
L305:   areturn 
L306:   nop 
L307:   nop 
L308:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = Method [35] [36] 
.const [6] = Class [37] 
.const [7] = Class [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Field [42] [43] 
.const [12] = Method [44] [45] 
.const [13] = Method [46] [47] 
.const [14] = Method [48] [49] 
.const [15] = Method [50] [51] 
.const [16] = Method [52] [53] 
.const [17] = Method [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Class [66] 
.const [24] = Field [67] [68] 
.const [25] = Class [69] 
.const [26] = InterfaceMethod [70] [71] 
.const [27] = InterfaceMethod [72] [73] 
.const [28] = InterfaceMethod [74] [75] 
.const [29] = InterfaceMethod [76] [77] 
.const [30] = InterfaceMethod [78] [79] 
.const [31] = InterfaceMethod [80] [81] 
.const [32] = Utf8 java/util/ArrayList 
.const [33] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [34] = Utf8 [B 
.const [35] = Class [82] 
.const [36] = NameAndType [83] [84] 
.const [37] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringPool 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 java/util/List 
.const [40] = Utf8 java/util/ListIterator 
.const [41] = Utf8 java/lang/System 
.const [42] = Class [85] 
.const [43] = NameAndType [86] [87] 
.const [44] = Class [88] 
.const [45] = NameAndType [89] [90] 
.const [46] = Class [91] 
.const [47] = NameAndType [92] [93] 
.const [48] = Class [94] 
.const [49] = NameAndType [95] [96] 
.const [50] = Class [97] 
.const [51] = NameAndType [98] [99] 
.const [52] = Class [100] 
.const [53] = NameAndType [101] [102] 
.const [54] = Class [103] 
.const [55] = NameAndType [104] [105] 
.const [56] = Class [106] 
.const [57] = NameAndType [107] [108] 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Class [112] 
.const [61] = NameAndType [113] [114] 
.const [62] = Class [115] 
.const [63] = NameAndType [116] [117] 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Utf8 java/util/ArrayList 
.const [67] = Class [121] 
.const [68] = NameAndType [122] [123] 
.const [69] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Utf8 java/lang/System 
.const [83] = Utf8 arraycopy 
.const [84] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [85] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringPool 
.const [86] = Utf8 entries 
.const [87] = Utf8 Ljava/util/List; 
.const [88] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [89] = Utf8 getOffset 
.const [90] = Utf8 ()I 
.const [91] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [92] = Utf8 getLength 
.const [93] = Utf8 ()I 
.const [94] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [95] = Utf8 canMerge 
.const [96] = Utf8 (Lde/esolutions/fw/util/config/bcf/BCFStringEntry;)I 
.const [97] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [98] = Utf8 setMerge 
.const [99] = Utf8 (Lde/esolutions/fw/util/config/bcf/BCFStringEntry;I)V 
.const [100] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [101] = Utf8 toBytes 
.const [102] = Utf8 ()[B 
.const [103] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [104] = Utf8 setBaseOffset 
.const [105] = Utf8 (I)V 
.const [106] = Utf8 java/util/ArrayList 
.const [107] = Utf8 add 
.const [108] = Utf8 (Ljava/lang/Object;)Z 
.const [109] = Utf8 java/util/ArrayList 
.const [110] = Utf8 listIterator 
.const [111] = Utf8 ()Ljava/util/ListIterator; 
.const [112] = Utf8 java/lang/Object 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 java/util/ArrayList 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (I)V 
.const [118] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringEntry 
.const [119] = Utf8 <init> 
.const [120] = Utf8 (Ljava/lang/String;)V 
.const [121] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringPool 
.const [122] = Utf8 entries 
.const [123] = Utf8 Ljava/util/List; 
.const [124] = Utf8 java/util/List 
.const [125] = Utf8 add 
.const [126] = Utf8 (Ljava/lang/Object;)Z 
.const [127] = Utf8 java/util/List 
.const [128] = Utf8 get 
.const [129] = Utf8 (I)Ljava/lang/Object; 
.const [130] = Utf8 java/util/List 
.const [131] = Utf8 size 
.const [132] = Utf8 ()I 
.const [133] = Utf8 java/util/List 
.const [134] = Utf8 listIterator 
.const [135] = Utf8 ()Ljava/util/ListIterator; 
.const [136] = Utf8 java/util/ListIterator 
.const [137] = Utf8 hasNext 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 java/util/ListIterator 
.const [140] = Utf8 next 
.const [141] = Utf8 ()Ljava/lang/Object; 
.const [142] = Utf8 de/esolutions/fw/util/config/bcf/BCFStringPool 
.const [143] = Class [142] 
.const [144] = Utf8 java/lang/Object 
.const [145] = Class [144] 
.const [146] = Utf8 entries 
.const [147] = Utf8 Ljava/util/List; 
.const [148] = Utf8 Code 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 addString 
.const [152] = Utf8 (Ljava/lang/String;)V 
.const [153] = Utf8 getStringOffset 
.const [154] = Utf8 (I)I 
.const [155] = Utf8 buildTable 
.const [156] = Utf8 ()[B 
.end class 
