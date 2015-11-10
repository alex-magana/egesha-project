<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PAKNAV</title>
</head>
<body>

<?php
$con = mysql_connect("localhost","866700_alex","123456");
		if (!$con){
		  die('Could not connect: ' . mysql_error());
		  }
		  
/*$con = mysql_connect("localhost","root","");
		if (!$con){
		  die('Could not connect: ' . mysql_error());
		  }*/
$db_name = mysql_select_db("paknav_zxq_paknav", $con);
		
//$db_name = mysql_select_db("paknav", $con);

	if(isset($_GET['name']) && isset($_GET['lat']) && isset($_GET['lng'])){

$name = $_GET['name'];
$latitude = $_GET['lat'];
$longitude = $_GET['lng'];
$openinghour = $_GET['ophour'];
$closinghour = $_GET['clhour'];
$rate = $_GET['charge'];
$ownership = $_GET['owner'];

$query = "INSERT INTO parkinglots VALUES ('','$name','$latitude','$longitude',
				'$openinghour','$closinghour','$rate','$ownership')";
			$result_set = mysql_query( $query ) or die(mysql_error());

echo "You have successfully registered the following parking lot to the database <p/>";
echo " <li> Name : $name";
echo " <li> Latitude : $latitude";
echo " <li> Longitude : $longitude";
echo " <li> Opening Hour : $openinghour";
echo " <li> Closing Hour : $closinghour";
echo " <li> Rate : $rate";
echo " <li> Ownership : $ownership";
		
	}
	
mysql_close();
?>

<br><a href="admin.html"> Add another record </a>
</body>
</html>