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
	
if(isset($_GET['pId']) && isset($_GET['Pname'])){
	$num = $_GET['pId'];
	//echo "$num";
	$name = $_GET['Pname'];
	//echo "$name";
	
$query = "DELETE FROM parkinglots WHERE id=$num";
			
		$result_set = mysql_query( $query ) or die(mysql_error());

echo "You have successfully deleted the following parking lot from the database <p/>";
echo "Name : $name";
		
		}
		
mysql_close();
?>

<br><a href="admin.html"> Delete another record </a>

</body>
</html>
