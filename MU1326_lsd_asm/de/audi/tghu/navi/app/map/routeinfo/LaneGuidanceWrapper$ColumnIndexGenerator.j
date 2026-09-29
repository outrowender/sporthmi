.version 50 0 
.class super [74] 
.super [76] 
.implements [78] 
.field private final synthetic [79] [80] 

.method private [82] : [83] 
    .attribute [81] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     aload_0 
L6:     invokespecial [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [81] .code stack 7 locals 9 
L0:     aload_1 
L1:     getfield [14] 
L4:     aload_1 
L5:     getfield [15] 
L8:     ior 
L9:     i2s 
L10:    istore_2 
L11:    iload_2 
L12:    bipush 62 
L14:    iand 
L15:    ifle L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    istore_3 
L24:    iload_2 
L25:    sipush 3968 
L28:    iand 
L29:    ifle L36 
L32:    iconst_1 
L33:    goto L37 
L36:    iconst_0 
L37:    istore 4 
L39:    iload_2 
L40:    bipush 64 
L42:    iand 
L43:    ifle L50 
L46:    iconst_1 
L47:    goto L51 
L50:    iconst_0 
L51:    istore 5 
L53:    iload 4 
L55:    ifeq L66 
L58:    iload_3 
L59:    ifne L66 
L62:    iconst_1 
L63:    goto L67 
L66:    iconst_0 
L67:    istore 6 
L69:    iload 4 
L71:    ifne L82 
L74:    iload_3 
L75:    ifeq L82 
L78:    iconst_1 
L79:    goto L83 
L82:    iconst_0 
L83:    istore 7 
L85:    iload 4 
L87:    ifeq L98 
L90:    iload_3 
L91:    ifeq L98 
L94:    iconst_1 
L95:    goto L99 
L98:    iconst_0 
L99:    istore 8 
L101:   aload_0 
L102:   getfield [13] 
L105:   aload_1 
L106:   getfield [14] 
L109:   invokestatic [2] 
L112:   aload_0 
L113:   getfield [13] 
L116:   aload_1 
L117:   getfield [15] 
L120:   invokestatic [2] 
L123:   iadd 
L124:   istore 9 
L126:   iconst_m1 
L127:   istore 10 
L129:   iload 9 
L131:   tableswitch 1 
            L156 
            L162 
            L249 
            default : L344 

L156:   iconst_0 
L157:   istore 10 
L159:   goto L369 
L162:   iload 5 
L164:   ifeq L173 
L167:   iconst_1 
L168:   istore 10 
L170:   goto L369 
L173:   iload 5 
L175:   ifne L189 
L178:   iload 6 
L180:   ifeq L189 
L183:   iconst_2 
L184:   istore 10 
L186:   goto L369 
L189:   iload 5 
L191:   ifne L205 
L194:   iload 8 
L196:   ifeq L205 
L199:   iconst_3 
L200:   istore 10 
L202:   goto L369 
L205:   iload 5 
L207:   ifne L221 
L210:   iload 7 
L212:   ifeq L221 
L215:   iconst_4 
L216:   istore 10 
L218:   goto L369 
L221:   aload_0 
L222:   getfield [13] 
L225:   invokestatic [3] 
L228:   ldc [4] 
L230:   ldc [5] 
L232:   aload_1 
L233:   getfield [14] 
L236:   i2l 
L237:   aload_1 
L238:   getfield [15] 
L241:   i2l 
L242:   invokevirtual [16] 
L245:   pop 
L246:   goto L369 
L249:   iload 5 
L251:   ifeq L270 
L254:   iload 6 
L256:   ifne L264 
L259:   iload 7 
L261:   ifeq L270 
L264:   iconst_5 
L265:   istore 10 
L267:   goto L369 
L270:   iload 5 
L272:   ifne L287 
L275:   iload 6 
L277:   ifeq L287 
L280:   bipush 6 
L282:   istore 10 
L284:   goto L369 
L287:   iload 8 
L289:   ifeq L299 
L292:   bipush 7 
L294:   istore 10 
L296:   goto L369 
L299:   iload 5 
L301:   ifne L316 
L304:   iload 7 
L306:   ifeq L316 
L309:   bipush 8 
L311:   istore 10 
L313:   goto L369 
L316:   aload_0 
L317:   getfield [13] 
L320:   invokestatic [3] 
L323:   ldc [4] 
L325:   ldc [6] 
L327:   aload_1 
L328:   getfield [14] 
L331:   i2l 
L332:   aload_1 
L333:   getfield [15] 
L336:   i2l 
L337:   invokevirtual [16] 
L340:   pop 
L341:   goto L369 
L344:   aload_0 
L345:   getfield [13] 
L348:   invokestatic [3] 
L351:   ldc [4] 
L353:   ldc [7] 
L355:   aload_1 
L356:   getfield [14] 
L359:   i2l 
L360:   aload_1 
L361:   getfield [15] 
L364:   i2l 
L365:   invokevirtual [16] 
L368:   pop 
L369:   iload 10 
L371:   areturn 
L372:   
    .end code 
.end method 

.method synthetic [86] : [87] 
    .attribute [81] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [17] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [20] [21] 
.const [3] = Method [22] [23] 
.const [4] = Int -1601830656 
.const [5] = String [24] 
.const [6] = String [25] 
.const [7] = String [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Class [31] 
.const [13] = Field [32] [33] 
.const [14] = Field [34] [35] 
.const [15] = Field [36] [37] 
.const [16] = Method [38] [39] 
.const [17] = Method [40] [41] 
.const [18] = Method [42] [43] 
.const [19] = Field [44] [45] 
.const [20] = Class [46] 
.const [21] = NameAndType [47] [48] 
.const [22] = Class [49] 
.const [23] = NameAndType [50] [51] 
.const [24] = Utf8 'ColumnIndexGenerator#getColumnIndex(), 2 arrows, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)' 
.const [25] = Utf8 'ColumnIndexGenerator#getColumnIndex(), 3 arrows, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)' 
.const [26] = Utf8 'ColumnIndexGenerator#getColumnIndex(), more than 3 arrows or has no arrow, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)' 
.const [27] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$ColumnIndexGenerator 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 org/dsi/ifc/navigation/NavLaneGuidanceData 
.const [30] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper 
.const [47] = Utf8 access$100 
.const [48] = Utf8 (Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper;S)I 
.const [49] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper 
.const [50] = Utf8 access$200 
.const [51] = Utf8 (Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper;)Lde/audi/atip/log/LogChannel; 
.const [52] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$ColumnIndexGenerator 
.const [53] = Utf8 this$0 
.const [54] = Utf8 Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper; 
.const [55] = Utf8 org/dsi/ifc/navigation/NavLaneGuidanceData 
.const [56] = Utf8 laneDirection 
.const [57] = Utf8 S 
.const [58] = Utf8 org/dsi/ifc/navigation/NavLaneGuidanceData 
.const [59] = Utf8 laneType 
.const [60] = Utf8 S 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;JJ)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$ColumnIndexGenerator 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper;)V 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$ColumnIndexGenerator 
.const [71] = Utf8 this$0 
.const [72] = Utf8 Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper; 
.const [73] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$ColumnIndexGenerator 
.const [74] = Class [73] 
.const [75] = Utf8 java/lang/Object 
.const [76] = Class [75] 
.const [77] = Utf8 de/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$ColumnIndexGenerateStrategy 
.const [78] = Class [77] 
.const [79] = Utf8 this$0 
.const [80] = Utf8 Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper; 
.const [81] = Utf8 Code 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper;)V 
.const [84] = Utf8 getColumnIndex 
.const [85] = Utf8 (Lorg/dsi/ifc/navigation/NavLaneGuidanceData;)I 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper;Lde/audi/tghu/navi/app/map/routeinfo/LaneGuidanceWrapper$1;)V 
.end class 
