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

//$db_name = mysql_select_db("paknav", $con) or die(mysql_error());
			
			
			$query = "SELECT * FROM parkinglots";
						
			$result_set = mysql_query( $query ) or die(mysql_error());

			echo "<table border='1'>
<tr>
<th>ID</th>
<th>NAME</th>
<th>LATITUDE</th>
<th>LONGITUDE</th>
<th>OPENING HOUR</th>
<th>CLOSING HOUR</th>
<th>RATE</th>
<th>OWNERSHIP</th>
</tr>";

				while($row = mysql_fetch_array($result_set)){
	echo "<tr>";
	echo "<td>" . $row['id'] . "</td>";
	echo "<td>" . $row['name'] . "</td>";
	echo "<td>" . $row['lat'] . "</td>";
	echo "<td>" . $row['lng'] . "</td>";
	echo "<td>" . $row['openinghour'] . "</td>";
	echo "<td>" . $row['closinghour'] . "</td>";
	echo "<td>" . $row['rate'] . "</td>";
	echo "<td>" . $row['ownership'] . "</td>";
	echo "</tr>";
		}
			echo "</table>";
		 
mysql_close();
?>
</body>
</html>