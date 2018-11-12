var getMsgSessaoModal = function(idModal, msg){
	console.log('modal',msg);
  // Get the modal
  var modal = document.getElementById(idModal);
  modal.style.display = "block";

  document.getElementById('msgSessaoResult').innerHTML = msg;

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
      if (event.target == modal) {
      	console.log('clickclose');
      		getListSessaoBtn();
          modal.style.display = "none";

      }
  }
}

var getMsgCanselBtn = function(idModal){
	console.log('clickclose');
  var modal = document.getElementById(idModal);
  getListSessaoBtn();
  modal.style.display = "none";
}


var getSessaoSaveBtn = function(idModal){
	var modal = document.getElementById(idModal);
	console.log('modelSessao: ', modal);
	var des = document.getElementById("sessaoD").value; 
}

var addSessaoBtn = function(idModal){
	var des = document.getElementById("sessaoD").value; 
	var json = {'des':des};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  console.log(this.responseText);
		  var obj = JSON.parse(this.responseText);
		  var modal = document.getElementById(idModal);
		  modal.style.display = "none";
		  getMsgSessaoModal('msgSessaoModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=2&token="+token, false);
	xhttp.send();
}



var removeSessaoBtn = function(id){

	var json = {'id':id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  console.log(this.responseText);
		   var obj = JSON.parse(this.responseText);
		   getMsgSessaoModal('msgSessaoModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=4&token="+token, false);
	xhttp.send();
}

var getListSessaoBtn = function(idModal){
	console.log('getListSessaoBtn');
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  var obj = JSON.parse(this.responseText);
		  var resutHeader = '<div class="table-wrapper-scroll-y"><table class="table table-bordered table-striped">'
		  +'<tbody><tr>'
		  +'<th><i class="icon_profile" id="idSessao"></i> ID</th>'
		  +'<th><i class="icon_profile"></i> Designação</th>'
		  +'<th><i class="icon_cogs"></i></th>'
		  +'</tr>';

		  var resultContent = '';

		  var resultFooter = '</tbody> </table></div>';
		  for (i in obj) {
            resultContent = resultContent
            +'<tr>'
                +'<td>'+obj[i].id+'</td>'
                +'<td>'+obj[i].designacao+'</td>'
                +'<td>'
                	+'<div class="btn-group">'
                		+'<a class="btn btn-primary" href="#" onclick="javascript:editSessaoBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-edit"></i></a>'
                        +'<a class="btn btn-danger" href="#" onclick="javascript:removeSessaoBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-trash"></i></a>'
                    +'</div>'
                +'</td>'
            +'</tr>';   
		  }
		  var resultFinal = (resutHeader + resultContent + resultFooter);
		  document.getElementById('tableSessao').innerHTML = resultFinal;

		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=5", false);
	xhttp.send();
}


var editSessaoBtn = function(id){
	var json = {'id':id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var obj = JSON.parse(this.responseText);
			console.log(obj);
			document.getElementById("editSessaoD").value = obj[0].info_sessao; 
			document.getElementById('editSessaoModal').setAttribute('name',id);
			getModal('editSessaoModal');
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=1&token="+token, false);
	xhttp.send();
}


var updateSessaoBtn = function(idModal){
  var id = document.getElementById(idModal).getAttribute("name");
  var des = document.getElementById("editSessaoD").value;

  var json = {'id':id,'des':des};

  var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
      var obj = JSON.parse(this.responseText);
      var modal = document.getElementById(idModal);
      console.log(modal);
      modal.style.display = "none";
      getMsgSessaoModal('msgSessaoModal',obj.msg);
    }
  };

  xhttp.open("POST", "http://localhost:8080/PEP/serv/sessao?op=3&token="+token, false);
  xhttp.send();
}