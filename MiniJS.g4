grammar MiniJS; // اسم الجرامر، لازم يطابق اسم الملف MiniJS.g4 وإلا ANTLR يعطي خطأ.
// ❌ خطأ شائع: كتابة الاسم بحروف مختلفة مثل miniJS أو MiniJs → لازم بالضبط مثل اسم الملف.

// ---------- PARSER RULES ----------
program
    : statement* EOF // القاعدة الأساسية: برنامج مكون من صفر أو أكثر من العبارات ثم نهاية الملف.
    ; // ❌ خطأ شائع: نسيان الـ EOF أو نسيان الفاصلة المنقوطة في النهاية.

statement
    : variableDecl // تعريف متغير
    | functionDecl // تعريف دالة
    | ifStatement // جملة شرطية
    | whileStatement // جملة تكرار while
    | forStatement // جملة تكرار for
    | returnStatement // جملة إرجاع
    | expressionStatement // جملة تعبير
    | block // كتلة أكواد {}
    ; // ❌ خطأ شائع: نسيان الفاصلة المنقوطة أو وضع فاصلة بدل " | " بين الخيارات.

block
    : '{' statement* '}' // الكتلة محصورة بين أقواس مع صفر أو أكثر من العبارات.
    ; // ❌ خطأ شائع: نسيان الأقواس أو نسيان النجمة بعد statement.

variableDecl
    : ('let' | 'const' | 'var') Identifier ('=' expression)? ';' // تعريف متغير مع خيار التعيين.
    ; // ❌ خطأ شائع: نسيان الأقواس حول let|const|var، أو نسيان الفاصلة المنقوطة.

functionDecl
    : 'function' Identifier '(' parameterList? ')' block // تعريف دالة.
    ; // ❌ خطأ شائع: كتابة (parameterList)* بدل ? يؤدي إلى خطأ في استدعاءات بدون بارامترات.

parameterList
    : Identifier (',' Identifier)* // قائمة المعاملات: a, b, c
    ; // ❌ خطأ شائع: نسيان الفاصلة بعد Identifier أو نسيان النجمة.

ifStatement
    : 'if' '(' expression ')' statement ('else' statement)? // جملة if مع else اختياري.
    ; // ❌ خطأ شائع: نسيان الأقواس حول expression أو وضع سيمي كولون بعد statement.

whileStatement
    : 'while' '(' expression ')' statement // جملة تكرار while.
    ; // ❌ خطأ شائع: نسيان القوسين أو كتابة { بدل statement.

forStatement
    : 'for' '(' (variableDecl | expressionStatement | ';') // جملة for: تهيئة
      expression? ';' // شرط اختياري
      expression? ')' statement // زيادة اختياري ثم الجسد
    ; // ❌ خطأ شائع: نسيان أحد الفواصل المنقوطة أو الأقواس.

returnStatement
    : 'return' expression? ';' // جملة إرجاع مع تعبير اختياري.
    ; // ❌ خطأ شائع: نسيان الفاصلة المنقوطة أو كتابة expression بدون ?.

expressionStatement
    : expression ';' // أي تعبير متبوع بـ ;
    ; // ❌ خطأ شائع: نسيان السيمي كولون.


// ---------- EXPRESSIONS ----------
expression
    : assignmentExpression // التعبير الأساسي هو تعبير تعيين أو غيره.
    ; // ❌ خطأ شائع: نسيان تعريف expression في الأعلى أو الخلط مع expressionStatement.

assignmentExpression
    : leftHandSide '=' assignmentExpression   #AssignExpr // تعيين متغير (a = b)
    | logicalOrExpression                     #Expr // أو مجرد تعبير منطقي أو رياضي.
    ; // ❌ خطأ شائع: نسيان الرمز '=' أو وضع : بدلاً من # في تسمية البدائل.

leftHandSide
    : Identifier (('.' Identifier) | ('[' expression ']'))* // الجهة اليسرى: متغير، خاصية، أو عنصر مصفوفة.
    ; // ❌ خطأ شائع: نسيان النجمة * أو الأقواس المربعة.

logicalOrExpression
    : logicalAndExpression ( '||' logicalAndExpression )* // عمليات OR منطقية.
    ; // ❌ خطأ شائع: نسيان النجمة أو كتابة | بدون علامات اقتباس.

logicalAndExpression
    : equalityExpression ( '&&' equalityExpression )* // عمليات AND منطقية.
    ; // ❌ خطأ شائع: كتابة & بدلاً من '&&' أو نسيان علامات الاقتباس.

equalityExpression
    : relationalExpression (('==' | '!=' | '===') relationalExpression)* // مقارنة == != ===
    ; // ❌ خطأ شائع: نسيان الأقواس أو علامات الاقتباس حول الرموز.

relationalExpression
    : additiveExpression (('<' | '>' | '<=' | '>=') additiveExpression)* // علاقات > < >= <=
    ; // ❌ خطأ شائع: كتابة <= بدون علامات اقتباس → ANTLR يعطي syntax error.

additiveExpression
    : multiplicativeExpression (('+' | '-') multiplicativeExpression)* // جمع وطرح
    ; // ❌ خطأ شائع: نسيان النجمة * بعد القوس.

multiplicativeExpression
    : unaryExpression (('*' | '/' | '%') unaryExpression)* // ضرب وقسمة وباقي القسمة
    ; // ❌ خطأ شائع: كتابة % بدون علامات اقتباس أو نسيان النجمة بعد القوس.

unaryExpression
    : ('!' | '-' | '+') unaryExpression // تعبير أحادي
    | primaryExpression // أو تعبير أساسي (قيمة أو متغير)
    ; // ❌ خطأ شائع: نسيان الـ | بين البدائل.

primaryExpression
    : '(' expression ')' // تعبير داخل أقواس
    | literal // قيمة ثابتة
    | leftHandSide // متغير أو خاصية
    | functionCall // استدعاء دالة
    | objectLiteral // كائن {}
    | arrayLiteral // مصفوفة []
    ; // ❌ خطأ شائع: نسيان القوس الختامي أو كتابة * هنا بالخطأ.

functionCall
    : leftHandSide '(' argumentList? ')' // استدعاء دالة: func(a,b)
    ; // ❌ خطأ شائع: نسيان ? بعد argumentList أو وضع block بدل الأقواس.

argumentList
    : expression (',' expression)* // قائمة وسيطات
    ; // ❌ خطأ شائع: نسيان الفاصلة أو النجمة.

objectLiteral
    : '{' (property (',' property)*)? '}' // كائن يحتوي على خصائص
    ; // ❌ خطأ شائع: نسيان الأقواس أو النجمة بعد property.

property
    : Identifier ':' expression // خاصية: الاسم: القيمة
    ; // ❌ خطأ شائع: نسيان النقطتين أو كتابتها '=' بالخطأ.

arrayLiteral
    : '[' (expression (',' expression)*)? ']' // مصفوفة عناصر [1,2,3]
    ; // ❌ خطأ شائع: نسيان الفاصلة أو الأقواس المربعة.


// ---------- LITERALS ----------
literal
    : NumberLiteral // رقم
    | StringLiteral // نص
    | BooleanLiteral // true أو false
    | 'null' // قيمة فارغة
    ; // ❌ خطأ شائع: نسيان علامات الاقتباس حول null.


// ---------- LEXER RULES ----------
BooleanLiteral : 'true' | 'false' ; // القيم المنطقية.
NumberLiteral  : [0-9]+ ('.' [0-9]+)? ; // رقم صحيح أو عشري.
StringLiteral  : '"' (~["\\\r\n])* '"' | '\'' (~['\\\r\n])* '\'' ; // نص داخل "" أو ''
Identifier     : [a-zA-Z_$] [a-zA-Z0-9_$]* ; // اسم متغير أو دالة.
// ❌ أخطاء شائعة في القواعد السابقة:
// - نسيان علامات الاقتباس في true/false
// - نسيان الأقواس المربعة في التعابير النمطية
// - كتابة .* بدل (~["\\\r\n])* يؤدي لتداخل خاطئ أو أخطاء lexing.

WS             : [ \t\r\n]+ -> skip ; // تجاهل المسافات البيضاء.
LINE_COMMENT   : '//' ~[\r\n]* -> skip ; // تجاهل التعليقات على سطر واحد.
BLOCK_COMMENT  : '/*' .*? '*/' -> skip ; // تجاهل التعليقات المتعددة.
// ❌ خطأ شائع: نسيان -> skip أو كتابة .* بدل .*? مما يسبب تطابق زائد (greedy).
