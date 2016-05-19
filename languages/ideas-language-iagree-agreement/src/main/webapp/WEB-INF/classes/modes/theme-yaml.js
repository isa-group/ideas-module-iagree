ace.define("ace/theme/yaml",["require","exports","module","ace/lib/dom"], function(require, exports, module) {

exports.isDark = false;
exports.cssClass = "ace-yaml";
exports.cssText = ".ace-yaml .ace_gutter {\
background: #f6f6f6;\
color: #4D4D4C\
}\
.ace-yaml .ace_print-margin {\
width: 1px;\
background: #f6f6f6\
}\
.ace-yaml {\
background-color: #FFFFFF;\
color: #4D4D4C\
}\
.ace-yaml .ace_cursor {\
color: #AEAFAD\
}\
.ace-yaml .ace_marker-layer .ace_selection {\
background: #D6D6D6\
}\
.ace-yaml.ace_multiselect .ace_selection.ace_start {\
box-shadow: 0 0 3px 0px #FFFFFF;\
}\
.ace-yaml .ace_marker-layer .ace_step {\
background: rgb(255, 255, 0)\
}\
.ace-yaml .ace_marker-layer .ace_bracket {\
margin: -1px 0 0 -1px;\
border: 1px solid #D1D1D1\
}\
.ace-yaml .ace_marker-layer .ace_active-line {\
background: #EFEFEF\
}\
.ace-yaml .ace_gutter-active-line {\
background-color : #dcdcdc\
}\
.ace-yaml .ace_marker-layer .ace_selected-word {\
border: 1px solid #D6D6D6\
}\
.ace-yaml .ace_invisible {\
color: #D1D1D1\
}\
.ace-yaml .ace_keyword,\
.ace-yaml .ace_meta,\
.ace-yaml .ace_storage,\
.ace-yaml .ace_storage.ace_type,\
.ace-yaml .ace_support.ace_type {\
color: #8959A8\
}\
.ace-yaml .ace_keyword.ace_operator {\
color: #3E999F\
}\
.ace-yaml .ace_constant.ace_character,\
.ace-yaml .ace_constant.ace_language,\
.ace-yaml .ace_constant.ace_numeric,\
.ace-yaml .ace_keyword.ace_other.ace_unit,\
.ace-yaml .ace_support.ace_constant,\
.ace-yaml .ace_variable.ace_parameter {\
color: #F5871F\
}\
.ace-yaml .ace_constant.ace_other {\
color: #666969\
}\
.ace-yaml .ace_invalid {\
color: #FFFFFF;\
background-color: #C82829\
}\
.ace-yaml .ace_invalid.ace_deprecated {\
color: #FFFFFF;\
background-color: #8959A8\
}\
.ace-yaml .ace_fold {\
background-color: #4271AE;\
border-color: #4D4D4C\
}\
.ace-yaml .ace_entity.ace_name.ace_function,\
.ace-yaml .ace_support.ace_function,\
.ace-yaml .ace_variable {\
color: #4271AE\
}\
.ace-yaml .ace_support.ace_class,\
.ace-yaml .ace_support.ace_type {\
color: #C99E00\
}\
.ace-yaml .ace_heading,\
.ace-yaml .ace_markup.ace_heading,\
.ace-yaml .ace_string {\
color: #718C00\
}\
.ace-yaml .ace_entity.ace_name.ace_tag,\
.ace-yaml .ace_entity.ace_other.ace_attribute-name,\
.ace-yaml .ace_meta.ace_tag,\
.ace-yaml .ace_string.ace_regexp,\
.ace-yaml .ace_variable {\
color: #C82829\
}\
.ace-yaml .ace_comment {\
color: #8E908C\
}\
.ace-yaml .ace_indent-guide {\
background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAACCAYAAACZgbYnAAAAE0lEQVQImWP4////f4bdu3f/BwAlfgctduB85QAAAABJRU5ErkJggg==) right repeat-y\
}";

var dom = require("../lib/dom");
dom.importCssString(exports.cssText, exports.cssClass);
});