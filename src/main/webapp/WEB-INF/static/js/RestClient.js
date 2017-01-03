var x = "";
var baseUrl = "http://localhost:8080/helloworld/v1";

$(document).ready(function() {
	 $.ajax({
			 url: baseUrl+"/users/",
			 headers: {
				 "Authorization": "Basic " + btoa("User" + ":" + "aaaa"),
  		         "Accept": "application/json"
			 }
	 }).then(function(data) {
		 x = data;
		 for(var i = 0; i < data.length; i++){
		 	createInput(data[i], document.getElementById("content"), true)
		 }
	 });
});



function createInput(ob, root, enabled){
	var keys = Object.keys(ob);
	var table = document.createElement("table");
	root.style.width = "300px"
	root.appendChild(table);

	
	for(var i = 0; i < keys.length; i++){
		var k = keys[i];
		var o = ob[k];
		if(k == "image"){
			var img = document.createElement("IMG");
			img.setAttribute('src', o);
			img.setAttribute('width', "50%");
			img.setAttribute('height', "20%");
			img.setAttribute('alt', k);
			img.style.display = "block";
			img.style.margin = "auto";
			root.insertBefore(img, table);
		} else if (enabled && (k.indexOf("Url") != -1)){
			k = k.replace("Url","");
			var a = document.createElement("A")
			var button = document.createElement("BUTTON")
			a.setAttribute('href', baseUrl+o);
			button.setAttribute('value', k);
			button.style.display = "block";
			button.style.margin = "auto";
			button.style.width = "50%"
			button.textContent = k.toUpperCase();
			a.appendChild(button);
			root.appendChild(a)
		} else {
			addRow(k,o);
		}
	}
	
	function addRow(key, val){
		var tr = document.createElement("TR");
		var td_k = document.createElement("TD");
		td_k.innerHTML=""+key;
		var td_v = document.createElement("TD");
		var td_in = document.createElement("INPUT");
		td_in.setAttribute('value',val);
		td_v.appendChild(td_in);
		tr.appendChild(td_k);
		tr.appendChild(td_v);
		table.appendChild(tr);
	}
}



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
			img.style.display = "block";
			img.style.margin = "auto";
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
