<?php
date_default_timezone_set("Asia/Kolkata");
session_start();
if (isset($_SESSION['start']) && (time() - $_SESSION['start'] > 3600)) {
    session_unset(); 
    session_destroy(); 
    echo "session destroyed"; 
    header("location: logout.php");
}
$_SESSION['start'] = time();
function is_connected()
{
    $connected = @fsockopen("www.google.com", 80); 
    if ($connected){
        $is_conn = true;
        fclose($connected);
    }else{
        $is_conn = false;
    }
    return $is_conn;
}
?>