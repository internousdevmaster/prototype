//AjaxZip3を使用して住所情報を自動入力する。
//且つ存在しない都道府県、市区町村を入力しないようにする。
//Version            : 1.0
//Author             : Y.Narita
function backSpaceClear(){
	AjaxZip3.zip2addr('postcode','','address','address');
	if(event.keyCode == 8){
			formClear();
    	}
}
function formClear(){
	document.entry.address.value="";
}

function addressClear(){
	var address = document.entry.address.value;
    	if( address == ""){
    		alert("住所が未入力です。");
    		return false;
    	}
}