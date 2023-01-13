<script type="text/javascript" src="plugins/jquery/jquery.js"></script>
<script type="text/javascript">
function start_countdown()
{
 var counter=1200;
 myVar= setInterval(function()
 { 
  if(counter>=0)
  {
   document.getElementById("countdown").innerHTML="<i class='fas fa-power-off'>&nbsp;"+Math.round(counter/60)+"&nbsp;Min</i>";
  }
  if(counter==0)
  {
   $.ajax
   ({
     type:'post',
     url:'index.php',
     data:{
      logout:"logout"
     },
     success:function(response) 
     {
      window.location="logout.php";
     }
   });
   }
   counter--;
 }, 1000)
}
start_countdown();
</script>
<script>
  function display_ct5() {
    var x = new Date()
    var ampm = x.getHours( ) >= 12 ? '&nbsp;PM' : '&nbsp;AM';
    hours = x.getHours( ) % 12;
    hours = hours ? hours : 12;
    var x1=hours + ":" +  x.getMinutes() + ampm;
    document.getElementById('ct5').innerHTML = x1;
    display_c5();
  }
  function display_c5(){
    var refresh=1000;
    mytime=setTimeout('display_ct5()',refresh)
  }
  display_c5()
</script>
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="dashboard.php" class="brand-link">
      <img src="images/logo.jpg" alt="Jet Airways" width="100%">
    </a>
    <div class="sidebar">
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image"><img src="profile/profile.png" class="img-circle elevation-1" alt="<?php echo $_SESSION['admin_name']; ?>"></div>
        <div class="info pt-0"><h4 class="p-0 m-0 text-white d-block"><?php echo $_SESSION['admin_name']; ?></h4>
      <em class="p-0 m-0 text-white"><sup><?php echo $_SESSION['admin_des']; ?></sup></em></div>
      </div>
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append"><button class="btn btn-sidebar"><i class="fas fa-search fa-fw"></i></button></div>
        </div>
      </div>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <?php if($_SESSION['admin_user_type']==1 OR $_SESSION['admin_user_type']==2) { ?> 
          <li class="nav-item"><a href="home.php" class="nav-link"><i class="nav-icon fas fa-home"></i><p>Home Page</p></a></li>
        <?php } if($_SESSION['admin_user_type']!=5) { ?> 
          <li class="nav-item"><a href="order.php" class="nav-link"><i class="nav-icon fas fa-dollar-sign"></i><p>Order Details</p></a></li>
        <?php } ?>
          <li class="nav-item"><a href="schedule.php" class="nav-link"><i class="nav-icon fas fa-clock"></i><p><?php if($_SESSION['admin_user_type']!=5) {echo "Inventory Schedule";}else{echo "Order Details"; }?></p></a>
            <!--
            <ul class="nav nav-treeview">
            <?php // if($_SESSION['admin_user_type']==1 OR $_SESSION['admin_user_type']==2) { ?> 
                <li class="nav-item"><a href="schedule.php?fb_inv_status=Pending" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Pending</p></a></li>
                <?php // } ?>
                <li class="nav-item"><a href="schedule.php?fb_inv_status=Scheduled" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Scheduled</p></a></li>
                <li class="nav-item"><a href="schedule.php?fb_inv_status=Validate" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Validated</p></a></li>
                <?php // if($_SESSION['admin_user_type']==1 OR $_SESSION['admin_user_type']==2 OR $_SESSION['admin_user_type']==6) { ?> 
                <li class="nav-item"><a href="schedule.php?fb_inv_status=In Process" class="nav-link"><i class="far fa-circle nav-icon"></i><p>POS In-Process</p></a></li>
                <li class="nav-item"><a href="schedule.php?fb_inv_status=Closed" class="nav-link"><i class="far fa-circle nav-icon"></i><p>POS Closed</p></a></li>
                <?php // } ?>
                <li class="nav-item"><a href="schedule.php?fb_inv_status=Completed" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Completed</p></a></li>
                <li class="nav-item"><a href="schedule.php" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Show All</p></a></li>
            </ul> -->
          </li>
          <?php if($_SESSION['admin_user_type']==1) { ?> 
          <li class="nav-item"><a href="flight.php" class="nav-link"><i class="nav-icon fas fa-plane"></i><p>Flight List</p></a></li>
          <li class="nav-item"><a href="sendinv.php" class="nav-link"><i class="nav-icon fas fa-clipboard-list"></i><p>Flight Schedule</p></a></li>
          <li class="nav-item"><a href="product.php" class="nav-link"><i class="nav-icon fas fa-sitemap"></i><p>Products List</p></a></li>
          <li class="nav-item"><a href="vendors.php" class="nav-link"><i class="nav-icon fas fa-user"></i><p>Vendor</p></a></li>
          <li class="nav-item"><a href="warehouse.php" class="nav-link"><i class="nav-icon fas fa-warehouse"></i><p>Warehouse</p></a></li>
          <li class="nav-item"><a href="airport.php" class="nav-link"><i class="nav-icon fas fa-road"></i><p>Airport</p></a></li>
          <li class="nav-item"><a href="gst.php" class="nav-link"><i class="nav-icon fas fa-table"></i><p>Register GST</p></a></li>
          <li class="nav-item"><a href="users.php" class="nav-link"><i class="nav-icon fas fa-users"></i><p>Register Users</p></a></li>
          <?php } ?>
          <li class="nav-item"><a href="report.php" class="nav-link"><i class="nav-icon fas fa-download"></i><p>Report Export</p></a></li>
        </ul>
      </nav>
      <h5 class="nav-item text-center bg-dark p-0 m-0" style="border-top: 3px solid red;position: absolute;bottom: 0;"><a href="#" class="nav-link">&nbsp;<i class="nav-icon fas fa-user"></i> <span>My Profile</span></a></h5>
    </div>
  </aside>
  <div class="content-wrapper iframe-mode" data-widget="iframe" data-loading-screen="750">
    <div class="nav navbar navbar-expand navbar-white navbar-light border-bottom p-0">
      <a class="nav-link bg-light" data-widget="pushmenu" aria-haspopup="true" aria-expanded="false" href="#" role="button"><i class="fas fa-bars"></i></a>  
      <div class="nav-item dropdown">
      <a class="nav-link bg-danger dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Close</a>
        <div class="dropdown-menu mt-0">
          <a class="dropdown-item" href="#" data-widget="iframe-close" data-type="all">Close All</a>
          <a class="dropdown-item" href="#" data-widget="iframe-close" data-type="all-other">Close All Other</a>
        </div>
      </div>
      <a class="nav-link bg-light" href="#" data-widget="iframe-scrollleft"><i class="fas fa-angle-double-left"></i></a>
      <ul class="navbar-nav overflow-hidden" role="tablist"></ul>
      <a class="nav-link bg-light" href="#" data-widget="iframe-scrollright"><i class="fas fa-angle-double-right"></i></a>
      <a class="nav-link bg-light" href="#" data-widget="iframe-fullscreen"><i class="fas fa-expand"></i></a>
      <?php if(is_connected()==1){echo "<a class='nav-link bg-success' title='Internet Connected'><i class='fas fa fa-wifi' ></i></a>";}else{echo "<a class='nav-link bg-danger' title='Not Connected'><i class='fas fa-sync fa-spin'></i></a>";} ?>
      <a class="nav-link bg-red" href="logout.php"><span id="countdown"></span></a>
    </div>
    <div class="tab-content">
      <div class="tab-empty" style="display: block;">
      </div>
      <div class="tab-loading">
        <div>
          <h2 class="display-4">Tab is loading <i class="fa fa-sync fa-spin"></i></h2>
        </div>
      </div>
    </div>
  </div>