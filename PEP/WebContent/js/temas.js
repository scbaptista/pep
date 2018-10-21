var getModal = function(idModal, idButton){
	// Get the modal
	var modal = document.getElementById(idModal);

	// Get the button that opens the modal
	var btn = document.getElementById(idButton);

	console.log('btn: ',btn);

	// Get the <span> element that closes the modal
	//var span = document.getElementsByClassName("close")[0];

	// When the user clicks the button, open the modal 
	btn.onclick = function() {
	    modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	//span.onclick = function() {
	  //  modal.style.display = "none";
	//}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
}


var getTemaCanselBtn = function(idModal){
	var modal = document.getElementById(idModal);
	modal.style.display = "none";
}

var getTemaSaveBtn = function(idModal){

	var modal = document.getElementById(idModal);

	var desg = document.getElementById("temaDesg").value; 
	var des = document.getElementById("temaDes").value; 


}