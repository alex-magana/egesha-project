<?php

$con = mysql_connect("mysql1.000webhost.com","a3213086_alex","asd123");
		if (!$con){
		  die('Could not connect: ' . mysql_error());
		  }
/*$con = mysql_connect("localhost","root","");
		if (!$con){
		  die('Could not connect: ' . mysql_error());
		  }*/
		  
$db_name = mysql_select_db("a3213086_paknav", $con);
//$db_name = mysql_select_db("paknav", $con);
		
		 if(isset($_GET['lat']) && isset($_GET['lng'])){
			 $lat= $_GET['lat'];
			 $lng= $_GET['lng'];
			 $type=$_GET['owner'];
			 $rad= $_GET['radius'];
			//$float_value_of_var = floatval($var);
			
				//Demo variables
			//$lat=-1.2919856798690028;
			//$lng=36.82445526123047;
			//$type="PUBLIC";
			//$rad=30;
		    //echo($lat);
			//echo($lng);
			//echo($type);
			//echo($rad);	
			//http://localhost:8080/hc-sr04/informationquery_mobi.php?lat=-1.2919856798690028&lng=36.82445526123047&owner=PRIVATE&radius=30	
			//http://paknav.net63.net/mobi/informationquery_mobi.php?lat=-1.2919856798690028&lng=36.82445526123047&owner=PRIVATE&radius=30	
			//http://paknav.net63.net/mobi/informationquery_mobi.php?lat=latitude&lng=longitude&owner=typeOption&radius=radiuOption
			
			if ($type=="ALL"){
			$query = "SELECT id,name,lat,lng,openinghour,closinghour,rate,capacity,available, ( 6371 * acos( cos( radians(".$lat.") ) * cos( radians( lat ) ) * cos( radians( lng ) 
						- radians(".$lng.") ) + sin( radians(".$lat.") ) * sin( radians( lat ) ) ) ) AS distance FROM parkinglots
								WHERE available > 0 
									HAVING distance < ".$rad." ORDER BY distance LIMIT 20";
						}
					elseif ($type=="PUBLIC"){
			$query = "SELECT id,name,lat,lng,openinghour,closinghour,rate,capacity,available, ( 6371 * acos( cos( radians(".$lat.") ) * cos( radians( lat ) ) * cos( radians( lng ) 
						- radians(".$lng.") ) + sin( radians(".$lat.") ) * sin( radians( lat ) ) ) ) AS distance FROM parkinglots
								WHERE available > 0 AND ownership='PUBLIC' 
									HAVING distance < ".$rad." ORDER BY distance LIMIT 20";
						}
						elseif($type=="PRIVATE"){
			$query = "SELECT id,name,lat,lng,openinghour,closinghour,rate,capacity,available, ( 6371 * acos( cos( radians(".$lat.") ) * cos( radians( lat ) ) * cos( radians( lng ) 
						- radians(".$lng.") ) + sin( radians(".$lat.") ) * sin( radians( lat ) ) ) ) AS distance FROM parkinglots
								WHERE available > 0 AND ownership='PRIVATE' 
									HAVING distance < ".$rad." ORDER BY distance LIMIT 20";
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
