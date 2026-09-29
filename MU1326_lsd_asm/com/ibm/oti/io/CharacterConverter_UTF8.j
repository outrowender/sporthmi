.version 50 0 
.class super [24] 
.super [26] 

.method annotation [28] : [29] 
    .attribute [27] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [30] : [31] 
    .attribute [27] .code stack 4 locals 4 
L0:     iload_3 
L1:     ifge L12 
L4:     new [9] 
L7:     dup 
L8:     invokespecial [8] 
L11:    athrow 
L12:    iload_2 
L13:    iload_3 
L14:    iadd 
L15:    istore 4 
L17:    iconst_0 
L18:    istore 5 
L20:    iload_2 
L21:    istore 6 
L23:    goto L329 
L26:    aload_1 
L27:    iload 6 
L29:    baload 
L30:    istore 7 
L32:    iload 7 
L34:    iflt L43 
L37:    iinc 6 1 
L40:    goto L326 
L43:    iload 7 
L45:    sipush 224 
L48:    iand 
L49:    sipush 192 
L52:    if_icmpne L107 
L55:    iload 6 
L57:    iconst_1 
L58:    iadd 
L59:    iload 4 
L61:    if_icmpge L336 
L64:    aload_1 
L65:    iload 6 
L67:    iconst_1 
L68:    iadd 
L69:    baload 
L70:    sipush 192 
L73:    iand 
L74:    sipush 128 
L77:    if_icmpne L86 
L80:    iinc 6 2 
L83:    goto L326 
L86:    iload 5 
L88:    ifne L95 
L91:    iconst_m1 
L92:    goto L97 
L95:    iload 5 
L97:    areturn 
L98:    goto L326 
L101:   goto L336 
L104:   goto L326 
L107:   iload 7 
L109:   sipush 240 
L112:   iand 
L113:   sipush 224 
L116:   if_icmpne L187 
L119:   iload 6 
L121:   iconst_2 
L122:   iadd 
L123:   iload 4 
L125:   if_icmpge L336 
L128:   aload_1 
L129:   iload 6 
L131:   iconst_1 
L132:   iadd 
L133:   baload 
L134:   sipush 192 
L137:   iand 
L138:   sipush 128 
L141:   if_icmpne L166 
L144:   aload_1 
L145:   iload 6 
L147:   iconst_2 
L148:   iadd 
L149:   baload 
L150:   sipush 192 
L153:   iand 
L154:   sipush 128 
L157:   if_icmpne L166 
L160:   iinc 6 3 
L163:   goto L326 
L166:   iload 5 
L168:   ifne L175 
L171:   iconst_m1 
L172:   goto L177 
L175:   iload 5 
L177:   areturn 
L178:   goto L326 
L181:   goto L336 
L184:   goto L326 
L187:   iload 7 
L189:   sipush 248 
L192:   iand 
L193:   sipush 240 
L196:   if_icmpne L314 
L199:   iload 6 
L201:   iconst_3 
L202:   iadd 
L203:   iload 4 
L205:   if_icmpge L336 
L208:   aload_1 
L209:   iload 6 
L211:   iconst_1 
L212:   iadd 
L213:   baload 
L214:   sipush 192 
L217:   iand 
L218:   sipush 128 
L221:   if_icmpne L293 
L224:   aload_1 
L225:   iload 6 
L227:   iconst_2 
L228:   iadd 
L229:   baload 
L230:   sipush 192 
L233:   iand 
L234:   sipush 128 
L237:   if_icmpne L293 
L240:   aload_1 
L241:   iload 6 
L243:   iconst_3 
L244:   iadd 
L245:   baload 
L246:   sipush 192 
L249:   iand 
L250:   sipush 128 
L253:   if_icmpne L293 
L256:   iload 7 
L258:   bipush 7 
L260:   iand 
L261:   iconst_2 
L262:   ishl 
L263:   aload_1 
L264:   iload 6 
L266:   iconst_1 
L267:   iadd 
L268:   baload 
L269:   iconst_4 
L270:   ishr 
L271:   iconst_3 
L272:   iand 
L273:   ior 
L274:   iconst_1 
L275:   isub 
L276:   bipush 31 
L278:   iand 
L279:   bipush 16 
L281:   if_icmpge L293 
L284:   iinc 6 4 
L287:   iinc 5 1 
L290:   goto L326 
L293:   iload 5 
L295:   ifne L302 
L298:   iconst_m1 
L299:   goto L304 
L302:   iload 5 
L304:   areturn 
L305:   goto L326 
L308:   goto L336 
L311:   goto L326 
L314:   iload 5 
L316:   ifne L323 
L319:   iconst_m1 
L320:   goto L325 
L323:   iload 5 
L325:   areturn 
L326:   iinc 5 1 
L329:   iload 6 
L331:   iload 4 
L333:   if_icmplt L26 
L336:   iload 5 
L338:   areturn 
L339:   nop 
L340:   
    .end code 
.end method 

.method public [32] : [33] 
    .attribute [27] .code stack 5 locals 2 
L0:     iload 4 
L2:     iload 5 
L4:     iadd 
L5:     istore 6 
L7:     goto L215 
L10:    aload_1 
L11:    iload_2 
L12:    iinc 2 1 
L15:    baload 
L16:    istore 7 
L18:    iload 7 
L20:    iflt L36 
L23:    aload_3 
L24:    iload 4 
L26:    iinc 4 1 
L29:    iload 7 
L31:    i2c 
L32:    castore 
L33:    goto L215 
L36:    iload 7 
L38:    sipush 224 
L41:    iand 
L42:    sipush 192 
L45:    if_icmpne L77 
L48:    aload_3 
L49:    iload 4 
L51:    iinc 4 1 
L54:    iload 7 
L56:    bipush 31 
L58:    iand 
L59:    bipush 6 
L61:    ishl 
L62:    aload_1 
L63:    iload_2 
L64:    iinc 2 1 
L67:    baload 
L68:    bipush 63 
L70:    iand 
L71:    iadd 
L72:    i2c 
L73:    castore 
L74:    goto L215 
L77:    iload 7 
L79:    sipush 240 
L82:    iand 
L83:    sipush 224 
L86:    if_icmpne L131 
L89:    aload_3 
L90:    iload 4 
L92:    iinc 4 1 
L95:    iload 7 
L97:    bipush 15 
L99:    iand 
L100:   bipush 12 
L102:   ishl 
L103:   aload_1 
L104:   iload_2 
L105:   iinc 2 1 
L108:   baload 
L109:   bipush 63 
L111:   iand 
L112:   bipush 6 
L114:   ishl 
L115:   iadd 
L116:   aload_1 
L117:   iload_2 
L118:   iinc 2 1 
L121:   baload 
L122:   bipush 63 
L124:   iand 
L125:   iadd 
L126:   i2c 
L127:   castore 
L128:   goto L215 
L131:   aload_3 
L132:   iload 4 
L134:   iinc 4 1 
L137:   iload 7 
L139:   bipush 7 
L141:   iand 
L142:   iconst_2 
L143:   ishl 
L144:   aload_1 
L145:   iload_2 
L146:   baload 
L147:   iconst_4 
L148:   ishr 
L149:   iconst_3 
L150:   iand 
L151:   iadd 
L152:   iconst_1 
L153:   isub 
L154:   bipush 6 
L156:   ishl 
L157:   aload_1 
L158:   iload_2 
L159:   iinc 2 1 
L162:   baload 
L163:   bipush 15 
L165:   iand 
L166:   iconst_2 
L167:   ishl 
L168:   iadd 
L169:   aload_1 
L170:   iload_2 
L171:   baload 
L172:   iconst_4 
L173:   ishr 
L174:   iconst_3 
L175:   iand 
L176:   iadd 
L177:   ldc [4] 
L179:   iadd 
L180:   i2c 
L181:   castore 
L182:   aload_3 
L183:   iload 4 
L185:   iinc 4 1 
L188:   aload_1 
L189:   iload_2 
L190:   iinc 2 1 
L193:   baload 
L194:   bipush 15 
L196:   iand 
L197:   bipush 6 
L199:   ishl 
L200:   aload_1 
L201:   iload_2 
L202:   iinc 2 1 
L205:   baload 
L206:   bipush 63 
L208:   iand 
L209:   iadd 
L210:   ldc [5] 
L212:   iadd 
L213:   i2c 
L214:   castore 
L215:   iload 4 
L217:   iload 6 
L219:   if_icmplt L10 
L222:   iload_2 
L223:   areturn 
L224:   
    .end code 
.end method 

.method public [34] : [35] 
    .attribute [27] .code stack 6 locals 6 
L0:     iconst_0 
L1:     istore 4 
L3:     iload_2 
L4:     iload_3 
L5:     iadd 
L6:     istore 5 
L8:     goto L98 
L11:    aload_1 
L12:    iload 5 
L14:    caload 
L15:    istore 6 
L17:    iload 6 
L19:    sipush 128 
L22:    if_icmpge L31 
L25:    iinc 4 1 
L28:    goto L98 
L31:    iload 6 
L33:    sipush 2048 
L36:    if_icmpge L45 
L39:    iinc 4 2 
L42:    goto L98 
L45:    iload 6 
L47:    ldc [5] 
L49:    if_icmplt L95 
L52:    iload 6 
L54:    ldc [6] 
L56:    if_icmpge L95 
L59:    iload 5 
L61:    ifle L95 
L64:    aload_1 
L65:    iload 5 
L67:    iconst_1 
L68:    isub 
L69:    caload 
L70:    ldc [4] 
L72:    if_icmplt L95 
L75:    aload_1 
L76:    iload 5 
L78:    iconst_1 
L79:    isub 
L80:    caload 
L81:    ldc [5] 
L83:    if_icmpge L95 
L86:    iinc 5 -1 
L89:    iinc 4 4 
L92:    goto L98 
L95:    iinc 4 3 
L98:    iinc 5 -1 
L101:   iload 5 
L103:   iload_2 
L104:   if_icmpge L11 
L107:   iload 4 
L109:   newarray byte 
L111:   astore 5 
L113:   aload 5 
L115:   arraylength 
L116:   istore 6 
L118:   iload_2 
L119:   iload_3 
L120:   iadd 
L121:   istore 7 
L123:   goto L420 
L126:   aload_1 
L127:   iload 7 
L129:   caload 
L130:   istore 8 
L132:   iload 8 
L134:   sipush 128 
L137:   if_icmpge L154 
L140:   aload 5 
L142:   iinc 6 -1 
L145:   iload 6 
L147:   iload 8 
L149:   i2b 
L150:   bastore 
L151:   goto L420 
L154:   iload 8 
L156:   sipush 2048 
L159:   if_icmpge L201 
L162:   aload 5 
L164:   iinc 6 -1 
L167:   iload 6 
L169:   sipush 128 
L172:   iload 8 
L174:   bipush 63 
L176:   iand 
L177:   ior 
L178:   i2b 
L179:   bastore 
L180:   aload 5 
L182:   iinc 6 -1 
L185:   iload 6 
L187:   sipush 192 
L190:   iload 8 
L192:   bipush 6 
L194:   ishr 
L195:   ior 
L196:   i2b 
L197:   bastore 
L198:   goto L420 
L201:   iload 8 
L203:   ldc [5] 
L205:   if_icmplt L363 
L208:   iload 8 
L210:   ldc [6] 
L212:   if_icmpge L363 
L215:   iload 7 
L217:   ifle L363 
L220:   aload_1 
L221:   iload 7 
L223:   iconst_1 
L224:   isub 
L225:   caload 
L226:   ldc [4] 
L228:   if_icmplt L363 
L231:   aload_1 
L232:   iload 7 
L234:   iconst_1 
L235:   isub 
L236:   caload 
L237:   ldc [5] 
L239:   if_icmpge L363 
L242:   aload_1 
L243:   iload 7 
L245:   iconst_1 
L246:   isub 
L247:   caload 
L248:   sipush 960 
L251:   iand 
L252:   bipush 64 
L254:   iadd 
L255:   istore 9 
L257:   aload 5 
L259:   iinc 6 -1 
L262:   iload 6 
L264:   sipush 128 
L267:   iload 8 
L269:   bipush 63 
L271:   iand 
L272:   ior 
L273:   i2b 
L274:   bastore 
L275:   aload 5 
L277:   iinc 6 -1 
L280:   iload 6 
L282:   sipush 128 
L285:   iload 8 
L287:   bipush 6 
L289:   ishr 
L290:   bipush 15 
L292:   iand 
L293:   ior 
L294:   aload_1 
L295:   iload 7 
L297:   iconst_1 
L298:   isub 
L299:   caload 
L300:   iconst_3 
L301:   iand 
L302:   iconst_4 
L303:   ishl 
L304:   ior 
L305:   i2b 
L306:   bastore 
L307:   aload 5 
L309:   iinc 6 -1 
L312:   iload 6 
L314:   sipush 128 
L317:   aload_1 
L318:   iload 7 
L320:   iconst_1 
L321:   isub 
L322:   caload 
L323:   iconst_2 
L324:   ishr 
L325:   bipush 15 
L327:   iand 
L328:   ior 
L329:   iload 9 
L331:   iconst_2 
L332:   ishr 
L333:   bipush 48 
L335:   iand 
L336:   ior 
L337:   i2b 
L338:   bastore 
L339:   aload 5 
L341:   iinc 6 -1 
L344:   iload 6 
L346:   sipush 240 
L349:   iload 9 
L351:   bipush 8 
L353:   ishr 
L354:   ior 
L355:   i2b 
L356:   bastore 
L357:   iinc 7 -1 
L360:   goto L420 
L363:   aload 5 
L365:   iinc 6 -1 
L368:   iload 6 
L370:   sipush 128 
L373:   iload 8 
L375:   bipush 63 
L377:   iand 
L378:   ior 
L379:   i2b 
L380:   bastore 
L381:   aload 5 
L383:   iinc 6 -1 
L386:   iload 6 
L388:   sipush 128 
L391:   iload 8 
L393:   bipush 6 
L395:   ishr 
L396:   bipush 63 
L398:   iand 
L399:   ior 
L400:   i2b 
L401:   bastore 
L402:   aload 5 
L404:   iinc 6 -1 
L407:   iload 6 
L409:   sipush 224 
L412:   iload 8 
L414:   bipush 12 
L416:   ishr 
L417:   ior 
L418:   i2b 
L419:   bastore 
L420:   iinc 7 -1 
L423:   iload 7 
L425:   iload_2 
L426:   if_icmpge L126 
L429:   aload 5 
L431:   areturn 
L432:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Class [11] 
.const [4] = Int 14155776 
.const [5] = Int 14417920 
.const [6] = Int 14680064 
.const [7] = Method [12] [13] 
.const [8] = Method [14] [15] 
.const [9] = Class [16] 
.const [10] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [11] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [12] = Class [17] 
.const [13] = NameAndType [18] [19] 
.const [14] = Class [20] 
.const [15] = NameAndType [21] [22] 
.const [16] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [17] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [18] = Utf8 <init> 
.const [19] = Utf8 ()V 
.const [20] = Utf8 java/lang/StringIndexOutOfBoundsException 
.const [21] = Utf8 <init> 
.const [22] = Utf8 ()V 
.const [23] = Utf8 com/ibm/oti/io/CharacterConverter_UTF8 
.const [24] = Class [23] 
.const [25] = Utf8 com/ibm/oti/io/CharacterConverter 
.const [26] = Class [25] 
.const [27] = Utf8 Code 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 countChars 
.const [31] = Utf8 ([BII)I 
.const [32] = Utf8 convert 
.const [33] = Utf8 ([BI[CII)I 
.const [34] = Utf8 convert 
.const [35] = Utf8 ([CII)[B 
.end class 
