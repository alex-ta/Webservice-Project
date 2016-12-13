var x = "";

$(document).ready(function() {
	 $.ajax({
			 url: "http://localhost:8080/helloworld/rest/users",
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
  		         "Accept": "application/json"
			 }
	 }).then(function(data) {
		 x = data;
		 for(var i = 0; i < data.length; i++){
		 	createInputField(data[i], document.getElementById("content"))
		 }
	 });
});


function createInputField(ob, root){
	var keys = Object.keys(ob);
	var table = document.createElement("table");
	root.appendChild(table);

	
	for(var i = 0; i < keys.length; i++){
		var k = keys[i];
		var o = ob[k];
		if(k == "image"){
			var img = document.createElement("IMG");
			img.setAttribute('src', o);
			img.setAttribute('width', "40px");
			img.setAttribute('height', "40px");
			img.setAttribute('alt', k);
			root.insertBefore(img, table);
		} else if(o instanceof Object){
			createInputField(o, table);
		} else {
			addRow(k,o);
		}
	}
	
	function addRow(key, val){
		var tr = document.createElement("tr");
		var td_k = document.createElement("td");
		td_k.innerHTML=""+key;
		var td_v = document.createElement("td");
		var td_in = document.createElement("input");
		td_in.setAttribute('value',val);
		td_v.appendChild(td_in);
		tr.appendChild(td_k);
		tr.appendChild(td_v);
		table.appendChild(tr);
	}
	
}
