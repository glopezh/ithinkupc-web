$( document ).ready(function() {
	
	$('#buscar').click(function() {
		$('#formRolBuscar').attr('method', 'get');
		$('#formRolBuscar').attr('action', '/rol/rol-buscar');
		$('#formRolBuscar').submit();
	});


	$('#limpiar').click(function() {
		$('#formRolBuscar').find('input[type=text]').val('');
		$('#registros-rol').html('');
	});
	
	
	$('#formRolBuscar').keypress(function (e){
		code = e.keyCode ? e.keyCode : e.which;
        if(code.toString() == 13) {
        	$('#buscar').click();
        }
    });


	$('#alta').click(function() {
		window.location.href = '/rol/alta';
	});

	$('#registros-rol').on('click', '.eliminar-rol', function() {
		var idRol = $(this).data('id-rol');
		window.location.href = '/rol/delete/' + idRol;
	});

});




