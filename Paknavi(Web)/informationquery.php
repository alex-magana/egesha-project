<?php
 
$con = mysql_connect("mysql1.000webhost.com","a3213086_alexweb","asd123");
		if (!$con){
		  die('Could not connect: ' . mysql_error());
		  }
/*$con = mysql_connect("localhost","root","");
		if (!$con){
		  die('Could not connect: ' . mysql_error());
		  }*/
		  
$db_name = mysql_select_db("a3213086_pakweb", $con);
//$db_name = mysql_select_db("paknav", $con);
		
		if(isset($_GET['lng']) && isset($_GET['lat'])){
			$lat=$_GET['lat'];
			$lng=$_GET['lng'];
			$type=$_GET['owner'];
			$rad=$_GET['radius'];
					//Demo variables
			//$lat=-1.2919856798690028;
			//$lng=36.82445526123047;
			//$type="PUBLIC";
			//$rad=30;
			
			if ($type=="ALL"){
			$query = "SELECT id,name,lat,lng,rate,openinghour,closinghour, ( 6371 * acos( cos( radians($lat) ) * cos( radians( lat ) ) * cos( radians( lng ) 
						- radians($lng) ) + sin( radians($lat) ) * sin( radians( lat ) ) ) ) AS distance FROM parkinglots
								HAVING distance < $rad ORDER BY distance LIMIT 20";
						}
					elseif ($type=="PUBLIC"){
			$query = "SELECT id,name,lat,lng,rate,openinghour,closinghour, ( 6371 * acos( cos( radians($lat) ) * cos( radians( lat ) ) * cos( radians( lng ) 
						- radians($lng) ) + sin( radians($lat) ) * sin( radians( lat ) ) ) ) AS distance FROM parkinglots
								WHERE ownership='PUBLIC' HAVING distance < $rad ORDER BY distance LIMIT 20";
						}
						elseif($type=="PRIVATE"){
			$query = "SELECT id,name,lat,lng,rate,openinghour,closinghour, ( 6371 * acos( cos( radians($lat) ) * cos( radians( lat ) ) * cos( radians( lng ) 
						- radians($lng) ) + sin( radians($lat) ) * sin( radians( lat ) ) ) ) AS distance FROM parkinglots
								WHERE ownership='PRIVATE' HAVING distance < $rad ORDER BY distance LIMIT 20";
						}
						else{
						die(mysql_error());
						}
						
			$result_set = mysql_query( $query ) or die(mysql_error());

			$rows = array();
			while($r = mysql_fetch_assoc($result_set)) {
				$rows[] = $r;
			}
		 
			echo json_encode($rows);
			
		}

mysql_close();
?>