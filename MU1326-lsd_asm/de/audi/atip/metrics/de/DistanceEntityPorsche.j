.version 50 0 
.class public super [77] 
.super [79] 

.method annotation [81] : [82] 
    .attribute [80] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [83] : [84] 
    .attribute [80] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     bipush 8 
L6:     if_icmpne L15 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [11] 
L14:    return 
L15:    aload_0 
L16:    getfield [12] 
L19:    ifgt L64 
L22:    aload_0 
L23:    getfield [12] 
L26:    ifne L56 
L29:    aload_0 
L30:    getfield [13] 
L33:    ifle L64 
L36:    aload_0 
L37:    getfield [13] 
L40:    bipush 25 
L42:    irem 
L43:    ifeq L56 
L46:    aload_0 
L47:    getfield [13] 
L50:    bipush 33 
L52:    irem 
L53:    ifne L64 
L56:    aload_0 
L57:    getfield [10] 
L60:    iconst_2 
L61:    if_icmpne L73 
L64:    aload_1 
L65:    aload_0 
L66:    getfield [12] 
L69:    invokevirtual [14] 
L72:    pop 
L73:    aload_0 
L74:    getfield [13] 
L77:    ifge L96 
L80:    aload_0 
L81:    getfield [10] 
L84:    iconst_5 
L85:    if_icmpeq L96 
L88:    aload_0 
L89:    getfield [10] 
L92:    iconst_1 
L93:    if_icmpne L323 
L96:    aload_0 
L97:    getfield [15] 
L100:   iconst_m1 
L101:   if_icmpeq L323 
L104:   aload_0 
L105:   getfield [13] 
L108:   lookupswitch 
            25 : L152 
            33 : L190 
            50 : L228 
            75 : L266 
            default : L304 

L152:   aload_0 
L153:   getfield [12] 
L156:   ifne L170 
L159:   aload_1 
L160:   sipush 188 
L163:   invokevirtual [16] 
L166:   pop 
L167:   goto L323 
L170:   aload_1 
L171:   aload_0 
L172:   getfield [15] 
L175:   invokestatic [2] 
L178:   invokevirtual [17] 
L181:   ldc [3] 
L183:   invokevirtual [17] 
L186:   pop 
L187:   goto L323 
L190:   aload_0 
L191:   getfield [12] 
L194:   ifne L208 
L197:   aload_1 
L198:   sipush 8531 
L201:   invokevirtual [16] 
L204:   pop 
L205:   goto L323 
L208:   aload_1 
L209:   aload_0 
L210:   getfield [15] 
L213:   invokestatic [2] 
L216:   invokevirtual [17] 
L219:   ldc [4] 
L221:   invokevirtual [17] 
L224:   pop 
L225:   goto L323 
L228:   aload_0 
L229:   getfield [12] 
L232:   ifne L246 
L235:   aload_1 
L236:   sipush 189 
L239:   invokevirtual [16] 
L242:   pop 
L243:   goto L323 
L246:   aload_1 
L247:   aload_0 
L248:   getfield [15] 
L251:   invokestatic [2] 
L254:   invokevirtual [17] 
L257:   bipush 53 
L259:   invokevirtual [16] 
L262:   pop 
L263:   goto L323 
L266:   aload_0 
L267:   getfield [12] 
L270:   ifne L284 
L273:   aload_1 
L274:   sipush 190 
L277:   invokevirtual [16] 
L280:   pop 
L281:   goto L323 
L284:   aload_1 
L285:   aload_0 
L286:   getfield [15] 
L289:   invokestatic [2] 
L292:   invokevirtual [17] 
L295:   ldc [5] 
L297:   invokevirtual [17] 
L300:   pop 
L301:   goto L323 
L304:   aload_1 
L305:   aload_0 
L306:   getfield [15] 
L309:   invokestatic [2] 
L312:   invokevirtual [17] 
L315:   aload_0 
L316:   getfield [13] 
L319:   invokevirtual [14] 
L322:   pop 
L323:   return 
L324:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [19] [20] 
.const [3] = String [21] 
.const [4] = String [22] 
.const [5] = String [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Field [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Field [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Class [46] 
.const [20] = NameAndType [47] [48] 
.const [21] = Utf8 '25' 
.const [22] = Utf8 '33' 
.const [23] = Utf8 '75' 
.const [24] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [25] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [26] = Utf8 java/lang/StringBuffer 
.const [27] = Utf8 de/audi/atip/metrics/Distance 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Utf8 de/audi/atip/metrics/Distance 
.const [47] = Utf8 getText 
.const [48] = Utf8 (I)Ljava/lang/String; 
.const [49] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [50] = Utf8 mode 
.const [51] = Utf8 I 
.const [52] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [53] = Utf8 getStringValueModeDecimal 
.const [54] = Utf8 (Ljava/lang/StringBuffer;)V 
.const [55] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [56] = Utf8 distanceMajor 
.const [57] = Utf8 I 
.const [58] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [59] = Utf8 distanceMinor 
.const [60] = Utf8 I 
.const [61] = Utf8 java/lang/StringBuffer 
.const [62] = Utf8 append 
.const [63] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [64] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [65] = Utf8 distanceSepTextConstant 
.const [66] = Utf8 I 
.const [67] = Utf8 java/lang/StringBuffer 
.const [68] = Utf8 append 
.const [69] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [70] = Utf8 java/lang/StringBuffer 
.const [71] = Utf8 append 
.const [72] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [73] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (I)V 
.const [76] = Utf8 de/audi/atip/metrics/de/DistanceEntityPorsche 
.const [77] = Class [76] 
.const [78] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [79] = Class [78] 
.const [80] = Utf8 Code 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 formatValue 
.const [84] = Utf8 (Ljava/lang/StringBuffer;)V 
.end class 
