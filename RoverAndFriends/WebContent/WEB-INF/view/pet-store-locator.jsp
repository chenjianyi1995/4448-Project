<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<p class="center"> edit page to find pet store</p>
</div>
<!--  
<! DOCTYPE html>
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
  <!--</script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJetgAVsV0loL7VDfszfB5YqCyqwGkrVs&callback=initMap">
    </script>
  </body>
</html>-->
<!DOCTYPE html>
<html>
  <head>
    <title>Place searches</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    <script>
      // This example requires the Places library. Include the libraries=places
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

      var map;
      var infowindow;

      function initMap() {
        var pyrmont = {lat: 40.0150, lng: -105.2705};

        map = new google.maps.Map(document.getElementById('map'), {
          center: pyrmont,
          zoom: 12
        });

        infowindow = new google.maps.InfoWindow();
        var service = new google.maps.places.PlacesService(map);
        service.nearbySearch({
          location: pyrmont,
          radius: 500,
          type: ['Pet store']
        }, callback);
      }

      function callback(results, status) {
        if (status === google.maps.places.PlacesServiceStatus.OK) {
          for (var i = 0; i < results.length; i++) {
            createMarker(results[i]);
          }
        }
      }

      function createMarker(place) {
        var placeLoc = place.geometry.location;
        var marker = new google.maps.Marker({
          map: map,
          position: place.geometry.location
        });

        google.maps.event.addListener(marker, 'click', function() {
          infowindow.setContent(place.name);
          infowindow.open(map, this);
        });
      }
    </script>
  </head>
  <body>
    <div id="map"></div>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJetgAVsV0loL7VDfszfB5YqCyqwGkrVs&libraries=places&callback=initMap" async defer></script>
  </body>
</html>
<%@ include file="common/footer.jspf"%>
