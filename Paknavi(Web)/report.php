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
			
			
			$query = "SELECT COUNT(*) as TOTALFOUND from parkinglots WHERE ownership='PUBLIC'";//EXECUTE SQL CODE;
			$result_set = mysql_query( $query ) or die(mysql_error());
			$num=mysql_result($result_set,0,"TOTALFOUND");
	
	$query2 = "SELECT COUNT(*) as TOTALFOUND from parkinglots WHERE ownership='PRIVATE'";//EXECUTE SQL CODE;
	$result_set2 = mysql_query( $query2 ) or die(mysql_error());
	$num2=mysql_result($result_set2,0,"TOTALFOUND");
	
	$values = array($num,$num2);
	
	echo json_encode($values);

mysql_close();

?>
