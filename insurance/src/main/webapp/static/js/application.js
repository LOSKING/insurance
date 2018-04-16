function turnPage(nowPage) {
	var urls = window.location.href;
	var site = urls.indexOf("?");
	if (site > 0) {
		urls = urls.substring(0, site);
	}
	urls = urls + "?nowPage=" + nowPage;

	var queryJson = document.getElementById("queryJsonStr").value;
	if (queryJson != null && queryJson != '') {
		urls = urls + "&queryJsonStr=" + urlEncode(queryJson);
//		urls = urlEncode(urls + "&queryJsonStr=" + queryJson);
	}
	window.location.href = urls;
}

function urlEncode(sStr) {
	return escape(sStr).replace(/\+/g, '%2B').replace(/\"/g, '%22').replace(
			/\'/g, '%27').replace(/\//g, '%2F');
}
