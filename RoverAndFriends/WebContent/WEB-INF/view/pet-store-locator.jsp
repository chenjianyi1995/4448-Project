<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<p class="center"> edit page to find pet store</p>
</div>

<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <h3>You Near-by location: ${user.zipCode}</h3>
    <div id="map"></div>
    <script>
      function initMap() {
        var boulder = {lat: 40.0150, lng: -105.2705};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 14,
          center: boulder
        });
        var request = {
        	    location:boulder,
        	    radius: '500',
        	    type: ['Pet store']
        	  };
        var marker = new google.maps.Marker({
          position: boulder,
          map: map
        });
       <!-- service.nearbySearch(request, callback);
      }
      function callback(results, status) {
    	  if (status == google.maps.places.PlacesServiceStatus.OK) {
    	    for (var i = 0; i < results.length; i++) {
    	      var place = results[i];
    	      createMarker(results[i]);
    	    }
    	  }
    	}-->
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJetgAVsV0loL7VDfszfB5YqCyqwGkrVs&callback=initMap">
    </script>
  </body>
</html>

<%@ include file="common/footer.jspf"%>
