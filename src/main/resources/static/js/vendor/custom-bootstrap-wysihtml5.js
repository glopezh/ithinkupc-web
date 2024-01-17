
var customTemplateWYSWYG = {
		
		// TODO: REEMPLAZAR los literales javascript por el I18N de Spring
		
		"font-styles" : function(locale, options) {
			  return "<li class='dropdown'>" +
              "<a class='btn btn-default btn-sm dropdown-toggle' data-toggle='dropdown' href='#'>" +
              "<i class='icon-font'></i>&nbsp;<span class='current-font'>" + "Normal" + "</span>&nbsp;<b class='caret'></b>" +
              "</a>" +
              "<ul class='dropdown-menu'>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='div' tabindex='-1'>" + "Normal" + "</a></li>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='h1' tabindex='-1'>" + "Títol 1" + "</a></li>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='h2' tabindex='-1'>" + "Títol 2" + "</a></li>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='h3' tabindex='-1'>" + "Títol 3" + "</a></li>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='h4'>" + "Títol 4" + "</a></li>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='h5'>" + "Títol 5" + "</a></li>" +
                "<li><a data-wysihtml5-command='formatBlock' data-wysihtml5-command-value='h6'>" + "Títol 6" + "</a></li>" +
              "</ul>" +
            "</li>";
		},
		
	  "emphasis": function(locale, options) {
            var size = (options && options.size) ? ' btn-'+options.size : '';
            return "<li>" +
              "<div class='btn-group'>" +
                "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='bold' title='CTRL+B' tabindex='-1'>" + "Negreta" + "</a>" +
                "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='italic' title='CTRL+I' tabindex='-1'>" + "Cursiva" + "</a>" +
                "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='underline' title='CTRL+U' tabindex='-1'>" + "Subratllat" + "</a>" +
              "</div>" +
            "</li>";
        },
        
	  "lists": function(locale, options) {
          var size = (options && options.size) ? ' btn-'+options.size : '';
          return "<li>" +
            "<div class='btn-group'>" +
              "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='insertUnorderedList' title='" + locale.lists.unordered + 
		"' tabindex='-1'><i class='fa fa-list'></i></a>" +
              "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='insertOrderedList' title='" + locale.lists.ordered + 
		"' tabindex='-1'><i class='fa fa-th-list'></i></a>" +
              "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='Outdent' title='" + locale.lists.outdent + 
		"' tabindex='-1'><i class='fa fa-outdent'></i></a>" +
              "<a class='btn btn-default btn-sm" + size + "' data-wysihtml5-command='Indent' title='" + locale.lists.indent + 
		"' tabindex='-1'><i class='fa fa-indent'></i></a>" +
            "</div>" +
          "</li>";
      }
}
	

