$( document ).ready(function() {
	
	$('#guardar').click(function() {
		$('#formPersona').attr('method', 'post');
		$('#formPersona').attr('action', '/persona/guardar');
		$('#formPersona').submit();
	});
	
	$('#cancelar').click(function() {
		$('#formPersona').find('input[type=text]').val('');
		window.location.href = '/persona/persona-buscar';
	});


});




