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
		
		 if(isset($_GET['id']) && isset($_GET['parent_id'])){
			 $id= $_GET['id'];
			 $p_id= $_GET['parent_id'];
			 $status=$_GET['status'];
			
				//Demo variables
		    //echo('id---->'.$id);
			//echo('pid---->'.$p_id);
			//echo('status---->'.$status .'<br/>');	
			//http://localhost:8080/hc-sr04/updateoccupancy_mobi.php?id=1&parent_id=15&status=1	
			//http://paknav.net63.net/mobi/updateoccupancy_mobi.php?id=1&parent_id=15&status=1	
			//http://paknav.net63.net/mobi/updateoccupancy_mobi.php?id=id&parent_id=mst_id&status=spotStatus
			
			if ($id != null){
				
					$query = "UPDATE parkinglots_details_".$p_id." SET is_occupied = ".$status." WHERE id = ".$id." AND mst_id = ".$p_id;
					mysql_query( $query ) or die(mysql_error().'Q1 FAILED');
					
					/*1 means occupied and 0 means available*/
					$query_b = "SELECT COUNT( id ) AS AVSLOTS FROM parkinglots_details_".$p_id." WHERE is_occupied = 0";
					$result = mysql_query( $query_b ) or die(mysql_error().'Q2 FAILED');
					
					$AVSLOTS = 0;
					while($r = mysql_fetch_assoc($result)) {
						
						$AVSLOTS = $r['AVSLOTS'];
						
					}
					//echo $AVSLOTS;
					$query_c = "UPDATE parkinglots SET available = ".$AVSLOTS." WHERE id = ".$p_id;
					mysql_query( $query_c ) or die(mysql_error().'Q3 FAILED');
				
			}
			else{
			
				die(mysql_error().'NULL VALUE ISSUED FOR TABLE parkinglots_details_'.$id.' FIELD id');

			}				 
			
		}

mysql_close();

?>
