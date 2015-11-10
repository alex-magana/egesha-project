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

$id = $_GET['parkid'];
$name = $_GET['name'];
$latitude = $_GET['lat'];
$longitude = $_GET['lng'];
$openinghour = $_GET['ophour'];
$closinghour = $_GET['clhour'];
$rate = $_GET['charge'];
$ownership = $_GET['owner'];

	$query = "UPDATE parkinglots SET id='$id',name='$name',lat='$latitude',lng='$longitude',openinghour='$openinghour',
					closinghour='$closinghour',rate='$rate',ownership='$ownership' WHERE id=$id";

		$result_set = mysql_query( $query ) or die(mysql_error());
echo"Data of ID:.$id.has been successfully updated";			
			}

mysql_close();
?>

</body>
</html>