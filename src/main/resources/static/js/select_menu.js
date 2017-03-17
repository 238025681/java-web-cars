$(function () {
	// bind change event to select
	$('#makers').on('change', function () {
		var url = $(this).val(); // get selected value
		if (url) { // require a URL
			window.location = url; // redirect
		}
		return false;
	});
});

$("#makers").prop("selectedIndex", -1);

$('.ls-modal').on('click', function(e){
  e.preventDefault();
  $('.custom-modal').modal('show').find('.modal-body').load($(this).attr('href'));
});