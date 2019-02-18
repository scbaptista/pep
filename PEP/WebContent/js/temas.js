var getMsgTemaModal = function(idModal, msg){
	console.log('modal',msg);
  // Get the modal
  var modal = document.getElementById(idModal);
  modal.style.display = "block";

  document.getElementById('msgTemaResult').innerHTML = msg;

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
      if (event.target == modal) {
      	getListTemasBtn();
        modal.style.display = "none";

      }
  }
}

var getTemaMsgCanselBtn = function(idModal){
  var modal = document.getElementById(idModal);
  getListTemasBtn();
  modal.style.display = "none";
}


var addTemaBtn = function(idModal){
	var temaDesg = document.getElementById("temaDesg").value;
  	var temaDes = document.getElementById("temaDes").value;

	var json = {'designacao':temaDesg, 'descricao':temaDes};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  console.log(this.responseText);
		  var obj = JSON.parse(this.responseText);
		  var modal = document.getElementById(idModal);
		  modal.style.display = "none";
		  getMsgTemaModal('msgTemaModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/tema?op=2&token="+token, false);
	xhttp.send();
}

var getListTemasBtn = function(idModal){
	console.log('getListTemasBtn');
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			
		  var obj = JSON.parse(this.responseText);
		  var resutHeader = '<div class="table-wrapper-scroll-y"><table class="table table-bordered table-striped">'
		  +'<tbody><tr>'
		  +'<th><i class="icon_profile" id="idTemas"></i> ID</th>'
		  +'<th><i class="icon_profile"></i> Designação</th>'
		  +'<th><i class="icon_profile"></i> Descrição</th>'
		  +'<th><i class="icon_cogs"></i></th>'
		  +'</tr>';

		  var resultContent = '';

		  var resultFooter = '</tbody> </table></div>';
		  for (i in obj) {
            resultContent = resultContent
            +'<tr>'
                +'<td>'+obj[i].id+'</td>'
                +'<td>'+obj[i].designacao+'</td>'
                +'<td>'+obj[i].descricao+'</td>'
                +'<td>'
                	+'<div class="btn-group">'
                		+'<a class="btn btn-primary" href="#" onclick="javascript:editTemaBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-edit"></i></a>'
                        +'<a class="btn btn-danger" href="#" onclick="javascript:removeTemaBtn('+obj[i].id+');" id="'+obj[i].id+'"><i class="fa fa-trash"></i></a>'
                    +'</div>'
                +'</td>'
            +'</tr>';   
		  }
		  var resultFinal = (resutHeader + resultContent + resultFooter);
		  
		  if (obj.length == 0) {
			  document.getElementById('tableTema').innerHTML = 'No results ....';
		  }else{
			  document.getElementById('tableTema').innerHTML = resultFinal;
		  }
		  

		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/tema?op=5", false);
	xhttp.send();
}

var removeTemaBtn = function(id){
	var json = {'id':id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  console.log(this.responseText);
		   var obj = JSON.parse(this.responseText);
		   getMsgTemaModal('msgTemaModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/tema?op=4&token="+token, false);
	xhttp.send();
}


var editTemaBtn = function(id){
	var json = {'id':id};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var obj = JSON.parse(this.responseText);
			console.log(obj);
			document.getElementById('edittemaDesg').value = obj[0].designacao;
			document.getElementById('edittemaDes').value = obj[0].descricao;
			document.getElementById('editTemaModal').setAttribute('name',id);
			getModal('editTemaModal');
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/tema?op=1&token="+token, false);
	xhttp.send();
}


var updateTemaBtn = function(idModal){
	var temaId = document.getElementById(idModal).getAttribute("name");
	var temaDesg = document.getElementById("edittemaDesg").value;
  	var temaDes = document.getElementById("edittemaDes").value;

	var json = {'id':temaId,'designacao':temaDesg, 'descricao':temaDes};

	var token = btoa(unescape(encodeURIComponent(JSON.stringify(json))));

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		  console.log(this.responseText);
		  var obj = JSON.parse(this.responseText);
		  var modal = document.getElementById(idModal);
		  console.log(modal);
		  modal.style.display = "none";
		  getMsgSessaoModal('msgTemaModal',obj.msg);
		}
	};

	xhttp.open("POST", "http://localhost:8080/PEP/serv/tema?op=3&token="+token, false);
	xhttp.send();
}