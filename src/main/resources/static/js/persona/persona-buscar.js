$( document ).ready(function() {
	
	$('#buscar').click(function() {
		$('#formPersonaBuscar').attr('method', 'get');
		$('#formPersonaBuscar').attr('action', '/persona/persona-buscar');
		$('#formPersonaBuscar').submit();
	});


	$('#limpiar').click(function() {
		$('#formPersonaBuscar').find('input[type=text]').val('');
		$('#registros-persona').html('');
	});
	
	
	$('#formPersonaBuscar').keypress(function (e){
		code = e.keyCode ? e.keyCode : e.which;
        if(code.toString() == 13) {
        	$('#buscar').click();
        }
    });


	$('#alta').click(function() {
		window.location.href = '/persona/alta';
	});


	$('#registros-persona').on('click', '.editar-persona', function() {
		var idPersona = $(this).data('id-persona');
		window.location.href = '/persona/' + idPersona;
	});


	$('#registros-persona').on('click', '.eliminar-persona', function() {
		var idPersona = $(this).data('id-persona');
		window.location.href = '/persona/delete/' + idPersona;
	});

});




